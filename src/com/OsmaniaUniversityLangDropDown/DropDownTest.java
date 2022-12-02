package com.OsmaniaUniversityLangDropDown;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		String applicationUrlAddress="https://www.osmania.ac.in/";
		
		WebDriver driver;
		WebElement selectLang;
		
		//identify the browser and lunch.
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		driver=new EdgeDriver();
		
		//Maximize the Window & Lunch application
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		
		//identify the header block
		selectLang=driver.findElement(By.id("gtranslate_selector"));
		
		//identify the common property type  of all elements
		List<WebElement>selectLangOptions=selectLang.findElements(By.tagName("option"));
		
		//total count of header block
		int selectLangOptions_Count=selectLangOptions.size();
		System.out.println("Total links available in header block is : "+selectLangOptions_Count);
		
	
		for(int i=0;i<selectLangOptions_Count;i++)
		{
		    //Drop Down Link Name and printing the Name 
			String linkName=selectLangOptions.get(i).getText();
			System.out.println(i+" "+linkName);
			
			//Drop Down Link Values and printing of values
			String linkNameValue=selectLangOptions.get(i).getAttribute("value");
			System.out.println(linkNameValue);	
			
			//Individual selection of links
			Select selection=new Select(selectLang);
			selection.selectByValue(linkNameValue);
			
			System.out.println(linkName+" Selected");
			
			Thread.sleep(1500);
			
			//ScreenShot of current webpage and storing into destination folder
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("./ScreenShots/OsmaniaUniversity/"+linkName+".png"));	
			
		} 
		
		//Close the application
		driver.quit();
		
	}

}
