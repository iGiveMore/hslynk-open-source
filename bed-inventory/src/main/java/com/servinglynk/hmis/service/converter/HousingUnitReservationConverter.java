package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.HousingUnitReservationEntity;
import com.servinglynk.hmis.model.HousingUnitReservation;

public class HousingUnitReservationConverter {

	public static HousingUnitReservation entityToModel(HousingUnitReservationEntity entity) {
		HousingUnitReservation model = new HousingUnitReservation();
		model.setReservationEndDateDate(entity.getReservationEndDateDate());
		model.setReservationStateDate(entity.getReservationStateDate());
		model.setReservedCleintId(entity.getReservedCleintId());
		model.setReservedHouseholdId(entity.getReservedHouseholdId());
		model.setHousingUnit(HousingUnitConverter.entityToModel(entity.getHousingUnit()));
		model.setId(entity.getId());
		return model;
	}

	public static HousingUnitReservationEntity modelToEntity(HousingUnitReservation model,
			HousingUnitReservationEntity entity) {
		if(entity == null) entity = new HousingUnitReservationEntity();
		entity.setReservationEndDateDate(model.getReservationEndDateDate());
		entity.setReservationStateDate(model.getReservationStateDate());
		entity.setReservedCleintId(model.getReservedCleintId());
		entity.setReservedHouseholdId(model.getReservedHouseholdId());
		return entity;
	}

}
