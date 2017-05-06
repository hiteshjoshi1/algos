/**
 * 
 */
package com.hitesh.learn.problemsolving.old;

/**
 * To check if two strings are away by more than one character
 * i.e one can be formed by other adding, removing or 
 * inserting one character to another
 * @author hitjoshi
 * @date Mar 26, 2017
 */
public class OneAway
{

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		System.out.println(OneAway.isOneAway("apple", "aple"));

	}
	
	public static boolean isOneAway(String str1, String str2){
		int [] arr = new int[256];
		char [] c = str1.toCharArray();
		for(int i = 0; i<c.length;i++){
			int k = c[i];
			arr[k]++;
		}
		int count = 0;
		char [] c2 = str2.toCharArray();
		for(int j = 0 ; j<c2.length; j++){
			int l = c2[j];
			arr[l]--;
			if(arr[l]< 0){
				count ++;
			}			
		}
		if(count>1) return false;
		return true;
	}
}
