package com.hitesh.learn.ds.old;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxOfArray extends Routines
{

	private static double [] array = new double []{-100,-113,-110,-85,-105,-102,-86,-163,-81,-101,-94,-90,-101,-79,-94,-90,-297};

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	
 //have to assign explicitly
		double []array2 = convertArray(array);
		printRoutine(array2);
		// Using kadane
		double x = maxArrayKadane(array2);
		System.out.println("Kadane "+x);

		// Using recusrion
		List result = recursiveMaxSubArray(array2, 0, array2.length-1);
		int i = ((Double)result.get(0)).intValue();
		int j = ((Double)result.get(1)).intValue();
		double k =(Double) result.get(2);
		System.out.println("Max array from"+array[i-1]+ " to pos "+array[j] + "Max Sum "+ k);

	}
	// method gets a copy of array - not Original array
	private static double [] convertArray(double [] a)
	{
		double b [] = new double[a.length];
		b[0]=0;
		for(int i = 1; i<a.length;i++)
		{
			b[i]= a[i]-a [i-1];
		}
		return b;
	}

	private static List<Double> findMaxCrossingSubArray(double [] a, int low, int mid, int high )
	{
		double maxLeft = Double.NEGATIVE_INFINITY;
		double sum = 0;
		double leftSum = 0;
		for(int i = mid ; i>= low;i--)
		{
			sum = sum +a[i];
			if(sum>= leftSum)
			{
				leftSum = sum;
				maxLeft = i; 
			}
		}
		double sum2 = 0;
		double rightSum = 0;
		double maxRight = Double.NEGATIVE_INFINITY;
		for(int i = mid+1; i<= high; i++)
		{
			sum2 = sum2+a[i];
			if(sum2 >= rightSum)
			{
				rightSum = sum2;
				maxRight = i;
			}
		}
		List<Double> list = new ArrayList<Double>();
		list.add(maxLeft);
		list.add(maxRight);
		list.add(leftSum+rightSum);
		return list;
	}

	public static List recursiveMaxSubArray(double[] a, int low, int high)
	{
		//List list = new ArrayList();
		List leftSubList = new ArrayList();			
		List rightSubList = new ArrayList();		
		List crossSubList = new ArrayList();
		if(high == low)
		{
			leftSubList.add(low);
			leftSubList.add(high);
			leftSubList.add(a[low]);	
			return leftSubList;

		}
		else
		{
			int  mid = low+(high-low)/2;
			leftSubList = recursiveMaxSubArray(a, low, mid);				
			rightSubList = recursiveMaxSubArray(a, mid+1, high);		
			crossSubList = findMaxCrossingSubArray(a, low, mid, high);

		}
		if ((double)leftSubList.get(2) >= (double)rightSubList.get(2) &&  (double)leftSubList.get(2)>= (double)crossSubList.get(2))
		{
			return leftSubList;

		}

		else if((double)rightSubList.get(2) >= (double)leftSubList.get(2) &&  (double)rightSubList.get(2)>= (double)crossSubList.get(2))
		{
			return rightSubList;

		}
		else return crossSubList;

	}
	/**
	 * maintain a variable that totals the array, as soon as sum turns negative
	 * @param a
	 * @return
	 */
public static double maxArrayKadane(double []a )
{
	double max_so_far = 0;
	double max_ending_here = 0;
	int initialPoint= 0;
	int finalPoint = 0;
	for(int i = 0; i<a.length; i++)
	{
		max_ending_here = max_ending_here+a[i];
		
		 if(max_ending_here < 0)
		 {
			 max_ending_here = 0;
			 initialPoint = i;
		 }
		if(max_so_far<max_ending_here)
		{
			max_so_far = max_ending_here;
			finalPoint = i;
		}
	}
	System.out.println("In kadane Initial Point"+initialPoint+" ---Final Point--- "+finalPoint+"---Start--- "+ array[initialPoint]+ " --- End--- "+array[finalPoint] );
	return max_so_far;
}
	
}
