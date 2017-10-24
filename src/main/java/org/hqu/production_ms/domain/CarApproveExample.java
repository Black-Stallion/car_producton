package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarApproveExample {
	 protected String orderByClause;

	    protected boolean distinct;

	    protected List<Criteria> oredCriteria;

	    public CarApproveExample() {
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

	        public Criteria andBianhaoIsNull() {
	            addCriterion("bianhao is null");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoIsNotNull() {
	            addCriterion("bianhao is not null");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoEqualTo(String value) {
	            addCriterion("bianhao =", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoNotEqualTo(String value) {
	            addCriterion("bianhao <>", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoGreaterThan(String value) {
	            addCriterion("bianhao >", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoGreaterThanOrEqualTo(String value) {
	            addCriterion("bianhao >=", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoLessThan(String value) {
	            addCriterion("bianhao <", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoLessThanOrEqualTo(String value) {
	            addCriterion("bianhao <=", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoLike(String value) {
	            addCriterion("bianhao like", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoNotLike(String value) {
	            addCriterion("bianhao not like", value, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoIn(List<String> values) {
	            addCriterion("bianhao in", values, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoNotIn(List<String> values) {
	            addCriterion("bianhao not in", values, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoBetween(String value1, String value2) {
	            addCriterion("bianhao between", value1, value2, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andBianhaoNotBetween(String value1, String value2) {
	            addCriterion("bianhao not between", value1, value2, "bianhao");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameIsNull() {
	            addCriterion("applyname is null");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameIsNotNull() {
	            addCriterion("applyname is not null");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameEqualTo(String value) {
	            addCriterion("applyname =", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameNotEqualTo(String value) {
	            addCriterion("applyname <>", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameGreaterThan(String value) {
	            addCriterion("applyname >", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameGreaterThanOrEqualTo(String value) {
	            addCriterion("applyname >=", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameLessThan(String value) {
	            addCriterion("applyname <", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameLessThanOrEqualTo(String value) {
	            addCriterion("applyname <=", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameLike(String value) {
	            addCriterion("applyname like", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameNotLike(String value) {
	            addCriterion("applyname not like", value, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameIn(List<String> values) {
	            addCriterion("applyname in", values, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameNotIn(List<String> values) {
	            addCriterion("applyname not in", values, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameBetween(String value1, String value2) {
	            addCriterion("applyname between", value1, value2, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApplynameNotBetween(String value1, String value2) {
	            addCriterion("applyname not between", value1, value2, "applyname");
	            return (Criteria) this;
	        }

	        public Criteria andApproveIsNull() {
	            addCriterion("approve is null");
	            return (Criteria) this;
	        }

	        public Criteria andApproveIsNotNull() {
	            addCriterion("approve is not null");
	            return (Criteria) this;
	        }

	        public Criteria andApproveEqualTo(String value) {
	            addCriterion("approve =", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveNotEqualTo(String value) {
	            addCriterion("approve <>", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveGreaterThan(String value) {
	            addCriterion("approve >", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveGreaterThanOrEqualTo(String value) {
	            addCriterion("approve >=", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveLessThan(String value) {
	            addCriterion("approve <", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveLessThanOrEqualTo(String value) {
	            addCriterion("approve <=", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveLike(String value) {
	            addCriterion("approve like", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveNotLike(String value) {
	            addCriterion("approve not like", value, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveIn(List<String> values) {
	            addCriterion("approve in", values, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveNotIn(List<String> values) {
	            addCriterion("approve not in", values, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveBetween(String value1, String value2) {
	            addCriterion("approve between", value1, value2, "approve");
	            return (Criteria) this;
	        }

	        public Criteria andApproveNotBetween(String value1, String value2) {
	            addCriterion("approve not between", value1, value2, "approve");
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

	        public Criteria andPeopleIsNull() {
	            addCriterion("people is null");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleIsNotNull() {
	            addCriterion("people is not null");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleEqualTo(Integer value) {
	            addCriterion("people =", value, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleNotEqualTo(Integer value) {
	            addCriterion("people <>", value, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleGreaterThan(Integer value) {
	            addCriterion("people >", value, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleGreaterThanOrEqualTo(Integer value) {
	            addCriterion("people >=", value, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleLessThan(Integer value) {
	            addCriterion("people <", value, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleLessThanOrEqualTo(Integer value) {
	            addCriterion("people <=", value, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleIn(List<Integer> values) {
	            addCriterion("people in", values, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleNotIn(List<Integer> values) {
	            addCriterion("people not in", values, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleBetween(Integer value1, Integer value2) {
	            addCriterion("people between", value1, value2, "people");
	            return (Criteria) this;
	        }

	        public Criteria andPeopleNotBetween(Integer value1, Integer value2) {
	            addCriterion("people not between", value1, value2, "people");
	            return (Criteria) this;
	        }

	        public Criteria andThingIsNull() {
	            addCriterion("thing is null");
	            return (Criteria) this;
	        }

	        public Criteria andThingIsNotNull() {
	            addCriterion("thing is not null");
	            return (Criteria) this;
	        }

	        public Criteria andThingEqualTo(String value) {
	            addCriterion("thing =", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingNotEqualTo(String value) {
	            addCriterion("thing <>", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingGreaterThan(String value) {
	            addCriterion("thing >", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingGreaterThanOrEqualTo(String value) {
	            addCriterion("thing >=", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingLessThan(String value) {
	            addCriterion("thing <", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingLessThanOrEqualTo(String value) {
	            addCriterion("thing <=", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingLike(String value) {
	            addCriterion("thing like", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingNotLike(String value) {
	            addCriterion("thing not like", value, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingIn(List<String> values) {
	            addCriterion("thing in", values, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingNotIn(List<String> values) {
	            addCriterion("thing not in", values, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingBetween(String value1, String value2) {
	            addCriterion("thing between", value1, value2, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andThingNotBetween(String value1, String value2) {
	            addCriterion("thing not between", value1, value2, "thing");
	            return (Criteria) this;
	        }

	        public Criteria andDaysIsNull() {
	            addCriterion("days is null");
	            return (Criteria) this;
	        }

	        public Criteria andDaysIsNotNull() {
	            addCriterion("days is not null");
	            return (Criteria) this;
	        }

	        public Criteria andDaysEqualTo(String value) {
	            addCriterion("days =", value, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysNotEqualTo(String value) {
	            addCriterion("days <>", value, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysGreaterThan(String value) {
	            addCriterion("days >", value, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysGreaterThanOrEqualTo(String value) {
	            addCriterion("days >=", value, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysLessThan(String value) {
	            addCriterion("days <", value, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysLessThanOrEqualTo(String value) {
	            addCriterion("days <=", value, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysIn(List<String> values) {
	            addCriterion("days in", values, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysNotIn(List<String> values) {
	            addCriterion("days not in", values, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysBetween(String value1, String value2) {
	            addCriterion("days between", value1, value2, "days");
	            return (Criteria) this;
	        }

	        public Criteria andDaysNotBetween(String value1, String value2) {
	            addCriterion("days not between", value1, value2, "days");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeIsNull() {
	            addCriterion("outtime is null");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeIsNotNull() {
	            addCriterion("outtime is not null");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeEqualTo(Date value) {
	            addCriterion("outtime =", value, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeNotEqualTo(Date value) {
	            addCriterion("outtime <>", value, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeGreaterThan(Date value) {
	            addCriterion("outtime >", value, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("outtime >=", value, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeLessThan(Date value) {
	            addCriterion("outtime <", value, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeLessThanOrEqualTo(Date value) {
	            addCriterion("outtime <=", value, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeIn(List<Date> values) {
	            addCriterion("outtime in", values, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeNotIn(List<Date> values) {
	            addCriterion("outtime not in", values, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeBetween(Date value1, Date value2) {
	            addCriterion("outtime between", value1, value2, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andOuttimeNotBetween(Date value1, Date value2) {
	            addCriterion("outtime not between", value1, value2, "outtime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeIsNull() {
	            addCriterion("applytime is null");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeIsNotNull() {
	            addCriterion("applytime is not null");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeEqualTo(Date value) {
	            addCriterion("applytime =", value, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeNotEqualTo(Date value) {
	            addCriterion("applytime <>", value, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeGreaterThan(Date value) {
	            addCriterion("applytime >", value, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("applytime >=", value, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeLessThan(Date value) {
	            addCriterion("applytime <", value, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
	            addCriterion("applytime <=", value, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeIn(List<Date> values) {
	            addCriterion("applytime in", values, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeNotIn(List<Date> values) {
	            addCriterion("applytime not in", values, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeBetween(Date value1, Date value2) {
	            addCriterion("applytime between", value1, value2, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
	            addCriterion("applytime not between", value1, value2, "applytime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeIsNull() {
	            addCriterion("approvetime is null");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeIsNotNull() {
	            addCriterion("approvetime is not null");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeEqualTo(Date value) {
	            addCriterion("approvetime =", value, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeNotEqualTo(Date value) {
	            addCriterion("approvetime <>", value, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeGreaterThan(Date value) {
	            addCriterion("approvetime >", value, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeGreaterThanOrEqualTo(Date value) {
	            addCriterion("approvetime >=", value, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeLessThan(Date value) {
	            addCriterion("approvetime <", value, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeLessThanOrEqualTo(Date value) {
	            addCriterion("approvetime <=", value, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeIn(List<Date> values) {
	            addCriterion("approvetime in", values, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeNotIn(List<Date> values) {
	            addCriterion("approvetime not in", values, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeBetween(Date value1, Date value2) {
	            addCriterion("approvetime between", value1, value2, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andApprovetimeNotBetween(Date value1, Date value2) {
	            addCriterion("approvetime not between", value1, value2, "approvetime");
	            return (Criteria) this;
	        }

	        public Criteria andDriverIsNull() {
	            addCriterion("driver is null");
	            return (Criteria) this;
	        }

	        public Criteria andDriverIsNotNull() {
	            addCriterion("driver is not null");
	            return (Criteria) this;
	        }

	        public Criteria andDriverEqualTo(String value) {
	            addCriterion("driver =", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverNotEqualTo(String value) {
	            addCriterion("driver <>", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverGreaterThan(String value) {
	            addCriterion("driver >", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverGreaterThanOrEqualTo(String value) {
	            addCriterion("driver >=", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverLessThan(String value) {
	            addCriterion("driver <", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverLessThanOrEqualTo(String value) {
	            addCriterion("driver <=", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverLike(String value) {
	            addCriterion("driver like", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverNotLike(String value) {
	            addCriterion("driver not like", value, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverIn(List<String> values) {
	            addCriterion("driver in", values, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverNotIn(List<String> values) {
	            addCriterion("driver not in", values, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverBetween(String value1, String value2) {
	            addCriterion("driver between", value1, value2, "driver");
	            return (Criteria) this;
	        }

	        public Criteria andDriverNotBetween(String value1, String value2) {
	            addCriterion("driver not between", value1, value2, "driver");
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

	        public Criteria andUsenatureIsNull() {
	            addCriterion("usenature is null");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureIsNotNull() {
	            addCriterion("usenature is not null");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureEqualTo(String value) {
	            addCriterion("usenature =", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureNotEqualTo(String value) {
	            addCriterion("usenature <>", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureGreaterThan(String value) {
	            addCriterion("usenature >", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureGreaterThanOrEqualTo(String value) {
	            addCriterion("usenature >=", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureLessThan(String value) {
	            addCriterion("usenature <", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureLessThanOrEqualTo(String value) {
	            addCriterion("usenature <=", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureLike(String value) {
	            addCriterion("usenature like", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureNotLike(String value) {
	            addCriterion("usenature not like", value, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureIn(List<String> values) {
	            addCriterion("usenature in", values, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureNotIn(List<String> values) {
	            addCriterion("usenature not in", values, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureBetween(String value1, String value2) {
	            addCriterion("usenature between", value1, value2, "usenature");
	            return (Criteria) this;
	        }

	        public Criteria andUsenatureNotBetween(String value1, String value2) {
	            addCriterion("usenature not between", value1, value2, "usenature");
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
