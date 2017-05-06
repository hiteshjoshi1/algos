package com.hitesh.learn.ds.old;
import java.util.NoSuchElementException;


public class PriorityQueue {

	private int[] keyArray;
	private int size;
	
	public PriorityQueue(int initialCap)
	{
		this.keyArray= new int[initialCap+1];
		size = 0;
	}

	public static void main(String[] args) {

	}

	private int getHeapMaximum(int[] arr)
	{
		return arr[0];
	}

	public int getExtractMax(int[] arr)
	{
		if(size<0)
		{
			throw new NoSuchElementException("Priority queue underflow");
		}
		int max=arr[0];
		arr[0]=arr[size];
		size=size-1;
		Heap heap = new Heap();
		heap.maxHeapify(arr,0);
		return max;		
	}
	private int getParent(int i)
	{
		return (int)Math.floor(i/2);
	}

	/**
	 * The priority q element whose key has to be increased is identified by index, and key is the new Priority
	 */
	public void queueIncreaseKey(int [] arr, int index, int key)
	{

		if(key < arr[index])
		{
			throw new IllegalArgumentException("New Key is smaller then current key. ");
		}
		arr[index]=key;
		while(index>0 && (arr[getParent(index)])<arr[index])
		{
			Heap.swap(arr,getParent(index), index);
			index=getParent(index);
		}
	}
	
	public void insertKey(int[]arr, int key)
	{
		 size=size+1;
		 queueIncreaseKey(arr, size, key);
	}

	

}
