package org.hqu.production_ms.domain;

import java.util.Date;

public class Shigu {
    private Integer shiguId;

    private String shigucode;

    private Date shigutime;

    private String place;

    private String shigutype;

    private String zeren;

    private String yuanyin;

    private String sunshi;

    private String drivernum;

    private Integer drivername;

    private String carnumber;

    private CarDriver carDriver;
    private Department department;
    
    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public CarDriver getCarDriver() {
		return carDriver;
	}

	public void setCarDriver(CarDriver carDriver) {
		this.carDriver = carDriver;
	}

	public Integer getShiguId() {
        return shiguId;
    }

    public void setShiguId(Integer shiguId) {
        this.shiguId = shiguId;
    }

    public String getShigucode() {
        return shigucode;
    }

    public void setShigucode(String shigucode) {
        this.shigucode = shigucode;
    }

    public Date getShigutime() {
        return shigutime;
    }

    public void setShigutime(Date shigutime) {
        this.shigutime = shigutime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getShigutype() {
        return shigutype;
    }

    public void setShigutype(String shigutype) {
        this.shigutype = shigutype == null ? null : shigutype.trim();
    }

    public String getZeren() {
        return zeren;
    }

    public void setZeren(String zeren) {
        this.zeren = zeren == null ? null : zeren.trim();
    }

    public String getYuanyin() {
        return yuanyin;
    }

    public void setYuanyin(String yuanyin) {
        this.yuanyin = yuanyin == null ? null : yuanyin.trim();
    }

    public String getSunshi() {
        return sunshi;
    }

    public void setSunshi(String sunshi) {
        this.sunshi = sunshi == null ? null : sunshi.trim();
    }

    public String getDrivernum() {
        return drivernum;
    }

    public void setDrivernum(String drivernum) {
        this.drivernum = drivernum == null ? null : drivernum.trim();
    }

    public Integer getDrivername() {
        return drivername;
    }

    public void setDrivername(Integer drivername) {
        this.drivername = drivername;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }
}