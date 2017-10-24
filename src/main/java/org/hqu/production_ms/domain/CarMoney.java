package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CarMoney {
    private Integer moneyId;

    private String carnum;

    private Date datatime;

    private String depatmentname;

    private BigDecimal money;
    
    private BigDecimal money1;

    private String b1;

    private String b2;
    private String month1;

    public String getMonth1() {
		return month1;
	}

	public void setMonth1(String month1) {
		this.month1 = month1;
	}

	public BigDecimal getMoney1() {
		return money1;
	}

	public void setMoney1(BigDecimal money1) {
		this.money1 = money1;
	}

	public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum == null ? null : carnum.trim();
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public String getDepatmentname() {
        return depatmentname;
    }

    public void setDepatmentname(String depatmentname) {
        this.depatmentname = depatmentname == null ? null : depatmentname.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1 == null ? null : b1.trim();
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2 == null ? null : b2.trim();
    }
}