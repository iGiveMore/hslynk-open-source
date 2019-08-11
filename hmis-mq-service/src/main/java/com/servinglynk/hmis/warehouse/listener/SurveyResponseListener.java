package com.servinglynk.hmis.warehouse.listener;

import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.common.MQDateUtil;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;

@Component
public class SurveyResponseListener extends BaseListener {

	@JmsListener(destination="survey.responses")
	public void listeneQueue(String eventString) {
		System.out.println("inside survey.responses listener");
		JSONObjectMapper mapper = new JSONObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			
			ClientMetaDataModel model = new ClientMetaDataModel();
			model.setAdditionalInfo(mapper.writeValueAsString(event.getPayload()));
			if(event.getPayload().get("dedupClientId")!=null) model.setClientDedupId(UUID.fromString(event.getPayload().get("dedupClientId").toString()));
			if(event.getPayload().get("clientId")!=null) model.setClientId(UUID.fromString(event.getPayload().get("clientId").toString()));
			if(event.getPayload().get("submissionDate")!=null) model.setDate(MQDateUtil.stringToDateTime(event.getPayload().get("submissionDate").toString()));
			if(event.getPayload().get("submissionId")!=null) model.setMetaDataIdentifier(UUID.fromString(event.getPayload().get("submissionId").toString()));
			if(event.getPayload().get("projectGroupCode")!=null) model.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			model.setType(event.getEventType());
			if(event.getPayload().get("userId")!=null) model.setUserId(UUID.fromString(event.getPayload().get("userId").toString()));

			
					if(Boolean.parseBoolean(event.getPayload().get("deleted").toString())) {
						serviceFactory.getClientMetaDataService().deleteClientMetaData(model);
					}else {
						serviceFactory.getClientMetaDataService().createClientMetaData(model);
					}
		}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}