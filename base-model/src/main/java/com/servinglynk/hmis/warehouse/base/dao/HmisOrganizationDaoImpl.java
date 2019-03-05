/**
 * 
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.OrganizationEntity;

/**
 * @author Sandeep
 *
 */
public class HmisOrganizationDaoImpl extends BaseDaoImpl implements
		HmisOrganizationDao {

	
	   public com.servinglynk.hmis.warehouse.model.base.OrganizationEntity createOrganization(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity organization){
		   organization.setId(UUID.randomUUID());
	       insert(organization);
	       return organization;
	   }
	   public com.servinglynk.hmis.warehouse.model.base.OrganizationEntity updateOrganization(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity organization){
	       update(organization);
	       return organization;
	   }
	   public void deleteOrganization(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity organization){
	       delete(organization);
	   }
	   public com.servinglynk.hmis.warehouse.model.base.OrganizationEntity getOrganizationById(UUID organizationId){ 
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity.class);
	       criteria.add(Restrictions.eq("id", organizationId));
	       List<OrganizationEntity> entities = (List<OrganizationEntity>) findByCriteria(criteria);
	       if(!entities.isEmpty()) return entities.get(0);
	       return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.base.OrganizationEntity> getAllOrganizations(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity.class);
	       return (List<com.servinglynk.hmis.warehouse.model.base.OrganizationEntity>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getOrganizationCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity.class);
	       return countRows(criteria);
	   }
}
