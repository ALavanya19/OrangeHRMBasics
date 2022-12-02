package com.DragDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragDrop_iframe_frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String applicationUrlAddress="https://jqueryui.com/droppable/";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
		driver=new EdgeDriver();
		
		driver.get(applicationUrlAddress);
		
		driver.manage().window().maximize();
		
		//identify the frame first 
		WebElement webPageFrame=driver.findElement(By.className("demo-frame"));
		
		//driver need to switch from page to frame
		driver.switchTo().frame(webPageFrame);
		
		//identify draggable & Droppable option properties
		WebElement dragElement=driver.findElement(By.id("draggable"));
		WebElement dropElement=driver.findElement(By.id("droppable"));
		
		//drag and drop the element
		Actions action=new Actions(driver);
		action.dragAndDrop(dragElement, dropElement).build().perform();
		
		//driver is in a iframe get back again to webpage
		driver.switchTo().defaultContent();
		
		//identify the Resizzable element now
		WebElement resizableElement=driver.findElement(By.linkText("Resizable"));
		resizableElement.click();
		
		String resizableUrL=driver.getCurrentUrl();
		System.out.println(resizableUrL);
		
	//	driver.quit();
	
		
	}

}
