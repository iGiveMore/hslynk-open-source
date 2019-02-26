package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("connectionwithsoar")
public class Connectionwithsoar extends ClientModel{


      private UUID connectionwithsoarId;

      private Integer connectionwithsoar;



      public UUID getConnectionwithsoarId(){
          return connectionwithsoarId;
      }
      public void setConnectionwithsoarId(UUID connectionwithsoarId){
          this.connectionwithsoarId = connectionwithsoarId;
      }
      public Integer getConnectionwithsoar(){
          return connectionwithsoar;
      }
      public void setConnectionwithsoar(Integer connectionwithsoar){
          this.connectionwithsoar = connectionwithsoar;
      }

 }
