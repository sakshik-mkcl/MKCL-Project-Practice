package com.app.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WriteExcelController {

    @RequestMapping("/inputText")
    public String showInputTextForm() {
        return "writeExcel";
    }
    
    @PostMapping("/downloadExcel")
    public void downloadExcel(@RequestParam("inputText") String inputText, HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        String[] lines = inputText.split("\\r?\\n");
        int rowNum = 0;

        // Define a cell style for the column headers
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerFont.setFontHeightInPoints((short) 14);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Create the column headers
        Row headerRow = sheet.createRow(rowNum++);
        String[] headerColumns = {"Id", "Name", "Address"}; // Replace with your column headers
        int headerColNum = 0;
        for (String headerColumn : headerColumns) {
            Cell headerCell = headerRow.createCell(headerColNum++);
            headerCell.setCellValue(headerColumn);
            headerCell.setCellStyle(headerCellStyle);
            
        }

      
        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        dataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.MEDIUM); 
        dataCellStyle.setBorderRight(BorderStyle.MEDIUM);
        // Add data to the sheet
        for (String line : lines) {
            Row row = sheet.createRow(rowNum++);
            String[] columns = line.split(",");
            int colNum = 0;
            for (String column : columns) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(column);
                cell.setCellStyle(dataCellStyle); // Apply data cell style
            }
        }

        // Set response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=data.xlsx");

        // Write workbook to response output stream
        workbook.write(response.getOutputStream());
        workbook.close();
    }

}