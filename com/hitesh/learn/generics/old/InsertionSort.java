/**
 * 
 */
package com.hitesh.learn.generics.old;

import generics.algos.util.Helper;

/**
 * @author hitjoshi
 * @date Jan 2, 2016
 */
/*
 * 1.Sorting cards
 * 2.Cards on hand are always sorted
 * 3.A new card is drawn
 * 4.Find its position in the sorted cards at hand BY
 * 5.Loop from the card at hand towards 0 to find the position
 * 6.Keep shifting cards, Mark the final position
 * 7.Insert the card in the final position
 */

public class InsertionSort<T extends Comparable<T>>
{
	public  T[] sort(T[] a)	{
		for(int i =0;i<a.length;i++){
			T comp = a[i]; 
			int pos = i;
			for(int j =i ; j>0 && Helper.lesserThanEqTo(comp,a[j-1]);j--){
				a[j]=a[j-1];
				pos=j-1;
			}
			a[pos]=comp;
		}
		return a;
	}


	public  T[] sortDesc(T[] a) {
		for(int i =0;i<a.length;i++) {
			T comp = a[i]; 
			int pos = i;
			for(int j =i ; j>0 && Helper.gterThanEqTo(comp,a[j-1]);j--){
				a[j]=a[j-1];
				pos=j-1;
			}
			a[pos]=comp;
		}
		return a;		
	}
}
