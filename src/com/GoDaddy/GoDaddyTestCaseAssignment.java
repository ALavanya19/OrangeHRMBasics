package com.GoDaddy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoDaddyTestCaseAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String applicationUrlAddress="https://www.godaddy.com/";
		
		WebDriver driver;
		//Lunch the browser
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		driver=new EdgeDriver();
		
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		driver.quit();

		
	}

}
