package com.hitesh.learn.ds.old;

public class SelectionSort extends Routines {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printRoutine(array);
		array =	selectionSort(array);
		System.out.println("Final Array");
		printRoutine(array);

	}

	public static int [] selectionSort(int[] a)
	{
		// runs for arr.length -1 as the last one will already be in right place
		for(int i = 0; i< a.length-1;i++)
		{
			
			// inner loop one full iteration makes sure that the lowest element is at its right position.
			for (int j = i+1;j<a.length;j++)
			{

				if(a[i]>a[j])
				{					
					swap(a,i,j);
					//printRoutine(a);
				}
			}
			//System.out.println("One Iteration Done"+i);
		}
		return a;
	}

}
