package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarSendExample() {
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

        public Criteria andSendnumsIsNull() {
            addCriterion("sendNums is null");
            return (Criteria) this;
        }

        public Criteria andSendnumsIsNotNull() {
            addCriterion("sendNums is not null");
            return (Criteria) this;
        }

        public Criteria andSendnumsEqualTo(String value) {
            addCriterion("sendNums =", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsNotEqualTo(String value) {
            addCriterion("sendNums <>", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsGreaterThan(String value) {
            addCriterion("sendNums >", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsGreaterThanOrEqualTo(String value) {
            addCriterion("sendNums >=", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsLessThan(String value) {
            addCriterion("sendNums <", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsLessThanOrEqualTo(String value) {
            addCriterion("sendNums <=", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsLike(String value) {
            addCriterion("sendNums like", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsNotLike(String value) {
            addCriterion("sendNums not like", value, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsIn(List<String> values) {
            addCriterion("sendNums in", values, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsNotIn(List<String> values) {
            addCriterion("sendNums not in", values, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsBetween(String value1, String value2) {
            addCriterion("sendNums between", value1, value2, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSendnumsNotBetween(String value1, String value2) {
            addCriterion("sendNums not between", value1, value2, "sendnums");
            return (Criteria) this;
        }

        public Criteria andSenduserIsNull() {
            addCriterion("sendUser is null");
            return (Criteria) this;
        }

        public Criteria andSenduserIsNotNull() {
            addCriterion("sendUser is not null");
            return (Criteria) this;
        }

        public Criteria andSenduserEqualTo(String value) {
            addCriterion("sendUser =", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserNotEqualTo(String value) {
            addCriterion("sendUser <>", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserGreaterThan(String value) {
            addCriterion("sendUser >", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserGreaterThanOrEqualTo(String value) {
            addCriterion("sendUser >=", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserLessThan(String value) {
            addCriterion("sendUser <", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserLessThanOrEqualTo(String value) {
            addCriterion("sendUser <=", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserLike(String value) {
            addCriterion("sendUser like", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserNotLike(String value) {
            addCriterion("sendUser not like", value, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserIn(List<String> values) {
            addCriterion("sendUser in", values, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserNotIn(List<String> values) {
            addCriterion("sendUser not in", values, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserBetween(String value1, String value2) {
            addCriterion("sendUser between", value1, value2, "senduser");
            return (Criteria) this;
        }

        public Criteria andSenduserNotBetween(String value1, String value2) {
            addCriterion("sendUser not between", value1, value2, "senduser");
            return (Criteria) this;
        }

        public Criteria andRoadIsNull() {
            addCriterion("road is null");
            return (Criteria) this;
        }

        public Criteria andRoadIsNotNull() {
            addCriterion("road is not null");
            return (Criteria) this;
        }

        public Criteria andRoadEqualTo(String value) {
            addCriterion("road =", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotEqualTo(String value) {
            addCriterion("road <>", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadGreaterThan(String value) {
            addCriterion("road >", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadGreaterThanOrEqualTo(String value) {
            addCriterion("road >=", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadLessThan(String value) {
            addCriterion("road <", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadLessThanOrEqualTo(String value) {
            addCriterion("road <=", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadLike(String value) {
            addCriterion("road like", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotLike(String value) {
            addCriterion("road not like", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadIn(List<String> values) {
            addCriterion("road in", values, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotIn(List<String> values) {
            addCriterion("road not in", values, "road");
            return (Criteria) this;
        }

        public Criteria andRoadBetween(String value1, String value2) {
            addCriterion("road between", value1, value2, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotBetween(String value1, String value2) {
            addCriterion("road not between", value1, value2, "road");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleIsNull() {
            addCriterion("userCarPeople is null");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleIsNotNull() {
            addCriterion("userCarPeople is not null");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleEqualTo(String value) {
            addCriterion("userCarPeople =", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleNotEqualTo(String value) {
            addCriterion("userCarPeople <>", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleGreaterThan(String value) {
            addCriterion("userCarPeople >", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("userCarPeople >=", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleLessThan(String value) {
            addCriterion("userCarPeople <", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleLessThanOrEqualTo(String value) {
            addCriterion("userCarPeople <=", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleLike(String value) {
            addCriterion("userCarPeople like", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleNotLike(String value) {
            addCriterion("userCarPeople not like", value, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleIn(List<String> values) {
            addCriterion("userCarPeople in", values, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleNotIn(List<String> values) {
            addCriterion("userCarPeople not in", values, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleBetween(String value1, String value2) {
            addCriterion("userCarPeople between", value1, value2, "usercarpeople");
            return (Criteria) this;
        }

        public Criteria andUsercarpeopleNotBetween(String value1, String value2) {
            addCriterion("userCarPeople not between", value1, value2, "usercarpeople");
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
            addCriterionForJDBCDate("sendDate =", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sendDate <>", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThan(Date value) {
            addCriterionForJDBCDate("sendDate >", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sendDate >=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThan(Date value) {
            addCriterionForJDBCDate("sendDate <", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sendDate <=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateIn(List<Date> values) {
            addCriterionForJDBCDate("sendDate in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sendDate not in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sendDate between", value1, value2, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sendDate not between", value1, value2, "senddate");
            return (Criteria) this;
        }

        public Criteria andEndcardateIsNull() {
            addCriterion("endCarDate is null");
            return (Criteria) this;
        }

        public Criteria andEndcardateIsNotNull() {
            addCriterion("endCarDate is not null");
            return (Criteria) this;
        }

        public Criteria andEndcardateEqualTo(Date value) {
            addCriterionForJDBCDate("endCarDate =", value, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateNotEqualTo(Date value) {
            addCriterionForJDBCDate("endCarDate <>", value, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateGreaterThan(Date value) {
            addCriterionForJDBCDate("endCarDate >", value, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endCarDate >=", value, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateLessThan(Date value) {
            addCriterionForJDBCDate("endCarDate <", value, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endCarDate <=", value, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateIn(List<Date> values) {
            addCriterionForJDBCDate("endCarDate in", values, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateNotIn(List<Date> values) {
            addCriterionForJDBCDate("endCarDate not in", values, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endCarDate between", value1, value2, "endcardate");
            return (Criteria) this;
        }

        public Criteria andEndcardateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endCarDate not between", value1, value2, "endcardate");
            return (Criteria) this;
        }

        public Criteria andFirstdutyIsNull() {
            addCriterion("firstDuty is null");
            return (Criteria) this;
        }

        public Criteria andFirstdutyIsNotNull() {
            addCriterion("firstDuty is not null");
            return (Criteria) this;
        }

        public Criteria andFirstdutyEqualTo(String value) {
            addCriterion("firstDuty =", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyNotEqualTo(String value) {
            addCriterion("firstDuty <>", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyGreaterThan(String value) {
            addCriterion("firstDuty >", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyGreaterThanOrEqualTo(String value) {
            addCriterion("firstDuty >=", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyLessThan(String value) {
            addCriterion("firstDuty <", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyLessThanOrEqualTo(String value) {
            addCriterion("firstDuty <=", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyLike(String value) {
            addCriterion("firstDuty like", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyNotLike(String value) {
            addCriterion("firstDuty not like", value, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyIn(List<String> values) {
            addCriterion("firstDuty in", values, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyNotIn(List<String> values) {
            addCriterion("firstDuty not in", values, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyBetween(String value1, String value2) {
            addCriterion("firstDuty between", value1, value2, "firstduty");
            return (Criteria) this;
        }

        public Criteria andFirstdutyNotBetween(String value1, String value2) {
            addCriterion("firstDuty not between", value1, value2, "firstduty");
            return (Criteria) this;
        }

        public Criteria andSafeIsNull() {
            addCriterion("safe is null");
            return (Criteria) this;
        }

        public Criteria andSafeIsNotNull() {
            addCriterion("safe is not null");
            return (Criteria) this;
        }

        public Criteria andSafeEqualTo(String value) {
            addCriterion("safe =", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeNotEqualTo(String value) {
            addCriterion("safe <>", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeGreaterThan(String value) {
            addCriterion("safe >", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeGreaterThanOrEqualTo(String value) {
            addCriterion("safe >=", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeLessThan(String value) {
            addCriterion("safe <", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeLessThanOrEqualTo(String value) {
            addCriterion("safe <=", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeLike(String value) {
            addCriterion("safe like", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeNotLike(String value) {
            addCriterion("safe not like", value, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeIn(List<String> values) {
            addCriterion("safe in", values, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeNotIn(List<String> values) {
            addCriterion("safe not in", values, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeBetween(String value1, String value2) {
            addCriterion("safe between", value1, value2, "safe");
            return (Criteria) this;
        }

        public Criteria andSafeNotBetween(String value1, String value2) {
            addCriterion("safe not between", value1, value2, "safe");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andFirstkmIsNull() {
            addCriterion("firstkm is null");
            return (Criteria) this;
        }

        public Criteria andFirstkmIsNotNull() {
            addCriterion("firstkm is not null");
            return (Criteria) this;
        }

        public Criteria andFirstkmEqualTo(String value) {
            addCriterion("firstkm =", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmNotEqualTo(String value) {
            addCriterion("firstkm <>", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmGreaterThan(String value) {
            addCriterion("firstkm >", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmGreaterThanOrEqualTo(String value) {
            addCriterion("firstkm >=", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmLessThan(String value) {
            addCriterion("firstkm <", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmLessThanOrEqualTo(String value) {
            addCriterion("firstkm <=", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmLike(String value) {
            addCriterion("firstkm like", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmNotLike(String value) {
            addCriterion("firstkm not like", value, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmIn(List<String> values) {
            addCriterion("firstkm in", values, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmNotIn(List<String> values) {
            addCriterion("firstkm not in", values, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmBetween(String value1, String value2) {
            addCriterion("firstkm between", value1, value2, "firstkm");
            return (Criteria) this;
        }

        public Criteria andFirstkmNotBetween(String value1, String value2) {
            addCriterion("firstkm not between", value1, value2, "firstkm");
            return (Criteria) this;
        }

        public Criteria andEndkmIsNull() {
            addCriterion("endkm is null");
            return (Criteria) this;
        }

        public Criteria andEndkmIsNotNull() {
            addCriterion("endkm is not null");
            return (Criteria) this;
        }

        public Criteria andEndkmEqualTo(String value) {
            addCriterion("endkm =", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmNotEqualTo(String value) {
            addCriterion("endkm <>", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmGreaterThan(String value) {
            addCriterion("endkm >", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmGreaterThanOrEqualTo(String value) {
            addCriterion("endkm >=", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmLessThan(String value) {
            addCriterion("endkm <", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmLessThanOrEqualTo(String value) {
            addCriterion("endkm <=", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmLike(String value) {
            addCriterion("endkm like", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmNotLike(String value) {
            addCriterion("endkm not like", value, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmIn(List<String> values) {
            addCriterion("endkm in", values, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmNotIn(List<String> values) {
            addCriterion("endkm not in", values, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmBetween(String value1, String value2) {
            addCriterion("endkm between", value1, value2, "endkm");
            return (Criteria) this;
        }

        public Criteria andEndkmNotBetween(String value1, String value2) {
            addCriterion("endkm not between", value1, value2, "endkm");
            return (Criteria) this;
        }

        public Criteria andTianqiIsNull() {
            addCriterion("tianqi is null");
            return (Criteria) this;
        }

        public Criteria andTianqiIsNotNull() {
            addCriterion("tianqi is not null");
            return (Criteria) this;
        }

        public Criteria andTianqiEqualTo(String value) {
            addCriterion("tianqi =", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiNotEqualTo(String value) {
            addCriterion("tianqi <>", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiGreaterThan(String value) {
            addCriterion("tianqi >", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiGreaterThanOrEqualTo(String value) {
            addCriterion("tianqi >=", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiLessThan(String value) {
            addCriterion("tianqi <", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiLessThanOrEqualTo(String value) {
            addCriterion("tianqi <=", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiLike(String value) {
            addCriterion("tianqi like", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiNotLike(String value) {
            addCriterion("tianqi not like", value, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiIn(List<String> values) {
            addCriterion("tianqi in", values, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiNotIn(List<String> values) {
            addCriterion("tianqi not in", values, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiBetween(String value1, String value2) {
            addCriterion("tianqi between", value1, value2, "tianqi");
            return (Criteria) this;
        }

        public Criteria andTianqiNotBetween(String value1, String value2) {
            addCriterion("tianqi not between", value1, value2, "tianqi");
            return (Criteria) this;
        }

        public Criteria andChucheqIsNull() {
            addCriterion("chucheq is null");
            return (Criteria) this;
        }

        public Criteria andChucheqIsNotNull() {
            addCriterion("chucheq is not null");
            return (Criteria) this;
        }

        public Criteria andChucheqEqualTo(String value) {
            addCriterion("chucheq =", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqNotEqualTo(String value) {
            addCriterion("chucheq <>", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqGreaterThan(String value) {
            addCriterion("chucheq >", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqGreaterThanOrEqualTo(String value) {
            addCriterion("chucheq >=", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqLessThan(String value) {
            addCriterion("chucheq <", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqLessThanOrEqualTo(String value) {
            addCriterion("chucheq <=", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqLike(String value) {
            addCriterion("chucheq like", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqNotLike(String value) {
            addCriterion("chucheq not like", value, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqIn(List<String> values) {
            addCriterion("chucheq in", values, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqNotIn(List<String> values) {
            addCriterion("chucheq not in", values, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqBetween(String value1, String value2) {
            addCriterion("chucheq between", value1, value2, "chucheq");
            return (Criteria) this;
        }

        public Criteria andChucheqNotBetween(String value1, String value2) {
            addCriterion("chucheq not between", value1, value2, "chucheq");
            return (Criteria) this;
        }

        public Criteria andXingshizIsNull() {
            addCriterion("xingshiz is null");
            return (Criteria) this;
        }

        public Criteria andXingshizIsNotNull() {
            addCriterion("xingshiz is not null");
            return (Criteria) this;
        }

        public Criteria andXingshizEqualTo(String value) {
            addCriterion("xingshiz =", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizNotEqualTo(String value) {
            addCriterion("xingshiz <>", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizGreaterThan(String value) {
            addCriterion("xingshiz >", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizGreaterThanOrEqualTo(String value) {
            addCriterion("xingshiz >=", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizLessThan(String value) {
            addCriterion("xingshiz <", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizLessThanOrEqualTo(String value) {
            addCriterion("xingshiz <=", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizLike(String value) {
            addCriterion("xingshiz like", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizNotLike(String value) {
            addCriterion("xingshiz not like", value, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizIn(List<String> values) {
            addCriterion("xingshiz in", values, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizNotIn(List<String> values) {
            addCriterion("xingshiz not in", values, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizBetween(String value1, String value2) {
            addCriterion("xingshiz between", value1, value2, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andXingshizNotBetween(String value1, String value2) {
            addCriterion("xingshiz not between", value1, value2, "xingshiz");
            return (Criteria) this;
        }

        public Criteria andShouchehIsNull() {
            addCriterion("shoucheh is null");
            return (Criteria) this;
        }

        public Criteria andShouchehIsNotNull() {
            addCriterion("shoucheh is not null");
            return (Criteria) this;
        }

        public Criteria andShouchehEqualTo(String value) {
            addCriterion("shoucheh =", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehNotEqualTo(String value) {
            addCriterion("shoucheh <>", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehGreaterThan(String value) {
            addCriterion("shoucheh >", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehGreaterThanOrEqualTo(String value) {
            addCriterion("shoucheh >=", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehLessThan(String value) {
            addCriterion("shoucheh <", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehLessThanOrEqualTo(String value) {
            addCriterion("shoucheh <=", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehLike(String value) {
            addCriterion("shoucheh like", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehNotLike(String value) {
            addCriterion("shoucheh not like", value, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehIn(List<String> values) {
            addCriterion("shoucheh in", values, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehNotIn(List<String> values) {
            addCriterion("shoucheh not in", values, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehBetween(String value1, String value2) {
            addCriterion("shoucheh between", value1, value2, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShouchehNotBetween(String value1, String value2) {
            addCriterion("shoucheh not between", value1, value2, "shoucheh");
            return (Criteria) this;
        }

        public Criteria andShigujlIsNull() {
            addCriterion("shigujl is null");
            return (Criteria) this;
        }

        public Criteria andShigujlIsNotNull() {
            addCriterion("shigujl is not null");
            return (Criteria) this;
        }

        public Criteria andShigujlEqualTo(String value) {
            addCriterion("shigujl =", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlNotEqualTo(String value) {
            addCriterion("shigujl <>", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlGreaterThan(String value) {
            addCriterion("shigujl >", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlGreaterThanOrEqualTo(String value) {
            addCriterion("shigujl >=", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlLessThan(String value) {
            addCriterion("shigujl <", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlLessThanOrEqualTo(String value) {
            addCriterion("shigujl <=", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlLike(String value) {
            addCriterion("shigujl like", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlNotLike(String value) {
            addCriterion("shigujl not like", value, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlIn(List<String> values) {
            addCriterion("shigujl in", values, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlNotIn(List<String> values) {
            addCriterion("shigujl not in", values, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlBetween(String value1, String value2) {
            addCriterion("shigujl between", value1, value2, "shigujl");
            return (Criteria) this;
        }

        public Criteria andShigujlNotBetween(String value1, String value2) {
            addCriterion("shigujl not between", value1, value2, "shigujl");
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Integer value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Integer value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Integer value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Integer value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<Integer> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<Integer> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andSdateIsNull() {
            addCriterion("sdate is null");
            return (Criteria) this;
        }

        public Criteria andSdateIsNotNull() {
            addCriterion("sdate is not null");
            return (Criteria) this;
        }

        public Criteria andSdateEqualTo(Date value) {
            addCriterionForJDBCDate("sdate =", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sdate <>", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThan(Date value) {
            addCriterionForJDBCDate("sdate >", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdate >=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThan(Date value) {
            addCriterionForJDBCDate("sdate <", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdate <=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateIn(List<Date> values) {
            addCriterionForJDBCDate("sdate in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sdate not in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdate between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdate not between", value1, value2, "sdate");
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