package org.hqu.production_ms.domain;

public class CarCareful {
    private Integer carefulId;

    private String name;

    private String yong;

    public Integer getCarefulId() {
        return carefulId;
    }

    public void setCarefulId(Integer carefulId) {
        this.carefulId = carefulId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getYong() {
        return yong;
    }

    public void setYong(String yong) {
        this.yong = yong == null ? null : yong.trim();
    }
}