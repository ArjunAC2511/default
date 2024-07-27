package com.ems.api.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	private String image;

	@Column(nullable = false, length = 50, name = "firstName")
	private String firstName;

	@Column(length = 50, name = "lastName")
	private String lastName;

	@Column(nullable = false, length = 50, unique = true)
	private String email;

	@Column(nullable = false, length = 50, name = "phoneNumber")
	private String phoneNumber;

	@Column(nullable = false, length = 500)
	private String password;

	@Column(nullable = false, name = "isActive")
	private Boolean isActive;

	@Column(nullable = false, name = "isDeleted")
	private Boolean isDeleted;

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	private DesignationEntity role;

	@ManyToOne
	@JoinColumn(name = "branchId", nullable = false)
	private BranchEntity branch;

	@ManyToOne
	@JoinColumn(name = "departmentId", nullable = false)
	private DepartmentEntity department;

	@ManyToOne
	@JoinColumn(name = "organizationId", nullable = false)
	private OrganizationEntity organization;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "updatedBy")
	private String updatedBy;

	@CreatedDate
	@Column(name = "createdDate", updatable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;
	
	
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public DesignationEntity getRole() {
		return role;
	}

	public void setRole(DesignationEntity role) {
		this.role = role;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserEntity(Integer userId, String image, String firstName, String lastName, String email, String phoneNumber,
			String password, Boolean isActive, Boolean isDeleted, DesignationEntity role, BranchEntity branch,
			DepartmentEntity department, OrganizationEntity organization, String createdBy, String updatedBy,
			LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.userId = userId;
		this.image = image;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.role = role;
		this.branch = branch;
		this.department = department;
		this.organization = organization;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(branch, createdBy, createdDate, department, email, firstName, image, isActive, isDeleted,
				lastName, organization, password, phoneNumber, role, updatedBy, updatedDate, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(branch, other.branch) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(department, other.department)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(image, other.image) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(organization, other.organization) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(role, other.role)
				&& Objects.equals(updatedBy, other.updatedBy) && Objects.equals(updatedDate, other.updatedDate)
				&& Objects.equals(userId, other.userId);
	}

}