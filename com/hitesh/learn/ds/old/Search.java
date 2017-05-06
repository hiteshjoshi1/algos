package com.hitesh.learn.ds.old;


public class Search {

	public static int [] array= new int[]{1,3,2}; 

	public static void main(String[] args)
	{
		Search search= new Search();
		int res=search.newBinarySearch(array, 0, array.length-1, 2);
		System.out.println("final "+res);
		
			
	}

	/**
	 * Method returns position of the item, or -1 if not found
	 * @param arr
	 * @return
	 */
	public int linearSearch(int [] arr, int elem)
	{
		int pos=-1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==elem)
				pos=i;
		}
		return pos;
	}
	
	public int binarySearch(int [] sortedArray,int start, int end, int item)
	{
		int mid = start+(end-start)/2;
		System.out.println(" "+start+" "+mid+" "+end );
		int pos=-1;
		if(start == mid || mid==end)
		{
			return -1;
		}
		 if(item == sortedArray[mid])
		 {
			 pos=mid;
		 }
		 else if(item > sortedArray[mid])
		{
		pos= binarySearch(sortedArray,mid,end,item);
		}
		else if((item < sortedArray[mid])){
		pos=binarySearch(sortedArray,start,mid,item);
		}	
		
		
		return pos;
	}
	
	/**
	 * New binary Search seraches element in anearly sorted array.
	 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
	 * @param arr
	 * @param l
	 * @param r
	 * @param x
	 * @return
	 */
public	int newBinarySearch(int arr[], int l, int r, int x)
	{
	   if (r >= l)
	   {
	        int mid = l + (r - l)/2;//2
	       // System.out.println("Mid   "+mid);
	        // If the element is present at one of the middle 3 positions
	        if (arr[mid] == x) 
	        	{return mid;
	        	}
	        	
	        if (mid > l && arr[mid-1] == x){ return (mid - 1);
	        
	        }
	        if (mid < r && arr[mid+1] == x){ return (mid + 1);
	        
	        }
	 
	        // If element is smaller than mid, then it can only be present
	        // in left subarray
	        if (arr[mid] > x){
	        	return newBinarySearch(arr, l, mid-1, x);//0,1
	        }
	 
	        // Else the element can only be present in right subarray
	        else
	        {	
	        return newBinarySearch(arr, mid+1, r, x);
	        }
	   }
	 
	   // We reach here when element is not present in array
	   return -1;
	}
	

	/**
	 * Add two n bit binary numbers, stored in two n element arrays
	 * Incomplete and wrong
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] binaryAddition(int[] a, int[] b)
	{
		int c[]=new int[Math.max(a.length, b.length)];
		int carry=0;
		int i = 0;

		while(i<=c.length)
		{

			if(a[i]+b[i]+carry==1)
			{
				c[i]=1;
				carry=0;
			}
			else if(a[i]+b[i]+carry==2)
			{
				c[i]=0;
				carry=1;
			}
			else if(a[i]+b[i]+carry == 3)
			{
				c[i]=1;
				carry=1;
			}
			else 
			{
				c[i]=0;
				carry=0;				
			}
		}

		return c;
	}

}
