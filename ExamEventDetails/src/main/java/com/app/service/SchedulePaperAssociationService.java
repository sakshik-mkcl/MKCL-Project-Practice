package com.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.DTO.SchedulePaperAssociationDTO;
import com.app.model.ExamEvent;

import com.app.model.Paper;
import com.app.model.ScheduleMaster;
import com.app.model.SchedulePaperAssociation;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class SchedulePaperAssociationService {

	
private ISql icrud = DALHelper.getIsql();
	
	
	
	public void saveSchedulePaperAssociation(SchedulePaperAssociation schedulepaperassociation) {
		try {
		icrud.save(schedulepaperassociation);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	
	
	public List<Object> getAllExamEventnamePapersScheculeAllIds() throws DALException {
	    ISql icrud = DALHelper.getIsql();
	   
	    		String q = "SELECT e.name, p.name, s.scheduleStart, s.scheduleEnd " +
	    		           "FROM " + ExamEvent.class.getName() + " e, " + 
	    		                     ScheduleMaster.class.getName() + " s, " + 
	    		                     Paper.class.getName() + " p, " + 
	    		                     SchedulePaperAssociation.class.getName() + " sm " +
	    		           "WHERE sm.fkExamEventID = e.examEventID " +
	    		           "AND sm.fkPaperID = p.paperID " +
	    		           "AND sm.fkScheduleID = s.scheduleID"  ;

	    		 List<Object> result = new ArrayList<>();
	    		    List<Object> queryResult = icrud.executeQuery(q);

	    		    for (Object row : queryResult) {
	    		        Object[] rowData = (Object[]) row;
	    		        SchedulePaperAssociationDTO dto = new SchedulePaperAssociationDTO();
	    		        dto.setEventName((String) rowData[0]);
	    		        dto.setPaperName((String) rowData[1]);
	    		        dto.setStartDate((Date) rowData[2]);
	    		        dto.setEndDate((Date) rowData[3]);
	    		        result.add(dto);
	    		    }

	  
	    return result;
	}
}
