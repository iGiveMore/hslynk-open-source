package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("residentialmoveindate")
public class Residentialmoveindate extends ClientModel{


      private UUID residentialmoveindateId;

      private Integer inpermanenthousing;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime residentialmoveindate;



      public UUID getResidentialmoveindateId(){
          return residentialmoveindateId;
      }
      public void setResidentialmoveindateId(UUID residentialmoveindateId){
          this.residentialmoveindateId = residentialmoveindateId;
      }
      public Integer getInpermanenthousing(){
          return inpermanenthousing;
      }
      public void setInpermanenthousing(Integer inpermanenthousing){
          this.inpermanenthousing = inpermanenthousing;
      }
      public LocalDateTime getResidentialmoveindate(){
          return residentialmoveindate;
      }
      public void setResidentialmoveindate(LocalDateTime residentialmoveindate){
          this.residentialmoveindate = residentialmoveindate;
      }

 }
