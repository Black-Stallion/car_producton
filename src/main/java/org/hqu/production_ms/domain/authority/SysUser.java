package org.hqu.production_ms.domain.authority;

import org.hqu.production_ms.domain.Department;

public class SysUser {
    private String id;

    private String username;

    private String password;

    private String locked;

    private String departmentId;

    private String qq;

    private String shenfen;

    private String phone;

    private String culte;

    private String jiguan;

    private String gongzuodanwei;

    private Integer leve;

    private String s1;

    private String s2;

    private String s3;

    private Department department;
    
    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getShenfen() {
        return shenfen;
    }

    public void setShenfen(String shenfen) {
        this.shenfen = shenfen == null ? null : shenfen.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCulte() {
        return culte;
    }

    public void setCulte(String culte) {
        this.culte = culte == null ? null : culte.trim();
    }

    public String getJiguan() {
        return jiguan;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan == null ? null : jiguan.trim();
    }

    public String getGongzuodanwei() {
        return gongzuodanwei;
    }

    public void setGongzuodanwei(String gongzuodanwei) {
        this.gongzuodanwei = gongzuodanwei == null ? null : gongzuodanwei.trim();
    }

    public Integer getLeve() {
        return leve;
    }

    public void setLeve(Integer leve) {
        this.leve = leve;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1 == null ? null : s1.trim();
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2 == null ? null : s2.trim();
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3 == null ? null : s3.trim();
    }
}