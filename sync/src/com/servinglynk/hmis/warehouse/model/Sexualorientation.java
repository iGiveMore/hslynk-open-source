package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Sexualorientation extends BaseModel{

	@Column(name = "enrollmentid")		
	private UUID enrollmentid;
	@Column(name = "sexualorientation")
	private String sexualorientation;
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the sexualorientation
	 */
	public String getSexualorientation() {
		return sexualorientation;
	}
	/**
	 * @param sexualorientation the sexualorientation to set
	 */
	public void setSexualorientation(String sexualorientation) {
		this.sexualorientation = sexualorientation;
	}
	
}
