package com.hitesh.learn.ds.old;

public class InsertionSort extends Routines {


	public static void main(String[] args) {
		System.out.println("Printing before --");
		printRoutine(array);
		insertionSort(array, 0, array.length);
		//recursiveInsertion(array,0);
		System.out.println("Printing After -- ");
		printRoutine(array);

	}
	public static void sort(int [] arr)
	{
		for(int i = 0; i < arr.length; i++ )
		{
			for(int j = i; j>0 && arr[j]>arr[j-1]; j--)
			{
				swap(arr, j, j-1);
			}
		}
	}

	public static int[] recursiveInsertion(int [] a, int len)
	{
		if(len==a.length) return a;
		for(int i = len; i>0 && a[i]<a[i-1];i--)
		{
			swap(a,i,i-1);
		}
		len++;	
		recursiveInsertion(a,len);
		return a;

	}
	
	public static void insertionSort(int[] a,int p, int r)
	{
		// sort a, starting from p and ending at r
		
		for(int x = p;x<r;x++)
		{
			
			for(int  y=p; y <= x;y++)
			{
				if(a[y]>a[x])
				{
					swap(a,y,x);
				}
							
			}
		}
	}
	
}