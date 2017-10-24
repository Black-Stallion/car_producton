package org.hqu.production_ms.domain.po;

import java.util.Date;

public class CarInPO {
    private Integer inId;

    private Date removetime;

    private Date diaorutime;

    private String inorgan;

    private String outorgan;

    private String departmentId;
    public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}


    private String newnum;

    private Integer carId;

    private String removenum;

    private String stats;

    private String notes;

    private String rbeiyong1;

    private String rbieyong2;

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public Date getRemovetime() {
        return removetime;
    }

    public void setRemovetime(Date removetime) {
        this.removetime = removetime;
    }

    public Date getDiaorutime() {
        return diaorutime;
    }

    public void setDiaorutime(Date diaorutime) {
        this.diaorutime = diaorutime;
    }

    public String getInorgan() {
        return inorgan;
    }

    public void setInorgan(String inorgan) {
        this.inorgan = inorgan == null ? null : inorgan.trim();
    }

    public String getOutorgan() {
        return outorgan;
    }

    public void setOutorgan(String outorgan) {
        this.outorgan = outorgan == null ? null : outorgan.trim();
    }


    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum == null ? null : newnum.trim();
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getRemovenum() {
        return removenum;
    }

    public void setRemovenum(String removenum) {
        this.removenum = removenum == null ? null : removenum.trim();
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats == null ? null : stats.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getRbeiyong1() {
        return rbeiyong1;
    }

    public void setRbeiyong1(String rbeiyong1) {
        this.rbeiyong1 = rbeiyong1 == null ? null : rbeiyong1.trim();
    }

    public String getRbieyong2() {
        return rbieyong2;
    }

    public void setRbieyong2(String rbieyong2) {
        this.rbieyong2 = rbieyong2 == null ? null : rbieyong2.trim();
    }
}