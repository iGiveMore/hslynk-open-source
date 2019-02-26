package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("dateofengagement")
public class Dateofengagement extends ClientModel{


      private UUID dateofengagementId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime dateofengagement;



      public UUID getDateofengagementId(){
          return dateofengagementId;
      }
      public void setDateofengagementId(UUID dateofengagementId){
          this.dateofengagementId = dateofengagementId;
      }
      public LocalDateTime getDateofengagement(){
          return dateofengagement;
      }
      public void setDateofengagement(LocalDateTime dateofengagement){
          this.dateofengagement = dateofengagement;
      }

 }
