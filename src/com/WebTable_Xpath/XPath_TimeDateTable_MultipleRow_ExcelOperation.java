package com.WebTable_Xpath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.tree.FixedHeightLayoutCache;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class XPath_TimeDateTable_MultipleRow_ExcelOperation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
        String applicationURLAddress="https://www.timeanddate.com/worldclock/";
   		
   		WebDriver driver;
   		
   		//identify and lunch browser
   		System.setProperty("webdriver.edge.driver", "./NewDriverFiles/msedgedriver.exe");
   		driver=new EdgeDriver();
   		driver.get(applicationURLAddress);
   		driver.manage().window().maximize();
   		
   		//get the excel file in system
   		FileInputStream file=new FileInputStream("./src/com/WebTable_Xpath/WebTable_ExcelOperations.xlsx");
   		XSSFWorkbook workbook=new XSSFWorkbook(file);
   		XSSFSheet sheet=workbook.getSheet("Sheet1");
   		
   		
   		//identify the xpath of the table element
   		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
   		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
   		
   		String xPathPart1="/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
   		String xPathPart2="]/td[";
   		String xPathPart3="]";
   		
   		//go to every row
   		for(int i=1;i<=36;i++)
   		{
   			Row row=sheet.createRow(i);//create row
   			for(int j=1;j<=8;j++) //goto every row of its cell's
   			{
   			
   				WebElement rowCell=driver.findElement(By.xpath(" /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]"));
   				String cityNameandTime=rowCell.getText();
   				
   				//get the elements text and print
   				System.out.print(cityNameandTime+" | ");
   				
   				//export the results into excel file
   				row.createCell(j).setCellValue(rowCell.getText());
   				
   			}
   			System.out.println();
   			
   		}
	
   		FileOutputStream file1=new FileOutputStream("./src/com/WebTable_Xpath/WebTable_ExcelOperations.xlsx");
   		workbook.write(file1);

   		driver.quit();
	}


}
