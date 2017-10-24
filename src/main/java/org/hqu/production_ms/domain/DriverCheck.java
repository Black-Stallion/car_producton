package org.hqu.production_ms.domain;

import java.util.Date;

public class DriverCheck {
    private Integer driveCheckId;

    private String drivernum;

    private Integer drivername;

    private String carnumber;

    private Date kaohetime;

    private String kaohescore;

    private String koufenyinsu;

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

	public Integer getDriveCheckId() {
        return driveCheckId;
    }

    public void setDriveCheckId(Integer driveCheckId) {
        this.driveCheckId = driveCheckId;
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

    public Date getKaohetime() {
        return kaohetime;
    }

    public void setKaohetime(Date kaohetime) {
        this.kaohetime = kaohetime;
    }

    public String getKaohescore() {
        return kaohescore;
    }

    public void setKaohescore(String kaohescore) {
        this.kaohescore = kaohescore == null ? null : kaohescore.trim();
    }

    public String getKoufenyinsu() {
        return koufenyinsu;
    }

    public void setKoufenyinsu(String koufenyinsu) {
        this.koufenyinsu = koufenyinsu == null ? null : koufenyinsu.trim();
    }
}