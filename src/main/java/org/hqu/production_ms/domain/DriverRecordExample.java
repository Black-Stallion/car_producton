package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DriverRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriverRecordExample() {
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

        public Criteria andDriveRecordIdIsNull() {
            addCriterion("drive_record_id is null");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdIsNotNull() {
            addCriterion("drive_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdEqualTo(Integer value) {
            addCriterion("drive_record_id =", value, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdNotEqualTo(Integer value) {
            addCriterion("drive_record_id <>", value, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdGreaterThan(Integer value) {
            addCriterion("drive_record_id >", value, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("drive_record_id >=", value, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdLessThan(Integer value) {
            addCriterion("drive_record_id <", value, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("drive_record_id <=", value, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdIn(List<Integer> values) {
            addCriterion("drive_record_id in", values, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdNotIn(List<Integer> values) {
            addCriterion("drive_record_id not in", values, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("drive_record_id between", value1, value2, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andDriveRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("drive_record_id not between", value1, value2, "driveRecordId");
            return (Criteria) this;
        }

        public Criteria andKaohetimeIsNull() {
            addCriterion("kaohetime is null");
            return (Criteria) this;
        }

        public Criteria andKaohetimeIsNotNull() {
            addCriterion("kaohetime is not null");
            return (Criteria) this;
        }

        public Criteria andKaohetimeEqualTo(Date value) {
            addCriterion("kaohetime =", value, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeNotEqualTo(Date value) {
            addCriterion("kaohetime <>", value, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeGreaterThan(Date value) {
            addCriterion("kaohetime >", value, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("kaohetime >=", value, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeLessThan(Date value) {
            addCriterion("kaohetime <", value, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeLessThanOrEqualTo(Date value) {
            addCriterion("kaohetime <=", value, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeIn(List<Date> values) {
            addCriterion("kaohetime in", values, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeNotIn(List<Date> values) {
            addCriterion("kaohetime not in", values, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeBetween(Date value1, Date value2) {
            addCriterion("kaohetime between", value1, value2, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andKaohetimeNotBetween(Date value1, Date value2) {
            addCriterion("kaohetime not between", value1, value2, "kaohetime");
            return (Criteria) this;
        }

        public Criteria andDrivernumIsNull() {
            addCriterion("drivernum is null");
            return (Criteria) this;
        }

        public Criteria andDrivernumIsNotNull() {
            addCriterion("drivernum is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernumEqualTo(String value) {
            addCriterion("drivernum =", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotEqualTo(String value) {
            addCriterion("drivernum <>", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumGreaterThan(String value) {
            addCriterion("drivernum >", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumGreaterThanOrEqualTo(String value) {
            addCriterion("drivernum >=", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumLessThan(String value) {
            addCriterion("drivernum <", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumLessThanOrEqualTo(String value) {
            addCriterion("drivernum <=", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumLike(String value) {
            addCriterion("drivernum like", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotLike(String value) {
            addCriterion("drivernum not like", value, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumIn(List<String> values) {
            addCriterion("drivernum in", values, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotIn(List<String> values) {
            addCriterion("drivernum not in", values, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumBetween(String value1, String value2) {
            addCriterion("drivernum between", value1, value2, "drivernum");
            return (Criteria) this;
        }

        public Criteria andDrivernumNotBetween(String value1, String value2) {
            addCriterion("drivernum not between", value1, value2, "drivernum");
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

        public Criteria andDrivernameEqualTo(Integer value) {
            addCriterion("drivername =", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotEqualTo(Integer value) {
            addCriterion("drivername <>", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThan(Integer value) {
            addCriterion("drivername >", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThanOrEqualTo(Integer value) {
            addCriterion("drivername >=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThan(Integer value) {
            addCriterion("drivername <", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThanOrEqualTo(Integer value) {
            addCriterion("drivername <=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameIn(List<Integer> values) {
            addCriterion("drivername in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotIn(List<Integer> values) {
            addCriterion("drivername not in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameBetween(Integer value1, Integer value2) {
            addCriterion("drivername between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotBetween(Integer value1, Integer value2) {
            addCriterion("drivername not between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivestartIsNull() {
            addCriterion("drivestart is null");
            return (Criteria) this;
        }

        public Criteria andDrivestartIsNotNull() {
            addCriterion("drivestart is not null");
            return (Criteria) this;
        }

        public Criteria andDrivestartEqualTo(String value) {
            addCriterion("drivestart =", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartNotEqualTo(String value) {
            addCriterion("drivestart <>", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartGreaterThan(String value) {
            addCriterion("drivestart >", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartGreaterThanOrEqualTo(String value) {
            addCriterion("drivestart >=", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartLessThan(String value) {
            addCriterion("drivestart <", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartLessThanOrEqualTo(String value) {
            addCriterion("drivestart <=", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartLike(String value) {
            addCriterion("drivestart like", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartNotLike(String value) {
            addCriterion("drivestart not like", value, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartIn(List<String> values) {
            addCriterion("drivestart in", values, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartNotIn(List<String> values) {
            addCriterion("drivestart not in", values, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartBetween(String value1, String value2) {
            addCriterion("drivestart between", value1, value2, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDrivestartNotBetween(String value1, String value2) {
            addCriterion("drivestart not between", value1, value2, "drivestart");
            return (Criteria) this;
        }

        public Criteria andDriveendIsNull() {
            addCriterion("driveend is null");
            return (Criteria) this;
        }

        public Criteria andDriveendIsNotNull() {
            addCriterion("driveend is not null");
            return (Criteria) this;
        }

        public Criteria andDriveendEqualTo(String value) {
            addCriterion("driveend =", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendNotEqualTo(String value) {
            addCriterion("driveend <>", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendGreaterThan(String value) {
            addCriterion("driveend >", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendGreaterThanOrEqualTo(String value) {
            addCriterion("driveend >=", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendLessThan(String value) {
            addCriterion("driveend <", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendLessThanOrEqualTo(String value) {
            addCriterion("driveend <=", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendLike(String value) {
            addCriterion("driveend like", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendNotLike(String value) {
            addCriterion("driveend not like", value, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendIn(List<String> values) {
            addCriterion("driveend in", values, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendNotIn(List<String> values) {
            addCriterion("driveend not in", values, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendBetween(String value1, String value2) {
            addCriterion("driveend between", value1, value2, "driveend");
            return (Criteria) this;
        }

        public Criteria andDriveendNotBetween(String value1, String value2) {
            addCriterion("driveend not between", value1, value2, "driveend");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(String value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(String value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(String value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(String value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(String value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(String value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLike(String value) {
            addCriterion("total like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotLike(String value) {
            addCriterion("total not like", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<String> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<String> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(String value1, String value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(String value1, String value2) {
            addCriterion("total not between", value1, value2, "total");
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