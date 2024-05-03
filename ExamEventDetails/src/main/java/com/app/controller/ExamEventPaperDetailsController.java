package com.app.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.ExamEvent;
import com.app.model.ExamEventPaperDetails;
import com.app.model.Paper;
import com.app.model.ScheduleMaster;
import com.app.service.ExamEventDetailService;
import com.app.service.ExamEventPaperDetailService;
import com.app.service.PaperService;

import mkcl.os.model.dal.DALException;

@Controller

public class ExamEventPaperDetailsController {

	
	@GetMapping("/saveExamEventPaperDetails")
	
	public String addExamEvent(@RequestParam("fkPaperID") String fkPaperID,
			@RequestParam("eventType") String allowAttemptType,
			@RequestParam("noOfAttempts") int noOfAttempts,
			@RequestParam("isIdenticalItems") Boolean isIdenticalItems,
			@RequestParam("isIdenticalItemSequence") Boolean isIdenticalItemSequence,
	@RequestParam("isRandomOption") Boolean isRandomOption,
	@RequestParam("palletNavigation") Boolean palletNavigation,
	@RequestParam("isSkipQuestion") Boolean isSkipQuestion,
	@RequestParam("isAnswerChange") Boolean isAnswerChange,
	@RequestParam("reset") Boolean reset,
	@RequestParam("showNotepad") Boolean showNotepad,HttpServletRequest request)

	{   
		HttpSession session = request.getSession();
	
		
        PaperService paperService= new PaperService();
        try {
			Paper paper=paperService.getIdByName(fkPaperID);
			System.out.println(paper);
			//session.setAttribute("paper", paper);
		} catch (DALException e1) {
			
			e1.printStackTrace();
		}
		Paper paper=(Paper) session.getAttribute("paper");
		System.out.println(paper);
        long paperId=paper.getPaperID();
        
		
		 
		 ExamEvent event = (ExamEvent) session.getAttribute("examEvent");
		 long examEventId = event.getExamEventID();
		// Retrieve the examId using the getExamId() method
		System.out.println("Exam ID: " + examEventId);
		
		
		
		 ExamEventPaperDetailService service=new ExamEventPaperDetailService();
		 System.out.println("all exam event paper details data 3rd page");
		 try {
			   
			    ExamEventPaperDetails examEventPaperDetails = new ExamEventPaperDetails(examEventId,paperId,allowAttemptType, noOfAttempts,isIdenticalItems,
			    		isIdenticalItemSequence,isRandomOption,palletNavigation,isSkipQuestion,isAnswerChange,showNotepad);
			    service.saveExamEventPaperDetails(examEventPaperDetails);
			} catch (Exception e) {
			    e.printStackTrace(); 
			}

		 return "redirect:/addPaperConfiguration";
	}

	
	
	
	@RequestMapping("/schedulePaper")
	public String proceed() {
		return "4schedulePaper";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
