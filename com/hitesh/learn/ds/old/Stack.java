package com.hitesh.learn.ds.old;
/**
 * Stack is LIFO.
 * @author hitjoshi
 *
 */
public class Stack {
	// initial stack size , initialized 2 zero
	private int size = -1;
	private static final int INITIAL_CAPACITY= 4;
	// Backing array with an initial capacity of 10 
	private int [] arr = new int [INITIAL_CAPACITY];
	
	public boolean isEmpty()
	{
		return size==-1 ? true:false;
	}
	
	public void push(int x)
	{
		size=size+1;
		if(size== arr.length)
		{
			//System.out.println("Resizing");
			arr = resize(arr);
		}
		//System.out.println("Pushing");
		arr[size]=x;
	}
		
	public int pop() 
	{
		if(isEmpty()) throw new Error("Stack empty, cant pop");
		
		else
		{
			size= size-1;
			return arr[size+1];
		}
		
	}
	
	private int[] resize(int [] arr)
	{
		int [] tempArr = new int[arr.length+INITIAL_CAPACITY];
		System.arraycopy(arr, 0,tempArr, 0, arr.length);
		return tempArr;
	}
	
	//Main
	
	public static void main(String[] args)
	{
		Stack stack = new Stack ();
		stack .push(21);
		stack.push(32);
		stack.push(55);
		stack.push(41);
		stack.push(71);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
	
	
}
