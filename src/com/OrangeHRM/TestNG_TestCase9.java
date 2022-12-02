package com.OrangeHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class TestNG_TestCase9 extends OrangeHRM_BaseTest {

	
	Logger log=Logger.getLogger(TestNG_TestCase9.class);
	
	//FileInputStream file2=new FileInputStream(".")
	
	@Test(priority=1)
	public void LoginTest() {
		
		PropertyConfigurator.configure("Log4j.properties");
		
		driver.findElement(By.id("txtUsername")).sendKeys("ALavanya19");
		driver.findElement(By.name("txtPassword")).sendKeys("ALavanya@19");
		driver.findElement(By.id("btnLogin")).click();
		
		
	}
	
	@Test(priority=2)
	public void pimTest() throws IOException {
		
		
		//get the Add Employee Excel
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM/OrangeHRM_PIM.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("AddEmployee");	
		int lastRow=sheet.getLastRowNum();
		
		//Get the PIM properties
		WebElement pimElement=driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		
		//perform mouse over operation
		Actions action=new Actions(driver);
		action.moveToElement(pimElement).build().perform();
		
		for(int i=1;i<lastRow;i++)
		{
		//Get the Add Employee Properties and Perform click operation
		driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']")).click();
		
		//Get FirstName and Middle Name and Last Name Properties
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='middleName']")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		sheet.getRow(i).createCell(3).setCellValue(driver.findElement(By.xpath("//*[@id='employeeId']")).getAttribute("value"));
		
		driver.findElement(By.xpath("//*[@id='btnSave']")).click(); 
		
		
		}
		
		FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRM/OrangeHRM_PIM.xlsx");
		workbook.write(file1);

				
	}
	
}
