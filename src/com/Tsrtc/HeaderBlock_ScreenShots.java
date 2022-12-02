package com.Tsrtc;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HeaderBlock_ScreenShots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
		
		WebDriver driver;
		
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(applicationUrlAddress);
		
		//Properties of HeaderElement
		WebElement headerBlock=driver.findElement(By.className("menu"));
		
		//Check the common propertiy for all elements in header block
		List<WebElement>headerElements=headerBlock.findElements(By.tagName("a"));
		

		for(int i=0;i<headerElements.size();i++)
		{
			
			String headerLinkName=headerElements.get(i).getText();
			System.out.println(i+" "+headerLinkName);
			
			//click on link
			headerElements.get(i).click();
			
			
			//Take screenshot of WebPage
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("./ScreenShots/TSRTC/"+headerLinkName+".png"));
			
			
			//driver currently move to Next Page get back the driver to current home page
			driver.navigate().back();
			
			//now driver don't have any elements again we need to find elements
			headerBlock=driver.findElement(By.className("menu"));
			
			headerElements=headerBlock.findElements(By.tagName("a"));
			
			
			
		
			
			
		}
		
		

	}

}
