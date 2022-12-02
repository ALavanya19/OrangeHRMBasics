package com.GoDaddy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
		
		WebDriver driver;
	
   public void applicationLunch()
   {
	   String applicationURLaddress="https://godaddy.com/";
	   
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(applicationURLaddress);
   }
   
   public void applicationExit()
   {
	   driver.quit();
   }
	
   public void getMenuLinks() throws InterruptedException
   {
	   
	   
	 WebElement domainsElement=driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div[2]/div/ul/li[1]"));
	 domainsElement.click();
	 List<WebElement>domainsList=domainsElement.findElements(By.tagName("a"));
	 
	 
    	
	 System.out.println(domainsList.size());
	 
	 for(int i=0;i<domainsList.size();i++)
	 {
		 
		 domainsList.get(i).getText();
		 domainsList.get(i).click();
		 
	 driver.navigate().back();
		 
		 Thread.sleep(1000);
		domainsElement=driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div[2]/div/ul/li[1]"));
		
		domainsElement.click();
		
		Thread.sleep(1000);
	//	/html/body/header/div/div[1]/nav/div[2]/div/ul/li[1] 
	  
		domainsList=domainsElement.findElements(By.tagName("a"));
		
	 }
		
	}
	
	
}
