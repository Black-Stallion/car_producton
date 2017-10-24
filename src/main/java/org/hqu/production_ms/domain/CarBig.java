package org.hqu.production_ms.domain;

import java.util.Date;

public class CarBig {
    private Integer bigId;

    private Integer carId;

    private String bigcarnum;

    private String drivername;

    private Date changedate;

    private String changbig;

    private String why;

    private CarRegister carRegister;
    private Department department;
    
    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public CarRegister getCarRegister() {
		return carRegister;
	}

	public void setCarRegister(CarRegister carRegister) {
		this.carRegister = carRegister;
	}

	private CarDriver carDriver;
    
    public CarDriver getCarDriver() {
		return carDriver;
	}

	public void setCarDriver(CarDriver carDriver) {
		this.carDriver = carDriver;
	}

	public Integer getBigId() {
        return bigId;
    }

    public void setBigId(Integer bigId) {
        this.bigId = bigId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBigcarnum() {
        return bigcarnum;
    }

    public void setBigcarnum(String bigcarnum) {
        this.bigcarnum = bigcarnum == null ? null : bigcarnum.trim();
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername == null ? null : drivername.trim();
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public String getChangbig() {
        return changbig;
    }

    public void setChangbig(String changbig) {
        this.changbig = changbig == null ? null : changbig.trim();
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why == null ? null : why.trim();
    }

}