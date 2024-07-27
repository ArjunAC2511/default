package com.ems.api.service;

import java.util.List;

import com.ems.api.dto.OrganizationDto;
import com.ems.api.dto.OrganizationReq;
import com.ems.api.dto.OrganizeStatusReq;

public interface OrganizationService {

	public String adddOrganization(OrganizationReq organization, String email);

	public OrganizationDto getOrganization(int organizationId);

	public List<OrganizationDto> getAllOrganizations();

	public String updateOrganization(int organizationId, OrganizationDto organization, String email);

	public OrganizationDto activeOrganization(int organizationId, OrganizeStatusReq status);

}
