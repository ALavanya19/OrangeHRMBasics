package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		//Get URL
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		String expected_OrangeHRMTitle="OrangeHRM";
		String expected_OrangeHRMHomePageURL="orangehrm-4.2.0.1";
		//Lunch Edge Browser
		System.setProperty("webdriver.edge.driver", "F:\\Automation\\Automation WorkSpace\\WebApplication\\driverfiles\\msedgedriver.exe");
		EdgeDriver edgedriver=new EdgeDriver();
		
		//Navigate to OrangeHRM application
		edgedriver.get(applicationUrlAddress);
		System.out.println("Navigated to OrangeHRM");
		
		//get Title of OrnageHRM 
		String actual_OrangeHRMTitle=edgedriver.getTitle();
		
		//compare is title is as per requirement or not
		if(actual_OrangeHRMTitle.equals(expected_OrangeHRMTitle))
		{
			System.out.println("OrangeHRM Title Matched : "+expected_OrangeHRMTitle);
		}
		else
		{
			System.out.println("OrangeHRM Title not Machted : "+actual_OrangeHRMTitle);
		}
		
		//print expected URL
		System.out.println("Orange HRM Expected Url Address : "+expected_OrangeHRMHomePageURL);
		//get the Current Url address for OrangeHRM
		String actual_OrangeHRMHomePageCurrentURL=edgedriver.getCurrentUrl();
		System.out.println("Orange HRM Current URL : "+actual_OrangeHRMHomePageCurrentURL);
		
		//Current Url contains expected URL or not
		if(actual_OrangeHRMHomePageCurrentURL.contains(expected_OrangeHRMHomePageURL))
		{
			System.out.println("OrangeHRM Url HomePage Address Matched : Pass");
		}
		else
		{
			System.out.println("OrangeHRM Url Homepage address not Matched : Fail"+expected_OrangeHRMHomePageURL);
		}
		
	
		//identify properties of Username & performing values in it
		//<input name="txtUsername" id="txtUsername" type="text">
		edgedriver.findElement(By.id("txtUsername")).sendKeys("ALavanya19");
		
		//identify properties of Password & performing values in it
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		edgedriver.findElement(By.id("txtPassword")).sendKeys("ALavanya@19");
		
		//identify properties of Login & Performing value sin it
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">x
		edgedriver.findElement(By.id("btnLogin")).click();
		
		//close the browser
		edgedriver.quit();
	}
}
