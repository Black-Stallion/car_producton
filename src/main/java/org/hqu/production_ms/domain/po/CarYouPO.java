package org.hqu.production_ms.domain.po;

import java.math.BigDecimal;

public class CarYouPO {
    private Integer youId;

    private String younumber;

    private String departmentId;

    private String beiyong1;

    private BigDecimal beiyong2;

    private BigDecimal bei1;

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