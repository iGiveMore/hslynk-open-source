package com.servinglynk.hmis.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "bed_occupant", schema =  "bed_inventory")
public class BedOccupantEntity extends BaseEntity {

	@Id
	@Column(name = "id", nullable = false)
	  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name = "client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID clientId;
	
	@Column(name = "decup_cleint_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID dedupClientId;
	
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Column(name = "occupancy_start_date")
	private Date occupancyStartDate;

	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Column(name = "occupancy_end_date")
	private Date occupancyEndDate;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "enrollment_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID enrollemntId;
	
	@Column(name = "enrollment_type")
	private String enrollmentType;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "bed_id", nullable = true )
	private BedUnitEntity bedUnit;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public UUID getDedupClientId() {
		return dedupClientId;
	}
	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	public Date getOccupancyStartDate() {
		return occupancyStartDate;
	}
	public void setOccupancyStartDate(Date occupancyStartDate) {
		this.occupancyStartDate = occupancyStartDate;
	}
	public Date getOccupancyEndDate() {
		return occupancyEndDate;
	}
	public void setOccupancyEndDate(Date occupancyEndDate) {
		this.occupancyEndDate = occupancyEndDate;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public BedUnitEntity getBedUnit() {
		return bedUnit;
	}
	public void setBedUnit(BedUnitEntity bedUnit) {
		this.bedUnit = bedUnit;
	}
	public UUID getEnrollemntId() {
		return enrollemntId;
	}
	public void setEnrollemntId(UUID enrollemntId) {
		this.enrollemntId = enrollemntId;
	}
	public String getEnrollmentType() {
		return enrollmentType;
	}
	public void setEnrollmentType(String enrollmentType) {
		this.enrollmentType = enrollmentType;
	}
}