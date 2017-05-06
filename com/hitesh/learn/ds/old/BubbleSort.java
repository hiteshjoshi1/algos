package com.hitesh.learn.ds.old;


public class BubbleSort extends Routines {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BubbleSort.sort(array);
		printRoutine(array);
	}
// compare each number with every other
// i=0 and j = a.length-1 to i+1 .. compares each element with other
// O(n^2)
	public static void sort(int [] arr)
	{
		for(int i= 0; i<arr.length;i++)
		{
			for(int j = arr.length-1;j>i+1;j--)
			{
				if(arr[i]>arr[j])
					swap(arr,i,j);
			}
		}
	}

}
