package com.ConditionalOperator;

public class NestedIfExample {

	
	public static void main(String[] args) {
		
		String str1="i";
		String str2="Am from";
		String str3="Agraharam";
		String str4="Agraharam";
		if(str1=="I")
		{
			if(str2=="am from")
			{
				if(str3==str4)
				{
				
					System.out.println("Village");
				}
				
			}
			else
			{
				System.out.println("strings not same");
			}	
		}
		else
		{
			System.out.println("str1 strings not same");
		}
		
	}
}
