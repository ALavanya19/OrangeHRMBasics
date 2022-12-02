package com.OrangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestNG_TestCase7 extends OrangeHRM_BaseTest {


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
    
    
    @Test(priority=4)
    public void AdminUserNameEditTest() throws InterruptedException
    {
    	// /html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr[2]
    	
    	
    	//table data using static xpath 
    //	WebElement resultTable=driver.findElement(By.xpath("//table[@id='resultTable']//*[@href='saveSystemUser?userId=7']"));
      
    	//table data using dynamic xpath
    	WebElement resultTable=driver.findElement(By.xpath("//table[@id='resultTable']//*[starts-with(@href,'saveSystemUser?userId=')]"));

    	resultTable.click();
    	
    	
    	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    	
    	WebElement userRole=driver.findElement(By.id("systemUser_userType"));
    	
    	Select select=new Select(userRole);
    	select.selectByVisibleText("ESS");
    	
    	driver.findElement(By.id("btnSave")).click();
    	
    	
    }
    
    public void AdminUserNameCancelTest()
    {
    
    	//<a href="saveSystemUser?userId=5">PassPassPass3</a>
    	driver.findElement(By.xpath("//table[@id='resultTable']//td[@href='saveSystemUser?userId=5']")).click();
    	
    	driver.findElement(By.xpath("//*[@value='Cancel']")).click();
    	
    }
	
}
