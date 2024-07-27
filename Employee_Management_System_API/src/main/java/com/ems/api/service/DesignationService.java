package com.ems.api.service;

import java.util.List;

import com.ems.api.dto.DesignationDto;
import com.ems.api.entity.DesignationEntity;

public interface DesignationService {

	DesignationEntity addDesignation(DesignationDto designation);

	DesignationEntity updateDesignation(int id, DesignationEntity designation);

	void deleteDesignation(int id);

	DesignationEntity getDesignationById(int id);

	List<DesignationEntity> getAllDesignations();
}
