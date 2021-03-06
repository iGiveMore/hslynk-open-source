package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class ActiveListView  extends Logging {

	 private SyncHBaseProcessor syncHBaseImport;
	 private Logger logger;
	 public ActiveListView(Logger logger) throws Exception {
	        this.logger = logger;
	        this.syncHBaseImport = new SyncHBaseProcessor();
	    }
	 
	public void createHbaseTable(String tableName) {
		syncHBaseImport.createHBASETable(tableName, logger);
	}
	
	 private Set<String> getDeletedIds(String hbaseTable, String projectGroupCode,String postgresTable,Properties props) {
	       // log.info("Start sync for table: " + postgresTable);
	        ResultSet resultSet;
	        PreparedStatement statement;
	        Connection connection;
	        Set<String> deletedIds = new HashSet<String>();
	        try {   
	     	      StringBuilder builder  = new StringBuilder();
	     	      builder.append("	  select client_dedup_id from housing_inventory.eligible_clients  ");
	     	      builder.append("	  where project_group_code= ? and  ( deleted=true or ignore_match_process=true ) ");
	     	      builder.append(" and date_updated >  ? ");
	     	      connection = SyncPostgresProcessor.getConnection();
		          statement = connection.prepareStatement(builder.toString());
		          statement.setString(1, projectGroupCode);
		          statement.setDate(2, getCutOffDate(props));
		          resultSet = statement.executeQuery();
	               while (resultSet.next()) {
	                   String key = resultSet.getString(1);
	                   deletedIds.add(key);
	               }
	               
	       }catch (Exception ex) {
	            logger.error("Exception:::"+ex.getMessage());
	            ex.printStackTrace();
	        }
	        return deletedIds;
	 }
	 
	 private void syncTableForDelete(String hbaseTable, String projectGroupCode,String postgresTable,Properties props) {
		 ResultSet resultSet;
	        HTable htable;
	        PreparedStatement statement;
	        Connection connection;
	        List<String> putsToDelete = new ArrayList<>();
	        try {   
	     	      htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
	     	      List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable, logger);
	     	      Set<String> deletedIds = getDeletedIds(hbaseTable, projectGroupCode, postgresTable, props);
	     	      
	     	     for(String dedupId : deletedIds )  {
	     	    	 if(existingKeysInHbase.contains(dedupId)) {
	     	    		 StringBuilder builder  = new StringBuilder();
			     	      builder.append(" SELECT distinct on (t.client_dedup_id) t.client_dedup_id,t.client_id as client_id,t.ignore_match_process as ignore_match_process,survey_score,survey_submission_date FROM housing_inventory.eligible_clients t ");
			     	      builder.append(" inner join (  ");
			     	      builder.append("	  select client_dedup_id,max(survey_submission_date) as maxDate from housing_inventory.eligible_clients tm ");
			     	      builder.append("	  where tm.project_group_code= ? and tm.deleted=false ");
			     	      builder.append(" group by client_dedup_id ) tm ");
			     	      builder.append(" on  t.client_dedup_id = tm.client_dedup_id ");
			     	      builder.append(" and t.survey_submission_date = tm.maxDate and t.project_group_code=? ");
			     	      builder.append(" and t.client_dedup_id =  ? ");
			     	      builder.append(" and t.deleted=false and t.ignore_match_process=false ");
			     	      builder.append(" order by t.client_dedup_id,survey_score desc" );
			     	      
			     	      connection = SyncPostgresProcessor.getConnection();
				          statement = connection.prepareStatement(builder.toString());
				          statement.setString(1, projectGroupCode);
				          statement.setString(2, projectGroupCode);
				          statement.setObject(3, UUID.fromString(dedupId));
				          resultSet = statement.executeQuery();
				          if(!resultSet.next()) {
				        	  logger.info(" Deleting..."+dedupId);
				        	  putsToDelete.add(dedupId);
				          }
	     	    	 }
	     	     }
	               String rowsToDelete = "Rows to delete for table " + postgresTable + ": " + putsToDelete.size();
	               logger.info(rowsToDelete);
	               if (putsToDelete.size() > 0) {
	                   syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
	                   putsToDelete.clear();
	               }
	        } catch (Exception ex) {
	            logger.error("Exception:::"+ex.getMessage());
	            ex.printStackTrace();
	        }
	     	      
	 }
	 private void syncTable(String hbaseTable, String projectGroupCode,String postgresTable,Properties props) {
	       // log.info("Start sync for table: " + postgresTable);
	        ResultSet resultSet;
	        HTable htable;
	        PreparedStatement statement;
	        Connection connection;
	        try {   
	     	      htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
	     	      StringBuilder builder  = new StringBuilder();
	     	      builder.append(" SELECT distinct on (t.client_dedup_id) t.client_dedup_id,t.client_id as client_id,t.ignore_match_process as ignore_match_process,survey_score,survey_submission_date FROM housing_inventory.eligible_clients t ");
	     	      builder.append(" inner join (  ");
	     	      builder.append("	  select client_dedup_id,max(survey_submission_date) as maxDate from housing_inventory.eligible_clients tm ");
	     	      builder.append("	  where tm.project_group_code= ? and tm.deleted=false ");
	     	      builder.append(" group by client_dedup_id ) tm ");
	     	      builder.append(" on  t.client_dedup_id = tm.client_dedup_id ");
	     	      builder.append(" and t.survey_submission_date = tm.maxDate and t.project_group_code=? ");
	     	      builder.append(" and t.date_updated >  ? ");
	     	      builder.append(" and t.deleted=false and t.ignore_match_process=false ");
	     	      builder.append(" order by t.client_dedup_id,survey_score desc" );
	     	      
	     	      connection = SyncPostgresProcessor.getConnection();
		          statement = connection.prepareStatement(builder.toString());
		          statement.setString(1, projectGroupCode);
		          statement.setString(2, projectGroupCode);
		          statement.setDate(3, getCutOffDate(props));
		          resultSet = statement.executeQuery();
		            
	     	      List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable, logger);
	               List<String> existingKeysInPostgres = new ArrayList<>();
 	               List<Put> putsToUpdate = new ArrayList<>();
	               List<Put> putsToInsert = new ArrayList<>();
	              
	               while (resultSet.next()) {
	                   String key = resultSet.getString(1);
	                   if(StringUtils.isBlank(key)){
	                       continue;
	                   }
	                   String clientId= (String)resultSet.getString("client_id");
	                   Put p = new Put(Bytes.toBytes(key));
	                   	
	                   	 addColumn("ignore_match_process",String.valueOf(resultSet.getBoolean("ignore_match_process")), key, p,existingKeysInHbase);
	                   	 addColumn("client_id",clientId, key, p,existingKeysInHbase);
	                   	 addColumn("survey_score",String.valueOf(resultSet.getInt("survey_score")), key, p,existingKeysInHbase);
	                   	 Survey survey = getLastestSurveyByClient(clientId, projectGroupCode);
	                   	 if(survey == null || survey.getSurveyId() == null) {
	                   		 survey = getLastestSurveyByClientFromSectionScore(clientId, projectGroupCode);
	                   	 }
	                   	 if(survey !=null && survey.getSurveyId() !=null) {
	                   		 String surveyId =  String.valueOf(survey.getSurveyId());
	                   		 addColumn("survey_id",surveyId, key, p,existingKeysInHbase);
	                   		 addColumn("survey_title",survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", " "), key, p,existingKeysInHbase);
	                   		 addColumn("survey_date",getCreatedAtString(resultSet.getTimestamp("survey_submission_date")), key, p,existingKeysInHbase);
	                   	 }
	                   	 
	                   	 Client client = getClientByID((String)resultSet.getString("client_id"));
	                   	 if(client !=null) {
	                   		 addColumn("first_name",client.getFirstName(), key, p,existingKeysInHbase);
	     	                	 addColumn("last_name",client.getLastName(), key, p,existingKeysInHbase);
	     	                	 addColumn("email",client.getEmail(),key,p,existingKeysInHbase);
	     	                	 addColumn("phone",client.getPhone(),key,p,existingKeysInHbase);
	     	                	 if(client.getDob() !=null) {
	     	                		 Date dob = client.getDob();
	     	                		 LocalDate birthday = dob.toLocalDate();
	     	                		 LocalDate now = LocalDate.now();
	     	                		 long age = birthday.until(now, ChronoUnit.YEARS);
	     		                	 addColumn("age",String.valueOf(age),key,p,existingKeysInHbase);
	     	                	 }
	                   	 }
	                   	 String notes = getNotes(clientId);
	                   	 if(StringUtils.isNotBlank(notes)) {
	                   		 addColumn("notes",notes,key,p,existingKeysInHbase);
	                   	 }
	                   	 
	                       if (existingKeysInHbase.contains(key)) {
	                           putsToUpdate.add(p);
	                           if (putsToUpdate.size() > syncHBaseImport.batchSize) {
	                        	   logger.info("Reached batchsize to update for table " + postgresTable + ": " + putsToUpdate.size());
	                               htable.put(putsToUpdate);
	                               putsToUpdate.clear();
	                           }
	                       } else {
	                           putsToInsert.add(p);
	                           if (putsToInsert.size() > syncHBaseImport.batchSize) {
	                               htable.put(putsToInsert);
	                               logger.info("Reached batchsize to putsToInsert for table " + postgresTable + ": " + putsToInsert.size());
	                               putsToInsert.clear();
	                           }
	                       }
	                       existingKeysInPostgres.add(key);
	                   }
	               
//	               if(CollectionUtils.isNotEmpty(existingKeysInHbaseCopy)) {
//	            	   existingKeysInHbaseCopy.removeAll(existingKeysInPostgres);  
//	 	              if(CollectionUtils.isNotEmpty(existingKeysInHbaseCopy)) {
//	 	            	  existingKeysInHbaseCopy.forEach(key -> {
//	 	            		 logger.info("Deleting Key:::::::"+key);
//	 	                       putsToDelete.add(key);
//	 	               });
//	 	              }
//	               }
	             
//	               String rowsToDelete = "Rows to delete for table " + postgresTable + ": " + putsToDelete.size();
//	               logger.info(rowsToDelete);
//	               if (putsToDelete.size() > 0) {
//	                   syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
//	                   putsToDelete.clear();
//	               }
	               
	               String rowsToInsert = "Rows to insert for table " + postgresTable + ": " + putsToInsert.size();
	               logger.info(rowsToInsert);
	               if (putsToInsert.size() > 0) {
	                   htable.put(putsToInsert);
	                   putsToInsert.clear();
	               }
	               String rowsToUpdate = "Rows to update for table " + postgresTable + ": " + putsToUpdate.size();
	               logger.info(rowsToUpdate);
	               if (putsToUpdate.size() > 0) {
	                   htable.put(putsToUpdate);
	                   putsToUpdate.clear();
	               }
	               String message = "insert : "+putsToInsert.size() + " update : "+putsToUpdate.size() ;
	               SyncPostgresProcessor.hydrateSyncTable("survey", "active_list", "COMPLETED", message ,projectGroupCode);
	        } catch (Exception ex) {
	            logger.error("Exception:::"+ex.getMessage());
	            ex.printStackTrace();
	        }

	        log.info("Sync done for table: " + postgresTable);
	    }
	 
	 private String getNotes(String key) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			String notes =null;
			try{
			connection = SyncPostgresProcessor.getConnection();
			statement = connection.prepareStatement(ViewQuery.GET_NOTES);
			statement.setObject(1, UUID.fromString(key));
			resultSet = statement.executeQuery();
				while(resultSet.next()) {
					notes = (String)resultSet.getString("response_text");
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
			return notes;
	}

	public void addColumn(String column, String value,String key,Put p,List<String> existingKeysInHbase) {
		 if(StringUtils.isNotBlank(value)) {
			if(existingKeysInHbase.contains(key)) {
				  p.add(Bytes.toBytes("CF"),
		                  Bytes.toBytes(column),
		                  Bytes.toBytes(value));
			}else {
				p.addColumn(Bytes.toBytes("CF"),
		                  Bytes.toBytes(column),
		                  Bytes.toBytes(value));
			}
			  
		 }
	 }
	
	public void updateColumn(String column, String value,String key,Put p) {
		 if(StringUtils.isNotBlank(value)) {
			  p.add(Bytes.toBytes("CF"),
	                  Bytes.toBytes(column),
	                  Bytes.toBytes(value));
		 }
	 }
	 
	 public int getAge(java.util.Date dob) {
			    long ageInMillis =  new java.util.Date().getTime() - dob.getTime();
			    Date age = new Date(ageInMillis);
			    return age.getYear();
	 }

	 
	 private static Date getCutOffDate(Properties props) {
		 int activeListDays = Integer.parseInt(props.ACTIVE_LIST_DAYS);
		 LocalDate date = LocalDate.now().minusDays(activeListDays);
		 Date dateBefore = Date.valueOf(date);
		 System.out.println("Cut off date : "+ dateBefore);
		 return dateBefore;
	}
	 private static String getCreatedAtString(Timestamp timestamp) {
		 String pattern = "yyyy-MM-dd HH:mm:ss";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    String stringDate = format.format(timestamp);
		    return stringDate;
	}

	public static  Survey getLastestSurveyByClient(String clientId,String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Survey survey = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement(ViewQuery.GET_LASTEST_SURVEY_BY_CLIENT);
		statement.setObject(1, UUID.fromString(clientId));
		statement.setString(2, projectGroupCode);
		resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String surveyId = (String)resultSet.getString("survey_id");
				survey = new Survey(projectGroupCode, UUID.fromString(surveyId) , (String)resultSet.getString("survey_title"), (Timestamp)resultSet.getTimestamp("created_at"));
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return survey;
	}
	
	public static  Survey getLastestSurveyByClientFromSectionScore(String clientId,String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Survey survey = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement(ViewQuery.GET_LASTEST_SURVEY_BY_CLIENT_FROM_SCORE);
		statement.setObject(1, UUID.fromString(clientId));
		statement.setString(2, projectGroupCode);
		resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String surveyId = (String)resultSet.getString("survey_id");
				survey = new Survey(projectGroupCode, UUID.fromString(surveyId) ,(String)resultSet.getString("survey_title") , (Timestamp)resultSet.getTimestamp("created_at"));
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return survey;
	}
	
	public static Client getClientByID(String clientId) throws Exception{
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try{
			connection = SyncPostgresProcessor.getConnection();
			statement = connection.prepareStatement(ViewQuery.GET_CLIENT_BY_ID);
			statement.setObject(1, UUID.fromString(clientId));
			resultSet = statement.executeQuery();
			String firstName =  null;
			String lastName =  null;
			String email = null;
			String phoneNumber = null;
			Date dob = null;
			while(resultSet.next()) {
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
				email = resultSet.getString("email_address");
				phoneNumber = resultSet.getString("phone_number");
				dob = (Date) resultSet.getDate("dob");
						
			}
			Client client = new Client(UUID.fromString(clientId), firstName, lastName,phoneNumber,email,dob);
			return client;
		}catch (Exception ex){
			throw ex;
		}
	}

	public void processActiveList(Properties props) {
		 FileAppender appender = new FileAppender();
         String appenderName = "active-list";
         appender.setName(appenderName);
         appender.setFile("logs/" + appenderName + ".log");
         appender.setImmediateFlush(true);
         appender.setAppend(true);
         appender.setLayout(new PatternLayout());
         appender.activateOptions();
         logger.addAppender(appender);
         List<String> allProjectGroupCodes = SyncPostgresProcessor.getAllProjectGroupCodes(logger);
         for (String projectGroupCode :allProjectGroupCodes) {
        	 String tableName ="active_list_"+projectGroupCode;
             createHbaseTable(tableName);
             logger.info("Processing active list for project group code"+projectGroupCode);
             syncTable(tableName, projectGroupCode, "eligible_clients",props);
             if(StringUtils.equals("false", props.ACTIVE_LIST_FULL)) {
            	 syncTableForDelete(tableName, projectGroupCode, "eligible_clients",props);
             }
         }
	}
	
	
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(ActiveListView.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		ActiveListView view = new ActiveListView(logger);
		view.processActiveList(props);
		
	}

}