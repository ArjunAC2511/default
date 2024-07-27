package com.ems.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Integer clientId;

	@Column(nullable = false, length = 100)
	private String clientName;
	private String clientLocation;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

	public ClientEntity(Integer clientId, String clientName, String clientLocation) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientLocation = clientLocation;
	}

	public ClientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}