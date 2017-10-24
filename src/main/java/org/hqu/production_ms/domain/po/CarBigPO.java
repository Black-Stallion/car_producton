package org.hqu.production_ms.domain.po;

import java.util.Date;

import javax.validation.constraints.Size;

public class CarBigPO {
    private Integer bigId;

    private Integer carId;

    private String bigcarnum;

    private String drivername;

    private Date changedate;
    @Size(max=500, message="所换大件限制在500个字符之内！")
    private String changbig;
    @Size(max=2000, message="更换原因限制在2000个字符之内！")
    private String why;

    private Integer driverId;

    public Integer getBigId() {
        return bigId;
    }

    public void setBigId(Integer bigId) {
        this.bigId = bigId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBigcarnum() {
        return bigcarnum;
    }

    public void setBigcarnum(String bigcarnum) {
        this.bigcarnum = bigcarnum == null ? null : bigcarnum.trim();
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername == null ? null : drivername.trim();
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public String getChangbig() {
        return changbig;
    }

    public void setChangbig(String changbig) {
        this.changbig = changbig == null ? null : changbig.trim();
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why == null ? null : why.trim();
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}