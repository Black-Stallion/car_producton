package org.hqu.production_ms.domain;

public class CarTechnical {
    private Integer technicalId;

    private String driverfrom;

    private String lidijianxi;

    private String jiejinjiao;

    private String liqujiao;

    private Integer highspeed;

    private String highpapo;

    private String turnbody;

    private String turntire;

    private String dianhuocx;

    private String yasuobi;

    private String tireqy;

    private String ranyoucl;

    private String dianchixh;

    private String ranyoubh;

    private String hundredsfuel;

    private CarType carType;

    public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Integer getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(Integer technicalId) {
        this.technicalId = technicalId;
    }

    public String getDriverfrom() {
        return driverfrom;
    }

    public void setDriverfrom(String driverfrom) {
        this.driverfrom = driverfrom == null ? null : driverfrom.trim();
    }

    public String getLidijianxi() {
        return lidijianxi;
    }

    public void setLidijianxi(String lidijianxi) {
        this.lidijianxi = lidijianxi == null ? null : lidijianxi.trim();
    }

    public String getJiejinjiao() {
        return jiejinjiao;
    }

    public void setJiejinjiao(String jiejinjiao) {
        this.jiejinjiao = jiejinjiao == null ? null : jiejinjiao.trim();
    }

    public String getLiqujiao() {
        return liqujiao;
    }

    public void setLiqujiao(String liqujiao) {
        this.liqujiao = liqujiao == null ? null : liqujiao.trim();
    }

    public Integer getHighspeed() {
        return highspeed;
    }

    public void setHighspeed(Integer highspeed) {
        this.highspeed = highspeed;
    }

    public String getHighpapo() {
        return highpapo;
    }

    public void setHighpapo(String highpapo) {
        this.highpapo = highpapo == null ? null : highpapo.trim();
    }

    public String getTurnbody() {
        return turnbody;
    }

    public void setTurnbody(String turnbody) {
        this.turnbody = turnbody;
    }

    public String getTurntire() {
        return turntire;
    }

    public void setTurntire(String turntire) {
        this.turntire = turntire;
    }

    public String getDianhuocx() {
        return dianhuocx;
    }

    public void setDianhuocx(String dianhuocx) {
        this.dianhuocx = dianhuocx == null ? null : dianhuocx.trim();
    }

    public String getYasuobi() {
        return yasuobi;
    }

    public void setYasuobi(String yasuobi) {
        this.yasuobi = yasuobi == null ? null : yasuobi.trim();
    }

    public String getTireqy() {
        return tireqy;
    }

    public void setTireqy(String tireqy) {
        this.tireqy = tireqy == null ? null : tireqy.trim();
    }

    public String getRanyoucl() {
        return ranyoucl;
    }

    public void setRanyoucl(String ranyoucl) {
        this.ranyoucl = ranyoucl == null ? null : ranyoucl.trim();
    }

    public String getDianchixh() {
        return dianchixh;
    }

    public void setDianchixh(String dianchixh) {
        this.dianchixh = dianchixh == null ? null : dianchixh.trim();
    }

    public String getRanyoubh() {
        return ranyoubh;
    }

    public void setRanyoubh(String ranyoubh) {
        this.ranyoubh = ranyoubh == null ? null : ranyoubh.trim();
    }

    public String getHundredsfuel() {
        return hundredsfuel;
    }

    public void setHundredsfuel(String hundredsfuel) {
        this.hundredsfuel = hundredsfuel == null ? null : hundredsfuel.trim();
    }
}