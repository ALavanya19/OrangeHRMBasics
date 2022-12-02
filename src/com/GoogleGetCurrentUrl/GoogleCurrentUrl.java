package com.GoogleGetCurrentUrl;

import org.openqa.selenium.edge.EdgeDriver;

public class GoogleCurrentUrl {

	public static void main(String[] args) {
		
		String applicationUrlAddress="https://google.com";
		String expected_GoogleTitle="Google";
		String expected_GoogleHomePageAddress="google.com";
		// set the properties to Browser
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		// creating object to edge browser and lunching browser
		
		EdgeDriver edgedriver=new EdgeDriver();
		
		//go to google.com
		
		edgedriver.get(applicationUrlAddress);
		
		System.out.println("Accplication URL address is: - "+applicationUrlAddress);
		// get the title of application
		
		String actual_GoogleTitle=edgedriver.getTitle();
	
		// compare expected and actual title as per customer requirement	
		if(actual_GoogleTitle.equals(expected_GoogleTitle))
		{
			System.out.println("Google Title is Matched : - Pass");
		}
		else
		{
			System.out.println("Google Title is not Matched : - Fail");
		}
		
		//get Google current URL addres
		String actual_GoogleHomepageAddress=edgedriver.getCurrentUrl();
		
		// check if actual address contains Google.com r not
		
		if(actual_GoogleHomepageAddress.contains(expected_GoogleHomePageAddress))
		{
		   System.out.println("Google Current URL address contains Google.com");
		}
		else
		{
			System.out.println("Google Current URL address does not contains Google.com");
		}
		
		edgedriver.quit();
	}
	
}
