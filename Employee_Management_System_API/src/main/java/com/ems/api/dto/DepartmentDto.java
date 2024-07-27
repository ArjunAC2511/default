//package com.ems.api.dto;
//
//public class DepartmentDto {
//
//	private String name;
//	private int organizationId;
//	private int branchId;
//	private String createdBy;
//	private String updatedBy;
//
//	public DepartmentDto() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getOrganizationId() {
//		return organizationId;
//	}
//
//	public void setOrganizationId(int organizationId) {
//		this.organizationId = organizationId;
//	}
//
//	public int getBranchId() {
//		return branchId;
//	}
//
//	public void setBranchId(int branchId) {
//		this.branchId = branchId;
//	}
//
//
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}
//
//}


package com.ems.api.dto;

public class DepartmentDto {

    private String name;
    private int organizationId;
    private int branchId;
    private Boolean status;  // Add status field
    private String createdBy;
    private String updatedBy;

    public DepartmentDto() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
