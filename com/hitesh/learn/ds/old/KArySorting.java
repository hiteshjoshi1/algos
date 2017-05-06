package com.hitesh.learn.ds.old;
/**
 * Class  takes a n*k dimensional array and outputs a single sorted  array of size n*k
 * @author hitjoshi
 */
public class KArySorting {

	public static void main(String[] args) {

		// in an array- Multi dimensional 
		int arr[][] = new int[][] {
				{1,2,3,4},
				{15,16,17,18},
				{3,3000},
				{0,3,1191,9898},
				{2, 6, 12, 34,50},
				{1, 9, 20, 1000,1200},
				{23, 34, 90,150,190},
		};
		
		//If all arrays are of same size as in merging k sorted Lists, this Step is not required
		int N=0;
		for (int row = 0; row < arr.length; row++)
		{
			N = N+arr[row].length;
		}
		KArySorting kSorting= new KArySorting();
		KArySorting.Struct structNode =  kSorting. new Struct(); 
		int[] result = structNode.kWayMerge(arr,N);
		System.out.println("Printing Final Array  "+result.length);
		for(int i=0;i<result.length;i++)
		{
			System.out.println(result[i]);
		}

	}

	class Struct
	{
		int data;
		int indexofArray;
		int indexOfNextElement;
		int size;

		private int heapSize()
		{
			return size;
		}	

		private int getLeftChild(int i)
		{
			return 2*i+1;
		}

		private int getRightChild(int i)
		{
			return 2*i+2;
		}

		public void swap( Struct[] arr, int index1, int index2) {
			Struct temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;			
		}

		public  void minHeapify( Struct arr[], int index)
		{
			int lIndex = getLeftChild(index);
			int rIndex = getRightChild(index);
			int smallest;
			if(lIndex <= heapSize() && arr[lIndex].data<arr[index].data)
			{
				smallest = lIndex;
			}
			else
			{
				smallest = index;
			}
			if(rIndex <= heapSize() && arr[rIndex].data<arr[smallest].data)
			{
				smallest = rIndex;
			}
			if(smallest != index)
			{
				swap(arr, index,smallest);
				minHeapify(arr, smallest);
			}
		}

		public void buildMinHeap(Struct[] arr)
		{
			this.size = arr.length-1;
			for(int i = (int)Math.floor(arr.length/2) ; i >= 0 ; i--)
			{			
				minHeapify(arr, i);
			}

		}

		// Returning Just the Data, i.e integer value. 
		public int[] kWayMerge( int [][] arr, int n)
		{
			int k = arr.length;
			Struct[] dataArray = new Struct[k];
			for (int i = 0; i < k; i++)
			{
				dataArray[i] = new Struct();
				dataArray[i].data = arr[i][0]; // Store the first element
				dataArray[i].indexofArray = i;  // Stores the index of array from which the elem was picked to be stored in Heap
				dataArray[i].indexOfNextElement = 1;  // Index of next element to be stored from array, default to 1st element
			}
			buildMinHeap(dataArray);

			int [] output = new int[n];// if n is size of  single array, total = n*k

			for (int count = 0; count < output.length; count++)
			{
				// Create a pointer Node Root from the top of Min Heap
				Struct root = dataArray[0];
				// Put it in final Array
				output[count] = root.data;
				// Check if the k array still has elements
				if (root.indexOfNextElement < arr[root.indexofArray].length)
				{
					// get the new Root from the Array which has prevous root
					root.data = arr[root.indexofArray][root.indexOfNextElement];
					root.indexOfNextElement += 1;

				}
				// case when one of the array has reached its end				
				else
				{			
					//Put the last data in the min heap on the Top as the array is extinguished
					dataArray[0]= dataArray[size];					
					// Reduce HeapSize
					size--;// reduce heap size
					root=	dataArray[0];
				}
				dataArray[0] = root;
				minHeapify(dataArray, 0);
			}
			return output;
		}
	}
}



