package org.hqu.production_ms.domain.po;

import java.util.Date;

public class CarTirePO {
    private Integer tireId;

    private String changpai;

    private String guige;

    private String taihao;

    private Date startdate;

    private Date enddate;

    private String addkm;

    private String why;

    private String checkrecord;

    private String checkrecord1;

    private String checkrecord2;

    public Integer getTireId() {
        return tireId;
    }

    public void setTireId(Integer tireId) {
        this.tireId = tireId;
    }

    public String getChangpai() {
        return changpai;
    }

    public void setChangpai(String changpai) {
        this.changpai = changpai == null ? null : changpai.trim();
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige == null ? null : guige.trim();
    }

    public String getTaihao() {
        return taihao;
    }

    public void setTaihao(String taihao) {
        this.taihao = taihao == null ? null : taihao.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getAddkm() {
        return addkm;
    }

    public void setAddkm(String addkm) {
        this.addkm = addkm == null ? null : addkm.trim();
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why == null ? null : why.trim();
    }

    public String getCheckrecord() {
        return checkrecord;
    }

    public void setCheckrecord(String checkrecord) {
        this.checkrecord = checkrecord == null ? null : checkrecord.trim();
    }

    public String getCheckrecord1() {
        return checkrecord1;
    }

    public void setCheckrecord1(String checkrecord1) {
        this.checkrecord1 = checkrecord1 == null ? null : checkrecord1.trim();
    }

    public String getCheckrecord2() {
        return checkrecord2;
    }

    public void setCheckrecord2(String checkrecord2) {
        this.checkrecord2 = checkrecord2 == null ? null : checkrecord2.trim();
    }
}