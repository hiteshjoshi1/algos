package com.hitesh.learn.problemsolving.old;
// Actual array is passed 
public class TestParameter
{

	public static void main(String[] args)
	{
		TestParameter t = new TestParameter();
		t.test();
	}
	public  void test()
	{
		int [] arr = new int[]{1,2,2,3,4,2};
		alterArray(arr);
		for(int i :arr)
		{
			System.out.println(i);
		}

	}
	public  int[] alterArray(int []a )
	{
		for(int i= 0; i<a.length;i++)
		{
			a[i]=5;
		}
		return a;
	}
}
