package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarWEExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarWEExample() {
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

        public Criteria andCarnumberIsNull() {
            addCriterion("carnumber is null");
            return (Criteria) this;
        }

        public Criteria andCarnumberIsNotNull() {
            addCriterion("carnumber is not null");
            return (Criteria) this;
        }

        public Criteria andCarnumberEqualTo(String value) {
            addCriterion("carnumber =", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotEqualTo(String value) {
            addCriterion("carnumber <>", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThan(String value) {
            addCriterion("carnumber >", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThanOrEqualTo(String value) {
            addCriterion("carnumber >=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThan(String value) {
            addCriterion("carnumber <", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThanOrEqualTo(String value) {
            addCriterion("carnumber <=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLike(String value) {
            addCriterion("carnumber like", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotLike(String value) {
            addCriterion("carnumber not like", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberIn(List<String> values) {
            addCriterion("carnumber in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotIn(List<String> values) {
            addCriterion("carnumber not in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberBetween(String value1, String value2) {
            addCriterion("carnumber between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotBetween(String value1, String value2) {
            addCriterion("carnumber not between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andKkk1IsNull() {
            addCriterion("kkk1 is null");
            return (Criteria) this;
        }

        public Criteria andKkk1IsNotNull() {
            addCriterion("kkk1 is not null");
            return (Criteria) this;
        }

        public Criteria andKkk1EqualTo(Double value) {
            addCriterion("kkk1 =", value, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1NotEqualTo(Double value) {
            addCriterion("kkk1 <>", value, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1GreaterThan(Double value) {
            addCriterion("kkk1 >", value, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1GreaterThanOrEqualTo(Double value) {
            addCriterion("kkk1 >=", value, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1LessThan(Double value) {
            addCriterion("kkk1 <", value, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1LessThanOrEqualTo(Double value) {
            addCriterion("kkk1 <=", value, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1In(List<Double> values) {
            addCriterion("kkk1 in", values, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1NotIn(List<Double> values) {
            addCriterion("kkk1 not in", values, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1Between(Double value1, Double value2) {
            addCriterion("kkk1 between", value1, value2, "kkk1");
            return (Criteria) this;
        }

        public Criteria andKkk1NotBetween(Double value1, Double value2) {
            addCriterion("kkk1 not between", value1, value2, "kkk1");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNull() {
            addCriterion("send_id is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("send_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(Integer value) {
            addCriterion("send_id =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(Integer value) {
            addCriterion("send_id <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(Integer value) {
            addCriterion("send_id >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_id >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(Integer value) {
            addCriterion("send_id <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_id <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<Integer> values) {
            addCriterion("send_id in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<Integer> values) {
            addCriterion("send_id not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(Integer value1, Integer value2) {
            addCriterion("send_id between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_id not between", value1, value2, "sendId");
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

        public Criteria andFatherdepIsNull() {
            addCriterion("fatherdep is null");
            return (Criteria) this;
        }

        public Criteria andFatherdepIsNotNull() {
            addCriterion("fatherdep is not null");
            return (Criteria) this;
        }

        public Criteria andFatherdepEqualTo(String value) {
            addCriterion("fatherdep =", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepNotEqualTo(String value) {
            addCriterion("fatherdep <>", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepGreaterThan(String value) {
            addCriterion("fatherdep >", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepGreaterThanOrEqualTo(String value) {
            addCriterion("fatherdep >=", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepLessThan(String value) {
            addCriterion("fatherdep <", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepLessThanOrEqualTo(String value) {
            addCriterion("fatherdep <=", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepLike(String value) {
            addCriterion("fatherdep like", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepNotLike(String value) {
            addCriterion("fatherdep not like", value, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepIn(List<String> values) {
            addCriterion("fatherdep in", values, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepNotIn(List<String> values) {
            addCriterion("fatherdep not in", values, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepBetween(String value1, String value2) {
            addCriterion("fatherdep between", value1, value2, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andFatherdepNotBetween(String value1, String value2) {
            addCriterion("fatherdep not between", value1, value2, "fatherdep");
            return (Criteria) this;
        }

        public Criteria andSenddateIsNull() {
            addCriterion("sendDate is null");
            return (Criteria) this;
        }

        public Criteria andSenddateIsNotNull() {
            addCriterion("sendDate is not null");
            return (Criteria) this;
        }

        public Criteria andSenddateEqualTo(Date value) {
            addCriterion("sendDate =", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotEqualTo(Date value) {
            addCriterion("sendDate <>", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThan(Date value) {
            addCriterion("sendDate >", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("sendDate >=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThan(Date value) {
            addCriterion("sendDate <", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThanOrEqualTo(Date value) {
            addCriterion("sendDate <=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateIn(List<Date> values) {
            addCriterion("sendDate in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotIn(List<Date> values) {
            addCriterion("sendDate not in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateBetween(Date value1, Date value2) {
            addCriterion("sendDate between", value1, value2, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotBetween(Date value1, Date value2) {
            addCriterion("sendDate not between", value1, value2, "senddate");
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