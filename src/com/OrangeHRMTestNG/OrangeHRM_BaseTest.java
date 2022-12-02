package com.OrangeHRMTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OrangeHRM_BaseTest {

	
	WebDriver driver;
	
	public String Username;
	public String Password;
	@BeforeTest
	public void orangeHRMApplicationLunch() {
		
		  String orangeHRMApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	      System.setProperty("webdriver.edge.driver", "F:\\Automation\\Automation WorkSpace\\WebApplication\\driverfiles\\msedgedriver.exe");
	      
		//  driver=new ChromeDriver();
	      driver=new EdgeDriver();
          driver.manage().window().maximize();
	      driver.get(orangeHRMApplicationUrlAddress);      
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void orangeHRMapplicationClose() {
		
		driver.quit();
	}
	
	
}
