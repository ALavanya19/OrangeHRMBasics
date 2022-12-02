package com.Tsrtc;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.GetAlertText;

public class HeaderBlock {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
				String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
				
				WebDriver driver;
				
				//identify the browser
				System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
				driver=new EdgeDriver();
				
				//maximize the browser
				driver.manage().window().maximize();
				
				//lunch application
				driver.get(applicationUrlAddress);
				
				//identify the header block
				//class="menu"
				WebElement headerBlock=driver.findElement(By.className("menu"));
				
				//identify the header block links
				//identify common type for all elements
				List<WebElement>headerLinks=headerBlock.findElements(By.tagName("a"));
				//count of header block links
				int headerLinks_count=headerLinks.size();
				System.out.println("No of elements available in the TSRTC Header Block is: "+headerLinks_count);
				
				//print the link name and navigated url and title of the page
				for(int i=1;i<headerLinks_count;i++)
				{
					//HeaderBlock Link Names 
					String linkName=headerLinks.get(i).getText();
					System.out.println(i+" "+linkName);
					headerLinks.get(i).click();
					
					//get the title of navigate page
					System.out.println(driver.getTitle());
					
					//get the url of navigated page
					System.out.println(driver.getCurrentUrl());
					
					//Taking ScreenShots of Current WebPage and storing its destination path
					File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenShot, new File("./ScreenShots/TSRTC/"+linkName+".png"));
					
					//get the driver back to home page
					driver.navigate().back();
					
					//identify header block again
					headerBlock=driver.findElement(By.className("menu"));
					
					//identify header block elements again
					headerLinks=headerBlock.findElements(By.tagName("a"));
					
				}
				
				driver.quit();
				

				
	}

}
