package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2016.BulkUploadActivity;

public interface BulkUploadActivityDao {
	public List<BulkUploadActivity> getBulkUploadActivityByUploadId(Long bulkUploadId);
}
