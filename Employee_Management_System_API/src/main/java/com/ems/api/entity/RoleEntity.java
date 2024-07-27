package com.ems.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class RoleEntity {

	@Id
	private Integer roleId;
	private String name;

}
