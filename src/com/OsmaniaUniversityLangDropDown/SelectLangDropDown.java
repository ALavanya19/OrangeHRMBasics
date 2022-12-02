package com.OsmaniaUniversityLangDropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectLangDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String applicationUrlAddress="https://www.osmania.ac.in/";
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(applicationUrlAddress);
		
		WebElement langDropDownElement=driver.findElement(By.id("gtranslate_selector"));
		
		List<WebElement>langDropDown=langDropDownElement.findElements(By.tagName("option"));
		
		int langDropDownCount=langDropDown.size();
		
		System.out.println("Total Count of Select Lang Drop Down is : "+langDropDownCount);
		
		for(int i=0;i<langDropDownCount;i++) {
			
			System.out.println(i+" "+langDropDown.get(i).getText());
		}
		
		
		
		driver.quit();
		
		
		
	}

}
