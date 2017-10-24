package org.hqu.production_ms.domain.po;

import java.util.Date;

public class DriverRecordPO {
    private Integer driveRecordId;

    private Date kaohetime;

    private String drivernum;

    private Integer drivername;

    private String drivestart;

    private String driveend;

    private String total;

    public Integer getDriveRecordId() {
        return driveRecordId;
    }

    public void setDriveRecordId(Integer driveRecordId) {
        this.driveRecordId = driveRecordId;
    }

    public Date getKaohetime() {
        return kaohetime;
    }

    public void setKaohetime(Date kaohetime) {
        this.kaohetime = kaohetime;
    }

    public String getDrivernum() {
        return drivernum;
    }

    public void setDrivernum(String drivernum) {
        this.drivernum = drivernum == null ? null : drivernum.trim();
    }

    public Integer getDrivername() {
        return drivername;
    }

    public void setDrivername(Integer drivername) {
        this.drivername = drivername;
    }

    public String getDrivestart() {
        return drivestart;
    }

    public void setDrivestart(String drivestart) {
        this.drivestart = drivestart == null ? null : drivestart.trim();
    }

    public String getDriveend() {
        return driveend;
    }

    public void setDriveend(String driveend) {
        this.driveend = driveend == null ? null : driveend.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }
}