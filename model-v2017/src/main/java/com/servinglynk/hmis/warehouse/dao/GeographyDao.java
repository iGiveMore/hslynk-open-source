package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2017.Geography;

public interface GeographyDao extends ParentDao{
	
	 com.servinglynk.hmis.warehouse.model.v2017.Geography createGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography);
	   com.servinglynk.hmis.warehouse.model.v2017.Geography updateGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography);
	   void deleteGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography);
	   com.servinglynk.hmis.warehouse.model.v2017.Geography getGeographyById(UUID geographyId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.Geography> getAllGeography(Integer startIndex, Integer maxItems);
	   long getGeographyCount(String geoCode);
	   long getCocGeographiesCount(UUID cocId);
	   List<Geography> getAllCocGeographies(UUID cocId, Integer startIndex, Integer maxItems);

}
