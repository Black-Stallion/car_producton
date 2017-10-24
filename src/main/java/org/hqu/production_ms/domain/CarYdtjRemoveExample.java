package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarYdtjRemoveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarYdtjRemoveExample() {
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

        public Criteria andRemoveIdIsNull() {
            addCriterion("remove_id is null");
            return (Criteria) this;
        }

        public Criteria andRemoveIdIsNotNull() {
            addCriterion("remove_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveIdEqualTo(Integer value) {
            addCriterion("remove_id =", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdNotEqualTo(Integer value) {
            addCriterion("remove_id <>", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdGreaterThan(Integer value) {
            addCriterion("remove_id >", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remove_id >=", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdLessThan(Integer value) {
            addCriterion("remove_id <", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdLessThanOrEqualTo(Integer value) {
            addCriterion("remove_id <=", value, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdIn(List<Integer> values) {
            addCriterion("remove_id in", values, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdNotIn(List<Integer> values) {
            addCriterion("remove_id not in", values, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdBetween(Integer value1, Integer value2) {
            addCriterion("remove_id between", value1, value2, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemoveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remove_id not between", value1, value2, "removeId");
            return (Criteria) this;
        }

        public Criteria andRemovetimeIsNull() {
            addCriterion("removeTime is null");
            return (Criteria) this;
        }

        public Criteria andRemovetimeIsNotNull() {
            addCriterion("removeTime is not null");
            return (Criteria) this;
        }

        public Criteria andRemovetimeEqualTo(Date value) {
            addCriterion("removeTime =", value, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeNotEqualTo(Date value) {
            addCriterion("removeTime <>", value, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeGreaterThan(Date value) {
            addCriterion("removeTime >", value, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("removeTime >=", value, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeLessThan(Date value) {
            addCriterion("removeTime <", value, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeLessThanOrEqualTo(Date value) {
            addCriterion("removeTime <=", value, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeIn(List<Date> values) {
            addCriterion("removeTime in", values, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeNotIn(List<Date> values) {
            addCriterion("removeTime not in", values, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeBetween(Date value1, Date value2) {
            addCriterion("removeTime between", value1, value2, "removetime");
            return (Criteria) this;
        }

        public Criteria andRemovetimeNotBetween(Date value1, Date value2) {
            addCriterion("removeTime not between", value1, value2, "removetime");
            return (Criteria) this;
        }

        public Criteria andInorganIsNull() {
            addCriterion("inOrgan is null");
            return (Criteria) this;
        }

        public Criteria andInorganIsNotNull() {
            addCriterion("inOrgan is not null");
            return (Criteria) this;
        }

        public Criteria andInorganEqualTo(String value) {
            addCriterion("inOrgan =", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganNotEqualTo(String value) {
            addCriterion("inOrgan <>", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganGreaterThan(String value) {
            addCriterion("inOrgan >", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganGreaterThanOrEqualTo(String value) {
            addCriterion("inOrgan >=", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganLessThan(String value) {
            addCriterion("inOrgan <", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganLessThanOrEqualTo(String value) {
            addCriterion("inOrgan <=", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganLike(String value) {
            addCriterion("inOrgan like", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganNotLike(String value) {
            addCriterion("inOrgan not like", value, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganIn(List<String> values) {
            addCriterion("inOrgan in", values, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganNotIn(List<String> values) {
            addCriterion("inOrgan not in", values, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganBetween(String value1, String value2) {
            addCriterion("inOrgan between", value1, value2, "inorgan");
            return (Criteria) this;
        }

        public Criteria andInorganNotBetween(String value1, String value2) {
            addCriterion("inOrgan not between", value1, value2, "inorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganIsNull() {
            addCriterion("outOrgan is null");
            return (Criteria) this;
        }

        public Criteria andOutorganIsNotNull() {
            addCriterion("outOrgan is not null");
            return (Criteria) this;
        }

        public Criteria andOutorganEqualTo(String value) {
            addCriterion("outOrgan =", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganNotEqualTo(String value) {
            addCriterion("outOrgan <>", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganGreaterThan(String value) {
            addCriterion("outOrgan >", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganGreaterThanOrEqualTo(String value) {
            addCriterion("outOrgan >=", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganLessThan(String value) {
            addCriterion("outOrgan <", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganLessThanOrEqualTo(String value) {
            addCriterion("outOrgan <=", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganLike(String value) {
            addCriterion("outOrgan like", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganNotLike(String value) {
            addCriterion("outOrgan not like", value, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganIn(List<String> values) {
            addCriterion("outOrgan in", values, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganNotIn(List<String> values) {
            addCriterion("outOrgan not in", values, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganBetween(String value1, String value2) {
            addCriterion("outOrgan between", value1, value2, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOutorganNotBetween(String value1, String value2) {
            addCriterion("outOrgan not between", value1, value2, "outorgan");
            return (Criteria) this;
        }

        public Criteria andOldnumIsNull() {
            addCriterion("oldNum is null");
            return (Criteria) this;
        }

        public Criteria andOldnumIsNotNull() {
            addCriterion("oldNum is not null");
            return (Criteria) this;
        }

        public Criteria andOldnumEqualTo(String value) {
            addCriterion("oldNum =", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumNotEqualTo(String value) {
            addCriterion("oldNum <>", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumGreaterThan(String value) {
            addCriterion("oldNum >", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumGreaterThanOrEqualTo(String value) {
            addCriterion("oldNum >=", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumLessThan(String value) {
            addCriterion("oldNum <", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumLessThanOrEqualTo(String value) {
            addCriterion("oldNum <=", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumLike(String value) {
            addCriterion("oldNum like", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumNotLike(String value) {
            addCriterion("oldNum not like", value, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumIn(List<String> values) {
            addCriterion("oldNum in", values, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumNotIn(List<String> values) {
            addCriterion("oldNum not in", values, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumBetween(String value1, String value2) {
            addCriterion("oldNum between", value1, value2, "oldnum");
            return (Criteria) this;
        }

        public Criteria andOldnumNotBetween(String value1, String value2) {
            addCriterion("oldNum not between", value1, value2, "oldnum");
            return (Criteria) this;
        }

        public Criteria andNewnumIsNull() {
            addCriterion("newNum is null");
            return (Criteria) this;
        }

        public Criteria andNewnumIsNotNull() {
            addCriterion("newNum is not null");
            return (Criteria) this;
        }

        public Criteria andNewnumEqualTo(String value) {
            addCriterion("newNum =", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumNotEqualTo(String value) {
            addCriterion("newNum <>", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumGreaterThan(String value) {
            addCriterion("newNum >", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumGreaterThanOrEqualTo(String value) {
            addCriterion("newNum >=", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumLessThan(String value) {
            addCriterion("newNum <", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumLessThanOrEqualTo(String value) {
            addCriterion("newNum <=", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumLike(String value) {
            addCriterion("newNum like", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumNotLike(String value) {
            addCriterion("newNum not like", value, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumIn(List<String> values) {
            addCriterion("newNum in", values, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumNotIn(List<String> values) {
            addCriterion("newNum not in", values, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumBetween(String value1, String value2) {
            addCriterion("newNum between", value1, value2, "newnum");
            return (Criteria) this;
        }

        public Criteria andNewnumNotBetween(String value1, String value2) {
            addCriterion("newNum not between", value1, value2, "newnum");
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

        public Criteria andRemovenumIsNull() {
            addCriterion("removeNum is null");
            return (Criteria) this;
        }

        public Criteria andRemovenumIsNotNull() {
            addCriterion("removeNum is not null");
            return (Criteria) this;
        }

        public Criteria andRemovenumEqualTo(String value) {
            addCriterion("removeNum =", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumNotEqualTo(String value) {
            addCriterion("removeNum <>", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumGreaterThan(String value) {
            addCriterion("removeNum >", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumGreaterThanOrEqualTo(String value) {
            addCriterion("removeNum >=", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumLessThan(String value) {
            addCriterion("removeNum <", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumLessThanOrEqualTo(String value) {
            addCriterion("removeNum <=", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumLike(String value) {
            addCriterion("removeNum like", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumNotLike(String value) {
            addCriterion("removeNum not like", value, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumIn(List<String> values) {
            addCriterion("removeNum in", values, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumNotIn(List<String> values) {
            addCriterion("removeNum not in", values, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumBetween(String value1, String value2) {
            addCriterion("removeNum between", value1, value2, "removenum");
            return (Criteria) this;
        }

        public Criteria andRemovenumNotBetween(String value1, String value2) {
            addCriterion("removeNum not between", value1, value2, "removenum");
            return (Criteria) this;
        }

        public Criteria andStatsIsNull() {
            addCriterion("stats is null");
            return (Criteria) this;
        }

        public Criteria andStatsIsNotNull() {
            addCriterion("stats is not null");
            return (Criteria) this;
        }

        public Criteria andStatsEqualTo(String value) {
            addCriterion("stats =", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotEqualTo(String value) {
            addCriterion("stats <>", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsGreaterThan(String value) {
            addCriterion("stats >", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsGreaterThanOrEqualTo(String value) {
            addCriterion("stats >=", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLessThan(String value) {
            addCriterion("stats <", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLessThanOrEqualTo(String value) {
            addCriterion("stats <=", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLike(String value) {
            addCriterion("stats like", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotLike(String value) {
            addCriterion("stats not like", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsIn(List<String> values) {
            addCriterion("stats in", values, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotIn(List<String> values) {
            addCriterion("stats not in", values, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsBetween(String value1, String value2) {
            addCriterion("stats between", value1, value2, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotBetween(String value1, String value2) {
            addCriterion("stats not between", value1, value2, "stats");
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

        public Criteria andRbeiyong1IsNull() {
            addCriterion("rbeiyong1 is null");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1IsNotNull() {
            addCriterion("rbeiyong1 is not null");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1EqualTo(String value) {
            addCriterion("rbeiyong1 =", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1NotEqualTo(String value) {
            addCriterion("rbeiyong1 <>", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1GreaterThan(String value) {
            addCriterion("rbeiyong1 >", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1GreaterThanOrEqualTo(String value) {
            addCriterion("rbeiyong1 >=", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1LessThan(String value) {
            addCriterion("rbeiyong1 <", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1LessThanOrEqualTo(String value) {
            addCriterion("rbeiyong1 <=", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1Like(String value) {
            addCriterion("rbeiyong1 like", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1NotLike(String value) {
            addCriterion("rbeiyong1 not like", value, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1In(List<String> values) {
            addCriterion("rbeiyong1 in", values, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1NotIn(List<String> values) {
            addCriterion("rbeiyong1 not in", values, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1Between(String value1, String value2) {
            addCriterion("rbeiyong1 between", value1, value2, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbeiyong1NotBetween(String value1, String value2) {
            addCriterion("rbeiyong1 not between", value1, value2, "rbeiyong1");
            return (Criteria) this;
        }

        public Criteria andRbieyong2IsNull() {
            addCriterion("rbieyong2 is null");
            return (Criteria) this;
        }

        public Criteria andRbieyong2IsNotNull() {
            addCriterion("rbieyong2 is not null");
            return (Criteria) this;
        }

        public Criteria andRbieyong2EqualTo(String value) {
            addCriterion("rbieyong2 =", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2NotEqualTo(String value) {
            addCriterion("rbieyong2 <>", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2GreaterThan(String value) {
            addCriterion("rbieyong2 >", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2GreaterThanOrEqualTo(String value) {
            addCriterion("rbieyong2 >=", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2LessThan(String value) {
            addCriterion("rbieyong2 <", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2LessThanOrEqualTo(String value) {
            addCriterion("rbieyong2 <=", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2Like(String value) {
            addCriterion("rbieyong2 like", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2NotLike(String value) {
            addCriterion("rbieyong2 not like", value, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2In(List<String> values) {
            addCriterion("rbieyong2 in", values, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2NotIn(List<String> values) {
            addCriterion("rbieyong2 not in", values, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2Between(String value1, String value2) {
            addCriterion("rbieyong2 between", value1, value2, "rbieyong2");
            return (Criteria) this;
        }

        public Criteria andRbieyong2NotBetween(String value1, String value2) {
            addCriterion("rbieyong2 not between", value1, value2, "rbieyong2");
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