package com.servinglynk.hmis.household.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.repository.GlobalHouseholdRepository;
import com.servinglynk.hmis.household.repository.HouseholdMembershipRepository;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipModel;
import com.servinglynk.hmis.household.web.rest.mapper.HouseholdMembershipMapper;
import com.servinglynk.hmis.household.web.rest.mapper.HouseholdMembershipMapperImplV3;
import com.servinglynk.hmis.household.web.rest.util.SecurityContextUtil;
import com.servinglynk.hmis.warehouse.core.model.Session;

/**
 * Service Implementation for managing HouseholdMembership.
 */
@Service("householdMembershipServiceV3")
@Transactional
public class HouseholdMembershipServiceV3 {

    private final Logger log = LoggerFactory.getLogger(HouseholdMembershipServiceV3.class);
    
    @Inject
    private HouseholdMembershipRepository householdMembershipRepository;
    
    @Autowired
    private GlobalHouseholdRepository globalHouseholdRepository;
    
    @Autowired
    private HouseholdMembershipMapperImplV3 householdMembershipMapper;
    
    @Transactional
    public List<HouseholdMembershipModel> save(UUID householdId,List<HouseholdMembershipModel> householdMembershipDTOs, Session session) {
        log.debug("Request to save HouseholdMembership : {}", householdMembershipDTOs);
        GlobalHousehold household =		globalHouseholdRepository.findOne(householdId);
        if(household==null) throw new ResourceNotFoundException("Global household not found "+householdId);
        List<HouseholdMembershipModel> lhouseholdmembersDTOs=new ArrayList<HouseholdMembershipModel>(); 
        for(HouseholdMembershipModel dto: householdMembershipDTOs){
        	dto.setDateCreated(LocalDateTime.now());
        	dto.setDateUpdated(LocalDateTime.now());
        	dto.setGlobalHouseholdId(householdId);
        	dto.setUserId(session.getAccount().getAccountId());
       // 	dto.setInactive(false);
        	lhouseholdmembersDTOs.add(dto);
        }
        List<HouseholdMembership> householdMembers = householdMembershipMapper.householdMembershipDTOsToHouseholdMemberships(lhouseholdmembersDTOs);
        householdMembers = householdMembershipRepository.save(householdMembers);
       List<HouseholdMembershipModel> result = householdMembershipMapper.householdMembershipsToHouseholdMembershipDTOs(householdMembers);
        return result;
    }
    
    @Transactional
    public HouseholdMembershipModel update(UUID householdId, HouseholdMembershipModel householdMembershipDTO, Session session) {
        log.debug("Request to save HouseholdMembership : {}", householdMembershipDTO);
    	GlobalHousehold globalHousehold =		globalHouseholdRepository.findOne(householdId);
    	if(globalHousehold==null) throw new ResourceNotFoundException("Global household not found "+householdId);
    	householdMembershipDTO.setDateCreated(LocalDateTime.now());
        householdMembershipDTO.setDateUpdated(LocalDateTime.now());
        householdMembershipDTO.setGlobalHouseholdId(householdId);
        householdMembershipDTO.setUserId(session.getAccount().getAccountId());
        HouseholdMembership householdMember = householdMembershipMapper.householdMembershipDTOToHouseholdMembership(householdMembershipDTO);

        householdMember = householdMembershipRepository.save(householdMember);
      //  HouseholdMembershipDTO result = householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(householdMember);
        return householdMembershipDTO;
    }

    /**
     *  Get all the householdMemberships.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<HouseholdMembership> getAllHouseholdMembersByHouseholdId(UUID householdId, Pageable pageable) {
        log.debug("Request to get all HouseholdMemberships");
        String projectGroup = SecurityContextUtil.getUserProjectGroup();
    	GlobalHousehold globalHousehold =		globalHouseholdRepository.findByGlobalHouseholdIdAndProjectGroupCodeAndDeleted(householdId,projectGroup,false);
    	if(globalHousehold==null) throw new ResourceNotFoundException("Global household not found "+householdId);
    	Page<HouseholdMembership> members = householdMembershipRepository.findByGlobalHouseholdAndDeleted(globalHousehold, pageable,false);
      
    	List<UUID> dedups = new ArrayList<>();
        List<HouseholdMembership> data = new ArrayList<>();
        for(HouseholdMembership membership : members.getContent()) {
        			if(!dedups.contains(membership.getDedupClientId()) && membership.getDedupClientId()!=null) {
        				data.add(membership);
        				dedups.add(globalHousehold.getDedupClientId());
        			}			
        }	        
   
        return new PageImpl<>(data, pageable, members.getTotalElements());
    }
    
    @Transactional(readOnly = true) 
    public Page<HouseholdMembership> findAll(Pageable pageable) {
        log.debug("Request to get all HouseholdMemberships");
        Page<HouseholdMembership> result = householdMembershipRepository.findAll(pageable); 
        return result;
    }

    /**
     *  Get one householdMembership by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public HouseholdMembershipModel findOne(UUID id) {
        log.debug("Request to get HouseholdMembership : {}", id);
        String projectGroup = SecurityContextUtil.getUserProjectGroup();
        HouseholdMembership householdMembership = householdMembershipRepository.findByHouseholdMembershipIdAndProjectGroupCodeAndDeleted(id,projectGroup,false);
        if(householdMembership==null) throw new ResourceNotFoundException("Global household not found "+id);
        HouseholdMembershipModel householdMembershipDTO = householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(householdMembership);
        return householdMembershipDTO;
    }

    /**
     *  Delete the  householdMembership by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(UUID id) {
        log.debug("Request to delete HouseholdMembership : {}", id);
        String projectGroup = SecurityContextUtil.getUserProjectGroup();
        HouseholdMembership householdMembership = householdMembershipRepository.findByHouseholdMembershipIdAndProjectGroupCode(id,projectGroup);
        if(householdMembership==null) throw new ResourceNotFoundException("Global household not found "+id);
        householdMembershipRepository.delete(householdMembership);
    }
    
    public Page<HouseholdMembership> getMemberShipByclientid(UUID clientid,Pageable pageable){
        String projectGroup = SecurityContextUtil.getUserProjectGroup();
    	Page<HouseholdMembership> householdMembership =	householdMembershipRepository.findByGlobalClientIdAndProjectGroupCode(clientid,projectGroup,pageable);
    	if(householdMembership.getSize()==0) throw new ResourceNotFoundException("Client not found");
    	return householdMembership;
    }
}
