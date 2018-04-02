package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc;

public interface EnrollmentCocDao extends ParentDao {
		List<EnrollmentCoc> getAllEnrollmentCoc(Integer startIndex, Integer maxItems);
		long getEnrollmentCocCount();
		public EnrollmentCoc getEnrollmentCocByDedupEnrollmentCocId(UUID id,String projectGroupCode);

	  com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc createEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCoc);
	   com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc updateEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCoc);
	   void deleteEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCoc);
	   com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc getEnrollmentCocById(UUID enrollmentCocId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc> getAllEnrollmentEnrollmentCocs(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentEnrollmentCocsCount(UUID enrollmentId);

}
