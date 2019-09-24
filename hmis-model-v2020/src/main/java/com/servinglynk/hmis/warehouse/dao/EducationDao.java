package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface EducationDao extends ParentDao {
	   com.servinglynk.hmis.warehouse.model.v2020.Education createEducation(com.servinglynk.hmis.warehouse.model.v2020.Education education);
	   com.servinglynk.hmis.warehouse.model.v2020.Education updateEducation(com.servinglynk.hmis.warehouse.model.v2020.Education education);
	   void deleteEducation(com.servinglynk.hmis.warehouse.model.v2020.Education education);
	   com.servinglynk.hmis.warehouse.model.v2020.Education getEducationById(UUID educationId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.Education> getAllEnrollmentEducations(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentEducationsCount(UUID enrollmentId);
}
