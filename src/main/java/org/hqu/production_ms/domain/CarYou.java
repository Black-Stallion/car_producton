package org.hqu.production_ms.domain;

import java.math.BigDecimal;

public class CarYou {
    private Integer youId;

    private String younumber;

    private String departmentId;

    private String beiyong1;

    private BigDecimal beiyong2;

    private BigDecimal bei1;
    
    private Department department;

    private BigDecimal you;
    
    private BigDecimal money;
    
    private String departmentName;
    
    public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public BigDecimal getYou() {
		return you;
	}

	public void setYou(BigDecimal you) {
		this.you = you;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getYouId() {
        return youId;
    }

    public void setYouId(Integer youId) {
        this.youId = youId;
    }

    public String getYounumber() {
        return younumber;
    }

    public void setYounumber(String younumber) {
        this.younumber = younumber == null ? null : younumber.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getBeiyong1() {
        return beiyong1;
    }

    public void setBeiyong1(String beiyong1) {
        this.beiyong1 = beiyong1 == null ? null : beiyong1.trim();
    }

    public BigDecimal getBeiyong2() {
        return beiyong2;
    }

    public void setBeiyong2(BigDecimal beiyong2) {
        this.beiyong2 = beiyong2;
    }

    public BigDecimal getBei1() {
        return bei1;
    }

    public void setBei1(BigDecimal bei1) {
        this.bei1 = bei1;
    }
}