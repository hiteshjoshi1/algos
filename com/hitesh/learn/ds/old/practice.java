package com.hitesh.learn.ds.old;

public class practice extends Routines  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr= new int[]{4,2,9,1,0};
		//System.out.println(arr.length);
		practice p = new practice();
		p.mergeSort(arr, 0,arr.length-1);
		System.out.println("Finally---------- ");
		printRoutine(arr);

	}
	
	public int[] mergeSort(int[] arr, int start, int end)
	{
		if(start<end)
		{
			int mid = start+(end- start)/2;
			mergeSort(arr, start,mid);
			mergeSort(arr,mid+1,end);
			merge(arr,start, mid,end );
		}
		
		return arr;
	}
	
	/**
	 * merge two sorted arrays
	 * @param a
	 * @param b
	 * @return
	 * 6,9
	 * mid=7
	 */
	public int [] merge(int arr[],int start, int mid, int end)
	{
		
		int offset= start-0;
		
		int [] aux = new int[(end - start)+1];
		
		// copy the subarray into the aux
		int i=start;
		int x=0;
		while(i<=end)
		{
			aux[x]=arr[i];
			i++;
			x++;
		}
		
		int q= start;
		int j=start-offset;
		
		int k = (mid+1)-offset;
		
		
		while(j<=(mid-offset) && k<=(end-offset))
		{
			if(aux[j]>=aux[k])
			{
				arr[q]=aux[k];
				k++;
			}
			else{
				arr[q]=aux[j];
				j++;
			}	
			q++;
		}
		
		printRoutine(arr);
		
		
		
	while(k<=(end-offset))
	{
		arr[q]=aux[j];
		k++;
		q++;
	}
	
	
		while(j<=(mid-offset))
		{
			arr[q]=aux[j];
			j++;
			q++;
		}


		
		return arr;
	}

}
