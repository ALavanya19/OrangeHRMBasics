package com.OrangeHRMTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;


public class OrangeHRM_TestNG_Login extends OrangeHRM_BaseTest{
	
	String expected_DashboardURL="dashboard";
	
	@Test(priority=1)
	public void loginTest() throws IOException {
		
		//Get the Excel file in the system
		FileInputStream file=new FileInputStream("./src/com/OrangeHRMTestNG/OrangeHRM_Login_MultipleTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet1=workbook.getSheet("Sheet1");
		
		
		int rowCount=sheet1.getLastRowNum();
		
		for(int i=1;i<rowCount+1;i++) //goes to every row in the excel
		{
		
			//identify the /user/name elements and passing keys from excel
			driver.findElement(By.id("txtUsername")).sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.name("txtPassword")).sendKeys(sheet1.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.id("btnLogin")).click();
		
			//Check URL contains DashBoard or not
			String actual_DashboardUrl=driver.getCurrentUrl();
			if(actual_DashboardUrl.contains(expected_DashboardURL))
			{
				//copy into excel
				sheet1.getRow(i).createCell(4).setCellValue("PASS");
				
				//identify the welcome admin
				driver.findElement(By.linkText("Welcome Admin")).click();
			       
			    //identify the logout
			    driver.findElement(By.linkText("Logout")).click();
			}
			else
			{
				//copy into excel
				sheet1.getRow(i).createCell(4).setCellValue("FAIL");
				//taking screenshots and saving into folder
				
				
				//Take screenshot of WebPage
				File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenShot, new File("./ScreenShots/OrangeHRMLoginFailedScreenshots/"+(sheet1.getRow(i).getCell(0).getStringCellValue()+sheet1.getRow(i).getCell(1).getStringCellValue())+".png"));
				
				//save excel file
				FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRMTestNG/OrangeHRM_Login_MultipleTestData.xlsx");
				workbook.write(file1);
				
				
	        }
			//save excel file
			FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRMTestNG/OrangeHRM_Login_MultipleTestData.xlsx");
			workbook.write(file1);	
			
	}
	}
	

}
