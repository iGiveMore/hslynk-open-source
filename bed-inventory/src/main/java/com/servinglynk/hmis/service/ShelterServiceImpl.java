package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.ShelterEntity;
import com.servinglynk.hmis.model.ShelterModel;
import com.servinglynk.hmis.model.Shelters;
import com.servinglynk.hmis.service.converter.ShelterConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;

@Service
public class ShelterServiceImpl extends BaseService implements ShelterService {

	@Transactional
	public ShelterModel createShelter(ShelterModel shelter) {
		ShelterEntity entity = ShelterConverter.modelToEntity(shelter,null);
		daoFactory.getShelterRepository().save(entity);
		shelter.setId(entity.getId());
		return shelter;
	}
	
	@Transactional
	public void updateShelter(ShelterModel shelter) {
		ShelterEntity entity =  daoFactory.getShelterRepository().findOne(shelter.getId());
		if(entity == null) throw new ResourceNotFoundException("Shelter "+shelter.getId()+" not found");
		entity = ShelterConverter.modelToEntity(shelter,entity);
		daoFactory.getShelterRepository().save(entity);
	}
	
	@Transactional
	public void deleteShelter(UUID shelterId) {
		ShelterEntity entity =  daoFactory.getShelterRepository().findOne(shelterId);
		if(entity == null) throw new ResourceNotFoundException("Shelter "+shelterId+" not found");
		daoFactory.getShelterRepository().delete(entity);
	}
	
	@Transactional
	public ShelterModel getShelter(UUID shelterId) {
		ShelterEntity entity =  daoFactory.getShelterRepository().findOne(shelterId);
		if(entity == null) throw new ResourceNotFoundException("Shelter "+shelterId+" not found");		
		return ShelterConverter.entityToModel(entity);
	}
	
	@Transactional
	public Shelters getShelters(Pageable pageable) {
		Shelters shelters = new Shelters();
		Page<ShelterEntity> entityPage = daoFactory.getShelterRepository().findAll(pageable);
		for(ShelterEntity shelterEntity : entityPage.getContent()) {
			shelters.addShleter(ShelterConverter.entityToModel(shelterEntity));
		}
		return shelters;
	}	
}