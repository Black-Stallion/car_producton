package org.hqu.production_ms.domain;

public class CarCheck {
    private Integer checkId;

    private Integer checkyear;

    private Integer checkmonth;

    private String carscore;

    private String carquestion;

    private String results;

    private CarRegister carRegister;
    private Department department;

    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getCheckyear() {
        return checkyear;
    }

    public void setCheckyear(Integer checkyear) {
        this.checkyear = checkyear;
    }

    public Integer getCheckmonth() {
        return checkmonth;
    }

    public void setCheckmonth(Integer checkmonth) {
        this.checkmonth = checkmonth;
    }

    public String getCarscore() {
        return carscore;
    }

    public void setCarscore(String carscore) {
        this.carscore = carscore == null ? null : carscore.trim();
    }

    public String getCarquestion() {
        return carquestion;
    }

    public void setCarquestion(String carquestion) {
        this.carquestion = carquestion == null ? null : carquestion.trim();
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results == null ? null : results.trim();
    }

	public CarRegister getRegister() {
		return carRegister;
	}

	public void setRegister(CarRegister carRegister) {
		this.carRegister = carRegister;
	}

   
}