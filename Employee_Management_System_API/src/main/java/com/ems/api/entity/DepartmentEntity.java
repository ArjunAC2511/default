//package com.ems.api.entity;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//
//@Entity
//@Table(name = "department")
//public class DepartmentEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int departmentId;
//
//	@Column
//	@NotBlank(message = "Department name is mandatory")
//	@Size(max = 100, message = "Department name must be less than 100 characters")
//	private String name;
//
//	@Column
//	//@NotBlank(message = "Created by is mandatory")
//	private String createdBy;
//
//	private Boolean status;
//
//	@Column
//	//@NotNull(message = "Created at is mandatory")
//	private Date createdAt = new Date();
//
//	@Column
//	private String updatedBy;
//
//	@Column
//	private Date updatedAt;
//
////    @Column
////    @Size(max = 100, message = "Branch name must be less than 100 characters")
////    private String branchName;
////
////    @Column
////    @Size(max = 100, message = "Organization name must be less than 100 characters")
////    private String organizationName;
//
//	@ManyToOne
//	@JsonIgnore
//	@JoinColumn(name = "branchId")
//	private BranchEntity branch;
//
//	@ManyToOne
//	@JsonIgnore
//	@JoinColumn(name = "organizationId")
//	private OrganizationEntity organization;
//
//	public DepartmentEntity() {
//	    super();
//	}
//
//	public Boolean getStatus() {
//		return status;
//	}
//
//	public void setStatus(Boolean status) {
//		this.status = status;
//	}
//
//	public int getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(int departmentId) {
//		this.departmentId = departmentId;
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
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
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
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	public BranchEntity getBranch() {
//		return branch;
//	}
//
//	public void setBranch(BranchEntity branch) {
//		this.branch = branch;
//	}
//
//	public OrganizationEntity getOrganization() {
//		return organization;
//	}
//
//	public void setOrganization(OrganizationEntity organization) {
//		this.organization = organization;
//	}
//}

package com.ems.api.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column
    @NotBlank(message = "Department name is mandatory")
    private String name;

    @Column
    private String createdBy;

    private Boolean status;

    @Column
    private Date createdAt = new Date();

    @Column
    private String updatedBy;

    @Column
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "branchId")
    private BranchEntity branch;

    @ManyToOne
    @JoinColumn(name = "organizationId")
    private OrganizationEntity organization;

    public DepartmentEntity() {
        // Default constructor
    }

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public DepartmentEntity(Integer departmentId, @NotBlank(message = "Department name is mandatory") String name,
			String createdBy, Boolean status, Date createdAt, String updatedBy, Date updatedAt, BranchEntity branch,
			OrganizationEntity organization) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.createdBy = createdBy;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.branch = branch;
		this.organization = organization;
	}

}