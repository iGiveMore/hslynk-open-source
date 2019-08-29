package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

public interface ClientManagementDao {

	void deleteClientIdentities(UUID clientId,UUID dedupClientId,String projectGroupCode,UUID userId);

	void mergeClientIdentities(UUID currentDedupId, UUID targetDedupId, UUID clientId, String projectGroupCode);
}