//package com.ems.api.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ems.api.dto.DepartmentDto;
//import com.ems.api.entity.DepartmentEntity;
//import com.ems.api.service.DepartmentService;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/departments")
//public class DepartmentController {
//
//	@Autowired
//	private DepartmentService departmentService;
//
//	@PostMapping("/addDepartment")
//	public ResponseEntity<DepartmentEntity> saveDepartment(@Validated @RequestBody DepartmentDto departmentDto,
//			@RequestParam("organizationId") int organizationId, @RequestParam("branchId") int branchId) {
//		DepartmentEntity savedDepartment = departmentService.saveDepartment(departmentDto, organizationId, branchId);
//		return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
//	}
//
//	@GetMapping("/{departmentId}")
//	public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable("departmentId") int departmentId) {
//		DepartmentEntity department = departmentService.getDepartmentById(departmentId);
//		return ResponseEntity.ok(department);
//	}
//
//	@DeleteMapping("/{departmentId}")
//	public ResponseEntity<String> deleteDepartmentById(@PathVariable("departmentId") int departmentId) {
//		String message = departmentService.deleteById(departmentId);
//		return ResponseEntity.ok(message);
//	}
//
//	@GetMapping("/getAlldept")
//	public ResponseEntity<List<DepartmentEntity>> getAllDepartments() {
//		List<DepartmentEntity> departments = departmentService.getAllDepartments();
//		return ResponseEntity.ok(departments);
//	}
//
//	@PutMapping("/{departmentId}")
//	public ResponseEntity<DepartmentEntity> updateDepartment(@PathVariable("departmentId") int departmentId,
//			@Validated @RequestBody DepartmentDto departmentDto) {
//		DepartmentEntity updatedDepartment = departmentService.updateDepartment(departmentId, departmentDto);
//		return ResponseEntity.ok(updatedDepartment);
//	}
//
//}



package com.ems.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ems.api.dto.DepartmentDto;
import com.ems.api.entity.DepartmentEntity;
import com.ems.api.service.DepartmentService;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<DepartmentEntity> saveDepartment(
            @Validated @RequestBody DepartmentDto departmentDto,
            @RequestParam int organizationId,
            @RequestParam int branchId) {
        DepartmentEntity savedDepartment = departmentService.saveDepartment(departmentDto, organizationId, branchId);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable int departmentId) {
        DepartmentEntity department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable int departmentId) {
        String response = departmentService.deleteById(departmentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    
    
    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentEntity>> getAllDepartments() {
        List<DepartmentEntity> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }


    
    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentEntity> updateDepartment(
            @PathVariable int departmentId,
            @Validated @RequestBody DepartmentDto departmentDto) {
        DepartmentEntity updatedDepartment = departmentService.updateDepartment(departmentId, departmentDto);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @PutMapping("/{departmentId}/status")
    public ResponseEntity<DepartmentEntity> changeDepartmentStatus(
            @PathVariable int departmentId,
            @RequestParam boolean status) {
        DepartmentEntity updatedDepartment = departmentService.changeDepartmentStatus(departmentId, status);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }
}

