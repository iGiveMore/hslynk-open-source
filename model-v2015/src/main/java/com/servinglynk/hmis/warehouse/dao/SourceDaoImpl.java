/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sandeep
 *
 */
public class SourceDaoImpl extends ParentDaoImpl implements SourceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(SourceDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) {
		Source source = domain.getSource();
		Data data = new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Source.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2015.Source sourceModel = null;
		try {
			sourceModel = getModelObject(domain, source, data, modelMap);
			sourceModel.setSoftwarevendor(source.getSoftwareVendor());
			//sourceModel.setSoftwareversion(BasicDataGenerator.getStringValue(source.getSoftwareVersion()));
			sourceModel.setSourcecontactemail(source.getSourceContactEmail());
			sourceModel.setSourcecontactextension(String.valueOf(source.getSourceContactExtension()));
			sourceModel.setSourcecontactfirst(source.getSourceContactFirst());
			sourceModel.setSourcecontactlast(source.getSourceContactLast());
			sourceModel.setSourceid(String.valueOf(source.getSourceID()));
			sourceModel.setSourcename(source.getSourceName());
			performSaveOrUpdate(sourceModel);
		}catch (Exception ex){
			String errorMessage = "Exception because of the source::"+source.getSourceID() +" Exception ::"+ex.getMessage();
			if(sourceModel != null){
				Error2015 error = new Error2015();
				error.model_id = sourceModel.getId();
				error.bulk_upload_ui = domain.getUpload().getId();
				error.project_group_code = domain.getUpload().getProjectGroupCode();
				error.source_system_id = sourceModel.getSourceSystemId();
				error.type = ErrorType.ERROR;
				error.error_description = errorMessage;
				error.date_created = sourceModel.getDateCreated();
				performSave(error);
			}
			logger.error(errorMessage);
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Source.class.getSimpleName(), domain,null);
	}
	
	
	public com.servinglynk.hmis.warehouse.model.v2015.Source getModelObject(ExportDomain domain, Source source ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Source sourceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			sourceModel = (com.servinglynk.hmis.warehouse.model.v2015.Source) getModel(com.servinglynk.hmis.warehouse.model.v2015.Source.class, source.getSourceID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(sourceModel == null) {
			sourceModel = new com.servinglynk.hmis.warehouse.model.v2015.Source();
			sourceModel.setId(UUID.randomUUID());
			sourceModel.setRecordToBeInserted(true);
			
		}else{
			++data.j;
		}
		hydrateCommonFields(sourceModel, domain,source.getSourceID(),data);
		return sourceModel;
	}


	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

}
