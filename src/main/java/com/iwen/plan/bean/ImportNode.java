package com.iwen.plan.bean;


import com.iwen.util.excel.ExcelColumn;

/**
 * @author Felix.Jin
 * @date 2019/8/22
 */
public class ImportNode {

    @ExcelColumn(title = "节点编码",require = 1)
    private String nodeCode;
    @ExcelColumn(title = "节点名称")
    private String nodeName;

    @ExcelColumn(title = "节点类型")
    private String nodeType;

    @ExcelColumn(title = "所属阶段")
    private String belongPhase;

    @ExcelColumn(title = "职能条线")
    private String funLine;

    @ExcelColumn(title = "是否失效")
    private String failure;

    @ExcelColumn(title = "关联系统")
    private String glSystem;

    @ExcelColumn(title = "计划完成时间")
    private String planFinshTime;

    @ExcelColumn(title = "实际完成时间")
    private String realFinshTime;

    @ExcelColumn(title = "岗位角色")
    private String orgRole;

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

    public String getBelongPhase() {
        return belongPhase;
    }

    public void setBelongPhase(String belongPhase) {
        this.belongPhase = belongPhase;
    }

    public String getFunLine() {
        return funLine;
    }

    public void setFunLine(String funLine) {
        this.funLine = funLine;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public String getGlSystem() {
        return glSystem;
    }

    public void setGlSystem(String glSystem) {
        this.glSystem = glSystem;
    }

    public String getPlanFinshTime() {
        return planFinshTime;
    }

    public void setPlanFinshTime(String planFinshTime) {
        this.planFinshTime = planFinshTime;
    }

    public String getRealFinshTime() {
        return realFinshTime;
    }

    public void setRealFinshTime(String realFinshTime) {
        this.realFinshTime = realFinshTime;
    }

    public String getOrgRole() {
        return orgRole;
    }

    public void setOrgRole(String orgRole) {
        this.orgRole = orgRole;
    }
}
