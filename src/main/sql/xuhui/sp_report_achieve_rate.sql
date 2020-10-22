BEGIN

truncate table pl_report_achieve_rate;
insert into pl_report_achieve_rate
(id,type,plan_type_id,biz_type,area,area_name,company_id,project_id,fenqi_id,version_type,current_version,
version_id,is_score,is_zero,sort_no,phase_id,level_id,node_code,node_name,
check_finish_date,planned_finish_date,actual_finish_date,adjust_coef,exempt_coef,
standard_finish_date,charger_id,charger_role,mgt_auth_id,`year_month`,`status`,plan_id,node_biz_type)

select d.id,a.type,a.plan_type_id,a.biz_type,a.area_id,a.area_name,a.company_id,a.project_id,a.fenqi_id,b.version_type,b.plan_version
,a.version_id,b.is_score,d.is_zero,d.sort_no_do,d.phase_id,d.level_id,d.node_code,d.node_name
,d.check_finish_date,d.planned_finish_date ,d.actual_finish_date ,d.adjust_coef,d.exempt_coef,
d.standard_finish_date,d.charger_id,d.charger_role,d.mgt_auth_id
,if(d.actual_finish_date is not null and d.planned_finish_date > d.actual_finish_date,date_format(actual_finish_date,'%Y-%m'),date_format(planned_finish_date,'%Y-%m')) as `year_month`
,case when actual_finish_date is null and planned_finish_date >= now() then '1'
		when actual_finish_date is null and planned_finish_date < now() then '2'
		when planned_finish_date >= actual_finish_date then '3'
		when planned_finish_date < actual_finish_date then '4'
		else '0'
		end as `status`,a.plan_id,d.biz_type
from pl_plan_rate a,pl_plan_node d,pl_plan_version b
where a.version_id=d.version_id and b.id=a.version_id and (a.operate_type='1' and a.plan_type_id='1' or a.plan_type_id='2' and a.biz_type=d.biz_type)
and d.is_deleted='0' and d.is_quote=0 and d.is_pre!=1 and a.type='1'
and if(actual_finish_date is not null,actual_finish_date<DATE_FORMAT(CURDATE(), '%Y-%m-%d'),planned_finish_date<DATE_FORMAT(CURDATE(), '%Y-%m-%d'));

UPDATE pl_report_achieve_rate r,pl_plan_info i
set r.company_name=i.company_name,
r.project_id=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where  r.fenqi_id=i.fenqi_id;


UPDATE pl_report_achieve_rate r,(SELECT plan_id from pl_report_achieve_rate   GROUP BY plan_id) c,pl_plan p,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=p.b.batch_name
where c.plan_id=p.id and r.plan_id=p.id and b.batch_code=p.batch_id and r.plan_type_id='1';

UPDATE pl_report_achieve_rate r,(SELECT plan_id from pl_report_achieve_rate   GROUP BY plan_id) c,pl_plan p
set r.business_type=p.business_type
where c.plan_id=p.id and r.plan_id=p.id;

UPDATE (
SELECT  u.username,u.nick_name from sys_user u
join (SELECT charger_id from pl_report_achieve_rate GROUP BY charger_id)a on u.username=a.charger_id)b, pl_report_achieve_rate r
set r.charger_name=b.nick_name
where r.charger_id=b.username ;

UPDATE (
SELECT  u.idm_code,u.job_definitions_name from sys_position_group u
join (SELECT charger_role from pl_report_achieve_rate GROUP BY charger_role)a on u.idm_code=a.charger_role)b, pl_report_achieve_rate r
set r.charger_role_label=b.job_definitions_name
where r.charger_role=b.idm_code;

UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where  p.plan_type_id='1' and s.id='dc'  and p.level_id='1'   ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where  p.plan_type_id='1' and s.id='dc'  and p.level_id='1'   and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.one_score
where  p.plan_type_id='1' and s.id='dc'  and p.level_id='2'  ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.two_score
where  p.plan_type_id='1' and s.id='dc'  and p.level_id='3'  ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.three_score
where  p.plan_type_id='1' and s.id='dc'  and p.level_id not in ('1','2','3')  ;
UPDATE pl_report_achieve_rate  set must_score=must_score*100 where  plan_type_id='1' ;
UPDATE pl_report_achieve_rate  set actual_score=must_score where  plan_type_id='1' and is_zero=0 and `status`=3 and is_score=0;
UPDATE pl_report_achieve_rate  set actual_score=must_score*exempt_coef where  plan_type_id='1' and is_score=1 and is_zero=0 and `status`=3 and DATEDIFF(check_finish_date,actual_finish_date)>=0;
UPDATE pl_report_achieve_rate  set actual_score=must_score*adjust_coef where  plan_type_id='1' and is_score=1 and is_zero=0 and `status`=3 and DATEDIFF(check_finish_date,actual_finish_date)<0;
UPDATE pl_report_achieve_rate  set actual_score=0 where  plan_type_id='1' and (`status` in (2,4) or is_zero=1);

UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where  p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='1'   ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where  p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='1'   and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.one_score
where  p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='2'  ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.two_score
where  p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id='3'  ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.three_score
where  p.plan_type_id='2' and p.biz_type='1' and s.id='sk'  and p.level_id not in ('1','2','3')  ;


UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.milestone_normal_score
where  p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='1'   ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s,pl_plan_milestone_node n set p.must_score=s.milestone_special_score
where  p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='1'   and n.plan_node_score_id=s.id and n.node_code=p.node_code;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.one_score
where  p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='2'  ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.two_score
where  p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id='3'  ;
UPDATE pl_report_achieve_rate p,pl_plan_node_score s set p.must_score=s.three_score
where  p.plan_type_id='2' and p.biz_type='2' and s.id='sg'  and p.level_id not in ('1','2','3')  ;
UPDATE pl_report_achieve_rate  set must_score=must_score*100 where  plan_type_id='2' ;
UPDATE pl_report_achieve_rate set actual_score=must_score where  plan_type_id='2' and `status`=3;
UPDATE pl_report_achieve_rate  set actual_score=0 where  plan_type_id='2' and `status` in (2,4);
UPDATE pl_report_achieve_rate set actual_score=null where  plan_type_id='2' and `status`=1;
END