package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonRootName("project")
public class Project extends ClientModel {
	
	private UUID projectId;
    private String projectName;
    private String projectCommonName;
    private Integer continuumProject;
    private Integer projectType;
    private Integer residentialAffiliation;
    private Integer hmisParticipatingProject;
    private Integer targetPopulation;
    private Integer trackingMethod;
    private UUID organizationId;
    private String projectGroup;
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
    private LocalDateTime operatingStartDate;
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
    private LocalDateTime operatingEndDate;
    private Integer housingType;
    private Integer pitCount;
	private String source;
	private String sourceSystemId;
    
    
	public UUID getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(UUID organizationId) {
		this.organizationId = organizationId;
	}

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
	/**
	 * @return the hmisParticipatingProject
	 */
	public Integer getHmisParticipatingProject() {
		return hmisParticipatingProject;
	}

	/**
	 * @param hmisParticipatingProject the hmisParticipatingProject to set
	 */
	public void setHmisParticipatingProject(Integer hmisParticipatingProject) {
		this.hmisParticipatingProject = hmisParticipatingProject;
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

	public LocalDateTime getOperatingStartDate() {
		return operatingStartDate;
	}

	public void setOperatingStartDate(LocalDateTime operatingStartDate) {
		this.operatingStartDate = operatingStartDate;
	}

	public LocalDateTime getOperatingEndDate() {
		return operatingEndDate;
	}

	public void setOperatingEndDate(LocalDateTime operatingEndDate) {
		this.operatingEndDate = operatingEndDate;
	}

	public Integer getHousingType() {
		return housingType;
	}

	public void setHousingType(Integer housingType) {
		this.housingType = housingType;
	}
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	/**
	 * @return the pitCount
	 */
	public Integer getPitCount() {
		return pitCount;
	}

	/**
	 * @param pitCount the pitCount to set
	 */
	public void setPitCount(Integer pitCount) {
		this.pitCount = pitCount;
	}
}