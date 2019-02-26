package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;

public interface ClientService {

	
	Client createClient(Client client,String caller) throws Exception;
	Client updateClient(Client client,String caller) throws Exception;
	Client deleteClient(UUID clientId,String caller);
	Client getClientById(UUID clientId);
	Clients getAllClients(String caller,Integer startIndex, Integer maxItems);
	
}
