package org.hqu.production_ms.domain;

public class CarTool {
    private Integer toolId;

    private String norms;

    private String nums;

    private String notes;
    private String nums1;

    private String notes1;
    private String toolname;
    
    private String toolzj;

    
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

	private CarRegister carRegister;

    public CarRegister getCarRegister() {
		return carRegister;
	}

	public void setCarRegister(CarRegister carRegister) {
		this.carRegister = carRegister;
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

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname == null ? null : toolname.trim();
    }
}