/**
 * 
 */
package com.hitesh.learn.generics.old;

/**
 * @author hitjoshi
 * @date Jan 30, 2016
 * Sorts an array , whose maximum is known beforehand
 */
public class CountingSort
{

	public static int[] sort(int []a, int k){
		int c [] = new int[k+1];
		// count the numbers 0-k and place the count in c
		for(int i = 0;i<a.length;i++){
			c[a[i]] = c[a[i]]+1;
		}
		
		// get a rolling count
		for(int i = 1; i<c.length;i++){
			c[i]=c[i]+c[i-1];
		}
		int b[] = new int[a.length];
		for(int i = a.length-1;i>=0;i--){
			b[c[a[i]]-1] = a[i];
			c[a[i]] = c[a[i]]-1;
		}
		return b;
	}
	
	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		int [] a = new int[]{2,5,3,0,2,3,0,3,7};
		a= CountingSort.sort(a,7);
		for(int i = 0;i<a.length; i++){
			System.out.println(a[i]);
		}

	}

}
