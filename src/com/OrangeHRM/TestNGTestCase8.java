package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestNGTestCase8 extends OrangeHRM_BaseTest{
	
	@Test(priority=1)
	public void LoginTest() {
		
		System.out.println("Login");
		driver.findElement(By.id("txtUsername")).sendKeys("ALavanya19");
		driver.findElement(By.name("txtPassword")).sendKeys("ALavanya@19");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2)
	public void orangeHRMAdminTest() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).build().perform();
		
	}
    @Test(priority=3)
	public void orangeHRMAdminUserManagementTest()
	{
	  
    	Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("menu_admin_UserManagement"))).build().perform();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
	}

}
