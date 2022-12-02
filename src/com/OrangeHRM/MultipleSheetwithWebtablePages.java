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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultipleSheetwithWebtablePages extends OrangeHRM_BaseTest {
	
	@Test(priority=1)
	public void LoginTest() {
		
	
		driver.findElement(By.id("txtUsername")).sendKeys("ALavanya19");
		driver.findElement(By.name("txtPassword")).sendKeys("ALavanya@19");
		driver.findElement(By.id("btnLogin")).click();
		

		//identify the PIM element
		WebElement pimElement=driver.findElement(By.id("menu_pim_viewPimModule"));
		//performing operation
		Actions action=new Actions(driver);
		action.moveToElement(pimElement).build().perform();
		
		//identify the  Employee List Element
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		
	}
	
	@Test(priority=2)
	public void empListTableButtonsNavigation_MultiSheets() throws IOException, InterruptedException {
		
		
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM/WebTablePagesNavigate_Excel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
	
		//get the Paging Properties
		//   /html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul
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
		
		List<WebElement>pagingNum=pagingTop.findElements(By.xpath("//ul[@class='paging top']//li"));
		System.out.println(pagingNum.size());
		int k=3;
		do
		{
			workbook.removeSheetAt(k-2);
			
			 XSSFSheet sheet=workbook.createSheet("EmpListPage"+(k-2));
				
				
				WebElement empListTable=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table"));
				
				List<WebElement>empListTableRow=empListTable.findElements(By.tagName("tr"));
				
				for(int row=0;row<empListTableRow.size();row++)
				{
					Row row1=sheet.createRow(row);
					
					
					List<WebElement>empListTableRowofCellHeader=empListTableRow.get(row).findElements(By.tagName("th"));
					
					for(int headerCell=0;headerCell<empListTableRowofCellHeader.size();headerCell++)
					{
						
						String empListTableRowofCellHeaderData=empListTableRowofCellHeader.get(headerCell).getText();
						row1.createCell(headerCell).setCellValue(empListTableRowofCellHeaderData);
						
						System.out.println("Header done");
						FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRM/WebTablePagesNavigate_Excel.xlsx");
						workbook.write(file1);
						
					}
					
					List<WebElement>empListTableRowofCellData=empListTableRow.get(row).findElements(By.tagName("td"));
					
					for(int dataCell=0;dataCell<empListTableRowofCellData.size();dataCell++)
					{
						String empListTableRowofCellData1=empListTableRowofCellData.get(dataCell).getText();
						row1.createCell(dataCell).setCellValue(empListTableRowofCellData1);
						
						System.out.println(dataCell+"data Done");
						
						FileOutputStream file1=new FileOutputStream("./src/com/OrangeHRM/WebTablePagesNavigate_Excel.xlsx");
						workbook.write(file1);
						
					}
					
				}
			
				k++;
				
				pagingTop=driver.findElement(By.xpath("//ul[@class='paging top']"));
				pagingNum=pagingTop.findElements(By.xpath("//ul[@class='paging top']//li"));
				
				WebElement links=pagingNum.get(k).findElement(By.tagName("a"));
				links.click();
				Thread.sleep(10000);
			
		}while(k<pagingNum.size()-2);
		
	
	}
    
}
