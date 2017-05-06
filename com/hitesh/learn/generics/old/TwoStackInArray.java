/**
 * 
 */
package com.hitesh.learn.generics.old;

import generics.algos.util.StackEnd;

/**
 * @author hitjoshi
 * @date Feb 7, 2016
 */
public class TwoStackInArray<T>{


	public static final int INT_CAPACITY = 10;
	@SuppressWarnings("unchecked")
	T[] a = (T[]) new Object[INT_CAPACITY];
	private int top1 = 0;
	private int top2 = this.a.length-1;

	public void push(T elem, StackEnd s) throws Exception{
		if(top1== top2){
			System.out.println("Stack is full");
			throw new Exception("Stack is full");
		}
		else if(s.getValue().equals("Top1") ){
			a[top1] = elem;
			top1++;
		}
		else {
			a[top2]	= elem;
			top2--;
		}
	}

	public  T pop(StackEnd s) throws Exception{

		if(s.getValue().equals("Top1") && top1==0 ){
			throw new Exception("Stack Underflow in stack 1");
		}
		if(s.getValue().equals("Top2") && top2==a.length-1 ){
			throw new Exception("Stack Underflow in stack 2");
		}
		if(s.getValue().equals("Top1")){
			T temp = a[top1-1];
			top1--;
			return temp;
		}
		else {

			T temp = a[top2+1];
			top2++;
			return temp;
		}

	}
	//Add everything in stack1
	public void enqueue(T elem) throws Exception{
		push(elem, StackEnd.STACK1);
	}
	// if stack 2 is empty, pop everything in stack 1 to stack 2, finally pop stack 2	
	public T dequeue() throws Exception{
		if(top2==a.length-1){
			while(top1 != 0){
				T temp = pop(StackEnd.STACK1);
				push(temp, StackEnd.STACK2);
			}

		}
		T ret = pop(StackEnd.STACK2);
		return ret;
	}


	public static void main(String[] args) throws Exception
	{
		TwoStackInArray<Integer> obj = new TwoStackInArray<Integer>();
		obj.enqueue(10);
		obj.enqueue(0);
		obj.enqueue(17);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		obj.enqueue(4);
		obj.enqueue(15);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());

		//		obj.push(1,StackEnd.STACK1);
		//		obj.push(9,StackEnd.STACK1);
		//
		//
		//		obj.push(10,StackEnd.STACK2);
		//		obj.push(18, StackEnd.STACK2);
		//		System.out.println(obj.pop(StackEnd.STACK2));
		//		System.out.println(obj.pop(StackEnd.STACK1));
		//		System.out.println(obj.pop(StackEnd.STACK2));
		//		System.out.println(obj.pop(StackEnd.STACK1));
		//		System.out.println(obj.pop(StackEnd.STACK2));

	}
}
