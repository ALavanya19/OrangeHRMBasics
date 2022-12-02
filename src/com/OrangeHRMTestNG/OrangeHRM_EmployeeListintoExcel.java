package com.OrangeHRMTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.annotations.Test;

public class OrangeHRM_EmployeeListintoExcel extends OrangeHRM_BaseTest {

	@Test(priority=1)
	public void LoginTest() {
		
	
		driver.findElement(By.id("txtUsername")).sendKeys("ALavanya19");
		driver.findElement(By.name("txtPassword")).sendKeys("ALavanya@19");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2)
	public void pimEmplListIntoExcelTest() throws IOException, InterruptedException {
		

		//identify the PIM element
		WebElement pimElement=driver.findElement(By.id("menu_pim_viewPimModule"));
		//performing operation
		Actions action=new Actions(driver);
		action.moveToElement(pimElement).build().perform();
		
		//identify the  Employee List Element
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		//identify the Excel file in the system
		FileInputStream file=new FileInputStream("./src/com/OrangeHRMTestNG/OrangeHRM_EmpListExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
       
	    
	    
	
		//get the Paging Properties
		WebElement pagingTop=driver.findElement(By.xpath("//ul[@class='paging top']"));
	
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[1]
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[2]
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[3]
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[4]=1
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[5]=2
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[6]=3
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[7]=4
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[8]
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[9]
		
		//identify the PagingNum in the Table
		List<WebElement>pagingNum=pagingTop.findElements(By.xpath("//ul[@class='paging top']//li"));
		
		int k=3;
		do
		{
			
			  //Create sheet with respect to Page in PagingNum
			    XSSFSheet sheet=workbook.createSheet("EmpListPage"+(k-2));
			    
				
			    //Identify the Table block Properties
				WebElement empListTable=driver.findElement(By.xpath("//table[@id='resultTable']"));	
				
				//identify the every row in table block
				List<WebElement>empListTableRow=empListTable.findElements(By.xpath("//tr"));
				
				
				//Go to Every Row of table block
				for(int row=0;row<empListTableRow.size();row++)
				{
					//create Row in the sheet
					Row row1=sheet.createRow(row);
					
					//Goes to every row and finds Header block in the table block
					List<WebElement>empListTableRowofCellHeader=empListTableRow.get(row).findElements(By.xpath("//th"));
			
					for(int headerCell=0;headerCell<empListTableRowofCellHeader.size();headerCell++)
					{
						
						//Goes to every row of the cell and gets the value
						String empListTableRowofCellHeaderData=empListTableRowofCellHeader.get(headerCell).getText();
						row1.createCell(headerCell).setCellValue(empListTableRowofCellHeaderData);
						
						//Save the File
						FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRMTestNG/OrangeHRM_EmpListExcel.xlsx");
						workbook.write(file1);
						
					}
					
					//Goes to every row and finds the No.of cells in that row
					List<WebElement>empListTableRowofCellData=empListTableRow.get(row).findElements(By.tagName("td"));
					
					for(int dataCell=0;dataCell<empListTableRowofCellData.size();dataCell++)
					{
						//Goes to every row of the cell and gets the value
						String empListTableRowofCellData1=empListTableRowofCellData.get(dataCell).getText();
						row1.createCell(dataCell).setCellValue(empListTableRowofCellData1);
						
						//save the file
						FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRMTestNG/OrangeHRM_EmpListExcel.xlsx");
						workbook.write(file1);
						
					}
					
				}
			
				//increment the page num
				k++;
				
				//identify the next element in the paging list and click on
			    WebElement links=pagingNum.get(k).findElement(By.tagName("a"));
			    links.click();
			   
			    
				//Again identify the PagingNum in the Table
				pagingTop=driver.findElement(By.xpath("//ul[@class='paging top']"));
				pagingNum=pagingTop.findElements(By.xpath("//ul[@class='paging top']//li"));
				
		}while(k<pagingNum.size()-2);
		
		//identify the welcome admin
		driver.findElement(By.linkText("Welcome Admin")).click();
			       
		//identify the logout
		driver.findElement(By.linkText("Logout")).click();
				
	
	
	}
    
}
