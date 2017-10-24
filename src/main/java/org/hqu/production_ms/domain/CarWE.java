package org.hqu.production_ms.domain;

import java.util.Date;

public class CarWE {
    private Integer carId;

    private String carnumber;

    private Double kkk1;

    private Integer sendId;

    private String departmentId;

    private String departmentName;

    private String fatherdep;

    private Date senddate;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getFatherdep() {
        return fatherdep;
    }

    public void setFatherdep(String fatherdep) {
        this.fatherdep = fatherdep == null ? null : fatherdep.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }
}