package com.hitesh.learn.ds.old;
/**
 * given a integer array and a value x
 * find out if there are two integers in array whose sum is equal to x
 * @author hitjoshi
 *
 */
public class Problem2_3_7 extends Routines
{

	public static void main(String[] args)
	{
		int [] array = {5, 8, 4, 2, 8, 9, 8, 1, 0, 17}; 
		MergeSort.mergeSort(array, 0, array.length-1);
		printRoutine(array);		
		System.out.println(sumIntBetter(array, 26));

	}
	// n^2 running time, two for loops 
	public static boolean sumInt(int a[], int x)
	{

		for(int i =0; i<a.length;i++)
		{		
			for(int j = a.length-1;j>=0;j-- )
			{			
				if (i != j && (a[i]+a[j]==x)) {
					return true;
				}

			}
		}
		return false;

	}

	public static boolean sumIntBetter(int []a, int x) {
		for ( int i = 0; i<a.length;i++)
		{

			int item = x- a[i];
			System.out.println("Item  "+item);
		if(BinarySearch.binarySearch(a, item,0, a.length-1)>0) return true;
			//if(BinarySearch.binarySearch(a, item,a.length-1)>0) return true;

		}
		return false;

	}

}
