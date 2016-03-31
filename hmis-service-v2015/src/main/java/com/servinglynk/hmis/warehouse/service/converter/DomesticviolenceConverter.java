package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
public class DomesticviolenceConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence modelToEntity (Domesticviolence model ,com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence();
       entity.setId(model.getDomesticviolenceId());
 if(model.getDomesticviolencevictim()!=null)
       entity.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(model.getDomesticviolencevictim().toString()));
 if(model.getWhenoccurred()!=null)
       entity.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(model.getWhenoccurred().toString()));
       entity.setCurrentlyFleeing(model.getCurrentlyFleeing());
       return entity;    
   }


   public static Domesticviolence entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence entity) {
       Domesticviolence model = new Domesticviolence();
       model.setDomesticviolenceId(entity.getId());
if(entity.getDomesticviolencevictim()!=null)
       model.setDomesticviolencevictim(Integer.parseInt(entity.getDomesticviolencevictim().getValue()));
if(entity.getWhenoccurred()!=null)
       model.setWhenoccurred(Integer.parseInt(entity.getWhenoccurred().getValue()));
       model.setCurrentlyFleeing(entity.getCurrentlyFleeing());
       return model;
   }


}
