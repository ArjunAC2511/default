package com.ems.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.api.entity.ProjectEntity;


public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {

}
