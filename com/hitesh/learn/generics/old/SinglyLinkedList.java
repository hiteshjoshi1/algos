/**
 * 
 */
package com.hitesh.learn.generics.old;

/**
 * @author hitjoshi
 * @date May 10, 2016
 * List without base array
 */
public class SinglyLinkedList<E>
{

	private Node<E> head = new Node<E>(null);
	private int size = 0;

	private static class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E e){
			this.data = e;
			this.next = null;
		}
		
		

		//getters and setters
		public E getData(){
			return this.data;
		}
		public void setData(E e){
			this.data = e;
		}
		public Node<E> getNext()
		{
			return next;
		}
		public void setNext(Node<E> next)
		{
			this.next = next;
		}
	}

	//API
	//add Node with data E  
	public void add(E data){
		Node <E> newNode = new Node<E>(data);
		newNode.next = this.head.next;
		this.head.next = newNode;
		
	}

	// check if Node with data E exists
	public E search(E data){

		Node<E> x = this.head; 
		while( x.data != data || x != null){
			x = x.next;
		}
		return x!=null?x.getData():null;
	}

	// delete node with data E
//	public E delete(E data){
//		Node<E> x = this.head; 
//		Node <E> prevNode = this.head;
//		while( x.data != data || x != null){
//			prevNode= x;
//			x = x.next;			
//		}
//		//list is empty, list has no element with data E
//		if(x==head){
//			System.out.println("List is empty/doesnot have E");
//			return null;
//		}
//		else if(x==null){
//			System.out.println("List doesnot have E");
//		}
//		else {
//			prevNode.next=x.next;
//			return x.data;
//		}
//	}

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
