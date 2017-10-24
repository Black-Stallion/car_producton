package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.List;

public class CarBSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarBSExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDdIsNull() {
            addCriterion("dd is null");
            return (Criteria) this;
        }

        public Criteria andDdIsNotNull() {
            addCriterion("dd is not null");
            return (Criteria) this;
        }

        public Criteria andDdEqualTo(Double value) {
            addCriterion("dd =", value, "dd");
            return (Criteria) this;
        }

        public Criteria andDdNotEqualTo(Double value) {
            addCriterion("dd <>", value, "dd");
            return (Criteria) this;
        }

        public Criteria andDdGreaterThan(Double value) {
            addCriterion("dd >", value, "dd");
            return (Criteria) this;
        }

        public Criteria andDdGreaterThanOrEqualTo(Double value) {
            addCriterion("dd >=", value, "dd");
            return (Criteria) this;
        }

        public Criteria andDdLessThan(Double value) {
            addCriterion("dd <", value, "dd");
            return (Criteria) this;
        }

        public Criteria andDdLessThanOrEqualTo(Double value) {
            addCriterion("dd <=", value, "dd");
            return (Criteria) this;
        }

        public Criteria andDdIn(List<Double> values) {
            addCriterion("dd in", values, "dd");
            return (Criteria) this;
        }

        public Criteria andDdNotIn(List<Double> values) {
            addCriterion("dd not in", values, "dd");
            return (Criteria) this;
        }

        public Criteria andDdBetween(Double value1, Double value2) {
            addCriterion("dd between", value1, value2, "dd");
            return (Criteria) this;
        }

        public Criteria andDdNotBetween(Double value1, Double value2) {
            addCriterion("dd not between", value1, value2, "dd");
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

        public Criteria andLmIsNull() {
            addCriterion("lm is null");
            return (Criteria) this;
        }

        public Criteria andLmIsNotNull() {
            addCriterion("lm is not null");
            return (Criteria) this;
        }

        public Criteria andLmEqualTo(String value) {
            addCriterion("lm =", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotEqualTo(String value) {
            addCriterion("lm <>", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmGreaterThan(String value) {
            addCriterion("lm >", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmGreaterThanOrEqualTo(String value) {
            addCriterion("lm >=", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLessThan(String value) {
            addCriterion("lm <", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLessThanOrEqualTo(String value) {
            addCriterion("lm <=", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmLike(String value) {
            addCriterion("lm like", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotLike(String value) {
            addCriterion("lm not like", value, "lm");
            return (Criteria) this;
        }

        public Criteria andLmIn(List<String> values) {
            addCriterion("lm in", values, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotIn(List<String> values) {
            addCriterion("lm not in", values, "lm");
            return (Criteria) this;
        }

        public Criteria andLmBetween(String value1, String value2) {
            addCriterion("lm between", value1, value2, "lm");
            return (Criteria) this;
        }

        public Criteria andLmNotBetween(String value1, String value2) {
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