package com.app.controller;
import java.io.File;
import com.app.entity.DataStore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {


	@RequestMapping("/")
	public String home() {
		return "index";
		
	}

String name;
@PostMapping("/upload")
public String saveFileUpload( @RequestParam("file") CommonsMultipartFile file,HttpServletRequest request, HttpServletResponse response, 
		Model model, RedirectAttributes redirectAttributes) throws IOException 
        {
        System.out.println("----------------------->"+file.getName());
        System.out.println("----------------------->"+file.getOriginalFilename());
        System.out.println("----------------------->"+file.getSize());
        System.out.println("----------------------->"+file.getContentType());
        System.out.println("----------------------->"+file.getStorageDescription());
        System.out.println("----------------------->"+file.getFileItem());
        System.out.println("----------------------->"+file.getInputStream());
     
        name = file.getOriginalFilename();
        System.out.println(name);
        
       //add values into list
        DataStore.list.add( name);
        System.out.println(DataStore.list);
		
       
        HttpSession session = request.getSession();
        session.setAttribute("fileName", name);
        byte[] data = file.getBytes();
        //we have to save this file to server...
        
        String path = "C:\\Users\\sakshik\\Desktop\\Files\\"+file.getOriginalFilename();
        System.out.println("----------------------->"+path);
        try {
                FileOutputStream fos = new FileOutputStream(path);
                fos.write(data);
                fos.close();
               
                
        } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
               
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
        }
		return "redirect:/";
        
}


@GetMapping("/download/{fileName}")
public void downloadAllFiles(@PathVariable("fileName") String fileName, HttpServletResponse response) {
    String directory = "C:\\Users\\sakshik\\Desktop\\Files\\";
    File[] files = new File(directory).listFiles();

    if (files != null && files.length > 0) {
        try {
            // Create a temporary zip file
            String zipFileName = directory + "all_files.zip";
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            // Add each uploaded file to the zip
            for (File file : files) {
                FileInputStream fis = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOut.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }

            // Close streams
            zipOut.close();
            fos.close();

            // Set response content type and headers for zip file
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=\"all_files.zip\"");
            response.setContentLength((int) new File(zipFileName).length());

            // Stream zip file to response
            FileInputStream zipInStream = new FileInputStream(zipFileName);
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = zipInStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Close streams
            zipInStream.close();
            out.close();

            // Delete the temporary zip file
            new File(zipFileName).delete();

            // Delete all files from the directory
            for (File file : files) {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("No files found to download");
    }
}

}
