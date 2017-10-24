package org.hqu.production_ms.domain.po;

import java.util.Date;

import javax.validation.constraints.Size;

public class ShiguPO {
    private Integer shiguId;
    @Size(max=100, message="事故编号长度不要超过100字符！")
    private String shigucode;

    private Date shigutime;

    private String place;

    private String shigutype;
    @Size(max=500, message="责任字数不要超过500字符！")
    private String zeren;
    @Size(max=5000, message="原因字数不要超过5000字符！")
    private String yuanyin;
    @Size(max=3000, message="损失字数不要超过3000字符！")
    private String sunshi;

    private String drivernum;

    private Integer drivername;

    private String carnumber;

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