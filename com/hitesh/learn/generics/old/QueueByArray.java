/**
 * 
 */
package com.hitesh.learn.generics.old;

import java.util.Arrays;

/**
 * @author hitjoshi
 * @date Feb 4, 2016
 * Array Based QueueByArray
 */
public class QueueByArray<T>{
	private static final int INIT_CAPACITY = 5;
	private T[] a = (T[])new Object[INIT_CAPACITY];
	private int size = 0;
	private int head = 0;//queue head
	private int tail = 0;// queue bottom

	public void enQueue(T p){
		if(size == a.length){
			ensureCapacity();
		}
		size++;
		a[tail]= p;
		if(tail == a.length-1 && size!=a.length){
			tail = 0;
		}
		else{
			tail++;
		}
	}
	private void ensureCapacity(){
	// original array, truncated or padded with null to get the new Length
			a = Arrays.copyOf(a,2*a.length+1);
	}
	public T deQueue()throws Exception{
		if(size == 0){
			throw new Exception("Cannot Dequeue from an empty QueueByArray");
		}

		T temp = a[head];
		if(head == a.length -1){
			head = 0;
		}
		else{
			head = head+1;
		}
		return temp;
	}
	
	public static void main(String [] args) throws Exception{
		QueueByArray<Integer> q = new QueueByArray<Integer>();
		q.enQueue(10);
		q.enQueue(1);
		System.out.println(q.deQueue());
		q.enQueue(9);
		q.enQueue(500);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		q.enQueue(0);			
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		}	
}