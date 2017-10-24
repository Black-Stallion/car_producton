package org.hqu.production_ms.domain;

import java.util.Date;

public class CarYouapply {
    private Integer yapplyId;

    private String applyname;

    private String approvename;

    private Date dtime;

    private String departmentId;

    private String folds;

    private String stat;

    private String bei;
    
    private Department department;
    
    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getYapplyId() {
        return yapplyId;
    }

    public void setYapplyId(Integer yapplyId) {
        this.yapplyId = yapplyId;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname == null ? null : applyname.trim();
    }

    public String getApprovename() {
        return approvename;
    }

    public void setApprovename(String approvename) {
        this.approvename = approvename == null ? null : approvename.trim();
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getFolds() {
        return folds;
    }

    public void setFolds(String folds) {
        this.folds = folds == null ? null : folds.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getBei() {
        return bei;
    }

    public void setBei(String bei) {
        this.bei = bei == null ? null : bei.trim();
    }
}