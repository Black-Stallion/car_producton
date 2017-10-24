package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarMoneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarMoneyExample() {
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

        public Criteria andMoneyIdIsNull() {
            addCriterion("money_id is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIdIsNotNull() {
            addCriterion("money_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyIdEqualTo(Integer value) {
            addCriterion("money_id =", value, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdNotEqualTo(Integer value) {
            addCriterion("money_id <>", value, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdGreaterThan(Integer value) {
            addCriterion("money_id >", value, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_id >=", value, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdLessThan(Integer value) {
            addCriterion("money_id <", value, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdLessThanOrEqualTo(Integer value) {
            addCriterion("money_id <=", value, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdIn(List<Integer> values) {
            addCriterion("money_id in", values, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdNotIn(List<Integer> values) {
            addCriterion("money_id not in", values, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdBetween(Integer value1, Integer value2) {
            addCriterion("money_id between", value1, value2, "moneyId");
            return (Criteria) this;
        }

        public Criteria andMoneyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("money_id not between", value1, value2, "moneyId");
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

        public Criteria andDatatimeIsNull() {
            addCriterion("datatime is null");
            return (Criteria) this;
        }

        public Criteria andDatatimeIsNotNull() {
            addCriterion("datatime is not null");
            return (Criteria) this;
        }

        public Criteria andDatatimeEqualTo(Date value) {
            addCriterionForJDBCDate("datatime =", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("datatime <>", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThan(Date value) {
            addCriterionForJDBCDate("datatime >", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("datatime >=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThan(Date value) {
            addCriterionForJDBCDate("datatime <", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("datatime <=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeIn(List<Date> values) {
            addCriterionForJDBCDate("datatime in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("datatime not in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("datatime between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("datatime not between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameIsNull() {
            addCriterion("depatmentname is null");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameIsNotNull() {
            addCriterion("depatmentname is not null");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameEqualTo(String value) {
            addCriterion("depatmentname =", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameNotEqualTo(String value) {
            addCriterion("depatmentname <>", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameGreaterThan(String value) {
            addCriterion("depatmentname >", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameGreaterThanOrEqualTo(String value) {
            addCriterion("depatmentname >=", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameLessThan(String value) {
            addCriterion("depatmentname <", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameLessThanOrEqualTo(String value) {
            addCriterion("depatmentname <=", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameLike(String value) {
            addCriterion("depatmentname like", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameNotLike(String value) {
            addCriterion("depatmentname not like", value, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameIn(List<String> values) {
            addCriterion("depatmentname in", values, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameNotIn(List<String> values) {
            addCriterion("depatmentname not in", values, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameBetween(String value1, String value2) {
            addCriterion("depatmentname between", value1, value2, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andDepatmentnameNotBetween(String value1, String value2) {
            addCriterion("depatmentname not between", value1, value2, "depatmentname");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andB1IsNull() {
            addCriterion("b1 is null");
            return (Criteria) this;
        }

        public Criteria andB1IsNotNull() {
            addCriterion("b1 is not null");
            return (Criteria) this;
        }

        public Criteria andB1EqualTo(String value) {
            addCriterion("b1 =", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotEqualTo(String value) {
            addCriterion("b1 <>", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1GreaterThan(String value) {
            addCriterion("b1 >", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1GreaterThanOrEqualTo(String value) {
            addCriterion("b1 >=", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1LessThan(String value) {
            addCriterion("b1 <", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1LessThanOrEqualTo(String value) {
            addCriterion("b1 <=", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1Like(String value) {
            addCriterion("b1 like", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotLike(String value) {
            addCriterion("b1 not like", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1In(List<String> values) {
            addCriterion("b1 in", values, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotIn(List<String> values) {
            addCriterion("b1 not in", values, "b1");
            return (Criteria) this;
        }

        public Criteria andB1Between(String value1, String value2) {
            addCriterion("b1 between", value1, value2, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotBetween(String value1, String value2) {
            addCriterion("b1 not between", value1, value2, "b1");
            return (Criteria) this;
        }

        public Criteria andB2IsNull() {
            addCriterion("b2 is null");
            return (Criteria) this;
        }

        public Criteria andB2IsNotNull() {
            addCriterion("b2 is not null");
            return (Criteria) this;
        }

        public Criteria andB2EqualTo(String value) {
            addCriterion("b2 =", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotEqualTo(String value) {
            addCriterion("b2 <>", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2GreaterThan(String value) {
            addCriterion("b2 >", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2GreaterThanOrEqualTo(String value) {
            addCriterion("b2 >=", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2LessThan(String value) {
            addCriterion("b2 <", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2LessThanOrEqualTo(String value) {
            addCriterion("b2 <=", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2Like(String value) {
            addCriterion("b2 like", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotLike(String value) {
            addCriterion("b2 not like", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2In(List<String> values) {
            addCriterion("b2 in", values, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotIn(List<String> values) {
            addCriterion("b2 not in", values, "b2");
            return (Criteria) this;
        }

        public Criteria andB2Between(String value1, String value2) {
            addCriterion("b2 between", value1, value2, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotBetween(String value1, String value2) {
            addCriterion("b2 not between", value1, value2, "b2");
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