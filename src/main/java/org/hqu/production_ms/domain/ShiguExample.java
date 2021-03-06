package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShiguExample() {
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

        public Criteria andShiguIdIsNull() {
            addCriterion("shigu_id is null");
            return (Criteria) this;
        }

        public Criteria andShiguIdIsNotNull() {
            addCriterion("shigu_id is not null");
            return (Criteria) this;
        }

        public Criteria andShiguIdEqualTo(Integer value) {
            addCriterion("shigu_id =", value, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdNotEqualTo(Integer value) {
            addCriterion("shigu_id <>", value, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdGreaterThan(Integer value) {
            addCriterion("shigu_id >", value, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shigu_id >=", value, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdLessThan(Integer value) {
            addCriterion("shigu_id <", value, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdLessThanOrEqualTo(Integer value) {
            addCriterion("shigu_id <=", value, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdIn(List<Integer> values) {
            addCriterion("shigu_id in", values, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdNotIn(List<Integer> values) {
            addCriterion("shigu_id not in", values, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdBetween(Integer value1, Integer value2) {
            addCriterion("shigu_id between", value1, value2, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShiguIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shigu_id not between", value1, value2, "shiguId");
            return (Criteria) this;
        }

        public Criteria andShigucodeIsNull() {
            addCriterion("shigucode is null");
            return (Criteria) this;
        }

        public Criteria andShigucodeIsNotNull() {
            addCriterion("shigucode is not null");
            return (Criteria) this;
        }

        public Criteria andShigucodeEqualTo(String value) {
            addCriterion("shigucode =", value, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeNotEqualTo(String value) {
            addCriterion("shigucode <>", value, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeGreaterThan(String value) {
            addCriterion("shigucode >", value, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeGreaterThanOrEqualTo(String value) {
            addCriterion("shigucode >=", value, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeLessThan(String value) {
            addCriterion("shigucode <", value, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeLessThanOrEqualTo(String value) {
            addCriterion("shigucode <=", value, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeIn(List<String> values) {
            addCriterion("shigucode in", values, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeNotIn(List<String> values) {
            addCriterion("shigucode not in", values, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeBetween(String value1, String value2) {
            addCriterion("shigucode between", value1, value2, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigucodeNotBetween(String value1, String value2) {
            addCriterion("shigucode not between", value1, value2, "shigucode");
            return (Criteria) this;
        }

        public Criteria andShigutimeIsNull() {
            addCriterion("shigutime is null");
            return (Criteria) this;
        }

        public Criteria andShigutimeIsNotNull() {
            addCriterion("shigutime is not null");
            return (Criteria) this;
        }

        public Criteria andShigutimeEqualTo(Date value) {
            addCriterion("shigutime =", value, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeNotEqualTo(Date value) {
            addCriterion("shigutime <>", value, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeGreaterThan(Date value) {
            addCriterion("shigutime >", value, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shigutime >=", value, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeLessThan(Date value) {
            addCriterion("shigutime <", value, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeLessThanOrEqualTo(Date value) {
            addCriterion("shigutime <=", value, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeIn(List<Date> values) {
            addCriterion("shigutime in", values, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeNotIn(List<Date> values) {
            addCriterion("shigutime not in", values, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeBetween(Date value1, Date value2) {
            addCriterion("shigutime between", value1, value2, "shigutime");
            return (Criteria) this;
        }

        public Criteria andShigutimeNotBetween(Date value1, Date value2) {
            addCriterion("shigutime not between", value1, value2, "shigutime");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andShigutypeIsNull() {
            addCriterion("shigutype is null");
            return (Criteria) this;
        }

        public Criteria andShigutypeIsNotNull() {
            addCriterion("shigutype is not null");
            return (Criteria) this;
        }

        public Criteria andShigutypeEqualTo(String value) {
            addCriterion("shigutype =", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeNotEqualTo(String value) {
            addCriterion("shigutype <>", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeGreaterThan(String value) {
            addCriterion("shigutype >", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeGreaterThanOrEqualTo(String value) {
            addCriterion("shigutype >=", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeLessThan(String value) {
            addCriterion("shigutype <", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeLessThanOrEqualTo(String value) {
            addCriterion("shigutype <=", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeLike(String value) {
            addCriterion("shigutype like", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeNotLike(String value) {
            addCriterion("shigutype not like", value, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeIn(List<String> values) {
            addCriterion("shigutype in", values, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeNotIn(List<String> values) {
            addCriterion("shigutype not in", values, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeBetween(String value1, String value2) {
            addCriterion("shigutype between", value1, value2, "shigutype");
            return (Criteria) this;
        }

        public Criteria andShigutypeNotBetween(String value1, String value2) {
            addCriterion("shigutype not between", value1, value2, "shigutype");
            return (Criteria) this;
        }

        public Criteria andZerenIsNull() {
            addCriterion("zeren is null");
            return (Criteria) this;
        }

        public Criteria andZerenIsNotNull() {
            addCriterion("zeren is not null");
            return (Criteria) this;
        }

        public Criteria andZerenEqualTo(String value) {
            addCriterion("zeren =", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenNotEqualTo(String value) {
            addCriterion("zeren <>", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenGreaterThan(String value) {
            addCriterion("zeren >", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenGreaterThanOrEqualTo(String value) {
            addCriterion("zeren >=", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenLessThan(String value) {
            addCriterion("zeren <", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenLessThanOrEqualTo(String value) {
            addCriterion("zeren <=", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenLike(String value) {
            addCriterion("zeren like", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenNotLike(String value) {
            addCriterion("zeren not like", value, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenIn(List<String> values) {
            addCriterion("zeren in", values, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenNotIn(List<String> values) {
            addCriterion("zeren not in", values, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenBetween(String value1, String value2) {
            addCriterion("zeren between", value1, value2, "zeren");
            return (Criteria) this;
        }

        public Criteria andZerenNotBetween(String value1, String value2) {
            addCriterion("zeren not between", value1, value2, "zeren");
            return (Criteria) this;
        }

        public Criteria andYuanyinIsNull() {
            addCriterion("yuanyin is null");
            return (Criteria) this;
        }

        public Criteria andYuanyinIsNotNull() {
            addCriterion("yuanyin is not null");
            return (Criteria) this;
        }

        public Criteria andYuanyinEqualTo(String value) {
            addCriterion("yuanyin =", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinNotEqualTo(String value) {
            addCriterion("yuanyin <>", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinGreaterThan(String value) {
            addCriterion("yuanyin >", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinGreaterThanOrEqualTo(String value) {
            addCriterion("yuanyin >=", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinLessThan(String value) {
            addCriterion("yuanyin <", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinLessThanOrEqualTo(String value) {
            addCriterion("yuanyin <=", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinLike(String value) {
            addCriterion("yuanyin like", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinNotLike(String value) {
            addCriterion("yuanyin not like", value, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinIn(List<String> values) {
            addCriterion("yuanyin in", values, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinNotIn(List<String> values) {
            addCriterion("yuanyin not in", values, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinBetween(String value1, String value2) {
            addCriterion("yuanyin between", value1, value2, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andYuanyinNotBetween(String value1, String value2) {
            addCriterion("yuanyin not between", value1, value2, "yuanyin");
            return (Criteria) this;
        }

        public Criteria andSunshiIsNull() {
            addCriterion("sunshi is null");
            return (Criteria) this;
        }

        public Criteria andSunshiIsNotNull() {
            addCriterion("sunshi is not null");
            return (Criteria) this;
        }

        public Criteria andSunshiEqualTo(String value) {
            addCriterion("sunshi =", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiNotEqualTo(String value) {
            addCriterion("sunshi <>", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiGreaterThan(String value) {
            addCriterion("sunshi >", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiGreaterThanOrEqualTo(String value) {
            addCriterion("sunshi >=", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiLessThan(String value) {
            addCriterion("sunshi <", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiLessThanOrEqualTo(String value) {
            addCriterion("sunshi <=", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiLike(String value) {
            addCriterion("sunshi like", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiNotLike(String value) {
            addCriterion("sunshi not like", value, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiIn(List<String> values) {
            addCriterion("sunshi in", values, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiNotIn(List<String> values) {
            addCriterion("sunshi not in", values, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiBetween(String value1, String value2) {
            addCriterion("sunshi between", value1, value2, "sunshi");
            return (Criteria) this;
        }

        public Criteria andSunshiNotBetween(String value1, String value2) {
            addCriterion("sunshi not between", value1, value2, "sunshi");
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