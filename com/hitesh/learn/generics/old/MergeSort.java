/**
 * 
 */
package com.hitesh.learn.generics.old;

import generics.algos.util.Helper;

import java.util.Comparator;

/**
 * @author hitjoshi
 * @date Jan 10, 2016
 */
public class MergeSort{

	public static Comparable[] mergeSort(Comparable []a, int p, int r)
	{
		if(p<r)
		{
			int q = (r+p)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a,p,q,r);

		}
		return a;
	}

	private static void merge(Comparable[] a, int p, int q, int r)
	{
		Comparable[] c = new Comparable[r-p+1];
		for(int i = 0;i<c.length;i++){
			c[i] = a[p+i];
		}
		int offset = p-0;
		int mid= q-p;
//		int mid = (c.length -1)/2;
		int i=0; int j = mid+1;
		r=c.length-1;
		while(i<=mid && j<=r){
			if(Helper.gterThanEqTo(c[i], c[j])){
				a[offset]=c[j];
				j++;
				offset++;
			}
			else{
				a[offset]=c[i];
				i++;
				offset++;
			}

		}
		while(i<=mid){
			a[offset]=c[i];
			i++;
			offset++;
		}
		while(j<=r){
			a[offset]=c[j]; 
			j++;
			offset++;
		}

	}
}
