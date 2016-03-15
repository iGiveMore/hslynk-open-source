package com.servinglynk.hmis.warehouse.model.v2015;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.model.stagv2015.HmisBaseStagingModel;

/** 
 * Object mapping for hibernate-handled table: exitrhy.
 * 
 *
 * @author autogenerated
 */
		

@Entity(name = "exitrhy_v2015")
@Table(name = "exitrhy", catalog = "hmis", schema = "v2015")
public class Exitrhy extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -4922345514822424647L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private Integer assistanceMainStreamBenefits;
	/** Field mapping. */
	private Integer earlyExitReason;
	/** Field mapping. */
	private Exit exitid;
	/** Field mapping. */
	private Integer exitCounseling;
	/** Field mapping. */
	private Integer familyReunificationAchieved;
	/** Field mapping. */
	private Integer furtherFollowupServices;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Integer otherAftercarePlanOrAction;
	/** Field mapping. */
	private Integer permenantHousingPlacement;
	/** Field mapping. */
	private Integer projectCompletionStatus;
	/** Field mapping. */
	private Integer resourcePackage;
	/** Field mapping. */
	private Integer scheduledFollowupContacts;
	/** Field mapping. */
	private Integer tempShelterPlacement;
	/** Field mapping. */
	private Integer writtenAfterCarePlan;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Exitrhy() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Exitrhy(java.util.UUID id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Exitrhy.class;
	}
 

	 /**
	 * Return the value associated with the column: assistanceMainStreamBenefits.
	 * @return A Integer object (this.assistanceMainStreamBenefits)
	 */
	@Basic( optional = true )
	@Column( name = "assistance_main_stream_benefits"  )
	public Integer getAssistanceMainStreamBenefits() {
		return this.assistanceMainStreamBenefits;
		
	}
	

  
	 /**  
	 * Set the value related to the column: assistanceMainStreamBenefits.
	 * @param assistanceMainStreamBenefits the assistanceMainStreamBenefits value you wish to set
	 */
	public void setAssistanceMainStreamBenefits(final Integer assistanceMainStreamBenefits) {
		this.assistanceMainStreamBenefits = assistanceMainStreamBenefits;
	}

	 /**
	 * Return the value associated with the column: earlyExitReason.
	 * @return A Integer object (this.earlyExitReason)
	 */
	@Basic( optional = true )
	@Column( name = "early_exit_reason"  )
	public Integer getEarlyExitReason() {
		return this.earlyExitReason;
		
	}
	

  
	 /**  
	 * Set the value related to the column: earlyExitReason.
	 * @param earlyExitReason the earlyExitReason value you wish to set
	 */
	public void setEarlyExitReason(final Integer earlyExitReason) {
		this.earlyExitReason = earlyExitReason;
	}

	 /**
	 * Return the value associated with the column: exitid.
	 * @return A Exit object (this.exitid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "exitId", nullable = true )
	public Exit getExitid() {
		return this.exitid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: exitid.
	 * @param exitid the exitid value you wish to set
	 */
	public void setExitid(final Exit exitid) {
		this.exitid = exitid;
	}

	 /**
	 * Return the value associated with the column: exitCounseling.
	 * @return A Integer object (this.exitCounseling)
	 */
	@Basic( optional = true )
	@Column( name = "exit_counseling"  )
	public Integer getExitCounseling() {
		return this.exitCounseling;
		
	}
	

  
	 /**  
	 * Set the value related to the column: exitCounseling.
	 * @param exitCounseling the exitCounseling value you wish to set
	 */
	public void setExitCounseling(final Integer exitCounseling) {
		this.exitCounseling = exitCounseling;
	}

	 /**
	 * Return the value associated with the column: familyReunificationAchieved.
	 * @return A Integer object (this.familyReunificationAchieved)
	 */
	@Basic( optional = true )
	@Column( name = "family_reunification_achieved"  )
	public Integer getFamilyReunificationAchieved() {
		return this.familyReunificationAchieved;
		
	}
	

  
	 /**  
	 * Set the value related to the column: familyReunificationAchieved.
	 * @param familyReunificationAchieved the familyReunificationAchieved value you wish to set
	 */
	public void setFamilyReunificationAchieved(final Integer familyReunificationAchieved) {
		this.familyReunificationAchieved = familyReunificationAchieved;
	}

	 /**
	 * Return the value associated with the column: furtherFollowupServices.
	 * @return A Integer object (this.furtherFollowupServices)
	 */
	@Basic( optional = true )
	@Column( name = "further_followup_services"  )
	public Integer getFurtherFollowupServices() {
		return this.furtherFollowupServices;
		
	}
	

  
	 /**  
	 * Set the value related to the column: furtherFollowupServices.
	 * @param furtherFollowupServices the furtherFollowupServices value you wish to set
	 */
	public void setFurtherFollowupServices(final Integer furtherFollowupServices) {
		this.furtherFollowupServices = furtherFollowupServices;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A java.util.UUID object (this.id)
	 */
	@Id 
	 @Basic( optional = false )
   @Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final java.util.UUID id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: otherAftercarePlanOrAction.
	 * @return A Integer object (this.otherAftercarePlanOrAction)
	 */
	@Basic( optional = true )
	@Column( name = "other_aftercare_plan_or_action"  )
	public Integer getOtherAftercarePlanOrAction() {
		return this.otherAftercarePlanOrAction;
		
	}
	

  
	 /**  
	 * Set the value related to the column: otherAftercarePlanOrAction.
	 * @param otherAftercarePlanOrAction the otherAftercarePlanOrAction value you wish to set
	 */
	public void setOtherAftercarePlanOrAction(final Integer otherAftercarePlanOrAction) {
		this.otherAftercarePlanOrAction = otherAftercarePlanOrAction;
	}


	 /**
	 * Return the value associated with the column: permenantHousingPlacement.
	 * @return A Integer object (this.permenantHousingPlacement)
	 */
	@Basic( optional = true )
	@Column( name = "permenant_housing_placement"  )
	public Integer getPermenantHousingPlacement() {
		return this.permenantHousingPlacement;
		
	}
  
	 /**  
	 * Set the value related to the column: permenantHousingPlacement.
	 * @param permenantHousingPlacement the permenantHousingPlacement value you wish to set
	 */
	public void setPermenantHousingPlacement(final Integer permenantHousingPlacement) {
		this.permenantHousingPlacement = permenantHousingPlacement;
	}

	 /**
	 * Return the value associated with the column: projectCompletionStatus.
	 * @return A Integer object (this.projectCompletionStatus)
	 */
	@Basic( optional = true )
	@Column( name = "project_completion_status"  )
	public Integer getProjectCompletionStatus() {
		return this.projectCompletionStatus;
		
	}
	

  
	 /**  
	 * Set the value related to the column: projectCompletionStatus.
	 * @param projectCompletionStatus the projectCompletionStatus value you wish to set
	 */
	public void setProjectCompletionStatus(final Integer projectCompletionStatus) {
		this.projectCompletionStatus = projectCompletionStatus;
	}

	 /**
	 * Return the value associated with the column: projectGroupCode.
	 * @return A String object (this.projectGroupCode)
	 */
	@Basic( optional = true )
	@Column( name = "project_group_code", length = 8  )
	public String getProjectGroupCode() {
		return this.projectGroupCode;
		
	}
	

  
	 /**  
	 * Set the value related to the column: projectGroupCode.
	 * @param projectGroupCode the projectGroupCode value you wish to set
	 */
	public void setProjectGroupCode(final String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}

	 /**
	 * Return the value associated with the column: resourcePackage.
	 * @return A Integer object (this.resourcePackage)
	 */
	@Basic( optional = true )
	@Column( name = "resource_package"  )
	public Integer getResourcePackage() {
		return this.resourcePackage;
		
	}
	

  
	 /**  
	 * Set the value related to the column: resourcePackage.
	 * @param resourcePackage the resourcePackage value you wish to set
	 */
	public void setResourcePackage(final Integer resourcePackage) {
		this.resourcePackage = resourcePackage;
	}

	 /**
	 * Return the value associated with the column: scheduledFollowupContacts.
	 * @return A Integer object (this.scheduledFollowupContacts)
	 */
	@Basic( optional = true )
	@Column( name = "scheduled_followup_contacts"  )
	public Integer getScheduledFollowupContacts() {
		return this.scheduledFollowupContacts;
		
	}
	

  
	 /**  
	 * Set the value related to the column: scheduledFollowupContacts.
	 * @param scheduledFollowupContacts the scheduledFollowupContacts value you wish to set
	 */
	public void setScheduledFollowupContacts(final Integer scheduledFollowupContacts) {
		this.scheduledFollowupContacts = scheduledFollowupContacts;
	}


	 /**
	 * Return the value associated with the column: tempShelterPlacement.
	 * @return A Integer object (this.tempShelterPlacement)
	 */
	@Basic( optional = true )
	@Column( name = "temp_shelter_placement"  )
	public Integer getTempShelterPlacement() {
		return this.tempShelterPlacement;
		
	}
	

  
	 /**  
	 * Set the value related to the column: tempShelterPlacement.
	 * @param tempShelterPlacement the tempShelterPlacement value you wish to set
	 */
	public void setTempShelterPlacement(final Integer tempShelterPlacement) {
		this.tempShelterPlacement = tempShelterPlacement;
	}

	 /**
	 * Return the value associated with the column: writtenAfterCarePlan.
	 * @return A Integer object (this.writtenAfterCarePlan)
	 */
	@Basic( optional = true )
	@Column( name = "written_after_care_plan"  )
	public Integer getWrittenAfterCarePlan() {
		return this.writtenAfterCarePlan;
		
	}
	

  
	 /**  
	 * Set the value related to the column: writtenAfterCarePlan.
	 * @param writtenAfterCarePlan the writtenAfterCarePlan value you wish to set
	 */
	public void setWrittenAfterCarePlan(final Integer writtenAfterCarePlan) {
		this.writtenAfterCarePlan = writtenAfterCarePlan;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Exitrhy clone() throws CloneNotSupportedException {
		
        final Exitrhy copy = (Exitrhy)super.clone();

		copy.setAssistanceMainStreamBenefits(this.getAssistanceMainStreamBenefits());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateCreatedFromSource(this.getDateCreatedFromSource());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDateUpdatedFromSource(this.getDateUpdatedFromSource());
		copy.setDeleted(this.isDeleted());
		copy.setEarlyExitReason(this.getEarlyExitReason());
		copy.setExitid(this.getExitid());
		copy.setExitCounseling(this.getExitCounseling());
		copy.setExport(this.getExport());
		copy.setFamilyReunificationAchieved(this.getFamilyReunificationAchieved());
		copy.setFurtherFollowupServices(this.getFurtherFollowupServices());
		copy.setId(this.getId());
		copy.setOtherAftercarePlanOrAction(this.getOtherAftercarePlanOrAction());
		copy.setParentId(this.getParentId());
		copy.setPermenantHousingPlacement(this.getPermenantHousingPlacement());
		copy.setProjectCompletionStatus(this.getProjectCompletionStatus());
		copy.setProjectGroupCode(this.getProjectGroupCode());
		copy.setResourcePackage(this.getResourcePackage());
		copy.setScheduledFollowupContacts(this.getScheduledFollowupContacts());
		copy.setSync(this.isSync());
		copy.setTempShelterPlacement(this.getTempShelterPlacement());
		copy.setUserId(this.getUserId());
		copy.setVersion(this.getVersion());
		copy.setWrittenAfterCarePlan(this.getWrittenAfterCarePlan());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("assistanceMainStreamBenefits: " + this.getAssistanceMainStreamBenefits() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateCreatedFromSource: " + this.getDateCreatedFromSource() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dateUpdatedFromSource: " + this.getDateUpdatedFromSource() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("earlyExitReason: " + this.getEarlyExitReason() + ", ");
		sb.append("exitCounseling: " + this.getExitCounseling() + ", ");
		sb.append("familyReunificationAchieved: " + this.getFamilyReunificationAchieved() + ", ");
		sb.append("furtherFollowupServices: " + this.getFurtherFollowupServices() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("otherAftercarePlanOrAction: " + this.getOtherAftercarePlanOrAction() + ", ");
		sb.append("parentId: " + this.getParentId() + ", ");
		sb.append("permenantHousingPlacement: " + this.getPermenantHousingPlacement() + ", ");
		sb.append("projectCompletionStatus: " + this.getProjectCompletionStatus() + ", ");
		sb.append("projectGroupCode: " + this.getProjectGroupCode() + ", ");
		sb.append("resourcePackage: " + this.getResourcePackage() + ", ");
		sb.append("scheduledFollowupContacts: " + this.getScheduledFollowupContacts() + ", ");
		sb.append("sync: " + this.isSync() + ", ");
		sb.append("tempShelterPlacement: " + this.getTempShelterPlacement() + ", ");
		sb.append("userId: " + this.getUserId() + ", ");
		sb.append("version: " + this.getVersion() + ", ");
		sb.append("writtenAfterCarePlan: " + this.getWrittenAfterCarePlan());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final Exitrhy that; 
		try {
			that = (Exitrhy) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getAssistanceMainStreamBenefits() == null) && (that.getAssistanceMainStreamBenefits() == null)) || (getAssistanceMainStreamBenefits() != null && getAssistanceMainStreamBenefits().equals(that.getAssistanceMainStreamBenefits())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateCreatedFromSource() == null) && (that.getDateCreatedFromSource() == null)) || (getDateCreatedFromSource() != null && getDateCreatedFromSource().equals(that.getDateCreatedFromSource())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDateUpdatedFromSource() == null) && (that.getDateUpdatedFromSource() == null)) || (getDateUpdatedFromSource() != null && getDateUpdatedFromSource().equals(that.getDateUpdatedFromSource())));
		result = result && (((getEarlyExitReason() == null) && (that.getEarlyExitReason() == null)) || (getEarlyExitReason() != null && getEarlyExitReason().equals(that.getEarlyExitReason())));
		result = result && (((getExitid() == null) && (that.getExitid() == null)) || (getExitid() != null && getExitid().getId().equals(that.getExitid().getId())));	
		result = result && (((getExitCounseling() == null) && (that.getExitCounseling() == null)) || (getExitCounseling() != null && getExitCounseling().equals(that.getExitCounseling())));
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().getId().equals(that.getExport().getId())));	
		result = result && (((getFamilyReunificationAchieved() == null) && (that.getFamilyReunificationAchieved() == null)) || (getFamilyReunificationAchieved() != null && getFamilyReunificationAchieved().equals(that.getFamilyReunificationAchieved())));
		result = result && (((getFurtherFollowupServices() == null) && (that.getFurtherFollowupServices() == null)) || (getFurtherFollowupServices() != null && getFurtherFollowupServices().equals(that.getFurtherFollowupServices())));
		result = result && (((getOtherAftercarePlanOrAction() == null) && (that.getOtherAftercarePlanOrAction() == null)) || (getOtherAftercarePlanOrAction() != null && getOtherAftercarePlanOrAction().equals(that.getOtherAftercarePlanOrAction())));
		result = result && (((getParentId() == null) && (that.getParentId() == null)) || (getParentId() != null && getParentId().equals(that.getParentId())));
		result = result && (((getPermenantHousingPlacement() == null) && (that.getPermenantHousingPlacement() == null)) || (getPermenantHousingPlacement() != null && getPermenantHousingPlacement().equals(that.getPermenantHousingPlacement())));
		result = result && (((getProjectCompletionStatus() == null) && (that.getProjectCompletionStatus() == null)) || (getProjectCompletionStatus() != null && getProjectCompletionStatus().equals(that.getProjectCompletionStatus())));
		result = result && (((getProjectGroupCode() == null) && (that.getProjectGroupCode() == null)) || (getProjectGroupCode() != null && getProjectGroupCode().equals(that.getProjectGroupCode())));
		result = result && (((getResourcePackage() == null) && (that.getResourcePackage() == null)) || (getResourcePackage() != null && getResourcePackage().equals(that.getResourcePackage())));
		result = result && (((getScheduledFollowupContacts() == null) && (that.getScheduledFollowupContacts() == null)) || (getScheduledFollowupContacts() != null && getScheduledFollowupContacts().equals(that.getScheduledFollowupContacts())));
		result = result && (((getTempShelterPlacement() == null) && (that.getTempShelterPlacement() == null)) || (getTempShelterPlacement() != null && getTempShelterPlacement().equals(that.getTempShelterPlacement())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVersion() == null) && (that.getVersion() == null)) || (getVersion() != null && getVersion().equals(that.getVersion())));
		result = result && (((getWrittenAfterCarePlan() == null) && (that.getWrittenAfterCarePlan() == null)) || (getWrittenAfterCarePlan() != null && getWrittenAfterCarePlan().equals(that.getWrittenAfterCarePlan())));
		return result;
	}
}
