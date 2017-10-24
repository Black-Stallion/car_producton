package org.hqu.production_ms.domain.po;

import javax.validation.constraints.Size;

public class CarToolPO {
    private Integer toolId;

    private String norms;
    @Size(max=40, message="长度限制在1000个字符之内！")
    private String nums;

    private String notes;

    private Integer carId;
    
    private String toolname;
    private String toolzj;
    private String nums1;

    private String notes1;

    public String getNums1() {
		return nums1;
	}

	public void setNums1(String nums1) {
		this.nums1 = nums1;
	}

	public String getNotes1() {
		return notes1;
	}

	public void setNotes1(String notes1) {
		this.notes1 = notes1;
	}

	public String getToolzj() {
		return toolzj;
	}

	public void setToolzj(String toolzj) {
		this.toolzj = toolzj;
	}

	public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname == null ? null : toolname.trim();
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public String getNorms() {
        return norms;
    }

    public void setNorms(String norms) {
        this.norms = norms == null ? null : norms.trim();
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums == null ? null : nums.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}