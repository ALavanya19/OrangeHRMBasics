package com.GoDaddy;

import org.apache.poi.ss.usermodel.charts.ManualLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GoDaddyTC2AllMenuLinks_Test extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//2. Test Case - Automate all the menu links of godaddy.com with Selenium.

		
		
		GoDaddyTC2AllMenuLinks_Test menulinks=new GoDaddyTC2AllMenuLinks_Test();
		
		menulinks.applicationLunch();
		
		menulinks.getMenuLinks();
		menulinks.applicationExit();
		
		
		
			
		
	}

}
