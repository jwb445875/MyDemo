BEGIN
UPDATE sys_project p,sys_organization o
set p.areaname=o.org_name
where p.areaid=o.id and p.hr_org_type_id='31';

UPDATE sys_project p,sys_organization o
set p.cityname=o.org_name
where p.parent_orgid=o.id and p.hr_org_type_id='31';

UPDATE pl_plan p,sys_project pp
set p.area=pp.areaid ,p.area_name=pp.areaname, p.company_id=pp.parent_orgid
where p.project_id=pp.id;

UPDATE pl_build_plan p,sys_project pp
set p.area_id=pp.areaid ,p.area_name=pp.areaname, p.company_id=pp.parent_orgid
where p.project_id=pp.id;

INSERT pl_plan_info(id,area,area_name,company_id,project_id,fenqi_id,is_deleted)
SELECT   uuid(),b.*,1 from (
SELECT DISTINCT a.* from (
SELECT
area,area_name,company_id,project_id,fenqi_id FROM pl_plan
union
SELECT area_id as area,area_name,company_id,project_id,id as fenqi_id from pl_build_plan) a)b;

UPDATE pl_plan_info r,(SELECT company_id from pl_plan_info where area!=company_id  GROUP BY company_id) c,sys_organization o
set r.company_name=o.org_name
where c.company_id=o.id and r.company_id=o.id and r.is_deleted=1;

UPDATE pl_plan_info r,(SELECT project_id from pl_plan_info   GROUP BY project_id) c,sys_project p
set r.project_no=p.pbnum,r.project_name=p.orgshortname
where c.project_id=p.id and r.project_id=p.id and r.is_deleted=1;

UPDATE pl_plan_info r,(SELECT fenqi_id from pl_plan_info   GROUP BY fenqi_id) c,sys_project p
set r.fenqi_no=p.opnum,r.fenqi_name=p.orgshortname
where c.fenqi_id=p.id and r.fenqi_id=p.id and r.is_deleted=1;


UPDATE (
SELECT DISTINCT pro.id,u.username
from sys_project pro
JOIN sys_position p on pro.orgdepid=p.belong_dep_id
JOIN sys_user_position up on p.`code`=up.position_code
JOIN sys_user u on u.username=up.username
join pl_plan_info d on d.fenqi_id=pro.id
where p.belong_job_def_id='134662' and  u.`status`='1')a,pl_plan_info r
set r.manager=a.username
where r.fenqi_id=a.id and r.is_deleted=1;

UPDATE (
SELECT DISTINCT pro.id,u.username
from sys_project pro
JOIN sys_position p on pro.orgdepid=p.belong_dep_id
JOIN sys_user_position up on p.`code`=up.position_code
JOIN sys_user u on u.username=up.username
join pl_plan_info d on d.fenqi_id=pro.id
where p.belong_job_def_id='476944' and  u.`status`='1')a,pl_plan_info r
set r.pm=a.username
where r.fenqi_id=a.id and r.is_deleted=1;

DELETE from pl_plan_info where is_deleted=0;
UPDATE pl_plan_info set is_deleted=0;

END