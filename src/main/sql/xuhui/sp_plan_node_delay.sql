BEGIN
INSERT pl_plan_node_delay(id,plan_id,type,area,area_name,company_id,project_id,fenqi_id,plan_name,batch_id,version_id,current_version,version_type,manager_name,manager,
node_id,unique_code,is_quote,node_name,level_id,phase_id,charger_id,charger_role,full_finish_date,custom_bussiness_type,org_id,org_name,
planned_finish_date,is_pre,to_days,`status`,is_deleted,plan_type_id,biz_type,business_type)
SELECT  uuid(),p.id,p.type, p.area,p.area_name,p.company_id,p.project_id,p.fenqi_id,p.plan_name,p.batch_id,v.id,p.current_version,p.version_type,p.manager_name,p.manager_id,
n.id,n.unique_code,n.is_quote,n.node_name,n.level_id,n.phase_id,n.charger_id,n.charger_role,n.full_finish_date,p.custom_bussiness_type,p.org_id,p.org_name,
n.planned_finish_date,n.is_pre,to_days(n.planned_finish_date)-to_days(now()),n.`status`,1,p.plan_type_id,p.biz_type,p.business_type
FROM pl_plan_version v
join pl_plan p on v.plan_id=p.id
join pl_plan_node n on n.version_id=v.id
WHERE v.`status` in (2,6) and v.is_deleted='0'  and v.is_freeze='0'
and	n.is_quote = 0 AND  n.actual_finish_date IS NULL  AND n.is_deleted = '0'
and to_days(n.planned_finish_date)-to_days(now()) <90;

INSERT pl_plan_node_delay(id,plan_id,type,area,area_name,company_id,project_id,fenqi_id,plan_name,batch_id,version_id,current_version,version_type,manager_name,manager,
node_id,unique_code,is_quote,node_name,level_id,phase_id,charger_id,charger_role,full_finish_date,custom_bussiness_type,org_id,org_name,
planned_finish_date,actual_finish_date,is_pre,to_days,`status`,is_deleted,plan_type_id,biz_type,business_type)
SELECT  uuid(),p.id,p.type, p.area,p.area_name,p.company_id,p.project_id,p.fenqi_id,p.plan_name,p.batch_id,v.id,p.current_version,p.version_type,p.manager_name,p.manager_id,
n.id,n.unique_code,n.is_quote,n.node_name,n.level_id,n.phase_id,n.charger_id,n.charger_role,n.full_finish_date,p.custom_bussiness_type,p.org_id,p.org_name,
n.planned_finish_date,n.actual_finish_date,n.is_pre,to_days(n.planned_finish_date)-to_days(n.actual_finish_date),n.`status`,1,p.plan_type_id,p.biz_type,p.business_type
FROM pl_plan_version v
join pl_plan p on v.plan_id=p.id
join pl_plan_node n on n.version_id=v.id
WHERE v.`status` in (2,6) and v.is_deleted='0'  and v.is_freeze='0'
and	n.is_quote = 0 AND  n.`status`=6  AND n.is_deleted = '0'
and to_days(n.planned_finish_date)-to_days(n.actual_finish_date) <0;

UPDATE pl_plan_node_delay r,pl_plan_info i
set r.company_name=i.company_name,
r.project_no=i.project_no,r.project_name=i.project_name,
r.fenqi_no=i.fenqi_no,r.fenqi_name=i.fenqi_name,
r.manager=i.manager,r.pm=i.pm
where r.fenqi_id=i.fenqi_id and r.is_deleted=1 and i.is_deleted=0 AND r.custom_bussiness_type='1';

UPDATE pl_plan_node_delay r,(SELECT batch_id from pl_plan_node_delay   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where r.is_deleted=1 and r.batch_id=c.batch_id and b.batch_code=c.batch_id;

UPDATE (
SELECT  u.username,u.nick_name from sys_user u
join (SELECT charger_id from pl_plan_node_delay GROUP BY charger_id)a on u.username=a.charger_id)b, pl_plan_node_delay r
set r.charger_name=b.nick_name
where r.charger_id=b.username and r.is_deleted=1;

UPDATE (
SELECT  u.idm_code,u.job_definitions_name from sys_position_group u
join (SELECT charger_role from pl_plan_node_delay GROUP BY charger_role)a on u.idm_code=a.charger_role)b, pl_plan_node_delay r
set r.charger_role_label=b.job_definitions_name
where r.charger_role=b.idm_code and r.is_deleted=1;

DELETE from pl_plan_node_delay where is_deleted=0;
UPDATE pl_plan_node_delay set is_deleted=0;
END