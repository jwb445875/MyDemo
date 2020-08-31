BEGIN

truncate table pl_plan_build_report;

INSERT into pl_plan_build_report(id,fenqi_id,project_id,company_id,area_name,version_type,current_version,batch_name,sort_no,version_id,batch_num,format_building_name,
product_type_name,sale_type,unique_code,decorate_name,floors,PRO_TYPE,total_sale_area,total_room_num,sale_park)
SELECT B.* from (SELECT * FROM (
SELECT i.id,p.id as fenqi_id,p.project_id,p.company_id,p.area_name,p.version_type,p.current_version,i.batch_name, @rowNum:=@rowNum + 1 AS 'rowNum',v.id as version_id,
i.batch_num,i.format_building_name,product_type_name,sale_type,i.unique_code,i.decorate_name,i.floors,i.pro_type,
IF(v.version_type=1,batch_sale_area,total_sale_area) as total_sale_area,
IF(v.version_type=1,batch_room_num,total_room_num) as total_room_num,sale_park
from pl_build_plan p join (SELECT @rowNum:=0) b
JOIN pl_build_plan_version v on p.id=v.plan_id and p.version_type=v.version_type and p.current_version=v.plan_version
JOIN pl_build_plan_info i on i.version_id=v.id
where p.`status`=2 and i.unique_code is not null
ORDER BY p.id,i.sort_no )A
ORDER BY A.rowNum  )B
ORDER BY B.rowNum;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate1=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=1;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate1=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=1 and n.status=6;


UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate2=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=2;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate2=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=2 and n.status=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate3=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=3;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate3=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=3 and n.status=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate4=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=4;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate4=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=4 and n.status=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate5=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=5;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate5=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=5 and n.status=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate6=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate6=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=6 and n.status=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate7=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=7;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate7=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=7 and n.status=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate8=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=8;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate8=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=8 and n.status=6;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.pdate9=n.planned_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=9;

UPDATE pl_plan_build_report r,pl_build_plan_node n
set r.adate9=n.actual_finish_date
where n.version_id=r.version_id and r.unique_code=n.info_unique_code and n.sort_no=9 and n.status=6;

UPDATE pl_plan_build_report r,pl_plan_info i
set r.company_name=i.company_name,
r.project_id=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where  r.fenqi_id=i.fenqi_id;
UPDATE pl_plan_build_report set floors=0 where floors is null;
END