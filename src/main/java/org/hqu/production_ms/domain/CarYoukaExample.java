package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarYoukaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarYoukaExample() {
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

        public Criteria andYoukaIdIsNull() {
            addCriterion("youka_id is null");
            return (Criteria) this;
        }

        public Criteria andYoukaIdIsNotNull() {
            addCriterion("youka_id is not null");
            return (Criteria) this;
        }

        public Criteria andYoukaIdEqualTo(Integer value) {
            addCriterion("youka_id =", value, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdNotEqualTo(Integer value) {
            addCriterion("youka_id <>", value, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdGreaterThan(Integer value) {
            addCriterion("youka_id >", value, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("youka_id >=", value, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdLessThan(Integer value) {
            addCriterion("youka_id <", value, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdLessThanOrEqualTo(Integer value) {
            addCriterion("youka_id <=", value, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdIn(List<Integer> values) {
            addCriterion("youka_id in", values, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdNotIn(List<Integer> values) {
            addCriterion("youka_id not in", values, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdBetween(Integer value1, Integer value2) {
            addCriterion("youka_id between", value1, value2, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYoukaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("youka_id not between", value1, value2, "youkaId");
            return (Criteria) this;
        }

        public Criteria andYouIdIsNull() {
            addCriterion("you_id is null");
            return (Criteria) this;
        }

        public Criteria andYouIdIsNotNull() {
            addCriterion("you_id is not null");
            return (Criteria) this;
        }

        public Criteria andYouIdEqualTo(Integer value) {
            addCriterion("you_id =", value, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdNotEqualTo(Integer value) {
            addCriterion("you_id <>", value, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdGreaterThan(Integer value) {
            addCriterion("you_id >", value, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("you_id >=", value, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdLessThan(Integer value) {
            addCriterion("you_id <", value, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdLessThanOrEqualTo(Integer value) {
            addCriterion("you_id <=", value, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdIn(List<Integer> values) {
            addCriterion("you_id in", values, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdNotIn(List<Integer> values) {
            addCriterion("you_id not in", values, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdBetween(Integer value1, Integer value2) {
            addCriterion("you_id between", value1, value2, "youId");
            return (Criteria) this;
        }

        public Criteria andYouIdNotBetween(Integer value1, Integer value2) {
            addCriterion("you_id not between", value1, value2, "youId");
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

        public Criteria andYongyouIsNull() {
            addCriterion("yongyou is null");
            return (Criteria) this;
        }

        public Criteria andYongyouIsNotNull() {
            addCriterion("yongyou is not null");
            return (Criteria) this;
        }

        public Criteria andYongyouEqualTo(BigDecimal value) {
            addCriterion("yongyou =", value, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouNotEqualTo(BigDecimal value) {
            addCriterion("yongyou <>", value, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouGreaterThan(BigDecimal value) {
            addCriterion("yongyou >", value, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yongyou >=", value, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouLessThan(BigDecimal value) {
            addCriterion("yongyou <", value, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yongyou <=", value, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouIn(List<BigDecimal> values) {
            addCriterion("yongyou in", values, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouNotIn(List<BigDecimal> values) {
            addCriterion("yongyou not in", values, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yongyou between", value1, value2, "yongyou");
            return (Criteria) this;
        }

        public Criteria andYongyouNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yongyou not between", value1, value2, "yongyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouIsNull() {
            addCriterion("totlyou is null");
            return (Criteria) this;
        }

        public Criteria andTotlyouIsNotNull() {
            addCriterion("totlyou is not null");
            return (Criteria) this;
        }

        public Criteria andTotlyouEqualTo(BigDecimal value) {
            addCriterion("totlyou =", value, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouNotEqualTo(BigDecimal value) {
            addCriterion("totlyou <>", value, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouGreaterThan(BigDecimal value) {
            addCriterion("totlyou >", value, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totlyou >=", value, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouLessThan(BigDecimal value) {
            addCriterion("totlyou <", value, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totlyou <=", value, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouIn(List<BigDecimal> values) {
            addCriterion("totlyou in", values, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouNotIn(List<BigDecimal> values) {
            addCriterion("totlyou not in", values, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totlyou between", value1, value2, "totlyou");
            return (Criteria) this;
        }

        public Criteria andTotlyouNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totlyou not between", value1, value2, "totlyou");
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

        public Criteria andBeiyong1EqualTo(Date value) {
            addCriterion("beiyong1 =", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotEqualTo(Date value) {
            addCriterion("beiyong1 <>", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1GreaterThan(Date value) {
            addCriterion("beiyong1 >", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1GreaterThanOrEqualTo(Date value) {
            addCriterion("beiyong1 >=", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1LessThan(Date value) {
            addCriterion("beiyong1 <", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1LessThanOrEqualTo(Date value) {
            addCriterion("beiyong1 <=", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1Like(Date value) {
            addCriterion("beiyong1 like", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotLike(Date value) {
            addCriterion("beiyong1 not like", value, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1In(List<Date> values) {
            addCriterion("beiyong1 in", values, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotIn(List<Date> values) {
            addCriterion("beiyong1 not in", values, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1Between(Date value1, Date value2) {
            addCriterion("beiyong1 between", value1, value2, "beiyong1");
            return (Criteria) this;
        }

        public Criteria andBeiyong1NotBetween(Date value1, Date value2) {
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