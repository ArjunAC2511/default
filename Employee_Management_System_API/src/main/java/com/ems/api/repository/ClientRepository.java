package com.ems.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.api.entity.ClientEntity;


public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

}
