package com.app.service;
import java.util.ArrayList;
import java.util.List;

import com.app.model.ExamEvent;
import com.app.model.Paper;
import com.app.model.ScheduleMaster;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;


public class ExamEventDetailService {
	
	private ISql icrud = DALHelper.getIsql();
	

	
	
	public void saveExamEventDetails(ExamEvent examEvent) {
		try {
		icrud.save(examEvent);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	
public List<ExamEvent> getAllExamEvent() {
		
        List<ExamEvent> arr= new ArrayList<ExamEvent>();

        try {            
        	
            arr=icrud.findAll(ExamEvent.class);
            System.out.println(arr);
        }catch(Exception e) {
                e.printStackTrace();
        }
      return arr;
	}
	
	
	
	
	
	public String getAlleventName() {
		
        List<String> arr= new ArrayList<String>();

        try {            
                String str="select name from ExamEvent where clientID=0";
        arr=icrud.executeQuery(str);
        }catch(Exception e) {
                e.printStackTrace();
        }
      System.out.println(arr.toString());
        return arr.toString();
	}
	
	
	
	public ExamEvent getSingleEvent(String name) throws DALException {
		
		if (!icrud.findBy(ExamEvent.class, "name", name).isEmpty()) {
		    
			ExamEvent event = icrud.findBy(ExamEvent.class, "name", name).get(0);
			System.out.println(event);
		    
		} else {
		   
			System.out.println("list is empty");
		    
		}
		    ExamEvent exam= (ExamEvent) icrud.findBy(ExamEvent.class, "name", name).get(0);
			
			System.out.println(exam);
		return exam;
	}


	
}
