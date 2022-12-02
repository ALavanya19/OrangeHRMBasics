package com.HastingsDirectApplication;

import org.openqa.selenium.edge.EdgeDriver;

public class HDTitleVerificationValidation {

	
	public static void main(String[] args) {
		
		String expected_HDTitle="hastings Direct | Car, Van, Bike and Home Insurance";
		
		//Identify browser
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		// creating Object for browser
		
		EdgeDriver edgedriver=new EdgeDriver();
		
		// Lunching Edge Browser
		
		edgedriver.get("https://hastingsdirect.com");
		
		//Get actual title of website
		
		 String actual_HDTitle=edgedriver.getTitle();
		 
		 System.out.println(actual_HDTitle);
		
		 if(actual_HDTitle.equals(expected_HDTitle))
		 {
			 System.out.println("HastingsDirect Title is same - Pass");
		 }
		 
		 else
		 {
			 System.out.println("HastingsDirect Tile is not same - Fail");
		 }
		 
		 edgedriver.quit();
		 
	}
}
