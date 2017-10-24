package org.hqu.production_ms.domain.po;

import javax.validation.constraints.Size;

public class CarCheckPO {
	
	  private Integer checkId;

	    private Integer checkyear;

	    private Integer checkmonth;

	    private String carscore;
	    @Size(max=600, message="存在问题限制在600个字符之内！")
	    private String carquestion;
	    @Size(max=200, message="处理结果限制在200个字符之内！")
	    private String results;

	    private Integer carId;

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

	    public Integer getCarId() {
	        return carId;
	    }

	    public void setCarId(Integer carId) {
	        this.carId = carId;
	    }
}
