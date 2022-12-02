package com.Loops;

import javax.swing.plaf.synth.SynthStyle;

public class ForLoopExample2 {

	public static void main(String[] args) {
		
		/* Triangle shape
		for(int a=0;a<5;a++)                    //a=1--
		{
			for(int b=0;b<=a;b++)
			{
				System.out.print("*");
			}
			System.out.println(" ");
		}
		*/
		
		// mirror traiangle
	/*	for(int a=0;a<5;a++)
		{
			for(int b=0;b<5-a;b++)
			{
				System.out.print(" ");
			}
			for(int c=0;c<=a;c++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	*/
		//hollow square
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(i==1 || i==6-1)
			
					System.out.print("*");
				else
					if(j==1 || j==6-1)
					{
						System.out.print("*");
					}
					else
					{
						System.out.print(" ");
					}
			}
			System.out.println();
		}
	
	}
	
}
