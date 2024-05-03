package com.app.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.ExamEvent;
import com.app.model.Paper;
import com.app.service.ExamEventDetailService;
import com.app.service.PaperService;

import mkcl.os.model.dal.DALException;



@Controller
public class HomeController {
	

	
	@RequestMapping("/")
	public String home() {
		return "examEvent";
		
	}
	
	
	@GetMapping("/saveExamEvent")
	public String addExamEvent(@RequestParam("name") String name,
			@RequestParam("examEventCode") String examEventCode,
			@RequestParam("defaultLanguageID") String defaultLanguageID,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		 ExamEventDetailService service=new ExamEventDetailService();
		 System.out.println(name + " "+ examEventCode + " " +defaultLanguageID +" " + startDate);
		 try {
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			    Date startDatee = dateFormat.parse(startDate);
			    Date endDatee = dateFormat.parse(endDate);
			    
			    ExamEvent examEvent = new ExamEvent(defaultLanguageID, examEventCode,name, startDatee, endDatee);
			    service.saveExamEventDetails(examEvent);
			} catch (java.text.ParseException e) {
			    e.printStackTrace(); 
			} catch (Exception e) {
			    e.printStackTrace(); 
			}

		 return "redirect:/";
	}
	
	 @ResponseBody
	 @GetMapping("/saveEventOnProceed")
	    public String getSingleEvent(@RequestParam("name") String name,HttpServletRequest request)  {
	            System.out.println(name);
	            HttpSession session = request.getSession();
	            
	            ExamEventDetailService examEventService=new ExamEventDetailService();
	            try {
	                        ExamEvent event =  examEventService.getSingleEvent(name);
	                        System.out.println(event);
	                        session.setAttribute("examEvent", event);
	                        
	                        
	                        
	                        if(event!=null) {
	                                return "Event Retrieved Successfully: "+event.toString();
	                        }else {
	                return "Event not found with the name: " + name;}
	            }catch (DALException e) {
	                        
	                        e.printStackTrace();
	                         return "Failed to retrieve event: " + e.getMessage();
	                }
	 }
	 
	
	 
	
	@RequestMapping("/addPaper")
	public String proceed1() {
		return "2addPaper";
		
	}
	
	
	
	
	@RequestMapping("/manageExamEvent")
	public String proceed2() {
		return "6manageExamEvent";
		
	}
	
	
	@RequestMapping("/scheduleTest")
	public String proceed3() {
		return "7scheduleTest";
		
	}	
		


}