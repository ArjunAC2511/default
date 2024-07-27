package com.ems.api.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	private String projectName;
	private String shortCode;
	private String projectSummary;
	private Boolean projectDeadline;
	private LocalDate projectStartDate;
	private LocalDate projectDeadlineDate;
	private String currency;

	private Boolean addProjectBudget;
	private Double projectBudget;
	private Integer hoursEstimate;
	private Integer weeksEstimate;
	private Integer monthsEstimate;
	private String clientLocation;

	
	@ManyToOne
	@JoinColumn(name = "clientId", nullable = false)
	private ClientEntity client;

	@ManyToOne
	@JoinColumn(name = "departmentId", nullable = false)
	private DepartmentEntity department;

	
	
	
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getProjectSummary() {
		return projectSummary;
	}

	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}

	public Boolean getProjectDeadline() {
		return projectDeadline;
	}

	public void setProjectDeadline(Boolean projectDeadline) {
		this.projectDeadline = projectDeadline;
	}

	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public LocalDate getProjectDeadlineDate() {
		return projectDeadlineDate;
	}

	public void setProjectDeadlineDate(LocalDate projectDeadlineDate) {
		this.projectDeadlineDate = projectDeadlineDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boolean getAddProjectBudget() {
		return addProjectBudget;
	}

	public void setAddProjectBudget(Boolean addProjectBudget) {
		this.addProjectBudget = addProjectBudget;
	}

	public Double getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(Double projectBudget) {
		this.projectBudget = projectBudget;
	}

	public Integer getHoursEstimate() {
		return hoursEstimate;
	}

	public void setHoursEstimate(Integer hoursEstimate) {
		this.hoursEstimate = hoursEstimate;
	}

	public Integer getWeeksEstimate() {
		return weeksEstimate;
	}

	public void setWeeksEstimate(Integer weeksEstimate) {
		this.weeksEstimate = weeksEstimate;
	}

	public Integer getMonthsEstimate() {
		return monthsEstimate;
	}

	public void setMonthsEstimate(Integer monthsEstimate) {
		this.monthsEstimate = monthsEstimate;
	}

	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public ProjectEntity(Integer projectId, String projectName, String shortCode, String projectSummary,
			Boolean projectDeadline, LocalDate projectStartDate, LocalDate projectDeadlineDate, String currency,
			Boolean addProjectBudget, Double projectBudget, Integer hoursEstimate, Integer weeksEstimate,
			Integer monthsEstimate, String clientLocation, ClientEntity client, DepartmentEntity department) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.shortCode = shortCode;
		this.projectSummary = projectSummary;
		this.projectDeadline = projectDeadline;
		this.projectStartDate = projectStartDate;
		this.projectDeadlineDate = projectDeadlineDate;
		this.currency = currency;
		this.addProjectBudget = addProjectBudget;
		this.projectBudget = projectBudget;
		this.hoursEstimate = hoursEstimate;
		this.weeksEstimate = weeksEstimate;
		this.monthsEstimate = monthsEstimate;
		this.clientLocation = clientLocation;
		this.client = client;
		this.department = department;
	}

	public ProjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}