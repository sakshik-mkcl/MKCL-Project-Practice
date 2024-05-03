package com.app.model;

import java.time.LocalDateTime;


public class SchedulePaperAssociation {
	private long schedulePaperAssociationID;
	private long fkScheduleID;
	private long fkPaperID;
	private Paper paper;
	private long fkExamEventID;
	private LocalDateTime dateCreated;
	private String modifiedBy;
	private String createdBy;
	private LocalDateTime dateModified; 
    private boolean isActive;
    
   
	public SchedulePaperAssociation(long fkScheduleID, long fkPaperID, long fkExamEventID) {
		
		this.fkScheduleID = fkScheduleID;
		this.fkPaperID = fkPaperID;
		this.fkExamEventID = fkExamEventID;
	}
	public long getSchedulePaperAssociationID() {
		return schedulePaperAssociationID;
	}
	public void setSchedulePaperAssociationID(long schedulePaperAssociationID) {
		this.schedulePaperAssociationID = schedulePaperAssociationID;
	}
	public long getFkScheduleID() {
		return fkScheduleID;
	}
	public void setFkScheduleID(long fkScheduleID) {
		this.fkScheduleID = fkScheduleID;
	}
	
	public long getFkPaperID() {
		return fkPaperID;
	}
	public void setFkPaperID(long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public long getFkExamEventID() {
		return fkExamEventID;
	}
	public void setFkExamEventID(long fkExamEventID) {
		this.fkExamEventID = fkExamEventID;
	}
	
	public boolean getisActive() {
		return isActive;
	}
	public void setisActive(boolean isActive) {
		this.isActive = isActive;
	}
}
