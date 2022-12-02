package com.AutomationScripts;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLunch {
     public static void main(String[] args) {
		
    	 //browser set property value for Lunch
    	 System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
    	 
    	 //creating object for chrome driver
          ChromeDriver chrome=new ChromeDriver();
          
    	 //Lunch browser
          chrome.get("https://mail.google.com");
          //closing the browser
         // chrome.close();
          chrome.quit();
          
     }

}
