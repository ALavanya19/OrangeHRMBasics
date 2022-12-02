package com.RadioButtons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest{

	
	@Test
	public void radioButtonTest() {
		
		// /html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td
		
		//Get the properties of RadioButton Block
		WebElement radioButtonBlock=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
		
		//Get RadioButton Elements which have common properties
		List<WebElement>radiobuttonlist=radioButtonBlock.findElements(By.tagName("input"));
		
		// List<WebElement>radioButtonsGroup1=radioButtonTable.findElements(By.name("group1"));
		// List<WebElement>radioButtonsGroup2=radioButtonTable.findElements(By.name("group2"));
	    //	System.out.println(radioButtonsGroup1.size());
	    //	System.out.println(radioButtonsGroup2.size());
		
		//Go to every row and get the Element
	    for(int i=0;i<radiobuttonlist.size();i++)
	    {
	    	
	    	radiobuttonlist.get(i).click();
	    	
	    	if(radiobuttonlist.get(i).isEnabled()==false)
	    	{
	    	String name=radiobuttonlist.get(i).getAttribute("value");
	    	System.out.println(radiobuttonlist.get(i).getAttribute("checked")+" "+name);
	    	}
	    	else
	    	{
	    		String name=radiobuttonlist.get(i).getAttribute("value");
		    	System.out.println(radiobuttonlist.get(i).getAttribute("checked")+" "+name);
	    	}
	    /*	//perform Radio Button Click operation
	    	radiobuttonlist.get(i).click();
	    	
	    	//Go to every Element and get the status is selected or not 
	    	for(int j=0;j<radiobuttonlist.size();j++)
	    	{
	    		//Get the Name of Radio Button
	    		String radioButtonName=radiobuttonlist.get(j).getAttribute("value");
	    		
	    		//Get the status of radio button
	    		String radioButtonStatus=radiobuttonlist.get(j).getAttribute("checked");
	    		System.out.println(radioButtonName+" "+radioButtonStatus);
	    	
	    	}
	    	System.out.println();
	    */
	    }
		
	}
}
