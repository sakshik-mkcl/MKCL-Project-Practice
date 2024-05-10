package com.app.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
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

        // Define cell style for the header row
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Create the header row which merged across three columns
        Row headerRow = sheet.createRow(rowNum++);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("User Information");
        headerCell.setCellStyle(headerCellStyle);
        //(0, 0, 0, 2) specifies the range of cells from A1 to C1
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2)); //(0,0)1st row 1st col top left to (0,2)1st row 2nd col ie top right

        // Create the column headers
        Row columnHeaderRow = sheet.createRow(rowNum++);
        String[] columnHeaders = {"Id", "Name", "Address"};
        int colNum = 0;
        for (String columnHeader : columnHeaders) {
            Cell columnHeaderCell = columnHeaderRow.createCell(colNum++);
            columnHeaderCell.setCellValue(columnHeader);
            columnHeaderCell.setCellStyle(headerCellStyle);
        }

        // Define cell style for data cells
        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        dataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        dataCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        dataCellStyle.setBorderLeft(BorderStyle.MEDIUM);
        dataCellStyle.setBorderRight(BorderStyle.MEDIUM);
        dataCellStyle.setBorderTop(BorderStyle.MEDIUM);

        // Add data to the sheet
        for (String line : lines) {
            Row row = sheet.createRow(rowNum++);
            String[] columns = line.split(",");
            colNum = 0;
            for (String column : columns) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(column);
                cell.setCellStyle(dataCellStyle);
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