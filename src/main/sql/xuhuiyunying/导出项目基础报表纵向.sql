
SELECT
	p.area_name as '区域/事业部',p.company_name as '城市公司',p.project_name as '项目名称',p.project_id as '项目身份证',p.fenqi_name as '分期',p.batch_name as '组团',
	p.version_name as '计划版本',p.oa_date as '版本审批完成时间',p.node_name as '节点名称',
	a.dict_label_cn as '节点类型',
	b.dict_label_cn as '职能条线',
	case when p.`status`='1' then '未完成' when p.`status`='2' then '逾期未完成' when p.`status`='3' then '正常完成' when p.`status`='4' then '逾期完成' end  as '完成状态',
	p.check_finish_date as '考核完成时间',p.planned_finish_date as '计划完成时间',p.actual_finish_date as '实际完成时间'
FROM
	pl_report_pl_plan p
	LEFT JOIN (SELECT dict_value,dict_label_cn FROM sys_dictionary_data WHERE dict_type = 'planning_all_node_type' ) a on a.dict_value=p.level_id
	LEFT JOIN (SELECT dict_value,dict_label_cn FROM sys_dictionary_data WHERE dict_type = 'planning_phaseId' ) b on b.dict_value=p.phase_id
WHERE
	p.type = 2
	AND p.plan_type = '1'
	AND p.is_quote = 0
	AND p.is_pre != 1
	AND p.operate_type = '1'
	AND p.planned_finish_date IS NOT NULL
ORDER BY
	p.area_name ASC,
	p.project_id ASC,
	p.fenqi_name ASC,
	p.batch_name ASC,
	version_name IS NULL,
	version_name = '',
	oa_date ASC