package org.hqu.production_ms.domain;

import java.util.Date;

public class DriverStudey {
    private Integer studyId;

    private Date stutime;

    private String zhuchiren;

    private String yingdao;

    private String shidao;

    private String shidaoname;

    private String weidaoname;

    private String content;

    private String departmentId;

    private String bei;
    
    private Department department;

    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getStudyId() {
        return studyId;
    }

    public void setStudyId(Integer studyId) {
        this.studyId = studyId;
    }

    public Date getStutime() {
        return stutime;
    }

    public void setStutime(Date stutime) {
        this.stutime = stutime;
    }

    public String getZhuchiren() {
        return zhuchiren;
    }

    public void setZhuchiren(String zhuchiren) {
        this.zhuchiren = zhuchiren == null ? null : zhuchiren.trim();
    }

    public String getYingdao() {
        return yingdao;
    }

    public void setYingdao(String yingdao) {
        this.yingdao = yingdao == null ? null : yingdao.trim();
    }

    public String getShidao() {
        return shidao;
    }

    public void setShidao(String shidao) {
        this.shidao = shidao == null ? null : shidao.trim();
    }

    public String getShidaoname() {
        return shidaoname;
    }

    public void setShidaoname(String shidaoname) {
        this.shidaoname = shidaoname == null ? null : shidaoname.trim();
    }

    public String getWeidaoname() {
        return weidaoname;
    }

    public void setWeidaoname(String weidaoname) {
        this.weidaoname = weidaoname == null ? null : weidaoname.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getBei() {
        return bei;
    }

    public void setBei(String bei) {
        this.bei = bei == null ? null : bei.trim();
    }
}