package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.servinglynk.hmis.warehouse.model.base.HMISModel;

/**
 * A GlobalHousehold.
 */
@Entity
@Table(name = "hmis_household", schema = "v2017")
public class HmisHousehold extends HMISModel implements Serializable {

	private static final long serialVersionUID = 1573515448747014869L;

	private UUID id;
	private Client headOfHousehold;
	private UUID dedupClientId;
	private List<HmisHouseHoldMember> members = new ArrayList<HmisHouseHoldMember>();
	private String sourceSystemHouseHoldId;
	private String sourceSystemId;
	
	
	@Id
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	@Column(name = "id")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "head_of_household_id", referencedColumnName = "id")
	public Client getHeadOfHousehold() {
		return headOfHousehold;
	}

	public void setHeadOfHousehold(Client headOfHousehold) {
		this.headOfHousehold = headOfHousehold;
	}

	@Column(name = "dedup_client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	public UUID getDedupClientId() {
		return dedupClientId;
	}

	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}

	@OneToMany(mappedBy = "hmisHousehold")
	public List<HmisHouseHoldMember> getMembers() {
		return members;
	}

	public void setMembers(List<HmisHouseHoldMember> members) {
		this.members = members;
	}
	
	@Column(name = "source_system_house_hold_id")
	public String getSourceSystemHouseHoldId() {
		return sourceSystemHouseHoldId;
	}

	public void setSourceSystemHouseHoldId(String sourceSystemHouseHoldId) {
		this.sourceSystemHouseHoldId = sourceSystemHouseHoldId;
	}

	@Column(name = "source_system_id")
	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
}