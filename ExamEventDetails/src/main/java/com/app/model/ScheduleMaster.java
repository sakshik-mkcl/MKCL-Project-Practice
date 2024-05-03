package com.app.model;


import java.time.LocalDateTime;

import java.util.Date;

public class ScheduleMaster {

	private long scheduleID;
	private String scheduleName;
	private Date scheduleStart;
	private Date scheduleEnd;
	private Boolean isActiveSchedule;
	private LocalDateTime dateCreated;
	private String modifiedBy;
	private String createdBy;
	private LocalDateTime dateModified;
	private long fkExamEventID;
	private String scheduleType;
	private Boolean allowScheduleExtension;	
	private int maxNumberOfPapers;
	private char deleted;
	
	
	
	public ScheduleMaster() {
		
	}
	
	
	public ScheduleMaster(long fkExamEventID, Date scheduleStart, Date scheduleEnd, String scheduleType, int maxNumberOfPapers) {
		super();
		this.fkExamEventID = fkExamEventID;
		this.scheduleStart = scheduleStart;
		this.scheduleEnd = scheduleEnd;
		this.scheduleType = scheduleType;
		this.maxNumberOfPapers = maxNumberOfPapers;
	}


	public long getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(long scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public Date getScheduleStart() {
		return scheduleStart;
	}
	public void setScheduleStart(Date scheduleStart) {
		this.scheduleStart = scheduleStart;
	}
	public Date getScheduleEnd() {
		return scheduleEnd;
	}
	public void setScheduleEnd(Date scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}
	
	public Boolean getIsActiveSchedule() {
		return isActiveSchedule;
	}
	public void setIsActiveSchedule(Boolean isActiveSchedule) {
		this.isActiveSchedule = isActiveSchedule;
	}
	public long getFkExamEventID() {
		return fkExamEventID;
	}
	public void setFkExamEventID(long fkExamEventID) {
		this.fkExamEventID = fkExamEventID;
	}
	public String getScheduleType() {
		return scheduleType;
	}
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
	public Boolean getAllowScheduleExtension() {
		return allowScheduleExtension;
	}
	public void setAllowScheduleExtension(Boolean allowScheduleExtension) {
		this.allowScheduleExtension = allowScheduleExtension;
	}
	public int getMaxNumberOfPapers() {
		return maxNumberOfPapers;
	}
	public void setMaxNumberOfPapers(int maxNumberOfPapers) {
		this.maxNumberOfPapers = maxNumberOfPapers;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getDateModified() {
		return dateModified;
	}
	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}
	

	@Override
	public String toString() {
	    return "{\"scheduleID\":\"" + scheduleID + "\",\"scheduleStart\":\"" + scheduleStart +"\","
	    		+ " \"scheduleEnd\":\"" + scheduleEnd +"\"}";
	}



	
	
	


}
