package com.HastingsDirectApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HeaderFooterLinks {
	
	public static void main(String[] args) {
		
		String applicationUrlAddress="https://www.hastingsdirect.com/";
		
		WebDriver driver;
		
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		driver=new EdgeDriver();
		
		driver.get(applicationUrlAddress);
		
		List<WebElement>totalLinks=driver.findElements(By.tagName("a"));
		
		int totalLinksCount=totalLinks.size();
		
		System.out.println("Total links is : "+totalLinksCount);
		
	/*	for(int i=0;i<totalLinksCount;i++)
		{
			if(totalLinks.get(i).isDisplayed()) {
			System.out.println(i+" "+totalLinks.get(i).getText());
		}
		}  */
		
		
		WebElement Headerlinks=driver.findElement(By.tagName("div"));
		
		List<WebElement>HeaderlinksElements=Headerlinks.findElements(By.tagName("a"));
		
		int HeaderLinksElementCount=HeaderlinksElements.size();
		
		System.out.println("Header links : "+HeaderLinksElementCount);
	}

}

