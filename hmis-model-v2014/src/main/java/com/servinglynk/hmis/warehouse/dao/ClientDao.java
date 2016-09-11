package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.Client;

public interface ClientDao extends ParentDao {
	Client createClient(Client client);
	Client updateClient(Client client);
	void deleteClient(Client client);
	Client getClientById(UUID clientId);
	List<Client> getAllClients(Integer startIndex, Integer maxItems);
	long getClientsCount(String projectGroupCode);
	public com.servinglynk.hmis.warehouse.model.v2014.Client getClientByDedupCliendId(UUID id,String projectGroupCode);
}
