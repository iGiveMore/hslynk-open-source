package com.servinglynk.hmis.warehouse.dao;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.model.base.HmisBulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class,loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class BulkUploaderTest {
	
	@Autowired
	BulkUploaderDao dao; 
	
	@Autowired
	ParentDaoFactory factory;
	
	
	@Transactional
	public void testOldFile()
	{
		HmisBulkUpload upload = new HmisBulkUpload();
	//	URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
//		path.setURLStreamHandlerFactory(fac);
		//upload.setInputPath(path.getFile());
		upload.setInputpath("C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setStatus("INITIAL");
	//	HmisUser hmisUser = (HmisUser)factory.getHmisUserDao().findByUsername("superadmin@hmis.com");
	//	upload.setUser(hmisUser);
		factory.getBulkUploaderWorkerDao().insert(upload);
		//dao.performBulkUpload(upload);
	}
	@Test
	public void testCSVZip() throws Exception
	{
		URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
		HmisBulkUpload
		bullkUpload = new HmisBulkUpload();
		bullkUpload.setInputpath(path.getPath());
		bullkUpload.setId(2L);
		bullkUpload.setProjectGroupCode("PG0001");
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("PG0001");
		factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
	}
	
	@Test
	public void testxmlBigFile() throws Exception
	{
		HmisBulkUpload bullkUpload = new HmisBulkUpload();
		bullkUpload.setInputpath("C:\\Users\\sdolia\\Desktop\\Files\\HUD_4_0_1_3101_13.xml");
		bullkUpload.setId(2L);
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("PG0001");
		bullkUpload.setProjectGroupCode("PG0001");
		factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
	}
	
	
	@Test
	public void testDeleted() throws Exception {
		List<HmisBulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("DELETED");
		if(uploadEntities!=null && uploadEntities.size() >0 ) {
			for(HmisBulkUpload bullkUpload : uploadEntities) {
				 dao.deleteLiveByExportId(bullkUpload.getExportId());
			}
		}
	}
	@Test
	public void deleteExportFromStaging() {
		UUID id = UUID.fromString("f51bade9-d2a4-4743-a165-642955431aba");
		dao.deleteStagingByExportId(id);
	}
	@Test
	public void deleteExportFromLive() {
		UUID id = UUID.fromString("f51bade9-d2a4-4743-a165-642955431aba");
		dao.deleteLiveByExportId(id);
	}
	@Test
	public void undodeleteExportFromLive() {
		String s = "293bf9fd-a465-413d-9e57-101022f37d21";
	String s2 = s.replace("-", "");
	UUID id = new UUID(
	        new BigInteger(s2.substring(0, 16), 16).longValue(),
	        new BigInteger(s2.substring(16), 16).longValue());
		dao.undoDeleteLiveByExportId(id);
	}
	@Test
	public void softDeleteProjectGroup() throws Exception {
		List<HmisBulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("LIVE");
		for(HmisBulkUpload upload : uploads) {
			if(upload !=null && upload.getExportId() !=null) {
				dao.deleteLiveByProjectGroupCode(upload.getProjectGroupCode());		
			}
		}
		
	}
	
	@Test
	public void moveToLive() throws Exception {
		List<HmisBulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("STAGING");
		for(HmisBulkUpload upload : uploads) {
			if(upload !=null && upload.getExportId() !=null) {
				dao.moveFromStagingToLive(upload);		
			}
		}
		
	}
}
