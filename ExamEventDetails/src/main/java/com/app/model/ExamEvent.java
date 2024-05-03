package com.app.model;

import java.io.Serializable;
import java.util.Date;

public class ExamEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	private long examEventID;
	private long clientID;
	private String defaultLanguageID;
	private String examEventCode;
	private String name;
	private Date startDate;
	private Date endDate;
	private Boolean isActiveEvent;
	
	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	
	
	//private char deleted;
	
	private String eventCategory;
	
	
	private String eventType;
	private String examEventState;
	private String defaultLang;
	
	
	
	public ExamEvent() {
		
	}





	public ExamEvent(String defaultLanguageID, String examEventCode, String name, Date startDate, Date endDate) {
		super();
		this.defaultLanguageID = defaultLanguageID;
		this.examEventCode = examEventCode;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}





	public String getDefaultLang() {
		return defaultLang;
	}



	public void setDefaultLang(String defaultLang) {
		this.defaultLang = defaultLang;
	}



	public long getExamEventID() {
		return examEventID;
	}

	public void setExamEventID(long examEventID) {
		this.examEventID = examEventID;
	}

	public long getClientID() {
		return clientID;
	}

	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	public String getDefaultLanguageID() {
		return defaultLanguageID;
	}

	public void setDefaultLanguageID(String defaultLanguageID) {
		this.defaultLanguageID = defaultLanguageID;
	}

	public String getExamEventCode() {
		return examEventCode;
	}

	public void setExamEventCode(String examEventCode) {
		this.examEventCode = examEventCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsActiveEvent() {
		return isActiveEvent;
	}

	public void setIsActiveEvent(Boolean isActiveEvent) {
		this.isActiveEvent = isActiveEvent;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	


	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getExamEventState() {
		return examEventState;
	}

	public void setExamEventState(String examEventState) {
		this.examEventState = examEventState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public String toString() {
		return "ExamEvent [examEventID=" + examEventID + ", clientID=" + clientID + ", defaultLanguageID="
				+ defaultLanguageID + ", examEventCode=" + examEventCode + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", isActiveEvent=" + isActiveEvent + ", createdBy=" + createdBy
				+ ", dateCreated=" + dateCreated + ", modifiedBy=" + modifiedBy + ", dateModified=" + dateModified
			 + ", eventCategory=" + eventCategory + ", eventType=" + eventType
				+ ", examEventState=" + examEventState + ", defaultLang=" + defaultLang + "]";
	}

	
	
}
