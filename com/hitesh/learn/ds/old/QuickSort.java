package com.hitesh.learn.ds.old;
import java.util.Random;

/**
 * 
 */

/**
 * @author hitjoshi
 * Has 2 same quicksorts-- with last element as pivot
 * One that uses a Random element as pivot--- Fastest
 * One that uses a Median of 3 random elements as pivot
 * Sorts an array
 * 
 */
public class QuickSort extends Routines {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// if commented, the array definition in routines will come into picture
//		int array [] = new int[]{19,18,16,17,15,14,8,7,6,5,4};
//		System.out.println(array.length);
////		QuickSort qs= new QuickSort();
////		qs.quickSort(array, 0, array.length-1);
//		System.out.println("Printing Original Array ");
//		printRoutine(array);
		//array = quickSortWithLastElementAsPivot(array,0,array.length-1);
//		
modifiedQuicksort(array, 0, array.length-1, 3);
		printRoutine(array);
		//Arrays.sort(arg0, arg1, arg2, arg3)
//		
//		try {
//			// Call using reflection in Routines, common method written in routines to print time
//			Object o = printTimeToRun("algos.QuickSort","modifiedQuicksort");
//			int a[] = (int[])o;
//			printRoutine(a);
//		} catch (ClassNotFoundException | NoSuchMethodException
//				| SecurityException | InstantiationException
//				| IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	}
	
	/**
	 * Assign pivot to the last element, sort around it,and finally place pivot to its correct position and return it	
	 * @param arr
	 * @param beg
	 * @param end
	 * @return
	 */
	private static int partition(int [] arr, int beg, int end)
	{
		// assign end element as pivot
		int pivot =arr[end];
		//i is the sentinel such that for all i, a[i]<pivot, i starts from -1
		int i=beg-1;
		// j finds the position which should be swapped with i , whenever arr[j]<=pivot
		for(int j=beg;j<end;j++)
		{
			if(arr[j]<=pivot)
			{
				i=i+1;
				swap(arr, i, j);
			}
		}
		// Finally swaps the pivot to its right position, so that it maintains the property a[i]<pivot and and pivot<a[j]
		swap(arr, i+1,end);
		return i+1;

	}


	public static int [] quickSort(int[] arr,int beg,int end)
	{
		if(beg<end)
		{
			int pivot = partition(arr, beg, end);
			quickSort(arr, beg, pivot-1);
			quickSort(arr, pivot+1, end);
		}

		return arr;
	}

	private static int randomizedPartition(int [] arr, int beg, int end)
	{
		int randomPivot= random(arr,beg,end);
		swap(arr,end,randomPivot);
		return partition(arr, beg, end);
	}




	
	public static int[] placeholderQuickSort(int []a)
	{
		return randomizedQuickSort(a,0, a.length-1 );
		
	}
	static int [] quickSortWithLastElementAsPivot(int[]a,int p, int r )
	{
		// terminating condition
		if(p<r)
		{
			int pivot = pivotPartitioning(a,p,r);
			quickSortWithLastElementAsPivot(a,p , pivot-1);
			quickSortWithLastElementAsPivot(a, pivot+1, r);
		}
		return a;
	}


	private static int pivotPartitioning(int[] a, int p, int r)
	{
		int i = -1;
		int x = a[r];
		for(int j = 0;j<r;j++)
		{
			if(a[j]<=x)
			{
				i =i+1;
				swap(a,i,j);
			}
		}
		swap(a, i+1, r);
		return i+1;
	}
	
	// Most Effective
	/**
	 * Run time is 120- 140 Msecs to converge
	 * Sorting with pivot picked at random from a median of 3 random Indexes
	 * This when compared to using last element as pivot, that Algo converges at 9080 MSecs
	 * @param arr
	 * @param beg
	 * @param end
	 * @return
	 */

	public static int [] randomizedQuickSort(int[] arr,int beg,int end)
	{
		if(beg<end)
		{
			// QuickSort that uses a single Random Pivot is the fastest
			int pivot = randomizedPartition(arr, beg, end);
			randomizedQuickSort(arr, beg, pivot-1);
			randomizedQuickSort(arr, pivot+1, end);

		}
		return arr;
	}
	// Returns median of three Random array Index picked
	private static int randomMedianPartition(int [] arr, int beg, int end)
	{
		int random1= random(arr,beg,end);
		int random2= random(arr,beg,end);
		int random3= random(arr,beg,end);
		int median= Math.max(Math.min(random1,random2), Math.min(Math.max(random1,random2),random3));

		swap(arr,end,median);
		return partition(arr, beg, end);
	}

// Called for gettin a Random Pivot Or generating a pivot from three Random indexes as above
	// returns an integer between beg and end
	private static int random(int[] arr, int beg, int end) {

		Random rand = new Random();
		// random.nextInt(integer)-- returns an integer between 0(Inclusive) and Integer(Exclusive)  
		return  (rand.nextInt((end - beg)) + beg+1);
	} 

	private  static void limitedQuickSort(int[] arr,int p,int r, int t)
	{
	if(r-p>t)
	{
		int q = partition(arr, p, r);
        limitedQuickSort(arr, p, q-1, t);
        limitedQuickSort(arr, q + 1, r, t);
	}
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
	
	public static void modifiedQuicksort(int A[], int p, int r, int threshold) {
		limitedQuickSort(A, p, r, threshold);
		 insertionSort(A, p, r);
	}
}
