package org.hqu.production_ms.domain.po;

import java.util.Date;

public class WeiguiPO {
    private Integer weiguiId;

    private Integer carnumb;

    private Date weiguitime;

    private String place;

    private String xingwei;

    private String score;

    private String money;

    private String issend;

    private String drivernum;

    private Integer drivername;

    private Date chulitime;

    private String chuliname;

    public Integer getWeiguiId() {
        return weiguiId;
    }

    public void setWeiguiId(Integer weiguiId) {
        this.weiguiId = weiguiId;
    }

    public Integer getCarnumb() {
        return carnumb;
    }

    public void setCarnumb(Integer carnumb) {
        this.carnumb = carnumb;
    }

    public Date getWeiguitime() {
        return weiguitime;
    }

    public void setWeiguitime(Date weiguitime) {
        this.weiguitime = weiguitime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getXingwei() {
        return xingwei;
    }

    public void setXingwei(String xingwei) {
        this.xingwei = xingwei == null ? null : xingwei.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getIssend() {
        return issend;
    }

    public void setIssend(String issend) {
        this.issend = issend == null ? null : issend.trim();
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

    public Date getChulitime() {
        return chulitime;
    }

    public void setChulitime(Date chulitime) {
        this.chulitime = chulitime;
    }

    public String getChuliname() {
        return chuliname;
    }

    public void setChuliname(String chuliname) {
        this.chuliname = chuliname == null ? null : chuliname.trim();
    }
}