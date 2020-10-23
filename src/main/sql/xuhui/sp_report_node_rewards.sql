BEGIN

truncate table pl_report_node_rewards;
INSERT into pl_report_node_rewards(id,fenqi_id,plan_id,version_id,node_code, node_name, level_id,planned_finish_date,actual_finish_date,
proposal_type_id,  planned_rewards_money, created_date, updated_date, is_deleted,tag_flag)
SELECT UUID_SHORT(),p.fenqi_id,p.id,v.id,d.node_code,d.node_name,d.level_id,n.planned_finish_date,n.actual_finish_date,
m.proposal_type ,d.rewards_money,NOW(),NOW(),d.is_deleted,0
from pl_project_rewards_master m,pl_project_rewards_detail d,pl_plan p,pl_plan_version v,pl_plan_node n
where m.project_rewards_status='0' and m.is_deleted='0' and m.id=d.project_rewards_master_id
and m.project_id=p.project_id and p.type='1' and p.biz_type='1' and p.is_deleted='0' and p.id=v.plan_id
and v.is_deleted='0' and v.`status` in (2,6) and v.id=n.version_id  and n.is_deleted='0' and n.node_code=d.node_code;

UPDATE pl_report_node_rewards r,pl_plan_info i
set r.area_id=i.area,r.area_name=i.area_name,
r.company_id=i.company_id,r.company_name=i.company_name,
r.project_id=i.project_id,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where r.fenqi_id=i.fenqi_id and i.is_deleted=0;
UPDATE pl_report_node_rewards set tag_flag=1 where planned_finish_date<date(concat(year(curdate()),'-',elt(quarter(curdate()),1,4,7,10),'-',1));
UPDATE pl_report_node_rewards set actual_cut_money=planned_rewards_money/2 where tag_flag=1 and (actual_finish_date is null or actual_finish_date>planned_finish_date);
UPDATE pl_report_node_rewards set actual_rewards_money=planned_rewards_money where tag_flag=1 and actual_cut_money is null;
END