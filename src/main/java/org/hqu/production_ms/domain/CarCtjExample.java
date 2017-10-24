package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarCtjExample {
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarCtjExample() {
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

        public Criteria andDengjizsidIsNull() {
            addCriterion("dengJiZSID is null");
            return (Criteria) this;
        }

        public Criteria andDengjizsidIsNotNull() {
            addCriterion("dengJiZSID is not null");
            return (Criteria) this;
        }

        public Criteria andDengjizsidEqualTo(String value) {
            addCriterion("dengJiZSID =", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidNotEqualTo(String value) {
            addCriterion("dengJiZSID <>", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidGreaterThan(String value) {
            addCriterion("dengJiZSID >", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidGreaterThanOrEqualTo(String value) {
            addCriterion("dengJiZSID >=", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidLessThan(String value) {
            addCriterion("dengJiZSID <", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidLessThanOrEqualTo(String value) {
            addCriterion("dengJiZSID <=", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidLike(String value) {
            addCriterion("dengJiZSID like", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidNotLike(String value) {
            addCriterion("dengJiZSID not like", value, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidIn(List<String> values) {
            addCriterion("dengJiZSID in", values, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidNotIn(List<String> values) {
            addCriterion("dengJiZSID not in", values, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidBetween(String value1, String value2) {
            addCriterion("dengJiZSID between", value1, value2, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andDengjizsidNotBetween(String value1, String value2) {
            addCriterion("dengJiZSID not between", value1, value2, "dengjizsid");
            return (Criteria) this;
        }

        public Criteria andShebeiidIsNull() {
            addCriterion("sheBeiID is null");
            return (Criteria) this;
        }

        public Criteria andShebeiidIsNotNull() {
            addCriterion("sheBeiID is not null");
            return (Criteria) this;
        }

        public Criteria andShebeiidEqualTo(String value) {
            addCriterion("sheBeiID =", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidNotEqualTo(String value) {
            addCriterion("sheBeiID <>", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidGreaterThan(String value) {
            addCriterion("sheBeiID >", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidGreaterThanOrEqualTo(String value) {
            addCriterion("sheBeiID >=", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidLessThan(String value) {
            addCriterion("sheBeiID <", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidLessThanOrEqualTo(String value) {
            addCriterion("sheBeiID <=", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidLike(String value) {
            addCriterion("sheBeiID like", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidNotLike(String value) {
            addCriterion("sheBeiID not like", value, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidIn(List<String> values) {
            addCriterion("sheBeiID in", values, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidNotIn(List<String> values) {
            addCriterion("sheBeiID not in", values, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidBetween(String value1, String value2) {
            addCriterion("sheBeiID between", value1, value2, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andShebeiidNotBetween(String value1, String value2) {
            addCriterion("sheBeiID not between", value1, value2, "shebeiid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andJiganIsNull() {
            addCriterion("jiGan is null");
            return (Criteria) this;
        }

        public Criteria andJiganIsNotNull() {
            addCriterion("jiGan is not null");
            return (Criteria) this;
        }

        public Criteria andJiganEqualTo(String value) {
            addCriterion("jiGan =", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganNotEqualTo(String value) {
            addCriterion("jiGan <>", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganGreaterThan(String value) {
            addCriterion("jiGan >", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganGreaterThanOrEqualTo(String value) {
            addCriterion("jiGan >=", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganLessThan(String value) {
            addCriterion("jiGan <", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganLessThanOrEqualTo(String value) {
            addCriterion("jiGan <=", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganLike(String value) {
            addCriterion("jiGan like", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganNotLike(String value) {
            addCriterion("jiGan not like", value, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganIn(List<String> values) {
            addCriterion("jiGan in", values, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganNotIn(List<String> values) {
            addCriterion("jiGan not in", values, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganBetween(String value1, String value2) {
            addCriterion("jiGan between", value1, value2, "jigan");
            return (Criteria) this;
        }

        public Criteria andJiganNotBetween(String value1, String value2) {
            addCriterion("jiGan not between", value1, value2, "jigan");
            return (Criteria) this;
        }

        public Criteria andDengjitiemIsNull() {
            addCriterion("dengjiTiem is null");
            return (Criteria) this;
        }

        public Criteria andDengjitiemIsNotNull() {
            addCriterion("dengjiTiem is not null");
            return (Criteria) this;
        }

        public Criteria andDengjitiemEqualTo(Date value) {
            addCriterion("dengjiTiem =", value, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemNotEqualTo(Date value) {
            addCriterion("dengjiTiem <>", value, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemGreaterThan(Date value) {
            addCriterion("dengjiTiem >", value, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemGreaterThanOrEqualTo(Date value) {
            addCriterion("dengjiTiem >=", value, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemLessThan(Date value) {
            addCriterion("dengjiTiem <", value, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemLessThanOrEqualTo(Date value) {
            addCriterion("dengjiTiem <=", value, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemIn(List<Date> values) {
            addCriterion("dengjiTiem in", values, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemNotIn(List<Date> values) {
            addCriterion("dengjiTiem not in", values, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemBetween(Date value1, Date value2) {
            addCriterion("dengjiTiem between", value1, value2, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjitiemNotBetween(Date value1, Date value2) {
            addCriterion("dengjiTiem not between", value1, value2, "dengjitiem");
            return (Criteria) this;
        }

        public Criteria andDengjiidIsNull() {
            addCriterion("dengjiID is null");
            return (Criteria) this;
        }

        public Criteria andDengjiidIsNotNull() {
            addCriterion("dengjiID is not null");
            return (Criteria) this;
        }

        public Criteria andDengjiidEqualTo(String value) {
            addCriterion("dengjiID =", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidNotEqualTo(String value) {
            addCriterion("dengjiID <>", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidGreaterThan(String value) {
            addCriterion("dengjiID >", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidGreaterThanOrEqualTo(String value) {
            addCriterion("dengjiID >=", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidLessThan(String value) {
            addCriterion("dengjiID <", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidLessThanOrEqualTo(String value) {
            addCriterion("dengjiID <=", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidLike(String value) {
            addCriterion("dengjiID like", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidNotLike(String value) {
            addCriterion("dengjiID not like", value, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidIn(List<String> values) {
            addCriterion("dengjiID in", values, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidNotIn(List<String> values) {
            addCriterion("dengjiID not in", values, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidBetween(String value1, String value2) {
            addCriterion("dengjiID between", value1, value2, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andDengjiidNotBetween(String value1, String value2) {
            addCriterion("dengjiID not between", value1, value2, "dengjiid");
            return (Criteria) this;
        }

        public Criteria andCarcjhIsNull() {
            addCriterion("carCJH is null");
            return (Criteria) this;
        }

        public Criteria andCarcjhIsNotNull() {
            addCriterion("carCJH is not null");
            return (Criteria) this;
        }

        public Criteria andCarcjhEqualTo(String value) {
            addCriterion("carCJH =", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhNotEqualTo(String value) {
            addCriterion("carCJH <>", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhGreaterThan(String value) {
            addCriterion("carCJH >", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhGreaterThanOrEqualTo(String value) {
            addCriterion("carCJH >=", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhLessThan(String value) {
            addCriterion("carCJH <", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhLessThanOrEqualTo(String value) {
            addCriterion("carCJH <=", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhLike(String value) {
            addCriterion("carCJH like", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhNotLike(String value) {
            addCriterion("carCJH not like", value, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhIn(List<String> values) {
            addCriterion("carCJH in", values, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhNotIn(List<String> values) {
            addCriterion("carCJH not in", values, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhBetween(String value1, String value2) {
            addCriterion("carCJH between", value1, value2, "carcjh");
            return (Criteria) this;
        }

        public Criteria andCarcjhNotBetween(String value1, String value2) {
            addCriterion("carCJH not between", value1, value2, "carcjh");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andUsenatureIsNull() {
            addCriterion("useNature is null");
            return (Criteria) this;
        }

        public Criteria andUsenatureIsNotNull() {
            addCriterion("useNature is not null");
            return (Criteria) this;
        }

        public Criteria andUsenatureEqualTo(String value) {
            addCriterion("useNature =", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureNotEqualTo(String value) {
            addCriterion("useNature <>", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureGreaterThan(String value) {
            addCriterion("useNature >", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureGreaterThanOrEqualTo(String value) {
            addCriterion("useNature >=", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureLessThan(String value) {
            addCriterion("useNature <", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureLessThanOrEqualTo(String value) {
            addCriterion("useNature <=", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureLike(String value) {
            addCriterion("useNature like", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureNotLike(String value) {
            addCriterion("useNature not like", value, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureIn(List<String> values) {
            addCriterion("useNature in", values, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureNotIn(List<String> values) {
            addCriterion("useNature not in", values, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureBetween(String value1, String value2) {
            addCriterion("useNature between", value1, value2, "usenature");
            return (Criteria) this;
        }

        public Criteria andUsenatureNotBetween(String value1, String value2) {
            addCriterion("useNature not between", value1, value2, "usenature");
            return (Criteria) this;
        }

        public Criteria andCarwayIsNull() {
            addCriterion("carWay is null");
            return (Criteria) this;
        }

        public Criteria andCarwayIsNotNull() {
            addCriterion("carWay is not null");
            return (Criteria) this;
        }

        public Criteria andCarwayEqualTo(String value) {
            addCriterion("carWay =", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayNotEqualTo(String value) {
            addCriterion("carWay <>", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayGreaterThan(String value) {
            addCriterion("carWay >", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayGreaterThanOrEqualTo(String value) {
            addCriterion("carWay >=", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayLessThan(String value) {
            addCriterion("carWay <", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayLessThanOrEqualTo(String value) {
            addCriterion("carWay <=", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayLike(String value) {
            addCriterion("carWay like", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayNotLike(String value) {
            addCriterion("carWay not like", value, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayIn(List<String> values) {
            addCriterion("carWay in", values, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayNotIn(List<String> values) {
            addCriterion("carWay not in", values, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayBetween(String value1, String value2) {
            addCriterion("carWay between", value1, value2, "carway");
            return (Criteria) this;
        }

        public Criteria andCarwayNotBetween(String value1, String value2) {
            addCriterion("carWay not between", value1, value2, "carway");
            return (Criteria) this;
        }

        public Criteria andManufacturedateIsNull() {
            addCriterion("manufactureDate is null");
            return (Criteria) this;
        }

        public Criteria andManufacturedateIsNotNull() {
            addCriterion("manufactureDate is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturedateEqualTo(Date value) {
            addCriterion("manufactureDate =", value, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateNotEqualTo(Date value) {
            addCriterion("manufactureDate <>", value, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateGreaterThan(Date value) {
            addCriterion("manufactureDate >", value, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateGreaterThanOrEqualTo(Date value) {
            addCriterion("manufactureDate >=", value, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateLessThan(Date value) {
            addCriterion("manufactureDate <", value, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateLessThanOrEqualTo(Date value) {
            addCriterion("manufactureDate <=", value, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateIn(List<Date> values) {
            addCriterion("manufactureDate in", values, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateNotIn(List<Date> values) {
            addCriterion("manufactureDate not in", values, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateBetween(Date value1, Date value2) {
            addCriterion("manufactureDate between", value1, value2, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andManufacturedateNotBetween(Date value1, Date value2) {
            addCriterion("manufactureDate not between", value1, value2, "manufacturedate");
            return (Criteria) this;
        }

        public Criteria andIssueorganIsNull() {
            addCriterion("issueOrgan is null");
            return (Criteria) this;
        }

        public Criteria andIssueorganIsNotNull() {
            addCriterion("issueOrgan is not null");
            return (Criteria) this;
        }

        public Criteria andIssueorganEqualTo(String value) {
            addCriterion("issueOrgan =", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotEqualTo(String value) {
            addCriterion("issueOrgan <>", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganGreaterThan(String value) {
            addCriterion("issueOrgan >", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganGreaterThanOrEqualTo(String value) {
            addCriterion("issueOrgan >=", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganLessThan(String value) {
            addCriterion("issueOrgan <", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganLessThanOrEqualTo(String value) {
            addCriterion("issueOrgan <=", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganLike(String value) {
            addCriterion("issueOrgan like", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotLike(String value) {
            addCriterion("issueOrgan not like", value, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganIn(List<String> values) {
            addCriterion("issueOrgan in", values, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotIn(List<String> values) {
            addCriterion("issueOrgan not in", values, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganBetween(String value1, String value2) {
            addCriterion("issueOrgan between", value1, value2, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssueorganNotBetween(String value1, String value2) {
            addCriterion("issueOrgan not between", value1, value2, "issueorgan");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNull() {
            addCriterion("issueDate is null");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNotNull() {
            addCriterion("issueDate is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedateEqualTo(Date value) {
            addCriterion("issueDate =", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotEqualTo(Date value) {
            addCriterion("issueDate <>", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThan(Date value) {
            addCriterion("issueDate >", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThanOrEqualTo(Date value) {
            addCriterion("issueDate >=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThan(Date value) {
            addCriterion("issueDate <", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThanOrEqualTo(Date value) {
            addCriterion("issueDate <=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateIn(List<Date> values) {
            addCriterion("issueDate in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotIn(List<Date> values) {
            addCriterion("issueDate not in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateBetween(Date value1, Date value2) {
            addCriterion("issueDate between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotBetween(Date value1, Date value2) {
            addCriterion("issueDate not between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalIsNull() {
            addCriterion("buycarapproval is null");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalIsNotNull() {
            addCriterion("buycarapproval is not null");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalEqualTo(String value) {
            addCriterion("buycarapproval =", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalNotEqualTo(String value) {
            addCriterion("buycarapproval <>", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalGreaterThan(String value) {
            addCriterion("buycarapproval >", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalGreaterThanOrEqualTo(String value) {
            addCriterion("buycarapproval >=", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalLessThan(String value) {
            addCriterion("buycarapproval <", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalLessThanOrEqualTo(String value) {
            addCriterion("buycarapproval <=", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalLike(String value) {
            addCriterion("buycarapproval like", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalNotLike(String value) {
            addCriterion("buycarapproval not like", value, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalIn(List<String> values) {
            addCriterion("buycarapproval in", values, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalNotIn(List<String> values) {
            addCriterion("buycarapproval not in", values, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalBetween(String value1, String value2) {
            addCriterion("buycarapproval between", value1, value2, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andBuycarapprovalNotBetween(String value1, String value2) {
            addCriterion("buycarapproval not between", value1, value2, "buycarapproval");
            return (Criteria) this;
        }

        public Criteria andNewsourceIsNull() {
            addCriterion("newSource is null");
            return (Criteria) this;
        }

        public Criteria andNewsourceIsNotNull() {
            addCriterion("newSource is not null");
            return (Criteria) this;
        }

        public Criteria andNewsourceEqualTo(String value) {
            addCriterion("newSource =", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceNotEqualTo(String value) {
            addCriterion("newSource <>", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceGreaterThan(String value) {
            addCriterion("newSource >", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceGreaterThanOrEqualTo(String value) {
            addCriterion("newSource >=", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceLessThan(String value) {
            addCriterion("newSource <", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceLessThanOrEqualTo(String value) {
            addCriterion("newSource <=", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceLike(String value) {
            addCriterion("newSource like", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceNotLike(String value) {
            addCriterion("newSource not like", value, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceIn(List<String> values) {
            addCriterion("newSource in", values, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceNotIn(List<String> values) {
            addCriterion("newSource not in", values, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceBetween(String value1, String value2) {
            addCriterion("newSource between", value1, value2, "newsource");
            return (Criteria) this;
        }

        public Criteria andNewsourceNotBetween(String value1, String value2) {
            addCriterion("newSource not between", value1, value2, "newsource");
            return (Criteria) this;
        }

        public Criteria andCarpriceIsNull() {
            addCriterion("carPrice is null");
            return (Criteria) this;
        }

        public Criteria andCarpriceIsNotNull() {
            addCriterion("carPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCarpriceEqualTo(BigDecimal value) {
            addCriterion("carPrice =", value, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceNotEqualTo(BigDecimal value) {
            addCriterion("carPrice <>", value, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceGreaterThan(BigDecimal value) {
            addCriterion("carPrice >", value, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("carPrice >=", value, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceLessThan(BigDecimal value) {
            addCriterion("carPrice <", value, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("carPrice <=", value, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceIn(List<BigDecimal> values) {
            addCriterion("carPrice in", values, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceNotIn(List<BigDecimal> values) {
            addCriterion("carPrice not in", values, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carPrice between", value1, value2, "carprice");
            return (Criteria) this;
        }

        public Criteria andCarpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carPrice not between", value1, value2, "carprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceIsNull() {
            addCriterion("oldcarPrice is null");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceIsNotNull() {
            addCriterion("oldcarPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceEqualTo(BigDecimal value) {
            addCriterion("oldcarPrice =", value, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceNotEqualTo(BigDecimal value) {
            addCriterion("oldcarPrice <>", value, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceGreaterThan(BigDecimal value) {
            addCriterion("oldcarPrice >", value, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oldcarPrice >=", value, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceLessThan(BigDecimal value) {
            addCriterion("oldcarPrice <", value, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oldcarPrice <=", value, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceIn(List<BigDecimal> values) {
            addCriterion("oldcarPrice in", values, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceNotIn(List<BigDecimal> values) {
            addCriterion("oldcarPrice not in", values, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oldcarPrice between", value1, value2, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andOldcarpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oldcarPrice not between", value1, value2, "oldcarprice");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeId <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeid");
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
