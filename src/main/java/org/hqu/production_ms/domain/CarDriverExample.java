package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarDriverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarDriverExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDriverIdIsNull() {
            addCriterion("driver_id is null");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNotNull() {
            addCriterion("driver_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriverIdEqualTo(Integer value) {
            addCriterion("driver_id =", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotEqualTo(Integer value) {
            addCriterion("driver_id <>", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThan(Integer value) {
            addCriterion("driver_id >", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_id >=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThan(Integer value) {
            addCriterion("driver_id <", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThanOrEqualTo(Integer value) {
            addCriterion("driver_id <=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdIn(List<Integer> values) {
            addCriterion("driver_id in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotIn(List<Integer> values) {
            addCriterion("driver_id not in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdBetween(Integer value1, Integer value2) {
            addCriterion("driver_id between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_id not between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andDrviernameIsNull() {
            addCriterion("drvierName is null");
            return (Criteria) this;
        }

        public Criteria andDrviernameIsNotNull() {
            addCriterion("drvierName is not null");
            return (Criteria) this;
        }

        public Criteria andDrviernameEqualTo(String value) {
            addCriterion("drvierName =", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameNotEqualTo(String value) {
            addCriterion("drvierName <>", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameGreaterThan(String value) {
            addCriterion("drvierName >", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameGreaterThanOrEqualTo(String value) {
            addCriterion("drvierName >=", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameLessThan(String value) {
            addCriterion("drvierName <", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameLessThanOrEqualTo(String value) {
            addCriterion("drvierName <=", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameLike(String value) {
            addCriterion("drvierName like", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameNotLike(String value) {
            addCriterion("drvierName not like", value, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameIn(List<String> values) {
            addCriterion("drvierName in", values, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameNotIn(List<String> values) {
            addCriterion("drvierName not in", values, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameBetween(String value1, String value2) {
            addCriterion("drvierName between", value1, value2, "drviername");
            return (Criteria) this;
        }

        public Criteria andDrviernameNotBetween(String value1, String value2) {
            addCriterion("drvierName not between", value1, value2, "drviername");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andCultureIsNull() {
            addCriterion("culture is null");
            return (Criteria) this;
        }

        public Criteria andCultureIsNotNull() {
            addCriterion("culture is not null");
            return (Criteria) this;
        }

        public Criteria andCultureEqualTo(String value) {
            addCriterion("culture =", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureNotEqualTo(String value) {
            addCriterion("culture <>", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureGreaterThan(String value) {
            addCriterion("culture >", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureGreaterThanOrEqualTo(String value) {
            addCriterion("culture >=", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureLessThan(String value) {
            addCriterion("culture <", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureLessThanOrEqualTo(String value) {
            addCriterion("culture <=", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureLike(String value) {
            addCriterion("culture like", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureNotLike(String value) {
            addCriterion("culture not like", value, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureIn(List<String> values) {
            addCriterion("culture in", values, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureNotIn(List<String> values) {
            addCriterion("culture not in", values, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureBetween(String value1, String value2) {
            addCriterion("culture between", value1, value2, "culture");
            return (Criteria) this;
        }

        public Criteria andCultureNotBetween(String value1, String value2) {
            addCriterion("culture not between", value1, value2, "culture");
            return (Criteria) this;
        }

        public Criteria andDrivernumIsNull() {
            addCriterion("driverNum is null");
            return (Criteria) this;
        }

        public Criteria andDrivernumIsNotNull() {
            addCriterion("driverNum is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernumEqualTo(String value) {
            addCriterion("driverNum =", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotEqualTo(String value) {
            addCriterion("driverNum <>", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumGreaterThan(String value) {
            addCriterion("driverNum >", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumGreaterThanOrEqualTo(String value) {
            addCriterion("driverNum >=", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumLessThan(String value) {
            addCriterion("driverNum <", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumLessThanOrEqualTo(String value) {
            addCriterion("driverNum <=", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumLike(String value) {
            addCriterion("driverNum like", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotLike(String value) {
            addCriterion("driverNum not like", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumIn(List<String> values) {
            addCriterion("driverNum in", values, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotIn(List<String> values) {
            addCriterion("driverNum not in", values, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumBetween(String value1, String value2) {
            addCriterion("driverNum between", value1, value2, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotBetween(String value1, String value2) {
            addCriterion("driverNum not between", value1, value2, "drivernum");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNull() {
            addCriterion("workTime is null");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNotNull() {
            addCriterion("workTime is not null");
            return (Criteria) this;
        }

        public Criteria andWorktimeEqualTo(Date value) {
            addCriterionForJDBCDate("workTime =", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("workTime <>", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThan(Date value) {
            addCriterionForJDBCDate("workTime >", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workTime >=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThan(Date value) {
            addCriterionForJDBCDate("workTime <", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workTime <=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeIn(List<Date> values) {
            addCriterionForJDBCDate("workTime in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("workTime not in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workTime between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workTime not between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andFirstzhengIsNull() {
            addCriterion("firstZheng is null");
            return (Criteria) this;
        }

        public Criteria andFirstzhengIsNotNull() {
            addCriterion("firstZheng is not null");
            return (Criteria) this;
        }

        public Criteria andFirstzhengEqualTo(String value) {
            addCriterion("firstZheng =", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengNotEqualTo(String value) {
            addCriterion("firstZheng <>", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengGreaterThan(String value) {
            addCriterion("firstZheng >", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengGreaterThanOrEqualTo(String value) {
            addCriterion("firstZheng >=", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengLessThan(String value) {
            addCriterion("firstZheng <", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengLessThanOrEqualTo(String value) {
            addCriterion("firstZheng <=", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengLike(String value) {
            addCriterion("firstZheng like", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengNotLike(String value) {
            addCriterion("firstZheng not like", value, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengIn(List<String> values) {
            addCriterion("firstZheng in", values, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengNotIn(List<String> values) {
            addCriterion("firstZheng not in", values, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengBetween(String value1, String value2) {
            addCriterion("firstZheng between", value1, value2, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andFirstzhengNotBetween(String value1, String value2) {
            addCriterion("firstZheng not between", value1, value2, "firstzheng");
            return (Criteria) this;
        }

        public Criteria andIssueorganIsNull() {
            addCriterion("issueOrgan is null");
            return (Criteria) this;
        }

        public Criteria andIssueorganIsNotNull() {
            addCriterion("issueOrgan is not null");
            return (Criteria) this;
        }

        public Criteria andIssueorganEqualTo(String value) {
            addCriterion("issueOrgan =", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotEqualTo(String value) {
            addCriterion("issueOrgan <>", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganGreaterThan(String value) {
            addCriterion("issueOrgan >", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganGreaterThanOrEqualTo(String value) {
            addCriterion("issueOrgan >=", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganLessThan(String value) {
            addCriterion("issueOrgan <", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganLessThanOrEqualTo(String value) {
            addCriterion("issueOrgan <=", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganLike(String value) {
            addCriterion("issueOrgan like", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotLike(String value) {
            addCriterion("issueOrgan not like", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganIn(List<String> values) {
            addCriterion("issueOrgan in", values, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotIn(List<String> values) {
            addCriterion("issueOrgan not in", values, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganBetween(String value1, String value2) {
            addCriterion("issueOrgan between", value1, value2, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotBetween(String value1, String value2) {
            addCriterion("issueOrgan not between", value1, value2, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeId <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andCartypeIsNull() {
            addCriterion("carType is null");
            return (Criteria) this;
        }

        public Criteria andCartypeIsNotNull() {
            addCriterion("carType is not null");
            return (Criteria) this;
        }

        public Criteria andCartypeEqualTo(String value) {
            addCriterion("carType =", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotEqualTo(String value) {
            addCriterion("carType <>", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThan(String value) {
            addCriterion("carType >", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThanOrEqualTo(String value) {
            addCriterion("carType >=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThan(String value) {
            addCriterion("carType <", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThanOrEqualTo(String value) {
            addCriterion("carType <=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLike(String value) {
            addCriterion("carType like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotLike(String value) {
            addCriterion("carType not like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeIn(List<String> values) {
            addCriterion("carType in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotIn(List<String> values) {
            addCriterion("carType not in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeBetween(String value1, String value2) {
            addCriterion("carType between", value1, value2, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotBetween(String value1, String value2) {
            addCriterion("carType not between", value1, value2, "cartype");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andChecktimeIsNull() {
            addCriterion("checktime is null");
            return (Criteria) this;
        }

        public Criteria andChecktimeIsNotNull() {
            addCriterion("checktime is not null");
            return (Criteria) this;
        }

        public Criteria andChecktimeEqualTo(Date value) {
            addCriterionForJDBCDate("checktime =", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("checktime <>", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeGreaterThan(Date value) {
            addCriterionForJDBCDate("checktime >", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("checktime >=", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeLessThan(Date value) {
            addCriterionForJDBCDate("checktime <", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("checktime <=", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeIn(List<Date> values) {
            addCriterionForJDBCDate("checktime in", values, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("checktime not in", values, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("checktime between", value1, value2, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("checktime not between", value1, value2, "checktime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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