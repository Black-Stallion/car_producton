package org.hqu.production_ms.domain.po;

import javax.validation.constraints.Size;

import org.hqu.production_ms.domain.Department;

public class UserPO {
	
	@Size(max=36, message="用户编号过长！")
	private String id;

	@Size(max=64, message="用户名过长！")
    private String username;

	@Size(max=32, message="密码过长！")
    private String password;
    
	@Size(max=1, message="用户状态输入非法！")
    private String locked;
    
	@Size(max=128, message="角色名过长！")
    private String roleName;
	
	private String departmentId;
	 @Size(max=40, message="E-mail长度限制在40个字符之内！")
	 private String qq;
	 @Size(min=18, max=18, message="请输入正确身份证号！")
	    private String shenfen;
	 @Size(max=18, message="电话长度限制在18个字符之内！")
	    private String phone;
	 @Size(max=20, message="文化程度限制在20个字符之内！")
	    private String culte;
	 @Size(max=100, message="籍贯限制在100个字符之内！")
	    private String jiguan;
	 @Size(max=200, message="工作单位限制在200个字符之内！")
	    private String gongzuodanwei;
	 private Integer leve;

	    private String s1;

	    private String s2;

	    private String s3;
	
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
			this.s1 = s1;
		}

		public String getS2() {
			return s2;
		}

		public void setS2(String s2) {
			this.s2 = s2;
		}

		public String getS3() {
			return s3;
		}

		public void setS3(String s3) {
			this.s3 = s3;
		}

	public String getQq() {
			return qq;
		}

		public void setQq(String qq) {
			this.qq = qq;
		}

		public String getShenfen() {
			return shenfen;
		}

		public void setShenfen(String shenfen) {
			this.shenfen = shenfen;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getCulte() {
			return culte;
		}

		public void setCulte(String culte) {
			this.culte = culte;
		}

		public String getJiguan() {
			return jiguan;
		}

		public void setJiguan(String jiguan) {
			this.jiguan = jiguan;
		}

		public String getGongzuodanwei() {
			return gongzuodanwei;
		}

		public void setGongzuodanwei(String gongzuodanwei) {
			this.gongzuodanwei = gongzuodanwei;
		}

	private Department department;
    
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Size(max=36, message="角色编号非法！")
    private String roleId;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
