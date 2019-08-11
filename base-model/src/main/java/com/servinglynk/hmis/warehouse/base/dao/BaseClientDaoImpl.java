package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.common.security.AuditUtil;
import com.servinglynk.hmis.warehouse.model.base.Client;

public class BaseClientDaoImpl extends QueryExecutorImpl implements BaseClientDao {

	@Override
	public void updateClientContact(Client client) {
		update(client);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Client getClient(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(Restrictions.eq("id", clientId));
		List<Client> clients = (List<Client>) findByCriteria(criteria);
		if(!clients.isEmpty()) return clients.get(0);
		return null;
	}

	@Override
	public void createClient(Client client) {
		insert(client);
	}

	@Override
	public void updateClient(Client client) {
		update(client);
	}
	
	public List<Client> getClientsByDedupId(UUID dedupId,Integer startIndex,Integer maxResults){
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(Restrictions.eq("dedupClientId", dedupId));
		criteria.add(Restrictions.isNull("parentId"));
		criteria.add(Restrictions.eq("deleted", false));
		if(AuditUtil.getSharedClients().isEmpty()) {
			criteria.add(Restrictions.eq("projectGroupCode",AuditUtil.getLoginUserProjectGroup()));
			}else {
				Criterion clientsCriterion = Restrictions.in("id",AuditUtil.getSharedClients());
				Criterion projectGroupCriterion =	Restrictions.eq("projectGroupCode",AuditUtil.getLoginUserProjectGroup());
		        Disjunction inDisjunction = Restrictions.disjunction();
		        	inDisjunction.add(projectGroupCriterion);
		        	inDisjunction.add(clientsCriterion);
		        	criteria.add(inDisjunction);
			}
		List<Client> clients = (List<Client>) getByCriteria(criteria, startIndex, maxResults);
		return clients;

	}
	
	public Long getClientsCountByDedupId(UUID dedupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(Restrictions.eq("dedupClientId", dedupId));
		criteria.add(Restrictions.isNull("parentId"));
		criteria.add(Restrictions.eq("deleted", false));
		if(AuditUtil.getSharedClients().isEmpty()) {
			criteria.add(Restrictions.eq("projectGroupCode",AuditUtil.getLoginUserProjectGroup()));
			}else {
				Criterion clientsCriterion = Restrictions.in("id",AuditUtil.getSharedClients());
				Criterion projectGroupCriterion =	Restrictions.eq("projectGroupCode",AuditUtil.getLoginUserProjectGroup());
		        Disjunction inDisjunction = Restrictions.disjunction();
		        	inDisjunction.add(projectGroupCriterion);
		        	inDisjunction.add(clientsCriterion);
		        	criteria.add(inDisjunction);
			}
		return getRowsCount(criteria);
	}

}