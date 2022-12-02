package com.ConditionalOperator;

public class IfelseIfExample {

	public static void main(String[] args) {
		
		int var1=150;
		int var2=550;
		double var3=453.6543;
		if(var1>var2 || var1>var3)
		{
			System.out.println("var1 is greater than var2 and var3");
		}
		else
			if(var2>var3)
			{
				System.out.println("var2 is greather than var3");
			}
			else
			{
			System.out.println("var3 is greather than var1 and var2");	
			}	
	}
	
}
