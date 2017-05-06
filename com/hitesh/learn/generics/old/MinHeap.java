/**
 * 
 */
package com.hitesh.learn.generics.old;

import generics.algos.util.Helper;

/**
 * @author hitjoshi
 * @date Jan 21, 2016
 * Intentionally made the whole API public to test from outside
 */
public class MinHeap
{
	
	public static void buildMinHeap(Comparable[]a)
	{
		for(int i= a.length/2;i>=0;i--){
			minHeapify(a, i, a.length);
		}
	}
	
	
	public static void minHeapify(Comparable[] a, int i , int heapSize){
		int l = Left(i);
		int r = right(i);
		int smallest = i;
		if(l<heapSize && Helper.lesserThanEqTo(a[l],a[i])){
			smallest = l;
		}
		if(r<heapSize && Helper.lesserThanEqTo(a[r], a[smallest])){
			smallest = r;
		}
		if(smallest != i){
			Helper.swap(a,i,smallest);
			minHeapify(a, smallest, heapSize);
		}
	}


	/**
	 * @param i
	 * @return
	 * @description 
	 * @return int
	 */
	public static int right(int i)
	{
		i<<=1;
		return i+1;
	}


	/**
	 * @param i
	 * @return
	 * @description 
	 * @return int
	 */
	public static int Left(int i)
	{
		i<<=1;
		return i+2;
	}

	public static Comparable[] minHeapSort(Comparable []a){
		buildMinHeap(a);
		int heapSize = a.length;
		for(int i=a.length-1;i>0;i--){
			Helper.swap(a, 0, i);
			heapSize--;
			minHeapify(a,0,heapSize);
		}
		return a;
	}

	
	public static void main(String[] args)
	{
//		String a [] = new String[]{"Hitesh","Rohit","Abhishek","Bum","Xander","Monisha"};
//		String [] res = (String[])MinHeap.minHeapSort(a); 
		Integer a[] = new Integer[]{3,1,4,5,9,0,7,2};
		Integer [] res = (Integer[])MinHeap.minHeapSort(a);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}	
	}
	
}
