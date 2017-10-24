package org.hqu.production_ms.domain;

import java.util.Date;

public class CarOut {
    private Integer outId;

    private Date removetime;

    private Date diaochutime;

    private String inorgan;


    private String departmentId;

    private String newnum;

    private Integer carId;

    private String removenum;

    private String stats;

    private String notes;

    private String rbeiyong1;

    private String rbieyong2;
    private Department department2;
    private int yidongnums;
  	public int getYidongnums() {
  		return yidongnums;
  	}
  	public void setYidongnums(int yidongnums) {
  		this.yidongnums = yidongnums;
  	}

    public Department getDepartment2() {
		return department2;
	}

	public void setDepartment2(Department department2) {
		this.department2 = department2;
	}
    private Department department3;
    private CarRegister carRegister;
    public Department getDepartment3() {
		return department3;
	}

	public void setDepartment3(Department department3) {
		this.department3 = department3;
	}

	public CarRegister getCarRegister() {
		return carRegister;
	}

	public void setCarRegister(CarRegister carRegister) {
		this.carRegister = carRegister;
	}

	public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public Date getRemovetime() {
        return removetime;
    }

    public void setRemovetime(Date removetime) {
        this.removetime = removetime;
    }

    public Date getDiaochutime() {
        return diaochutime;
    }

    public void setDiaochutime(Date diaochutime) {
        this.diaochutime = diaochutime;
    }

    public String getInorgan() {
        return inorgan;
    }

    public void setInorgan(String inorgan) {
        this.inorgan = inorgan == null ? null : inorgan.trim();
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
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