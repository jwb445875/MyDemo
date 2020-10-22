BEGIN
	truncate table pl_report_pl_phase_eff;

insert into pl_report_pl_phase_eff
(id,type,plan_type_id,biz_type,business_type,area_id,area_name,company_id,project_id,fenqi_id,batch_id,node_code,node_name,planned_finish_date,actual_finish_date,node_biz_type)
select uuid(),a.type,a.plan_type_id,a.biz_type,a.business_type,a.area, a.area_name,a.company_id,a.project_id,a.fenqi_id,a.batch_id,d.node_code,d.node_name,d.planned_finish_date ,d.actual_finish_date ,d.biz_type
from pl_plan_version b
join pl_plan a on a.id = b.plan_id
left join pl_plan_node d
on d.version_id = b.id and d.status in(2,6) and d.is_deleted='0'
where  b.status in(2,6) and b.is_freeze='0' and b.is_deleted='0';

UPDATE pl_report_pl_phase_eff r,pl_plan_info i
set r.company_name=i.company_name,
r.project_id=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where  r.fenqi_id=i.fenqi_id;

UPDATE pl_report_pl_phase_eff r,(SELECT batch_id from pl_report_pl_phase_eff   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where r.batch_id=c.batch_id and b.batch_code=c.batch_id and r.plan_type_id='1';
END