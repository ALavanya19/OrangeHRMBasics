package com.RadioButtons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	WebDriver driver;
	
	@BeforeTest
	
	public void setUp() {
		
		String applicationUrlAddress="https://echoecho.com/htmlforms10.htm";
		
		System.setProperty("webdriver.edge.driver", "./NewDriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		
	//	driver.quit();
	}
	
	
	
}
