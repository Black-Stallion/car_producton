package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.List;

public class CarUsingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarUsingExample() {
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

        public Criteria andUsingIdIsNull() {
            addCriterion("using_id is null");
            return (Criteria) this;
        }

        public Criteria andUsingIdIsNotNull() {
            addCriterion("using_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsingIdEqualTo(Integer value) {
            addCriterion("using_id =", value, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdNotEqualTo(Integer value) {
            addCriterion("using_id <>", value, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdGreaterThan(Integer value) {
            addCriterion("using_id >", value, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("using_id >=", value, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdLessThan(Integer value) {
            addCriterion("using_id <", value, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdLessThanOrEqualTo(Integer value) {
            addCriterion("using_id <=", value, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdIn(List<Integer> values) {
            addCriterion("using_id in", values, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdNotIn(List<Integer> values) {
            addCriterion("using_id not in", values, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdBetween(Integer value1, Integer value2) {
            addCriterion("using_id between", value1, value2, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("using_id not between", value1, value2, "usingId");
            return (Criteria) this;
        }

        public Criteria andUsingyearIsNull() {
            addCriterion("usingyear is null");
            return (Criteria) this;
        }

        public Criteria andUsingyearIsNotNull() {
            addCriterion("usingyear is not null");
            return (Criteria) this;
        }

        public Criteria andUsingyearEqualTo(Integer value) {
            addCriterion("usingyear =", value, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearNotEqualTo(Integer value) {
            addCriterion("usingyear <>", value, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearGreaterThan(Integer value) {
            addCriterion("usingyear >", value, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearGreaterThanOrEqualTo(Integer value) {
            addCriterion("usingyear >=", value, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearLessThan(Integer value) {
            addCriterion("usingyear <", value, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearLessThanOrEqualTo(Integer value) {
            addCriterion("usingyear <=", value, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearIn(List<Integer> values) {
            addCriterion("usingyear in", values, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearNotIn(List<Integer> values) {
            addCriterion("usingyear not in", values, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearBetween(Integer value1, Integer value2) {
            addCriterion("usingyear between", value1, value2, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingyearNotBetween(Integer value1, Integer value2) {
            addCriterion("usingyear not between", value1, value2, "usingyear");
            return (Criteria) this;
        }

        public Criteria andUsingmonthIsNull() {
            addCriterion("usingMonth is null");
            return (Criteria) this;
        }

        public Criteria andUsingmonthIsNotNull() {
            addCriterion("usingMonth is not null");
            return (Criteria) this;
        }

        public Criteria andUsingmonthEqualTo(Integer value) {
            addCriterion("usingMonth =", value, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthNotEqualTo(Integer value) {
            addCriterion("usingMonth <>", value, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthGreaterThan(Integer value) {
            addCriterion("usingMonth >", value, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("usingMonth >=", value, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthLessThan(Integer value) {
            addCriterion("usingMonth <", value, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthLessThanOrEqualTo(Integer value) {
            addCriterion("usingMonth <=", value, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthIn(List<Integer> values) {
            addCriterion("usingMonth in", values, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthNotIn(List<Integer> values) {
            addCriterion("usingMonth not in", values, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthBetween(Integer value1, Integer value2) {
            addCriterion("usingMonth between", value1, value2, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andUsingmonthNotBetween(Integer value1, Integer value2) {
            addCriterion("usingMonth not between", value1, value2, "usingmonth");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersIsNull() {
            addCriterion("monthNumbers is null");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersIsNotNull() {
            addCriterion("monthNumbers is not null");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersEqualTo(String value) {
            addCriterion("monthNumbers =", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersNotEqualTo(String value) {
            addCriterion("monthNumbers <>", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersGreaterThan(String value) {
            addCriterion("monthNumbers >", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersGreaterThanOrEqualTo(String value) {
            addCriterion("monthNumbers >=", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersLessThan(String value) {
            addCriterion("monthNumbers <", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersLessThanOrEqualTo(String value) {
            addCriterion("monthNumbers <=", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersLike(String value) {
            addCriterion("monthNumbers like", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersNotLike(String value) {
            addCriterion("monthNumbers not like", value, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersIn(List<String> values) {
            addCriterion("monthNumbers in", values, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersNotIn(List<String> values) {
            addCriterion("monthNumbers not in", values, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersBetween(String value1, String value2) {
            addCriterion("monthNumbers between", value1, value2, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthnumbersNotBetween(String value1, String value2) {
            addCriterion("monthNumbers not between", value1, value2, "monthnumbers");
            return (Criteria) this;
        }

        public Criteria andMonthkmIsNull() {
            addCriterion("monthKM is null");
            return (Criteria) this;
        }

        public Criteria andMonthkmIsNotNull() {
            addCriterion("monthKM is not null");
            return (Criteria) this;
        }

        public Criteria andMonthkmEqualTo(String value) {
            addCriterion("monthKM =", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmNotEqualTo(String value) {
            addCriterion("monthKM <>", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmGreaterThan(String value) {
            addCriterion("monthKM >", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmGreaterThanOrEqualTo(String value) {
            addCriterion("monthKM >=", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmLessThan(String value) {
            addCriterion("monthKM <", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmLessThanOrEqualTo(String value) {
            addCriterion("monthKM <=", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmLike(String value) {
            addCriterion("monthKM like", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmNotLike(String value) {
            addCriterion("monthKM not like", value, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmIn(List<String> values) {
            addCriterion("monthKM in", values, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmNotIn(List<String> values) {
            addCriterion("monthKM not in", values, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmBetween(String value1, String value2) {
            addCriterion("monthKM between", value1, value2, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthkmNotBetween(String value1, String value2) {
            addCriterion("monthKM not between", value1, value2, "monthkm");
            return (Criteria) this;
        }

        public Criteria andMonthtimeIsNull() {
            addCriterion("monthTime is null");
            return (Criteria) this;
        }

        public Criteria andMonthtimeIsNotNull() {
            addCriterion("monthTime is not null");
            return (Criteria) this;
        }

        public Criteria andMonthtimeEqualTo(String value) {
            addCriterion("monthTime =", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeNotEqualTo(String value) {
            addCriterion("monthTime <>", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeGreaterThan(String value) {
            addCriterion("monthTime >", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeGreaterThanOrEqualTo(String value) {
            addCriterion("monthTime >=", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeLessThan(String value) {
            addCriterion("monthTime <", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeLessThanOrEqualTo(String value) {
            addCriterion("monthTime <=", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeLike(String value) {
            addCriterion("monthTime like", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeNotLike(String value) {
            addCriterion("monthTime not like", value, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeIn(List<String> values) {
            addCriterion("monthTime in", values, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeNotIn(List<String> values) {
            addCriterion("monthTime not in", values, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeBetween(String value1, String value2) {
            addCriterion("monthTime between", value1, value2, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthtimeNotBetween(String value1, String value2) {
            addCriterion("monthTime not between", value1, value2, "monthtime");
            return (Criteria) this;
        }

        public Criteria andMonthdaysIsNull() {
            addCriterion("monthDays is null");
            return (Criteria) this;
        }

        public Criteria andMonthdaysIsNotNull() {
            addCriterion("monthDays is not null");
            return (Criteria) this;
        }

        public Criteria andMonthdaysEqualTo(String value) {
            addCriterion("monthDays =", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysNotEqualTo(String value) {
            addCriterion("monthDays <>", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysGreaterThan(String value) {
            addCriterion("monthDays >", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysGreaterThanOrEqualTo(String value) {
            addCriterion("monthDays >=", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysLessThan(String value) {
            addCriterion("monthDays <", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysLessThanOrEqualTo(String value) {
            addCriterion("monthDays <=", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysLike(String value) {
            addCriterion("monthDays like", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysNotLike(String value) {
            addCriterion("monthDays not like", value, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysIn(List<String> values) {
            addCriterion("monthDays in", values, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysNotIn(List<String> values) {
            addCriterion("monthDays not in", values, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysBetween(String value1, String value2) {
            addCriterion("monthDays between", value1, value2, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthdaysNotBetween(String value1, String value2) {
            addCriterion("monthDays not between", value1, value2, "monthdays");
            return (Criteria) this;
        }

        public Criteria andMonthryIsNull() {
            addCriterion("monthRY is null");
            return (Criteria) this;
        }

        public Criteria andMonthryIsNotNull() {
            addCriterion("monthRY is not null");
            return (Criteria) this;
        }

        public Criteria andMonthryEqualTo(String value) {
            addCriterion("monthRY =", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryNotEqualTo(String value) {
            addCriterion("monthRY <>", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryGreaterThan(String value) {
            addCriterion("monthRY >", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryGreaterThanOrEqualTo(String value) {
            addCriterion("monthRY >=", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryLessThan(String value) {
            addCriterion("monthRY <", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryLessThanOrEqualTo(String value) {
            addCriterion("monthRY <=", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryLike(String value) {
            addCriterion("monthRY like", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryNotLike(String value) {
            addCriterion("monthRY not like", value, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryIn(List<String> values) {
            addCriterion("monthRY in", values, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryNotIn(List<String> values) {
            addCriterion("monthRY not in", values, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryBetween(String value1, String value2) {
            addCriterion("monthRY between", value1, value2, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthryNotBetween(String value1, String value2) {
            addCriterion("monthRY not between", value1, value2, "monthry");
            return (Criteria) this;
        }

        public Criteria andMonthrhyIsNull() {
            addCriterion("monthRHY is null");
            return (Criteria) this;
        }

        public Criteria andMonthrhyIsNotNull() {
            addCriterion("monthRHY is not null");
            return (Criteria) this;
        }

        public Criteria andMonthrhyEqualTo(String value) {
            addCriterion("monthRHY =", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyNotEqualTo(String value) {
            addCriterion("monthRHY <>", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyGreaterThan(String value) {
            addCriterion("monthRHY >", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyGreaterThanOrEqualTo(String value) {
            addCriterion("monthRHY >=", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyLessThan(String value) {
            addCriterion("monthRHY <", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyLessThanOrEqualTo(String value) {
            addCriterion("monthRHY <=", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyLike(String value) {
            addCriterion("monthRHY like", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyNotLike(String value) {
            addCriterion("monthRHY not like", value, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyIn(List<String> values) {
            addCriterion("monthRHY in", values, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyNotIn(List<String> values) {
            addCriterion("monthRHY not in", values, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyBetween(String value1, String value2) {
            addCriterion("monthRHY between", value1, value2, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andMonthrhyNotBetween(String value1, String value2) {
            addCriterion("monthRHY not between", value1, value2, "monthrhy");
            return (Criteria) this;
        }

        public Criteria andHaoyouIsNull() {
            addCriterion("haoyou is null");
            return (Criteria) this;
        }

        public Criteria andHaoyouIsNotNull() {
            addCriterion("haoyou is not null");
            return (Criteria) this;
        }

        public Criteria andHaoyouEqualTo(String value) {
            addCriterion("haoyou =", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouNotEqualTo(String value) {
            addCriterion("haoyou <>", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouGreaterThan(String value) {
            addCriterion("haoyou >", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouGreaterThanOrEqualTo(String value) {
            addCriterion("haoyou >=", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouLessThan(String value) {
            addCriterion("haoyou <", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouLessThanOrEqualTo(String value) {
            addCriterion("haoyou <=", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouLike(String value) {
            addCriterion("haoyou like", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouNotLike(String value) {
            addCriterion("haoyou not like", value, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouIn(List<String> values) {
            addCriterion("haoyou in", values, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouNotIn(List<String> values) {
            addCriterion("haoyou not in", values, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouBetween(String value1, String value2) {
            addCriterion("haoyou between", value1, value2, "haoyou");
            return (Criteria) this;
        }

        public Criteria andHaoyouNotBetween(String value1, String value2) {
            addCriterion("haoyou not between", value1, value2, "haoyou");
            return (Criteria) this;
        }

        public Criteria andKindscostIsNull() {
            addCriterion("kindscost is null");
            return (Criteria) this;
        }

        public Criteria andKindscostIsNotNull() {
            addCriterion("kindscost is not null");
            return (Criteria) this;
        }

        public Criteria andKindscostEqualTo(String value) {
            addCriterion("kindscost =", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostNotEqualTo(String value) {
            addCriterion("kindscost <>", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostGreaterThan(String value) {
            addCriterion("kindscost >", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostGreaterThanOrEqualTo(String value) {
            addCriterion("kindscost >=", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostLessThan(String value) {
            addCriterion("kindscost <", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostLessThanOrEqualTo(String value) {
            addCriterion("kindscost <=", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostLike(String value) {
            addCriterion("kindscost like", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostNotLike(String value) {
            addCriterion("kindscost not like", value, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostIn(List<String> values) {
            addCriterion("kindscost in", values, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostNotIn(List<String> values) {
            addCriterion("kindscost not in", values, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostBetween(String value1, String value2) {
            addCriterion("kindscost between", value1, value2, "kindscost");
            return (Criteria) this;
        }

        public Criteria andKindscostNotBetween(String value1, String value2) {
            addCriterion("kindscost not between", value1, value2, "kindscost");
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