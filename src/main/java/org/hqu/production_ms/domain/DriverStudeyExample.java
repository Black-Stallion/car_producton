package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DriverStudeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriverStudeyExample() {
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

        public Criteria andStudyIdIsNull() {
            addCriterion("study_id is null");
            return (Criteria) this;
        }

        public Criteria andStudyIdIsNotNull() {
            addCriterion("study_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudyIdEqualTo(Integer value) {
            addCriterion("study_id =", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotEqualTo(Integer value) {
            addCriterion("study_id <>", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThan(Integer value) {
            addCriterion("study_id >", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_id >=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThan(Integer value) {
            addCriterion("study_id <", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThanOrEqualTo(Integer value) {
            addCriterion("study_id <=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdIn(List<Integer> values) {
            addCriterion("study_id in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotIn(List<Integer> values) {
            addCriterion("study_id not in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdBetween(Integer value1, Integer value2) {
            addCriterion("study_id between", value1, value2, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("study_id not between", value1, value2, "studyId");
            return (Criteria) this;
        }

        public Criteria andStutimeIsNull() {
            addCriterion("stutime is null");
            return (Criteria) this;
        }

        public Criteria andStutimeIsNotNull() {
            addCriterion("stutime is not null");
            return (Criteria) this;
        }

        public Criteria andStutimeEqualTo(Date value) {
            addCriterion("stutime =", value, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeNotEqualTo(Date value) {
            addCriterion("stutime <>", value, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeGreaterThan(Date value) {
            addCriterion("stutime >", value, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stutime >=", value, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeLessThan(Date value) {
            addCriterion("stutime <", value, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeLessThanOrEqualTo(Date value) {
            addCriterion("stutime <=", value, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeIn(List<Date> values) {
            addCriterion("stutime in", values, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeNotIn(List<Date> values) {
            addCriterion("stutime not in", values, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeBetween(Date value1, Date value2) {
            addCriterion("stutime between", value1, value2, "stutime");
            return (Criteria) this;
        }

        public Criteria andStutimeNotBetween(Date value1, Date value2) {
            addCriterion("stutime not between", value1, value2, "stutime");
            return (Criteria) this;
        }

        public Criteria andZhuchirenIsNull() {
            addCriterion("zhuchiren is null");
            return (Criteria) this;
        }

        public Criteria andZhuchirenIsNotNull() {
            addCriterion("zhuchiren is not null");
            return (Criteria) this;
        }

        public Criteria andZhuchirenEqualTo(String value) {
            addCriterion("zhuchiren =", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenNotEqualTo(String value) {
            addCriterion("zhuchiren <>", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenGreaterThan(String value) {
            addCriterion("zhuchiren >", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenGreaterThanOrEqualTo(String value) {
            addCriterion("zhuchiren >=", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenLessThan(String value) {
            addCriterion("zhuchiren <", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenLessThanOrEqualTo(String value) {
            addCriterion("zhuchiren <=", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenLike(String value) {
            addCriterion("zhuchiren like", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenNotLike(String value) {
            addCriterion("zhuchiren not like", value, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenIn(List<String> values) {
            addCriterion("zhuchiren in", values, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenNotIn(List<String> values) {
            addCriterion("zhuchiren not in", values, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenBetween(String value1, String value2) {
            addCriterion("zhuchiren between", value1, value2, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andZhuchirenNotBetween(String value1, String value2) {
            addCriterion("zhuchiren not between", value1, value2, "zhuchiren");
            return (Criteria) this;
        }

        public Criteria andYingdaoIsNull() {
            addCriterion("yingdao is null");
            return (Criteria) this;
        }

        public Criteria andYingdaoIsNotNull() {
            addCriterion("yingdao is not null");
            return (Criteria) this;
        }

        public Criteria andYingdaoEqualTo(String value) {
            addCriterion("yingdao =", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoNotEqualTo(String value) {
            addCriterion("yingdao <>", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoGreaterThan(String value) {
            addCriterion("yingdao >", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoGreaterThanOrEqualTo(String value) {
            addCriterion("yingdao >=", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoLessThan(String value) {
            addCriterion("yingdao <", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoLessThanOrEqualTo(String value) {
            addCriterion("yingdao <=", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoLike(String value) {
            addCriterion("yingdao like", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoNotLike(String value) {
            addCriterion("yingdao not like", value, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoIn(List<String> values) {
            addCriterion("yingdao in", values, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoNotIn(List<String> values) {
            addCriterion("yingdao not in", values, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoBetween(String value1, String value2) {
            addCriterion("yingdao between", value1, value2, "yingdao");
            return (Criteria) this;
        }

        public Criteria andYingdaoNotBetween(String value1, String value2) {
            addCriterion("yingdao not between", value1, value2, "yingdao");
            return (Criteria) this;
        }

        public Criteria andShidaoIsNull() {
            addCriterion("shidao is null");
            return (Criteria) this;
        }

        public Criteria andShidaoIsNotNull() {
            addCriterion("shidao is not null");
            return (Criteria) this;
        }

        public Criteria andShidaoEqualTo(String value) {
            addCriterion("shidao =", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoNotEqualTo(String value) {
            addCriterion("shidao <>", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoGreaterThan(String value) {
            addCriterion("shidao >", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoGreaterThanOrEqualTo(String value) {
            addCriterion("shidao >=", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoLessThan(String value) {
            addCriterion("shidao <", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoLessThanOrEqualTo(String value) {
            addCriterion("shidao <=", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoLike(String value) {
            addCriterion("shidao like", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoNotLike(String value) {
            addCriterion("shidao not like", value, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoIn(List<String> values) {
            addCriterion("shidao in", values, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoNotIn(List<String> values) {
            addCriterion("shidao not in", values, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoBetween(String value1, String value2) {
            addCriterion("shidao between", value1, value2, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaoNotBetween(String value1, String value2) {
            addCriterion("shidao not between", value1, value2, "shidao");
            return (Criteria) this;
        }

        public Criteria andShidaonameIsNull() {
            addCriterion("shidaoname is null");
            return (Criteria) this;
        }

        public Criteria andShidaonameIsNotNull() {
            addCriterion("shidaoname is not null");
            return (Criteria) this;
        }

        public Criteria andShidaonameEqualTo(String value) {
            addCriterion("shidaoname =", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameNotEqualTo(String value) {
            addCriterion("shidaoname <>", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameGreaterThan(String value) {
            addCriterion("shidaoname >", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameGreaterThanOrEqualTo(String value) {
            addCriterion("shidaoname >=", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameLessThan(String value) {
            addCriterion("shidaoname <", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameLessThanOrEqualTo(String value) {
            addCriterion("shidaoname <=", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameLike(String value) {
            addCriterion("shidaoname like", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameNotLike(String value) {
            addCriterion("shidaoname not like", value, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameIn(List<String> values) {
            addCriterion("shidaoname in", values, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameNotIn(List<String> values) {
            addCriterion("shidaoname not in", values, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameBetween(String value1, String value2) {
            addCriterion("shidaoname between", value1, value2, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andShidaonameNotBetween(String value1, String value2) {
            addCriterion("shidaoname not between", value1, value2, "shidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameIsNull() {
            addCriterion("weidaoname is null");
            return (Criteria) this;
        }

        public Criteria andWeidaonameIsNotNull() {
            addCriterion("weidaoname is not null");
            return (Criteria) this;
        }

        public Criteria andWeidaonameEqualTo(String value) {
            addCriterion("weidaoname =", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameNotEqualTo(String value) {
            addCriterion("weidaoname <>", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameGreaterThan(String value) {
            addCriterion("weidaoname >", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameGreaterThanOrEqualTo(String value) {
            addCriterion("weidaoname >=", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameLessThan(String value) {
            addCriterion("weidaoname <", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameLessThanOrEqualTo(String value) {
            addCriterion("weidaoname <=", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameLike(String value) {
            addCriterion("weidaoname like", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameNotLike(String value) {
            addCriterion("weidaoname not like", value, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameIn(List<String> values) {
            addCriterion("weidaoname in", values, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameNotIn(List<String> values) {
            addCriterion("weidaoname not in", values, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameBetween(String value1, String value2) {
            addCriterion("weidaoname between", value1, value2, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andWeidaonameNotBetween(String value1, String value2) {
            addCriterion("weidaoname not between", value1, value2, "weidaoname");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andBeiIsNull() {
            addCriterion("bei is null");
            return (Criteria) this;
        }

        public Criteria andBeiIsNotNull() {
            addCriterion("bei is not null");
            return (Criteria) this;
        }

        public Criteria andBeiEqualTo(String value) {
            addCriterion("bei =", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotEqualTo(String value) {
            addCriterion("bei <>", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiGreaterThan(String value) {
            addCriterion("bei >", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiGreaterThanOrEqualTo(String value) {
            addCriterion("bei >=", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiLessThan(String value) {
            addCriterion("bei <", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiLessThanOrEqualTo(String value) {
            addCriterion("bei <=", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiLike(String value) {
            addCriterion("bei like", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotLike(String value) {
            addCriterion("bei not like", value, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiIn(List<String> values) {
            addCriterion("bei in", values, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotIn(List<String> values) {
            addCriterion("bei not in", values, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiBetween(String value1, String value2) {
            addCriterion("bei between", value1, value2, "bei");
            return (Criteria) this;
        }

        public Criteria andBeiNotBetween(String value1, String value2) {
            addCriterion("bei not between", value1, value2, "bei");
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