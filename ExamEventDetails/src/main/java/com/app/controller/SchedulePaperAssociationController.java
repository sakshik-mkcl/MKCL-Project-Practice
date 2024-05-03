package com.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.SchedulePaperAssociation;
import com.app.service.SchedulePaperAssociationService;

@Controller
public class SchedulePaperAssociationController {

	
	@GetMapping("/saveScheduleTest")
	public String saveScheduleTest(@RequestParam("fkExamEventID") long fkExamEventID,
			@RequestParam("fkPaperID") long fkPaperID,
			@RequestParam("fkScheduleID") long fkScheduleID) {

		SchedulePaperAssociationService service=new SchedulePaperAssociationService();
		System.out.println(fkExamEventID + " " + fkScheduleID + " " + fkPaperID);
		try {
			
		SchedulePaperAssociation schedulePaperAssociation=new SchedulePaperAssociation(fkScheduleID, fkPaperID, fkExamEventID);
		
			service.saveSchedulePaperAssociation(schedulePaperAssociation);
		}  catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/scheduleTest";
	}
}
