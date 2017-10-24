package org.hqu.production_ms.domain;

import java.util.Date;

public class CarDriver {
    private Integer driverId;

    private String drviername;

    private Integer sex;

    private Date birthday;

    private String culture;

    private String drivernum;

    private Date worktime;

    private String firstzheng;

    private String issueorgan;

    private String departmentId;

    private Integer typeid;

    private String cartype;

    private String departmentName;

    private Date checktime;
    
    private Department department;
    
    private String ye;
    
    public String getYe() {
		return ye;
	}

	public void setYe(String ye) {
		this.ye = ye;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDrviername() {
        return drviername;
    }

    public void setDrviername(String drviername) {
        this.drviername = drviername == null ? null : drviername.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture == null ? null : culture.trim();
    }

    public String getDrivernum() {
        return drivernum;
    }

    public void setDrivernum(String drivernum) {
        this.drivernum = drivernum == null ? null : drivernum.trim();
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public String getFirstzheng() {
        return firstzheng;
    }

    public void setFirstzheng(String firstzheng) {
        this.firstzheng = firstzheng == null ? null : firstzheng.trim();
    }

    public String getIssueorgan() {
        return issueorgan;
    }

    public void setIssueorgan(String issueorgan) {
        this.issueorgan = issueorgan == null ? null : issueorgan.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }
}