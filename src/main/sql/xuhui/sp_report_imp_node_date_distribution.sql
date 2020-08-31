BEGIN

truncate table pl_report_imp_node_date_distribution;
insert into pl_report_imp_node_date_distribution
(id,type,area_id,area_name,company_id,project_id,fenqi_id,batch_id,version_type,
dimension,node_code,node_name,finish_date)
select uuid(),a.type,a.area,a.area_name,a.company_id,project_id,a.fenqi_id,a.batch_id,b.version_type
,case when node_code = 'JT-LCB-00048' then 1
when node_code = 'JT-LCB-00003' or node_code = 'JT-LCB-00004' then 2
else 3 end as dimension
,d.node_code,d.node_name,ifnull(d.actual_finish_date,d.planned_finish_date) as finish_date
from pl_plan_version b
inner join pl_plan a on a.id = b.plan_id
inner join pl_plan_node d
on d.version_id = b.id  and d.planned_finish_date is not null and d.is_deleted='0'
where  b.status in(2,6) and b.is_freeze='0' and b.is_deleted='0'
and (d.level_id='1' or d.level_id='2');

UPDATE pl_report_imp_node_date_distribution r,pl_plan_info i
set r.company_name=i.company_name,
r.project_id=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where  r.fenqi_id=i.fenqi_id;

UPDATE pl_report_imp_node_date_distribution r,(SELECT batch_id from pl_report_imp_node_date_distribution   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where r.batch_id=c.batch_id and b.batch_code=c.batch_id;

UPDATE pl_report_imp_node_date_distribution p,sys_dictionary_data d
set p.version_name=d.dict_label_cn
where d.dict_type = 'planning_versionType_two' and d.dict_value = p.version_type;
END