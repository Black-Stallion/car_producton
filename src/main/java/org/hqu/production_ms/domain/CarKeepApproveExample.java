package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarKeepApproveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarKeepApproveExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Integer value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Integer value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Integer value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Integer value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<Integer> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<Integer> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterion("startDate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterion("startDate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterion("startDate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("startDate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterion("startDate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterion("startDate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterion("startDate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterion("startDate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterion("startDate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterion("startDate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("endDate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("endDate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("endDate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("endDate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("endDate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("endDate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("endDate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("endDate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("endDate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("endDate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andIntervalkmIsNull() {
            addCriterion("intervalKM is null");
            return (Criteria) this;
        }

        public Criteria andIntervalkmIsNotNull() {
            addCriterion("intervalKM is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalkmEqualTo(String value) {
            addCriterion("intervalKM =", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmNotEqualTo(String value) {
            addCriterion("intervalKM <>", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmGreaterThan(String value) {
            addCriterion("intervalKM >", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmGreaterThanOrEqualTo(String value) {
            addCriterion("intervalKM >=", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmLessThan(String value) {
            addCriterion("intervalKM <", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmLessThanOrEqualTo(String value) {
            addCriterion("intervalKM <=", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmLike(String value) {
            addCriterion("intervalKM like", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmNotLike(String value) {
            addCriterion("intervalKM not like", value, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmIn(List<String> values) {
            addCriterion("intervalKM in", values, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmNotIn(List<String> values) {
            addCriterion("intervalKM not in", values, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmBetween(String value1, String value2) {
            addCriterion("intervalKM between", value1, value2, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andIntervalkmNotBetween(String value1, String value2) {
            addCriterion("intervalKM not between", value1, value2, "intervalkm");
            return (Criteria) this;
        }

        public Criteria andRepairtypeIsNull() {
            addCriterion("repairType is null");
            return (Criteria) this;
        }

        public Criteria andRepairtypeIsNotNull() {
            addCriterion("repairType is not null");
            return (Criteria) this;
        }

        public Criteria andRepairtypeEqualTo(String value) {
            addCriterion("repairType =", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeNotEqualTo(String value) {
            addCriterion("repairType <>", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeGreaterThan(String value) {
            addCriterion("repairType >", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeGreaterThanOrEqualTo(String value) {
            addCriterion("repairType >=", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeLessThan(String value) {
            addCriterion("repairType <", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeLessThanOrEqualTo(String value) {
            addCriterion("repairType <=", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeLike(String value) {
            addCriterion("repairType like", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeNotLike(String value) {
            addCriterion("repairType not like", value, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeIn(List<String> values) {
            addCriterion("repairType in", values, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeNotIn(List<String> values) {
            addCriterion("repairType not in", values, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeBetween(String value1, String value2) {
            addCriterion("repairType between", value1, value2, "repairtype");
            return (Criteria) this;
        }

        public Criteria andRepairtypeNotBetween(String value1, String value2) {
            addCriterion("repairType not between", value1, value2, "repairtype");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIsNull() {
            addCriterion("supplierName is null");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIsNotNull() {
            addCriterion("supplierName is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliernameEqualTo(String value) {
            addCriterion("supplierName =", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotEqualTo(String value) {
            addCriterion("supplierName <>", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameGreaterThan(String value) {
            addCriterion("supplierName >", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameGreaterThanOrEqualTo(String value) {
            addCriterion("supplierName >=", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLessThan(String value) {
            addCriterion("supplierName <", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLessThanOrEqualTo(String value) {
            addCriterion("supplierName <=", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLike(String value) {
            addCriterion("supplierName like", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotLike(String value) {
            addCriterion("supplierName not like", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIn(List<String> values) {
            addCriterion("supplierName in", values, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotIn(List<String> values) {
            addCriterion("supplierName not in", values, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameBetween(String value1, String value2) {
            addCriterion("supplierName between", value1, value2, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotBetween(String value1, String value2) {
            addCriterion("supplierName not between", value1, value2, "suppliername");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarnumIsNull() {
            addCriterion("carnum is null");
            return (Criteria) this;
        }

        public Criteria andCarnumIsNotNull() {
            addCriterion("carnum is not null");
            return (Criteria) this;
        }

        public Criteria andCarnumEqualTo(String value) {
            addCriterion("carnum =", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotEqualTo(String value) {
            addCriterion("carnum <>", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumGreaterThan(String value) {
            addCriterion("carnum >", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumGreaterThanOrEqualTo(String value) {
            addCriterion("carnum >=", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumLessThan(String value) {
            addCriterion("carnum <", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumLessThanOrEqualTo(String value) {
            addCriterion("carnum <=", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumLike(String value) {
            addCriterion("carnum like", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotLike(String value) {
            addCriterion("carnum not like", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumIn(List<String> values) {
            addCriterion("carnum in", values, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotIn(List<String> values) {
            addCriterion("carnum not in", values, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumBetween(String value1, String value2) {
            addCriterion("carnum between", value1, value2, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotBetween(String value1, String value2) {
            addCriterion("carnum not between", value1, value2, "carnum");
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

        public Criteria andStatsIsNull() {
            addCriterion("stats is null");
            return (Criteria) this;
        }

        public Criteria andStatsIsNotNull() {
            addCriterion("stats is not null");
            return (Criteria) this;
        }

        public Criteria andStatsEqualTo(String value) {
            addCriterion("stats =", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotEqualTo(String value) {
            addCriterion("stats <>", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsGreaterThan(String value) {
            addCriterion("stats >", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsGreaterThanOrEqualTo(String value) {
            addCriterion("stats >=", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLessThan(String value) {
            addCriterion("stats <", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLessThanOrEqualTo(String value) {
            addCriterion("stats <=", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLike(String value) {
            addCriterion("stats like", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotLike(String value) {
            addCriterion("stats not like", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsIn(List<String> values) {
            addCriterion("stats in", values, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotIn(List<String> values) {
            addCriterion("stats not in", values, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsBetween(String value1, String value2) {
            addCriterion("stats between", value1, value2, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotBetween(String value1, String value2) {
            addCriterion("stats not between", value1, value2, "stats");
            return (Criteria) this;
        }

        public Criteria andApplynameIsNull() {
            addCriterion("applyname is null");
            return (Criteria) this;
        }

        public Criteria andApplynameIsNotNull() {
            addCriterion("applyname is not null");
            return (Criteria) this;
        }

        public Criteria andApplynameEqualTo(String value) {
            addCriterion("applyname =", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameNotEqualTo(String value) {
            addCriterion("applyname <>", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameGreaterThan(String value) {
            addCriterion("applyname >", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameGreaterThanOrEqualTo(String value) {
            addCriterion("applyname >=", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameLessThan(String value) {
            addCriterion("applyname <", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameLessThanOrEqualTo(String value) {
            addCriterion("applyname <=", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameLike(String value) {
            addCriterion("applyname like", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameNotLike(String value) {
            addCriterion("applyname not like", value, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameIn(List<String> values) {
            addCriterion("applyname in", values, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameNotIn(List<String> values) {
            addCriterion("applyname not in", values, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameBetween(String value1, String value2) {
            addCriterion("applyname between", value1, value2, "applyname");
            return (Criteria) this;
        }

        public Criteria andApplynameNotBetween(String value1, String value2) {
            addCriterion("applyname not between", value1, value2, "applyname");
            return (Criteria) this;
        }

        public Criteria andApproveIsNull() {
            addCriterion("approve is null");
            return (Criteria) this;
        }

        public Criteria andApproveIsNotNull() {
            addCriterion("approve is not null");
            return (Criteria) this;
        }

        public Criteria andApproveEqualTo(String value) {
            addCriterion("approve =", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotEqualTo(String value) {
            addCriterion("approve <>", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThan(String value) {
            addCriterion("approve >", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThanOrEqualTo(String value) {
            addCriterion("approve >=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThan(String value) {
            addCriterion("approve <", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThanOrEqualTo(String value) {
            addCriterion("approve <=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLike(String value) {
            addCriterion("approve like", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotLike(String value) {
            addCriterion("approve not like", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveIn(List<String> values) {
            addCriterion("approve in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotIn(List<String> values) {
            addCriterion("approve not in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveBetween(String value1, String value2) {
            addCriterion("approve between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotBetween(String value1, String value2) {
            addCriterion("approve not between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andDepIsNull() {
            addCriterion("dep is null");
            return (Criteria) this;
        }

        public Criteria andDepIsNotNull() {
            addCriterion("dep is not null");
            return (Criteria) this;
        }

        public Criteria andDepEqualTo(String value) {
            addCriterion("dep =", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotEqualTo(String value) {
            addCriterion("dep <>", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepGreaterThan(String value) {
            addCriterion("dep >", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepGreaterThanOrEqualTo(String value) {
            addCriterion("dep >=", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepLessThan(String value) {
            addCriterion("dep <", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepLessThanOrEqualTo(String value) {
            addCriterion("dep <=", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepLike(String value) {
            addCriterion("dep like", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotLike(String value) {
            addCriterion("dep not like", value, "dep");
            return (Criteria) this;
        }

        public Criteria andDepIn(List<String> values) {
            addCriterion("dep in", values, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotIn(List<String> values) {
            addCriterion("dep not in", values, "dep");
            return (Criteria) this;
        }

        public Criteria andDepBetween(String value1, String value2) {
            addCriterion("dep between", value1, value2, "dep");
            return (Criteria) this;
        }

        public Criteria andDepNotBetween(String value1, String value2) {
            addCriterion("dep not between", value1, value2, "dep");
            return (Criteria) this;
        }

        public Criteria andBeiyong1IsNull() {
            addCriterion("beiyong1 is null");
            return (Criteria) this;
        }

        public Criteria andBeiyong1IsNotNull() {
            addCriterion("beiyong1 is not null");
            return (Criteria) this;
        }

        public Criteria andBeiyong1EqualTo(String value) {
            addCriterion("beiyong1 =", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotEqualTo(String value) {
            addCriterion("beiyong1 <>", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1GreaterThan(String value) {
            addCriterion("beiyong1 >", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1GreaterThanOrEqualTo(String value) {
            addCriterion("beiyong1 >=", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1LessThan(String value) {
            addCriterion("beiyong1 <", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1LessThanOrEqualTo(String value) {
            addCriterion("beiyong1 <=", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1Like(String value) {
            addCriterion("beiyong1 like", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotLike(String value) {
            addCriterion("beiyong1 not like", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1In(List<String> values) {
            addCriterion("beiyong1 in", values, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotIn(List<String> values) {
            addCriterion("beiyong1 not in", values, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1Between(String value1, String value2) {
            addCriterion("beiyong1 between", value1, value2, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotBetween(String value1, String value2) {
            addCriterion("beiyong1 not between", value1, value2, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong2IsNull() {
            addCriterion("beiyong2 is null");
            return (Criteria) this;
        }

        public Criteria andBeiyong2IsNotNull() {
            addCriterion("beiyong2 is not null");
            return (Criteria) this;
        }

        public Criteria andBeiyong2EqualTo(String value) {
            addCriterion("beiyong2 =", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2NotEqualTo(String value) {
            addCriterion("beiyong2 <>", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2GreaterThan(String value) {
            addCriterion("beiyong2 >", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2GreaterThanOrEqualTo(String value) {
            addCriterion("beiyong2 >=", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2LessThan(String value) {
            addCriterion("beiyong2 <", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2LessThanOrEqualTo(String value) {
            addCriterion("beiyong2 <=", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2Like(String value) {
            addCriterion("beiyong2 like", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2NotLike(String value) {
            addCriterion("beiyong2 not like", value, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2In(List<String> values) {
            addCriterion("beiyong2 in", values, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2NotIn(List<String> values) {
            addCriterion("beiyong2 not in", values, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2Between(String value1, String value2) {
            addCriterion("beiyong2 between", value1, value2, "beiyong2");
            return (Criteria) this;
        }

        public Criteria andBeiyong2NotBetween(String value1, String value2) {
            addCriterion("beiyong2 not between", value1, value2, "beiyong2");
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