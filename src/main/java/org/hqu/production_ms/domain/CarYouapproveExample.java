package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarYouapproveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarYouapproveExample() {
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

        public Criteria andYapplyIdIsNull() {
            addCriterion("yapply_id is null");
            return (Criteria) this;
        }

        public Criteria andYapplyIdIsNotNull() {
            addCriterion("yapply_id is not null");
            return (Criteria) this;
        }

        public Criteria andYapplyIdEqualTo(Integer value) {
            addCriterion("yapply_id =", value, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdNotEqualTo(Integer value) {
            addCriterion("yapply_id <>", value, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdGreaterThan(Integer value) {
            addCriterion("yapply_id >", value, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("yapply_id >=", value, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdLessThan(Integer value) {
            addCriterion("yapply_id <", value, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("yapply_id <=", value, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdIn(List<Integer> values) {
            addCriterion("yapply_id in", values, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdNotIn(List<Integer> values) {
            addCriterion("yapply_id not in", values, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdBetween(Integer value1, Integer value2) {
            addCriterion("yapply_id between", value1, value2, "yapplyId");
            return (Criteria) this;
        }

        public Criteria andYapplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("yapply_id not between", value1, value2, "yapplyId");
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

        public Criteria andApprovenameIsNull() {
            addCriterion("approvename is null");
            return (Criteria) this;
        }

        public Criteria andApprovenameIsNotNull() {
            addCriterion("approvename is not null");
            return (Criteria) this;
        }

        public Criteria andApprovenameEqualTo(String value) {
            addCriterion("approvename =", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameNotEqualTo(String value) {
            addCriterion("approvename <>", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameGreaterThan(String value) {
            addCriterion("approvename >", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameGreaterThanOrEqualTo(String value) {
            addCriterion("approvename >=", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameLessThan(String value) {
            addCriterion("approvename <", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameLessThanOrEqualTo(String value) {
            addCriterion("approvename <=", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameLike(String value) {
            addCriterion("approvename like", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameNotLike(String value) {
            addCriterion("approvename not like", value, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameIn(List<String> values) {
            addCriterion("approvename in", values, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameNotIn(List<String> values) {
            addCriterion("approvename not in", values, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameBetween(String value1, String value2) {
            addCriterion("approvename between", value1, value2, "approvename");
            return (Criteria) this;
        }

        public Criteria andApprovenameNotBetween(String value1, String value2) {
            addCriterion("approvename not between", value1, value2, "approvename");
            return (Criteria) this;
        }

        public Criteria andDtimeIsNull() {
            addCriterion("dtime is null");
            return (Criteria) this;
        }

        public Criteria andDtimeIsNotNull() {
            addCriterion("dtime is not null");
            return (Criteria) this;
        }

        public Criteria andDtimeEqualTo(Date value) {
            addCriterion("dtime =", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeNotEqualTo(Date value) {
            addCriterion("dtime <>", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeGreaterThan(Date value) {
            addCriterion("dtime >", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dtime >=", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeLessThan(Date value) {
            addCriterion("dtime <", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeLessThanOrEqualTo(Date value) {
            addCriterion("dtime <=", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeIn(List<Date> values) {
            addCriterion("dtime in", values, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeNotIn(List<Date> values) {
            addCriterion("dtime not in", values, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeBetween(Date value1, Date value2) {
            addCriterion("dtime between", value1, value2, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeNotBetween(Date value1, Date value2) {
            addCriterion("dtime not between", value1, value2, "dtime");
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

        public Criteria andFoldsIsNull() {
            addCriterion("folds is null");
            return (Criteria) this;
        }

        public Criteria andFoldsIsNotNull() {
            addCriterion("folds is not null");
            return (Criteria) this;
        }

        public Criteria andFoldsEqualTo(String value) {
            addCriterion("folds =", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsNotEqualTo(String value) {
            addCriterion("folds <>", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsGreaterThan(String value) {
            addCriterion("folds >", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsGreaterThanOrEqualTo(String value) {
            addCriterion("folds >=", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsLessThan(String value) {
            addCriterion("folds <", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsLessThanOrEqualTo(String value) {
            addCriterion("folds <=", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsLike(String value) {
            addCriterion("folds like", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsNotLike(String value) {
            addCriterion("folds not like", value, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsIn(List<String> values) {
            addCriterion("folds in", values, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsNotIn(List<String> values) {
            addCriterion("folds not in", values, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsBetween(String value1, String value2) {
            addCriterion("folds between", value1, value2, "folds");
            return (Criteria) this;
        }

        public Criteria andFoldsNotBetween(String value1, String value2) {
            addCriterion("folds not between", value1, value2, "folds");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("stat is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("stat is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("stat =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("stat <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("stat >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("stat >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("stat <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("stat <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("stat like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("stat not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("stat in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("stat not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("stat between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("stat not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andBeiIsNull() {
            addCriterion("bei is null");
            return (Criteria) this;
        }

        public Criteria andBeiIsNotNull() {
            addCriterion("bei is not null");
            return (Criteria) this;
        }

        public Criteria andBeiEqualTo(String value) {
            addCriterion("bei =", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotEqualTo(String value) {
            addCriterion("bei <>", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiGreaterThan(String value) {
            addCriterion("bei >", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiGreaterThanOrEqualTo(String value) {
            addCriterion("bei >=", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiLessThan(String value) {
            addCriterion("bei <", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiLessThanOrEqualTo(String value) {
            addCriterion("bei <=", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiLike(String value) {
            addCriterion("bei like", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotLike(String value) {
            addCriterion("bei not like", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiIn(List<String> values) {
            addCriterion("bei in", values, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotIn(List<String> values) {
            addCriterion("bei not in", values, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiBetween(String value1, String value2) {
            addCriterion("bei between", value1, value2, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotBetween(String value1, String value2) {
            addCriterion("bei not between", value1, value2, "bei");
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