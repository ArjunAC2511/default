package com.ems.api.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ems.api.dto.OrganizationDto;
import com.ems.api.dto.OrganizationReq;
import com.ems.api.dto.OrganizeStatusReq;
import com.ems.api.entity.OrganizationEntity;
import com.ems.api.exception.BadRequestException;
import com.ems.api.exception.NotFoundException;
import com.ems.api.repository.OrganizationRepo;
import com.ems.api.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepo organizeRepository;

	@Override
	public String adddOrganization(OrganizationReq organization, String createdBy) {
		if (createdBy.isBlank() || "Null".equalsIgnoreCase(createdBy)) {
			throw new NotFoundException("User email not found.");

		}

		Optional<OrganizationEntity> name = organizeRepository.findByName(organization.getName());
		if (name.isPresent()) {
			throw new BadRequestException("Organization name already exists.");

		}

		if (null == organization.getStatus()) {

			throw new BadRequestException("status not found.");

		}

		OrganizationEntity entity = new OrganizationEntity();
		entity.setName(organization.getName());
		entity.setStatus(organization.getStatus());
		entity.setCreatedBy(createdBy);
		entity.setCreatedAt(LocalDateTime.now());
		organizeRepository.save(entity);

		return "saved successfully";
	}

	@Override
	public OrganizationDto getOrganization(int organizationId) {

		Optional<OrganizationEntity> optional = organizeRepository.findById(organizationId);
		if (optional.isPresent()) {
			OrganizationEntity organization = optional.get();
			OrganizationDto dto = new OrganizationDto();
			dto.setName(organization.getName());
			dto.setOrganizationId(organization.getOrganizationId());
			dto.setStatus(organization.isStatus());
			return dto;
		}
		throw new NotFoundException("Organization does not exist.");
	}

	@Override
	public List<OrganizationDto> getAllOrganizations() {

		Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");

		List<OrganizationEntity> list = organizeRepository.findAll(sort);

		// List<Organization> list =
		// organizeRepository.findAllOrganizationsSortedByCreatedAtDesc();

		if (list.isEmpty()) {
			return new ArrayList<>();
		}

		List<OrganizationDto> dtos = new ArrayList<>();
		for (OrganizationEntity entity : list) {
			OrganizationDto dto = new OrganizationDto();
			dto.setName(entity.getName());
			dto.setStatus(entity.isStatus());
			dto.setOrganizationId(entity.getOrganizationId());
			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public String updateOrganization(int organizationId, OrganizationDto organization, String updatedBy) {
		if (updatedBy.isEmpty() || "Null".equalsIgnoreCase(updatedBy)) {
			throw new NotFoundException("User email not found.");
		}

		Optional<OrganizationEntity> organizationObj = organizeRepository.findById(organizationId);
		if (organizationObj.isPresent()) {
			OrganizationEntity entity = organizationObj.get();
			entity.setName(organization.getName());
			entity.setUpdatedAt(LocalDateTime.now());
			entity.setStatus(organization.getStatus());
			entity.setUpdatedBy(updatedBy);
			organizeRepository.save(entity);

			return "saved successfully";
		}

		throw new NotFoundException("Organization does not exist.");
	}

	@Override
	public OrganizationDto activeOrganization(int organizationId, OrganizeStatusReq statusReq) {
	
		  if (statusReq == null||String.valueOf(organizationId).isBlank()) {
	            throw new BadRequestException("Please enter a valid input.");
	        }

	        Optional<OrganizationEntity> optionalOrganization = organizeRepository.findById(organizationId);

	        if (optionalOrganization.isPresent()) {
	            OrganizationEntity organization = optionalOrganization.get();

	            boolean inputStatus = statusReq.isStatus();
	            organization.setStatus(inputStatus);

	            OrganizationEntity savedOrganization = organizeRepository.save(organization);
	            OrganizationDto dto = new OrganizationDto();
	            BeanUtils.copyProperties(savedOrganization, dto);
	            return dto;
	        } else {
	            throw new NotFoundException("Organization does not exist.");
	        }
	    }
}
