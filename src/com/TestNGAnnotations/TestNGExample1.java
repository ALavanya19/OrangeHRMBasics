package com.TestNGAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample1  {
	
  @BeforeTest
  public void beforeTestex1() {
	  
	  System.out.println("Before Test executed");
  }
  
  @AfterTest
  public void afterTestex1() {
	  System.out.println("After Test executed");
  }
}
