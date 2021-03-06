package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.List;

public class CarTechnicalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarTechnicalExample() {
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

        public Criteria andTechnicalIdIsNull() {
            addCriterion("technical_id is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdIsNotNull() {
            addCriterion("technical_id is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdEqualTo(Integer value) {
            addCriterion("technical_id =", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdNotEqualTo(Integer value) {
            addCriterion("technical_id <>", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdGreaterThan(Integer value) {
            addCriterion("technical_id >", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("technical_id >=", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdLessThan(Integer value) {
            addCriterion("technical_id <", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdLessThanOrEqualTo(Integer value) {
            addCriterion("technical_id <=", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdIn(List<Integer> values) {
            addCriterion("technical_id in", values, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdNotIn(List<Integer> values) {
            addCriterion("technical_id not in", values, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdBetween(Integer value1, Integer value2) {
            addCriterion("technical_id between", value1, value2, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("technical_id not between", value1, value2, "technicalId");
            return (Criteria) this;
        }

        public Criteria andDriverfromIsNull() {
            addCriterion("driverFrom is null");
            return (Criteria) this;
        }

        public Criteria andDriverfromIsNotNull() {
            addCriterion("driverFrom is not null");
            return (Criteria) this;
        }

        public Criteria andDriverfromEqualTo(String value) {
            addCriterion("driverFrom =", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromNotEqualTo(String value) {
            addCriterion("driverFrom <>", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromGreaterThan(String value) {
            addCriterion("driverFrom >", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromGreaterThanOrEqualTo(String value) {
            addCriterion("driverFrom >=", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromLessThan(String value) {
            addCriterion("driverFrom <", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromLessThanOrEqualTo(String value) {
            addCriterion("driverFrom <=", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromLike(String value) {
            addCriterion("driverFrom like", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromNotLike(String value) {
            addCriterion("driverFrom not like", value, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromIn(List<String> values) {
            addCriterion("driverFrom in", values, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromNotIn(List<String> values) {
            addCriterion("driverFrom not in", values, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromBetween(String value1, String value2) {
            addCriterion("driverFrom between", value1, value2, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andDriverfromNotBetween(String value1, String value2) {
            addCriterion("driverFrom not between", value1, value2, "driverfrom");
            return (Criteria) this;
        }

        public Criteria andLidijianxiIsNull() {
            addCriterion("lidijianxi is null");
            return (Criteria) this;
        }

        public Criteria andLidijianxiIsNotNull() {
            addCriterion("lidijianxi is not null");
            return (Criteria) this;
        }

        public Criteria andLidijianxiEqualTo(String value) {
            addCriterion("lidijianxi =", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiNotEqualTo(String value) {
            addCriterion("lidijianxi <>", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiGreaterThan(String value) {
            addCriterion("lidijianxi >", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiGreaterThanOrEqualTo(String value) {
            addCriterion("lidijianxi >=", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiLessThan(String value) {
            addCriterion("lidijianxi <", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiLessThanOrEqualTo(String value) {
            addCriterion("lidijianxi <=", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiLike(String value) {
            addCriterion("lidijianxi like", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiNotLike(String value) {
            addCriterion("lidijianxi not like", value, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiIn(List<String> values) {
            addCriterion("lidijianxi in", values, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiNotIn(List<String> values) {
            addCriterion("lidijianxi not in", values, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiBetween(String value1, String value2) {
            addCriterion("lidijianxi between", value1, value2, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andLidijianxiNotBetween(String value1, String value2) {
            addCriterion("lidijianxi not between", value1, value2, "lidijianxi");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoIsNull() {
            addCriterion("jiejinjiao is null");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoIsNotNull() {
            addCriterion("jiejinjiao is not null");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoEqualTo(String value) {
            addCriterion("jiejinjiao =", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoNotEqualTo(String value) {
            addCriterion("jiejinjiao <>", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoGreaterThan(String value) {
            addCriterion("jiejinjiao >", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoGreaterThanOrEqualTo(String value) {
            addCriterion("jiejinjiao >=", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoLessThan(String value) {
            addCriterion("jiejinjiao <", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoLessThanOrEqualTo(String value) {
            addCriterion("jiejinjiao <=", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoLike(String value) {
            addCriterion("jiejinjiao like", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoNotLike(String value) {
            addCriterion("jiejinjiao not like", value, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoIn(List<String> values) {
            addCriterion("jiejinjiao in", values, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoNotIn(List<String> values) {
            addCriterion("jiejinjiao not in", values, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoBetween(String value1, String value2) {
            addCriterion("jiejinjiao between", value1, value2, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andJiejinjiaoNotBetween(String value1, String value2) {
            addCriterion("jiejinjiao not between", value1, value2, "jiejinjiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoIsNull() {
            addCriterion("liqujiao is null");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoIsNotNull() {
            addCriterion("liqujiao is not null");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoEqualTo(String value) {
            addCriterion("liqujiao =", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoNotEqualTo(String value) {
            addCriterion("liqujiao <>", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoGreaterThan(String value) {
            addCriterion("liqujiao >", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoGreaterThanOrEqualTo(String value) {
            addCriterion("liqujiao >=", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoLessThan(String value) {
            addCriterion("liqujiao <", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoLessThanOrEqualTo(String value) {
            addCriterion("liqujiao <=", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoLike(String value) {
            addCriterion("liqujiao like", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoNotLike(String value) {
            addCriterion("liqujiao not like", value, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoIn(List<String> values) {
            addCriterion("liqujiao in", values, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoNotIn(List<String> values) {
            addCriterion("liqujiao not in", values, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoBetween(String value1, String value2) {
            addCriterion("liqujiao between", value1, value2, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andLiqujiaoNotBetween(String value1, String value2) {
            addCriterion("liqujiao not between", value1, value2, "liqujiao");
            return (Criteria) this;
        }

        public Criteria andHighspeedIsNull() {
            addCriterion("highSpeed is null");
            return (Criteria) this;
        }

        public Criteria andHighspeedIsNotNull() {
            addCriterion("highSpeed is not null");
            return (Criteria) this;
        }

        public Criteria andHighspeedEqualTo(Integer value) {
            addCriterion("highSpeed =", value, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedNotEqualTo(Integer value) {
            addCriterion("highSpeed <>", value, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedGreaterThan(Integer value) {
            addCriterion("highSpeed >", value, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("highSpeed >=", value, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedLessThan(Integer value) {
            addCriterion("highSpeed <", value, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedLessThanOrEqualTo(Integer value) {
            addCriterion("highSpeed <=", value, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedIn(List<Integer> values) {
            addCriterion("highSpeed in", values, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedNotIn(List<Integer> values) {
            addCriterion("highSpeed not in", values, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedBetween(Integer value1, Integer value2) {
            addCriterion("highSpeed between", value1, value2, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighspeedNotBetween(Integer value1, Integer value2) {
            addCriterion("highSpeed not between", value1, value2, "highspeed");
            return (Criteria) this;
        }

        public Criteria andHighpapoIsNull() {
            addCriterion("highPaPo is null");
            return (Criteria) this;
        }

        public Criteria andHighpapoIsNotNull() {
            addCriterion("highPaPo is not null");
            return (Criteria) this;
        }

        public Criteria andHighpapoEqualTo(String value) {
            addCriterion("highPaPo =", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoNotEqualTo(String value) {
            addCriterion("highPaPo <>", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoGreaterThan(String value) {
            addCriterion("highPaPo >", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoGreaterThanOrEqualTo(String value) {
            addCriterion("highPaPo >=", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoLessThan(String value) {
            addCriterion("highPaPo <", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoLessThanOrEqualTo(String value) {
            addCriterion("highPaPo <=", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoLike(String value) {
            addCriterion("highPaPo like", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoNotLike(String value) {
            addCriterion("highPaPo not like", value, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoIn(List<String> values) {
            addCriterion("highPaPo in", values, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoNotIn(List<String> values) {
            addCriterion("highPaPo not in", values, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoBetween(String value1, String value2) {
            addCriterion("highPaPo between", value1, value2, "highpapo");
            return (Criteria) this;
        }

        public Criteria andHighpapoNotBetween(String value1, String value2) {
            addCriterion("highPaPo not between", value1, value2, "highpapo");
            return (Criteria) this;
        }

        public Criteria andTurnbodyIsNull() {
            addCriterion("turnBody is null");
            return (Criteria) this;
        }

        public Criteria andTurnbodyIsNotNull() {
            addCriterion("turnBody is not null");
            return (Criteria) this;
        }

        public Criteria andTurnbodyEqualTo(String value) {
            addCriterion("turnBody =", value, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyNotEqualTo(String value) {
            addCriterion("turnBody <>", value, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyGreaterThan(String value) {
            addCriterion("turnBody >", value, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyGreaterThanOrEqualTo(String value) {
            addCriterion("turnBody >=", value, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyLessThan(String value) {
            addCriterion("turnBody <", value, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyLessThanOrEqualTo(String value) {
            addCriterion("turnBody <=", value, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyIn(List<String> values) {
            addCriterion("turnBody in", values, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyNotIn(List<String> values) {
            addCriterion("turnBody not in", values, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyBetween(String value1, String value2) {
            addCriterion("turnBody between", value1, value2, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurnbodyNotBetween(String value1, String value2) {
            addCriterion("turnBody not between", value1, value2, "turnbody");
            return (Criteria) this;
        }

        public Criteria andTurntireIsNull() {
            addCriterion("turnTire is null");
            return (Criteria) this;
        }

        public Criteria andTurntireIsNotNull() {
            addCriterion("turnTire is not null");
            return (Criteria) this;
        }

        public Criteria andTurntireEqualTo(String value) {
            addCriterion("turnTire =", value, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireNotEqualTo(String value) {
            addCriterion("turnTire <>", value, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireGreaterThan(String value) {
            addCriterion("turnTire >", value, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireGreaterThanOrEqualTo(String value) {
            addCriterion("turnTire >=", value, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireLessThan(String value) {
            addCriterion("turnTire <", value, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireLessThanOrEqualTo(String value) {
            addCriterion("turnTire <=", value, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireIn(List<String> values) {
            addCriterion("turnTire in", values, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireNotIn(List<String> values) {
            addCriterion("turnTire not in", values, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireBetween(String value1, String value2) {
            addCriterion("turnTire between", value1, value2, "turntire");
            return (Criteria) this;
        }

        public Criteria andTurntireNotBetween(String value1, String value2) {
            addCriterion("turnTire not between", value1, value2, "turntire");
            return (Criteria) this;
        }

        public Criteria andDianhuocxIsNull() {
            addCriterion("dianhuoCX is null");
            return (Criteria) this;
        }

        public Criteria andDianhuocxIsNotNull() {
            addCriterion("dianhuoCX is not null");
            return (Criteria) this;
        }

        public Criteria andDianhuocxEqualTo(String value) {
            addCriterion("dianhuoCX =", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxNotEqualTo(String value) {
            addCriterion("dianhuoCX <>", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxGreaterThan(String value) {
            addCriterion("dianhuoCX >", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxGreaterThanOrEqualTo(String value) {
            addCriterion("dianhuoCX >=", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxLessThan(String value) {
            addCriterion("dianhuoCX <", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxLessThanOrEqualTo(String value) {
            addCriterion("dianhuoCX <=", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxLike(String value) {
            addCriterion("dianhuoCX like", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxNotLike(String value) {
            addCriterion("dianhuoCX not like", value, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxIn(List<String> values) {
            addCriterion("dianhuoCX in", values, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxNotIn(List<String> values) {
            addCriterion("dianhuoCX not in", values, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxBetween(String value1, String value2) {
            addCriterion("dianhuoCX between", value1, value2, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andDianhuocxNotBetween(String value1, String value2) {
            addCriterion("dianhuoCX not between", value1, value2, "dianhuocx");
            return (Criteria) this;
        }

        public Criteria andYasuobiIsNull() {
            addCriterion("yasuobi is null");
            return (Criteria) this;
        }

        public Criteria andYasuobiIsNotNull() {
            addCriterion("yasuobi is not null");
            return (Criteria) this;
        }

        public Criteria andYasuobiEqualTo(String value) {
            addCriterion("yasuobi =", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiNotEqualTo(String value) {
            addCriterion("yasuobi <>", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiGreaterThan(String value) {
            addCriterion("yasuobi >", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiGreaterThanOrEqualTo(String value) {
            addCriterion("yasuobi >=", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiLessThan(String value) {
            addCriterion("yasuobi <", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiLessThanOrEqualTo(String value) {
            addCriterion("yasuobi <=", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiLike(String value) {
            addCriterion("yasuobi like", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiNotLike(String value) {
            addCriterion("yasuobi not like", value, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiIn(List<String> values) {
            addCriterion("yasuobi in", values, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiNotIn(List<String> values) {
            addCriterion("yasuobi not in", values, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiBetween(String value1, String value2) {
            addCriterion("yasuobi between", value1, value2, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andYasuobiNotBetween(String value1, String value2) {
            addCriterion("yasuobi not between", value1, value2, "yasuobi");
            return (Criteria) this;
        }

        public Criteria andTireqyIsNull() {
            addCriterion("tireQY is null");
            return (Criteria) this;
        }

        public Criteria andTireqyIsNotNull() {
            addCriterion("tireQY is not null");
            return (Criteria) this;
        }

        public Criteria andTireqyEqualTo(String value) {
            addCriterion("tireQY =", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyNotEqualTo(String value) {
            addCriterion("tireQY <>", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyGreaterThan(String value) {
            addCriterion("tireQY >", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyGreaterThanOrEqualTo(String value) {
            addCriterion("tireQY >=", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyLessThan(String value) {
            addCriterion("tireQY <", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyLessThanOrEqualTo(String value) {
            addCriterion("tireQY <=", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyLike(String value) {
            addCriterion("tireQY like", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyNotLike(String value) {
            addCriterion("tireQY not like", value, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyIn(List<String> values) {
            addCriterion("tireQY in", values, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyNotIn(List<String> values) {
            addCriterion("tireQY not in", values, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyBetween(String value1, String value2) {
            addCriterion("tireQY between", value1, value2, "tireqy");
            return (Criteria) this;
        }

        public Criteria andTireqyNotBetween(String value1, String value2) {
            addCriterion("tireQY not between", value1, value2, "tireqy");
            return (Criteria) this;
        }

        public Criteria andRanyouclIsNull() {
            addCriterion("ranyouCL is null");
            return (Criteria) this;
        }

        public Criteria andRanyouclIsNotNull() {
            addCriterion("ranyouCL is not null");
            return (Criteria) this;
        }

        public Criteria andRanyouclEqualTo(String value) {
            addCriterion("ranyouCL =", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclNotEqualTo(String value) {
            addCriterion("ranyouCL <>", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclGreaterThan(String value) {
            addCriterion("ranyouCL >", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclGreaterThanOrEqualTo(String value) {
            addCriterion("ranyouCL >=", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclLessThan(String value) {
            addCriterion("ranyouCL <", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclLessThanOrEqualTo(String value) {
            addCriterion("ranyouCL <=", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclLike(String value) {
            addCriterion("ranyouCL like", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclNotLike(String value) {
            addCriterion("ranyouCL not like", value, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclIn(List<String> values) {
            addCriterion("ranyouCL in", values, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclNotIn(List<String> values) {
            addCriterion("ranyouCL not in", values, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclBetween(String value1, String value2) {
            addCriterion("ranyouCL between", value1, value2, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andRanyouclNotBetween(String value1, String value2) {
            addCriterion("ranyouCL not between", value1, value2, "ranyoucl");
            return (Criteria) this;
        }

        public Criteria andDianchixhIsNull() {
            addCriterion("dianchiXH is null");
            return (Criteria) this;
        }

        public Criteria andDianchixhIsNotNull() {
            addCriterion("dianchiXH is not null");
            return (Criteria) this;
        }

        public Criteria andDianchixhEqualTo(String value) {
            addCriterion("dianchiXH =", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhNotEqualTo(String value) {
            addCriterion("dianchiXH <>", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhGreaterThan(String value) {
            addCriterion("dianchiXH >", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhGreaterThanOrEqualTo(String value) {
            addCriterion("dianchiXH >=", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhLessThan(String value) {
            addCriterion("dianchiXH <", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhLessThanOrEqualTo(String value) {
            addCriterion("dianchiXH <=", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhLike(String value) {
            addCriterion("dianchiXH like", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhNotLike(String value) {
            addCriterion("dianchiXH not like", value, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhIn(List<String> values) {
            addCriterion("dianchiXH in", values, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhNotIn(List<String> values) {
            addCriterion("dianchiXH not in", values, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhBetween(String value1, String value2) {
            addCriterion("dianchiXH between", value1, value2, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andDianchixhNotBetween(String value1, String value2) {
            addCriterion("dianchiXH not between", value1, value2, "dianchixh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhIsNull() {
            addCriterion("ranyouBH is null");
            return (Criteria) this;
        }

        public Criteria andRanyoubhIsNotNull() {
            addCriterion("ranyouBH is not null");
            return (Criteria) this;
        }

        public Criteria andRanyoubhEqualTo(String value) {
            addCriterion("ranyouBH =", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhNotEqualTo(String value) {
            addCriterion("ranyouBH <>", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhGreaterThan(String value) {
            addCriterion("ranyouBH >", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhGreaterThanOrEqualTo(String value) {
            addCriterion("ranyouBH >=", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhLessThan(String value) {
            addCriterion("ranyouBH <", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhLessThanOrEqualTo(String value) {
            addCriterion("ranyouBH <=", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhLike(String value) {
            addCriterion("ranyouBH like", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhNotLike(String value) {
            addCriterion("ranyouBH not like", value, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhIn(List<String> values) {
            addCriterion("ranyouBH in", values, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhNotIn(List<String> values) {
            addCriterion("ranyouBH not in", values, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhBetween(String value1, String value2) {
            addCriterion("ranyouBH between", value1, value2, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andRanyoubhNotBetween(String value1, String value2) {
            addCriterion("ranyouBH not between", value1, value2, "ranyoubh");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelIsNull() {
            addCriterion("hundredsFuel is null");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelIsNotNull() {
            addCriterion("hundredsFuel is not null");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelEqualTo(String value) {
            addCriterion("hundredsFuel =", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelNotEqualTo(String value) {
            addCriterion("hundredsFuel <>", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelGreaterThan(String value) {
            addCriterion("hundredsFuel >", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelGreaterThanOrEqualTo(String value) {
            addCriterion("hundredsFuel >=", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelLessThan(String value) {
            addCriterion("hundredsFuel <", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelLessThanOrEqualTo(String value) {
            addCriterion("hundredsFuel <=", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelLike(String value) {
            addCriterion("hundredsFuel like", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelNotLike(String value) {
            addCriterion("hundredsFuel not like", value, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelIn(List<String> values) {
            addCriterion("hundredsFuel in", values, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelNotIn(List<String> values) {
            addCriterion("hundredsFuel not in", values, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelBetween(String value1, String value2) {
            addCriterion("hundredsFuel between", value1, value2, "hundredsfuel");
            return (Criteria) this;
        }

        public Criteria andHundredsfuelNotBetween(String value1, String value2) {
            addCriterion("hundredsFuel not between", value1, value2, "hundredsfuel");
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