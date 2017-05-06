/**
 * 
 */
package com.hitesh.learn.generics.old;



/**
 * @author hitjoshi
 * @date Feb 23, 2016
 * Queue is first in first out
 * 
 */
public class QueueByStack<T>
{
	
	private Stack<T> stack1= new Stack<T>();
	
	private Stack<T> stack2 = new Stack<T>();
	
	public void enQueue(T elem){
		// always push to stack 1
		stack1.push(elem);
	}
	
	public T deQueue() throws Exception{
		// push elements in stack 1 to stack 2.
		T elem= null;
		if(stack1.isEmpty() && stack2.isEmpty()){
			throw new Exception("No element in the Queue");
		}
		else if(stack2.isEmpty()){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		}
		elem = stack2.pop();	
		return elem;
	}

	public static void main(String[] args) throws Exception
	{
		QueueByStack<Integer> q = new QueueByStack<Integer>();
		q.enQueue(10);
		q.enQueue(1);	
		q.enQueue(9);
		q.enQueue(500);
		q.enQueue(0);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		q.enQueue(50);	
		System.out.println(q.deQueue());
		q.enQueue(150);	
		q.enQueue(40);	
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}
