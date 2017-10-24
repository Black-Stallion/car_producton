package org.hqu.production_ms.domain;

public class CarBS {
    private Integer baoyangId;

    private Integer id;

    private Double dd;

    private String notes;

    private String lm;
    
    private String carnum;

    public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public Integer getBaoyangId() {
        return baoyangId;
    }

    public void setBaoyangId(Integer baoyangId) {
        this.baoyangId = baoyangId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDd() {
        return dd;
    }

    public void setDd(Double dd) {
        this.dd = dd;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getLm() {
        return lm;
    }

    public void setLm(String lm) {
        this.lm = lm == null ? null : lm.trim();
    }
}