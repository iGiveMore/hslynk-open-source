package com.servinglynk.hmis.warehouse.model.v2015;

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

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: bulk_upload.
 * 
 *
 * @author autogenerated
 */
		

@Entity
@Table(name = "bulk_upload", catalog = "hmis", schema = "v2015")
public class BulkUpload extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 5515655458223886905L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Export export;
	/** Field mapping. */
	private Long id;
	/** Field mapping. */
	private String inputpath;
	/** Field mapping. */
	private LocalDateTime insertAt;
	/** Field mapping. */
	private String insertBy;
	/** Field mapping. */
	private String status;
	/** Field mapping. */
	private LocalDateTime updateAt;
	/** Field mapping. */
	private String updateBy;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public BulkUpload() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public BulkUpload(Long id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return BulkUpload.class;
	}
 

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

	 /**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@Basic( optional = false )
	@Column( name = "id", nullable = false  )
	public Long getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0L) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: inputpath.
	 * @return A String object (this.inputpath)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getInputPath() {
		return this.inputpath;
		
	}
	

  
	 /**  
	 * Set the value related to the column: inputpath.
	 * @param inputpath the inputpath value you wish to set
	 */
	public void setInputPath(final String inputpath) {
		this.inputpath = inputpath;
	}

	 /**
	 * Return the value associated with the column: insertAt.
	 * @return A LocalDateTime object (this.insertAt)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "insert_at"  )
	public LocalDateTime getInsertAt() {
		return this.insertAt;
		
	}
	

  
	 /**  
	 * Set the value related to the column: insertAt.
	 * @param insertAt the insertAt value you wish to set
	 */
	public void setInsertAt(final LocalDateTime insertAt) {
		this.insertAt = insertAt;
	}

	 /**
	 * Return the value associated with the column: insertBy.
	 * @return A String object (this.insertBy)
	 */
	@Basic( optional = true )
	@Column( name = "insert_by", length = 100  )
	public String getInsertBy() {
		return this.insertBy;
		
	}
	

  
	 /**  
	 * Set the value related to the column: insertBy.
	 * @param insertBy the insertBy value you wish to set
	 */
	public void setInsertBy(final String insertBy) {
		this.insertBy = insertBy;
	}

	 /**
	 * Return the value associated with the column: status.
	 * @return A String object (this.status)
	 */
	@Basic( optional = true )
	@Column( length = 10  )
	public String getStatus() {
		return this.status;
		
	}
	

  
	 /**  
	 * Set the value related to the column: status.
	 * @param status the status value you wish to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	 /**
	 * Return the value associated with the column: updateAt.
	 * @return A LocalDateTime object (this.updateAt)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "update_at"  )
	public LocalDateTime getUpdateAt() {
		return this.updateAt;
		
	}
	

  
	 /**  
	 * Set the value related to the column: updateAt.
	 * @param updateAt the updateAt value you wish to set
	 */
	public void setUpdateAt(final LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	 /**
	 * Return the value associated with the column: updateBy.
	 * @return A String object (this.updateBy)
	 */
	@Basic( optional = true )
	@Column( name = "update_by", length = 100  )
	public String getUpdateBy() {
		return this.updateBy;
		
	}
	

  
	 /**  
	 * Set the value related to the column: updateBy.
	 * @param updateBy the updateBy value you wish to set
	 */
	public void setUpdateBy(final String updateBy) {
		this.updateBy = updateBy;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public BulkUpload clone() throws CloneNotSupportedException {
		
        final BulkUpload copy = (BulkUpload)super.clone();

		copy.setExport(this.getExport());
		copy.setId(this.getId());
		copy.setInputPath(this.getInputPath());
		copy.setInsertAt(this.getInsertAt());
		copy.setInsertBy(this.getInsertBy());
		copy.setStatus(this.getStatus());
		copy.setUpdateAt(this.getUpdateAt());
		copy.setUpdateBy(this.getUpdateBy());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("inputpath: " + this.getInputPath() + ", ");
		sb.append("insertAt: " + this.getInsertAt() + ", ");
		sb.append("insertBy: " + this.getInsertBy() + ", ");
		sb.append("status: " + this.getStatus() + ", ");
		sb.append("updateAt: " + this.getUpdateAt() + ", ");
		sb.append("updateBy: " + this.getUpdateBy());
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
		
		final BulkUpload that; 
		try {
			that = (BulkUpload) proxyThat;
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
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().getId().equals(that.getExport().getId())));	
		result = result && (((getInputPath() == null) && (that.getInputPath() == null)) || (getInputPath() != null && getInputPath().equals(that.getInputPath())));
		result = result && (((getInsertAt() == null) && (that.getInsertAt() == null)) || (getInsertAt() != null && getInsertAt().equals(that.getInsertAt())));
		result = result && (((getInsertBy() == null) && (that.getInsertBy() == null)) || (getInsertBy() != null && getInsertBy().equals(that.getInsertBy())));
		result = result && (((getStatus() == null) && (that.getStatus() == null)) || (getStatus() != null && getStatus().equals(that.getStatus())));
		result = result && (((getUpdateAt() == null) && (that.getUpdateAt() == null)) || (getUpdateAt() != null && getUpdateAt().equals(that.getUpdateAt())));
		result = result && (((getUpdateBy() == null) && (that.getUpdateBy() == null)) || (getUpdateBy() != null && getUpdateBy().equals(that.getUpdateBy())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Long newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0L) {
							newHashCode = getId();
						} else {
							newHashCode = (long) super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
		return (int) (this.hashCode & 0xffffff);
	}
	

	
}
