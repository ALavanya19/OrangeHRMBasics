package com.Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GirdExample {

	WebDriver driver;
	String orangeHRMApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@Parameters("Browser")
	@Test(priority=1)
	public void orangeHRMApplicationLunch(String browserName) throws MalformedURLException {
		
		System.out.println("Browser Name : "+browserName);
		
		DesiredCapabilities cap=null;
		if(browserName.equalsIgnoreCase("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(browserName.equalsIgnoreCase("edge")) 
		{
		    cap=DesiredCapabilities.edge();
		    cap.setBrowserName("edge");
		    cap.setPlatform(Platform.WINDOWS);
		}
		
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.111.9:5555/wd/hub"),cap);
		
		//  String orangeHRMApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	     // System.setProperty("webdriver.edge.driver", "./driverFiles/msedgedriver.exe");
	      
		//  driver=new ChromeDriver();
	    //  driver=new EdgeDriver();
          driver.manage().window().maximize();
	      driver.get(orangeHRMApplicationUrlAddress);      
	}
}
