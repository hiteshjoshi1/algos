/**
 * 
 */
package com.hitesh.learn.ds.old;

import java.lang.reflect.InvocationTargetException;

/**
 * @author hitjoshi
 *
 */
public class MaxHeaps extends Routines
{
	//static int array[] = new int[]{2, 1, 3, 3, 1, 6, 5, 8, 8, 0 };
	private static int heapsize = array.length;
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException
	{
		printRoutine(array);
		int res[] = heapSort(array);
		printRoutine(res);

/*		
		try {
			// Call using reflection in Routines, common method written in routines to print time
			Object o = printTimeToRun("algos.MaxHeaps","heapSort");
			int a[] = (int[])o;
			printRoutine(a);
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public static int leftChild(int i)
	{
		return 2*i;
	}

	public static int rightChild(int i)
	{
		return 2*i+1;		
	}

	public static int [] maxHeapify(int[]a, int i)
	{
		int left = leftChild(i);		
		int right = rightChild(i);
		int largest = 0;
		if(left < heapsize && a[left]>a[i] )
		{
			largest= left;
		}
		else
			largest= i;
		if(right<heapsize && a[right]>a[largest])
		{
			largest = right;
		}
		if(i !=largest)
		{
			swap(a,i,largest);
			return maxHeapify(a,largest);
		}
		return a;
	}
	public static int[] buildMaxHeap(int [] a)
	{

		//All Nodes from a[length/2]+1 are leafs
		for(int i = a.length/2;i>=0;i--)
		{
			maxHeapify(a, i);
		}
		return a;
	}

	public static int[] heapSort(int [] a)
	{
		a = buildMaxHeap(a);		
		int b [] = new int[a.length];
		int k =0;
		for(int i = a.length-1;i>0;i--)
		{
			b[k] = a[0];
			a[0] = a[i];
			heapsize =  heapsize-1;
			maxHeapify(a, 0);
			k++;
		}
		return b;
	}

	// Max Priority Queue
	/**
	 * Pass a Max heap to the method
	 * @param a
	 * @return
	 */
	public int getHeapMax(int[]a)
	{
		return a[0];
	}
	
	public int extractMax(int [] a)
	{
		if(heapsize<=0)
			System.out.println("heap underflow");
		int max = a[0];
		a[0] = a[heapsize];
		heapsize = heapsize-1;
		maxHeapify(a, 0);
		return max;
	}
}