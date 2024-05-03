package com.app.model;
import java.time.LocalDateTime;


public class Paper 
{

	private long paperID;
	private long fkClientID;
	private String code;
	private String name;
	private String duration;
	private boolean isPublished;
	private String abbreviation;
	private LocalDateTime dateCreated;
	private String modifiedBy;
	private String createdBy;
	private LocalDateTime dateModified;
	
	private char deleted;
	private String totalMarks;
	
	
	
	public Paper() {
		
	}
	public Paper(long paperID, long fkClientID, String code, String name, String duration, boolean isPublished,
			LocalDateTime dateCreated, String modifiedBy, String createdBy, LocalDateTime dateModified, char deleted,
			String totalMarks) {
		super();
		this.paperID = paperID;
		this.fkClientID = fkClientID;
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.isPublished = isPublished;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.createdBy = createdBy;
		this.dateModified = dateModified;
		this.deleted = deleted;
		this.totalMarks = totalMarks;
	}
	public long getPaperID() {
		return paperID;
	}
	public boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	public void setPaperID(long paperID) {
		this.paperID = paperID;
	}
	public long getFkClientID() {
		return fkClientID;
	}
	public void setFkClientID(long fkClientID) {
		this.fkClientID = fkClientID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
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
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String total_Marks) {
		totalMarks = total_Marks;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	@Override
	public String toString() {
	    return "{\"paperID\":\"" + paperID + "\",\"name\":\"" + name +"\"}";
	}


	
}

