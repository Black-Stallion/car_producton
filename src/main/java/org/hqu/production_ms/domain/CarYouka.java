package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CarYouka {
    private Integer youkaId;

    private Integer youId;

    private Integer carId;

    private BigDecimal yongyou;

    private BigDecimal totlyou;

    private Date beiyong1;

    private String beiyong2;

    private CarYou carYou;
    
    private CarRegister carRegister;
    
    private Department department;
    
    private BigDecimal allyou;
    
    private BigDecimal alltomoney;
    
    public BigDecimal getAlltomoney() {
		return alltomoney;
	}

	public void setAlltomoney(BigDecimal alltomoney) {
		this.alltomoney = alltomoney;
	}

	public BigDecimal getAllyou() {
		return allyou;
	}

	public void setAllyou(BigDecimal allyou) {
		this.allyou = allyou;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public CarYou getCarYou() {
		return carYou;
	}

	public void setCarYou(CarYou carYou) {
		this.carYou = carYou;
	}

	public CarRegister getCarRegister() {
		return carRegister;
	}

	public void setCarRegister(CarRegister carRegister) {
		this.carRegister = carRegister;
	}

	public Integer getYoukaId() {
        return youkaId;
    }

    public void setYoukaId(Integer youkaId) {
        this.youkaId = youkaId;
    }

    public Integer getYouId() {
        return youId;
    }

    public void setYouId(Integer youId) {
        this.youId = youId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public BigDecimal getYongyou() {
        return yongyou;
    }

    public void setYongyou(BigDecimal yongyou) {
        this.yongyou = yongyou;
    }

    public BigDecimal getTotlyou() {
        return totlyou;
    }

    public void setTotlyou(BigDecimal totlyou) {
        this.totlyou = totlyou;
    }

    public Date getBeiyong1() {
        return beiyong1;
    }

    public void setBeiyong1(Date beiyong1) {
        this.beiyong1 = beiyong1;
    }

    public String getBeiyong2() {
        return beiyong2;
    }

    public void setBeiyong2(String beiyong2) {
        this.beiyong2 = beiyong2 == null ? null : beiyong2.trim();
    }
}