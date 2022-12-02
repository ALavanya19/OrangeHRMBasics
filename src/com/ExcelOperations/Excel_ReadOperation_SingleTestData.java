package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_ReadOperation_SingleTestData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//identify the Excel in the file system
		FileInputStream file=new FileInputStream("./src/com/ExcelOperations/Excel_Operations.xlsx");
		
		//identify the WorkBook in the excel
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//identify the sheet in the excel
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//identify the row in the sheet
		Row row=sheet.getRow(0);
		
		//identify the cell in the row
		Cell cell=row.getCell(0);
		
		//identify the value row of the cel
		String data=cell.getStringCellValue();
		
		//print the String availabel in row cel
		System.out.println(data);
		
		

	}

}


