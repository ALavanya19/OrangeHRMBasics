package com.GoDaddy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoDaddyTestCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Open Godaddy.com and Print it's Page title.
		
		String applicationUrlAddress="https://www.godaddy.com/";
		
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		driver=new EdgeDriver();
		
		driver.get(applicationUrlAddress);
		
		driver.manage().window().maximize();
		
		//get title and print it
		String goDaddyPageTitle=driver.getTitle();
		System.out.println("The Title of the GoDaddy WebPage is : "+goDaddyPageTitle);

		//get the current URL and Print it
		String goDaddyPageCurrentUrl=driver.getCurrentUrl();
		System.out.println("The Current URL address of the GoDaddy WebPage is: "+goDaddyPageCurrentUrl);

		driver.quit();
		
	}

}
