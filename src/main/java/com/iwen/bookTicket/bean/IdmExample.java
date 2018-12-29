package com.iwen.bookTicket.bean;

import java.util.ArrayList;
import java.util.List;

public class IdmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int limitStart;

    private int limitEnd;

    public IdmExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return this.limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return this.limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andSmartAliasIsNull() {
            addCriterion("smart-alias is null");
            return (Criteria) this;
        }

        public Criteria andSmartAliasIsNotNull() {
            addCriterion("smart-alias is not null");
            return (Criteria) this;
        }

        public Criteria andSmartAliasEqualTo(String value) {
            addCriterion("smart-alias =", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasNotEqualTo(String value) {
            addCriterion("smart-alias <>", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasGreaterThan(String value) {
            addCriterion("smart-alias >", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasGreaterThanOrEqualTo(String value) {
            addCriterion("smart-alias >=", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasLessThan(String value) {
            addCriterion("smart-alias <", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasLessThanOrEqualTo(String value) {
            addCriterion("smart-alias <=", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasLike(String value) {
            addCriterion("smart-alias like", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasNotLike(String value) {
            addCriterion("smart-alias not like", value, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasIn(List<String> values) {
            addCriterion("smart-alias in", values, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasNotIn(List<String> values) {
            addCriterion("smart-alias not in", values, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasBetween(String value1, String value2) {
            addCriterion("smart-alias between", value1, value2, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andSmartAliasNotBetween(String value1, String value2) {
            addCriterion("smart-alias not between", value1, value2, "smartAlias");
            return (Criteria) this;
        }

        public Criteria andCnIsNull() {
            addCriterion("cn is null");
            return (Criteria) this;
        }

        public Criteria andCnIsNotNull() {
            addCriterion("cn is not null");
            return (Criteria) this;
        }

        public Criteria andCnEqualTo(String value) {
            addCriterion("cn =", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotEqualTo(String value) {
            addCriterion("cn <>", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThan(String value) {
            addCriterion("cn >", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThanOrEqualTo(String value) {
            addCriterion("cn >=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThan(String value) {
            addCriterion("cn <", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThanOrEqualTo(String value) {
            addCriterion("cn <=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLike(String value) {
            addCriterion("cn like", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotLike(String value) {
            addCriterion("cn not like", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnIn(List<String> values) {
            addCriterion("cn in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotIn(List<String> values) {
            addCriterion("cn not in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnBetween(String value1, String value2) {
            addCriterion("cn between", value1, value2, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotBetween(String value1, String value2) {
            addCriterion("cn not between", value1, value2, "cn");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberIsNull() {
            addCriterion("employeenumber is null");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberIsNotNull() {
            addCriterion("employeenumber is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberEqualTo(String value) {
            addCriterion("employeenumber =", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberNotEqualTo(String value) {
            addCriterion("employeenumber <>", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberGreaterThan(String value) {
            addCriterion("employeenumber >", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberGreaterThanOrEqualTo(String value) {
            addCriterion("employeenumber >=", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberLessThan(String value) {
            addCriterion("employeenumber <", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberLessThanOrEqualTo(String value) {
            addCriterion("employeenumber <=", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberLike(String value) {
            addCriterion("employeenumber like", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberNotLike(String value) {
            addCriterion("employeenumber not like", value, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberIn(List<String> values) {
            addCriterion("employeenumber in", values, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberNotIn(List<String> values) {
            addCriterion("employeenumber not in", values, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberBetween(String value1, String value2) {
            addCriterion("employeenumber between", value1, value2, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andEmployeenumberNotBetween(String value1, String value2) {
            addCriterion("employeenumber not between", value1, value2, "employeenumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberIsNull() {
            addCriterion("departmentnumber is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberIsNotNull() {
            addCriterion("departmentnumber is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberEqualTo(String value) {
            addCriterion("departmentnumber =", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberNotEqualTo(String value) {
            addCriterion("departmentnumber <>", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberGreaterThan(String value) {
            addCriterion("departmentnumber >", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberGreaterThanOrEqualTo(String value) {
            addCriterion("departmentnumber >=", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberLessThan(String value) {
            addCriterion("departmentnumber <", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberLessThanOrEqualTo(String value) {
            addCriterion("departmentnumber <=", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberLike(String value) {
            addCriterion("departmentnumber like", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberNotLike(String value) {
            addCriterion("departmentnumber not like", value, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberIn(List<String> values) {
            addCriterion("departmentnumber in", values, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberNotIn(List<String> values) {
            addCriterion("departmentnumber not in", values, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberBetween(String value1, String value2) {
            addCriterion("departmentnumber between", value1, value2, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnumberNotBetween(String value1, String value2) {
            addCriterion("departmentnumber not between", value1, value2, "departmentnumber");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameIsNull() {
            addCriterion("departmentname is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameIsNotNull() {
            addCriterion("departmentname is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameEqualTo(String value) {
            addCriterion("departmentname =", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotEqualTo(String value) {
            addCriterion("departmentname <>", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameGreaterThan(String value) {
            addCriterion("departmentname >", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameGreaterThanOrEqualTo(String value) {
            addCriterion("departmentname >=", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameLessThan(String value) {
            addCriterion("departmentname <", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameLessThanOrEqualTo(String value) {
            addCriterion("departmentname <=", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameLike(String value) {
            addCriterion("departmentname like", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotLike(String value) {
            addCriterion("departmentname not like", value, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameIn(List<String> values) {
            addCriterion("departmentname in", values, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotIn(List<String> values) {
            addCriterion("departmentname not in", values, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameBetween(String value1, String value2) {
            addCriterion("departmentname between", value1, value2, "departmentname");
            return (Criteria) this;
        }

        public Criteria andDepartmentnameNotBetween(String value1, String value2) {
            addCriterion("departmentname not between", value1, value2, "departmentname");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNull() {
            addCriterion("userpassword is null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIsNotNull() {
            addCriterion("userpassword is not null");
            return (Criteria) this;
        }

        public Criteria andUserpasswordEqualTo(String value) {
            addCriterion("userpassword =", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotEqualTo(String value) {
            addCriterion("userpassword <>", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThan(String value) {
            addCriterion("userpassword >", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("userpassword >=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThan(String value) {
            addCriterion("userpassword <", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLessThanOrEqualTo(String value) {
            addCriterion("userpassword <=", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordLike(String value) {
            addCriterion("userpassword like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotLike(String value) {
            addCriterion("userpassword not like", value, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordIn(List<String> values) {
            addCriterion("userpassword in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotIn(List<String> values) {
            addCriterion("userpassword not in", values, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordBetween(String value1, String value2) {
            addCriterion("userpassword between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andUserpasswordNotBetween(String value1, String value2) {
            addCriterion("userpassword not between", value1, value2, "userpassword");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberIsNull() {
            addCriterion("smart-idcardnumber is null");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberIsNotNull() {
            addCriterion("smart-idcardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberEqualTo(String value) {
            addCriterion("smart-idcardnumber =", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberNotEqualTo(String value) {
            addCriterion("smart-idcardnumber <>", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberGreaterThan(String value) {
            addCriterion("smart-idcardnumber >", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("smart-idcardnumber >=", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberLessThan(String value) {
            addCriterion("smart-idcardnumber <", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberLessThanOrEqualTo(String value) {
            addCriterion("smart-idcardnumber <=", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberLike(String value) {
            addCriterion("smart-idcardnumber like", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberNotLike(String value) {
            addCriterion("smart-idcardnumber not like", value, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberIn(List<String> values) {
            addCriterion("smart-idcardnumber in", values, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberNotIn(List<String> values) {
            addCriterion("smart-idcardnumber not in", values, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberBetween(String value1, String value2) {
            addCriterion("smart-idcardnumber between", value1, value2, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardnumberNotBetween(String value1, String value2) {
            addCriterion("smart-idcardnumber not between", value1, value2, "smartIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeIsNull() {
            addCriterion("smart-idcardtype is null");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeIsNotNull() {
            addCriterion("smart-idcardtype is not null");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeEqualTo(String value) {
            addCriterion("smart-idcardtype =", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeNotEqualTo(String value) {
            addCriterion("smart-idcardtype <>", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeGreaterThan(String value) {
            addCriterion("smart-idcardtype >", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("smart-idcardtype >=", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeLessThan(String value) {
            addCriterion("smart-idcardtype <", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeLessThanOrEqualTo(String value) {
            addCriterion("smart-idcardtype <=", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeLike(String value) {
            addCriterion("smart-idcardtype like", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeNotLike(String value) {
            addCriterion("smart-idcardtype not like", value, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeIn(List<String> values) {
            addCriterion("smart-idcardtype in", values, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeNotIn(List<String> values) {
            addCriterion("smart-idcardtype not in", values, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeBetween(String value1, String value2) {
            addCriterion("smart-idcardtype between", value1, value2, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartIdcardtypeNotBetween(String value1, String value2) {
            addCriterion("smart-idcardtype not between", value1, value2, "smartIdcardtype");
            return (Criteria) this;
        }

        public Criteria andSmartGenderIsNull() {
            addCriterion("smart-gender is null");
            return (Criteria) this;
        }

        public Criteria andSmartGenderIsNotNull() {
            addCriterion("smart-gender is not null");
            return (Criteria) this;
        }

        public Criteria andSmartGenderEqualTo(String value) {
            addCriterion("smart-gender =", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderNotEqualTo(String value) {
            addCriterion("smart-gender <>", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderGreaterThan(String value) {
            addCriterion("smart-gender >", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderGreaterThanOrEqualTo(String value) {
            addCriterion("smart-gender >=", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderLessThan(String value) {
            addCriterion("smart-gender <", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderLessThanOrEqualTo(String value) {
            addCriterion("smart-gender <=", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderLike(String value) {
            addCriterion("smart-gender like", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderNotLike(String value) {
            addCriterion("smart-gender not like", value, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderIn(List<String> values) {
            addCriterion("smart-gender in", values, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderNotIn(List<String> values) {
            addCriterion("smart-gender not in", values, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderBetween(String value1, String value2) {
            addCriterion("smart-gender between", value1, value2, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartGenderNotBetween(String value1, String value2) {
            addCriterion("smart-gender not between", value1, value2, "smartGender");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayIsNull() {
            addCriterion("smart-birthday is null");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayIsNotNull() {
            addCriterion("smart-birthday is not null");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayEqualTo(String value) {
            addCriterion("smart-birthday =", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayNotEqualTo(String value) {
            addCriterion("smart-birthday <>", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayGreaterThan(String value) {
            addCriterion("smart-birthday >", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("smart-birthday >=", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayLessThan(String value) {
            addCriterion("smart-birthday <", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayLessThanOrEqualTo(String value) {
            addCriterion("smart-birthday <=", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayLike(String value) {
            addCriterion("smart-birthday like", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayNotLike(String value) {
            addCriterion("smart-birthday not like", value, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayIn(List<String> values) {
            addCriterion("smart-birthday in", values, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayNotIn(List<String> values) {
            addCriterion("smart-birthday not in", values, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayBetween(String value1, String value2) {
            addCriterion("smart-birthday between", value1, value2, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartBirthdayNotBetween(String value1, String value2) {
            addCriterion("smart-birthday not between", value1, value2, "smartBirthday");
            return (Criteria) this;
        }

        public Criteria andSmartTypeIsNull() {
            addCriterion("smart-type is null");
            return (Criteria) this;
        }

        public Criteria andSmartTypeIsNotNull() {
            addCriterion("smart-type is not null");
            return (Criteria) this;
        }

        public Criteria andSmartTypeEqualTo(String value) {
            addCriterion("smart-type =", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeNotEqualTo(String value) {
            addCriterion("smart-type <>", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeGreaterThan(String value) {
            addCriterion("smart-type >", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeGreaterThanOrEqualTo(String value) {
            addCriterion("smart-type >=", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeLessThan(String value) {
            addCriterion("smart-type <", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeLessThanOrEqualTo(String value) {
            addCriterion("smart-type <=", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeLike(String value) {
            addCriterion("smart-type like", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeNotLike(String value) {
            addCriterion("smart-type not like", value, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeIn(List<String> values) {
            addCriterion("smart-type in", values, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeNotIn(List<String> values) {
            addCriterion("smart-type not in", values, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeBetween(String value1, String value2) {
            addCriterion("smart-type between", value1, value2, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartTypeNotBetween(String value1, String value2) {
            addCriterion("smart-type not between", value1, value2, "smartType");
            return (Criteria) this;
        }

        public Criteria andSmartStatusIsNull() {
            addCriterion("smart-status is null");
            return (Criteria) this;
        }

        public Criteria andSmartStatusIsNotNull() {
            addCriterion("smart-status is not null");
            return (Criteria) this;
        }

        public Criteria andSmartStatusEqualTo(String value) {
            addCriterion("smart-status =", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusNotEqualTo(String value) {
            addCriterion("smart-status <>", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusGreaterThan(String value) {
            addCriterion("smart-status >", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusGreaterThanOrEqualTo(String value) {
            addCriterion("smart-status >=", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusLessThan(String value) {
            addCriterion("smart-status <", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusLessThanOrEqualTo(String value) {
            addCriterion("smart-status <=", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusLike(String value) {
            addCriterion("smart-status like", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusNotLike(String value) {
            addCriterion("smart-status not like", value, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusIn(List<String> values) {
            addCriterion("smart-status in", values, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusNotIn(List<String> values) {
            addCriterion("smart-status not in", values, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusBetween(String value1, String value2) {
            addCriterion("smart-status between", value1, value2, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartStatusNotBetween(String value1, String value2) {
            addCriterion("smart-status not between", value1, value2, "smartStatus");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptIsNull() {
            addCriterion("smart-parttimedept is null");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptIsNotNull() {
            addCriterion("smart-parttimedept is not null");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptEqualTo(String value) {
            addCriterion("smart-parttimedept =", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptNotEqualTo(String value) {
            addCriterion("smart-parttimedept <>", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptGreaterThan(String value) {
            addCriterion("smart-parttimedept >", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptGreaterThanOrEqualTo(String value) {
            addCriterion("smart-parttimedept >=", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptLessThan(String value) {
            addCriterion("smart-parttimedept <", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptLessThanOrEqualTo(String value) {
            addCriterion("smart-parttimedept <=", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptLike(String value) {
            addCriterion("smart-parttimedept like", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptNotLike(String value) {
            addCriterion("smart-parttimedept not like", value, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptIn(List<String> values) {
            addCriterion("smart-parttimedept in", values, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptNotIn(List<String> values) {
            addCriterion("smart-parttimedept not in", values, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptBetween(String value1, String value2) {
            addCriterion("smart-parttimedept between", value1, value2, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimedeptNotBetween(String value1, String value2) {
            addCriterion("smart-parttimedept not between", value1, value2, "smartParttimedept");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostIsNull() {
            addCriterion("smart-parttimepost is null");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostIsNotNull() {
            addCriterion("smart-parttimepost is not null");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostEqualTo(String value) {
            addCriterion("smart-parttimepost =", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostNotEqualTo(String value) {
            addCriterion("smart-parttimepost <>", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostGreaterThan(String value) {
            addCriterion("smart-parttimepost >", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostGreaterThanOrEqualTo(String value) {
            addCriterion("smart-parttimepost >=", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostLessThan(String value) {
            addCriterion("smart-parttimepost <", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostLessThanOrEqualTo(String value) {
            addCriterion("smart-parttimepost <=", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostLike(String value) {
            addCriterion("smart-parttimepost like", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostNotLike(String value) {
            addCriterion("smart-parttimepost not like", value, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostIn(List<String> values) {
            addCriterion("smart-parttimepost in", values, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostNotIn(List<String> values) {
            addCriterion("smart-parttimepost not in", values, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostBetween(String value1, String value2) {
            addCriterion("smart-parttimepost between", value1, value2, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartParttimepostNotBetween(String value1, String value2) {
            addCriterion("smart-parttimepost not between", value1, value2, "smartParttimepost");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileIsNull() {
            addCriterion("smart-securemobile is null");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileIsNotNull() {
            addCriterion("smart-securemobile is not null");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileEqualTo(String value) {
            addCriterion("smart-securemobile =", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileNotEqualTo(String value) {
            addCriterion("smart-securemobile <>", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileGreaterThan(String value) {
            addCriterion("smart-securemobile >", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileGreaterThanOrEqualTo(String value) {
            addCriterion("smart-securemobile >=", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileLessThan(String value) {
            addCriterion("smart-securemobile <", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileLessThanOrEqualTo(String value) {
            addCriterion("smart-securemobile <=", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileLike(String value) {
            addCriterion("smart-securemobile like", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileNotLike(String value) {
            addCriterion("smart-securemobile not like", value, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileIn(List<String> values) {
            addCriterion("smart-securemobile in", values, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileNotIn(List<String> values) {
            addCriterion("smart-securemobile not in", values, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileBetween(String value1, String value2) {
            addCriterion("smart-securemobile between", value1, value2, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartSecuremobileNotBetween(String value1, String value2) {
            addCriterion("smart-securemobile not between", value1, value2, "smartSecuremobile");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityIsNull() {
            addCriterion("smart-authority is null");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityIsNotNull() {
            addCriterion("smart-authority is not null");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityEqualTo(String value) {
            addCriterion("smart-authority =", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityNotEqualTo(String value) {
            addCriterion("smart-authority <>", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityGreaterThan(String value) {
            addCriterion("smart-authority >", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityGreaterThanOrEqualTo(String value) {
            addCriterion("smart-authority >=", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityLessThan(String value) {
            addCriterion("smart-authority <", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityLessThanOrEqualTo(String value) {
            addCriterion("smart-authority <=", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityLike(String value) {
            addCriterion("smart-authority like", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityNotLike(String value) {
            addCriterion("smart-authority not like", value, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityIn(List<String> values) {
            addCriterion("smart-authority in", values, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityNotIn(List<String> values) {
            addCriterion("smart-authority not in", values, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityBetween(String value1, String value2) {
            addCriterion("smart-authority between", value1, value2, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andSmartAuthorityNotBetween(String value1, String value2) {
            addCriterion("smart-authority not between", value1, value2, "smartAuthority");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampIsNull() {
            addCriterion("createTimestamp is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampIsNotNull() {
            addCriterion("createTimestamp is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampEqualTo(String value) {
            addCriterion("createTimestamp =", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampNotEqualTo(String value) {
            addCriterion("createTimestamp <>", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampGreaterThan(String value) {
            addCriterion("createTimestamp >", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampGreaterThanOrEqualTo(String value) {
            addCriterion("createTimestamp >=", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampLessThan(String value) {
            addCriterion("createTimestamp <", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampLessThanOrEqualTo(String value) {
            addCriterion("createTimestamp <=", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampLike(String value) {
            addCriterion("createTimestamp like", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampNotLike(String value) {
            addCriterion("createTimestamp not like", value, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampIn(List<String> values) {
            addCriterion("createTimestamp in", values, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampNotIn(List<String> values) {
            addCriterion("createTimestamp not in", values, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampBetween(String value1, String value2) {
            addCriterion("createTimestamp between", value1, value2, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatetimestampNotBetween(String value1, String value2) {
            addCriterion("createTimestamp not between", value1, value2, "createtimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampIsNull() {
            addCriterion("modifyTimestamp is null");
            return (Criteria) this;
        }

        public Criteria andModifytimestampIsNotNull() {
            addCriterion("modifyTimestamp is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimestampEqualTo(String value) {
            addCriterion("modifyTimestamp =", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampNotEqualTo(String value) {
            addCriterion("modifyTimestamp <>", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampGreaterThan(String value) {
            addCriterion("modifyTimestamp >", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampGreaterThanOrEqualTo(String value) {
            addCriterion("modifyTimestamp >=", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampLessThan(String value) {
            addCriterion("modifyTimestamp <", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampLessThanOrEqualTo(String value) {
            addCriterion("modifyTimestamp <=", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampLike(String value) {
            addCriterion("modifyTimestamp like", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampNotLike(String value) {
            addCriterion("modifyTimestamp not like", value, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampIn(List<String> values) {
            addCriterion("modifyTimestamp in", values, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampNotIn(List<String> values) {
            addCriterion("modifyTimestamp not in", values, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampBetween(String value1, String value2) {
            addCriterion("modifyTimestamp between", value1, value2, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andModifytimestampNotBetween(String value1, String value2) {
            addCriterion("modifyTimestamp not between", value1, value2, "modifytimestamp");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberIsNull() {
            addCriterion("telephoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberIsNotNull() {
            addCriterion("telephoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberEqualTo(String value) {
            addCriterion("telephoneNumber =", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotEqualTo(String value) {
            addCriterion("telephoneNumber <>", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberGreaterThan(String value) {
            addCriterion("telephoneNumber >", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("telephoneNumber >=", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberLessThan(String value) {
            addCriterion("telephoneNumber <", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberLessThanOrEqualTo(String value) {
            addCriterion("telephoneNumber <=", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberLike(String value) {
            addCriterion("telephoneNumber like", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotLike(String value) {
            addCriterion("telephoneNumber not like", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberIn(List<String> values) {
            addCriterion("telephoneNumber in", values, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotIn(List<String> values) {
            addCriterion("telephoneNumber not in", values, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberBetween(String value1, String value2) {
            addCriterion("telephoneNumber between", value1, value2, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotBetween(String value1, String value2) {
            addCriterion("telephoneNumber not between", value1, value2, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberIsNull() {
            addCriterion("facsimileTelephoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberIsNotNull() {
            addCriterion("facsimileTelephoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberEqualTo(String value) {
            addCriterion("facsimileTelephoneNumber =", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberNotEqualTo(String value) {
            addCriterion("facsimileTelephoneNumber <>", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberGreaterThan(String value) {
            addCriterion("facsimileTelephoneNumber >", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("facsimileTelephoneNumber >=", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberLessThan(String value) {
            addCriterion("facsimileTelephoneNumber <", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberLessThanOrEqualTo(String value) {
            addCriterion("facsimileTelephoneNumber <=", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberLike(String value) {
            addCriterion("facsimileTelephoneNumber like", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberNotLike(String value) {
            addCriterion("facsimileTelephoneNumber not like", value, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberIn(List<String> values) {
            addCriterion("facsimileTelephoneNumber in", values, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberNotIn(List<String> values) {
            addCriterion("facsimileTelephoneNumber not in", values, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberBetween(String value1, String value2) {
            addCriterion("facsimileTelephoneNumber between", value1, value2, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andFacsimiletelephonenumberNotBetween(String value1, String value2) {
            addCriterion("facsimileTelephoneNumber not between", value1, value2, "facsimiletelephonenumber");
            return (Criteria) this;
        }

        public Criteria andPostaladdressIsNull() {
            addCriterion("postalAddress is null");
            return (Criteria) this;
        }

        public Criteria andPostaladdressIsNotNull() {
            addCriterion("postalAddress is not null");
            return (Criteria) this;
        }

        public Criteria andPostaladdressEqualTo(String value) {
            addCriterion("postalAddress =", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressNotEqualTo(String value) {
            addCriterion("postalAddress <>", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressGreaterThan(String value) {
            addCriterion("postalAddress >", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressGreaterThanOrEqualTo(String value) {
            addCriterion("postalAddress >=", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressLessThan(String value) {
            addCriterion("postalAddress <", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressLessThanOrEqualTo(String value) {
            addCriterion("postalAddress <=", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressLike(String value) {
            addCriterion("postalAddress like", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressNotLike(String value) {
            addCriterion("postalAddress not like", value, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressIn(List<String> values) {
            addCriterion("postalAddress in", values, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressNotIn(List<String> values) {
            addCriterion("postalAddress not in", values, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressBetween(String value1, String value2) {
            addCriterion("postalAddress between", value1, value2, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostaladdressNotBetween(String value1, String value2) {
            addCriterion("postalAddress not between", value1, value2, "postaladdress");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIsNull() {
            addCriterion("postalCode is null");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIsNotNull() {
            addCriterion("postalCode is not null");
            return (Criteria) this;
        }

        public Criteria andPostalcodeEqualTo(String value) {
            addCriterion("postalCode =", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotEqualTo(String value) {
            addCriterion("postalCode <>", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeGreaterThan(String value) {
            addCriterion("postalCode >", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postalCode >=", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLessThan(String value) {
            addCriterion("postalCode <", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLessThanOrEqualTo(String value) {
            addCriterion("postalCode <=", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLike(String value) {
            addCriterion("postalCode like", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotLike(String value) {
            addCriterion("postalCode not like", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIn(List<String> values) {
            addCriterion("postalCode in", values, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotIn(List<String> values) {
            addCriterion("postalCode not in", values, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeBetween(String value1, String value2) {
            addCriterion("postalCode between", value1, value2, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotBetween(String value1, String value2) {
            addCriterion("postalCode not between", value1, value2, "postalcode");
            return (Criteria) this;
        }

        public Criteria andHomephoneIsNull() {
            addCriterion("homephone is null");
            return (Criteria) this;
        }

        public Criteria andHomephoneIsNotNull() {
            addCriterion("homephone is not null");
            return (Criteria) this;
        }

        public Criteria andHomephoneEqualTo(String value) {
            addCriterion("homephone =", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotEqualTo(String value) {
            addCriterion("homephone <>", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneGreaterThan(String value) {
            addCriterion("homephone >", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneGreaterThanOrEqualTo(String value) {
            addCriterion("homephone >=", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneLessThan(String value) {
            addCriterion("homephone <", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneLessThanOrEqualTo(String value) {
            addCriterion("homephone <=", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneLike(String value) {
            addCriterion("homephone like", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotLike(String value) {
            addCriterion("homephone not like", value, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneIn(List<String> values) {
            addCriterion("homephone in", values, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotIn(List<String> values) {
            addCriterion("homephone not in", values, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneBetween(String value1, String value2) {
            addCriterion("homephone between", value1, value2, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomephoneNotBetween(String value1, String value2) {
            addCriterion("homephone not between", value1, value2, "homephone");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressIsNull() {
            addCriterion("homePostalAddress is null");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressIsNotNull() {
            addCriterion("homePostalAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressEqualTo(String value) {
            addCriterion("homePostalAddress =", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressNotEqualTo(String value) {
            addCriterion("homePostalAddress <>", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressGreaterThan(String value) {
            addCriterion("homePostalAddress >", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressGreaterThanOrEqualTo(String value) {
            addCriterion("homePostalAddress >=", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressLessThan(String value) {
            addCriterion("homePostalAddress <", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressLessThanOrEqualTo(String value) {
            addCriterion("homePostalAddress <=", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressLike(String value) {
            addCriterion("homePostalAddress like", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressNotLike(String value) {
            addCriterion("homePostalAddress not like", value, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressIn(List<String> values) {
            addCriterion("homePostalAddress in", values, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressNotIn(List<String> values) {
            addCriterion("homePostalAddress not in", values, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressBetween(String value1, String value2) {
            addCriterion("homePostalAddress between", value1, value2, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andHomepostaladdressNotBetween(String value1, String value2) {
            addCriterion("homePostalAddress not between", value1, value2, "homepostaladdress");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andSmartOrderIsNull() {
            addCriterion("smart-order is null");
            return (Criteria) this;
        }

        public Criteria andSmartOrderIsNotNull() {
            addCriterion("smart-order is not null");
            return (Criteria) this;
        }

        public Criteria andSmartOrderEqualTo(String value) {
            addCriterion("smart-order =", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderNotEqualTo(String value) {
            addCriterion("smart-order <>", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderGreaterThan(String value) {
            addCriterion("smart-order >", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderGreaterThanOrEqualTo(String value) {
            addCriterion("smart-order >=", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderLessThan(String value) {
            addCriterion("smart-order <", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderLessThanOrEqualTo(String value) {
            addCriterion("smart-order <=", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderLike(String value) {
            addCriterion("smart-order like", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderNotLike(String value) {
            addCriterion("smart-order not like", value, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderIn(List<String> values) {
            addCriterion("smart-order in", values, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderNotIn(List<String> values) {
            addCriterion("smart-order not in", values, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderBetween(String value1, String value2) {
            addCriterion("smart-order between", value1, value2, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andSmartOrderNotBetween(String value1, String value2) {
            addCriterion("smart-order not between", value1, value2, "smartOrder");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeIsNull() {
            addCriterion("ds-pwp-account-expiration-time is null");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeIsNotNull() {
            addCriterion("ds-pwp-account-expiration-time is not null");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeEqualTo(String value) {
            addCriterion("ds-pwp-account-expiration-time =", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeNotEqualTo(String value) {
            addCriterion("ds-pwp-account-expiration-time <>", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeGreaterThan(String value) {
            addCriterion("ds-pwp-account-expiration-time >", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ds-pwp-account-expiration-time >=", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeLessThan(String value) {
            addCriterion("ds-pwp-account-expiration-time <", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeLessThanOrEqualTo(String value) {
            addCriterion("ds-pwp-account-expiration-time <=", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeLike(String value) {
            addCriterion("ds-pwp-account-expiration-time like", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeNotLike(String value) {
            addCriterion("ds-pwp-account-expiration-time not like", value, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeIn(List<String> values) {
            addCriterion("ds-pwp-account-expiration-time in", values, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeNotIn(List<String> values) {
            addCriterion("ds-pwp-account-expiration-time not in", values, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeBetween(String value1, String value2) {
            addCriterion("ds-pwp-account-expiration-time between", value1, value2, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountExpirationTimeNotBetween(String value1, String value2) {
            addCriterion("ds-pwp-account-expiration-time not between", value1, value2, "dsPwpAccountExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeIsNull() {
            addCriterion("ds-pwp-password-expiration-time is null");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeIsNotNull() {
            addCriterion("ds-pwp-password-expiration-time is not null");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeEqualTo(String value) {
            addCriterion("ds-pwp-password-expiration-time =", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeNotEqualTo(String value) {
            addCriterion("ds-pwp-password-expiration-time <>", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeGreaterThan(String value) {
            addCriterion("ds-pwp-password-expiration-time >", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ds-pwp-password-expiration-time >=", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeLessThan(String value) {
            addCriterion("ds-pwp-password-expiration-time <", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeLessThanOrEqualTo(String value) {
            addCriterion("ds-pwp-password-expiration-time <=", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeLike(String value) {
            addCriterion("ds-pwp-password-expiration-time like", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeNotLike(String value) {
            addCriterion("ds-pwp-password-expiration-time not like", value, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeIn(List<String> values) {
            addCriterion("ds-pwp-password-expiration-time in", values, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeNotIn(List<String> values) {
            addCriterion("ds-pwp-password-expiration-time not in", values, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeBetween(String value1, String value2) {
            addCriterion("ds-pwp-password-expiration-time between", value1, value2, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpPasswordExpirationTimeNotBetween(String value1, String value2) {
            addCriterion("ds-pwp-password-expiration-time not between", value1, value2, "dsPwpPasswordExpirationTime");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledIsNull() {
            addCriterion("ds-pwp-account-disabled is null");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledIsNotNull() {
            addCriterion("ds-pwp-account-disabled is not null");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledEqualTo(String value) {
            addCriterion("ds-pwp-account-disabled =", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledNotEqualTo(String value) {
            addCriterion("ds-pwp-account-disabled <>", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledGreaterThan(String value) {
            addCriterion("ds-pwp-account-disabled >", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledGreaterThanOrEqualTo(String value) {
            addCriterion("ds-pwp-account-disabled >=", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledLessThan(String value) {
            addCriterion("ds-pwp-account-disabled <", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledLessThanOrEqualTo(String value) {
            addCriterion("ds-pwp-account-disabled <=", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledLike(String value) {
            addCriterion("ds-pwp-account-disabled like", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledNotLike(String value) {
            addCriterion("ds-pwp-account-disabled not like", value, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledIn(List<String> values) {
            addCriterion("ds-pwp-account-disabled in", values, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledNotIn(List<String> values) {
            addCriterion("ds-pwp-account-disabled not in", values, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledBetween(String value1, String value2) {
            addCriterion("ds-pwp-account-disabled between", value1, value2, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andDsPwpAccountDisabledNotBetween(String value1, String value2) {
            addCriterion("ds-pwp-account-disabled not between", value1, value2, "dsPwpAccountDisabled");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidIsNull() {
            addCriterion("customized-companyid is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidIsNotNull() {
            addCriterion("customized-companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidEqualTo(String value) {
            addCriterion("customized-companyid =", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidNotEqualTo(String value) {
            addCriterion("customized-companyid <>", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidGreaterThan(String value) {
            addCriterion("customized-companyid >", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidGreaterThanOrEqualTo(String value) {
            addCriterion("customized-companyid >=", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidLessThan(String value) {
            addCriterion("customized-companyid <", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidLessThanOrEqualTo(String value) {
            addCriterion("customized-companyid <=", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidLike(String value) {
            addCriterion("customized-companyid like", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidNotLike(String value) {
            addCriterion("customized-companyid not like", value, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidIn(List<String> values) {
            addCriterion("customized-companyid in", values, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidNotIn(List<String> values) {
            addCriterion("customized-companyid not in", values, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidBetween(String value1, String value2) {
            addCriterion("customized-companyid between", value1, value2, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyidNotBetween(String value1, String value2) {
            addCriterion("customized-companyid not between", value1, value2, "customizedCompanyid");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyIsNull() {
            addCriterion("customized-company is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyIsNotNull() {
            addCriterion("customized-company is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyEqualTo(String value) {
            addCriterion("customized-company =", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyNotEqualTo(String value) {
            addCriterion("customized-company <>", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyGreaterThan(String value) {
            addCriterion("customized-company >", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("customized-company >=", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyLessThan(String value) {
            addCriterion("customized-company <", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyLessThanOrEqualTo(String value) {
            addCriterion("customized-company <=", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyLike(String value) {
            addCriterion("customized-company like", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyNotLike(String value) {
            addCriterion("customized-company not like", value, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyIn(List<String> values) {
            addCriterion("customized-company in", values, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyNotIn(List<String> values) {
            addCriterion("customized-company not in", values, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyBetween(String value1, String value2) {
            addCriterion("customized-company between", value1, value2, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedCompanyNotBetween(String value1, String value2) {
            addCriterion("customized-company not between", value1, value2, "customizedCompany");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidIsNull() {
            addCriterion("customized-positionid is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidIsNotNull() {
            addCriterion("customized-positionid is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidEqualTo(String value) {
            addCriterion("customized-positionid =", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidNotEqualTo(String value) {
            addCriterion("customized-positionid <>", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidGreaterThan(String value) {
            addCriterion("customized-positionid >", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidGreaterThanOrEqualTo(String value) {
            addCriterion("customized-positionid >=", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidLessThan(String value) {
            addCriterion("customized-positionid <", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidLessThanOrEqualTo(String value) {
            addCriterion("customized-positionid <=", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidLike(String value) {
            addCriterion("customized-positionid like", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidNotLike(String value) {
            addCriterion("customized-positionid not like", value, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidIn(List<String> values) {
            addCriterion("customized-positionid in", values, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidNotIn(List<String> values) {
            addCriterion("customized-positionid not in", values, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidBetween(String value1, String value2) {
            addCriterion("customized-positionid between", value1, value2, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionidNotBetween(String value1, String value2) {
            addCriterion("customized-positionid not between", value1, value2, "customizedPositionid");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameIsNull() {
            addCriterion("customized-positionname is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameIsNotNull() {
            addCriterion("customized-positionname is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameEqualTo(String value) {
            addCriterion("customized-positionname =", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameNotEqualTo(String value) {
            addCriterion("customized-positionname <>", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameGreaterThan(String value) {
            addCriterion("customized-positionname >", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameGreaterThanOrEqualTo(String value) {
            addCriterion("customized-positionname >=", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameLessThan(String value) {
            addCriterion("customized-positionname <", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameLessThanOrEqualTo(String value) {
            addCriterion("customized-positionname <=", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameLike(String value) {
            addCriterion("customized-positionname like", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameNotLike(String value) {
            addCriterion("customized-positionname not like", value, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameIn(List<String> values) {
            addCriterion("customized-positionname in", values, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameNotIn(List<String> values) {
            addCriterion("customized-positionname not in", values, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameBetween(String value1, String value2) {
            addCriterion("customized-positionname between", value1, value2, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedPositionnameNotBetween(String value1, String value2) {
            addCriterion("customized-positionname not between", value1, value2, "customizedPositionname");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateIsNull() {
            addCriterion("customized-joinsysdate is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateIsNotNull() {
            addCriterion("customized-joinsysdate is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateEqualTo(String value) {
            addCriterion("customized-joinsysdate =", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateNotEqualTo(String value) {
            addCriterion("customized-joinsysdate <>", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateGreaterThan(String value) {
            addCriterion("customized-joinsysdate >", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateGreaterThanOrEqualTo(String value) {
            addCriterion("customized-joinsysdate >=", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateLessThan(String value) {
            addCriterion("customized-joinsysdate <", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateLessThanOrEqualTo(String value) {
            addCriterion("customized-joinsysdate <=", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateLike(String value) {
            addCriterion("customized-joinsysdate like", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateNotLike(String value) {
            addCriterion("customized-joinsysdate not like", value, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateIn(List<String> values) {
            addCriterion("customized-joinsysdate in", values, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateNotIn(List<String> values) {
            addCriterion("customized-joinsysdate not in", values, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateBetween(String value1, String value2) {
            addCriterion("customized-joinsysdate between", value1, value2, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedJoinsysdateNotBetween(String value1, String value2) {
            addCriterion("customized-joinsysdate not between", value1, value2, "customizedJoinsysdate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateIsNull() {
            addCriterion("customized-outdutydate is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateIsNotNull() {
            addCriterion("customized-outdutydate is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateEqualTo(String value) {
            addCriterion("customized-outdutydate =", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateNotEqualTo(String value) {
            addCriterion("customized-outdutydate <>", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateGreaterThan(String value) {
            addCriterion("customized-outdutydate >", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateGreaterThanOrEqualTo(String value) {
            addCriterion("customized-outdutydate >=", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateLessThan(String value) {
            addCriterion("customized-outdutydate <", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateLessThanOrEqualTo(String value) {
            addCriterion("customized-outdutydate <=", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateLike(String value) {
            addCriterion("customized-outdutydate like", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateNotLike(String value) {
            addCriterion("customized-outdutydate not like", value, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateIn(List<String> values) {
            addCriterion("customized-outdutydate in", values, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateNotIn(List<String> values) {
            addCriterion("customized-outdutydate not in", values, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateBetween(String value1, String value2) {
            addCriterion("customized-outdutydate between", value1, value2, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedOutdutydateNotBetween(String value1, String value2) {
            addCriterion("customized-outdutydate not between", value1, value2, "customizedOutdutydate");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorIsNull() {
            addCriterion("customized-creator is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorIsNotNull() {
            addCriterion("customized-creator is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorEqualTo(String value) {
            addCriterion("customized-creator =", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorNotEqualTo(String value) {
            addCriterion("customized-creator <>", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorGreaterThan(String value) {
            addCriterion("customized-creator >", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("customized-creator >=", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorLessThan(String value) {
            addCriterion("customized-creator <", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorLessThanOrEqualTo(String value) {
            addCriterion("customized-creator <=", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorLike(String value) {
            addCriterion("customized-creator like", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorNotLike(String value) {
            addCriterion("customized-creator not like", value, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorIn(List<String> values) {
            addCriterion("customized-creator in", values, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorNotIn(List<String> values) {
            addCriterion("customized-creator not in", values, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorBetween(String value1, String value2) {
            addCriterion("customized-creator between", value1, value2, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedCreatorNotBetween(String value1, String value2) {
            addCriterion("customized-creator not between", value1, value2, "customizedCreator");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierIsNull() {
            addCriterion("customized-modifier is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierIsNotNull() {
            addCriterion("customized-modifier is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierEqualTo(String value) {
            addCriterion("customized-modifier =", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierNotEqualTo(String value) {
            addCriterion("customized-modifier <>", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierGreaterThan(String value) {
            addCriterion("customized-modifier >", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierGreaterThanOrEqualTo(String value) {
            addCriterion("customized-modifier >=", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierLessThan(String value) {
            addCriterion("customized-modifier <", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierLessThanOrEqualTo(String value) {
            addCriterion("customized-modifier <=", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierLike(String value) {
            addCriterion("customized-modifier like", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierNotLike(String value) {
            addCriterion("customized-modifier not like", value, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierIn(List<String> values) {
            addCriterion("customized-modifier in", values, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierNotIn(List<String> values) {
            addCriterion("customized-modifier not in", values, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierBetween(String value1, String value2) {
            addCriterion("customized-modifier between", value1, value2, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedModifierNotBetween(String value1, String value2) {
            addCriterion("customized-modifier not between", value1, value2, "customizedModifier");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeIsNull() {
            addCriterion("customized-updatetype is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeIsNotNull() {
            addCriterion("customized-updatetype is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeEqualTo(String value) {
            addCriterion("customized-updatetype =", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeNotEqualTo(String value) {
            addCriterion("customized-updatetype <>", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeGreaterThan(String value) {
            addCriterion("customized-updatetype >", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("customized-updatetype >=", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeLessThan(String value) {
            addCriterion("customized-updatetype <", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeLessThanOrEqualTo(String value) {
            addCriterion("customized-updatetype <=", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeLike(String value) {
            addCriterion("customized-updatetype like", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeNotLike(String value) {
            addCriterion("customized-updatetype not like", value, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeIn(List<String> values) {
            addCriterion("customized-updatetype in", values, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeNotIn(List<String> values) {
            addCriterion("customized-updatetype not in", values, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeBetween(String value1, String value2) {
            addCriterion("customized-updatetype between", value1, value2, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andCustomizedUpdatetypeNotBetween(String value1, String value2) {
            addCriterion("customized-updatetype not between", value1, value2, "customizedUpdatetype");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesIsNull() {
            addCriterion("smart-sources is null");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesIsNotNull() {
            addCriterion("smart-sources is not null");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesEqualTo(String value) {
            addCriterion("smart-sources =", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesNotEqualTo(String value) {
            addCriterion("smart-sources <>", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesGreaterThan(String value) {
            addCriterion("smart-sources >", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesGreaterThanOrEqualTo(String value) {
            addCriterion("smart-sources >=", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesLessThan(String value) {
            addCriterion("smart-sources <", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesLessThanOrEqualTo(String value) {
            addCriterion("smart-sources <=", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesLike(String value) {
            addCriterion("smart-sources like", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesNotLike(String value) {
            addCriterion("smart-sources not like", value, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesIn(List<String> values) {
            addCriterion("smart-sources in", values, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesNotIn(List<String> values) {
            addCriterion("smart-sources not in", values, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesBetween(String value1, String value2) {
            addCriterion("smart-sources between", value1, value2, "smartSources");
            return (Criteria) this;
        }

        public Criteria andSmartSourcesNotBetween(String value1, String value2) {
            addCriterion("smart-sources not between", value1, value2, "smartSources");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2IsNull() {
            addCriterion("customized-reserve2 is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2IsNotNull() {
            addCriterion("customized-reserve2 is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2EqualTo(String value) {
            addCriterion("customized-reserve2 =", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2NotEqualTo(String value) {
            addCriterion("customized-reserve2 <>", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2GreaterThan(String value) {
            addCriterion("customized-reserve2 >", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("customized-reserve2 >=", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2LessThan(String value) {
            addCriterion("customized-reserve2 <", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2LessThanOrEqualTo(String value) {
            addCriterion("customized-reserve2 <=", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2Like(String value) {
            addCriterion("customized-reserve2 like", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2NotLike(String value) {
            addCriterion("customized-reserve2 not like", value, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2In(List<String> values) {
            addCriterion("customized-reserve2 in", values, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2NotIn(List<String> values) {
            addCriterion("customized-reserve2 not in", values, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2Between(String value1, String value2) {
            addCriterion("customized-reserve2 between", value1, value2, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve2NotBetween(String value1, String value2) {
            addCriterion("customized-reserve2 not between", value1, value2, "customizedReserve2");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3IsNull() {
            addCriterion("customized-reserve3 is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3IsNotNull() {
            addCriterion("customized-reserve3 is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3EqualTo(String value) {
            addCriterion("customized-reserve3 =", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3NotEqualTo(String value) {
            addCriterion("customized-reserve3 <>", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3GreaterThan(String value) {
            addCriterion("customized-reserve3 >", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("customized-reserve3 >=", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3LessThan(String value) {
            addCriterion("customized-reserve3 <", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3LessThanOrEqualTo(String value) {
            addCriterion("customized-reserve3 <=", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3Like(String value) {
            addCriterion("customized-reserve3 like", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3NotLike(String value) {
            addCriterion("customized-reserve3 not like", value, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3In(List<String> values) {
            addCriterion("customized-reserve3 in", values, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3NotIn(List<String> values) {
            addCriterion("customized-reserve3 not in", values, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3Between(String value1, String value2) {
            addCriterion("customized-reserve3 between", value1, value2, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve3NotBetween(String value1, String value2) {
            addCriterion("customized-reserve3 not between", value1, value2, "customizedReserve3");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4IsNull() {
            addCriterion("customized-reserve4 is null");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4IsNotNull() {
            addCriterion("customized-reserve4 is not null");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4EqualTo(String value) {
            addCriterion("customized-reserve4 =", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4NotEqualTo(String value) {
            addCriterion("customized-reserve4 <>", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4GreaterThan(String value) {
            addCriterion("customized-reserve4 >", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4GreaterThanOrEqualTo(String value) {
            addCriterion("customized-reserve4 >=", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4LessThan(String value) {
            addCriterion("customized-reserve4 <", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4LessThanOrEqualTo(String value) {
            addCriterion("customized-reserve4 <=", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4Like(String value) {
            addCriterion("customized-reserve4 like", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4NotLike(String value) {
            addCriterion("customized-reserve4 not like", value, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4In(List<String> values) {
            addCriterion("customized-reserve4 in", values, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4NotIn(List<String> values) {
            addCriterion("customized-reserve4 not in", values, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4Between(String value1, String value2) {
            addCriterion("customized-reserve4 between", value1, value2, "customizedReserve4");
            return (Criteria) this;
        }

        public Criteria andCustomizedReserve4NotBetween(String value1, String value2) {
            addCriterion("customized-reserve4 not between", value1, value2, "customizedReserve4");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andUidLikeInsensitive(String value) {
            addCriterion("upper(uid) like", value.toUpperCase(), "uid");
            return this;
        }

        public Criteria andSmartAliasLikeInsensitive(String value) {
            addCriterion("upper(smart-alias) like", value.toUpperCase(), "smartAlias");
            return this;
        }

        public Criteria andCnLikeInsensitive(String value) {
            addCriterion("upper(cn) like", value.toUpperCase(), "cn");
            return this;
        }

        public Criteria andEmployeenumberLikeInsensitive(String value) {
            addCriterion("upper(employeenumber) like", value.toUpperCase(), "employeenumber");
            return this;
        }

        public Criteria andDepartmentnumberLikeInsensitive(String value) {
            addCriterion("upper(departmentnumber) like", value.toUpperCase(), "departmentnumber");
            return this;
        }

        public Criteria andDepartmentnameLikeInsensitive(String value) {
            addCriterion("upper(departmentname) like", value.toUpperCase(), "departmentname");
            return this;
        }

        public Criteria andMailLikeInsensitive(String value) {
            addCriterion("upper(mail) like", value.toUpperCase(), "mail");
            return this;
        }

        public Criteria andUserpasswordLikeInsensitive(String value) {
            addCriterion("upper(userpassword) like", value.toUpperCase(), "userpassword");
            return this;
        }

        public Criteria andSmartIdcardnumberLikeInsensitive(String value) {
            addCriterion("upper(smart-idcardnumber) like", value.toUpperCase(), "smartIdcardnumber");
            return this;
        }

        public Criteria andSmartIdcardtypeLikeInsensitive(String value) {
            addCriterion("upper(smart-idcardtype) like", value.toUpperCase(), "smartIdcardtype");
            return this;
        }

        public Criteria andSmartGenderLikeInsensitive(String value) {
            addCriterion("upper(smart-gender) like", value.toUpperCase(), "smartGender");
            return this;
        }

        public Criteria andSmartBirthdayLikeInsensitive(String value) {
            addCriterion("upper(smart-birthday) like", value.toUpperCase(), "smartBirthday");
            return this;
        }

        public Criteria andSmartTypeLikeInsensitive(String value) {
            addCriterion("upper(smart-type) like", value.toUpperCase(), "smartType");
            return this;
        }

        public Criteria andSmartStatusLikeInsensitive(String value) {
            addCriterion("upper(smart-status) like", value.toUpperCase(), "smartStatus");
            return this;
        }

        public Criteria andSmartParttimedeptLikeInsensitive(String value) {
            addCriterion("upper(smart-parttimedept) like", value.toUpperCase(), "smartParttimedept");
            return this;
        }

        public Criteria andSmartParttimepostLikeInsensitive(String value) {
            addCriterion("upper(smart-parttimepost) like", value.toUpperCase(), "smartParttimepost");
            return this;
        }

        public Criteria andSmartSecuremobileLikeInsensitive(String value) {
            addCriterion("upper(smart-securemobile) like", value.toUpperCase(), "smartSecuremobile");
            return this;
        }

        public Criteria andSmartAuthorityLikeInsensitive(String value) {
            addCriterion("upper(smart-authority) like", value.toUpperCase(), "smartAuthority");
            return this;
        }

        public Criteria andCreatetimestampLikeInsensitive(String value) {
            addCriterion("upper(createTimestamp) like", value.toUpperCase(), "createtimestamp");
            return this;
        }

        public Criteria andModifytimestampLikeInsensitive(String value) {
            addCriterion("upper(modifyTimestamp) like", value.toUpperCase(), "modifytimestamp");
            return this;
        }

        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("upper(mobile) like", value.toUpperCase(), "mobile");
            return this;
        }

        public Criteria andTelephonenumberLikeInsensitive(String value) {
            addCriterion("upper(telephoneNumber) like", value.toUpperCase(), "telephonenumber");
            return this;
        }

        public Criteria andFacsimiletelephonenumberLikeInsensitive(String value) {
            addCriterion("upper(facsimileTelephoneNumber) like", value.toUpperCase(), "facsimiletelephonenumber");
            return this;
        }

        public Criteria andPostaladdressLikeInsensitive(String value) {
            addCriterion("upper(postalAddress) like", value.toUpperCase(), "postaladdress");
            return this;
        }

        public Criteria andPostalcodeLikeInsensitive(String value) {
            addCriterion("upper(postalCode) like", value.toUpperCase(), "postalcode");
            return this;
        }

        public Criteria andHomephoneLikeInsensitive(String value) {
            addCriterion("upper(homephone) like", value.toUpperCase(), "homephone");
            return this;
        }

        public Criteria andHomepostaladdressLikeInsensitive(String value) {
            addCriterion("upper(homePostalAddress) like", value.toUpperCase(), "homepostaladdress");
            return this;
        }

        public Criteria andManagerLikeInsensitive(String value) {
            addCriterion("upper(manager) like", value.toUpperCase(), "manager");
            return this;
        }

        public Criteria andSmartOrderLikeInsensitive(String value) {
            addCriterion("upper(smart-order) like", value.toUpperCase(), "smartOrder");
            return this;
        }

        public Criteria andDsPwpAccountExpirationTimeLikeInsensitive(String value) {
            addCriterion("upper(ds-pwp-account-expiration-time) like", value.toUpperCase(), "dsPwpAccountExpirationTime");
            return this;
        }

        public Criteria andDsPwpPasswordExpirationTimeLikeInsensitive(String value) {
            addCriterion("upper(ds-pwp-password-expiration-time) like", value.toUpperCase(), "dsPwpPasswordExpirationTime");
            return this;
        }

        public Criteria andDsPwpAccountDisabledLikeInsensitive(String value) {
            addCriterion("upper(ds-pwp-account-disabled) like", value.toUpperCase(), "dsPwpAccountDisabled");
            return this;
        }

        public Criteria andCustomizedCompanyidLikeInsensitive(String value) {
            addCriterion("upper(customized-companyid) like", value.toUpperCase(), "customizedCompanyid");
            return this;
        }

        public Criteria andCustomizedCompanyLikeInsensitive(String value) {
            addCriterion("upper(customized-company) like", value.toUpperCase(), "customizedCompany");
            return this;
        }

        public Criteria andCustomizedPositionidLikeInsensitive(String value) {
            addCriterion("upper(customized-positionid) like", value.toUpperCase(), "customizedPositionid");
            return this;
        }

        public Criteria andCustomizedPositionnameLikeInsensitive(String value) {
            addCriterion("upper(customized-positionname) like", value.toUpperCase(), "customizedPositionname");
            return this;
        }

        public Criteria andCustomizedJoinsysdateLikeInsensitive(String value) {
            addCriterion("upper(customized-joinsysdate) like", value.toUpperCase(), "customizedJoinsysdate");
            return this;
        }

        public Criteria andCustomizedOutdutydateLikeInsensitive(String value) {
            addCriterion("upper(customized-outdutydate) like", value.toUpperCase(), "customizedOutdutydate");
            return this;
        }

        public Criteria andCustomizedCreatorLikeInsensitive(String value) {
            addCriterion("upper(customized-creator) like", value.toUpperCase(), "customizedCreator");
            return this;
        }

        public Criteria andCustomizedModifierLikeInsensitive(String value) {
            addCriterion("upper(customized-modifier) like", value.toUpperCase(), "customizedModifier");
            return this;
        }

        public Criteria andCustomizedUpdatetypeLikeInsensitive(String value) {
            addCriterion("upper(customized-updatetype) like", value.toUpperCase(), "customizedUpdatetype");
            return this;
        }

        public Criteria andSmartSourcesLikeInsensitive(String value) {
            addCriterion("upper(smart-sources) like", value.toUpperCase(), "smartSources");
            return this;
        }

        public Criteria andCustomizedReserve2LikeInsensitive(String value) {
            addCriterion("upper(customized-reserve2) like", value.toUpperCase(), "customizedReserve2");
            return this;
        }

        public Criteria andCustomizedReserve3LikeInsensitive(String value) {
            addCriterion("upper(customized-reserve3) like", value.toUpperCase(), "customizedReserve3");
            return this;
        }

        public Criteria andCustomizedReserve4LikeInsensitive(String value) {
            addCriterion("upper(customized-reserve4) like", value.toUpperCase(), "customizedReserve4");
            return this;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}