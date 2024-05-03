package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.app.dao.CandidateDao;
import com.app.entity.Candidate;

@Controller
public class CandidateController {
	
	@Autowired
	private CandidateDao candidateDao;
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
		
	}
	
	@RequestMapping("/addCandidate")
	public String addCandidate() {
		return "save";
	}
	
	@PostMapping("/handleCandidate")
	public RedirectView handleCandidate(@ModelAttribute Candidate candidate, HttpServletRequest request) {
		System.out.println(candidate);
		candidateDao.createCandidate(candidate);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
		
	}

	
}
