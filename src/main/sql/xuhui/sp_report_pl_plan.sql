BEGIN
truncate table pl_plan_node_ext;
truncate table pl_plan_node_ext2;
truncate table pl_report_pl_plan;

insert into pl_plan_node_ext
select v.id,v.plan_id,v.oa_date,n.planned_finish_date ,v.status,v.version_type,v.plan_version,t.operate_type,v.is_score
from  pl_plan_version v
join pl_plan p on v.plan_id=p.id
left join pl_template t on p.template_id=t.id
left join pl_plan_node n
on n.version_id = v.id and n.node_code = 'JT-LCB-00001'  and n.is_deleted='0'
where  v.status in(2,6,7) and v.is_freeze='0' and v.is_deleted='0';

insert into pl_plan_node_ext2
select n.id,n.version_id,n.node_code,n.node_name,n.phase_id,n.level_id,n.planned_finish_date,n.actual_finish_date
,n.`status`,n.check_finish_date,n.full_finish_date,n.must_score,n.actual_score,n.adjust_coef,n.adjust_count,n.is_exempt,
n.is_pre,n.is_quote,n.exempt_coef,n.is_zero,n.biz_type
from  pl_plan_node n,pl_plan_node_ext t
where  n.version_id = t.version_id  and n.is_deleted='0' ;



insert into pl_report_pl_plan
(id,version_id,plan_id,oa_date,version_name,finish_date_name,get_land_date,version_type,plan_version,
phase_id,level_id,node_code,node_name,planned_finish_date,actual_finish_date,type,`status`,check_finish_date,full_finish_date
,must_score,actual_score,adjust_coef,adjust_count,is_exempt,is_pre,is_quote,exempt_coef,is_zero,operate_type,is_score,node_biz_type)
SELECT uuid(),t.version_id,t.plan_id,t.oa_date,'' as version_name
,'实际完成时间' as finished_date_name,t.get_land_date,t.version_type,t.plan_version,
d.phase_id,d.level_id,d.node_code,d.node_name,d.planned_finish_date ,
d.actual_finish_date ,1,d.`status`,d.check_finish_date,d.full_finish_date
,d.must_score,d.actual_score,d.adjust_coef,d.adjust_count,d.is_exempt,d.is_pre,d.is_quote,d.exempt_coef,d.is_zero,t.operate_type,t.is_score,d.node_biz_type
from pl_plan_node_ext t
join pl_plan_node_ext2 d on t.version_id=d.version_id where t.status in(2,6);

insert into pl_report_pl_plan
(id,version_id,plan_id,oa_date,version_name,finish_date_name,get_land_date,version_type,plan_version,
phase_id,level_id,node_code,node_name,planned_finish_date,actual_finish_date,type,`status`,check_finish_date,full_finish_date
,must_score,actual_score,adjust_coef,adjust_count,is_exempt,is_pre,is_quote,exempt_coef,is_zero,operate_type,is_score,node_biz_type)
SELECT uuid(),t.version_id,t.plan_id,t.oa_date,'' as version_name
,'计划完成时间' as finished_date_name,t.get_land_date,t.version_type,t.plan_version,
d.phase_id,d.level_id,d.node_code,d.node_name,d.planned_finish_date ,
d.actual_finish_date ,2,d.`status`,d.check_finish_date,d.full_finish_date
,d.must_score,d.actual_score,d.adjust_coef,d.adjust_count,d.is_exempt,d.is_pre,d.is_quote,d.exempt_coef,d.is_zero,t.operate_type,t.is_score,d.node_biz_type
from pl_plan_node_ext t
join pl_plan_node_ext2 d on t.version_id=d.version_id;

UPDATE pl_report_pl_plan r,pl_plan p
set r.area_id=p.area,r.area_name=p.area_name,r.project_id=p.project_id,r.fenqi_id=p.fenqi_id,r.batch_id=p.batch_id,
r.plan_version_type=p.version_type,r.current_version=p.current_version,r.plan_type=p.type,r.biz_type=p.biz_type,r.plan_type_id=p.plan_type_id,r.business_type=p.business_type
where r.plan_id=p.id;

UPDATE pl_report_pl_plan r,pl_plan_info i
set
r.project_id=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name,r.company_id=i.company_id,r.company_name=i.company_name
where  r.fenqi_id=i.fenqi_id;

UPDATE pl_report_pl_plan r,(SELECT batch_id from pl_report_pl_plan   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where r.batch_id=c.batch_id and b.batch_code=c.batch_id;

UPDATE pl_report_pl_plan p,sys_dictionary_data d
set p.version_name=concat(d.dict_label_cn,'V',p.plan_version)
where d.dict_type = 'planning_versionType_all' and p.plan_type='1' and p.biz_type!='2' and d.dict_value = p.version_type ;

UPDATE pl_report_pl_plan p
set p.version_name=concat('V',p.plan_version)
where p.plan_type='2' or p.biz_type='2';

UPDATE pl_report_pl_plan set `status`=1 where  `status`!=6 and DATEDIFF(now(),planned_finish_date)<=0;
UPDATE pl_report_pl_plan set `status`=2 where  `status`!=6 and DATEDIFF(now(),planned_finish_date)>0;
UPDATE pl_report_pl_plan set `status`=4 where  `status`=6 and DATEDIFF(actual_finish_date,planned_finish_date)>0;
UPDATE pl_report_pl_plan set `status`=3 where  `status`=6;

UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='1' and s.id='dc'  and p.level_id='1'   ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='1' and s.id='dc'  and p.level_id='1'   and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.one_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='1' and s.id='dc'  and p.level_id='2'  ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.two_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='1' and s.id='dc'  and p.level_id='3'  ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.three_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='1' and s.id='dc'  and p.level_id not in ('1','2','3')  ;
UPDATE pl_report_pl_plan  set actual_score=must_score*100 where type=1 and plan_type='1' and plan_type_id='1' and is_zero=0 and `status`=3 and is_score=0;
UPDATE pl_report_pl_plan  set actual_score=must_score*100*exempt_coef where type=1 and plan_type='1' and plan_type_id='1' and is_score=1 and is_zero=0 and `status`=3 and DATEDIFF(check_finish_date,actual_finish_date)>=0;
UPDATE pl_report_pl_plan  set actual_score=must_score*100*adjust_coef where type=1 and plan_type='1' and plan_type_id='1' and is_score=1 and is_zero=0 and `status`=3 and DATEDIFF(check_finish_date,actual_finish_date)<0;

UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='1'   ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='1'   and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.one_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='2'  ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.two_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='3'  ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.three_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id not in ('1','2','3')  ;


UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='1'   ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='1'   and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.one_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='2'  ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.two_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='3'  ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.three_score
where p.type=1 and p.plan_type='1' and p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id not in ('1','2','3')  ;

UPDATE pl_report_pl_plan set actual_score=must_score where type=1 and plan_type='1' and plan_type_id='2' and `status`=3;
UPDATE pl_report_pl_plan set actual_score=null where type=1 and plan_type='1' and plan_type_id='2' and `status`=1;

UPDATE pl_report_pl_plan set must_score=null,actual_score=0 where type=1 and plan_type='2';
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where p.type=1 and p.plan_type='2'  and p.level_id='1' and p.area_id=s.org_id and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' ;
UPDATE pl_report_pl_plan p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where p.type=1 and p.plan_type='2'  and p.level_id='1' and p.area_id=s.org_id and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.one_score
where p.type=1 and p.plan_type='2'  and p.level_id='2' and p.area_id=s.org_id and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2';
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.two_score
where p.type=1 and p.plan_type='2'  and p.level_id='3' and p.area_id=s.org_id and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2';
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.three_score
where p.type=1 and p.plan_type='2'  and p.level_id='4' and p.area_id=s.org_id and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2';
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.four_score
where p.type=1 and p.plan_type='2'  and p.level_id not in ('1','2','3','4') and p.area_id=s.org_id and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2';

UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where p.type=1 and p.plan_type='2'  and p.level_id='1' and s.org_id='00000001' and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' and p.must_score is null;
UPDATE pl_report_pl_plan p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where p.type=1 and p.plan_type='2'  and p.level_id='1' and s.org_id='00000001' and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' and p.must_score is null and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.one_score
where p.type=1 and p.plan_type='2'  and p.level_id='2' and s.org_id='00000001' and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' and p.must_score is null;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.two_score
where p.type=1 and p.plan_type='2'  and p.level_id='3' and s.org_id='00000001' and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' and p.must_score is null;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.three_score
where p.type=1 and p.plan_type='2'  and p.level_id='4' and s.org_id='00000001' and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' and p.must_score is null;
UPDATE pl_report_pl_plan p,pl_plan_node_score s set p.must_score=s.four_score
where p.type=1 and p.plan_type='2'  and p.level_id not in ('1','2','3','4') and s.org_id='00000001' and p.plan_type_id=s.plan_type_id and p.biz_type=s.biz_type and s.node_plan_type='2' and p.must_score is null;
UPDATE pl_report_pl_plan set actual_score=must_score where type=1 and plan_type='2' and `status`=3;
UPDATE pl_report_pl_plan set actual_score=null where type=1 and plan_type='2' and `status`=1;


truncate table pl_report_node_score;
INSERT into pl_report_node_score(id, area_id, area_name, company_id, company_name, project_id, project_name, fenqi_id,
fenqi_name, plan_id, version_id, node_code, node_name, level_id, planned_finish_date,
actual_finish_date, should_score, actual_score, charger_role,
charger_role_type, version, created_date, created_by, updated_date, updated_by, is_deleted)
SELECT id, area_id, area_name, company_id, company_name, project_id, project_name, fenqi_id,
fenqi_name, plan_id, version_id, node_code, node_name, level_id, planned_finish_date,
actual_finish_date, must_score, actual_score, NULL,
NULL, `status`, NOW(), NULL, NOW(), NULL,'0'
from pl_report_pl_plan where type=1 and plan_type_id='2' and plan_type='1' and biz_type='2' AND node_biz_type='2';
UPDATE pl_report_node_score s,pl_plan_node n set s.charger_role=n.charger_role where s.version_id=n.version_id and s.node_code=n.node_code;
UPDATE pl_report_node_score s,(
SELECT idm_code,CASE WHEN  hie_classfi_code='3' THEN 2 ELSE 1 END as a from pl_job_user GROUP BY idm_code,hie_classfi_code)a
set s.charger_role_type=a.a where s.charger_role=a.idm_code;
UPDATE pl_report_node_score set charger_role_type=1 where charger_role_type is null;
end