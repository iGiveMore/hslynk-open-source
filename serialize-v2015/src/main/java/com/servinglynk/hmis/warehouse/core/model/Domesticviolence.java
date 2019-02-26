package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;



import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("domesticviolence")
public class Domesticviolence extends ClientModel{


      private UUID domesticviolenceId;

      private Integer domesticviolencevictim;

      private Integer whenoccurred;

      private Integer currentlyFleeing;

      private LocalDateTime informationDate;
      private Integer dataCollectionStage;

      public LocalDateTime getInformationDate() {
		return informationDate;
	}
	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}
	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
	public UUID getDomesticviolenceId(){
          return domesticviolenceId;
      }
      public void setDomesticviolenceId(UUID domesticviolenceId){
          this.domesticviolenceId = domesticviolenceId;
      }
      public Integer getDomesticviolencevictim(){
          return domesticviolencevictim;
      }
      public void setDomesticviolencevictim(Integer domesticviolencevictim){
          this.domesticviolencevictim = domesticviolencevictim;
      }
      public Integer getWhenoccurred(){
          return whenoccurred;
      }
      public void setWhenoccurred(Integer whenoccurred){
          this.whenoccurred = whenoccurred;
      }
      public Integer getCurrentlyFleeing(){
          return currentlyFleeing;
      }
      public void setCurrentlyFleeing(Integer currentlyFleeing){
          this.currentlyFleeing = currentlyFleeing;
      }

 }
