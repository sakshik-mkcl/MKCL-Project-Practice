package com.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.app.model.ExamEvent;
import com.app.model.ScheduleMaster;

import mkcl.os.model.dal.DALException;
import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class ScheduleMasterService {
	
	private ISql icrud = DALHelper.getIsql();
	
	
	
	public void saveSchedule(ScheduleMaster scheduleMaster) {
		try {
		icrud.save(scheduleMaster);
	}catch(Exception e) {
		e.printStackTrace();
	}
	} 
	
	public void updateSchedule(ScheduleMaster scheduleMaster) {
		try {
		icrud.update(scheduleMaster);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
public List<ScheduleMaster> getAllSchedulesById(long examEventId) {
		
        List<ScheduleMaster> arr= new ArrayList<ScheduleMaster>();

        try {            
			
        
        arr=icrud.findBy(ScheduleMaster.class, "fkExamEventID", examEventId);
        System.out.println(arr);
        }catch(Exception e) {
                e.printStackTrace();
        }
      return arr;
	}
	
	
	
public List<ScheduleMaster> getAllSchedules() {
		
        List<ScheduleMaster> arr= new ArrayList<ScheduleMaster>();

        try {            
			
        
        arr=icrud.findAll(ScheduleMaster.class);
        }catch(Exception e) {
                e.printStackTrace();
        }
      return arr;
	}


public void delete(long scheduleID) {
    try {
        ScheduleMaster schedule = icrud.findBy(ScheduleMaster.class, "scheduleID", scheduleID).get(0);
        if (schedule != null) {
            icrud.delete(schedule);
        } else {
         
            System.out.println("ScheduleMaster with ID " + scheduleID + " does not exist.");
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
}
	


/*
 * public ScheduleMaster updateSchedule(long scheduleID, ScheduleMaster
 * updatedScheduleData) { try {
 * 
 * ScheduleMaster schedule = icrud.findBy(ScheduleMaster.class, "scheduleID",
 * scheduleID).get(0);
 * 
 * if (schedule != null) {
 * 
 * schedule.setScheduleType(updatedScheduleData.getScheduleType());
 * schedule.setMaxNumberOfPapers(updatedScheduleData.getMaxNumberOfPapers());
 * schedule.setScheduleStart(updatedScheduleData.getScheduleStart());
 * schedule.setScheduleEnd(updatedScheduleData.getScheduleEnd());
 * 
 * icrud.save(schedule); return schedule; } else {
 * 
 * System.out.println("ScheduleMaster with ID " + scheduleID +
 * " does not exist."); return null; } } catch(Exception e) {
 * 
 * e.printStackTrace(); return null; } }
 */



public ScheduleMaster getScheduleById(long scheduleID) {
    try {
        
        ScheduleMaster schedule = icrud.findBy(ScheduleMaster.class, "scheduleID", scheduleID).get(0);

            return schedule;
        } catch(Exception e) {
       
        e.printStackTrace();
        return null;
    }
}



public long getScheduleIdByExamEventId(long fkExamEventID) throws DALException {
   
        
        ScheduleMaster schedule = icrud.findBy(ScheduleMaster.class, "fkExamEventID", fkExamEventID).get(0);

            return schedule.getScheduleID();
        
}

	


}