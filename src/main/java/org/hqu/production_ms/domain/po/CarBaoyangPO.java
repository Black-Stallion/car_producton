package org.hqu.production_ms.domain.po;

import java.math.BigDecimal;

public class CarBaoyangPO {
    private Integer baoyangId;

    private Integer carId;

    private String notes;

    private String beiy1;

    private String beiy2;

    private BigDecimal lm;

    public Integer getBaoyangId() {
        return baoyangId;
    }

    public void setBaoyangId(Integer baoyangId) {
        this.baoyangId = baoyangId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getBeiy1() {
        return beiy1;
    }

    public void setBeiy1(String beiy1) {
        this.beiy1 = beiy1 == null ? null : beiy1.trim();
    }

    public String getBeiy2() {
        return beiy2;
    }

    public void setBeiy2(String beiy2) {
        this.beiy2 = beiy2 == null ? null : beiy2.trim();
    }

    public BigDecimal getLm() {
        return lm;
    }

    public void setLm(BigDecimal lm) {
        this.lm = lm;
    }
}