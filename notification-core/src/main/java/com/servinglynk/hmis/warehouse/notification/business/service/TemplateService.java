package com.servinglynk.hmis.warehouse.notification.business.service;

import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.servinglynk.hmis.warehouse.core.model.ParameterVO;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.notification.framework.MergedNotificationContent;
import com.servinglynk.hmis.warehouse.notification.framework.NotificationWork;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationLineEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.TemplateHeaderEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.TemplateLineEntity;
@Service
public class TemplateService extends ParentService implements ITemplateService{
	
	@Autowired
	VelocityEngine velocityEngine;

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}


	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}



	public MergedNotificationContent merge(NotificationWork notificationWork){
			NotificationLineEntity nle = notificationWork.getNotificationLineEntity();
			Parameters data = notificationWork.getNotificationData();
			ParameterVO params = new ParameterVO(data);
			MergedNotificationContent notificationContent = new MergedNotificationContent();
			
			TemplateHeaderEntity template = nle.getTemplate();
			Integer version = nle.getTemplateVersion();
			List<TemplateLineEntity> templateLines= daoFactory.getTemplateLineDao().findTemplate(template.getExternalId(), version);
			if(!templateLines.isEmpty()){
				TemplateLineEntity templateLine = (TemplateLineEntity) templateLines.get(0);
				if(templateLine!=null){
					 System.out.println(velocityEngine.getProperty("file.resource.loader.path"));				
					 String mergedContent = VelocityEngineUtils.mergeTemplateIntoString(
							velocityEngine,
							templateLine.getLocation(),"UTF-8",
							params.getMap());
					 
					 if(params.getMap().get("subject")!=null && !(params.getMap().get("subject")+"").equalsIgnoreCase(""))
					 {
						 notificationContent.setSubject(params.getMap().get("subject")+"");
					 }else{
						 StringBuffer mergedSubject = StringUtils.stringSubstitution(templateLine.getSubject(), params.getMap());						 
						 notificationContent.setSubject(mergedSubject.toString());
					 }
					 notificationContent.setBody(mergedContent);
				}
			}
			
			return notificationContent;
				
	}
	
}
