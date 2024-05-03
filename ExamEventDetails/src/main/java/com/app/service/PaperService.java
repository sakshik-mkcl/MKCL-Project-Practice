package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ExamEvent;
import com.app.model.ExamEventPaperDetails;
import com.app.model.Paper;
import com.app.model.ScheduleMaster;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class PaperService {
	
	public Paper getPaperById(long id) throws DALException {
        ISql icrud = DALHelper.getIsql();
        List<Paper> li= new ArrayList<Paper>();
        li=icrud.findBy(Paper.class, "paperID", id);
        Paper paper= new Paper();
    if (li.size()!=0) {
		    
	paper = icrud.findBy(Paper.class, "paperID", id).get(0);
			System.out.println(paper);
		    
		} else {
		   
			System.out.println("Paper list is empty");
		    
		}

        return paper;
}
	

	public List<Paper> getAllPapersByExamEventId(long examEventId) throws DALException {
	    ISql icrud = DALHelper.getIsql();
	    String q = "select p from " + Paper.class.getName() + " p where p.paperID in " +
	               "(select eepd.fkPaperID from " + ExamEventPaperDetails.class.getName() + " eepd " +
	               "where eepd.examEventID = " + examEventId + ")";
	    
	    return icrud.executeQuery(q);
	}

 
	public void remove(long paperID) {
		ISql icrud = DALHelper.getIsql();
	    try {
	        Paper paper = icrud.findBy(Paper.class, "paperID", paperID).get(0);
	        if (paper != null) {
	            icrud.delete(paper);
	        } else {
	         
	            System.out.println("Paper with ID " + paperID + " does not exist.");
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	public String getAllPapers() {
        ISql icrud = DALHelper.getIsql();
        List<String> arr= new ArrayList<String>();

        try {            
                String str="select name from Paper";
        arr=icrud.executeQuery(str);
        }catch(Exception e) {
                e.printStackTrace();
        }
      System.out.println(arr.toString());
        return arr.toString();


}
	//get paper by name
	public Paper getIdByName(String name) throws DALException {
        ISql icrud = DALHelper.getIsql();
        List<Paper> li= new ArrayList<Paper>();
        li=icrud.findBy(Paper.class, "name", name);
        Paper paper= new Paper();
    if (li.size()!=0) {
		    
	paper = icrud.findBy(Paper.class, "name", name).get(0);
			System.out.println(paper);
		    
		} else {
		   
			System.out.println("Paper list is empty");
		    
		}

        return paper;
}
	

	
	
	
	
	
/*
 * public List<String> getPaperNamesByIds(String[] paperIDs) { ISql icrud =
 * DALHelper.getIsql(); List<String> arr= new ArrayList<String>();
 * 
 * try { String str="select name from Paper where paperID=paperIDs";
 * arr=icrud.executeQuery(str); }catch(Exception e) { e.printStackTrace(); }
 * System.out.println(arr.toString()); return arr;
 * 
 * }
 */

}
