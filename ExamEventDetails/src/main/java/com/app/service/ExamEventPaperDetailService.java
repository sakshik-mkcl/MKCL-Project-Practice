package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.model.ExamEventPaperDetails;
import com.app.model.Paper;
import com.app.model.ScheduleMaster;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ExamEventPaperDetailService {
	
private ISql icrud = DALHelper.getIsql();


public void savePaperIdAndExamEventId(ExamEventPaperDetails examEventPaper) {
    ISql icrud = DALHelper.getIsql();
    

    try {            
    	icrud.save(examEventPaper);
    }catch(Exception e) {
            e.printStackTrace();
    }
  


}



/**
 * public List<Long> getPaperIdByExamEventId(long examEventId) throws
 * DALException { ISql icrud = DALHelper.getIsql(); List<Long> li= new
 * ArrayList<Long>(); li=icrud.findBy(Paper.class, "name", name); Paper paper=
 * new Paper(); if (li.size()!=0) {
 * 
 * paper = icrud.findBy(Paper.class, "name", name).get(0);
 * System.out.println(paper);
 * 
 * } else {
 * 
 * System.out.println("Paper list is empty");
 * 
 * }
 * 
 * return paper; }
 */

	
	public void saveExamEventPaperDetails( ExamEventPaperDetails examEventPaperDetails) {
		try {	
		icrud.save(examEventPaperDetails);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}

}
