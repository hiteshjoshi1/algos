/**
 *
 * Determine if the given String has all unique characters  
 */
package com.hitesh.learn.problemsolving.old;

/**
 * @author hitjoshi
 * @date Mar 26, 2017
 */
public class UniqueCharacters
{

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		System.out.println(UniqueCharacters.isUnique("a quickbrownfx"));

	}
	public static boolean isUnique(String s){
		
	char [] c = s.toCharArray();
	boolean [] b = new boolean[256];

	
	for(int i = 0; i<c.length;i++){
		
		int x = c[i];
		if(b[x]){
			return false;
		}
		b[x] = true;
	}
	return true;
	}
}
