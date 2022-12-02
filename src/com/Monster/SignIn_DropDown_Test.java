package com.Monster;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SignIn_DropDown_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String applicationUrlAddress="https://my.monsterindia.com/sponsered_popup.html";
		
		WebDriver driver;
		
		//Identify and lunch edge browser
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(applicationUrlAddress);
		
		
		
		
	}

}
