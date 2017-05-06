package com.hitesh.learn.problemsolving.old;


public class Test3 {

	//	1*2*3*4*17*18*19*20
	//	- -5*6*7*14*15*16
	//	- - - -8*9*12*13
	//	- - - - - -10*11 	
	public static void main(String[] args){
		int n =Integer.parseInt(args[0]);
		//int n = 4;
		int start = 1;
		int left = n;
		int right = n*n+1;
	
		for(int k = 1;k<=n;k++){
			int p = 0;
			int e = right;
			int run = left-start+1;
			while(start<=left){
			System.out.print(start);
			System.out.print("*");
			start++;
			}
			
			 while(p<run){
				 System.out.print(e);
				 System.out.print("*");
				 e++;
				 p++;
			 }
		System.out.println("");	 
		
		int space = n-run+1;
		int l=0;
		while(l<space)
		{
			System.out.print(" ");
			l++;
		}
		start = left+1;
		left = left + (n-k);
		right = right-(n-k);
		}
}
}
