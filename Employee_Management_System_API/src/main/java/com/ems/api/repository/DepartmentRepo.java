package com.ems.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.api.entity.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer>{

	Optional<DepartmentEntity> findById(int departrmentId);
}
