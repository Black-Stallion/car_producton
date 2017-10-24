package org.hqu.production_ms.domain;

import java.util.Date;

public class CarSend{
	private Integer sendId;

    private String sendnums;

    private String senduser;

    private String road;

    private String usercarpeople;

    private Date senddate;

    private Date endcardate;

    private String firstduty;

    private String safe;

    private String note;

    private String firstkm;

    private String endkm;

    private String tianqi;

    private String chucheq;

    private String xingshiz;

    private String shoucheh;

    private String shigujl;

    private String notes;

    private Integer applyId;

    private Date sdate;

    private String departmentId;

    private Integer carId;

    private Integer driverId;
    
    private CarApply carApply;
    
    private CarRegister carRegister;
    
    private CarDriver carDriver;
    
    private Department department;
    
    private String kkk1;

    public String getKkk1() {
		return kkk1;
	}

	public void setKkk1(String kkk1) {
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

	public CarApply getCarApply() {
		return carApply;
	}

	public void setCarApply(CarApply carApply) {
		this.carApply = carApply;
	}

	public CarRegister getCarRegister() {
		return carRegister;
	}

	public void setCarRegister(CarRegister carRegister) {
		this.carRegister = carRegister;
	}

	public CarDriver getCarDriver() {
		return carDriver;
	}

	public void setCarDriver(CarDriver carDriver) {
		this.carDriver = carDriver;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getSendnums() {
        return sendnums;
    }

    public void setSendnums(String sendnums) {
        this.sendnums = sendnums == null ? null : sendnums.trim();
    }

    public String getSenduser() {
        return senduser;
    }

    public void setSenduser(String senduser) {
        this.senduser = senduser == null ? null : senduser.trim();
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road == null ? null : road.trim();
    }

    public String getUsercarpeople() {
        return usercarpeople;
    }

    public void setUsercarpeople(String usercarpeople) {
        this.usercarpeople = usercarpeople == null ? null : usercarpeople.trim();
    }

    public Date getEndcardate() {
        return endcardate;
    }

    public void setEndcardate(Date endcardate) {
        this.endcardate = endcardate;
    }

    public String getFirstduty() {
        return firstduty;
    }

    public void setFirstduty(String firstduty) {
        this.firstduty = firstduty == null ? null : firstduty.trim();
    }

    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe == null ? null : safe.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getFirstkm() {
        return firstkm;
    }

    public void setFirstkm(String firstkm) {
        this.firstkm = firstkm == null ? null : firstkm.trim();
    }

    public String getEndkm() {
        return endkm;
    }

    public void setEndkm(String endkm) {
        this.endkm = endkm == null ? null : endkm.trim();
    }

    public String getTianqi() {
        return tianqi;
    }

    public void setTianqi(String tianqi) {
        this.tianqi = tianqi == null ? null : tianqi.trim();
    }

    public String getChucheq() {
        return chucheq;
    }

    public void setChucheq(String chucheq) {
        this.chucheq = chucheq == null ? null : chucheq.trim();
    }

    public String getXingshiz() {
        return xingshiz;
    }

    public void setXingshiz(String xingshiz) {
        this.xingshiz = xingshiz == null ? null : xingshiz.trim();
    }

    public String getShoucheh() {
        return shoucheh;
    }

    public void setShoucheh(String shoucheh) {
        this.shoucheh = shoucheh == null ? null : shoucheh.trim();
    }

    public String getShigujl() {
        return shigujl;
    }

    public void setShigujl(String shigujl) {
        this.shigujl = shigujl == null ? null : shigujl.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}