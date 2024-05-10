package com.app.controller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.service.ReadExcelService;

@Controller
public class ReadExcelController {
        
        private ReadExcelService eServ = new ReadExcelService();
        
        
        @RequestMapping("/readExcel")
        public String showInputTextForm() {
            return "readExcel";
        }
        
        @PostMapping("/saveExcel")
        public void saveExcelFile(@RequestParam("excel") CommonsMultipartFile file, HttpSession s,HttpServletResponse response) throws IOException {
                System.out.println("----------------------->"+file.getName());
                System.out.println("----------------------->"+file.getOriginalFilename());
                System.out.println("----------------------->"+file.getSize());
                System.out.println("----------------------->"+file.getContentType());
                System.out.println("----------------------->"+file.getStorageDescription());
                
                byte[] data = file.getBytes();
                //we have to save this file to server...
                
                String path = "C:\\Users\\sakshik\\Desktop\\Files\\"+file.getOriginalFilename();
                System.out.println("----------------------->"+path);
                try {
                        FileOutputStream fos = new FileOutputStream(path);
                        fos.write(data);
                        fos.close();
                        
                        eServ.readExcelAndSaveInDB(path, "Sheet1");
                        
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                       
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        
                }
                
        }
}







