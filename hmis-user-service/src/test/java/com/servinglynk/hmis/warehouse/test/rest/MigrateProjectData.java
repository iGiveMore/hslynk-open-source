package com.servinglynk.hmis.warehouse.test.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectMapEntity;

public class MigrateProjectData {
	
	
	public static String toString(LocalDateTime dateTime) {
		Date date = java.util.Date
	      .from(dateTime.atZone(ZoneId.systemDefault())
	      .toInstant());
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return format.format(date);
	}
	


	public UUID getGlobalProjectId(String projectName,String sourceSystemId,String projectGroup,Connection connection) throws Exception {
		
		String query ="SELECT ID FROM base.hmis_global_project where project_name='"+projectName.replaceAll("'", "''")+"' ";
	
		if(sourceSystemId!=null) {
			query = query + " and source_system_id='"+sourceSystemId+"' ";
		}else {
			query = query + " and source_system_id is NULL";
		}
		
		query = query + " and project_group_code='"+projectGroup+"'";
		
	//	System.out.println(" "+query);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next()) {
			return 	UUID.fromString(rs.getObject("ID").toString());
		}
		return null;
	}
	
	
	public void createGlobalProject(Connection connection,GlobalProjectEntity project) throws Exception {
		
		UUID id = UUID.randomUUID();
		
		Statement statement = connection.createStatement();
		
		String createdDate = null;
		String updatedDate = null;
		
		if(project.getDateCreated()!=null) createdDate ="TO_TIMESTAMP('"+MigrateProjectData.toString(project.getDateCreated())+"', 'DD-MM-YYYY HH24:MI:SS')";
		if(project.getDateUpdated()!=null)  updatedDate ="TO_TIMESTAMP('"+MigrateProjectData.toString(project.getDateUpdated())+"', 'DD-MM-YYYY HH24:MI:SS')";
		
		
		String query="insert into base.hmis_global_project (id,project_name,project_common_name,description,date_created,date_updated,deleted,user_id,project_group_code,source_system_id) "
				+ "values ('"+id+"','"+project.getProjectName()+"'," ;
			
		
		if(project.getProjectCommonName()!=null) {
			query = query + "'"+project.getProjectCommonName()+"'," ;		
		}else {
			query = query + "null," ;		
		}
		
				if(project.getDescription()!=null) {
					query = query + "'"+project.getDescription()+"'," ;		
				}else {
					query = query + "null," ;		
				}

			
						
						
			query = query		+ createdDate+","+updatedDate+","+project.isDeleted()+",";
			

			if(project.getUser()!=null) {
				query = query + "'"+project.getUser()+"'," ;		
			}else {
				query = query + "null," ;		
			}

			query = query + "'"+project.getProjectGroupCode()+"',";
			
			if(project.getSourceSystemId()!=null) {
				query = query + "'"+project.getSourceSystemId()+"'" ;		
			}else {
				query = query + "null" ;		
			}
			
			query = query + ")";
		
		
		System.out.println(" "+query+";");
		
		statement.execute(query);
		
	}
	
	public void updateGlobalProject(UUID globalProjectId,GlobalProjectMapEntity projectMap,Connection connection) throws Exception {
		
		UUID id = UUID.randomUUID();
		
		Statement statement = connection.createStatement();
		
		
		String createdDate = null;
		String updatedDate = null;
		
		if(projectMap.getDateCreated()!=null) createdDate ="TO_TIMESTAMP('"+MigrateProjectData.toString(projectMap.getDateCreated())+"', 'DD-MM-YYYY HH24:MI:SS')";
		if(projectMap.getDateUpdated()!=null)  updatedDate ="TO_TIMESTAMP('"+MigrateProjectData.toString(projectMap.getDateUpdated())+"', 'DD-MM-YYYY HH24:MI:SS')";
		
		
		String query ="INSERT INTO base.hmis_global_project_map(" + 
				"id, project_id, source, date_created, date_updated, deleted, " + 
				"user_id, project_group_code, global_project_id)" + 
				" VALUES ('"+id+"','"+projectMap.getProjectId()+"', '"+projectMap.getSource()+"',"+createdDate+", "+updatedDate+", "+projectMap.isDeleted()+", ";
		
		if(projectMap.getUser()!=null) {
			query = query + "'"+projectMap.getUser()+"'," ;		
		}else {
			query = query + "null," ;		
		}
		
		query = query + "'"+projectMap.getProjectGroupCode()+"', '"+globalProjectId+"');" + 
				" ";
		
		System.out.println(" "+query+";");
		
		
		statement.execute(query);
		
	}
	

	public static void main(String args[]) throws SQLException, ClassNotFoundException {
		MigrateProjectData data = new MigrateProjectData();
		
		String query = "SELECT * FROM base.project where project_group_code not in ('PG0001','MO0010') ";
		Class.forName("org.postgresql.Driver");
		Connection connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/hmis", "postgres", "admin");;
		Statement statement =null;
		try {
			 statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				UUID globalProjectId = data.getGlobalProjectId(rs.getString("projectname"), rs.getString("source_system_id"),rs.getString("project_group_code"), connection);
				if(globalProjectId==null) {
					GlobalProjectEntity project = new GlobalProjectEntity();
					if(rs.getString("projectcommonname")!=null) project.setProjectCommonName(rs.getString("projectcommonname").replaceAll("'", "''"));
					project.setProjectGroupCode(rs.getString("project_group_code"));					
					if(rs.getString("projectname")!=null) project.setProjectName(rs.getString("projectname").replaceAll("'", "''"));
					if(rs.getString("source_system_id")!=null) {
						project.setSourceSystemId(rs.getString("source_system_id"));
					}
					if(rs.getTimestamp("date_created")!=null) project.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
					if(rs.getTimestamp("date_updated")!=null) project.setDateUpdated(rs.getTimestamp("date_updated").toLocalDateTime());
					if(rs.getObject("user_id")!=null) project.setUser(UUID.fromString(rs.getObject("user_id").toString()));
					project.setDeleted(rs.getBoolean("deleted"));
					data.createGlobalProject(connection, project);
					
//					.replaceAll("'", "''")
				}else {
					GlobalProjectMapEntity projectMap = new GlobalProjectMapEntity();
					
					projectMap.setProjectGroupCode(rs.getString("project_group_code"));					
					projectMap.setProjectId(UUID.fromString(rs.getString("id")));
					projectMap.setDeleted(rs.getBoolean("deleted"));
					if(rs.getTimestamp("date_created")!=null) projectMap.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());
					if(rs.getTimestamp("date_updated")!=null) projectMap.setDateUpdated(rs.getTimestamp("date_updated").toLocalDateTime());
					if(rs.getObject("user_id")!=null) projectMap.setUser(UUID.fromString(rs.getObject("user_id").toString()));
					data.updateGlobalProject(globalProjectId, projectMap, connection);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(!statement.isClosed()) statement.close();
			if(!connection.isClosed()) connection.close();
		}
		
		
			//System.out.println( data.toString(new Date()));
	}
}
