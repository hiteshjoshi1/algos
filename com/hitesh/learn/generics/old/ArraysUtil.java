/**
 * 
 */
package com.hitesh.learn.generics.old;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author hitjoshi
 * @date Feb 25, 2016
 */
public class ArraysUtil
{

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.remove(5);

	}
	
	public static <T> int binarySearch(T[] a, T key, Comparator<? super T > c){
		return 0;
	}

}
