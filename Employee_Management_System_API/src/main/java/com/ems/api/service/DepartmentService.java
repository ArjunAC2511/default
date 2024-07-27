package com.ems.api.service;

import com.ems.api.dto.DepartmentDto;
import com.ems.api.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

	DepartmentEntity saveDepartment(DepartmentDto departmentDto, int organizationId, int branchId);

	DepartmentEntity getDepartmentById(int departmentId);

	DepartmentEntity changeDepartmentStatus(int departmentId, boolean status);

	String deleteById(int departmentId);

	List<DepartmentEntity> getAllDepartments();

	DepartmentEntity updateDepartment(int departmentId, DepartmentDto departmentDto);
}
