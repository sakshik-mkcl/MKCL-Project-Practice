package com.app.DTO;

import java.util.Date;

public class SchedulePaperAssociationDTO {
	private String eventName;
	private String paperName;
	private Date startDate;
	private Date endDate;
	
	
	public SchedulePaperAssociationDTO() {
	
	}
	
	public SchedulePaperAssociationDTO(String eventName, String paperName, Date startDate, Date endDate) {
		super();
		this.eventName = eventName;
		this.paperName = paperName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
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
	
	

}
