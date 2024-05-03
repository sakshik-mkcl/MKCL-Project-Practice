package com.app.model;

import java.util.Date;


public class ExamEventPaperDetails {
	
	private long examEventPaperID;
	private long examEventID;
	private long fkPaperID;
	private int noOfAttempts;	
	

	private String createdBy;
	private Date dateCreated;
	private String modifiedBy;
	private Date dateModified;
	private char deleted;
	
	private String allowAttemptType;
	private boolean showNotepad;
    private boolean palletNavigation;
	
	private boolean isIdenticalItems;
	private boolean isIdenticalItemSequence;

	private boolean isRandomOption;
	private boolean isSkipQuestion;
	private boolean isAnswerChange;
	
    
    
	
	
	public ExamEventPaperDetails(long examEventID, long fkPaperID) {
		super();
		this.examEventID = examEventID;
		this.fkPaperID = fkPaperID;
	}
	
	
	public ExamEventPaperDetails( long examEventID,long fkPaperID,String allowAttemptType, int noOfAttempts
			, boolean isIdenticalItems, boolean isIdenticalItemSequence, boolean isRandomOption,
			boolean palletNavigation,boolean isSkipQuestion, boolean isAnswerChange, boolean showNotepad) {
		super();
		
		this.examEventID = examEventID;
		this.fkPaperID = fkPaperID;
		this.noOfAttempts = noOfAttempts;
		
		this.allowAttemptType = allowAttemptType;
		this.isIdenticalItems = isIdenticalItems;
		this.isIdenticalItemSequence = isIdenticalItemSequence;
		this.isRandomOption = isRandomOption;
		this.isSkipQuestion = isSkipQuestion;
		this.isAnswerChange = isAnswerChange;
		this.showNotepad = showNotepad;
		this.palletNavigation = palletNavigation;
	}


	public long getExamEventPaperID() {
		return examEventPaperID;
	}


	public void setExamEventPaperID(long examEventPaperID) {
		this.examEventPaperID = examEventPaperID;
	}


	public long getExamEventID() {
		return examEventID;
	}


	public void setExamEventID(long examEventID) {
		this.examEventID = examEventID;
	}


	public Long getFkPaperID() {
		return fkPaperID;
	}


	public void setFkPaperID(Long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}


	public int getNoOfAttempts() {
		return noOfAttempts;
	}


	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
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


	public char getDeleted() {
		return deleted;
	}


	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}


	public String getAllowAttemptType() {
		return allowAttemptType;
	}


	public void setAllowAttemptType(String allowAttemptType) {
		this.allowAttemptType = allowAttemptType;
	}


	public boolean getShowNotepad() {
		return showNotepad;
	}


	public void setShowNotepad(boolean showNotepad) {
		this.showNotepad = showNotepad;
	}


	public boolean getPalletNavigation() {
		return palletNavigation;
	}


	public void setPalletNavigation(boolean palletNavigation) {
		this.palletNavigation = palletNavigation;
	}


	public boolean getIsIdenticalItems() {
		return isIdenticalItems;
	}


	public void setIsIdenticalItems(boolean isIdenticalItems) {
		this.isIdenticalItems = isIdenticalItems;
	}


	public boolean getIsIdenticalItemSequence() {
		return isIdenticalItemSequence;
	}


	public void setIsIdenticalItemSequence(boolean isIdenticalItemSequence) {
		this.isIdenticalItemSequence = isIdenticalItemSequence;
	}


	public boolean getIsRandomOption() {
		return isRandomOption;
	}


	public void setIsRandomOption(boolean isRandomOption) {
		this.isRandomOption = isRandomOption;
	}


	public boolean getIsSkipQuestion() {
		return isSkipQuestion;
	}


	public void setIsSkipQuestion(boolean isSkipQuestion) {
		this.isSkipQuestion = isSkipQuestion;
	}


	public boolean getIsAnswerChange() {
		return isAnswerChange;
	}


	public void setIsAnswerChange(boolean isAnswerChange) {
		this.isAnswerChange = isAnswerChange;
	}
	

	
	
}
