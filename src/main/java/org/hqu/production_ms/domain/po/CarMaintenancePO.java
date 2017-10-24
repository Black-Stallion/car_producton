package org.hqu.production_ms.domain.po;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

public class CarMaintenancePO {
    private Integer maintenanceId;

    private BigDecimal kilometre;
    @Size(max=3000, message="维护项目限制在3000个字符之内！")
    private String mproject;

    private Integer typeid;
    @Size(max=200, message="名称限制在200个字符之内！")
    private String mname;

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public BigDecimal getKilometre() {
        return kilometre;
    }

    public void setKilometre(BigDecimal kilometre) {
        this.kilometre = kilometre;
    }

    public String getMproject() {
        return mproject;
    }

    public void setMproject(String mproject) {
        this.mproject = mproject == null ? null : mproject.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }
}