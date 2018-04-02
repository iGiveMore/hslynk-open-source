package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
public class DomesticviolenceConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Domesticviolence modelToEntity (Domesticviolence model ,com.servinglynk.hmis.warehouse.model.v2017.Domesticviolence entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Domesticviolence();
       entity.setId(model.getDomesticviolenceId());
 if(model.getDomesticviolencevictim()!=null)
       entity.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(model.getDomesticviolencevictim().toString()));
 if(model.getWhenoccurred()!=null)
       entity.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(model.getWhenoccurred().toString()));
 if(model.getDataCollectionStage() !=null)
	entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));

 if(model.getInformationDate()!=null)
    entity.setInformationDate(model.getInformationDate());

       entity.setCurrentlyFleeing(model.getCurrentlyFleeing());
       return entity;
   }


   public static Domesticviolence entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Domesticviolence entity) {
       Domesticviolence model = new Domesticviolence();
       model.setDomesticviolenceId(entity.getId());
if(entity.getDomesticviolencevictim()!=null)
       model.setDomesticviolencevictim(Integer.parseInt(entity.getDomesticviolencevictim().getValue()));
if(entity.getWhenoccurred()!=null)
       model.setWhenoccurred(Integer.parseInt(entity.getWhenoccurred().getValue()));
if(entity.getInformationDate()!=null)
    model.setInformationDate(entity.getInformationDate());
 if(entity.getDataCollectionStage() !=null)
     model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));

       model.setCurrentlyFleeing(entity.getCurrentlyFleeing());
       return model;
   }


}
