package com.RediffMail;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RediffMailDynamixXpath extends BaseTest{

	@Test
	public void createRediffmail_AccountTest() {
		
		//get the properties using dynamic xpath
		
		// attribute values is changing "name52e416f9"
		
		driver.findElement(By.xpath("//*[starts-with(@name,'name')]")).sendKeys("Aduri Lavanya");
		
		//login52e416f9
		//login1aa97ecf
		
		driver.findElement(By.xpath("//*[starts-with(@name,'login')]")).sendKeys("ALavanya@19");
		
	
		//passwd1aa97ecf
		//passwdd0bf3c4c
		
		driver.findElement(By.xpath("//*[starts-with(@name,'passwd')]")).sendKeys("dscrgd");
		
	}

}
