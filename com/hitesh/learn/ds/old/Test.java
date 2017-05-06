package com.hitesh.learn.ds.old;



public class Test extends Routines {
	public static void main(String args[])  
	{
		int[] arr = new int [] {1, 23, 12, 9, 30, 2, 50};
		
		Test t = new Test();
		t.kLargestBubble(arr, 3);
		//System.out.println("Position is "+ t.getPos(arr, 0, arr.length-1));
		//printRoutine(t.kSmallest(arr,arr.length));
	}
	
//	For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements i.e., k = 3 then your program should print 50, 30 and 23.
	public void kLargestBubble(int a[], int k)
	{
		for(int i=0;i<k;i++)
		{
			
			for(int j=i+1;j<a.length;j++)
			{
				if (a[i]<a[j])
				{
					swap(a,i,j);
				}
			}
			printRoutine(a);

		}
		
		for(int m =0; m<k;m++)
		{
			System.out.println(a[m]);
		}
		
	}
	
	
	private int heapSize;
	public int[] kSmallest(int [] arr, int k)
	{
		int [] finalArr= new int[k];
		int i=0;
		buildMinHeap(arr);
		while(k>0)
		{
			finalArr[i]=arr[0];
			i++;
			k--;
			arr[0]= arr[heapSize];
			heapSize--;
			minHeapify(arr,0);
		}
		return finalArr;
	}	
	
	private void buildMinHeap(int[] a)
	{
		this.heapSize= a.length-1;
		for(int i = a.length/2;i>=0;i--)
		{
			minHeapify(a,i);
		}
	}
	
	private void minHeapify(int []a, int i)
	{
		int l = leftChild(i);
		int r = rightChild(i);
		int smallest=i;
		if(l<=this.heapSize && a[l]<a[i])
		{
			smallest= l;
			
		}
		if(r<= this.heapSize && a[r]<a[smallest])
		{
			smallest= r;
		}
		if(smallest != i)
		{
		swap(a,i, smallest);
		minHeapify(a, smallest);
		}
	}
	
	private int leftChild(int i)
	{
		return 2*i+1;	
	}
	private int rightChild(int i)
	{
		return 2*i+2;
	}
	
	
	private int partition(int [] a, int p, int q)
	{
		int i = p-1;
		int x = a[q];
		for(int j=p;j<q;j++)
		{
			if(a[j] <= x)
			{
				i=i+1;
				swap(a,i,j);
			}
		}
		swap(a,i+1,q);
		return i+1;
	}
	
	
	public int getPos(int a[],int beg, int end)
	{
		
		int mid= beg+(end-beg)/2;
				
		if(a.length ==0)
			return -1;
		
		else if(a[0]==1)
			return -1;
		
		else if(beg == end)
			return beg+1;
		
		else if(a[mid]== 0 && a[mid+1] == 1)
			return mid+1;
		
		else if(a[mid] == 0 && a[mid+1] == 0)
			return getPos(a,mid+1,end);
		
		else
			return getPos(a,beg,mid);
		
	}

	public int findSum(int[] arr, int x)
	{
		int [] temp = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			temp[i]= x-arr[i];
		}
		return 0;
	}
	private static int fibonacciRecusion(int number)
	{
		if(number==1 || number==2)
			return 1;

		return fibonacciRecusion(number-1)+fibonacciRecusion(number-2);

	}
}
