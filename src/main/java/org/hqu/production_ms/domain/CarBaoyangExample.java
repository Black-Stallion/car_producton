package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarBaoyangExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarBaoyangExample() {
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

        public Criteria andBaoyangIdIsNull() {
            addCriterion("baoyang_id is null");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdIsNotNull() {
            addCriterion("baoyang_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdEqualTo(Integer value) {
            addCriterion("baoyang_id =", value, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdNotEqualTo(Integer value) {
            addCriterion("baoyang_id <>", value, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdGreaterThan(Integer value) {
            addCriterion("baoyang_id >", value, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("baoyang_id >=", value, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdLessThan(Integer value) {
            addCriterion("baoyang_id <", value, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdLessThanOrEqualTo(Integer value) {
            addCriterion("baoyang_id <=", value, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdIn(List<Integer> values) {
            addCriterion("baoyang_id in", values, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdNotIn(List<Integer> values) {
            addCriterion("baoyang_id not in", values, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdBetween(Integer value1, Integer value2) {
            addCriterion("baoyang_id between", value1, value2, "baoyangId");
            return (Criteria) this;
        }

        public Criteria andBaoyangIdNotBetween(Integer value1, Integer value2) {
            addCriterion("baoyang_id not between", value1, value2, "baoyangId");
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

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andBeiy1IsNull() {
            addCriterion("beiy1 is null");
            return (Criteria) this;
        }

        public Criteria andBeiy1IsNotNull() {
            addCriterion("beiy1 is not null");
            return (Criteria) this;
        }

        public Criteria andBeiy1EqualTo(String value) {
            addCriterion("beiy1 =", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1NotEqualTo(String value) {
            addCriterion("beiy1 <>", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1GreaterThan(String value) {
            addCriterion("beiy1 >", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1GreaterThanOrEqualTo(String value) {
            addCriterion("beiy1 >=", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1LessThan(String value) {
            addCriterion("beiy1 <", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1LessThanOrEqualTo(String value) {
            addCriterion("beiy1 <=", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1Like(String value) {
            addCriterion("beiy1 like", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1NotLike(String value) {
            addCriterion("beiy1 not like", value, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1In(List<String> values) {
            addCriterion("beiy1 in", values, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1NotIn(List<String> values) {
            addCriterion("beiy1 not in", values, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1Between(String value1, String value2) {
            addCriterion("beiy1 between", value1, value2, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy1NotBetween(String value1, String value2) {
            addCriterion("beiy1 not between", value1, value2, "beiy1");
            return (Criteria) this;
        }

        public Criteria andBeiy2IsNull() {
            addCriterion("beiy2 is null");
            return (Criteria) this;
        }

        public Criteria andBeiy2IsNotNull() {
            addCriterion("beiy2 is not null");
            return (Criteria) this;
        }

        public Criteria andBeiy2EqualTo(String value) {
            addCriterion("beiy2 =", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2NotEqualTo(String value) {
            addCriterion("beiy2 <>", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2GreaterThan(String value) {
            addCriterion("beiy2 >", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2GreaterThanOrEqualTo(String value) {
            addCriterion("beiy2 >=", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2LessThan(String value) {
            addCriterion("beiy2 <", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2LessThanOrEqualTo(String value) {
            addCriterion("beiy2 <=", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2Like(String value) {
            addCriterion("beiy2 like", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2NotLike(String value) {
            addCriterion("beiy2 not like", value, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2In(List<String> values) {
            addCriterion("beiy2 in", values, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2NotIn(List<String> values) {
            addCriterion("beiy2 not in", values, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2Between(String value1, String value2) {
            addCriterion("beiy2 between", value1, value2, "beiy2");
            return (Criteria) this;
        }

        public Criteria andBeiy2NotBetween(String value1, String value2) {
            addCriterion("beiy2 not between", value1, value2, "beiy2");
            return (Criteria) this;
        }

        public Criteria andLmIsNull() {
            addCriterion("lm is null");
            return (Criteria) this;
        }

        public Criteria andLmIsNotNull() {
            addCriterion("lm is not null");
            return (Criteria) this;
        }

        public Criteria andLmEqualTo(BigDecimal value) {
            addCriterion("lm =", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotEqualTo(BigDecimal value) {
            addCriterion("lm <>", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmGreaterThan(BigDecimal value) {
            addCriterion("lm >", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lm >=", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLessThan(BigDecimal value) {
            addCriterion("lm <", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lm <=", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLike(BigDecimal value) {
            addCriterion("lm like", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotLike(BigDecimal value) {
            addCriterion("lm not like", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmIn(List<BigDecimal> values) {
            addCriterion("lm in", values, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotIn(List<BigDecimal> values) {
            addCriterion("lm not in", values, "lm");
            return (Criteria) this;
        }

        public Criteria andLmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lm between", value1, value2, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lm not between", value1, value2, "lm");
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