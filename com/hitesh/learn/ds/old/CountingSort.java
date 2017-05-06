package com.hitesh.learn.ds.old;



public class CountingSort extends Routines
{
	public static void main(String[] args)
	{
		int [] a = new int[]{2,3,4,2,1,1,3,2,};
		CountingSort obj = new CountingSort();
		int[]  res = obj.countingSort(a, 4);// input is 0-k
		for(int i =0;i<res.length;i++)
		{
			System.out.println(res[i]);
		}
	}

	public int[] countingSort(int a[], int k )
	{
		int res[] = new int[a.length];
		int temp [] = new int[k+1];
		printRoutine(a);
		for(int i = 0; i< a.length; i++ )
		{
			temp[a[i]]=temp[a[i]]+1; 
		}

		printRoutine(temp);
		for(int i = 1; i<=temp.length-1;i++)
		{
			temp[i]= temp[i-1]+temp[i];
		}

		printRoutine(temp);
		for(int i = a.length-1;i>=0;i--)
		{

			res[temp[a[i]]-1]= a[i];
			temp[a[i]]= temp[a[i]]-1;
		}
		//	int pos = 0;
		//	for(int i =0; i<temp.length;i++)
		//	{
		//		int j =0;
		//		int val = temp[i];
		//		
		//		while(j<val)
		//		{
		//			res[pos] = i;
		//			j++;
		//			pos++;
		//		}
		//		
		//	}
		return res;
	}
}
