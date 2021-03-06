package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_redirect_uri",schema="base")
public class RedirectUriEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "uri", nullable=false)
	private String uri;

	@ManyToOne
	@JoinColumn(name = "trustedApp_id", nullable=false, referencedColumnName="id")
	private TrustedAppEntity trustedApp;


	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public TrustedAppEntity getTrustedApp() {
		return trustedApp;
	}
	public void setTrustedApp(TrustedAppEntity trustedApp) {
		this.trustedApp = trustedApp;
	}

}
