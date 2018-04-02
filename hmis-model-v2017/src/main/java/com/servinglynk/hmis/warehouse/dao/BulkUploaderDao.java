package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import org.apache.log4j.Appender;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

@Transactional(propagation = Propagation.REQUIRED) 
public interface BulkUploaderDao {

	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3);
	public void deleteStagingByExportId(UUID exportId);
	public void deleteLiveByExportId(UUID exportId);
	public void deleteLiveByProjectGroupCode(String projectGroupCode, UUID exportId);
	public void undoDeleteLiveByExportId(UUID exportId);
	public BulkUpload processBase(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,Boolean isFileFromS3);
	public BulkUpload processEnrollment(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,Boolean isFileFromS3);
	public BulkUpload processDisabilities(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,Boolean isFileFromS3);
	public BulkUpload processExit(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,Boolean isFileFromS3);
	public BulkUpload processExitChildren(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,Boolean isFileFromS3);
	public BulkUpload processEnrollmentChildren(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,Boolean isFileFromS3);
	public BulkUpload processClientChildren(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender, Boolean isFileFromS3);

}
