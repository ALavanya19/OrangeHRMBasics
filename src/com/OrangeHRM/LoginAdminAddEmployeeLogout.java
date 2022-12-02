package com.OrangeHRM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginAdminAddEmployeeLogout {

	
	public static void main(String[] args) throws InterruptedException {
		
	    String orangeHrmApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		String expected_OrangeHrmHomePageTitle="OrangeHRM";
	    String actual_OrangeHrmHomePageTitle;
	    String expected_OrangeHrmHomePageUrlAddress="orangehrm-4.2.0.1";
	    String actual_OrangeHrmHomePageUrlAddress;
	    String expected_OrangeHrmLoginText="LOGIN Panel";
	    String actual_OrangeHrmLoginText;
	    String expected_OrangeHrmAdminText="Admin";
	    String actual_OrangeHrmAdminText;
	    String expected_OrangeHrmPimAddEmployeePageTitle="OrangeHRM";
	    String actual_OrangeHrmPimAddEmpPageTitle;
	    String expected_OrangeHrmPimAddEmpPageFNText="Full Name";
	    String actual_OrangeHrmPimAddEmpFNText;
	    String EmployeeID;
	    String ValFirstName;
	    String ValMiddleName;
	    String ValLastName;
	    String ValEmployeeID;
	    
	    WebDriver driver;
	    WebElement actual_OrangeHrmLoginTextElement;
	    WebElement UserName;
	    WebElement Password;
	    WebElement Login;
	    WebElement actual_OrangeHrmAdminTextElement;
	    WebElement OrangeHrmPimElement;
	    WebElement PimAddEmployee;
	    WebElement OrangeHrmPimAddEmployeeFullNameElement;
	    WebElement AddEmpFirstName;
	    WebElement AddEmpMiddleName;
	    WebElement AddEmpLastName;
	    WebElement EmployeeIDElement;
	    WebElement SaveElement;
	    WebElement ValFirstNameElement;
	    WebElement ValMiddleNameElement;
	    WebElement ValLastNameElement;
	    WebElement ValEmployeeIDElement;
	    WebElement WelcomeAdminElement;
	    WebElement LogoutElement;
	    
	    //identifying the edge browser
	       System.setProperty("webdriver.edge.driver", "./driverfiles/msedgedriver.exe");
		
	    //automate the browser- create object for browser
	       driver=new EdgeDriver();
	    
	    //Maximize the browserscreen
	       driver.manage().window().maximize();
	       
		//lunch the application
	       driver.get(orangeHrmApplicationUrlAddress);
	    
	       System.out.println("Navigated to Orange HRM Login Page Application");
	       
	    //get the Title of Orange HRM application
	       actual_OrangeHrmHomePageTitle=driver.getTitle();
		
		//check expected and actual results same or not
	       if(actual_OrangeHrmHomePageTitle.equals(expected_OrangeHrmHomePageTitle))
	       {
	    	   System.out.println("The 'Expected Title-OrangeHRM' of Orange HRM application Matched - PASS ");
	       }
	       else
	       {
	    	   System.out.println("The 'Expected Title-OrangeHRM' of Orange HRM application not Matched - Fail ");
	       }
	       
	    // get the Orange HRM current Url
	       actual_OrangeHrmHomePageUrlAddress=driver.getCurrentUrl();
	       
	    //Check the Ornage HRm contains Expected URl address or not   
	       if(actual_OrangeHrmHomePageUrlAddress.contains(expected_OrangeHrmHomePageUrlAddress))
	       {
	    	   System.out.println("The Orange HRM actual URL application contains orangehrm-4.2.0.1 - PASS ");
	       }
	       else
	       {
	    	   System.out.println("The Ornage HRM actual URL application not contains orangehrm-4.2.0.1 - FAIL");
	       }
	       
	    
	    //Properties of Login Panel 
	    //<div id="logInPanelHeading">LOGIN Panel</div>   
	       actual_OrangeHrmLoginTextElement=driver.findElement(By.id("logInPanelHeading"));
	       
	    //Get the Text of the Web element of LOGIN Panel 
	       actual_OrangeHrmLoginText=actual_OrangeHrmLoginTextElement.getText();
	       
	       
	    //Check the Orange HRM Login Panel Text is Matched or not   
	       if(actual_OrangeHrmLoginText.equals(expected_OrangeHrmLoginText))
	       {
	    	   System.out.println("The Orange HRM Login 'Expected Text - LOGIN Panel 'Text is Matched - PASS");
	       }
	       else
	       {
	    	   System.out.println("The Orange HRM Login 'Expected Text -LOGIN Panel' is not Matched - FAIL");
	       }
	       
	    // Login the Application with valid data
	    // User Name :  <input name="txtUsername" id="txtUsername" type="text">
	       
	       UserName=driver.findElement(By.id("txtUsername"));
	       UserName.sendKeys("ALavanya19");
	       
	    //PassWord : <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	       Password=driver.findElement(By.name("txtPassword"));
	       Password.sendKeys("ALavanya@19");
            
	    //Login : <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">   
	       Login=driver.findElement(By.className("button"));
	       Login.click();
	
	        System.out.println("Navigated to Orange HRM Home Page");   
	        
	    // Get the Title of Orange HRM Home Page application
	       actual_OrangeHrmHomePageTitle=driver.getTitle();
	    
	    //check the displayed correct title or not
	       if(actual_OrangeHrmHomePageTitle.equals(expected_OrangeHrmHomePageTitle))
	       {
	    	   System.out.println("After Landing Orange HRM HomePage application 'Expected Title - OrangeHRM' Title  is matched - PASS");
	       }
	       else
	       {
	    	   System.out.println("After Landing Orange HRM HomePage application 'Expected Title - OrangeHRM' Title is not Matched - FAIL");
	       }
	       
	    // Get the Text of Admin in Orange HRM landed page
	    // Admin : id=menu_admin_viewAdminModule   
	       WebElement headerAdmin=driver.findElement(By.id("menu_admin_viewAdminModule"));
	       String actual_headerAminText=headerAdmin.getText();
	       if(actual_headerAminText.equals(expected_OrangeHrmAdminText))
	       {
	    	   System.out.println("After Landing Home Page 'Expected Text - Admin' Text is Matched - PASS");
	       }
	       else
	       {
	    	   System.out.println("After Landing Home Page 'Expected Text - Admin' Text is Not Matched - PASS");
	       }
	       
	       
	       OrangeHrmPimElement=driver.findElement(By.id("menu_pim_viewPimModule"));
	       OrangeHrmPimElement.click();
	       
	       System.out.println("Navigated to PIM Menu");
	      
	          
	    // get properties of Under PIM and Add Employee
	    // <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee"
	    //  id="menu_pim_addEmployee">Add Employee</a>
	          
	        PimAddEmployee=driver.findElement(By.linkText("Add Employee"));
	        PimAddEmployee.click();
	        System.out.println("Navigated to Add Employee Page");
	          
	        actual_OrangeHrmPimAddEmpPageTitle=driver.getTitle();
	        if(actual_OrangeHrmPimAddEmpPageTitle.equals(expected_OrangeHrmPimAddEmployeePageTitle))
	        {
	        	System.out.println("Navigated to Add Employee Page 'Expected Title - OrangeHRM' Title is matched - PASS");       
	         }
	        else
	          {
	        	  System.out.println("Navigated yo Add Employee Page 'Expected Title -OrangeHRM' Title not Matched - FAIL");
	          }
	          
	    //get the properties of Orange HRM--PIM--Add Employee --Full Name Text
	    //<label class="hasTopFieldHelp">Full Name</label>
	          
	        OrangeHrmPimAddEmployeeFullNameElement=driver.findElement(By.className("hasTopFieldHelp"));
	        actual_OrangeHrmPimAddEmpFNText=OrangeHrmPimAddEmployeeFullNameElement.getText();
	        if(actual_OrangeHrmPimAddEmpFNText.equals(expected_OrangeHrmPimAddEmpPageFNText))
	          {
	        	  System.out.println("The Add Employee Page 'Expected Text- Full Name' Text is Matched - PASS");
	          }
	        else
	          {
	        	  System.out.println("The Add Employee Page 'Expected Text - Full Name' Text is not Matched - FAIL");
	          }
	          
	    //creation Employee 
	    // First Name: <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
	    // Middle Name: <input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
	    //Last Name: <input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
            AddEmpFirstName=driver.findElement(By.id("firstName"));
            AddEmpMiddleName=driver.findElement(By.name("middleName"));
            
        // Taking the First Name bcoz of classname is same for first name and last name 
        //AddEmpLastName=driver.findElement(By.className("formInputText"));
            AddEmpLastName=driver.findElement(By.name("lastName"));
            AddEmpFirstName.sendKeys("APJ");
            AddEmpMiddleName.sendKeys("ABDUL");
            AddEmpLastName.sendKeys("KALAM");
	 
        //Get the Employee ID properties
        //<input class="formInputText valid" maxlength="10" type="text"
        //name="employeeId" value="0002" id="employeeId">
            EmployeeIDElement=driver.findElement(By.id("employeeId"));
            EmployeeID=EmployeeIDElement.getAttribute("value");
            System.out.println("Expected EmployeeID : "+EmployeeID);
	         
        //Click on Save 
        //<input type="button" class="" id="btnSave" value="Save">
	        SaveElement=driver.findElement(By.id("btnSave"));
	        SaveElement.click();
	        System.out.println("Clicked on Save Button -- Navigated to Personal Details Page");
	
	        
	    //Validating the FirstName, MiddleName, LastName and EmployeeID
	    //FirstName -- <input value="APJ" type="text" name="personal[txtEmpFirstName]" 
	    //class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">
	    //MiddleName -- <input value="ABDUL" type="text" name="personal[txtEmpMiddleName]" class="block default editable"
	    //maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
	    //LastName -- <input value="KALAM" type="text" name="personal[txtEmpLastName]" class="block default editable" 
	    //maxlength="30" title="Last Name" id="personal_txtEmpLastName" disabled="disabled">
	    //EmployeeID -- <input value="0004" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" 
	    //id="personal_txtEmployeeId" disabled="disabled">
	          
	        ValFirstNameElement=driver.findElement(By.id("personal_txtEmpFirstName"));
	        ValFirstName=ValFirstNameElement.getAttribute("value");
	        ValMiddleNameElement=driver.findElement(By.id("personal_txtEmpMiddleName"));
	        ValMiddleName=ValMiddleNameElement.getAttribute("value");
	        ValLastNameElement=driver.findElement(By.id("personal_txtEmpLastName"));
	        ValLastName=ValLastNameElement.getAttribute("value");
	        ValEmployeeIDElement=driver.findElement(By.id("personal_txtEmployeeId"));
	        ValEmployeeID=ValEmployeeIDElement.getAttribute("value");
	          
	          if(ValFirstName.equals("APJ"))
	          {
	        	  System.out.println("First Name Matched - PASS");
	        	  
	          }
	          else
	          {
	        	  System.out.println("First Name not Matched - FAIL");
	          }
	          if(ValMiddleName.equals("ABDUL"))
	          {
	        	  System.out.println("Middle Name Matched - PASS");
	          }
	          else
	          {
	        	  System.out.println("Middle Name not Matched - FAIL");
	          }
	          if(ValLastName.equals("KALAM"))
	          {
	        	  System.out.println("Last Name Matched - PASS");
	          }
	          else
	          {
	        	  System.out.println("Last Name not Matched - FAIL");
	          }
	          if(ValEmployeeID.equals(EmployeeID))
	          {
	        	  System.out.println("Employee ID Matched - PASS");
	          }
	          else
	          {
	        	  System.out.println("Employee ID not Matched - FAIL");
	          }
	          
	          System.out.println("Validation Successfully done");
	          
	    //Get properties of Welcome Admin
	    //<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	        WelcomeAdminElement=driver.findElement(By.linkText("Welcome Admin"));
	        WelcomeAdminElement.click();
	         
	          
	        Thread.sleep(1500);
	          
	          
	    //Logout
	    //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
	        LogoutElement=driver.findElement(By.linkText("Logout"));
	        LogoutElement.click();
	        System.out.println("Logged Out Successfully");
	          
	    //Expected Text LOGIN Panel
	 
	        if(actual_OrangeHrmLoginText.equals(expected_OrangeHrmLoginText))
		       {
		    	   System.out.println("The Orange HRM Logged out Text is Matched - PASS");
		       }
		    else
		       {
		    	   System.out.println("The Orange HRM Logged out Text is not Matched - FAIL");
		       }
	          
	    //Close the applicarion
	        driver.quit();
	
	}
	
	
	
}
