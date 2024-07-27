package com.ems.api.dto;

public class DesignationDto {
	private int roleId;
	private String name;

//	private DepartmentEntity department;
	// private BranchEntity branch;
//	private OrganizationEntity organization;

	private int departmentId;
	private int branchId;
	private int organizationId;

	public DesignationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DesignationDto(int roleId, String name, int departmentId, int branchId, int organizationId) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.departmentId = departmentId;
		this.branchId = branchId;
		this.organizationId = organizationId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

}
