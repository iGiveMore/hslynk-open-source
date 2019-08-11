package com.servinglynk.hmis.household.repository;

import java.util.List;
import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;

/**
 * Spring Data JPA repository for the HouseholdMembership entity.
 */
public interface HouseholdMembershipRepository extends JpaRepository<HouseholdMembership,Serializable> {
	
   Page<HouseholdMembership> findByGlobalHousehold(GlobalHousehold globalHousehold,Pageable pageable);
   Page<HouseholdMembership> findByGlobalClientId(UUID globalClientId,Pageable pageable);
HouseholdMembership findByHouseholdMembershipIdAndProjectGroupCode(UUID id, String projectGroup);
Page<HouseholdMembership> findByGlobalClientIdAndProjectGroupCode(UUID clientid, String projectGroup,
		Pageable pageable);
Page<HouseholdMembership> findByGlobalHouseholdAndDeleted(GlobalHousehold globalHousehold, Pageable pageable,
		boolean deleted);

List<HouseholdMembership> findByGlobalHouseholdAndDeleted(GlobalHousehold globalHousehold, boolean deleted);
HouseholdMembership findByHouseholdMembershipIdAndProjectGroupCodeAndDeleted(UUID id, String projectGroup, boolean deleted);

}