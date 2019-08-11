package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.HmisUser;

public class HmisUserDaoImpl extends BaseDaoImpl implements HmisUserDao {

	@Override
	public void addHmisUser(HmisUser hmisUser) {
		insert(hmisUser);
	}
	@Override
	public HmisUser getHmisUser(String id) {
		HmisUser hmisUser = (HmisUser) get(HmisUser.class, id);
		return hmisUser;
	}
	
	public HmisUser getHmisUser(UUID id) {
		HmisUser hmisUser = (HmisUser) get(HmisUser.class, id);
		return hmisUser;
	}

	@Override
	public void updateHmisUser(HmisUser hmisUser) {
		HmisUser hmisUserToUpdate = getHmisUser(hmisUser.getId().toString());
		hmisUserToUpdate.setFirstName(hmisUser.getFirstName());
		update(hmisUserToUpdate);
	}

	@Override
	public void deleteHmisUser(String id) {
		HmisUser hmisUser = getHmisUser(id);
		if (hmisUser != null)
			delete(hmisUser);
	}

	@Override
	public List<HmisUser> getHmisUsers() {
		return (List<HmisUser>) list("HmisUser");
	}
	
	public HmisUser findByUsername(String userName){
		DetachedCriteria criteria= DetachedCriteria.forClass(HmisUser.class);
		criteria.add(Restrictions.eq("username",userName));
		List<HmisUser> accountEntities = (List<HmisUser>)findByCriteria(criteria);
		if(accountEntities.size()>0){
			return getHmisUser(accountEntities.get(0).getId());
		}
		return null;
	}
}