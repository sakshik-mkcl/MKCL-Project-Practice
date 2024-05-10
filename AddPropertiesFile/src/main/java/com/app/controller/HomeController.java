package com.app.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	@Value("${CandidateStatisticsReportPath}")
	private String CandidateStatisticsReportPath;
	
	@Value("${global.recordsPerPage}")
    private int recordsPerPage;

    @Value("${QuestionPaperPath}")
    private String questionPaperPath;
    
    @Value("${ImagesPath}")
    private String ImagesPath;
    
    @Value("${MaxCandidatesPerProctor}")
    private String MaxCandidatesPerProctor;
    
    @Value("${isLoggingEnabled}")
    private String isLoggingEnabled;

	@GetMapping("/properties")
    public String showProperties(Model model) {
        model.addAttribute("recordsPerPage", recordsPerPage);
        model.addAttribute("questionPaperPath", questionPaperPath);
        model.addAttribute("CandidateStatisticsReportPath", CandidateStatisticsReportPath);
        model.addAttribute("ImagesPath", ImagesPath);
        model.addAttribute("MaxCandidatesPerProctor", MaxCandidatesPerProctor);
        model.addAttribute("isLoggingEnabled", isLoggingEnabled);
        
        return "properties";
    }

}
