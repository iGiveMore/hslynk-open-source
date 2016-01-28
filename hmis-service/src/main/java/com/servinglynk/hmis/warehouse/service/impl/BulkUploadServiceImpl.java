package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.service.BulkUploadService;

@Service
public class BulkUploadServiceImpl extends ServiceBase implements BulkUploadService  {
	
	@Transactional
	public void createBulkUploadEntry(com.servinglynk.hmis.warehouse.core.model.BulkUpload uploadModel) throws Exception {
		try{
			BulkUpload upload = new BulkUpload();
			upload.setInputPath(uploadModel.getInputPath());
			upload.setStatus("INITIAL");
			upload.setDateCreated(LocalDateTime.now());
			upload.setDateUpdated(LocalDateTime.now());
			upload.setSync(false);
			upload.setUser(daoFactory.getAccountDao().findByUsername(uploadModel.getUsername()));
			upload.setProjectGroupCode(uploadModel.getProjectGroupCode());
			daoFactory.getBulkUploaderWorkerDao().insert(upload);
		}catch(Exception e){
				throw new Exception("Worker Not Found"+ e.getMessage());
		}
	}
}
