/**
 * 
 */
package com.hitesh.learn.generics.old;

import java.util.Arrays;

/**
 * @author hitjoshi
 * @date Feb 3, 2
 * 
 */
public class Stack<T>{
	private static final int INIT_CAPACITY = 3;
	private int top = 0;

	@SuppressWarnings("unchecked")
	private T[] a = (T[]) new Object[INIT_CAPACITY];

	public void push(T elem){

		if(top == a.length-1 ){
			ensureCapacity();
		}
		top++;
		a[top] = elem;

	}
	public T pop() throws Exception{
		if(top==0){
			throw new Exception("Stack is empty");
		}
		else{
			T temp = a[top];
			top--;
			return temp;
		}
	}
	public T peep(){
		return a[top];
	}
	
	public boolean isEmpty(){
		if(top ==0){
			return true;
		}
		return false;
	}

	private void ensureCapacity(){
		a = Arrays.copyOf(a, 2*top+1);

	}
	public static void main(String[] args) throws Exception
	{
		Stack<String> t = new Stack<String>();
		t.push("aaa");
		t.push("bbb");
		t.push("ccc");
		t.push("xxx");
		t.push("abc");
		int i =5;
		System.out.println(t.isEmpty());
		while(i>0){
			System.out.println(t.pop());
			i--;
		}
	
	}
}