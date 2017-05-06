/**
 * 
 */
package com.hitesh.learn.problemsolving.old;

/**
 * @author hitjoshi
 * @date Mar 15, 2017
 */
public class CommonElementsTest
{

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		int a[] = new int[]{18,27,35,40,49,55,59,82,87};
		int b[] = new int[]{18,20,27,41,42,59,62,64,82};
		
		int k = 0, count = 0;
		for(int i = 0; i < a.length; i++ ){
			if(k==a.length-1) break;
			 if(a[i]>b[k]){
					while(a[i]>b[k]){
						k++;
					}
				}
			if(a[i]==b[k]){
			count++;
			
			}
			
		}

		System.out.println(count);
	}

}
