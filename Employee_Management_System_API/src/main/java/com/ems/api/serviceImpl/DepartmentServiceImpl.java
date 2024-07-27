//
//
//package com.ems.api.serviceImpl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ems.api.dto.DepartmentDto;
//import com.ems.api.entity.BranchEntity;
//import com.ems.api.entity.DepartmentEntity;
//import com.ems.api.entity.OrganizationEntity;
//import com.ems.api.exception.BadRequestException;
//import com.ems.api.exception.NotFoundException;
//import com.ems.api.repository.BranchRepository;
//import com.ems.api.repository.DepartmentRepo;
//import com.ems.api.repository.OrganizationRepo;
//import com.ems.api.service.DepartmentService;
//
//@Service
//public class DepartmentServiceImpl implements DepartmentService {
//
//    @Autowired
//    private DepartmentRepo departmentRepo;
//
//    @Autowired
//    private BranchRepository branchRepo;
//
//    @Autowired
//    private OrganizationRepo organizationRepo;
//
//    @Override
//    public DepartmentEntity saveDepartment(DepartmentDto departmentDto, int organizationId, int branchId) {
//        if (departmentDto == null) {
//            throw new BadRequestException("Department DTO cannot be null");
//        }
//
//        Optional<OrganizationEntity> organizationOptional = organizationRepo.findById(organizationId);
//        if (organizationOptional.isEmpty()) {
//            throw new NotFoundException("Organization with id " + organizationId + " not found");
//        }
//        OrganizationEntity organization = organizationOptional.get();
//
//        Optional<BranchEntity> branchOptional = branchRepo.findById(branchId);
//        if (branchOptional.isEmpty()) {
//            throw new NotFoundException("Branch with id " + branchId + " not found");
//        }
//        BranchEntity branch = branchOptional.get();
//
//        validateDepartmentDto(departmentDto);
//
//        DepartmentEntity departmentEntity = new DepartmentEntity();
//        BeanUtils.copyProperties(departmentDto, departmentEntity);
//
//        departmentEntity.setOrganization(organization);
//        departmentEntity.setBranch(branch);
//        departmentEntity.setStatus(departmentDto.getStatus());
//
//        return departmentRepo.save(departmentEntity);
//    }
//
//    @Override
//    public DepartmentEntity getDepartmentById(int departmentId) {
//        Optional<DepartmentEntity> departmentOptional = departmentRepo.findById(departmentId);
//        return departmentOptional.orElseThrow(() -> new NotFoundException("Department with id " + departmentId + " not found"));
//    }
//
//    @Override
//    public String deleteById(int departmentId) {
//        if (!departmentRepo.existsById(departmentId)) {
//            throw new NotFoundException("Department with id " + departmentId + " not found");
//        }
//        departmentRepo.deleteById(departmentId);
//        return "Department with id " + departmentId + " has been deleted successfully";
//    }
//
//    @Override
//    public List<DepartmentEntity> getAllDepartments() {
//        return departmentRepo.findAll();
//    }
//
//    @Override
//    public DepartmentEntity updateDepartment(int departmentId, DepartmentDto departmentDto) {
//        if (departmentDto == null) {
//            throw new BadRequestException("Department DTO cannot be null");
//        }
//
//        DepartmentEntity departmentEntity = getDepartmentById(departmentId);
//
//        validateDepartmentDto(departmentDto);
//
//        BeanUtils.copyProperties(departmentDto, departmentEntity);
//
//        return departmentRepo.save(departmentEntity);
//    }
//
//    @Override
//    public DepartmentEntity changeDepartmentStatus(int departmentId, boolean status) {
//        Optional<DepartmentEntity> departmentOptional = departmentRepo.findById(departmentId);
//        if (departmentOptional.isEmpty()) {
//            throw new NotFoundException("Department with id " + departmentId + " not found");
//        }
//        DepartmentEntity departmentEntity = departmentOptional.get();
//        departmentEntity.setStatus(status);
//        return departmentRepo.save(departmentEntity);
//    }
//
//    private void validateDepartmentDto(DepartmentDto departmentDto) {
//        if (departmentDto.getName() == null || departmentDto.getName().isEmpty()) {
//            throw new BadRequestException("Department name cannot be null or empty");
//        }
//    }
//}




package com.ems.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.api.dto.DepartmentDto;
import com.ems.api.entity.BranchEntity;
import com.ems.api.entity.DepartmentEntity;
import com.ems.api.entity.OrganizationEntity;
import com.ems.api.exception.BadRequestException;
import com.ems.api.exception.NotFoundException;
import com.ems.api.repository.BranchRepository;
import com.ems.api.repository.DepartmentRepo;
import com.ems.api.repository.OrganizationRepo;
import com.ems.api.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private BranchRepository branchRepo;

    @Autowired
    private OrganizationRepo organizationRepo;

    @Override
    public DepartmentEntity saveDepartment(DepartmentDto departmentDto, int organizationId, int branchId) {
        if (departmentDto == null) {
            throw new BadRequestException("Department DTO cannot be null");
        }

        Optional<OrganizationEntity> organizationOptional = organizationRepo.findById(organizationId);
        if (organizationOptional.isEmpty()) {
            throw new NotFoundException("Organization with id " + organizationId + " not found");
        }
        OrganizationEntity organization = organizationOptional.get();

        Optional<BranchEntity> branchOptional = branchRepo.findById(branchId);
        if (branchOptional.isEmpty()) {
            throw new NotFoundException("Branch with id " + branchId + " not found");
        }
        BranchEntity branch = branchOptional.get();

        validateDepartmentDto(departmentDto);

        DepartmentEntity departmentEntity = new DepartmentEntity();
        BeanUtils.copyProperties(departmentDto, departmentEntity);

        departmentEntity.setOrganization(organization);
        departmentEntity.setBranch(branch);
        departmentEntity.setStatus(departmentDto.getStatus());

        return departmentRepo.save(departmentEntity);
    }

    @Override
    public DepartmentEntity getDepartmentById(int departmentId) {
        Optional<DepartmentEntity> departmentOptional = departmentRepo.findById(departmentId);
        return departmentOptional.orElseThrow(() -> new NotFoundException("Department with id " + departmentId + " not found"));
    }

    @Override
    public String deleteById(int departmentId) {
        if (!departmentRepo.existsById(departmentId)) {
            throw new NotFoundException("Department with id " + departmentId + " not found");
        }
        departmentRepo.deleteById(departmentId);
        return "Department with id " + departmentId + " has been deleted successfully";
    }

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public DepartmentEntity updateDepartment(int departmentId, DepartmentDto departmentDto) {
        if (departmentDto == null) {
            throw new BadRequestException("Department DTO cannot be null");
        }

        DepartmentEntity departmentEntity = getDepartmentById(departmentId);

        validateDepartmentDto(departmentDto);

        BeanUtils.copyProperties(departmentDto, departmentEntity);

        return departmentRepo.save(departmentEntity);
    }

    @Override
    public DepartmentEntity changeDepartmentStatus(int departmentId, boolean status) {
        Optional<DepartmentEntity> departmentOptional = departmentRepo.findById(departmentId);
        if (departmentOptional.isEmpty()) {
            throw new NotFoundException("Department with id " + departmentId + " not found");
        }
        DepartmentEntity departmentEntity = departmentOptional.get();
        departmentEntity.setStatus(status);
        return departmentRepo.save(departmentEntity);
    }

    private void validateDepartmentDto(DepartmentDto departmentDto) {
        if (departmentDto.getName() == null || departmentDto.getName().isEmpty()) {
            throw new BadRequestException("Department name cannot be null or empty");
        }
    }
}
