package com.TestNGAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGExample2 extends TestNGExample1 {
	
	@BeforeMethod
	public void beforeMethodex2() {
		
		System.out.println("Before Method executed");
	}
	
	@AfterMethod
	public void afterMethodex2() {
		System.out.println("After Method Executed");
	}
	
	@Test
	public void testEx1() {
		System.out.println("Test case Executed");
	}
	

}
