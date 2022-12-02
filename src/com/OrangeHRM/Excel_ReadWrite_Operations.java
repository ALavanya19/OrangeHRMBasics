package com.OrangeHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Excel_ReadWrite_Operations {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		WebDriver driver;
		String expected_OrangeHRMTitle="OrangeHRM";
		String expected_OrangeHRMUrl="orangehrm-4.2.0.1";
		String expected_LoginPanelText="LOGIN Panel";
		String expected_DashboardURL="dashboard";
		String expected_AdminText="Admin";
		String expected_PimText="PIM";
		
		//identify the browser and lunch the Orange HRM application
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		
		//identify the File in the system
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM/Excel_Operations.xlsx");
		//identify the workbook in the file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//identify the sheet in the workbook
		XSSFSheet sheet=workbook.getSheet("Sheet1");			
		
		//identify the title of the Orange HRM
		String actual_OrangeHRMTitle=driver.getTitle();
			
		if(actual_OrangeHRMTitle.equals(expected_OrangeHRMTitle))
		{
			sheet.getRow(1).createCell(2).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(2).setCellValue("FAIL");
		}
		
		
		//identify the current URL of the Orange HRM
		String actual_OrangeHRMCurrentUrl=driver.getCurrentUrl();
		if(actual_OrangeHRMCurrentUrl.contains(expected_OrangeHRMUrl))
		{
			sheet.getRow(1).createCell(3).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(3).setCellValue("FAIL");
		}
		
		
		//identify the LOGIN Panel Text
		WebElement loginPanelElement=driver.findElement(By.id("logInPanelHeading"));
		String actual_LoginPanelElementText=loginPanelElement.getText();
		if(actual_LoginPanelElementText.equals(expected_LoginPanelText))
		{
			System.out.println("Actual Text of the LOGIN Panel is matched to Expected Login Panel : PASS");
		}
		else
		{
			System.out.println("Actual Text of the LOGIN Panel is not matched to Expected Login Panel : FAIL");	
		}
		
		//identify the userName & Password in the home page		
		WebElement userName=driver.findElement(By.id("txtUsername"));
		WebElement password=driver.findElement(By.name("txtPassword"));
		WebElement submit=driver.findElement(By.id("btnLogin"));
		
		//pass the keys from the excel
		userName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		password.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		submit.click();
		
		//get the DashBoard URL
		String actual_DashboardUrl=driver.getCurrentUrl();
		if(actual_DashboardUrl.contains(expected_DashboardURL))
		{
			sheet.getRow(1).createCell(4).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(4).setCellValue("FAIL");
		}
						
		//identify the Admin Element in DashBoard Page
		WebElement adminElement=driver.findElement(By.id("menu_admin_viewAdminModule"));
		String actual_AdminText=adminElement.getText();
		if(actual_AdminText.equals(expected_AdminText))
		{
			sheet.getRow(1).createCell(5).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(5).setCellValue("FAIL");
		}
		
		//identify the PIm element
		WebElement pimElement=driver.findElement(By.id("menu_pim_viewPimModule"));
		String actual_PimText=pimElement.getText();
        if(actual_PimText.equals(expected_PimText))
        {
        	sheet.getRow(1).createCell(6).setCellValue("PASS");
        }
        else
        {
        	sheet.getRow(1).createCell(6).setCellValue("FAIL");
        }
		
		//performing operation
		Actions action=new Actions(driver);
		action.moveToElement(pimElement).build().perform();
		
		//identify the Add Employee Element
		WebElement AddEmployeeElement=driver.findElement(By.id("menu_pim_addEmployee"));
		AddEmployeeElement.click();
		
		//identify the first name middle name last name and Employee Id
		WebElement addEmpFirstNameElement=driver.findElement(By.name("firstName"));
		WebElement addEmpMiddleNameElement=driver.findElement(By.name("middleName"));
		WebElement addEmpLastNameElement=driver.findElement(By.name("lastName"));
		WebElement addEmpIdElement=driver.findElement(By.name("employeeId"));
		String expected_AddEmpID=addEmpIdElement.getAttribute("value");
		WebElement saveElement=driver.findElement(By.id("btnSave"));
		
		//get the values and excel and set the results into excel
		addEmpFirstNameElement.sendKeys(sheet.getRow(1).getCell(7).getStringCellValue());
		addEmpMiddleNameElement.sendKeys(sheet.getRow(1).getCell(8).getStringCellValue());
		addEmpLastNameElement.sendKeys(sheet.getRow(1).getCell(9).getStringCellValue());
		sheet.getRow(1).createCell(10).setCellValue(expected_AddEmpID);
	
		//click on save button
		saveElement.click();
		
		//get the first name middle name and last name  emp id values 
		WebElement personalFirstName=driver.findElement(By.id("personal_txtEmpFirstName"));
		WebElement personalMiddleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
		WebElement personalLastName=driver.findElement(By.id("personal_txtEmpLastName"));
		WebElement personalEmpId=driver.findElement(By.id("personal_txtEmployeeId"));
		
		//get the value in the firstname middle name and last name and emp id
		String actual_ValFirstName=personalFirstName.getAttribute("value");
		String actual_ValMiddleName=personalMiddleName.getAttribute("value");
		String actual_ValLastName=personalLastName.getAttribute("value");
		String actual_ValEmpID=personalEmpId.getAttribute("value");
		
		//validate the values and store results in excel
		if(actual_ValFirstName.equals(sheet.getRow(1).getCell(7).getStringCellValue()))
		{
			sheet.getRow(1).createCell(11).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(11).setCellValue("FAIL");
		}
		if(actual_ValMiddleName.equals(sheet.getRow(1).getCell(8).getStringCellValue()))
		{
			sheet.getRow(1).createCell(12).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(12).setCellValue("FAIL");
		}
		if(actual_ValLastName.equals(sheet.getRow(1).getCell(9).getStringCellValue()))
		{
			sheet.getRow(1).createCell(13).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(13).setCellValue("FAIL");
		}
		if(actual_ValEmpID.equals(sheet.getRow(1).getCell(10).getStringCellValue()))
		{
			sheet.getRow(1).createCell(14).setCellValue("PASS");	
		}
		else
		{
			sheet.getRow(1).createCell(14).setCellValue("FAIL");
		}
		
		
		//identify the welcome admin
		WebElement WelcomeAdminElement=driver.findElement(By.linkText("Welcome Admin"));
	    WelcomeAdminElement.click();
	         
	    Thread.sleep(1500);
	        
	    //identify the logout
	    WebElement LogoutElement=driver.findElement(By.linkText("Logout"));
	    LogoutElement.click();
	        
	    if(actual_OrangeHRMTitle.equals(expected_OrangeHRMTitle))
		{
			sheet.getRow(1).createCell(15).setCellValue("PASS");
		}
		else
		{
			sheet.getRow(1).createCell(15).setCellValue("FAIL");
		}
	    
	    //save the excel file     
	    FileOutputStream  outputfile=new FileOutputStream("./src/com/OrangeHRM/Excel_Operations.xlsx");
		workbook.write(outputfile);
			    
		//Close the applicarion
		driver.quit();
	}

}
