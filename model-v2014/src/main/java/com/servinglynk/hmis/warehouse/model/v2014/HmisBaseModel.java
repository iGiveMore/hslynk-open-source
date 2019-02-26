package com.servinglynk.hmis.warehouse.model.v2014;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class HmisBaseModel implements Entity{
	
	/** Field mapping. */
	protected LocalDateTime dateCreated = LocalDateTime.now();
	/** Field mapping. */
	protected LocalDateTime dateUpdated = LocalDateTime.now();
	/** Field mapping. */
	protected LocalDateTime dateCreatedFromSource;
	/** Field mapping. */
	protected LocalDateTime dateUpdatedFromSource;
	/** Field mapping. */
	protected String projectGroupCode;
	private UUID userId;
	private String sourceSystemId;
	 /**
		 * Return the value associated with the column: dateCreated.
		 * @return A LocalDateTime object (this.dateCreated)
		 */
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_created"  )
		public LocalDateTime getDateCreated() {
			return this.dateCreated;
		}
		 /**  
		 * Set the value related to the column: dateCreated.
		 * @param dateCreated the dateCreated value you wish to set
		 */
		public void setDateCreated(final LocalDateTime dateCreated) {
			this.dateCreated = dateCreated;
		}

		 /**
		 * Return the value associated with the column: dateUpdated.
		 * @return A LocalDateTime object (this.dateUpdated)
		 */
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_updated"  )
		public LocalDateTime getDateUpdated() {
			return this.dateUpdated;
		}
		 /**  
		 * Set the value related to the column: dateUpdated.
		 * @param dateUpdated the dateUpdated value you wish to set
		 */
		public void setDateUpdated(final LocalDateTime dateUpdated) {
			this.dateUpdated = dateUpdated;
		}
	
		
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_created_from_source"  )
		  public LocalDateTime getDateCreatedFromSource() {
			return dateCreatedFromSource;
		}
		public void setDateCreatedFromSource(LocalDateTime dateCreatedFromSource) {
			this.dateCreatedFromSource = dateCreatedFromSource;
		}
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_updated_from_source"  )
		public LocalDateTime getDateUpdatedFromSource() {
			return dateUpdatedFromSource;
		}
		public void setDateUpdatedFromSource(LocalDateTime dateUpdatedFromSource) {
			this.dateUpdatedFromSource = dateUpdatedFromSource;
		}
		@Column(name="project_group_code")
			public String getProjectGroupCode() {
				return projectGroupCode;
			}
			public void setProjectGroupCode(String projectGroupCode) {
				this.projectGroupCode = projectGroupCode;
			}
			
			
			
			private boolean deleted;
			private boolean active;
			private boolean sync;
			
			
			@Column(name="sync")
			public boolean isSync() {
				return sync;
			}
			public void setSync(boolean sync) {
				this.sync = sync;
			}
			@Column(name="deleted")
			public boolean isDeleted() {
				return deleted;
			}

			public void setDeleted(boolean deleted) {
				this.deleted = deleted;
			}
			@Column(name="active")
			public boolean isActive() {
				return active;
			}

			public void setActive(boolean active) {
				this.active = active;
			}
			private UUID parentId;
			
			@Basic( optional = true )
			@Column( name = "parent_id", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
			public UUID getParentId() {
				return parentId;
			}

			public void setParentId(UUID parentId) {
				this.parentId = parentId;
			}
			
			private Long version;
			@Basic( optional = true )
			@Column( name = "version", nullable = true  )
			public Long getVersion() {
				return version;
			}

			public void setVersion(Long version) {
				this.version = version;
			}
			@Basic( optional = true )
			@Column( name = "user_id", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
			public UUID getUserId() {
				return userId;
			}

			public void setUserId(UUID user) {
				this.userId = user;
			}
			
			@Basic( optional = true )
			@Column( name = "source_system_id", nullable = true  )
		//	@Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES, analyzer=@Analyzer(definition="clientAnalyzer"))
			public String getSourceSystemId() {
				return sourceSystemId;
			}

			public void setSourceSystemId(String sourceId) {
				this.sourceSystemId = sourceId;
			}
			private boolean recordToBoInserted= true;
			
			@Transient
			public boolean isRecordToBoInserted() {
				return recordToBoInserted;
			}
			public void setRecordToBeInserted(boolean inserted) {
				this.recordToBoInserted = inserted;
			}
			
			private boolean ignored;
			/**
			 * @return the ignored
			 */
			@Transient
			public boolean isIgnored() {
				return ignored;
			}
			/**
			 * @param ignored the ignored to set
			 */
			public void setIgnored(boolean ignored) {
				this.ignored = ignored;
			}
			
			
}