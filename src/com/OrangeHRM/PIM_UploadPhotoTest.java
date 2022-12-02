package com.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PIM_UploadPhotoTest extends OrangeHRM_BaseTest {

	
	
	
	@Test(priority=1)
	public void loginTest() {
		
		System.out.println("Login");
		driver.findElement(By.id("txtUsername")).sendKeys("ALavanya19");
		driver.findElement(By.name("txtPassword")).sendKeys("ALavanya@19");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2)
	public void pimAddEmpTest() throws IOException, InterruptedException
	{
		
		WebElement pimElement=driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(pimElement).build().perform();
		
		WebElement pimAddEmpElement=driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']"));
		pimAddEmpElement.click();
		
		WebElement firstName=driver.findElement(By.xpath("//*[@name='firstName']"));
	    WebElement middleName=driver.findElement(By.xpath("//*[@name='middleName']"));
	    WebElement lastName=driver.findElement(By.xpath("//*[@name='lastName']"));
	    WebElement empIDElement=driver.findElement(By.xpath("//*[@name='employeeId']"));
	    
	    firstName.sendKeys("Nandamuri");
	    middleName.sendKeys("Tarak");
	    lastName.sendKeys("RamaRao");
	    String empId=empIDElement.getAttribute("value");
	    
	    action.sendKeys(Keys.TAB).build().perform();
	    action.sendKeys(Keys.TAB).build().perform();
	    action.sendKeys(Keys.ENTER).build().perform();
	    
	  //driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\lenovo\\Desktop\\NTR.jpg");
	    java.lang.Runtime.getRuntime().exec("./Photo/UploadPhotoAutoit.exe");
	    
	    Thread.sleep(10000);
	  //  driver.findElement(By.id("btnSave")).click();
	    
	    
		
	}
	
}
