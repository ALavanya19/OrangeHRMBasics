package com.OrangeHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_TestCase6 extends OrangeHRM_BaseTest{


	
	
	@Test(priority=1)
	public void LoginTest() {
		
		System.out.println("Login");
		driver.findElement(By.id("txtUsername")).sendKeys("ALavanya19");
		driver.findElement(By.name("txtPassword")).sendKeys("ALavanya@19");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2)
	public void orangeHRMAdminTest() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).build().perform();
		
	}
    @Test(priority=3)
	public void orangeHRMAdminUserManagementTest()
	{
	  
    	Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("menu_admin_UserManagement"))).build().perform();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
	}
    

    
    @Test(enabled=false)
    public void addSystemUser() throws IOException, InterruptedException {
    	

    	FileInputStream file=new FileInputStream("./src/com/OrangeHRM/OrangeHRM.xlsx");
    	XSSFWorkbook workbook=new XSSFWorkbook(file);
    	XSSFSheet sheet=workbook.getSheet("Admin");
    	
    
    	for(int i=2;i<sheet.getLastRowNum();i++)
    	{
    		//Click on Add Button to add System Users
        	driver.findElement(By.name("btnAdd")).click();
    
    	//Select User Role Properties and perform operation
    	Select select=new Select(driver.findElement(By.id("systemUser_userType")));
    	select.selectByVisibleText("Admin");
    	
    	//Employee Name Properties and performing soe operations
    	driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
    	
    	//UserName properties and performing some operations
    	driver.findElement(By.id("systemUser_userName")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
    	
    	//Ststus Properties and actions
    	select=new Select(driver.findElement(By.id("systemUser_status")));
    	select.selectByVisibleText("Enabled");
    	
    	//Password and confirm passwor properties and performing some operations
    	driver.findElement(By.id("systemUser_password")).sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
    	driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
    	
    	Thread.sleep(2000);
    	
    	//click on Save button
    	driver.findElement(By.className("addbutton")).click();
    	
    	Thread.sleep(2000);
    	
    	
      }
       	
    }
    
    @Test(priority=5)
    public void systemUsersResultsTableTest() throws IOException {
    	

    	FileInputStream file=new FileInputStream("./src/com/OrangeHRM/OrangeHRM.xlsx");
    	XSSFWorkbook workbook=new XSSFWorkbook(file);
    	XSSFSheet sheet=workbook.getSheet("Admin");

    	
    	//get the System Users data into excel
    	List<WebElement>resultTable=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table")).findElements(By.tagName("tr"));
    	
    	for(int i=0;i<resultTable.size();i++)
    	{
    		Row row=sheet.createRow(i+5);
    		List<WebElement>tableHeader=resultTable.get(i).findElements(By.tagName("th"));
    		for(int j=0;j<tableHeader.size();j++)
    		{
    			row.createCell(j).setCellValue(tableHeader.get(j).getText());
    		}
    		
    		List<WebElement>tableData=resultTable.get(i).findElements(By.tagName("td"));
    		for(int k=0;k<tableData.size();k++)
    		{
    			row.createCell(k).setCellValue(tableData.get(k).getText());
    		}
    		
    	}
    	
    	FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRM/OrangeHRM.xlsx");
    	workbook.write(file1);
    
    	
    }
    
 /*   @Test(priority=6)
    public void systemUserDelete() {
    	
    	
   
    	
    	driver.findElement(By.xpath("//*[@value='Delete']"));
    	
    }?*/
    
}
