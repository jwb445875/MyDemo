BEGIN
truncate table pl_report_plan_node_feed;
INSERT pl_report_plan_node_feed(id,type,area_id,area_name,company_id,project_id,fenqi_id,plan_name,batch_id,
node_name,level_id,planned_finish_date,risk_type,risk_comment,feedback_date)
SELECT DISTINCT
    UUID_SHORT(),p.type,p.area,p.area_name,p.company_id,p.project_id,p.fenqi_id,
		case when p.version_type='1' then CONCAT(p.plan_name,'_投资版_V',p.current_version)
		when  p.version_type='2' then CONCAT(p.plan_name,'_战规版_V',p.current_version)
		when p.version_type='3' then CONCAT(p.plan_name,'_动态版_V',p.current_version)
else CONCAT(p.plan_name,'_V',p.current_version) end as plan_name
		,p.batch_id,
		n.node_name,n.level_id,n.planned_finish_date,
		fb.risk_type,fb.risk_comment,fb.created_date
	FROM
	pl_feedback_info fb
		LEFT JOIN pl_plan_node n  ON fb.node_id = n.unique_code
		LEFT JOIN pl_plan_version ver ON ver.id = n.version_id and ver.`status` in (2,6)
		LEFT JOIN pl_plan p ON ver.plan_id = p.id
	WHERE
		fb.type = '2'
		AND n.is_deleted = '0'
		AND p.is_deleted = '0'
		AND n.is_deleted = '0'
		AND ver.is_deleted = '0'
		AND ver.is_freeze = '0' ;


UPDATE pl_report_plan_node_feed r,pl_plan_info i
set r.company_name=i.company_name,
r.project_code=i.project_no,r.project_name=i.project_name,
r.stage_name=i.fenqi_name
where r.fenqi_id=i.fenqi_id and i.is_deleted=0;

UPDATE pl_report_plan_node_feed r,(SELECT batch_id from pl_report_plan_node_feed   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where r.batch_id=c.batch_id and b.batch_code=c.batch_id;

END