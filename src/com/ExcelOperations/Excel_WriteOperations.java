package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_WriteOperations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//identify the file in the systam
		FileInputStream file=new FileInputStream("./src/com/ExcelOperations/Excel_Operations.xlsx");
		
		//identify the workbook in the excel
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//identify the sheet in the workbook
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//create the row in a sheet
		Row row=sheet.createRow(1);
		
		
		row.createCell(2).setCellValue("Selenium");

		FileOutputStream file1=new FileOutputStream("./src/com/ExcelOperations/Excel_Operations.xlsx");
		workbook.write(file1);

	}

}
