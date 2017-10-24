package org.hqu.production_ms.domain.po;

import java.util.Date;

import javax.validation.constraints.Size;

public class CarDriverPO {
    private Integer driverId;
   
    private String drviername;

    private Integer sex;

    private Date birthday;
    @Size(max=40, message="文化限制在40个字符之内！")
    private String culture;
    private String cartype;
    @Size(max=50, message="驾驶证号限制在50个字符之内！")
    private String drivernum;

    private Date worktime;

    private String firstzheng;
    @Size(max=100, message="发证机关限制在100个字符之内！")
    private String issueorgan;

    private String departmentId;
    
    private String departmentName;
    
    private Date checktime;
    
    private int typeid;


	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }


	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
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
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getChecktime() {
		return checktime;
	}

	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}

	
}