package com.ems.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.api.dto.OrganizationDto;
import com.ems.api.dto.OrganizationReq;
import com.ems.api.dto.OrganizeStatusReq;
import com.ems.api.exception.NotFoundException;
import com.ems.api.service.OrganizationService;
@CrossOrigin(origins = "*")
@RestController
public class OrganizationController {

    @Autowired
   private OrganizationService organizationService;

    @PostMapping("/addorganization/{createdBy}")
    public ResponseEntity<String> addOrganization(@RequestBody OrganizationReq organization, @PathVariable String createdBy) {
        String result = organizationService.adddOrganization(organization, createdBy);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/updateorganization/{organizationId}/{updatedBy}")
    public ResponseEntity<String> updateOrganization(@PathVariable Integer organizationId, @RequestBody OrganizationDto organization,
                                                     @PathVariable String updatedBy) {
        String result = organizationService.updateOrganization(organizationId, organization, updatedBy);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/getorganization/{organizationId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Integer organizationId) {
        OrganizationDto organization = organizationService.getOrganization(organizationId);
        if (organization == null) {
            throw new NotFoundException("Organization not found with id: " + organizationId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(organization);
    }

    @GetMapping("/allorganizations")
    public ResponseEntity<List<OrganizationDto>> getAllOrganizations() {
        List<OrganizationDto> organizations = organizationService.getAllOrganizations();
        return ResponseEntity.status(HttpStatus.OK).body(organizations);
    }

    @PostMapping("/changeStatus/{organizationId}")
    public ResponseEntity<OrganizationDto> changeStatus(@PathVariable int organizationId,
                                                        @RequestBody OrganizeStatusReq status) {
        String organizationIdString = String.valueOf(organizationId);
        if (organizationIdString.isEmpty()) {
            throw new NotFoundException("Id must be valid");
        }
        OrganizationDto organization = organizationService.activeOrganization(organizationId, status);
        return ResponseEntity.status(HttpStatus.OK).body(organization);
    }
}
