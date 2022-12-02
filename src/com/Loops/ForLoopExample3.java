package com.Loops;

public class ForLoopExample3 {

	public static void main(String[] args) {
		/* pattren 1
		           2 3 
		           4 5 6
		           7 8 9 10
		           11 12 13 14 15  
		int z=1;
		for(int i=1;i<=5;i++)
		{   
			
			for(int j=0;j<i;j++)
			{
				
				System.out.print(" "+z);
				z++;
			}
			System.out.println();
			
		}*/
		
		/*  pattren 7 5 6
		            4 3 
		            2 
		 
		int z=7;
		for(int i=3;i>=0;i--)
		{
		   for(int j=0;j<i;j++) 
		   {
		   
			 System.out.print(z);
			 z--;
		   }
		   System.out.println();
		}
			
		*/
		
		/* 5th table 1*5=5
		 *           2*5=10
		
				for(int z=1;z<=10;z++)
				{
					System.out.println(z+"*"+ "5" + "="+(z*5));
				}
         */
		
		/* *
		   * * *
		   * * * *
		   * * *
		   * *
		   */
		/*for(int i=0;i<3;i++)
		{
		
		   for(int j=0;j<=i;j++)
		   {
		   
		   System.out.print("*");
		   }
		   System.out.println();
		}
		for(int i=2;i>=0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
				System.out.println();
		} */
			
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<i;j++)
			{
				System.out.print(" ");
			}
			for(int k=1;k<5-i;k++)
			{
				System.out.print("* ");
			}
			System.out.println();
			
		}
		for(int x=1;x<5;x++)
		{
			for(int y=1;y<x;y++)
			{
				System.out.print(" ");
			}
			for(int z=1;z<5;z++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	
	}
}
