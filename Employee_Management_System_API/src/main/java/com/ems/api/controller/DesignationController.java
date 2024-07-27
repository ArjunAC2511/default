package com.ems.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.api.dto.DesignationDto;
import com.ems.api.entity.DesignationEntity;
import com.ems.api.service.DesignationService;
@CrossOrigin(origins = "*")
@RestController

public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@PostMapping("/addDesignation")
	public ResponseEntity<DesignationEntity> addDesignation(@RequestBody DesignationDto designation) {
		DesignationEntity entity = designationService.addDesignation(designation);
		if (entity != null) {
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<DesignationEntity> updateDesignation(@PathVariable int id,
			@RequestBody DesignationEntity designation) {
		try {
			DesignationEntity updatedDesignation = designationService.updateDesignation(id, designation);
			return ResponseEntity.ok(updatedDesignation);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteDesignation(@PathVariable int id) {
		try {
			designationService.deleteDesignation(id);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/getby/{id}")
	public ResponseEntity<DesignationEntity> getDesignationById(@PathVariable int id) {
		try {
			DesignationEntity designation = designationService.getDesignationById(id);
			return ResponseEntity.ok(designation);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<List<DesignationEntity>> getAllDesignations() {
		List<DesignationEntity> designations = designationService.getAllDesignations();
		return ResponseEntity.ok(designations);
	}
}
