package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("noncashBenefits")
public class Noncashbenefits extends ClientModel{

	 @JsonProperty("noncashBenefitsId")
      private UUID noncashbenefitsID;

      @JsonProperty("benefitsFromAnySource")
      private Integer benefitsfromanysource;
      @JsonProperty("otherSource")
      private Integer othersource;

      @JsonProperty("otherSourceIdentify")
      private String othersourceidentify;
      @JsonProperty("otherTanf")
      private Integer othertanf;
      
      @JsonProperty("rentalAssistanceOngoing")
      private Integer rentalassistanceongoing;

      @JsonProperty("rentalAssistanceTemp")
      private Integer rentalassistancetemp;

      private Integer snap;
      @JsonProperty("tanfChildcare")
      private Integer tanfchildcare;
      @JsonProperty("tanfTransportation")
      private Integer tanftransportation;

      private Integer wic;

      @JsonDeserialize(using=JsonDateDeserializer.class)
      @JsonSerialize(using=JsonDateSerializer.class)
      private LocalDateTime informationDate;
      private Integer dataCollectionStage;
      
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      LocalDateTime submissionDate;

        public LocalDateTime getSubmissionDate() {
  		return submissionDate;
  	}
  	public void setSubmissionDate(LocalDateTime submissionDate) {
  		this.submissionDate = submissionDate;
  	}


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
      public UUID getNoncashbenefitsID(){
          return noncashbenefitsID;
      }
      public void setNoncashbenefitsID(UUID noncashbenefitsID){
          this.noncashbenefitsID = noncashbenefitsID;
      }
      public Integer getBenefitsfromanysource(){
          return benefitsfromanysource;
      }
      public void setBenefitsfromanysource(Integer benefitsfromanysource){
          this.benefitsfromanysource = benefitsfromanysource;
      }
      public Integer getOthersource(){
          return othersource;
      }
      public void setOthersource(Integer othersource){
          this.othersource = othersource;
      }
      public String getOthersourceidentify(){
          return othersourceidentify;
      }
      public void setOthersourceidentify(String othersourceidentify){
          this.othersourceidentify = othersourceidentify;
      }
      public Integer getOthertanf(){
          return othertanf;
      }
      public void setOthertanf(Integer othertanf){
          this.othertanf = othertanf;
      }
      public Integer getRentalassistanceongoing(){
          return rentalassistanceongoing;
      }
      public void setRentalassistanceongoing(Integer rentalassistanceongoing){
          this.rentalassistanceongoing = rentalassistanceongoing;
      }
      public Integer getRentalassistancetemp(){
          return rentalassistancetemp;
      }
      public void setRentalassistancetemp(Integer rentalassistancetemp){
          this.rentalassistancetemp = rentalassistancetemp;
      }
      public Integer getSnap(){
          return snap;
      }
      public void setSnap(Integer snap){
          this.snap = snap;
      }
      public Integer getTanfchildcare(){
          return tanfchildcare;
      }
      public void setTanfchildcare(Integer tanfchildcare){
          this.tanfchildcare = tanfchildcare;
      }
      public Integer getTanftransportation(){
          return tanftransportation;
      }
      public void setTanftransportation(Integer tanftransportation){
          this.tanftransportation = tanftransportation;
      }
      public Integer getWic(){
          return wic;
      }
      public void setWic(Integer wic){
          this.wic = wic;
      }

 }
