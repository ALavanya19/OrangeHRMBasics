package com.RediffMail;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Rediff_CreateAcct_FirstName extends BaseTest{
	

	@Test
	public void createAccount() {

		driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input")).sendKeys("Aduri Lavanya");
		
		
	}

}
