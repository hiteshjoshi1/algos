/**
 * 
 */
package com.hitesh.learn.generics.old;

/**
 * @author hitjoshi
 * @date Jan 2, 2016
 */
public class Helper
{

	public static boolean lesserThanEqTo(Comparable a, Comparable b){
		return a.compareTo(b)<=0;		
	}

	public static boolean gterThanEqTo(Comparable a, Comparable b){
		return a.compareTo(b)>=0;		
	}

	public static void swap(Comparable[] a, int i, int j)
	{
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;

	}
	
	public static void print(Comparable [] a){
		
		for(int i = 0; i<a.length;i++){
			System.out.print("|");
			System.out.print(a[i]);
			System.out.print("|");
		}
		System.out.println("-");
	}
}
