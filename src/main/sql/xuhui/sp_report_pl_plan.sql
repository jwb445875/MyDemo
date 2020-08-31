BEGIN
truncate table pl_plan_node_ext;
truncate table pl_plan_node_ext2;
truncate table pl_report_pl_plan;

insert into pl_plan_node_ext
select v.id,v.plan_id,v.oa_date,n.planned_finish_date ,v.status,v.version_type,v.plan_version
from  pl_plan_version v
left join pl_plan_node n
on n.version_id = v.id and n.node_code = 'JT-LCB-00001'  and n.is_deleted='0'
where  v.status in(2,6,7) and v.is_freeze='0' and v.is_deleted='0';

insert into pl_plan_node_ext2
select n.id,n.version_id,n.node_code,n.node_name,n.phase_id,n.level_id,n.planned_finish_date,n.actual_finish_date
from  pl_plan_node n,pl_plan_node_ext t
where  n.version_id = t.version_id  and n.is_deleted='0' ;



insert into pl_report_pl_plan
(id,version_id,plan_id,oa_date,version_name,finish_date_name,get_land_date,version_type,plan_version,
phase_id,level_id,node_code,node_name,planned_finish_date,actual_finish_date,type)
SELECT uuid(),t.version_id,t.plan_id,t.oa_date,'' as version_name
,'实际完成时间' as finished_date_name,t.get_land_date,t.version_type,t.plan_version,
d.phase_id,d.level_id,d.node_code,d.node_name,d.planned_finish_date ,
d.actual_finish_date ,1
from pl_plan_node_ext t
join pl_plan_node_ext2 d on t.version_id=d.version_id where t.status in(2,6);

insert into pl_report_pl_plan
(id,version_id,plan_id,oa_date,version_name,finish_date_name,get_land_date,version_type,plan_version,
phase_id,level_id,node_code,node_name,planned_finish_date,actual_finish_date,type)
SELECT uuid(),t.version_id,t.plan_id,t.oa_date,'' as version_name
,'计划完成时间' as finished_date_name,t.get_land_date,t.version_type,t.plan_version,
d.phase_id,d.level_id,d.node_code,d.node_name,d.planned_finish_date ,
d.actual_finish_date ,2
from pl_plan_node_ext t
join pl_plan_node_ext2 d on t.version_id=d.version_id;

UPDATE pl_report_pl_plan r,pl_plan p
set r.area_name=p.area_name,r.project_id=p.project_id,r.fenqi_id=p.fenqi_id,r.batch_id=p.batch_id,
r.plan_version_type=p.version_type,r.current_version=p.current_version,r.plan_type=p.type
where r.plan_id=p.id;

UPDATE pl_report_pl_plan r,pl_plan_info i
set
r.project_id=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where  r.fenqi_id=i.fenqi_id;

UPDATE pl_report_pl_plan r,(SELECT batch_id from pl_report_pl_plan   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where r.batch_id=c.batch_id and b.batch_code=c.batch_id;

UPDATE pl_report_pl_plan p,sys_dictionary_data d
set p.version_name=concat(d.dict_label_cn,p.plan_version)
where d.dict_type = 'planning_versionType_two' and d.dict_value = p.version_type and p.type=2;


end