package com.hitesh.learn.ds.old;
import java.util.Random;



public class Program extends Routines {	
	public static void main(String[] args)
	{
		int [] arr = new int[]{ 5, 2, 4, 7, 1, 8, 0,98};
		//printAlternatesStartWithNegative(arr);
		System.out.println(arr.length);
		//printMaxAndMinElements(arr);
		System.out.println("smallest ---- "+randomizedSmallestSelect(arr, 0,arr.length-1 , 6));
		
		System.out.println("Smallest "+iterativeSmalleSelect(arr,0, arr.length-1,6));
		quicksort(arr, 0, arr.length-1);
		printRoutine(arr);
		
	}
	
	
	public static int iterativeSmalleSelect(int [] arr,int start, int end, int pos)
	{
		if(start==end)
			return arr[start];
		
		int pivot = partition(arr, start, end);		
		int k = pivot - start+1;//number of elements less then pivot, minimum could be 1, when pivot is 0
		
			System.out.println("Pivot out "+pivot);
			while(k != pos)
			{
				if(k<pos)
				{
					start = pivot+1;
					pos = pos-k;
				}
				else 
				{
					end = pivot-1;
					
				}
				pivot = partition(arr, start, end);
				k = pivot-start+1;
			}
			
			return arr[pivot];
		
		
			
		
	
	}
	
	public static int randomizedSmallestSelect(int [] a, int start, int end,int pos)
	{
		//recursion breaking condition 1
		if(start == end)
			return a[start];
		int pivot = randomPartition(a, start, end);
		//System.out.println("Start  "+start+" End  "+end+" pivot  "+pivot);
		int k = pivot-start+1;// find number of elements before pivot element, if its equal to pos , return
		
		if (pos == k) return a[pivot];
		
		else if (pos<k)
			return randomizedSmallestSelect(a, start, pivot-1, pos);
		else 	return randomizedSmallestSelect(a, pivot+1, end, pos-k);
			
	}
	
	public static int[] quicksort(int[] arr,int start, int end)
	{
		if(start < end)
		{
		 int 	pivot= randomPartition(arr, start,end);
		 quicksort(arr, start,pivot-1);
		 quicksort(arr, pivot+1,end);
		}

		return arr;
			
	}
	
	
	 static int randomPartition(int[] a, int start, int end) {
		
		int r = random(start,end); 

		//System.out.println("Random  "+r);
		// swapping with the end value for the final swap prep
		swap(a,r,end);
		
		int i = start-1;
		
		for(int j = start;j<end;j++)
		{
			if(a[j]<a[end])
			{
				i++;
				swap(a,i,j);
			}
		}
		// for this swap to work and seprate to parts around pivot , it has to be at the end
		swap(a,i+1,end);
		return i+1;
		
		
		
		
	}

	static int random(int start, int end) {
		
		return (new Random().nextInt(end-start)+start+1);
	}

	public static void printMaxAndMinElements(int[] arr)
	{
		int max = 0;
		int min = 0;
		if(arr.length==0) return;
		if(arr.length%2 !=0)
		{
			 max=min =arr[0];
		}
		else
		{
			if(arr[0]>arr[1])
			{
				max=arr[0];
				min= arr[1];
			}
			else
			{
				min=arr[0];
				max= arr[1];
			}
		}
		
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>arr[i-1])
			{
				max = arr[i]>=max?arr[i]:max;
				min = arr[i-1]<=min ?arr[i-1]:min;
			}
			else
			{				
				min = arr[i]<=min ?arr[i]:min;
				max = arr[i-1]>=max?arr[i-1]:max;
			}
				
		}
		
		System.out.println("Max   "+max);
		System.out.println("Min    "+min);
	}



	// input-- {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8},   output -{-5, 5, -2, 2, -8, 4, 7, 1, 8, 0,}  
	public static void printAlternatesStartWithNegative(int arr[])
	{
		for(int i=0; i<arr.length;i++)
		{
	
	// its even and positive----------------
			if( (i%2 == 0 && arr[i]> 0) )
			{
		// find replacement
				int j=i;
				while(j<arr.length)
				{
					if(arr[j]>= 0) 
						{
							j++;
			
						}
					else
					{
						shiftRight(arr,i,j);
						break;
					}
						
				}

				System.out.println("in if");
				printRoutine(arr);
			}
			// odd and negative
			else if(i%2!=0 && arr[i]<0)
			{

				int k=i;
				while(k<arr.length)
				{
					if(arr[k]<0)
					{
					k++;
					}
					else
					{
						shiftRight(arr, i, k);
						break;
					}
				}
			

				System.out.println("in else");
				printRoutine(arr);
			}
			
		}
		printRoutine(arr);
		
	}

	private static void shiftRight(int[] arr, int i, int j) {
		int temp = arr[j];
	for(int x = j;x>i;x--)
	{
		arr[x]=arr[x-1];
	}
	arr[i]= temp;	
	}
	
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
}
