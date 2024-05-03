package com.app.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ExamEvent;
import com.app.model.ExamEventPaperDetails;
import com.app.model.Paper;
import com.app.service.ExamEventPaperDetailService;
import com.app.service.LanguageService;
import com.app.service.PaperService;

import mkcl.os.model.dal.DALException;


@Controller
public class PaperController {
	
	
	@GetMapping("/paperlist/{eventId}")
	@ResponseBody
	public String getPaperList(@PathVariable("eventId") Long eventId) throws DALException {
	    PaperService paperService = new PaperService();
	    return paperService.getAllPapersByExamEventId(eventId).toString();
	}
	
	
	@RequestMapping("/examEvent")
	public String back() {
		return "examEvent";
		
	}
	
	
	@RequestMapping("/addPaperConfiguration")
	public String proceed2() {
		return "3paperConfig";
		
	}
	
	@GetMapping("/remove/{id}")
	public void removePaper(@PathVariable Long id) {
		PaperService paperService = new PaperService();
		paperService.remove(id);
		
	}
	
	
	
	
	/*
	 * @PostMapping("/saveSelectedPapers") public String
	 * saveSelectedPapers(@RequestParam("selectedPapers") String[] selectedPapers) {
	 * paperService.processSelectedPapers(selectedPapers); return
	 * "redirect:/successPage"; // Redirect to success page after processing }
	 */
	
	
	/*
	 * @GetMapping("/saveSelectedPapers") public String
	 * saveSelectedPapers(@RequestParam("selectedPapers") String
	 * selectedPapers,HttpServletRequest request) {
	 * 
	 * String[] paperIds = selectedPapers.split(","); HttpSession session =
	 * request.getSession(); ExamEvent event = (ExamEvent)
	 * session.getAttribute("examEvent"); long examEventId = event.getExamEventID();
	 * 
	 * System.out.println("Exam ID: " + examEventId);
	 * 
	 * ExamEventPaperDetailService service=new ExamEventPaperDetailService();
	 * PaperService paperService=new PaperService();
	 * 
	 * 
	 * 
	 * for (String paperIdStr : paperIds) { Paper paper; try { paper =
	 * paperService.getIdByName(paperIdStr); System.out.println(paper);
	 * session.setAttribute("paper", paper); } catch (DALException e1) {
	 * 
	 * e1.printStackTrace(); }
	 * 
	 * 
	 * if (!paperIdStr.isEmpty()) { try { Long paperId = Long.parseLong(paperIdStr);
	 * ExamEventPaperDetails examEventPaper = new ExamEventPaperDetails(examEventId,
	 * paperId); service.savePaperIdAndExamEventId(examEventPaper);
	 * System.out.println("Paper ID: " + paperId);
	 * 
	 * } catch (NumberFormatException e) {
	 * 
	 * e.printStackTrace(); } } }
	 * 
	 * 
	 * 
	 * return "redirect:/addPaper"; }
	 */

	@GetMapping("/saveSelectedPapers")
	public String saveSelectedPapers(@RequestParam("selectedPapers") String selectedPapers, HttpSession session) {
	    String[] paperIds = selectedPapers.split(",");
	    ExamEvent event = (ExamEvent) session.getAttribute("examEvent");
	    long examEventId = event.getExamEventID();
	    ExamEventPaperDetailService service = new ExamEventPaperDetailService();
	    PaperService paperService = new PaperService();

	    for (String paperIdStr : paperIds) {
	        try {
	            if (!paperIdStr.isEmpty()) {
	                Long paperId = Long.parseLong(paperIdStr);
	                ExamEventPaperDetails examEventPaper = new ExamEventPaperDetails(examEventId, paperId);
	                service.savePaperIdAndExamEventId(examEventPaper);
	                Paper paper = paperService.getPaperById(paperId); 
	                session.setAttribute("paper", paper);
	                System.out.println("Paper ID: " + paperId);
	            }
	        } catch ( DALException e) {
	            e.printStackTrace();
	            // Handle exceptions
	        }
	    }

	    return "redirect:/addPaper";
	}

	
	
	@GetMapping("/allSelectedPapers")
	@ResponseBody
    public String languages() {
             PaperService service=new PaperService();
            String answer="";
            answer=service.getAllPapers();
            System.out.println(service.getAllPapers());
          System.out.println("controller");
            System.out.println(answer);
            return answer;
    }
	
	
	
	 
	 
	
	 
	


	

}
