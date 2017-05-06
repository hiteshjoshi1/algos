/**
 * 
 */
package com.hitesh.learn.ds.old;

/**
 * @author hitjoshi
 * @date Apr 3, 2017
 */
public class DoublyList
{
	private Node head = new Node();
	private int size = 0;

	class Node{
		int data;
		Node prev = null;
		Node next = null;

		public Node(int d){
			this.data = d;
		}
		private Node(){
			Node prev = null;
			Node next = null;
	
		}
	}

	//add to end
		public void add(int d){
			Node nu = new Node(d);
				// first time
				if(this.size == 0){
					head.next = nu;
					size++;
				}
				else{
					Node t = head;
					while(t.next != null){
						t = t.next;
					}
					t.next = nu;
					nu.next = null;
					nu.prev = t;
					size++;
				}
			}
		
		public void addToPos(int d, int pos) throws Exception{
			if(pos>size){
				throw new Exception("Index Out of Bounds of the List");
			}
			// add to the end
			if(pos == size){
			this.add(d);	
			}
			else{
				Node t = head;
				for(int i = 0; i< pos;i++){
					t = t.next;
				}
				Node nu = new Node(d);
				nu.next = t.next;
				t.next.prev  = nu;
				nu.prev = t;
				t.next = nu;
				size++;
			}
			
		}
		
		public void printList(){
			if(size == 0) return;
			Node t = head.next;
			while(t != null){
				System.out.println(t.data);
				t = t.next;
			}
		}
		
		public static void main(String [] args) throws Exception{
			DoublyList l = new DoublyList();
			l.add(10);
			l.add(18);
			l.add(15);
			l.printList();
			l.addToPos(8,3);
			System.out.println("After--");
			l.printList();
		}

}
