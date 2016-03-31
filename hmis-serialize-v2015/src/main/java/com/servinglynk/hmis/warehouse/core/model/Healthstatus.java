package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.cglib.core.Local;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("healthstatus")
public class Healthstatus extends ClientModel{


      private UUID healthstatusId;

      private LocalDateTime informationDate;

      private Integer healthCategory;

      private Integer healthStatus;

      private LocalDateTime dueDate;



      public UUID getHealthstatusId(){
          return healthstatusId;
      }
      public void setHealthstatusId(UUID healthstatusId){
          this.healthstatusId = healthstatusId;
      }
      public LocalDateTime getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(LocalDateTime informationDate){
          this.informationDate = informationDate;
      }
      public Integer getHealthCategory(){
          return healthCategory;
      }
      public void setHealthCategory(Integer healthCategory){
          this.healthCategory = healthCategory;
      }
      public Integer getHealthStatus(){
          return healthStatus;
      }
      public void setHealthStatus(Integer healthStatus){
          this.healthStatus = healthStatus;
      }
      public LocalDateTime getDueDate(){
          return dueDate;
      }
      public void setDueDate(LocalDateTime dueDate){
          this.dueDate = dueDate;
      }

 }
