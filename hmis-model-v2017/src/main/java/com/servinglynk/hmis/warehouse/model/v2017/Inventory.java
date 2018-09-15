package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;


/**
 * Object mapping for hibernate-handled table: inventory.
 *
 *
 * @author autogenerated
 */
@Entity(name = "inventory_v2017")
@Table(name = "inventory", catalog = "hmis", schema = "v2017")
public class Inventory extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 5575541932820010068L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private InventoryAvailabiltyEnum availabilty;
	/** Field mapping. */
	private InventoryBedtypeEnum bedtype;
	/** Field mapping. */
	private Integer chBedInventory;
	/** Field mapping. */
	private Integer bedInventory;
	/** Field mapping. */
	private Coc coc;
	/** Field mapping. */
	private Project projectid;
	/** Field mapping. */
	private Integer hmisparticipatingbeds;
	/** Field mapping. */
	private InventoryHouseholdtypeEnum householdtype;
	/** Field mapping. */
	private java.util.UUID id;
	private String cocCode;
	/** Field mapping. */
	private LocalDateTime informationdate;
	/** Field mapping. */
	private LocalDateTime inventoryenddate;
	/** Field mapping. */
	private LocalDateTime inventorystartdate;
	/** Field mapping. */
	private Integer unitinventory;
	/** Field mapping. */
	private Integer vetBedInventory;
	/** Field mapping. */
	private Integer youthBedInventory;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Inventory() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Inventory(java.util.UUID id) {
		this.id = id;
	}





	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Inventory.class;
	}


	 	/**
		 * Return the value associated with the column: availabilty.
		 * @return A InventoryAvailabiltyEnum object (this.availabilty)
		 */
		@Type(type = "com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnumType")
		@Basic( optional = true )
		@Column
		public InventoryAvailabiltyEnum getAvailabilty() {
			return this.availabilty;

		}



	 /**
	 * Set the value related to the column: availabilty.
	 * @param availabilty the availabilty value you wish to set
	 */
	public void setAvailabilty(final InventoryAvailabiltyEnum availabilty) {
		this.availabilty = availabilty;
	}



	/**
	 * Return the value associated with the column: bedtype.
	 * @return A InventoryBedtypeEnum object (this.bedtype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnumType")
	@Basic( optional = true )
	@Column
	public InventoryBedtypeEnum getBedtype() {
		return this.bedtype;

	}



	 /**
	 * Set the value related to the column: bedtype.
	 * @param bedtype the bedtype value you wish to set
	 */
	public void setBedtype(final InventoryBedtypeEnum bedtype) {
		this.bedtype = bedtype;
	}

	 /**
	 * Return the value associated with the column: chBedInventory.
	 * @return A Integer object (this.chBedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "ch_bed_inventory"  )
	public Integer getChBedInventory() {
		return this.chBedInventory;

	}



	 /**
	 * Set the value related to the column: chBedInventory.
	 * @param chBedInventory the chBedInventory value you wish to set
	 */
	public void setChBedInventory(final Integer chBedInventory) {
		this.chBedInventory = chBedInventory;
	}
	
	 /**
	 * Return the value associated with the column: chBedInventory.
	 * @return A Integer object (this.chBedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "bed_inventory"  )
	public Integer getBedInventory() {
		return this.bedInventory;

	}



	 /**
	 * Set the value related to the column: chBedInventory.
	 * @param chBedInventory the chBedInventory value you wish to set
	 */
	public void setBedInventory(final Integer bedInventory) {
		this.bedInventory = bedInventory;
	}

	 /**
	 * Return the value associated with the column: coc.
	 * @return A Coc object (this.coc)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "coc_id", nullable = true )
	public Coc getCoc() {
		return this.coc;

	}



	 /**
	 * Set the value related to the column: coc.
	 * @param coc the coc value you wish to set
	 */
	public void setCoc(final Coc coc) {
		this.coc = coc;
	}

	 /**
	 * Return the value associated with the column: projectid.
	 * @return A Project object (this.projectid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "projectid", nullable = true )
	public Project getProjectid() {
		return this.projectid;

	}



	 /**
	 * Set the value related to the column: projectid.
	 * @param projectid the projectid value you wish to set
	 */
	public void setProjectid(final Project projectid) {
		this.projectid = projectid;
	}



	 /**
	 * Return the value associated with the column: hmisparticipatingbeds.
	 * @return A Integer object (this.hmisparticipatingbeds)
	 */
	public Integer getHmisparticipatingbeds() {
		return this.hmisparticipatingbeds;

	}



	 /**
	 * Set the value related to the column: hmisparticipatingbeds.
	 * @param hmisparticipatingbeds the hmisparticipatingbeds value you wish to set
	 */
	public void setHmisparticipatingbeds(final Integer hmisparticipatingbeds) {
		this.hmisparticipatingbeds = hmisparticipatingbeds;
	}

	/**
	 * Return the value associated with the column: householdtype.
	 * @return A InventoryHouseholdtypeEnum object (this.householdtype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnumType")
	@Basic( optional = true )
	@Column
	public InventoryHouseholdtypeEnum getHouseholdtype() {
		return this.householdtype;

	}



	 /**
	 * Set the value related to the column: householdtype.
	 * @param householdtype the householdtype value you wish to set
	 */
	public void setHouseholdtype(final InventoryHouseholdtypeEnum householdtype) {
		this.householdtype = householdtype;
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
	 * Return the value associated with the column: informationdate.
	 * @return A LocalDateTime object (this.informationdate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getInformationdate() {
		return this.informationdate;

	}



	 /**
	 * Set the value related to the column: informationdate.
	 * @param informationdate the informationdate value you wish to set
	 */
	public void setInformationdate(final LocalDateTime informationdate) {
		this.informationdate = informationdate;
	}

	 /**
	 * Return the value associated with the column: inventoryenddate.
	 * @return A LocalDateTime object (this.inventoryenddate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getInventoryenddate() {
		return this.inventoryenddate;

	}



	 /**
	 * Set the value related to the column: inventoryenddate.
	 * @param inventoryenddate the inventoryenddate value you wish to set
	 */
	public void setInventoryenddate(final LocalDateTime inventoryenddate) {
		this.inventoryenddate = inventoryenddate;
	}

	 /**
	 * Return the value associated with the column: inventorystartdate.
	 * @return A LocalDateTime object (this.inventorystartdate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getInventorystartdate() {
		return this.inventorystartdate;

	}



	 /**
	 * Set the value related to the column: inventorystartdate.
	 * @param inventorystartdate the inventorystartdate value you wish to set
	 */
	public void setInventorystartdate(final LocalDateTime inventorystartdate) {
		this.inventorystartdate = inventorystartdate;
	}

	 /**
	 * Return the value associated with the column: unitinventory.
	 * @return A Integer object (this.unitinventory)
	 */
	public Integer getUnitinventory() {
		return this.unitinventory;

	}



	 /**
	 * Set the value related to the column: unitinventory.
	 * @param unitinventory the unitinventory value you wish to set
	 */
	public void setUnitinventory(final Integer unitinventory) {
		this.unitinventory = unitinventory;
	}


	 /**
	 * Return the value associated with the column: vetBedInventory.
	 * @return A Integer object (this.vetBedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "vet_bed_inventory"  )
	public Integer getVetBedInventory() {
		return this.vetBedInventory;

	}



	 /**
	 * Set the value related to the column: vetBedInventory.
	 * @param vetBedInventory the vetBedInventory value you wish to set
	 */
	public void setVetBedInventory(final Integer vetBedInventory) {
		this.vetBedInventory = vetBedInventory;
	}


	 /**
	 * Return the value associated with the column: youthBedInventory.
	 * @return A Integer object (this.youthBedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "youth_bed_inventory"  )
	public Integer getYouthBedInventory() {
		return this.youthBedInventory;

	}



	 /**
	 * Set the value related to the column: youthBedInventory.
	 * @param youthBedInventory the youthBedInventory value you wish to set
	 */
	public void setYouthBedInventory(final Integer youthBedInventory) {
		this.youthBedInventory = youthBedInventory;
	}
	/** Field mapping. */
	protected Export export;
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Inventory clone() throws CloneNotSupportedException {

        final Inventory copy = (Inventory)super.clone();

		copy.setAvailabilty(this.getAvailabilty());
		copy.setBedtype(this.getBedtype());
		copy.setChBedInventory(this.getChBedInventory());
		copy.setCoc(this.getCoc());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateCreatedFromSource(this.getDateCreatedFromSource());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDateUpdatedFromSource(this.getDateUpdatedFromSource());
		copy.setDeleted(this.isDeleted());
		copy.setExport(this.getExport());
		copy.setHmisparticipatingbeds(this.getHmisparticipatingbeds());
		copy.setHouseholdtype(this.getHouseholdtype());
		copy.setId(this.getId());
		copy.setInformationdate(this.getInformationdate());
		copy.setInventoryenddate(this.getInventoryenddate());
		copy.setInventorystartdate(this.getInventorystartdate());
		copy.setParentId(this.getParentId());
		copy.setProjectGroupCode(this.getProjectGroupCode());
		copy.setSync(this.isSync());
		copy.setUnitinventory(this.getUnitinventory());
		copy.setUserId(this.getUserId());
		copy.setVersion(this.getVersion());
		copy.setVetBedInventory(this.getVetBedInventory());
		copy.setYouthBedInventory(this.getYouthBedInventory());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("availabilty: " + this.getAvailabilty() + ", ");
		sb.append("bedtype: " + this.getBedtype() + ", ");
		sb.append("chBedInventory: " + this.getChBedInventory() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateCreatedFromSource: " + this.getDateCreatedFromSource() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dateUpdatedFromSource: " + this.getDateUpdatedFromSource() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("hmisparticipatingbeds: " + this.getHmisparticipatingbeds() + ", ");
		sb.append("householdtype: " + this.getHouseholdtype() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("informationdate: " + this.getInformationdate() + ", ");
		sb.append("inventoryenddate: " + this.getInventoryenddate() + ", ");
		sb.append("inventorystartdate: " + this.getInventorystartdate() + ", ");
		sb.append("parentId: " + this.getParentId() + ", ");
		sb.append("projectGroupCode: " + this.getProjectGroupCode() + ", ");
		sb.append("sync: " + this.isSync() + ", ");
		sb.append("unitinventory: " + this.getUnitinventory() + ", ");
		sb.append("userId: " + this.getUserId() + ", ");
		sb.append("version: " + this.getVersion() + ", ");
		sb.append("vetBedInventory: " + this.getVetBedInventory() + ", ");
		sb.append("youthBedInventory: " + this.getYouthBedInventory());
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

		final Inventory that;
		try {
			that = (Inventory) proxyThat;
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
		result = result && (((getAvailabilty() == null) && (that.getAvailabilty() == null)) || (getAvailabilty() != null && getAvailabilty().equals(that.getAvailabilty())));
		result = result && (((getBedtype() == null) && (that.getBedtype() == null)) || (getBedtype() != null && getBedtype().equals(that.getBedtype())));
		result = result && (((getChBedInventory() == null) && (that.getChBedInventory() == null)) || (getChBedInventory() != null && getChBedInventory().equals(that.getChBedInventory())));
		result = result && (((getCoc() == null) && (that.getCoc() == null)) || (getCoc() != null && getCoc().getId().equals(that.getCoc().getId())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateCreatedFromSource() == null) && (that.getDateCreatedFromSource() == null)) || (getDateCreatedFromSource() != null && getDateCreatedFromSource().equals(that.getDateCreatedFromSource())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDateUpdatedFromSource() == null) && (that.getDateUpdatedFromSource() == null)) || (getDateUpdatedFromSource() != null && getDateUpdatedFromSource().equals(that.getDateUpdatedFromSource())));
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().getId().equals(that.getExport().getId())));
		result = result && (((getHmisparticipatingbeds() == null) && (that.getHmisparticipatingbeds() == null)) || (getHmisparticipatingbeds() != null && getHmisparticipatingbeds().equals(that.getHmisparticipatingbeds())));
		result = result && (((getHouseholdtype() == null) && (that.getHouseholdtype() == null)) || (getHouseholdtype() != null && getHouseholdtype().equals(that.getHouseholdtype())));
		result = result && (((getInformationdate() == null) && (that.getInformationdate() == null)) || (getInformationdate() != null && getInformationdate().equals(that.getInformationdate())));
		result = result && (((getInventoryenddate() == null) && (that.getInventoryenddate() == null)) || (getInventoryenddate() != null && getInventoryenddate().equals(that.getInventoryenddate())));
		result = result && (((getInventorystartdate() == null) && (that.getInventorystartdate() == null)) || (getInventorystartdate() != null && getInventorystartdate().equals(that.getInventorystartdate())));
		result = result && (((getParentId() == null) && (that.getParentId() == null)) || (getParentId() != null && getParentId().equals(that.getParentId())));
		result = result && (((getProjectGroupCode() == null) && (that.getProjectGroupCode() == null)) || (getProjectGroupCode() != null && getProjectGroupCode().equals(that.getProjectGroupCode())));
		result = result && (((getUnitinventory() == null) && (that.getUnitinventory() == null)) || (getUnitinventory() != null && getUnitinventory().equals(that.getUnitinventory())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVersion() == null) && (that.getVersion() == null)) || (getVersion() != null && getVersion().equals(that.getVersion())));
		result = result && (((getVetBedInventory() == null) && (that.getVetBedInventory() == null)) || (getVetBedInventory() != null && getVetBedInventory().equals(that.getVetBedInventory())));
		result = result && (((getYouthBedInventory() == null) && (that.getYouthBedInventory() == null)) || (getYouthBedInventory() != null && getYouthBedInventory().equals(that.getYouthBedInventory())));
		return result;
	}
}
