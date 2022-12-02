package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WelcomeAdminLogout {
	
	public static void main(String[] args) {
		
		String orangHrmApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		String expected_OrangeHrmHomePageTitle="OrangeHRM";
		String actual_OrangeHrmHomePageTitle;
		
		
		WebDriver driver;
		WebElement userName;
		WebElement password;
		WebElement login;
		WebElement welcomeAdmin;
		WebElement logout;
		
		
		//set driver properties
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		//create an object for edge driver
		driver=driver=new EdgeDriver();
		
		//Lunching application in driver
		driver.get(orangHrmApplicationUrl);
		//get the title of app
		actual_OrangeHrmHomePageTitle=driver.getTitle();
		//check wheather title is as per requirement or not
		
		if(actual_OrangeHrmHomePageTitle.equals(expected_OrangeHrmHomePageTitle))
		{
			System.out.println("Orange HRM Home Page Title is Matched : PASS "+expected_OrangeHrmHomePageTitle);
			
		}
		else
		{
			System.out.println("Ornage HRM Home Page Title is not Matched : FAIL "+expected_OrangeHrmHomePageTitle);
		}
		
		//identifying the UserName Element and inspect find its locator 
		//<input name="txtUsername" id="txtUsername" type="text">
		userName=driver.findElement(By.id("txtUsername"));
		//perform some operations in user name
		userName.sendKeys("ALavanya19");
		
		//identifying the Password and inspect its locator
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		password=driver.findElement(By.name("txtPassword"));
		//performing some operations
		password.sendKeys("ALavanya@20");
	
	//identifying the Login element and inspect its locator
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		login=driver.findElement(By.className("button"));
		//performing some operations
		login.click();
		
		//identifying the Admin and inspect its locators
		//<a href="#" id="welcome" class="panelTrigger activated-welcome">Welcome Admin</a>
		welcomeAdmin=driver.findElement(By.linkText("Welcome Admin"));
		
		//welcomeAdmin=driver.findElement(By.partialLinkText("Admin"));
		// performing some operations
		welcomeAdmin.click();
		
		//identify the logout element and inspect the properties
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		logout=driver.findElement(By.linkText("Logout"));
        // performing some operations
		logout.click();  
		
		driver.quit();
		
	}

}
