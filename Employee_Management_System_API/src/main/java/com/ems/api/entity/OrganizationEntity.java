package com.ems.api.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

@Table(name = "organization")
public class OrganizationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer organizationId;

	@NotBlank(message = "Name is mandatory")
	@Size(max = 100, min = 3, message = "Name can have a maximum of 255 characters")
	private String name;

	private Boolean status;

	private String createdBy;

	private LocalDateTime createdAt;

	private String updatedBy;

	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<BranchEntity> branches;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isStatus() {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<BranchEntity> getBranches() {
		return branches;
	}

	public void setBranches(Set<BranchEntity> branches) {
		this.branches = branches;
	}

	public OrganizationEntity(Integer organizationId,
			@NotBlank(message = "Name is mandatory") @Size(max = 100, min = 3, message = "Name can have a maximum of 255 characters") String name,
			Boolean status, String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt,
			Set<BranchEntity> branches) {
		super();
		this.organizationId = organizationId;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.branches = branches;
	}

	public OrganizationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}