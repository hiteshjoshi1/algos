package com.hitesh.learn.ds.old;

import java.lang.reflect.InvocationTargetException;

public class BinarySearch extends Routines
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		int [] array = {5, 8, 4, 2, 8, 9, 8, 1, 0, 17}; 

//		MergeSort.mergeSort(array, 0, array.length-1);
//		printRoutine(array);
//		int pos =  binarySearch(array, 17,0,array.length-1);
//		System.out.println("position is"+pos);
//		printRoutine(array);
		
	}
	public static int binarySearch(int []a, int e, int l, int r)
	{
		
		if(l>r)return -1;// not found, greater then last element of sorted array
		int mid = l+ (r-l)/2;
		
		if(e == a[mid])
			return mid;
		else if(e<a[mid])
		{
			r= mid-1;
			return 	binarySearch(a, e, l,r);
		}
		else
		{
			l= mid+1;
			return binarySearch(a, e, l,r);
		}
	}
}
