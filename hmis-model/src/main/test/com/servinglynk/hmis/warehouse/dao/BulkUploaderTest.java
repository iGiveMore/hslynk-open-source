package com.servinglynk.hmis.warehouse.dao;

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

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class,loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class BulkUploaderTest {
	@Autowired
	BulkUploaderDao dao;
	
	@Autowired
	ParentDaoFactory factory;
	
	@Test
	public void test()
	{
		BulkUpload upload = new BulkUpload();
		URL path = BulkUploaderUnMarshallerTest.class.getResource("New_HUD_Boman.xml");
		upload.setInputPath(path.getFile());
		dao.performBulkUpload(upload);
	}
	@Test
	public void testOldFile()
	{
		BulkUpload upload = new BulkUpload();
		URL path = BulkUploaderUnMarshallerTest.class.getResource("outputhmis-model.xml");
		upload.setInputPath(path.getFile());
		
		dao.performBulkUpload(upload);
	}
	
	@Test
	public void deleteExportFromStaging() {
		UUID id = UUID.fromString("fda97ba3-e737-4812-a03a-448212606fee");
		dao.deleteStagingByExportId(id);
	}
	@Test
	public void deleteExportFromLive() {
		UUID id = UUID.fromString("4dc6383a-c305-45f0-a876-016bf247e4a2");
		dao.deleteLiveByExportId(id);
	}
	
	@Test
	public void moveToLive() throws Exception {
		ExportDomain domain = new ExportDomain();
		List<BulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("STAGING");
		for(BulkUpload upload : uploads) {
			if(upload !=null && upload.getExport() !=null) {
				domain.setExportId(upload.getExport().getId());
				dao.moveFromStagingToLive(domain);		
			}
		}
		
	}
}
