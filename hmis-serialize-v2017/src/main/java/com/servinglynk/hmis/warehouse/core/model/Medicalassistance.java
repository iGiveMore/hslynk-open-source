package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("medicalassistance")
public class Medicalassistance extends ClientModel{


      private UUID medicalassistanceId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime informationDate;
      private Integer dataCollectionStage;
      private Integer hivaidsassistance;

      private Integer nohivaidsassistancereason;

      private Integer adap;

      private Integer noadapreason;

      

      public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
	public UUID getMedicalassistanceId(){
          return medicalassistanceId;
      }
      public void setMedicalassistanceId(UUID medicalassistanceId){
          this.medicalassistanceId = medicalassistanceId;
      }
      public LocalDateTime getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(LocalDateTime informationDate){
          this.informationDate = informationDate;
      }
      public Integer getHivaidsassistance(){
          return hivaidsassistance;
      }
      public void setHivaidsassistance(Integer hivaidsassistance){
          this.hivaidsassistance = hivaidsassistance;
      }
      public Integer getNohivaidsassistancereason(){
          return nohivaidsassistancereason;
      }
      public void setNohivaidsassistancereason(Integer nohivaidsassistancereason){
          this.nohivaidsassistancereason = nohivaidsassistancereason;
      }
      public Integer getAdap(){
          return adap;
      }
      public void setAdap(Integer adap){
          this.adap = adap;
      }
      public Integer getNoadapreason(){
          return noadapreason;
      }
      public void setNoadapreason(Integer noadapreason){
          this.noadapreason = noadapreason;
      }

 }
