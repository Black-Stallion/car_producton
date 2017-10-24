package org.hqu.production_ms.domain;

import java.math.BigDecimal;

public class CarMaintenance {
    private Integer maintenanceId;

    private BigDecimal kilometre;

    private String mproject;

    private CarType carType;

    public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	private String mname;

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public BigDecimal getKilometre() {
        return kilometre;
    }

    public void setKilometre(BigDecimal kilometre) {
        this.kilometre = kilometre;
    }

    public String getMproject() {
        return mproject;
    }

    public void setMproject(String mproject) {
        this.mproject = mproject == null ? null : mproject.trim();
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }
}