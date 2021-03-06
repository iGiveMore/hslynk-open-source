package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="CLIENT_CONSENT_REQUEST_ENTITIES",schema="base",catalog="hmis")
public class ClientConsentRequestEntitiesEntity extends BaseModel {
	
	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "ID")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "client_consent_request_id")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private ClientConsentRequestEntity clientConsentRequestEntity;
	
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "consent_type_id")
	private UUID consentTypeId;
	
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "consent_entity_id")
	private UUID consentEntityId;
	
	@Column(name="deleted")
	private boolean deleted;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}	
	public ClientConsentRequestEntity getClientConsentRequestEntity() {
		return clientConsentRequestEntity;
	}
	public void setClientConsentRequestEntity(ClientConsentRequestEntity clientConsentRequestEntity) {
		this.clientConsentRequestEntity = clientConsentRequestEntity;
	}
	public UUID getConsentTypeId() {
		return consentTypeId;
	}
	public void setConsentTypeId(UUID consentTypeId) {
		this.consentTypeId = consentTypeId;
	}
	public UUID getConsentEntityId() {
		return consentEntityId;
	}
	public void setConsentEntityId(UUID consentEntityId) {
		this.consentEntityId = consentEntityId;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}