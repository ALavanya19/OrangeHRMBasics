package com.GoDaddy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuLinksTC1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String applicationURLAddress="https:/godaddy.com/";
		
		WebDriver driver;
		String expected_GoDaddyTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";

		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		driver=new EdgeDriver();
		driver.get(applicationURLAddress);
		driver.manage().window().maximize();
		
		WebElement goDaddyDomainsElement=driver.findElement(By.id("id-d6f9deab-d554-45df-a52c-8a9ab53948b5"));
		
		goDaddyDomainsElement.click();
		
		
		WebElement goDaddyDomains_DomainNameSearch=driver.findElement(By.id("id-3a34578f-40f3-4d2f-aaa4-0a1320f3fe6a"));
		goDaddyDomains_DomainNameSearch.click();
	
		
		//get the tile of the page and validate the title
		String actual_PageTitle=driver.getTitle();
		String expected_PageTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		
		if(actual_PageTitle.equals(expected_PageTitle))
		{
			System.out.println("The Actual GoDaddy Title is matched with Expected GoDaddy Title : PASS");
		}
		else
		{
			System.out.println("The Actual GoDaddy Title is not matched with Expected GoDaddy Title : FAIL");
		}

		
		driver.quit();
		
		
	}

}
