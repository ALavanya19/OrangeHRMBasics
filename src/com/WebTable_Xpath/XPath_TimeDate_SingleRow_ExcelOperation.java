package com.WebTable_Xpath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class XPath_TimeDate_SingleRow_ExcelOperation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
 		String applicationURLAddress="https://www.timeanddate.com/worldclock/";
   		
   		WebDriver driver;
   		
   		//identify and lunch browser
   		System.setProperty("webdriver.edge.driver", "./NewDriverFiles/msedgedriver.exe");
   		driver=new EdgeDriver();
   		driver.get(applicationURLAddress);
   		driver.manage().window().maximize();
   		
   		//get teh fexcel file in system
   		FileInputStream file=new FileInputStream("./src/com/WebTable_Xpath/WebTable_ExcelOperations.xlsx");
   		XSSFWorkbook workbook=new XSSFWorkbook(file);
   		XSSFSheet sheet=workbook.getSheet("Sheet1");
   		
   		
   		//identify the element and get the xpath of table element
   		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
   		// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
   		
   		String xpathPart1="/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
   		String xpathPart2="]/td[1]";
   		for(int i=1;i<36;i++)
   		{
   		
   		WebElement rowElements=driver.findElement(By.xpath(xpathPart1+i+xpathPart2));
   		String cityName=rowElements.getText();
   		System.out.println(cityName);
   		sheet.createRow(i).createCell(0).setCellValue(cityName);
   		
   		FileOutputStream file1=new FileOutputStream("./src/com/WebTable_Xpath/WebTable_ExcelOperations.xlsx");
   		workbook.write(file1);
   		
   		
   		
   		}
   		
   		
   		driver.quit();
 

	}

}
