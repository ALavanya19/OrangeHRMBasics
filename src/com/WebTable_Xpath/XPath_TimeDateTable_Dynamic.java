package com.WebTable_Xpath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class XPath_TimeDateTable_Dynamic {

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
   		
   		//get the rows into List
   		List<WebElement>rowElements=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr"));
   		
   		//go to every row
   		for(int i=0;i<=rowElements.size();i++)
   		{
   		    //identify the row of cell
   			List<WebElement>cellElement=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+(i+1)+"]/td"));
   			
   			//create the row 
   			Row row=sheet.createRow(i);
   			
   		     //go to every row of its cell's
   			for(int j=0;j<cellElement.size();j++)
   			{
   				//identify the row of its cell
   				WebElement nameAndTimeElements=rowElements.get(i).findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]"));
   			    
   				//get the text of every row of its cell element
   				String CityandTime=nameAndTimeElements.getText();
   			    System.out.print(CityandTime+"   ");
   			    
   			    //copy data into excel
   			    row.createCell(j).setCellValue(CityandTime);
   			    		
   			}
   			System.out.println();
   		}
	
   		//save the Excel
	FileOutputStream file1=new FileOutputStream("./src/com/WebTable_Xpath/WebTable_ExcelOperations.xlsx");
	workbook.write(file1);
	
	//close the application
	driver.quit();
	}
}
