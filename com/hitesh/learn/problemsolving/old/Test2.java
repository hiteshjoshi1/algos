package com.hitesh.learn.problemsolving.old;


public class Test2
{
	public static void main(String[] args)
	{
//		double a = Double.parseDouble(args[0]);
//		double b = Double.parseDouble(args[1]);
//		System.out.println(check(a,b));
//		//print fibonacci series
//		int f = 0;
//		int g = 1;
//		for (int i = 0; i <= 15; i++)
//		{
//		System.out.println(f);
//		f = f + g;
//		g = f - g;
//		}	 
		
//		System.out.println(getBinary(8));

		int [][] b = new int[2][4];
		for(int i = 0;i<b.length;i++)
		{
			for(int j = 0;j<b[0].length;j++)
			{
				b[i][j]=(int)(Math.random()*100);
			}
		}
		System.out.println("Print b");
		for(int i = 0;i<b.length;i++)
		{
			for(int j = 0;j<b[0].length;j++)
			{
		System.out.println(b[i][j]);
			}
		}

// Transposing a matrix b to a			
		int a[][]=new int[b[0].length][b.length];
		for(int i = 0;i<b.length;i++)
		{
			for(int j = 0;j<b[0].length;j++)
			{
				a[j][i]= b[i][j];
			}
		}

		System.out.println("print A");		
		for(int i = 0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
		System.out.println(a[i][j]);
			}
		}

		
	}

	
	public static boolean check (double a, double b)
	{
		if(((0<a)&&(a<1))&& ((0<b)&&(b<1)))
			return true;
		else return false;

	}
	// Bullshit way to do it
	public static String getBinaryRep(int i){
		
		int k = 0;
		int[]a= new int[10];
		while(i>0)
		{
			System.out.println("I%2  "+i%2);
			a[k]=i%2;
			i=i/2;
			System.out.println("I "+i);
			k++;
		}
		String str="";
		for(int j =k;j>=0;j--)
		{
		str=str+a[j]; 
		}
		System.out.println("My Ans "+str);
		return str;
	}
	
public static String getBinary(int n)
{
	String s="";
	for(int i =n;i>0;i=i/2)
	{
		s=i%2+s;
	}
	return s;
}
}

