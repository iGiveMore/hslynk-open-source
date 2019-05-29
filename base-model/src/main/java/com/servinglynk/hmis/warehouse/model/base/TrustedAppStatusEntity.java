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
@Table(name = "hmis_trusted_app_status",schema="base")
public class TrustedAppStatusEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "status")
	private String status;

	@Column(name = "comments")
	private String comments;

	@ManyToOne
	@JoinColumn(name = "trustedapp_id", nullable = false, referencedColumnName = "id")
	private TrustedAppEntity trustedApp;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public TrustedAppEntity getTrustedApp() {
		return trustedApp;
	}

	public void setTrustedApp(TrustedAppEntity trustedApp) {
		this.trustedApp = trustedApp;
	}

}
