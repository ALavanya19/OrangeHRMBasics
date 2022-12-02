package com.RediffMail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		String applicationUrlAddress="https://register.rediff.com/register/register.php?FormName=user_details";
		System.setProperty("webdriver.edge.driver", "./NewDriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(applicationUrlAddress);
		
	}

	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
		
	}
	
	
	
	
	
}
