package com.iwen.bookTicket.bean;


import java.io.Serializable;
import java.util.List;

public class CostDeptVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String departmentId;
	private String name;
	private int levelNum;
	private int pid;
	private List<CostDeptVO> children;
	private Integer uid;
	private Integer ucid;
	private String deptNo;
	private String parentName;
	private String adminPhone;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}

	public List<CostDeptVO> getChildren() {
		return children;
	}

	public void setChildren(List<CostDeptVO> children) {
		this.children = children;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getUcid() {
		return ucid;
	}

	public void setUcid(Integer ucid) {
		this.ucid = ucid;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	private String hrdept;

	public String getHrdept() {
		return hrdept;
	}

	public void setHrdept(String hrdept) {
		this.hrdept = hrdept;
	}
}
