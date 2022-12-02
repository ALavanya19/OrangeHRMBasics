package com.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MultipleTestData_FailScreenShots {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		WebDriver driver;
		String userNamedata,passworddata;
		String expected_DashboardURL="dashboard";
		
		//identify and lunch browser
		System.setProperty("webdriver.edge.driver", "./NewDriverFiles/msedgedriver.exe");
		driver=new EdgeDriver(); 
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		
		//Get the Excel file in the system
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM/OrangeHRM_Login_MultipleTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet1=workbook.getSheet("Sheet1");
		
		//identify the last row of in the sheet1
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
			  
			    Thread.sleep(1500);
			        
			    //identify the logout
			    driver.findElement(By.linkText("Logout")).click();
			}
			else
			{
				//copy into excel
				sheet1.getRow(i).createCell(4).setCellValue("FAIL");
				//taking screenshots and saving into folder
				File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				File screenshotlocation=new File(".//ScreenShots/OrangeHRMLoginFailedScreenshots/"+(sheet1.getRow(i).getCell(0).getStringCellValue()+sheet1.getRow(i).getCell(1).getStringCellValue())+".png");
				FileUtils.copyFile(screenShot,screenshotlocation);

				//get the image
				InputStream input=new FileInputStream(".//ScreenShots/OrangeHRMLoginFailedScreenshots/"+(sheet1.getRow(i).getCell(0).getStringCellValue()+sheet1.getRow(i).getCell(1).getStringCellValue())+".png");

				//convert into byte
				byte[] bytes=IOUtils.toByteArray(input);

				//get the index on workbook
				int index=workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);


				//create canvas in sheet
				XSSFDrawing drwaing=sheet1.createDrawingPatriarch();

				//set row and col using anchor

				ClientAnchor anchor=new XSSFClientAnchor();

				anchor.setRow1(i);
				anchor.setCol1(5);

				//invoke picture into sheet
				XSSFPicture picture=drwaing.createPicture(anchor, index);
				picture.resize(1, 1);
				
			//save excel file
			FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRM/OrangeHRM_Login_MultipleTestData.xlsx");
			workbook.write(file1);
			
			}
		}
		
		//save excel file
		FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRM/OrangeHRM_Login_MultipleTestData.xlsx");
		workbook.write(file1);
		//close the application
       driver.quit();
	}

}
