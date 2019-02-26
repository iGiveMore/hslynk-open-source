package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;

public interface EnrollmentDao extends ParentDao {

	
	com.servinglynk.hmis.warehouse.model.v2014.Enrollment getEnrollmentById(UUID enrollmentId);
	
	
	
	
	Enrollment createEnrollment(Enrollment enrollment);
	Enrollment updateEnrollment(Enrollment enrollment);
	void deleteEnrollment(Enrollment enrollment);
	Enrollment getEnrollmentByClientIdAndEnrollmentId(UUID enrollmentId,UUID clientId);
	List<Enrollment> getEnrollmentsByClientId(UUID clientId,Integer startIndex, Integer maxItems);
	long getEnrollmentCount(UUID clientId);
	public long getEnrollmentCountByProjectGroupCode(String projectGroupCode);
	public List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment> getEnrollmentsByProjectGroupCode(String projectGroupCode,Integer startIndex, Integer maxItems);
	public com.servinglynk.hmis.warehouse.model.v2014.Enrollment getEnrollmentByProjectGroupCodeAndSourceSystem(String projectGroupCode,String sourceSystemId,String exportId);

}
