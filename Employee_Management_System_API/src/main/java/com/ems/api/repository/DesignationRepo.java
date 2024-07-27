package com.ems.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.api.entity.DesignationEntity;

public interface DesignationRepo extends JpaRepository<DesignationEntity, Integer> {

}

