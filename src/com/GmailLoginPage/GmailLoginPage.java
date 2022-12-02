package com.GmailLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLoginPage {


	public static void main(String[] args) {
		
	String googleApplicationURL="https://google.com";
	String expected_GoogleTitle="Google";
	String actual_GoogleTitle;
	String expected_GoogleSignInTitle="Sign in - Google Accounts";
	String actual_GoogleSignInTitle;
	String expected_GoogleSignInUrlAddress="accounts.google.com";
	String actual_GoogleSignInUrlAddress;
	WebDriver driver;
	WebElement googleSignIn;
	WebElement googleSignInEmailOrPhone;
	WebElement googleSignInNext;
	System.setProperty("webdriver.chrome.driver","./driverfiles/chromedriver.exe");
	driver=new ChromeDriver();
	
	driver.get(googleApplicationURL);
    actual_GoogleTitle=driver.getTitle();
	if(actual_GoogleTitle.equals(expected_GoogleTitle))
	{
		System.out.println("Google Home Page Title Matched - PASS");
	}
	else
	{
		System.out.println("Google Home Page Title Not Matched - Fail");
	}
  
	// <a class="gb_1 gb_2 gb_8d gb_8c"
	// href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;
	//continue=https://www.google.com/&amp;ec=GAZAmgQ" target="_top">Sign in</a>
	
	googleSignIn=driver.findElement(By.linkText("Sign in"));
	googleSignIn.click();
	
	actual_GoogleSignInTitle=driver.getTitle();
	if(actual_GoogleSignInTitle.equals(expected_GoogleSignInTitle))
	{
		System.out.println("Google Sign In page Title Matched - PASS");
	}
	else
	{
		System.out.println("Google Sign In Page Title not Matched - Fail");
	}
	
	actual_GoogleSignInUrlAddress=driver.getCurrentUrl();
	
	if(actual_GoogleSignInUrlAddress.contains(expected_GoogleSignInUrlAddress))
	{
		System.out.println("Google Sign In Page Url Contains - PASS"+expected_GoogleSignInUrlAddress);
	}
	else
	{
		System.out.println("Google Sign In Page Url not Contains - FAIL"+expected_GoogleSignInUrlAddress);
	}
	
	//<input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" 
	//spellcheck="false" tabindex="0" aria-label="Email or phone" name="identifier" 
	//value="" autocapitalize="none" id="identifierId" dir="ltr" data-initial-dir="ltr" 
	//data-initial-value="">
	
	googleSignInEmailOrPhone=driver.findElement(By.id("identifierId"));
	googleSignInEmailOrPhone.sendKeys("lavanyaaduri9e503");
	
	//<span jsname="V67aGc" class="VfPpkd-vQzf8d">Next</span>
	
	googleSignInNext=driver.findElement(By.className("VfPpkd-vQzf8d"));
	googleSignInNext.click();
	
	
	
	}
}
