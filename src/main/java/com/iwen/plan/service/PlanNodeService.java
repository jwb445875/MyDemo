package com.iwen.plan.service;

import com.iwen.plan.bean.PlanNodeEntity;
import com.iwen.plan.bean.TSUser;
import com.iwen.plan.dao.UserMapper;
import com.iwen.plan.util.NodePreNexSortUtil;
import com.iwen.plan.util.NodePreNexUtil;
import com.iwen.plan.util.NodeStandardUtil;
import com.iwen.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class PlanNodeService {
	Logger logger = LoggerFactory.getLogger(PlanNodeService.class);



	/**
	 * 更新标准完成时间
	 * @param start 第一个节点的开始时间
	 * @param nodes 更新节点
	 * @param springDay 春节影响时长
	 * @param newYearDate 大年初一日期
	 */
	public void upStandards(Date start,List<PlanNodeEntity> nodes,Integer springDay, String newYearDate) {
		try {
			NodeStandardUtil util=new NodeStandardUtil(nodes,springDay,newYearDate);
			nodes=util.getStandards(start);
			if(nodes!=null){
				List<PlanNodeEntity> node1s=nodes.stream().filter(p->p.getStandardStartDate()!=null).collect(Collectors.toList());
				if (!node1s.isEmpty()){
					//benchUpdateStandardsTime(versionId,type,node1s);
				}
				List<PlanNodeEntity> node2s=nodes.stream().filter(p->p.getStandardStartDate()==null).collect(Collectors.toList());
				if (!node2s.isEmpty()){
					//benchCleanStandardsTime(versionId,node2s);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * 更新节点前后codes和sorts
	 * @param nodes 更新的节点
	 * @param draft 是否草稿
	 * @param first 是否第一次
	 */
	public void upNodePreAndNex(List<PlanNodeEntity> nodes, boolean draft,boolean first) {
		Map<String,Integer> map;
		if(draft){
			map = nodes.stream().collect(Collectors.toMap(PlanNodeEntity::getNodeCode, PlanNodeEntity::getSortNo,(k1, k2)->k1));
		}else {
			map = nodes.stream().collect(Collectors.toMap(PlanNodeEntity::getNodeCode, PlanNodeEntity::getSortNoDo,(k1, k2)->k1));
		}
		NodePreNexSortUtil a=null;
		if(first){
			Map<Integer,String> imap=nodes.stream().collect(Collectors.toMap(PlanNodeEntity::getSortNo, PlanNodeEntity::getNodeCode,(k1, k2)->k1));
			a=new NodePreNexSortUtil(imap);
		}
		NodePreNexUtil util=new NodePreNexUtil(map);
		NodePreNexSortUtil b = a;
		nodes.forEach(p->{
			p.setPreNodeSorts(util.getSorts(p.getPreNodeCodes()));
			p.setNexNodeSorts(util.getSorts(p.getNexNodeCodes()));
			if(first){
				p.setPreNodeCodes(b.getCodes(p.getPreNodeSorts()));
				p.setNexNodeCodes(b.getCodes(p.getNexNodeSorts()));
			}
		});
		//.benchUpdatePreNex(versionId,nodes);
	}

}
