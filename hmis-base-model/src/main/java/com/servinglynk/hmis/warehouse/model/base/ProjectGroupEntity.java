package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity (name = "hmis_project_group")
@Table(name = "hmis_project_group",schema="base")
public class ProjectGroupEntity  {


	private UUID id;
    

	private String projectGroupName;


    private String projectGroupDesc;
    
    private String bucketName;
    private String projectGroupCode;
    
    private boolean skipuseridentifers;
    
   // private boolean active;
    
    private String senderEmail;
    
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
    public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name="bucket_name")
    public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	@Column(name="project_group_name")
	public String getProjectGroupName() {
		return projectGroupName;
	}
	public void setProjectGroupName(String projectGroupName) {
		this.projectGroupName = projectGroupName;
	}
	
    @Column(name="project_group_desc")
	public String getProjectGroupDesc() {
		return projectGroupDesc;
	}
	public void setProjectGroupDesc(String projectGroupDesc) {
		this.projectGroupDesc = projectGroupDesc;
	}
	
    @Column(name="project_group_code")
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	@Column(name="skip_user_identifers")
	public boolean isSkipuseridentifers() {
		return skipuseridentifers;
	}
	public void setSkipuseridentifers(boolean skipuseridentifers) {
		this.skipuseridentifers = skipuseridentifers;
	}
//	@Column(name="active")
//	public boolean isActitve() {
//		return active;
//	}
//	public void setActive(boolean active) {
//		this.active = active;
//	}
	
	@Column(name="sender_email")
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	
}