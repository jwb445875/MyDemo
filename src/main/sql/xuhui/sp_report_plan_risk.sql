BEGIN
truncate table pl_report_plan_risk;
truncate table pl_report_plan_risk1;
truncate table pl_report_plan_risk2;
DROP TABLE IF EXISTS `pl_report_plan_version`;
CREATE TABLE `pl_report_plan_version` (
`id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '主键',
`plan_id` varchar(64),
`version_id` varchar(64),
`version_type` varchar(32) ,
`version_type2` varchar(32) ,
`plan_version` int (11) ,
`plan_parameter_id` varchar (64) ,
PRIMARY KEY (`id`),
KEY `idx_version_id_` (`plan_id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '预警etl中间表3';
INSERT into pl_report_plan_version(id,plan_id,version_type,version_type2,plan_version)
SELECT UUID_SHORT(),plan_id,version_type,version_type,MAX(plan_version) from pl_plan_version
where `status` in (2,6,7)  and version_type!='0' GROUP BY plan_id,version_type;
UPDATE pl_report_plan_version pv,pl_plan_version v set pv.version_id=v.id,pv.plan_parameter_id=v.plan_parameter_id
where pv.plan_id=v.plan_id and pv.version_type=v.version_type and pv.plan_version=v.plan_version;
INSERT into pl_report_plan_version(id,plan_id,version_id,version_type,version_type2,plan_version,plan_parameter_id)
SELECT UUID_SHORT(),p.id,v.id,'0',v.version_type,v.plan_version,v.plan_parameter_id
from pl_plan p,pl_plan_version v
where p.id=v.plan_id and  v.`status` in (2,6) and p.type='1';

insert into pl_report_plan_risk(id,area_id,area_name,company_id,project_id,fenqi_id,batch_id,plan_id,plan_name,
version_type,current_version,floor_num,
plan_risk_warn_id,risk_name,warn_level,risk_type,key_node_id,key_node_code,key_node_name,
node_id,node_code,node_name,node_date,node_status,warn_date, created_date, created_by, updated_date, updated_by)
SELECT UUID_SHORT(),p.area,p.area_name,p.company_id,p.project_id,p.fenqi_id,p.batch_id,p.id,p.plan_name,
pv.version_type,pv.plan_version,pp.floor_num,
w.id,w.risk_name,w.warn_level,w.risk_type,w.key_node_id,w.key_node_code,w.key_node_name,
n.id,n.node_code,n.node_name, IFNULL(n.actual_finish_date,n.planned_finish_date),n.status, NOW(),NOW(),'iwen',NOW(),'iwen'
from pl_plan_risk_warn w
join pl_plan p on p.area=w.org_id
join pl_report_plan_version pv on pv.plan_id=p.id and pv.version_type=w.version_type
join pl_plan_parameter pp on pp.id=pv.plan_parameter_id
join pl_plan_node n on n.version_id=pv.version_id and n.node_code=w.node_code
where  w.`status`='0' ;

insert into pl_report_plan_risk(id,area_id,area_name,company_id,project_id,fenqi_id,batch_id,plan_id,plan_name,
version_type,current_version,floor_num,
plan_risk_warn_id,risk_name,warn_level,risk_type,key_node_id,key_node_code,key_node_name,
node_id,node_code,node_name,node_date,node_status,warn_date, created_date, created_by, updated_date, updated_by)
SELECT UUID_SHORT(),p.area,p.area_name,p.company_id,p.project_id,p.fenqi_id,p.batch_id,p.id,p.plan_name,
pv.version_type2,pv.plan_version,pp.floor_num,
w.id,w.risk_name,w.warn_level,w.risk_type,w.key_node_id,w.key_node_code,w.key_node_name,
n.id,n.node_code,n.node_name,IFNULL(n.actual_finish_date,n.planned_finish_date) ,n.status, NOW(),NOW(),'iwen',NOW(),'iwen'
from pl_plan_risk_warn w
join pl_plan p on  p.type='1' and p.area not in (SELECT org_id from pl_plan_risk_warn where org_id!='00000001' GROUP BY org_id)
join pl_report_plan_version pv on pv.plan_id=p.id and pv.version_type=w.version_type
join pl_plan_parameter pp on pp.id=pv.plan_parameter_id
join pl_plan_node n on n.version_id=pv.version_id and n.node_code=w.node_code
where w.org_id='00000001' and w.`status`='0';

INSERT into pl_report_plan_risk1
SELECT UUID_SHORT(),r.plan_id,wn.node_code,r.node_date,r.warn_date,w.multiple*r.floor_num+w.days ,r.node_status,wn.version_type,r.id
from pl_report_plan_risk r
join pl_plan_risk_warn w on w.id=r.plan_risk_warn_id
join pl_plan_risk_warn_node wn on w.id=wn.plan_risk_warn_id;

INSERT into pl_report_plan_risk2
SELECT UUID_SHORT(),w.risk_warn_report_id,n.id,n.node_code,n.node_name,
IFNULL(n.actual_finish_date,w.warn_date),datediff(node_date,IFNULL(n.actual_finish_date,w.warn_date))
from pl_report_plan_risk1 w
join pl_report_plan_version pv on pv.plan_id=w.version_id and w.version_type=pv.version_type
join pl_plan_node n on pv.version_id=n.version_id and w.node_code=n.node_code
where  n.is_deleted='0' and datediff(node_date,IFNULL(n.actual_finish_date,w.warn_date))<w.day and (w.node_status!=6 or n.status!=6);

UPDATE pl_report_plan_risk r,(
SELECT risk_warn_report_id,MIN(day) day from pl_report_plan_risk2
GROUP BY risk_warn_report_id)a,pl_report_plan_risk2 b
set r.sub_node_id=b.sub_node_id,r.sub_node_code=b.sub_node_code,
r.sub_node_name=b.sub_node_name,r.sub_node_date=b.sub_node_date
where r.id=a.risk_warn_report_id and a.risk_warn_report_id=b.risk_warn_report_id
and a.day=b.`day`;

DELETE from pl_report_plan_risk where sub_node_id is null;
UPDATE pl_report_plan_risk r,pl_report_plan_risk1 r1
set r.risk_rule=CONCAT(node_name,'-',sub_node_name,'<',r1.day,'天')
where r.id=r1.risk_warn_report_id;
UPDATE pl_report_plan_risk r,pl_plan_info i
set r.company_name=i.company_name,
r.project_code=i.project_no,r.project_name=i.project_name,
r.fenqi_name=i.fenqi_name
where r.fenqi_id=i.fenqi_id and i.is_deleted=0;

UPDATE pl_report_plan_risk r,(SELECT batch_id from pl_report_plan_risk   GROUP BY batch_id) c,
(select  batch_code,batch_name from pl_batch  GROUP BY batch_code) b
set r.batch_name=b.batch_name
where  r.batch_id=c.batch_id and b.batch_code=c.batch_id;
UPDATE pl_report_plan_risk set warn_date=sub_node_date;
END