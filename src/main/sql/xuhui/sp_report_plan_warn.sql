BEGIN
truncate table pl_report_plan_warn;
truncate table pl_report_plan_warn_node;

insert into pl_report_plan_warn_node(id,version_id,sort_no,
node_id, node_code, node_name, standard_finish_date, planned_finish_date, actual_finish_date,
 created_date, created_by, updated_date, updated_by)
SELECT UUID_SHORT(),v.id,m.sort_no,
n.id,n.node_code,n.node_name, n.standard_finish_date,n.planned_finish_date, n.actual_finish_date,
NOW(),'iwen',NOW(),'iwen'
from  pl_plan p
join pl_plan_version v on v.plan_id=p.id
LEft join pl_template t on p.template_id=t.id
join pl_plan_node n on n.version_id=v.id
join pl_report_plan_warn_node_enum m on n.node_code=m.node_code
where  v.`status` in (2,6) and p.type='1';

insert into pl_report_plan_warn(id,version_id,area_id,area_name,company_id,project_id,fenqi_id,batch_id,plan_name,business_type,
version_type,current_version,floor_num,take_time,created_date, created_by, updated_date, updated_by)
SELECT UUID_SHORT(),v.id,p.area,p.area_name,p.company_id,p.project_id,p.fenqi_id,p.batch_id,p.plan_name,t.business_type,
v.version_type,v.plan_version,pp.floor_num,pp.take_time,NOW(),'iwen',NOW(),'iwen'
from  pl_plan p
join pl_plan_version v on v.plan_id=p.id
LEft join pl_template t on p.template_id=t.id
join pl_plan_parameter pp on pp.id=v.plan_parameter_id
where  v.`status` in (2,6) and p.type='1';

UPDATE pl_report_plan_warn w,sys_dictionary_data d
set w.business_type=d.dict_label_cn
where d.dict_type='planning_business_type' and w.business_type=d.dict_value;

UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date1=n.standard_finish_date,w.pa_date1=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=1;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date2=n.standard_finish_date,w.pa_date2=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=2;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date3=n.standard_finish_date,w.pa_date3=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=3;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date4=n.standard_finish_date,w.pa_date4=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=4;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date5=n.standard_finish_date,w.pa_date5=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=5;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date6=n.standard_finish_date,w.pa_date6=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=6;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date7=n.standard_finish_date,w.pa_date7=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=7;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date8=n.standard_finish_date,w.pa_date8=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=8;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date9=n.standard_finish_date,w.pa_date8=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=9;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date10=n.standard_finish_date,w.pa_date10=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=10;
UPDATE pl_report_plan_warn w,pl_report_plan_warn_node n
set w.st_date11=n.standard_finish_date,w.pa_date11=IFNULL(n.actual_finish_date,n.planned_finish_date)
where w.version_id=n.version_id and n.sort_no=11;

UPDATE pl_report_plan_warn r,pl_plan_info i
set r.company_name=i.company_name,
r.project_code=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where r.fenqi_id=i.fenqi_id and i.is_deleted=0;

UPDATE pl_report_plan_warn r,(SELECT batch_id from pl_report_plan_warn   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where  r.batch_id=c.batch_id and b.batch_code=c.batch_id;
END