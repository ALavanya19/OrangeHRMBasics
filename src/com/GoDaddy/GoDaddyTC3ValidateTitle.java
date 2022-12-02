package com.GoDaddy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoDaddyTC3ValidateTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String applicationURLaddress="https://godaddy.com/";
		
		WebDriver driver;
		
		
		//Set and Lunch Browser
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		driver=new EdgeDriver();
		driver.get(applicationURLaddress);
		driver.manage().window().maximize();
		
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
