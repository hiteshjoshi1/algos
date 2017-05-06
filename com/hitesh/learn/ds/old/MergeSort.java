package com.hitesh.learn.ds.old;

public class MergeSort extends Routines {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int [] array = new int[]{4, 1, 7, 8, 5, 9, 9, 4, 7, 0};
		printRoutine(array);
		mergeSort(array, 0, array.length-1);
		printRoutine(array);

	}

	public static int [] mergeSort(int []a, int p, int r)
	{
		if(p<r)
		{
			int q= (int )Math.ceil((p+r)/2);
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			mergeNu(a,p,q,r);
		}
		return a;
	}

	public static void merge(int [] a, int p, int q, int r)
	{
		System.out.println("p "+p +" q "+q+" r "+r );//0,0,1
		int k = p;
		int l = p;
		int [] helper = new int[r-p+1];
		// Initialize helper
		for(int i = 0;i<helper.length;i++)
		{
			helper[i]=a[l+i];
		}
	
		
		int offset = p-0;//0
		// indices in helper
		int start = p - offset;// start in helper will always be 0
		int mid = q+1- offset;// mid passed +1- offset gives the mid off 
	

		while(start<=((q-offset)) && mid<=(r-offset))//0<0
		{
			if(helper[start]>=helper[mid])
			{
				a[k]= helper[mid];
				mid++;
			}
			else
			{
				a[k] = helper[start];
				start++;
			}
			k++;
		}
		
		while(start<=q-offset)
		{
			a[k]=helper[start];
			k++;
			start++;
		}
		while(mid<=r-offset)
		{
			a[k]= helper[mid];
			k++;
			mid++;
		}
	}
	
	public static int [] mergeNu (int []a, int p, int q, int r)
	{
		int n1= q-p+1;
		int n2 = r-q;
		int left[] = new int[n1];
		int right[] = new int [n2];
		for(int i = 0; i<n1;i++)
		{
		left[i] = a[p+i];
		}
		for(int j = 0; j<n2;j++)
		{
		right[j] = a[q+j+1];
		}
		int i =0,  j = 0; 
		for(int  k =p;k<=r ; k++)
		{
			// reaches end on left side, at max one more elements is one right
			if(i==n1)
			{
				a[k]=right[j++];				
			}
			// reaches end on right side, at max one more element on left
			else if(j == n2)
			{
				a[k]= left[i++];
			}
			else if(left[i]>right[j])
			{
				a[k]=right[j++];
			}
			else{
				a[k] = left[i++];
			}
		}
		return a;
	}
}
