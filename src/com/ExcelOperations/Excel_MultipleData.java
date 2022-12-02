package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_MultipleData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//identify the File in the system
		FileInputStream file=new FileInputStream("./src/com/ExcelOperations/Excel_Operations.xlsx");
		
		//identify the workbook in the file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//identify the sheet in the workbook
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		
		// create the row in the sheet
		Row row2=sheet.createRow(2);
		Row row3=sheet.createRow(3);
	
		
		//create cells in the row
		row2.createCell(0).setCellValue(" ");
		row2.createCell(1).setCellValue("Automation");
	//	row3.createCell(0).setCellValue("");
	//	row3.createCell(1).setCellValue("Mannual");
		
		FileOutputStream fileOutPut=new FileOutputStream("./src/com/ExcelOperations/Excel_Operations.xlsx");
		workbook.write(fileOutPut);
		
		//identify the row active count
		int rowCount=sheet.getLastRowNum();
	//	System.out.println(rowCount);
		
		for(int i=0;i<=rowCount;i++)
		{
			//identify the active cells in a row
			
			int cellCount=sheet.getRow(i).getLastCellNum();
		//	System.out.println(cellCount);
			
			for(int j=0;j<cellCount;j++)
			{
				//System.out.println("scr");
				String cellData=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(cellData+" ");
				
			}
			System.out.println();
			
		
	}
		
	}

}
