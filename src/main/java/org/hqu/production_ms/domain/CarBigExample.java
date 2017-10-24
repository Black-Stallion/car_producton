package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarBigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarBigExample() {
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

        public Criteria andBigIdIsNull() {
            addCriterion("big_id is null");
            return (Criteria) this;
        }

        public Criteria andBigIdIsNotNull() {
            addCriterion("big_id is not null");
            return (Criteria) this;
        }

        public Criteria andBigIdEqualTo(Integer value) {
            addCriterion("big_id =", value, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdNotEqualTo(Integer value) {
            addCriterion("big_id <>", value, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdGreaterThan(Integer value) {
            addCriterion("big_id >", value, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("big_id >=", value, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdLessThan(Integer value) {
            addCriterion("big_id <", value, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdLessThanOrEqualTo(Integer value) {
            addCriterion("big_id <=", value, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdIn(List<Integer> values) {
            addCriterion("big_id in", values, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdNotIn(List<Integer> values) {
            addCriterion("big_id not in", values, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdBetween(Integer value1, Integer value2) {
            addCriterion("big_id between", value1, value2, "bigId");
            return (Criteria) this;
        }

        public Criteria andBigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("big_id not between", value1, value2, "bigId");
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

        public Criteria andBigcarnumIsNull() {
            addCriterion("bigcarnum is null");
            return (Criteria) this;
        }

        public Criteria andBigcarnumIsNotNull() {
            addCriterion("bigcarnum is not null");
            return (Criteria) this;
        }

        public Criteria andBigcarnumEqualTo(String value) {
            addCriterion("bigcarnum =", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumNotEqualTo(String value) {
            addCriterion("bigcarnum <>", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumGreaterThan(String value) {
            addCriterion("bigcarnum >", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumGreaterThanOrEqualTo(String value) {
            addCriterion("bigcarnum >=", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumLessThan(String value) {
            addCriterion("bigcarnum <", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumLessThanOrEqualTo(String value) {
            addCriterion("bigcarnum <=", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumLike(String value) {
            addCriterion("bigcarnum like", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumNotLike(String value) {
            addCriterion("bigcarnum not like", value, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumIn(List<String> values) {
            addCriterion("bigcarnum in", values, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumNotIn(List<String> values) {
            addCriterion("bigcarnum not in", values, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumBetween(String value1, String value2) {
            addCriterion("bigcarnum between", value1, value2, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andBigcarnumNotBetween(String value1, String value2) {
            addCriterion("bigcarnum not between", value1, value2, "bigcarnum");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNull() {
            addCriterion("drivername is null");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNotNull() {
            addCriterion("drivername is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernameEqualTo(String value) {
            addCriterion("drivername =", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotEqualTo(String value) {
            addCriterion("drivername <>", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThan(String value) {
            addCriterion("drivername >", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThanOrEqualTo(String value) {
            addCriterion("drivername >=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThan(String value) {
            addCriterion("drivername <", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThanOrEqualTo(String value) {
            addCriterion("drivername <=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLike(String value) {
            addCriterion("drivername like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotLike(String value) {
            addCriterion("drivername not like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameIn(List<String> values) {
            addCriterion("drivername in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotIn(List<String> values) {
            addCriterion("drivername not in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameBetween(String value1, String value2) {
            addCriterion("drivername between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotBetween(String value1, String value2) {
            addCriterion("drivername not between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andChangedateIsNull() {
            addCriterion("changeDate is null");
            return (Criteria) this;
        }

        public Criteria andChangedateIsNotNull() {
            addCriterion("changeDate is not null");
            return (Criteria) this;
        }

        public Criteria andChangedateEqualTo(Date value) {
            addCriterion("changeDate =", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateNotEqualTo(Date value) {
            addCriterion("changeDate <>", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateGreaterThan(Date value) {
            addCriterion("changeDate >", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateGreaterThanOrEqualTo(Date value) {
            addCriterion("changeDate >=", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateLessThan(Date value) {
            addCriterion("changeDate <", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateLessThanOrEqualTo(Date value) {
            addCriterion("changeDate <=", value, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateIn(List<Date> values) {
            addCriterion("changeDate in", values, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateNotIn(List<Date> values) {
            addCriterion("changeDate not in", values, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateBetween(Date value1, Date value2) {
            addCriterion("changeDate between", value1, value2, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangedateNotBetween(Date value1, Date value2) {
            addCriterion("changeDate not between", value1, value2, "changedate");
            return (Criteria) this;
        }

        public Criteria andChangbigIsNull() {
            addCriterion("changbig is null");
            return (Criteria) this;
        }

        public Criteria andChangbigIsNotNull() {
            addCriterion("changbig is not null");
            return (Criteria) this;
        }

        public Criteria andChangbigEqualTo(String value) {
            addCriterion("changbig =", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigNotEqualTo(String value) {
            addCriterion("changbig <>", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigGreaterThan(String value) {
            addCriterion("changbig >", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigGreaterThanOrEqualTo(String value) {
            addCriterion("changbig >=", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigLessThan(String value) {
            addCriterion("changbig <", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigLessThanOrEqualTo(String value) {
            addCriterion("changbig <=", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigLike(String value) {
            addCriterion("changbig like", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigNotLike(String value) {
            addCriterion("changbig not like", value, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigIn(List<String> values) {
            addCriterion("changbig in", values, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigNotIn(List<String> values) {
            addCriterion("changbig not in", values, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigBetween(String value1, String value2) {
            addCriterion("changbig between", value1, value2, "changbig");
            return (Criteria) this;
        }

        public Criteria andChangbigNotBetween(String value1, String value2) {
            addCriterion("changbig not between", value1, value2, "changbig");
            return (Criteria) this;
        }

        public Criteria andWhyIsNull() {
            addCriterion("why is null");
            return (Criteria) this;
        }

        public Criteria andWhyIsNotNull() {
            addCriterion("why is not null");
            return (Criteria) this;
        }

        public Criteria andWhyEqualTo(String value) {
            addCriterion("why =", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyNotEqualTo(String value) {
            addCriterion("why <>", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyGreaterThan(String value) {
            addCriterion("why >", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyGreaterThanOrEqualTo(String value) {
            addCriterion("why >=", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyLessThan(String value) {
            addCriterion("why <", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyLessThanOrEqualTo(String value) {
            addCriterion("why <=", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyLike(String value) {
            addCriterion("why like", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyNotLike(String value) {
            addCriterion("why not like", value, "why");
            return (Criteria) this;
        }

        public Criteria andWhyIn(List<String> values) {
            addCriterion("why in", values, "why");
            return (Criteria) this;
        }

        public Criteria andWhyNotIn(List<String> values) {
            addCriterion("why not in", values, "why");
            return (Criteria) this;
        }

        public Criteria andWhyBetween(String value1, String value2) {
            addCriterion("why between", value1, value2, "why");
            return (Criteria) this;
        }

        public Criteria andWhyNotBetween(String value1, String value2) {
            addCriterion("why not between", value1, value2, "why");
            return (Criteria) this;
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