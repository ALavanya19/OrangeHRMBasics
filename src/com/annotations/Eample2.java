package com.annotations;

import org.testng.annotations.Test;

public class Eample2 extends Eample1 {

	@Test
	public void Test() {
		Eample1 e1=new Eample1();
		e1.Empl1();
		System.out.println("Emp1 Called");
		e1.emp12();
		System.out.println("Emp12 called");
		
	}
	
}
