package org.hqu.production_ms.domain;

public class Department {
    private String departmentId;

    private String departmentName;

    private String note;

    private Integer level;

    private String fatherdep;
    private String fathername;

    public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFatherdep() {
        return fatherdep;
    }

    public void setFatherdep(String fatherdep) {
        this.fatherdep = fatherdep == null ? null : fatherdep.trim();
    }
}