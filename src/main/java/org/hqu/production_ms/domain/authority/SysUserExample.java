package org.hqu.production_ms.domain.authority;

import java.util.ArrayList;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andLockedIsNull() {
            addCriterion("locked is null");
            return (Criteria) this;
        }

        public Criteria andLockedIsNotNull() {
            addCriterion("locked is not null");
            return (Criteria) this;
        }

        public Criteria andLockedEqualTo(String value) {
            addCriterion("locked =", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotEqualTo(String value) {
            addCriterion("locked <>", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThan(String value) {
            addCriterion("locked >", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThanOrEqualTo(String value) {
            addCriterion("locked >=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThan(String value) {
            addCriterion("locked <", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThanOrEqualTo(String value) {
            addCriterion("locked <=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLike(String value) {
            addCriterion("locked like", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotLike(String value) {
            addCriterion("locked not like", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedIn(List<String> values) {
            addCriterion("locked in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotIn(List<String> values) {
            addCriterion("locked not in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedBetween(String value1, String value2) {
            addCriterion("locked between", value1, value2, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotBetween(String value1, String value2) {
            addCriterion("locked not between", value1, value2, "locked");
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

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andShenfenIsNull() {
            addCriterion("shenfen is null");
            return (Criteria) this;
        }

        public Criteria andShenfenIsNotNull() {
            addCriterion("shenfen is not null");
            return (Criteria) this;
        }

        public Criteria andShenfenEqualTo(String value) {
            addCriterion("shenfen =", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenNotEqualTo(String value) {
            addCriterion("shenfen <>", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenGreaterThan(String value) {
            addCriterion("shenfen >", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenGreaterThanOrEqualTo(String value) {
            addCriterion("shenfen >=", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenLessThan(String value) {
            addCriterion("shenfen <", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenLessThanOrEqualTo(String value) {
            addCriterion("shenfen <=", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenLike(String value) {
            addCriterion("shenfen like", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenNotLike(String value) {
            addCriterion("shenfen not like", value, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenIn(List<String> values) {
            addCriterion("shenfen in", values, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenNotIn(List<String> values) {
            addCriterion("shenfen not in", values, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenBetween(String value1, String value2) {
            addCriterion("shenfen between", value1, value2, "shenfen");
            return (Criteria) this;
        }

        public Criteria andShenfenNotBetween(String value1, String value2) {
            addCriterion("shenfen not between", value1, value2, "shenfen");
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

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
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

        public Criteria andCulteIsNull() {
            addCriterion("culte is null");
            return (Criteria) this;
        }

        public Criteria andCulteIsNotNull() {
            addCriterion("culte is not null");
            return (Criteria) this;
        }

        public Criteria andCulteEqualTo(String value) {
            addCriterion("culte =", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteNotEqualTo(String value) {
            addCriterion("culte <>", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteGreaterThan(String value) {
            addCriterion("culte >", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteGreaterThanOrEqualTo(String value) {
            addCriterion("culte >=", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteLessThan(String value) {
            addCriterion("culte <", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteLessThanOrEqualTo(String value) {
            addCriterion("culte <=", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteLike(String value) {
            addCriterion("culte like", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteNotLike(String value) {
            addCriterion("culte not like", value, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteIn(List<String> values) {
            addCriterion("culte in", values, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteNotIn(List<String> values) {
            addCriterion("culte not in", values, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteBetween(String value1, String value2) {
            addCriterion("culte between", value1, value2, "culte");
            return (Criteria) this;
        }

        public Criteria andCulteNotBetween(String value1, String value2) {
            addCriterion("culte not between", value1, value2, "culte");
            return (Criteria) this;
        }

        public Criteria andJiguanIsNull() {
            addCriterion("jiguan is null");
            return (Criteria) this;
        }

        public Criteria andJiguanIsNotNull() {
            addCriterion("jiguan is not null");
            return (Criteria) this;
        }

        public Criteria andJiguanEqualTo(String value) {
            addCriterion("jiguan =", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotEqualTo(String value) {
            addCriterion("jiguan <>", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThan(String value) {
            addCriterion("jiguan >", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThanOrEqualTo(String value) {
            addCriterion("jiguan >=", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThan(String value) {
            addCriterion("jiguan <", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThanOrEqualTo(String value) {
            addCriterion("jiguan <=", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLike(String value) {
            addCriterion("jiguan like", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotLike(String value) {
            addCriterion("jiguan not like", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanIn(List<String> values) {
            addCriterion("jiguan in", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotIn(List<String> values) {
            addCriterion("jiguan not in", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanBetween(String value1, String value2) {
            addCriterion("jiguan between", value1, value2, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotBetween(String value1, String value2) {
            addCriterion("jiguan not between", value1, value2, "jiguan");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiIsNull() {
            addCriterion("gongzuodanwei is null");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiIsNotNull() {
            addCriterion("gongzuodanwei is not null");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiEqualTo(String value) {
            addCriterion("gongzuodanwei =", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiNotEqualTo(String value) {
            addCriterion("gongzuodanwei <>", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiGreaterThan(String value) {
            addCriterion("gongzuodanwei >", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiGreaterThanOrEqualTo(String value) {
            addCriterion("gongzuodanwei >=", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiLessThan(String value) {
            addCriterion("gongzuodanwei <", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiLessThanOrEqualTo(String value) {
            addCriterion("gongzuodanwei <=", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiLike(String value) {
            addCriterion("gongzuodanwei like", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiNotLike(String value) {
            addCriterion("gongzuodanwei not like", value, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiIn(List<String> values) {
            addCriterion("gongzuodanwei in", values, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiNotIn(List<String> values) {
            addCriterion("gongzuodanwei not in", values, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiBetween(String value1, String value2) {
            addCriterion("gongzuodanwei between", value1, value2, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andGongzuodanweiNotBetween(String value1, String value2) {
            addCriterion("gongzuodanwei not between", value1, value2, "gongzuodanwei");
            return (Criteria) this;
        }

        public Criteria andLeveIsNull() {
            addCriterion("leve is null");
            return (Criteria) this;
        }

        public Criteria andLeveIsNotNull() {
            addCriterion("leve is not null");
            return (Criteria) this;
        }

        public Criteria andLeveEqualTo(Integer value) {
            addCriterion("leve =", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveNotEqualTo(Integer value) {
            addCriterion("leve <>", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveGreaterThan(Integer value) {
            addCriterion("leve >", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveGreaterThanOrEqualTo(Integer value) {
            addCriterion("leve >=", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveLessThan(Integer value) {
            addCriterion("leve <", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveLessThanOrEqualTo(Integer value) {
            addCriterion("leve <=", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveIn(List<Integer> values) {
            addCriterion("leve in", values, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveNotIn(List<Integer> values) {
            addCriterion("leve not in", values, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveBetween(Integer value1, Integer value2) {
            addCriterion("leve between", value1, value2, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveNotBetween(Integer value1, Integer value2) {
            addCriterion("leve not between", value1, value2, "leve");
            return (Criteria) this;
        }

        public Criteria andS1IsNull() {
            addCriterion("s1 is null");
            return (Criteria) this;
        }

        public Criteria andS1IsNotNull() {
            addCriterion("s1 is not null");
            return (Criteria) this;
        }

        public Criteria andS1EqualTo(String value) {
            addCriterion("s1 =", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotEqualTo(String value) {
            addCriterion("s1 <>", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1GreaterThan(String value) {
            addCriterion("s1 >", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1GreaterThanOrEqualTo(String value) {
            addCriterion("s1 >=", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1LessThan(String value) {
            addCriterion("s1 <", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1LessThanOrEqualTo(String value) {
            addCriterion("s1 <=", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1Like(String value) {
            addCriterion("s1 like", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotLike(String value) {
            addCriterion("s1 not like", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1In(List<String> values) {
            addCriterion("s1 in", values, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotIn(List<String> values) {
            addCriterion("s1 not in", values, "s1");
            return (Criteria) this;
        }

        public Criteria andS1Between(String value1, String value2) {
            addCriterion("s1 between", value1, value2, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotBetween(String value1, String value2) {
            addCriterion("s1 not between", value1, value2, "s1");
            return (Criteria) this;
        }

        public Criteria andS2IsNull() {
            addCriterion("s2 is null");
            return (Criteria) this;
        }

        public Criteria andS2IsNotNull() {
            addCriterion("s2 is not null");
            return (Criteria) this;
        }

        public Criteria andS2EqualTo(String value) {
            addCriterion("s2 =", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotEqualTo(String value) {
            addCriterion("s2 <>", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2GreaterThan(String value) {
            addCriterion("s2 >", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2GreaterThanOrEqualTo(String value) {
            addCriterion("s2 >=", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2LessThan(String value) {
            addCriterion("s2 <", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2LessThanOrEqualTo(String value) {
            addCriterion("s2 <=", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2Like(String value) {
            addCriterion("s2 like", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotLike(String value) {
            addCriterion("s2 not like", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2In(List<String> values) {
            addCriterion("s2 in", values, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotIn(List<String> values) {
            addCriterion("s2 not in", values, "s2");
            return (Criteria) this;
        }

        public Criteria andS2Between(String value1, String value2) {
            addCriterion("s2 between", value1, value2, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotBetween(String value1, String value2) {
            addCriterion("s2 not between", value1, value2, "s2");
            return (Criteria) this;
        }

        public Criteria andS3IsNull() {
            addCriterion("s3 is null");
            return (Criteria) this;
        }

        public Criteria andS3IsNotNull() {
            addCriterion("s3 is not null");
            return (Criteria) this;
        }

        public Criteria andS3EqualTo(String value) {
            addCriterion("s3 =", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotEqualTo(String value) {
            addCriterion("s3 <>", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3GreaterThan(String value) {
            addCriterion("s3 >", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3GreaterThanOrEqualTo(String value) {
            addCriterion("s3 >=", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3LessThan(String value) {
            addCriterion("s3 <", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3LessThanOrEqualTo(String value) {
            addCriterion("s3 <=", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3Like(String value) {
            addCriterion("s3 like", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotLike(String value) {
            addCriterion("s3 not like", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3In(List<String> values) {
            addCriterion("s3 in", values, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotIn(List<String> values) {
            addCriterion("s3 not in", values, "s3");
            return (Criteria) this;
        }

        public Criteria andS3Between(String value1, String value2) {
            addCriterion("s3 between", value1, value2, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotBetween(String value1, String value2) {
            addCriterion("s3 not between", value1, value2, "s3");
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