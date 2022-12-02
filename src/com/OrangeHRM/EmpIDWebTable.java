package com.OrangeHRM;

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
import org.openqa.selenium.interactions.Actions;

public class EmpIDWebTable {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		WebDriver driver;
		//identify the browser and lunch the Orange HRM application
		
		System.setProperty("webdriver.edge.driver", "F:\\Automation\\Automation WorkSpace\\WebApplication\\driverfiles\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();

		//identify the File in the system
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM/Excel_Operations.xlsx");
		//identify the workbook in the file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//identify the sheet in the workbook
		XSSFSheet sheet1=workbook.getSheet("Sheet1");	
		XSSFSheet sheet2=workbook.getSheet("Sheet2");
		
		
		//identify the userName & Password in the home page		
		driver.findElement(By.id("txtUsername")).sendKeys(sheet1.getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.name("txtPassword")).sendKeys(sheet1.getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.id("btnLogin")).click();
			

		//identify the PIM element
		WebElement pimElement=driver.findElement(By.id("menu_pim_viewPimModule"));
		//performing operation
		Actions action=new Actions(driver);
		action.moveToElement(pimElement).build().perform();
		
		//identify the  Employee List Element
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		//identify the web table in the we page
		WebElement EmpListTable=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]"));
		
		//identify the rows of webtable
		List<WebElement>rowsOfEmpIDTable=EmpListTable.findElements(By.tagName("tr"));
		
		//goes to every row of the webtable
		for( int i=0;i<rowsOfEmpIDTable.size();i++)
		{
			
			 Row row=sheet2.createRow(i);
			//identify the no of cells in a that row
			List<WebElement>cellOfRowEmpIDTable=rowsOfEmpIDTable.get(i).findElements(By.tagName("td"));
			  
			//goes to every row of its cells
			for(int j=0;j<cellOfRowEmpIDTable.size();j++)
			{
				//get the data of every row of its cell
				String cellDataOfEmpId=cellOfRowEmpIDTable.get(j).getText();
				row.createCell(j).setCellValue(cellDataOfEmpId);
			}
			//identify the no of header cells in the web table
			List<WebElement>headerBlockofEmpIDTable=rowsOfEmpIDTable.get(i).findElements(By.tagName("th"));
			//goes to every row of its cell
			for(int k=0;k<headerBlockofEmpIDTable.size();k++)
			{
				//get the data of every row of its cell in the table header block
				String headerBlockDataEmpIdTable=headerBlockofEmpIDTable.get(k).getText();
				row.createCell(k).setCellValue(headerBlockDataEmpIdTable);
			}	
		}
		
		//save the excel file     
	    FileOutputStream  outputfile=new FileOutputStream("./src/com/OrangeHRM/Excel_Operations.xlsx");
		workbook.write(outputfile);
		//identify the welcome admin
		driver.findElement(By.linkText("Welcome Admin")).click();
			         
		Thread.sleep(1500);
			        
		//identify the logout
		driver.findElement(By.linkText("Logout")).click();
		    
		//Close the applicarion
		driver.quit();
		
	}

}
