package com.hitesh.learn.ds.old;
/**
 * 
 */

/**
 * @author hitjoshi
 *
 */
public class Heap {


	private int size = 0;
	public static int [] heapArray;

	
	public static void main(String[] args) {
		int [] heapArray = new int[]{11,2,21,13,4,1,7,6,5,34};
		
	
//			heapArray= new int[1000];
//			for(int i=0;i<heapArray.length;i++)
//			{
//				heapArray[i]=(int)(Math.random()*1000);
//			}
		
		Heap heap= new Heap();
		heap.deleteHeapNode(heapArray, 4);
		//heap.descendingHeapSort(heapArray);
		System.out.println("Final Array ");
		for(int i = 0;i<heapArray.length ; i++)
		{			
			System.out.println(heapArray[i]);
		}
	}

	private int getLeftChild(int i)
	{
		return 2*i+1;
	}

	private int getRightChild(int i)
	{
		return 2*i+2;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;			
	}
	private int heapSize()
	{
		return size;
	}
	private int getParent(int i)
	{
		return (int)Math.floor(i/2);
	}

	
	public int deleteHeapNode(int [] arr, int i)
	{
		buildMaxHeap(arr);
		System.out.println("Printing before deletion");
		for(int k=0;k<=heapSize();k++)
		{
			System.out.println(arr[k]);
		}
		int deleted=arr[i];
	
		
		arr[i]=arr[size];
		size=size-1;
		maxHeapify(arr,i);
		System.out.println("Printing after deletion");
		for(int k=0;k<=heapSize();k++)
		{
			System.out.println(arr[k]);
		}
			
//		int parent=getParent(i);
//		
//		if(arr[i]<arr[parent])
//		{
//		maxHeapify(arr,i);
//		}
//		else
//			while(i>0 && arr[i]>arr[parent])
//			{
//				swap(arr, i, parent);
//				i=parent;
//			}
//		
		return deleted;
	}

public void minHeapify(int arr[], int index)
{
	int lIndex = getLeftChild(index);
	int rIndex = getRightChild(index);
	int smallest;
	if(lIndex<= heapSize() && arr[lIndex]<arr[index])
	{
		smallest = lIndex;
	}
	else
	{
		smallest = index;
	}
	if(rIndex <= heapSize() && arr[rIndex]<arr[smallest])
	{
		smallest = rIndex;
	}
	if(smallest != index)
	{
		swap(arr, index,smallest);
		minHeapify(arr, smallest);
	}
}


public void buildMinHeap(int [] arr)
{
	this.size = arr.length-1;
	for(int i = (int)Math.floor(arr.length/2) ; i>=0 ; i--)
	{			
		minHeapify(arr, i);
	}
//	System.out.println("Min Heap has been made, now printing");
//	for(int i=0;i<arr.length;i++)
//	{
//		System.out.println(arr[i]);
//	}

}
	public void maxHeapify(int [] arr, int index)
	{		
		int lIndex = getLeftChild(index);
		int rIndex = getRightChild(index);
//		System.out.println("Index "+index+" Left Index "+lIndex+" Right Index "+rIndex);
//		System.out.println("HeapSize "+heapSize());
		int largest;
		if(lIndex<= heapSize() && arr[lIndex]>arr[index])
		{
			largest = lIndex;
		}
		else
		{
			largest = index;
		}
		if(rIndex <= heapSize() && arr[rIndex]>arr[largest])
		{
			largest = rIndex;
		}
		if(largest != index)
		{
			swap(arr, index,largest);
			maxHeapify(arr, largest);
		}

	}

	public void buildMaxHeap(int [] arr)
	{
		this.size = arr.length-1;
		for(int i = (int)Math.floor(arr.length/2) ; i>=0 ; i--)
		{			
			maxHeapify(arr, i);
		}
		System.out.println("Max Heap has been made");

	}

	public int[] heapSort(int [] arr)
	{
		buildMaxHeap(arr);
		for(int i = arr.length-1;i>=1;i--)
		{
			swap(arr,0,i);
			this.size = this.size-1;
			maxHeapify(arr, 0);
		}

		return arr;
	}

	public int[] descendingHeapSort(int [] arr)
	{
		buildMinHeap(arr);
		for(int i = arr.length-1;i>=1;i--)
		{
			swap(arr,0,i);
			this.size = this.size-1;
			minHeapify(arr, 0);
		}
		return arr;
	}
	
}
