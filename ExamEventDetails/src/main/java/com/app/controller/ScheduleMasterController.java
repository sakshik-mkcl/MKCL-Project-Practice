package com.app.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ExamEvent;
import com.app.model.ScheduleMaster;
import com.app.service.ExamEventDetailService;
import com.app.service.ScheduleMasterService;

@Controller
public class ScheduleMasterController {

	ScheduleMasterService service = new ScheduleMasterService();
	
	@GetMapping("/schedulelist/{eventId}")
    @ResponseBody
    public String getScheduleList(@PathVariable("eventId") Long eventId) {
    	ScheduleMasterService scheduleService =new ScheduleMasterService();
        return scheduleService.getAllSchedulesById(eventId).toString();
    }
    

	

	@GetMapping("/saveSchedule")
	public String addExamEvent(@RequestParam("scheduleType") String scheduleType,
			@RequestParam("maxNumberOfPapers") int maxNumberOfPapers,
			@RequestParam("scheduleStart") String scheduleStart, @RequestParam("scheduleEnd") String scheduleEnd,
			HttpServletRequest request) {

		System.out.println(scheduleType + " " + maxNumberOfPapers + " " + scheduleStart + " " + scheduleEnd);
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date startDatee = dateFormat.parse(scheduleStart);
			Date endDatee = dateFormat.parse(scheduleEnd);

			HttpSession session = request.getSession();
			ExamEvent event = (ExamEvent) session.getAttribute("examEvent");
			long examEventId = event.getExamEventID();
			System.out.println("Exam ID: " + examEventId);

			ScheduleMaster scheduleMaster = new ScheduleMaster(examEventId, startDatee, endDatee, scheduleType,
					maxNumberOfPapers);
			service.saveSchedule(scheduleMaster);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/schedulePaper";
	}
	
	@GetMapping("update/updateSchedule")
	public String updateSchedule(@RequestParam("scheduleID") long scheduleID, @RequestParam("scheduleType") String scheduleType,
			@RequestParam("maxNumberOfPapers") int maxNumberOfPapers,
			@RequestParam("scheduleStart") String scheduleStart, @RequestParam("scheduleEnd") String scheduleEnd,
			HttpServletRequest request) {

		System.out.println(scheduleType + " " + maxNumberOfPapers + " " + scheduleStart + " " + scheduleEnd);
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date startDatee = dateFormat.parse(scheduleStart);
			Date endDatee = dateFormat.parse(scheduleEnd);

			HttpSession session = request.getSession();
			ExamEvent event = (ExamEvent) session.getAttribute("examEvent");
			long examEventId = event.getExamEventID();
			System.out.println("Exam ID: " + examEventId);

			ScheduleMaster scheduleMaster = new ScheduleMaster(examEventId, startDatee, endDatee, scheduleType,
					maxNumberOfPapers);
			service.updateSchedule(scheduleMaster);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/schedulePaper";
	}

	
	
	
	

	@GetMapping("/delete/{id}")
	public String deleteSchedule(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/schedulePaper";
	}

	@GetMapping("/update/{scheduleID}")
	
	public String updateForm(@PathVariable("scheduleID") long scheduleID, Model model) {
		
		 ScheduleMasterService service = new ScheduleMasterService(); 
		 ScheduleMaster schedule = service.getScheduleById(scheduleID);
		 model.addAttribute("schedule",schedule);
	    return "update";	
	}
	
	
	/*
	 * @GetMapping("/update/{scheduleID}") public String
	 * showUpdateForm(@PathVariable("scheduleID") long scheduleID, Model model) {
	 * 
	 * ScheduleMasterService service = new ScheduleMasterService(); ScheduleMaster
	 * schedule = service.getScheduleById(scheduleID);
	 * 
	 * model.addAttribute("schedule", schedule);
	 * 
	 * return "4schedulePaper"; }
	 * 
	 * 
	 * 
	 * @PostMapping("/update/{scheduleID}") public String
	 * updateSchedule(@PathVariable("scheduleID") long scheduleID,
	 * 
	 * @ModelAttribute("schedule") ScheduleMaster updatedScheduleData) { try {
	 * ScheduleMasterService service = new ScheduleMasterService();
	 * 
	 * service.updateSchedule(scheduleID, updatedScheduleData); } catch(Exception e)
	 * { e.printStackTrace();
	 * 
	 * }
	 * 
	 * return "redirect:/schedulePaper"; }
	 */


	
	@RequestMapping("/activateExamEvent")
	public String proceed1() {
		return "5activateExamEvent";
		
	}
	  	

}
