package com.hitesh.learn.problemsolving.old;
public class MissingInteger {
	
	public static void main (String[] args)
	{
		int[] array= new int[]{1,2,3,4,5,7,8,9,10};
		int auxArray[] = new int[array.length];
		
		int n=array.length+1;
		int tot = (n*(n+1))/2;
		//System.out.println(tot);
		for(int i=0;i<array.length;i++)
		{
			tot=tot-array[i];
		}
		System.out.println("missing number "+tot);
	}

}
