package com.ems.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class DesignationEntity {
	@Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	private String name;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	private DepartmentEntity department;

	@ManyToOne
	@JoinColumn(name = "branchId")
	private BranchEntity branch;

	@ManyToOne
	@JoinColumn(name = "organizationId")
	private OrganizationEntity Organization;

	public DesignationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public OrganizationEntity getOrganization() {
		return Organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		Organization = organization;
	}

	public DesignationEntity(Integer roleId, String name, DepartmentEntity department, BranchEntity branch,
			OrganizationEntity organization) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.department = department;
		this.branch = branch;
		Organization = organization;
	}

}