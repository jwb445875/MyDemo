package com.iwen.plan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


public class PlanNodeEntity  {

    private String id;
    /**
     * 项目计划版本表主键值
     */
    private String versionId;
    /**
     * 节点编码
     */
    private String nodeCode;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 节点类型（字典表：PLANNING_NODE_TYPE）
     */
    private String nodeType;
    /**
     * 所属职能条线（字典表：PLANNING_PHASEID）
     */
    private String phaseId;
    /**
     * 节点阶段（字典表：PLANNING_PHASECODE）
     */
    private String phaseCode;
    /**
     * 节点状态
     * 【1：未开始 2:：已开始 3：风险预警 4：待完成 5：逾期未完成 6：逾期完成 7：正常完成  8：节点完成审批中 9：计划调整审批中】
     */
    private String status;
    /**
     * 排序序号（整体节点排序）
     */
    private Integer sortNo;
    /**
     * 排序序号（有效的节点排序）
     */
    private Integer sortNoDo;
    /**
     * 标准工期（天）
     */
    private Integer standardTime;
    //标准开始时间提前天数
    private Integer springDay;
    /**
     * 执行方式（字典表：planning_executeType）
     */
    private String executeType;
    /**
     * 加减天数
     */
    private Integer operateDays;
    /**
     * 前置节点IDS
     */
    private String preNodeCodes;
    /**
     * 后续节点IDS
     */
    private String nexNodeCodes;
    /**
     * 前置节点的顺序号
     */
    private String preNodeSorts;
    /**
     * 后续节点的顺序号
     */
    private String nexNodeSorts;
    /**
     * 标准完成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date standardFinishDate;
    /**
     * 标准开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date standardStartDate;
    /**
     * 计划开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date plannedStartDate;
    /**
     * 计划完成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date plannedFinishDate;
    /**
     * 实际工期（天）
     */
    private Integer actualTime;
    /**
     *偏差
     */
    private Integer windage;
    /**
     * 春节延长天数
     */
    private Integer extendDay;
    /**
     * 实际开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date actualStartDate;
    /**
     * 实际完成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date actualFinishDate;

    /**
     * 是否关键节点（0：否，1：是）
     */
    private String isKeyNode;
    /**
     * 删除标记（0：未删除 1：已删除）
     */
    private String deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    public String getPhaseCode() {
        return phaseCode;
    }

    public void setPhaseCode(String phaseCode) {
        this.phaseCode = phaseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getSortNoDo() {
        return sortNoDo;
    }

    public void setSortNoDo(Integer sortNoDo) {
        this.sortNoDo = sortNoDo;
    }

    public Integer getStandardTime() {
        return standardTime;
    }

    public void setStandardTime(Integer standardTime) {
        this.standardTime = standardTime;
    }

    public Integer getSpringDay() {
        return springDay;
    }

    public void setSpringDay(Integer springDay) {
        this.springDay = springDay;
    }

    public String getExecuteType() {
        return executeType;
    }

    public void setExecuteType(String executeType) {
        this.executeType = executeType;
    }

    public Integer getOperateDays() {
        return operateDays;
    }

    public void setOperateDays(Integer operateDays) {
        this.operateDays = operateDays;
    }

    public String getPreNodeCodes() {
        return preNodeCodes;
    }

    public void setPreNodeCodes(String preNodeCodes) {
        this.preNodeCodes = preNodeCodes;
    }

    public String getNexNodeCodes() {
        return nexNodeCodes;
    }

    public void setNexNodeCodes(String nexNodeCodes) {
        this.nexNodeCodes = nexNodeCodes;
    }

    public String getPreNodeSorts() {
        return preNodeSorts;
    }

    public void setPreNodeSorts(String preNodeSorts) {
        this.preNodeSorts = preNodeSorts;
    }

    public String getNexNodeSorts() {
        return nexNodeSorts;
    }

    public void setNexNodeSorts(String nexNodeSorts) {
        this.nexNodeSorts = nexNodeSorts;
    }

    public Date getStandardFinishDate() {
        return standardFinishDate;
    }

    public void setStandardFinishDate(Date standardFinishDate) {
        this.standardFinishDate = standardFinishDate;
    }

    public Date getStandardStartDate() {
        return standardStartDate;
    }

    public void setStandardStartDate(Date standardStartDate) {
        this.standardStartDate = standardStartDate;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedFinishDate() {
        return plannedFinishDate;
    }

    public void setPlannedFinishDate(Date plannedFinishDate) {
        this.plannedFinishDate = plannedFinishDate;
    }

    public Integer getActualTime() {
        return actualTime;
    }

    public void setActualTime(Integer actualTime) {
        this.actualTime = actualTime;
    }

    public Integer getWindage() {
        return windage;
    }

    public void setWindage(Integer windage) {
        this.windage = windage;
    }

    public Integer getExtendDay() {
        return extendDay;
    }

    public void setExtendDay(Integer extendDay) {
        this.extendDay = extendDay;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualFinishDate() {
        return actualFinishDate;
    }

    public void setActualFinishDate(Date actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public String getIsKeyNode() {
        return isKeyNode;
    }

    public void setIsKeyNode(String isKeyNode) {
        this.isKeyNode = isKeyNode;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
