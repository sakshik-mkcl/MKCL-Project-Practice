package com.app.controller;

import java.io.ByteArrayOutputStream;


import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.User;




@RestController
public class HomeController {
	
//private ExcelServices eService = new ExcelServices();
	
	@GetMapping("/")
    public ModelAndView home() {
    	return new ModelAndView("index");
    }

	
	@GetMapping("/form")
	public ModelAndView form(Model model) {
		model.addAttribute("user",new User());
		return new ModelAndView("form");
	}
	
	@PostMapping("/form")
	public ResponseEntity<byte[]> register(@ModelAttribute("user") User user) {
		
		
		final Logger logger = org.slf4j.LoggerFactory.getLogger(HomeController.class);
        
                logger.trace("1. This is the trace message from the home controller");
                logger.debug("2. This is the debug message from the home controller");
                logger.info("1. This is the info message from the home controller");
                logger.warn("1. This is the warn message from the home controller");
                logger.error("1. This is the error message from the home controller");
               
          
		
		
		System.out.println("inside Form");
	    byte[] pdfBytes = generatePDF(user);
	    if (pdfBytes != null) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("filename", "information.pdf");
	        headers.setContentLength(pdfBytes.length);
	        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	    } else {
	       
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	private byte[] generatePDF(User user) {
        try(PDDocument document =  new PDDocument()){
        	PDPage page = new PDPage();
        	document.addPage(page);
        	
        	try(PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
        		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
                contentStream.beginText();
// moves the text cursor to the specified position (50 units from the left and 750 units from the bottom) on the PDF page.
                contentStream.newLineAtOffset(50, 750);
                contentStream.newLine();
                contentStream.showText("Candidate Information:");
                contentStream.newLineAtOffset(0, -20);
                contentStream.newLine();
                contentStream.showText("ID: "+ user.getId());
                contentStream.newLineAtOffset(0, -20);
                contentStream.newLine();
                contentStream.showText("Name: " + user.getName());
                contentStream.newLineAtOffset(0, -20);
                contentStream.newLine();
                contentStream.showText("Username: " + user.getUsername());
                
                contentStream.endText();
        	}
        	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
    }
	}
	

}