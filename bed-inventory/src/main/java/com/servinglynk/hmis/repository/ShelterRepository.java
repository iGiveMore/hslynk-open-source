package com.servinglynk.hmis.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.ShelterEntity;

public interface ShelterRepository  extends JpaRepository<ShelterEntity, Serializable> {

}
