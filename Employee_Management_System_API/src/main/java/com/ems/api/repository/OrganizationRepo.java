package com.ems.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.api.entity.OrganizationEntity;

@Repository
public interface OrganizationRepo extends JpaRepository<OrganizationEntity, Integer> {

	public Optional<OrganizationEntity> findByName(String name);

	@Query("SELECT o FROM OrganizationEntity o ORDER BY o.createdAt DESC")
	List<OrganizationEntity> findAllOrganizationsSortedByCreatedAtDesc();
	
	  boolean existsById(Integer id);
	   Optional<OrganizationEntity> findById(Integer id);

}
