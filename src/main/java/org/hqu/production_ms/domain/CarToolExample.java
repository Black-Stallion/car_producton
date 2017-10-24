package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.List;

public class CarToolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarToolExample() {
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

        public Criteria andToolIdIsNull() {
            addCriterion("tool_id is null");
            return (Criteria) this;
        }

        public Criteria andToolIdIsNotNull() {
            addCriterion("tool_id is not null");
            return (Criteria) this;
        }

        public Criteria andToolIdEqualTo(Integer value) {
            addCriterion("tool_id =", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdNotEqualTo(Integer value) {
            addCriterion("tool_id <>", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdGreaterThan(Integer value) {
            addCriterion("tool_id >", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tool_id >=", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdLessThan(Integer value) {
            addCriterion("tool_id <", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdLessThanOrEqualTo(Integer value) {
            addCriterion("tool_id <=", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdIn(List<Integer> values) {
            addCriterion("tool_id in", values, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdNotIn(List<Integer> values) {
            addCriterion("tool_id not in", values, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdBetween(Integer value1, Integer value2) {
            addCriterion("tool_id between", value1, value2, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tool_id not between", value1, value2, "toolId");
            return (Criteria) this;
        }

        public Criteria andNormsIsNull() {
            addCriterion("norms is null");
            return (Criteria) this;
        }

        public Criteria andNormsIsNotNull() {
            addCriterion("norms is not null");
            return (Criteria) this;
        }

        public Criteria andNormsEqualTo(String value) {
            addCriterion("norms =", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsNotEqualTo(String value) {
            addCriterion("norms <>", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsGreaterThan(String value) {
            addCriterion("norms >", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsGreaterThanOrEqualTo(String value) {
            addCriterion("norms >=", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsLessThan(String value) {
            addCriterion("norms <", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsLessThanOrEqualTo(String value) {
            addCriterion("norms <=", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsLike(String value) {
            addCriterion("norms like", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsNotLike(String value) {
            addCriterion("norms not like", value, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsIn(List<String> values) {
            addCriterion("norms in", values, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsNotIn(List<String> values) {
            addCriterion("norms not in", values, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsBetween(String value1, String value2) {
            addCriterion("norms between", value1, value2, "norms");
            return (Criteria) this;
        }

        public Criteria andNormsNotBetween(String value1, String value2) {
            addCriterion("norms not between", value1, value2, "norms");
            return (Criteria) this;
        }

        public Criteria andNumsIsNull() {
            addCriterion("nums is null");
            return (Criteria) this;
        }

        public Criteria andNumsIsNotNull() {
            addCriterion("nums is not null");
            return (Criteria) this;
        }

        public Criteria andNumsEqualTo(String value) {
            addCriterion("nums =", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotEqualTo(String value) {
            addCriterion("nums <>", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThan(String value) {
            addCriterion("nums >", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThanOrEqualTo(String value) {
            addCriterion("nums >=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThan(String value) {
            addCriterion("nums <", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThanOrEqualTo(String value) {
            addCriterion("nums <=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLike(String value) {
            addCriterion("nums like", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotLike(String value) {
            addCriterion("nums not like", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsIn(List<String> values) {
            addCriterion("nums in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotIn(List<String> values) {
            addCriterion("nums not in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsBetween(String value1, String value2) {
            addCriterion("nums between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotBetween(String value1, String value2) {
            addCriterion("nums not between", value1, value2, "nums");
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

        public Criteria andToolnameIsNull() {
            addCriterion("toolname is null");
            return (Criteria) this;
        }

        public Criteria andToolnameIsNotNull() {
            addCriterion("toolname is not null");
            return (Criteria) this;
        }

        public Criteria andToolnameEqualTo(String value) {
            addCriterion("toolname =", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameNotEqualTo(String value) {
            addCriterion("toolname <>", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameGreaterThan(String value) {
            addCriterion("toolname >", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameGreaterThanOrEqualTo(String value) {
            addCriterion("toolname >=", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameLessThan(String value) {
            addCriterion("toolname <", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameLessThanOrEqualTo(String value) {
            addCriterion("toolname <=", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameLike(String value) {
            addCriterion("toolname like", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameNotLike(String value) {
            addCriterion("toolname not like", value, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameIn(List<String> values) {
            addCriterion("toolname in", values, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameNotIn(List<String> values) {
            addCriterion("toolname not in", values, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameBetween(String value1, String value2) {
            addCriterion("toolname between", value1, value2, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolnameNotBetween(String value1, String value2) {
            addCriterion("toolname not between", value1, value2, "toolname");
            return (Criteria) this;
        }

        public Criteria andToolzjIsNull() {
            addCriterion("toolzj is null");
            return (Criteria) this;
        }

        public Criteria andToolzjIsNotNull() {
            addCriterion("toolzj is not null");
            return (Criteria) this;
        }

        public Criteria andToolzjEqualTo(String value) {
            addCriterion("toolzj =", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjNotEqualTo(String value) {
            addCriterion("toolzj <>", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjGreaterThan(String value) {
            addCriterion("toolzj >", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjGreaterThanOrEqualTo(String value) {
            addCriterion("toolzj >=", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjLessThan(String value) {
            addCriterion("toolzj <", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjLessThanOrEqualTo(String value) {
            addCriterion("toolzj <=", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjLike(String value) {
            addCriterion("toolzj like", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjNotLike(String value) {
            addCriterion("toolzj not like", value, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjIn(List<String> values) {
            addCriterion("toolzj in", values, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjNotIn(List<String> values) {
            addCriterion("toolzj not in", values, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjBetween(String value1, String value2) {
            addCriterion("toolzj between", value1, value2, "toolzj");
            return (Criteria) this;
        }

        public Criteria andToolzjNotBetween(String value1, String value2) {
            addCriterion("toolzj not between", value1, value2, "toolzj");
            return (Criteria) this;
        }

        public Criteria andNums1IsNull() {
            addCriterion("nums1 is null");
            return (Criteria) this;
        }

        public Criteria andNums1IsNotNull() {
            addCriterion("nums1 is not null");
            return (Criteria) this;
        }

        public Criteria andNums1EqualTo(String value) {
            addCriterion("nums1 =", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1NotEqualTo(String value) {
            addCriterion("nums1 <>", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1GreaterThan(String value) {
            addCriterion("nums1 >", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1GreaterThanOrEqualTo(String value) {
            addCriterion("nums1 >=", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1LessThan(String value) {
            addCriterion("nums1 <", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1LessThanOrEqualTo(String value) {
            addCriterion("nums1 <=", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1Like(String value) {
            addCriterion("nums1 like", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1NotLike(String value) {
            addCriterion("nums1 not like", value, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1In(List<String> values) {
            addCriterion("nums1 in", values, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1NotIn(List<String> values) {
            addCriterion("nums1 not in", values, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1Between(String value1, String value2) {
            addCriterion("nums1 between", value1, value2, "nums1");
            return (Criteria) this;
        }

        public Criteria andNums1NotBetween(String value1, String value2) {
            addCriterion("nums1 not between", value1, value2, "nums1");
            return (Criteria) this;
        }

        public Criteria andNotes1IsNull() {
            addCriterion("notes1 is null");
            return (Criteria) this;
        }

        public Criteria andNotes1IsNotNull() {
            addCriterion("notes1 is not null");
            return (Criteria) this;
        }

        public Criteria andNotes1EqualTo(String value) {
            addCriterion("notes1 =", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1NotEqualTo(String value) {
            addCriterion("notes1 <>", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1GreaterThan(String value) {
            addCriterion("notes1 >", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1GreaterThanOrEqualTo(String value) {
            addCriterion("notes1 >=", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1LessThan(String value) {
            addCriterion("notes1 <", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1LessThanOrEqualTo(String value) {
            addCriterion("notes1 <=", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1Like(String value) {
            addCriterion("notes1 like", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1NotLike(String value) {
            addCriterion("notes1 not like", value, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1In(List<String> values) {
            addCriterion("notes1 in", values, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1NotIn(List<String> values) {
            addCriterion("notes1 not in", values, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1Between(String value1, String value2) {
            addCriterion("notes1 between", value1, value2, "notes1");
            return (Criteria) this;
        }

        public Criteria andNotes1NotBetween(String value1, String value2) {
            addCriterion("notes1 not between", value1, value2, "notes1");
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