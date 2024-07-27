package com.ems.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.api.dto.DesignationDto;
import com.ems.api.entity.BranchEntity;
import com.ems.api.entity.DepartmentEntity;
import com.ems.api.entity.DesignationEntity;
import com.ems.api.entity.OrganizationEntity;
import com.ems.api.exception.BadRequestException;
import com.ems.api.exception.NotFoundException;
import com.ems.api.repository.BranchRepository;
import com.ems.api.repository.DepartmentRepo;
import com.ems.api.repository.DesignationRepo;
import com.ems.api.repository.OrganizationRepo;
import com.ems.api.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepo designationRepo;
	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private BranchRepository branchRepo;

	@Autowired
	private OrganizationRepo organizationRepo;

	@Override
	public DesignationEntity addDesignation(DesignationDto designationDto) {
		if (designationDto == null) {
			throw new BadRequestException("Designation DTO cannot be null");
		}

		Optional<DepartmentEntity> departmentOptional = departmentRepo.findById(designationDto.getDepartmentId());
		if (departmentOptional.isEmpty()) {
			throw new NotFoundException("Department with id " + designationDto.getDepartmentId() + " not found");
		}
		DepartmentEntity department = departmentOptional.get();

		Optional<BranchEntity> branchOptional = branchRepo.findById(designationDto.getBranchId());
		if (branchOptional.isEmpty()) {
			throw new NotFoundException("Branch with id " + designationDto.getBranchId() + " not found");
		}
		BranchEntity branch = branchOptional.get();

		Optional<OrganizationEntity> organizationOptional = organizationRepo
				.findById(designationDto.getOrganizationId());
		if (organizationOptional.isEmpty()) {
			throw new NotFoundException("Organization with id " + designationDto.getOrganizationId() + " not found");
		}
		OrganizationEntity organization = organizationOptional.get();

		validateDesignationDto(designationDto);

		DesignationEntity desg = new DesignationEntity();
		BeanUtils.copyProperties(designationDto, desg);

		desg.setDepartment(department);
		desg.setBranch(branch);
		desg.setOrganization(organization);

		return designationRepo.save(desg);
	}

	private void validateDesignationDto(DesignationDto designationDto) {
		if (designationDto.getName() == null || designationDto.getName().isEmpty()) {
			throw new BadRequestException("Designation name cannot be null or empty");
		}
	}

	@Override
	public DesignationEntity updateDesignation(int id, DesignationEntity designation) {
		Optional<DesignationEntity> existingDesignation = designationRepo.findById(id);
		if (existingDesignation.isPresent()) {
			DesignationEntity updatedDesignation = existingDesignation.get();
			updatedDesignation.setName(designation.getName());
			updatedDesignation.setDepartment(designation.getDepartment());
			updatedDesignation.setBranch(designation.getBranch());
			updatedDesignation.setOrganization(designation.getOrganization());
			return designationRepo.save(updatedDesignation);
		} else {
			throw new RuntimeException("Designation not found with id " + id);
		}
	}

	@Override
	public void deleteDesignation(int id) {
		designationRepo.deleteById(id);
	}

	@Override
	public DesignationEntity getDesignationById(int id) {
		return designationRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Designation not found with id " + id));
	}

	@Override
	public List<DesignationEntity> getAllDesignations() {
		return designationRepo.findAll();
	}
}
