package com.ems.api.dto;

import com.ems.api.entity.BranchEntity;
import com.ems.api.entity.DepartmentEntity;
import com.ems.api.entity.OrganizationEntity;
import com.ems.api.entity.RoleEntity;

import lombok.Data;

@Data
public class UserResponse {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Boolean isActive;
	private Boolean isDeleted;
	private String image;
	private RoleEntity role;
	private BranchEntity branch;
	private DepartmentEntity department;
	private OrganizationEntity organization;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
