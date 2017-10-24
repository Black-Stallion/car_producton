package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarFoldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarFoldExample() {
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

        public Criteria andFoldIdIsNull() {
            addCriterion("fold_id is null");
            return (Criteria) this;
        }

        public Criteria andFoldIdIsNotNull() {
            addCriterion("fold_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoldIdEqualTo(Integer value) {
            addCriterion("fold_id =", value, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdNotEqualTo(Integer value) {
            addCriterion("fold_id <>", value, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdGreaterThan(Integer value) {
            addCriterion("fold_id >", value, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fold_id >=", value, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdLessThan(Integer value) {
            addCriterion("fold_id <", value, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdLessThanOrEqualTo(Integer value) {
            addCriterion("fold_id <=", value, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdIn(List<Integer> values) {
            addCriterion("fold_id in", values, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdNotIn(List<Integer> values) {
            addCriterion("fold_id not in", values, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdBetween(Integer value1, Integer value2) {
            addCriterion("fold_id between", value1, value2, "foldId");
            return (Criteria) this;
        }

        public Criteria andFoldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fold_id not between", value1, value2, "foldId");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andFoldIsNull() {
            addCriterion("fold is null");
            return (Criteria) this;
        }

        public Criteria andFoldIsNotNull() {
            addCriterion("fold is not null");
            return (Criteria) this;
        }

        public Criteria andFoldEqualTo(String value) {
            addCriterion("fold =", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldNotEqualTo(String value) {
            addCriterion("fold <>", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldGreaterThan(String value) {
            addCriterion("fold >", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldGreaterThanOrEqualTo(String value) {
            addCriterion("fold >=", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldLessThan(String value) {
            addCriterion("fold <", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldLessThanOrEqualTo(String value) {
            addCriterion("fold <=", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldLike(String value) {
            addCriterion("fold like", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldNotLike(String value) {
            addCriterion("fold not like", value, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldIn(List<String> values) {
            addCriterion("fold in", values, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldNotIn(List<String> values) {
            addCriterion("fold not in", values, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldBetween(String value1, String value2) {
            addCriterion("fold between", value1, value2, "fold");
            return (Criteria) this;
        }

        public Criteria andFoldNotBetween(String value1, String value2) {
            addCriterion("fold not between", value1, value2, "fold");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNull() {
            addCriterion("datetime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("datetime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterion("datetime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterion("datetime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterion("datetime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("datetime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterion("datetime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("datetime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterion("datetime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterion("datetime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterion("datetime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("datetime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
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

        public Criteria andBei2IsNull() {
            addCriterion("bei2 is null");
            return (Criteria) this;
        }

        public Criteria andBei2IsNotNull() {
            addCriterion("bei2 is not null");
            return (Criteria) this;
        }

        public Criteria andBei2EqualTo(String value) {
            addCriterion("bei2 =", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotEqualTo(String value) {
            addCriterion("bei2 <>", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2GreaterThan(String value) {
            addCriterion("bei2 >", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2GreaterThanOrEqualTo(String value) {
            addCriterion("bei2 >=", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2LessThan(String value) {
            addCriterion("bei2 <", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2LessThanOrEqualTo(String value) {
            addCriterion("bei2 <=", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2Like(String value) {
            addCriterion("bei2 like", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotLike(String value) {
            addCriterion("bei2 not like", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2In(List<String> values) {
            addCriterion("bei2 in", values, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotIn(List<String> values) {
            addCriterion("bei2 not in", values, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2Between(String value1, String value2) {
            addCriterion("bei2 between", value1, value2, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotBetween(String value1, String value2) {
            addCriterion("bei2 not between", value1, value2, "bei2");
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