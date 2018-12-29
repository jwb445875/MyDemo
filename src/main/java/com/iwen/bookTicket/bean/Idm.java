package com.iwen.bookTicket.bean;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Idm implements Serializable {
    private String uid;

    private String smartAlias;

    private String cn;

    private String employeenumber;

    private String departmentnumber;

    private String departmentname;

    private String mail;

    private String userpassword;

    private String smartIdcardnumber;

    private String smartIdcardtype;

    private String smartGender;

    private String smartBirthday;

    private String smartType;

    private String smartStatus;

    private String smartParttimedept;

    private String smartParttimepost;

    private String smartSecuremobile;

    private String smartAuthority;

    private String createtimestamp;

    private String modifytimestamp;

    private String mobile;

    private String telephonenumber;

    private String facsimiletelephonenumber;

    private String postaladdress;

    private String postalcode;

    private String homephone;

    private String homepostaladdress;

    private String manager;

    private String smartOrder;

    private String dsPwpAccountExpirationTime;

    private String dsPwpPasswordExpirationTime;

    private String dsPwpAccountDisabled;

    private String customizedCompanyid;

    private String customizedCompany;

    private String customizedPositionid;

    private String customizedPositionname;

    private String customizedJoinsysdate;

    private String customizedOutdutydate;

    private String customizedCreator;

    private String customizedModifier;

    private String customizedUpdatetype;

    private String smartSources;

    private String customizedReserve2;

    private String customizedReserve3;

    private String customizedReserve4;

    private static final long serialVersionUID = 1L;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getSmartAlias() {
        return smartAlias;
    }

    public void setSmartAlias(String smartAlias) {
        this.smartAlias = smartAlias == null ? null : smartAlias.trim();
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn == null ? null : cn.trim();
    }

    public String getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(String employeenumber) {
        this.employeenumber = employeenumber == null ? null : employeenumber.trim();
    }

    public String getDepartmentnumber() {
        return departmentnumber;
    }

    public void setDepartmentnumber(String departmentnumber) {
        this.departmentnumber = departmentnumber == null ? null : departmentnumber.trim();
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getSmartIdcardnumber() {
        return smartIdcardnumber;
    }

    public void setSmartIdcardnumber(String smartIdcardnumber) {
        this.smartIdcardnumber = smartIdcardnumber == null ? null : smartIdcardnumber.trim();
    }

    public String getSmartIdcardtype() {
        return smartIdcardtype;
    }

    public void setSmartIdcardtype(String smartIdcardtype) {
        this.smartIdcardtype = smartIdcardtype == null ? null : smartIdcardtype.trim();
    }

    public String getSmartGender() {
        return smartGender;
    }

    public void setSmartGender(String smartGender) {
        this.smartGender = smartGender == null ? null : smartGender.trim();
    }

    public String getSmartBirthday() {
        return smartBirthday;
    }

    public void setSmartBirthday(String smartBirthday) {
        this.smartBirthday = smartBirthday == null ? null : smartBirthday.trim();
    }

    public String getSmartType() {
        return smartType;
    }

    public void setSmartType(String smartType) {
        this.smartType = smartType == null ? null : smartType.trim();
    }

    public String getSmartStatus() {
        return smartStatus;
    }

    public void setSmartStatus(String smartStatus) {
        this.smartStatus = smartStatus == null ? null : smartStatus.trim();
    }

    public String getSmartParttimedept() {
        return smartParttimedept;
    }

    public void setSmartParttimedept(String smartParttimedept) {
        this.smartParttimedept = smartParttimedept == null ? null : smartParttimedept.trim();
    }

    public String getSmartParttimepost() {
        return smartParttimepost;
    }

    public void setSmartParttimepost(String smartParttimepost) {
        this.smartParttimepost = smartParttimepost == null ? null : smartParttimepost.trim();
    }

    public String getSmartSecuremobile() {
        return smartSecuremobile;
    }

    public void setSmartSecuremobile(String smartSecuremobile) {
        this.smartSecuremobile = smartSecuremobile == null ? null : smartSecuremobile.trim();
    }

    public String getSmartAuthority() {
        return smartAuthority;
    }

    public void setSmartAuthority(String smartAuthority) {
        this.smartAuthority = smartAuthority == null ? null : smartAuthority.trim();
    }

    public String getCreatetimestamp() {
        return createtimestamp;
    }

    public void setCreatetimestamp(String createtimestamp) {
        this.createtimestamp = createtimestamp == null ? null : createtimestamp.trim();
    }

    public String getModifytimestamp() {
        return modifytimestamp;
    }

    public void setModifytimestamp(String modifytimestamp) {
        this.modifytimestamp = modifytimestamp == null ? null : modifytimestamp.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber == null ? null : telephonenumber.trim();
    }

    public String getFacsimiletelephonenumber() {
        return facsimiletelephonenumber;
    }

    public void setFacsimiletelephonenumber(String facsimiletelephonenumber) {
        this.facsimiletelephonenumber = facsimiletelephonenumber == null ? null : facsimiletelephonenumber.trim();
    }

    public String getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(String postaladdress) {
        this.postaladdress = postaladdress == null ? null : postaladdress.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone == null ? null : homephone.trim();
    }

    public String getHomepostaladdress() {
        return homepostaladdress;
    }

    public void setHomepostaladdress(String homepostaladdress) {
        this.homepostaladdress = homepostaladdress == null ? null : homepostaladdress.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getSmartOrder() {
        return smartOrder;
    }

    public void setSmartOrder(String smartOrder) {
        this.smartOrder = smartOrder == null ? null : smartOrder.trim();
    }

    public String getDsPwpAccountExpirationTime() {
        return dsPwpAccountExpirationTime;
    }

    public void setDsPwpAccountExpirationTime(String dsPwpAccountExpirationTime) {
        this.dsPwpAccountExpirationTime = dsPwpAccountExpirationTime == null ? null : dsPwpAccountExpirationTime.trim();
    }

    public String getDsPwpPasswordExpirationTime() {
        return dsPwpPasswordExpirationTime;
    }

    public void setDsPwpPasswordExpirationTime(String dsPwpPasswordExpirationTime) {
        this.dsPwpPasswordExpirationTime = dsPwpPasswordExpirationTime == null ? null : dsPwpPasswordExpirationTime.trim();
    }

    public String getDsPwpAccountDisabled() {
        return dsPwpAccountDisabled;
    }

    public void setDsPwpAccountDisabled(String dsPwpAccountDisabled) {
        this.dsPwpAccountDisabled = dsPwpAccountDisabled == null ? null : dsPwpAccountDisabled.trim();
    }

    public String getCustomizedCompanyid() {
        return customizedCompanyid;
    }

    public void setCustomizedCompanyid(String customizedCompanyid) {
        this.customizedCompanyid = customizedCompanyid == null ? null : customizedCompanyid.trim();
    }

    public String getCustomizedCompany() {
        return customizedCompany;
    }

    public void setCustomizedCompany(String customizedCompany) {
        this.customizedCompany = customizedCompany == null ? null : customizedCompany.trim();
    }

    public String getCustomizedPositionid() {
        return customizedPositionid;
    }

    public void setCustomizedPositionid(String customizedPositionid) {
        this.customizedPositionid = customizedPositionid == null ? null : customizedPositionid.trim();
    }

    public String getCustomizedPositionname() {
        return customizedPositionname;
    }

    public void setCustomizedPositionname(String customizedPositionname) {
        this.customizedPositionname = customizedPositionname == null ? null : customizedPositionname.trim();
    }

    public String getCustomizedJoinsysdate() {
        return customizedJoinsysdate;
    }

    public void setCustomizedJoinsysdate(String customizedJoinsysdate) {
        this.customizedJoinsysdate = customizedJoinsysdate == null ? null : customizedJoinsysdate.trim();
    }

    public String getCustomizedOutdutydate() {
        return customizedOutdutydate;
    }

    public void setCustomizedOutdutydate(String customizedOutdutydate) {
        this.customizedOutdutydate = customizedOutdutydate == null ? null : customizedOutdutydate.trim();
    }

    public String getCustomizedCreator() {
        return customizedCreator;
    }

    public void setCustomizedCreator(String customizedCreator) {
        this.customizedCreator = customizedCreator == null ? null : customizedCreator.trim();
    }

    public String getCustomizedModifier() {
        return customizedModifier;
    }

    public void setCustomizedModifier(String customizedModifier) {
        this.customizedModifier = customizedModifier == null ? null : customizedModifier.trim();
    }

    public String getCustomizedUpdatetype() {
        return customizedUpdatetype;
    }

    public void setCustomizedUpdatetype(String customizedUpdatetype) {
        this.customizedUpdatetype = customizedUpdatetype == null ? null : customizedUpdatetype.trim();
    }

    public String getSmartSources() {
        return smartSources;
    }

    public void setSmartSources(String smartSources) {
        this.smartSources = smartSources == null ? null : smartSources.trim();
    }

    public String getCustomizedReserve2() {
        return customizedReserve2;
    }

    public void setCustomizedReserve2(String customizedReserve2) {
        this.customizedReserve2 = customizedReserve2 == null ? null : customizedReserve2.trim();
    }

    public String getCustomizedReserve3() {
        return customizedReserve3;
    }

    public void setCustomizedReserve3(String customizedReserve3) {
        this.customizedReserve3 = customizedReserve3 == null ? null : customizedReserve3.trim();
    }

    public String getCustomizedReserve4() {
        return customizedReserve4;
    }

    public void setCustomizedReserve4(String customizedReserve4) {
        this.customizedReserve4 = customizedReserve4 == null ? null : customizedReserve4.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Idm other = (Idm) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getSmartAlias() == null ? other.getSmartAlias() == null : this.getSmartAlias().equals(other.getSmartAlias()))
            && (this.getCn() == null ? other.getCn() == null : this.getCn().equals(other.getCn()))
            && (this.getEmployeenumber() == null ? other.getEmployeenumber() == null : this.getEmployeenumber().equals(other.getEmployeenumber()))
            && (this.getDepartmentnumber() == null ? other.getDepartmentnumber() == null : this.getDepartmentnumber().equals(other.getDepartmentnumber()))
            && (this.getDepartmentname() == null ? other.getDepartmentname() == null : this.getDepartmentname().equals(other.getDepartmentname()))
            && (this.getMail() == null ? other.getMail() == null : this.getMail().equals(other.getMail()))
            && (this.getUserpassword() == null ? other.getUserpassword() == null : this.getUserpassword().equals(other.getUserpassword()))
            && (this.getSmartIdcardnumber() == null ? other.getSmartIdcardnumber() == null : this.getSmartIdcardnumber().equals(other.getSmartIdcardnumber()))
            && (this.getSmartIdcardtype() == null ? other.getSmartIdcardtype() == null : this.getSmartIdcardtype().equals(other.getSmartIdcardtype()))
            && (this.getSmartGender() == null ? other.getSmartGender() == null : this.getSmartGender().equals(other.getSmartGender()))
            && (this.getSmartBirthday() == null ? other.getSmartBirthday() == null : this.getSmartBirthday().equals(other.getSmartBirthday()))
            && (this.getSmartType() == null ? other.getSmartType() == null : this.getSmartType().equals(other.getSmartType()))
            && (this.getSmartStatus() == null ? other.getSmartStatus() == null : this.getSmartStatus().equals(other.getSmartStatus()))
            && (this.getSmartParttimedept() == null ? other.getSmartParttimedept() == null : this.getSmartParttimedept().equals(other.getSmartParttimedept()))
            && (this.getSmartParttimepost() == null ? other.getSmartParttimepost() == null : this.getSmartParttimepost().equals(other.getSmartParttimepost()))
            && (this.getSmartSecuremobile() == null ? other.getSmartSecuremobile() == null : this.getSmartSecuremobile().equals(other.getSmartSecuremobile()))
            && (this.getSmartAuthority() == null ? other.getSmartAuthority() == null : this.getSmartAuthority().equals(other.getSmartAuthority()))
            && (this.getCreatetimestamp() == null ? other.getCreatetimestamp() == null : this.getCreatetimestamp().equals(other.getCreatetimestamp()))
            && (this.getModifytimestamp() == null ? other.getModifytimestamp() == null : this.getModifytimestamp().equals(other.getModifytimestamp()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getTelephonenumber() == null ? other.getTelephonenumber() == null : this.getTelephonenumber().equals(other.getTelephonenumber()))
            && (this.getFacsimiletelephonenumber() == null ? other.getFacsimiletelephonenumber() == null : this.getFacsimiletelephonenumber().equals(other.getFacsimiletelephonenumber()))
            && (this.getPostaladdress() == null ? other.getPostaladdress() == null : this.getPostaladdress().equals(other.getPostaladdress()))
            && (this.getPostalcode() == null ? other.getPostalcode() == null : this.getPostalcode().equals(other.getPostalcode()))
            && (this.getHomephone() == null ? other.getHomephone() == null : this.getHomephone().equals(other.getHomephone()))
            && (this.getHomepostaladdress() == null ? other.getHomepostaladdress() == null : this.getHomepostaladdress().equals(other.getHomepostaladdress()))
            && (this.getManager() == null ? other.getManager() == null : this.getManager().equals(other.getManager()))
            && (this.getSmartOrder() == null ? other.getSmartOrder() == null : this.getSmartOrder().equals(other.getSmartOrder()))
            && (this.getDsPwpAccountExpirationTime() == null ? other.getDsPwpAccountExpirationTime() == null : this.getDsPwpAccountExpirationTime().equals(other.getDsPwpAccountExpirationTime()))
            && (this.getDsPwpPasswordExpirationTime() == null ? other.getDsPwpPasswordExpirationTime() == null : this.getDsPwpPasswordExpirationTime().equals(other.getDsPwpPasswordExpirationTime()))
            && (this.getDsPwpAccountDisabled() == null ? other.getDsPwpAccountDisabled() == null : this.getDsPwpAccountDisabled().equals(other.getDsPwpAccountDisabled()))
            && (this.getCustomizedCompanyid() == null ? other.getCustomizedCompanyid() == null : this.getCustomizedCompanyid().equals(other.getCustomizedCompanyid()))
            && (this.getCustomizedCompany() == null ? other.getCustomizedCompany() == null : this.getCustomizedCompany().equals(other.getCustomizedCompany()))
            && (this.getCustomizedPositionid() == null ? other.getCustomizedPositionid() == null : this.getCustomizedPositionid().equals(other.getCustomizedPositionid()))
            && (this.getCustomizedPositionname() == null ? other.getCustomizedPositionname() == null : this.getCustomizedPositionname().equals(other.getCustomizedPositionname()))
            && (this.getCustomizedJoinsysdate() == null ? other.getCustomizedJoinsysdate() == null : this.getCustomizedJoinsysdate().equals(other.getCustomizedJoinsysdate()))
            && (this.getCustomizedOutdutydate() == null ? other.getCustomizedOutdutydate() == null : this.getCustomizedOutdutydate().equals(other.getCustomizedOutdutydate()))
            && (this.getCustomizedCreator() == null ? other.getCustomizedCreator() == null : this.getCustomizedCreator().equals(other.getCustomizedCreator()))
            && (this.getCustomizedModifier() == null ? other.getCustomizedModifier() == null : this.getCustomizedModifier().equals(other.getCustomizedModifier()))
            && (this.getCustomizedUpdatetype() == null ? other.getCustomizedUpdatetype() == null : this.getCustomizedUpdatetype().equals(other.getCustomizedUpdatetype()))
            && (this.getSmartSources() == null ? other.getSmartSources() == null : this.getSmartSources().equals(other.getSmartSources()))
            && (this.getCustomizedReserve2() == null ? other.getCustomizedReserve2() == null : this.getCustomizedReserve2().equals(other.getCustomizedReserve2()))
            && (this.getCustomizedReserve3() == null ? other.getCustomizedReserve3() == null : this.getCustomizedReserve3().equals(other.getCustomizedReserve3()))
            && (this.getCustomizedReserve4() == null ? other.getCustomizedReserve4() == null : this.getCustomizedReserve4().equals(other.getCustomizedReserve4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getSmartAlias() == null) ? 0 : getSmartAlias().hashCode());
        result = prime * result + ((getCn() == null) ? 0 : getCn().hashCode());
        result = prime * result + ((getEmployeenumber() == null) ? 0 : getEmployeenumber().hashCode());
        result = prime * result + ((getDepartmentnumber() == null) ? 0 : getDepartmentnumber().hashCode());
        result = prime * result + ((getDepartmentname() == null) ? 0 : getDepartmentname().hashCode());
        result = prime * result + ((getMail() == null) ? 0 : getMail().hashCode());
        result = prime * result + ((getUserpassword() == null) ? 0 : getUserpassword().hashCode());
        result = prime * result + ((getSmartIdcardnumber() == null) ? 0 : getSmartIdcardnumber().hashCode());
        result = prime * result + ((getSmartIdcardtype() == null) ? 0 : getSmartIdcardtype().hashCode());
        result = prime * result + ((getSmartGender() == null) ? 0 : getSmartGender().hashCode());
        result = prime * result + ((getSmartBirthday() == null) ? 0 : getSmartBirthday().hashCode());
        result = prime * result + ((getSmartType() == null) ? 0 : getSmartType().hashCode());
        result = prime * result + ((getSmartStatus() == null) ? 0 : getSmartStatus().hashCode());
        result = prime * result + ((getSmartParttimedept() == null) ? 0 : getSmartParttimedept().hashCode());
        result = prime * result + ((getSmartParttimepost() == null) ? 0 : getSmartParttimepost().hashCode());
        result = prime * result + ((getSmartSecuremobile() == null) ? 0 : getSmartSecuremobile().hashCode());
        result = prime * result + ((getSmartAuthority() == null) ? 0 : getSmartAuthority().hashCode());
        result = prime * result + ((getCreatetimestamp() == null) ? 0 : getCreatetimestamp().hashCode());
        result = prime * result + ((getModifytimestamp() == null) ? 0 : getModifytimestamp().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getTelephonenumber() == null) ? 0 : getTelephonenumber().hashCode());
        result = prime * result + ((getFacsimiletelephonenumber() == null) ? 0 : getFacsimiletelephonenumber().hashCode());
        result = prime * result + ((getPostaladdress() == null) ? 0 : getPostaladdress().hashCode());
        result = prime * result + ((getPostalcode() == null) ? 0 : getPostalcode().hashCode());
        result = prime * result + ((getHomephone() == null) ? 0 : getHomephone().hashCode());
        result = prime * result + ((getHomepostaladdress() == null) ? 0 : getHomepostaladdress().hashCode());
        result = prime * result + ((getManager() == null) ? 0 : getManager().hashCode());
        result = prime * result + ((getSmartOrder() == null) ? 0 : getSmartOrder().hashCode());
        result = prime * result + ((getDsPwpAccountExpirationTime() == null) ? 0 : getDsPwpAccountExpirationTime().hashCode());
        result = prime * result + ((getDsPwpPasswordExpirationTime() == null) ? 0 : getDsPwpPasswordExpirationTime().hashCode());
        result = prime * result + ((getDsPwpAccountDisabled() == null) ? 0 : getDsPwpAccountDisabled().hashCode());
        result = prime * result + ((getCustomizedCompanyid() == null) ? 0 : getCustomizedCompanyid().hashCode());
        result = prime * result + ((getCustomizedCompany() == null) ? 0 : getCustomizedCompany().hashCode());
        result = prime * result + ((getCustomizedPositionid() == null) ? 0 : getCustomizedPositionid().hashCode());
        result = prime * result + ((getCustomizedPositionname() == null) ? 0 : getCustomizedPositionname().hashCode());
        result = prime * result + ((getCustomizedJoinsysdate() == null) ? 0 : getCustomizedJoinsysdate().hashCode());
        result = prime * result + ((getCustomizedOutdutydate() == null) ? 0 : getCustomizedOutdutydate().hashCode());
        result = prime * result + ((getCustomizedCreator() == null) ? 0 : getCustomizedCreator().hashCode());
        result = prime * result + ((getCustomizedModifier() == null) ? 0 : getCustomizedModifier().hashCode());
        result = prime * result + ((getCustomizedUpdatetype() == null) ? 0 : getCustomizedUpdatetype().hashCode());
        result = prime * result + ((getSmartSources() == null) ? 0 : getSmartSources().hashCode());
        result = prime * result + ((getCustomizedReserve2() == null) ? 0 : getCustomizedReserve2().hashCode());
        result = prime * result + ((getCustomizedReserve3() == null) ? 0 : getCustomizedReserve3().hashCode());
        result = prime * result + ((getCustomizedReserve4() == null) ? 0 : getCustomizedReserve4().hashCode());
        return result;
    }
    public void setValue(String name,Object value){
        try {
            Field f = this.getClass().getDeclaredField(name);
            f.setAccessible(true);
            f.set(name, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}