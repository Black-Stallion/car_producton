package org.hqu.production_ms.domain;


public class CarPublic {

	    private Integer carId;
	    private String departmentId;
	    private String carnumber;
	    private String usenature;
	    private CarType carType ;
	    private Department department ;
	    private String stat;
	    
	    public String getStat() {
			return stat;
		}

		public void setStat(String stat) {
			this.stat = stat;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Integer getCarId() {
			return carId;
		}

		public void setCarId(Integer carId) {
			this.carId = carId;
		}

		public String getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}

		public String getUsenature() {
			return usenature;
		}

		public void setUsenature(String usenature) {
			this.usenature = usenature;
		}

		public CarType getCarType() {
			return carType;
		}

		public void setCarType(CarType carType) {
			this.carType = carType;
		}	

	    public String getCarnumber() {
	        return carnumber;
	    }

	    public void setCarnumber(String carnumber) {
	        this.carnumber = carnumber == null ? null : carnumber.trim();
	    }
	}
