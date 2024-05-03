package com.app.controller;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.app.dao.CandidateDao;

import com.app.entity.Candidate;



@Controller
public class CandidateController {
	
	@Autowired
	private CandidateDao candidateDao;
	
//	@Autowired
//	private ProLangDao pdao;
//	
//	@Autowired
//	private SkillsDao sdao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("Hellooooo");
		return new ModelAndView("index");
	}
	
	@RequestMapping("/addCandidate")
	public String addCandidate() {
		return "save";
	}
	
	
	@PostMapping("/handleCandidate")
	public RedirectView handleCandidate(@ModelAttribute Candidate candidate, HttpServletRequest request) throws Exception {
		System.out.println(candidate);
		candidateDao.addCandidate(candidate);
		
	  int cid=candidateDao.getCandidateId(candidate);
      System.out.println(cid);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
		
	}
		



}
