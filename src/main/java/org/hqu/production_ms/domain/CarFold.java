package org.hqu.production_ms.domain;

import java.util.Date;

public class CarFold {
    private Integer foldId;

    private String image;

    private String fold;

    private Date datetime;

    private String user;

    private String bei;

    private String bei2;
    
    private Department department;

    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getFoldId() {
        return foldId;
    }

    public void setFoldId(Integer foldId) {
        this.foldId = foldId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFold() {
        return fold;
    }

    public void setFold(String fold) {
        this.fold = fold == null ? null : fold.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getBei() {
        return bei;
    }

    public void setBei(String bei) {
        this.bei = bei == null ? null : bei.trim();
    }

    public String getBei2() {
        return bei2;
    }

    public void setBei2(String bei2) {
        this.bei2 = bei2 == null ? null : bei2.trim();
    }
}