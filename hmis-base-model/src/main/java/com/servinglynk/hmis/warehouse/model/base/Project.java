package com.servinglynk.hmis.warehouse.model.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;


/** 
 * Object mapping for hibernate-handled table: project.
 * 
 *
 * @author autogenerated
 */
@Entity
@Table(name = "project", catalog = "hmis", schema = "base")
public class Project extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -7029415480218844556L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	
	/** Field mapping. */
	private ProjectContinuumprojectEnum continuumproject;
		/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private OrganizationEntity organizationid;
	/** Field mapping. */
	private String projectcommonname;
	/** Field mapping. */
	private String projectname;
	/** Field mapping. */
	private ProjectProjecttypeEnum projecttype;
	/** Field mapping. */
	private ProjectTargetpopulationEnum targetpopulation;
	/** Field mapping. */
	private ProjectTrackingmethodEnum trackingmethod;
	private Integer schemaYear;
	
	/** Field mapping. */
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Project() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Project(java.util.UUID id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Project.class;
	}
 	/**
	 * Return the value associated with the column: continuumproject.
	 * @return A ProjectContinuumprojectEnum object (this.continuumproject)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnumType")
	@Basic( optional = true )
	@Column
	public ProjectContinuumprojectEnum getContinuumproject() {
		return this.continuumproject;

	}
	

  
	 /**  
	 * Set the value related to the column: continuumproject.
	 * @param continuumproject the continuumproject value you wish to set
	 */
	public void setContinuumproject(final ProjectContinuumprojectEnum continuumproject) {
		this.continuumproject = continuumproject;
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
	 * Return the value associated with the column: organizationid.
	 * @return A Organization object (this.organizationid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "organizationid", nullable = true )
	public OrganizationEntity getOrganizationid() {
		return this.organizationid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: organizationid.
	 * @param organizationid the organizationid value you wish to set
	 */
	public void setOrganizationid(final OrganizationEntity organizationid) {
		this.organizationid = organizationid;
	}

	 /**
	 * Return the value associated with the column: projectcommonname.
	 * @return A String object (this.projectcommonname)
	 */
	@Basic( optional = true )
	@Column
	public String getProjectcommonname() {
		return this.projectcommonname;
		
	}
	

  
	 /**  
	 * Set the value related to the column: projectcommonname.
	 * @param projectcommonname the projectcommonname value you wish to set
	 */
	public void setProjectcommonname(final String projectcommonname) {
		this.projectcommonname = projectcommonname;
	}

	 /**
	 * Return the value associated with the column: projectname.
	 * @return A String object (this.projectname)
	 */
	@Basic( optional = true )
	@Column
	public String getProjectname() {
		return this.projectname;
		
	}
	

  
	 /**  
	 * Set the value related to the column: projectname.
	 * @param projectname the projectname value you wish to set
	 */
	public void setProjectname(final String projectname) {
		this.projectname = projectname;
	}

		/**
		 * Return the value associated with the column: projecttype.
		 * @return A ProjectProjecttypeEnum object (this.projecttype)
		 */
		@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnumType")
		@Basic( optional = true )
		@Column
		public ProjectProjecttypeEnum getProjecttype() {
			return this.projecttype;

		}
	

  
	 /**  
	 * Set the value related to the column: projecttype.
	 * @param projecttype the projecttype value you wish to set
	 */
	public void setProjecttype(final ProjectProjecttypeEnum projecttype) {
		this.projecttype = projecttype;
	}

	/**
	 * Return the value associated with the column: targetpopulation.
	 * @return A ProjectTargetpopulationEnum object (this.targetpopulation)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnumType")
	@Basic( optional = true )
	@Column
	public ProjectTargetpopulationEnum getTargetpopulation() {
		return this.targetpopulation;

	}
	

  
	 /**  
	 * Set the value related to the column: targetpopulation.
	 * @param targetpopulation the targetpopulation value you wish to set
	 */
	public void setTargetpopulation(final ProjectTargetpopulationEnum targetpopulation) {
		this.targetpopulation = targetpopulation;
	}

	/**
	 * Return the value associated with the column: trackingmethod.
	 * @return A ProjectTrackingmethodEnum object (this.trackingmethod)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnumType")
	@Basic( optional = true )
	@Column
	public ProjectTrackingmethodEnum getTrackingmethod() {
		return this.trackingmethod;

	}
	

  
	 /**  
	 * Set the value related to the column: trackingmethod.
	 * @param trackingmethod the trackingmethod value you wish to set
	 */
	public void setTrackingmethod(final ProjectTrackingmethodEnum trackingmethod) {
		this.trackingmethod = trackingmethod;
	}
	
	
	@Column(name="schema_year")
    public Integer getSchemaYear() {
		return schemaYear;
	}

	public void setSchemaYear(Integer schemaYear) {
		this.schemaYear = schemaYear;
	}

	@Override
    public Project clone() throws CloneNotSupportedException {
		
        final Project copy = (Project)super.clone();

		copy.setContinuumproject(this.getContinuumproject());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDeleted(this.isDeleted());
		copy.setId(this.getId());
		copy.setOrganizationid(this.getOrganizationid());
		copy.setParentId(this.getParentId());
		copy.setProjectcommonname(this.getProjectcommonname());
		copy.setProjectname(this.getProjectname());
		copy.setProjecttype(this.getProjecttype());
		copy.setSync(this.isSync());
		copy.setTargetpopulation(this.getTargetpopulation());
		copy.setTrackingmethod(this.getTrackingmethod());
		copy.setUser(this.getUser());
		copy.setVersion(this.getVersion());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("continuumproject: " + this.getContinuumproject() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("parentId: " + this.getParentId() + ", ");
		sb.append("projectcommonname: " + this.getProjectcommonname() + ", ");
		sb.append("projectname: " + this.getProjectname() + ", ");
		sb.append("projecttype: " + this.getProjecttype() + ", ");
		sb.append("sync: " + this.isSync() + ", ");
		sb.append("targetpopulation: " + this.getTargetpopulation() + ", ");
		sb.append("trackingmethod: " + this.getTrackingmethod() + ", ");
		sb.append("user: " + this.getUser() + ", ");
		sb.append("version: " + this.getVersion());
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
		
		final Project that; 
		try {
			that = (Project) proxyThat;
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
		result = result && (((getContinuumproject() == null) && (that.getContinuumproject() == null)) || (getContinuumproject() != null && getContinuumproject().equals(that.getContinuumproject())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getOrganizationid() == null) && (that.getOrganizationid() == null)) || (getOrganizationid() != null && getOrganizationid().getId().equals(that.getOrganizationid().getId())));	
		result = result && (((getParentId() == null) && (that.getParentId() == null)) || (getParentId() != null && getParentId().equals(that.getParentId())));
		result = result && (((getProjectcommonname() == null) && (that.getProjectcommonname() == null)) || (getProjectcommonname() != null && getProjectcommonname().equals(that.getProjectcommonname())));
		result = result && (((getProjectname() == null) && (that.getProjectname() == null)) || (getProjectname() != null && getProjectname().equals(that.getProjectname())));
		result = result && (((getProjecttype() == null) && (that.getProjecttype() == null)) || (getProjecttype() != null && getProjecttype().equals(that.getProjecttype())));
		result = result && (((getTargetpopulation() == null) && (that.getTargetpopulation() == null)) || (getTargetpopulation() != null && getTargetpopulation().equals(that.getTargetpopulation())));
		result = result && (((getTrackingmethod() == null) && (that.getTrackingmethod() == null)) || (getTrackingmethod() != null && getTrackingmethod().equals(that.getTrackingmethod())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));
		result = result && (((getVersion() == null) && (that.getVersion() == null)) || (getVersion() != null && getVersion().equals(that.getVersion())));
		return result;
	}
}