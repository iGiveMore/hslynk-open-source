package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("project")
public class Project extends ClientModel {
	
	private UUID projectId;
	private UUID organizationId;
    private String projectName;
    private String projectCommonName;
    private Integer continuumProject;
    private Integer projectType;
    private Integer residentialAffiliation;
    private Integer targetPopulation;
    private Integer trackingMethod;
    private String projectGroup;
	private String source;
    
	public Project() {
		
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Project(UUID projectId) {
		this.projectId = projectId;
	}

	public UUID getProjectId() {
		return projectId;
	}

	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}

	public String getProjectCommonName() {
		return projectCommonName;
	}

	public void setProjectCommonName(String projectCommonName) {
		this.projectCommonName = projectCommonName;
	}

	public Integer getContinuumProject() {
		return continuumProject;
	}

	public void setContinuumProject(Integer continuumProject) {
		this.continuumProject = continuumProject;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public Integer getResidentialAffiliation() {
		return residentialAffiliation;
	}

	public void setResidentialAffiliation(Integer residentialAffiliation) {
		this.residentialAffiliation = residentialAffiliation;
	}

	public Integer getTargetPopulation() {
		return targetPopulation;
	}

	public void setTargetPopulation(Integer targetPopulation) {
		this.targetPopulation = targetPopulation;
	}

	public Integer getTrackingMethod() {
		return trackingMethod;
	}

	public void setTrackingMethod(Integer trackingMethod) {
		this.trackingMethod = trackingMethod;
	}

	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}

	public UUID getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(UUID organizationId) {
		this.organizationId = organizationId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}