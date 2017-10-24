package org.hqu.production_ms.domain;

import java.util.Date;

public class CarWD {
    private String drviername;

    private String departmentId;

    private Integer driverId;

    private Double kkk1;

    private Integer sendId;

    private Date senddate;

    public String getDrviername() {
        return drviername;
    }

    public void setDrviername(String drviername) {
        this.drviername = drviername == null ? null : drviername.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Double getKkk1() {
        return kkk1;
    }

    public void setKkk1(Double kkk1) {
        this.kkk1 = kkk1;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }
}