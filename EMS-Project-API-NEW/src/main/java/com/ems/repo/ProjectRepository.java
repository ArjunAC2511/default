package com.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
