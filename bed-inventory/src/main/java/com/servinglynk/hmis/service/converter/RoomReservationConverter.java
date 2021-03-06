package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.RoomReservationEntity;
import com.servinglynk.hmis.model.RoomReservation;

public class RoomReservationConverter {

	public static RoomReservation entityToModel(RoomReservationEntity entity) {
		RoomReservation model = new RoomReservation();
		model.setReservationEndDateDate(entity.getReservationEndDateDate());
		model.setReservationStateDate(entity.getReservationStateDate());
		model.setReservedCleintId(entity.getReservedCleintId());
		model.setReservedHouseholdId(entity.getReservedHouseholdId());
		model.setRoom(RoomConverter.entityToModel(entity.getRoom()));
		model.setId(entity.getId());
		return model;
	}

	public static RoomReservationEntity modelToEntity(RoomReservation model, RoomReservationEntity entity) {
		if(entity == null) entity = new RoomReservationEntity();
		entity.setReservationEndDateDate(model.getReservationEndDateDate());
		entity.setReservationStateDate(model.getReservationStateDate());
		entity.setReservedCleintId(model.getReservedCleintId());
		entity.setReservedHouseholdId(model.getReservedHouseholdId());
		return entity;
	}

}
