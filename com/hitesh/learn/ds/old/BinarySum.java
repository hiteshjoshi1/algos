package com.hitesh.learn.ds.old;

import java.util.ArrayList;
import java.util.List;

public class BinarySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a1[] =	convertToBinary(30);
		int a2[] = convertToBinary(400);
//		for(int i :a1)
//		{
//			System.out.println(i);
//		}
//
//		System.out.println("Arr 2");
//		for(int j:a2)
//		{
//			System.out.println(j);
//		}
		// Make array equal in length
		int diff= a1.length-a2.length;
		if(diff>0)
		{
			a2 = pad(a2,diff);
		}
		else
		{
			a1 = pad(a1,-diff);
		}
			
		int c[] = binaryAdd(a1,a2);
		System.out.println("Finally C in Binary--");
		for(int i =0; i<c.length;i++)
		{
			System.out.println(c[i]);
		}
		System.out.println("Converting c into Decimal---");
		int tot= 0;
		for(int i =0;i<c.length;i++)
		{
			tot= tot+(c[i]*(int)Math.pow(2,i));
		
		}
		System.out.println("Final--- "+tot);

	}

	// pad to make equal length
	// unitialized array has zeroes in it.
static int [] pad(int [] a, int padding)
{
	int temp[] = new int[a.length+padding];
	
	for(int i=0;i<a.length;i++)
	{
		temp[i]=a[i];
	}
	return temp;
}
	
	static	int[] convertToBinary(int n)
	{
		List<Integer> intList = new ArrayList<Integer>();

		for(int i = n; i>=1; i=i/2)
		{
			int rem = i%2;
			intList.add(rem);
		}
		Integer [] arr= intList.toArray(new Integer[0]);
		int [] a = new int[arr.length];

		for(int i = 0;i<arr.length;i++)
		{
			a[i]=arr[i].intValue(); 

		}
		return a;
	}

	/**
	 * Add to Binary numbers and  return the sum in an array
	 * Binary Addition
	 */
	public static int[] binaryAdd(int[] a, int [] b)
	{
		int[] c= new int [a.length+1];


		int carry = 0;
		for(int i =0; i< a.length;i++)
		{
			c[i]= (a[i]+b[i]+carry)%2;
			carry=(a[i]+b[i]+carry)/2;
		}
		c[c.length-1]= carry;
		return c;
	}

}
