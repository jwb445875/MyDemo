package com.iwen.bookTicket.service;


import com.iwen.bookTicket.bean.CostDeptVO;
import com.iwen.bookTicket.dao.ExtCostDeptMapper;
import com.iwen.bookTicket.dao.ExtHrDeptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.*;

@Service
@Transactional
public class CostDeptService {

	@Autowired
	private ExtCostDeptMapper extCostDeptMapper;

	@Autowired
	private ExtHrDeptMapper extHrDeptMapper;

	Logger logger = LoggerFactory.getLogger(CostDeptService.class);

	public void  sycnCostDeptAll(List<Map<String,String>> costs) {
		int i=1;
		for (Map<String,String> map:costs){
			logger.info("更新第"+i+"条，账号："+map.get("account")+map.toString());
			if(map.get("cid")!=null){
				addSycnCostDept(map.get("account"),map.get("cid"),map.get("cname"));
			}
			if(map.get("hid")!=null){
				addSycnHrDept(map.get("account"),map.get("hid"),map.get("hname"));
			}
			if(map.get("phone")!=null){
				upPhone(map.get("account"),map.get("phone"));
			}
			i++;
		}
	}



	/**
	 * 同步添加成本部门
	 * @param
	 */
	public void addSycnCostDept(String account,String id,String name){
		try {
			CostDeptVO vo = extCostDeptMapper.getByDepartmentId(id, account);
			if (vo == null) {
				vo = new CostDeptVO();
				vo.setDepartmentId(id);
				vo.setName(name);
				extCostDeptMapper.addSycnCostDept(vo);
				Integer uid = extCostDeptMapper.getUidByAccount(account);
				if (uid != null) {
					extCostDeptMapper.delSycnCostUser(uid);
					extCostDeptMapper.addSycnCostUser(vo.getId(), uid);
				}
			} else {
				if (vo.getName() == null || !vo.getName().equals(name)) {
					vo.setName(name);
					extCostDeptMapper.upName(vo);
				}
				if (vo.getUid() != null && vo.getUcid() == null) {
					extCostDeptMapper.delSycnCostUser(vo.getUid());
					extCostDeptMapper.addSycnCostUser(vo.getId(), vo.getUid());
				}
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 同步添加Hr部门
	 * @param
	 */
	public void addSycnHrDept(String account,String id,String name){
		try {
			CostDeptVO vo = extHrDeptMapper.getByDepartmentId(id, account);
			if (vo == null) {
				vo = new CostDeptVO();
				vo.setDepartmentId(id);
				vo.setName(name);
				extHrDeptMapper.addSycnHrDept(vo);
				Integer uid = extCostDeptMapper.getUidByAccount(account);
				if (uid != null) {
					extHrDeptMapper.delSycnHrUser(uid);
					extHrDeptMapper.addSycnHrUser(vo.getId(), uid);
				}
			} else {
				if (vo.getName() == null || !vo.getName().equals(name)) {
					vo.setName(name);
					extHrDeptMapper.upName(vo);
				}
				if (vo.getUid() != null && vo.getUcid() == null) {
					extHrDeptMapper.delSycnHrUser(vo.getUid());
					extHrDeptMapper.addSycnHrUser(vo.getId(), vo.getUid());
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void upPhone(String account,String phone){
		try {
			extHrDeptMapper.upPhone(account,phone);
		}catch (Exception e){
			e.printStackTrace();
		}
	}




}
