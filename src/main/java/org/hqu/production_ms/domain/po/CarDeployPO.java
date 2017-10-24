package org.hqu.production_ms.domain.po;

import java.util.Date;

public class CarDeployPO {
    private Integer deployId;

    private Integer carId;

    private Integer driverId;

    private Date deploy;

    private String bei1;

    private String bei2;

    private Date bei3;

    public Integer getDeployId() {
        return deployId;
    }

    public void setDeployId(Integer deployId) {
        this.deployId = deployId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Date getDeploy() {
        return deploy;
    }

    public void setDeploy(Date deploy) {
        this.deploy = deploy;
    }

    public String getBei1() {
        return bei1;
    }

    public void setBei1(String bei1) {
        this.bei1 = bei1 == null ? null : bei1.trim();
    }

    public String getBei2() {
        return bei2;
    }

    public void setBei2(String bei2) {
        this.bei2 = bei2 == null ? null : bei2.trim();
    }

    public Date getBei3() {
        return bei3;
    }

    public void setBei3(Date bei3) {
        this.bei3 = bei3;
    }
}