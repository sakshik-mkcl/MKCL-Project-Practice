package com.app.controller;


import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RestController;

import com.app.service.ExamEventDetailService;
import com.app.service.LanguageService;


@RestController
public class LanguageController {
	
	@GetMapping("/langlist")
    public String languages() {
             LanguageService service=new LanguageService();
            String answer="";
            answer=service.getAllLanguage();
            System.out.println(service.getAllLanguage());
          System.out.println("controller");
            System.out.println(answer);
            return answer;
    }
	
	
	@GetMapping("/eventName")
    public String getEventName() {
             ExamEventDetailService service=new ExamEventDetailService();
            String answer="";
            answer=service.getAlleventName();
            System.out.println(service.getAlleventName());
          System.out.println("controller");
            System.out.println(answer);
            return answer;
    }
	
	
	
	
	
	
	
	
	
}