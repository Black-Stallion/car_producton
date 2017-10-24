package org.hqu.production_ms.domain.po;

import java.util.Date;

public class CarHandoverPO {
    private Integer handoverId;

    private Date handovertime;

    private String handovernote;

    private String oldcaruser;

    private String newcaruser;

    private Integer carId;

    private Date querendate;

    private String state;

    private String carnumber;

    private String hbeiyong1;

    private String hbieyong2;

    public Integer getHandoverId() {
        return handoverId;
    }

    public void setHandoverId(Integer handoverId) {
        this.handoverId = handoverId;
    }

    public Date getHandovertime() {
        return handovertime;
    }

    public void setHandovertime(Date handovertime) {
        this.handovertime = handovertime;
    }

    public String getHandovernote() {
        return handovernote;
    }

    public void setHandovernote(String handovernote) {
        this.handovernote = handovernote == null ? null : handovernote.trim();
    }

    public String getOldcaruser() {
        return oldcaruser;
    }

    public void setOldcaruser(String oldcaruser) {
        this.oldcaruser = oldcaruser == null ? null : oldcaruser.trim();
    }

    public String getNewcaruser() {
        return newcaruser;
    }

    public void setNewcaruser(String newcaruser) {
        this.newcaruser = newcaruser == null ? null : newcaruser.trim();
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getQuerendate() {
        return querendate;
    }

    public void setQuerendate(Date querendate) {
        this.querendate = querendate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public String getHbeiyong1() {
        return hbeiyong1;
    }

    public void setHbeiyong1(String hbeiyong1) {
        this.hbeiyong1 = hbeiyong1 == null ? null : hbeiyong1.trim();
    }

    public String getHbieyong2() {
        return hbieyong2;
    }

    public void setHbieyong2(String hbieyong2) {
        this.hbieyong2 = hbieyong2 == null ? null : hbieyong2.trim();
    }
}