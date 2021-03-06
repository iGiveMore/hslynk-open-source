package com.servinglynk.hmis.warehouse.model.v2014;

import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: housingassessmentdisposition.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "housingassessmentdisposition")
@Table(name = "housingassessmentdisposition", catalog = "hmis", schema = "v2014")
public class Housingassessmentdisposition extends HmisBaseModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 8906820996032660100L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private HousingassessmentdispositionAssessmentdispositionEnum assessmentdisposition;
	/** Field mapping. */
	private Exit exitid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String otherdisposition;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Housingassessmentdisposition() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Housingassessmentdisposition(java.util.UUID id) {
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
		return Housingassessmentdisposition.class;
	}


	 /**
	 * Return the value associated with the column: assessmentdisposition.
	 * @return A HousingassessmentdispositionAssessmentdispositionEnum object (this.assessmentdisposition)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnumType")
	@Basic( optional = true )
	@Column
	public HousingassessmentdispositionAssessmentdispositionEnum getAssessmentdisposition() {
		return this.assessmentdisposition;

	}



	 /**
	 * Set the value related to the column: assessmentdisposition.
	 * @param assessmentdisposition the assessmentdisposition value you wish to set
	 */
	public void setAssessmentdisposition(final HousingassessmentdispositionAssessmentdispositionEnum assessmentdisposition) {
		this.assessmentdisposition = assessmentdisposition;
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
	 * Return the value associated with the column: otherdisposition.
	 * @return A String object (this.otherdisposition)
	 */
	@Basic( optional = true )
	@Column
	public String getOtherdisposition() {
		return this.otherdisposition;

	}



	 /**
	 * Set the value related to the column: otherdisposition.
	 * @param otherdisposition the otherdisposition value you wish to set
	 */
	public void setOtherdisposition(final String otherdisposition) {
		this.otherdisposition = otherdisposition;
	}



   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Housingassessmentdisposition clone() throws CloneNotSupportedException {

        final Housingassessmentdisposition copy = (Housingassessmentdisposition)super.clone();

		copy.setAssessmentdisposition(this.getAssessmentdisposition());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setExitid(this.getExitid());
		copy.setId(this.getId());
		copy.setOtherdisposition(this.getOtherdisposition());
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

		sb.append("assessmentdisposition: " + this.getAssessmentdisposition() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("otherdisposition: " + this.getOtherdisposition() + ", ");
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

		final Housingassessmentdisposition that;
		try {
			that = (Housingassessmentdisposition) proxyThat;
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
		result = result && (((getAssessmentdisposition() == null) && (that.getAssessmentdisposition() == null)) || (getAssessmentdisposition() != null && getAssessmentdisposition().equals(that.getAssessmentdisposition())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getExitid() == null) && (that.getExitid() == null)) || (getExitid() != null && getExitid().getId().equals(that.getExitid().getId())));
		result = result && (((getOtherdisposition() == null) && (that.getOtherdisposition() == null)) || (getOtherdisposition() != null && getOtherdisposition().equals(that.getOtherdisposition())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		return result;
	}
}
