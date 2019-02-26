package com.servinglynk.hmis.warehouse.model.v2014;

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

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;


/**
 * Object mapping for hibernate-handled table: projectcompletionstatus.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "projectcompletionstatus")
@Table(name = "projectcompletionstatus", catalog = "hmis", schema = "v2014")
public class Projectcompletionstatus extends HmisBaseModel  implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = 8910163621967561003L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private ProjectcompletionstatusEarlyexitreasonEnum earlyexitreason;
	/** Field mapping. */
	private Exit exitid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private ProjectcompletionstatusProjectcompletionstatusEnum projectcompletionstatus;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Projectcompletionstatus() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Projectcompletionstatus(java.util.UUID id) {
		this.id = id;
	}




	/** Field mapping. */
	private Export export;
	 /**
	 * Return the value associated with the column: export.
	 * @return A Export object (this.export)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "export_id", nullable = true )
	public Export getExport() {
		return this.export;

	}



	 /**
	 * Set the value related to the column: export.
	 * @param export the export value you wish to set
	 */
	public void setExport(final Export export) {
		this.export = export;
	}



	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Projectcompletionstatus.class;
	}


	 /**
	 * Return the value associated with the column: earlyexitreason.
	 * @return A ProjectcompletionstatusEarlyexitreasonEnum object (this.earlyexitreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnumType")
	@Basic( optional = true )
	@Column
	public ProjectcompletionstatusEarlyexitreasonEnum getEarlyexitreason() {
		return this.earlyexitreason;

	}



	 /**
	 * Set the value related to the column: earlyexitreason.
	 * @param earlyexitreason the earlyexitreason value you wish to set
	 */
	public void setEarlyexitreason(final ProjectcompletionstatusEarlyexitreasonEnum earlyexitreason) {
		this.earlyexitreason = earlyexitreason;
	}

	 /**
	 * Return the value associated with the column: exitid.
	 * @return A Exit object (this.exitid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "exitid", nullable = true )
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
	 * Return the value associated with the column: projectcompletionstatus.
	 * @return A ProjectcompletionstatusProjectcompletionstatusEnum object (this.projectcompletionstatus)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnumType")
	@Basic( optional = true )
	@Column
	public ProjectcompletionstatusProjectcompletionstatusEnum getProjectcompletionstatus() {
		return this.projectcompletionstatus;

	}



	 /**
	 * Set the value related to the column: projectcompletionstatus.
	 * @param projectcompletionstatus the projectcompletionstatus value you wish to set
	 */
	public void setProjectcompletionstatus(final ProjectcompletionstatusProjectcompletionstatusEnum projectcompletionstatus) {
		this.projectcompletionstatus = projectcompletionstatus;
	}



   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Projectcompletionstatus clone() throws CloneNotSupportedException {

        final Projectcompletionstatus copy = (Projectcompletionstatus)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEarlyexitreason(this.getEarlyexitreason());
		copy.setExitid(this.getExitid());
		copy.setId(this.getId());
		copy.setProjectcompletionstatus(this.getProjectcompletionstatus());
		copy.setUserId(this.getUserId());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("earlyexitreason: " + this.getEarlyexitreason() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("projectcompletionstatus: " + this.getProjectcompletionstatus() + ", ");
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

		final Projectcompletionstatus that;
		try {
			that = (Projectcompletionstatus) proxyThat;
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
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEarlyexitreason() == null) && (that.getEarlyexitreason() == null)) || (getEarlyexitreason() != null && getEarlyexitreason().equals(that.getEarlyexitreason())));
		result = result && (((getExitid() == null) && (that.getExitid() == null)) || (getExitid() != null && getExitid().getId().equals(that.getExitid().getId())));
		result = result && (((getProjectcompletionstatus() == null) && (that.getProjectcompletionstatus() == null)) || (getProjectcompletionstatus() != null && getProjectcompletionstatus().equals(that.getProjectcompletionstatus())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		return result;
	}


}
