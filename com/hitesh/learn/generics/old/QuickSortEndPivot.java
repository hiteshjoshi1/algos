/**
 * 
 */
package com.hitesh.learn.generics.old;

import generics.algos.util.Helper;

/**
 * @author hitjoshi
 * @date Jan 30, 2016
 * 
 */
public class QuickSortEndPivot
{

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
//		Integer a[] = new Integer[]{3,1,4,5,9,0,7,2};
		Integer a[] = new Integer[]{3,3,3,3,3,3,3,3};
		System.out.println(QuickSortEndPivot.partition(a, 0, a.length-1));
//		QuickSortEndPivot.quickSort(a, 0,a.length-1 );
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}

	}
	
	public static void quickSort(Comparable a[], int p , int r){
		if(p<r){
			int q = partition(a,p,r);
			Helper.print(a);
			quickSort(a,p,q-1);
			quickSort(a, q+1, r);
		}
	}

	public static int partition(Comparable[] a, int p, int r)
	{
		// end is the pivot
		Comparable pivot = a[r];
		
		int i = p-1;
		for(int j=p;j<r;j++){
			if(Helper.lesserThanEqTo(a[j],pivot)){
				i = i+1;
				Helper.swap(a, i, j);
			}			
		}
		Helper.swap(a, i+1, r);
		return i+1;
	}

}
