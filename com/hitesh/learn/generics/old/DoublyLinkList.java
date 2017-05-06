/**
 * 
 */
package com.hitesh.learn.generics.old;


/**
 * @author hitjoshi
 * @date Mar 2, 2016
 * Implementation of a doubly linked list
 */
public class DoublyLinkList<E> implements MyList<E>
{
	private Node<E> start=null;
	private Node<E> end = null;
	private int size = 0;

	// static inner class - linked with DoublyLinkList<E>
	// and hence does not hide type parameter
	private static class Node<E>{
		E e;
		public Node(E f){
			this.e=f;
		}
		Node<E> prevNode = null;
		Node<E> nextNode = null;
		public E getE()
		{
			return e;
		}
		public void setE(E e)
		{
			this.e = e;
		}			
	}
	public void add(E e){
		DoublyLinkList.Node<E> newNode = new DoublyLinkList.Node<E>(e);
		if(size==0){
			start = newNode;
			end = newNode;
			size++;
		}
		else{
			end.nextNode=newNode;			
			newNode.prevNode=end;
			end=newNode;		
			size++;
		}
	}

	public E get(int i) throws IndexOutOfBoundsException{
		if(i>size || i<0){
			throw new IndexOutOfBoundsException("Out of bounds");
		}
		DoublyLinkList.Node<E> node= start;
		while(i>0){
			node=node.nextNode;
			i--;
		}

		return node.getE();
	}

	public void add(E e, int loc) throws IndexOutOfBoundsException{
		if(loc>size || loc<0){
			throw new IndexOutOfBoundsException("Out of bounds");
		}
		DoublyLinkList.Node<E> newNode = new DoublyLinkList.Node<E>(e);	
		DoublyLinkList.Node<E> node= start;
		if(loc!=0){
			while(--loc>0){
				node=node.nextNode;

			}
			// cur node next points to new.next
			newNode.nextNode = node.nextNode;
			node.nextNode.prevNode =newNode;	
			newNode.prevNode = node;
			node.nextNode=newNode;
			size++;
		}
		else{
			newNode.prevNode=null;
			newNode.nextNode=start;
			start.prevNode = newNode;
			start=newNode;
			size++;
		}

	}
	public boolean remove(Object e)throws IndexOutOfBoundsException{
		boolean found = false;
		if(size==0){
			throw new IndexOutOfBoundsException("List is empty");
		}
		else{
			Node<E> node = start;
			while(node.nextNode!=null){
				if(node.e.equals(e)){
					found = true;
					break;
				}
			}
			if(found){
				node.prevNode.nextNode = node.nextNode;
				node.nextNode.prevNode=node.prevNode;		
			}
			size--;
			return found;
		}

	}

	public E remove(int index) throws IndexOutOfBoundsException{
		if(index<1 || index>size){
			throw new IndexOutOfBoundsException("Out of bounds "+index);
		}
		else{
			Node<E> node = start;
			while(--index>0){
				node = node.nextNode;
			}
			Node<E> prevNode = node.prevNode;
			Node<E> nextNode = node.nextNode;
			if(prevNode !=null){
				prevNode.nextNode = nextNode;
			}
			else{
				start=node.nextNode;
			}
			if(nextNode!=null){
				nextNode.prevNode = prevNode;
			}
			else{
				end=prevNode;
			}
			//			node.prevNode.nextNode = node.nextNode;
			//			node.nextNode.prevNode=node.prevNode;
			size--;
			return node.getE();
		}
	}


	//adhoc method
	public void printThisList(){
		int i = size;
		Node<E> node = start;
		while(i>0){
			System.out.println(node.getE());
			node = node.nextNode;
			i--;
		}
	}
	public void printThisListReverse(){
		int i = size;
		Node<E> node = end;
		while(i>0){
			System.out.println(node.getE());
			node = node.prevNode;
			i--;
		}

	}


	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		DoublyLinkList<Integer> list = new DoublyLinkList<Integer>();
		list.add(20);
		list.add(50);
		list.add(70);
		list.add(95);
		list.add(4, 0);
		list.add(10,3);
		list.printThisList();
		//		System.out.println("Reverese");
		//		list.printThisListReverse();

		System.out.println("removing "+list.remove(6));
		System.out.println("After Remove");
		list.printThisList();
		list.removeAll();
		System.out.println("Size "+list.size);
//		java.util.LinkedList<String> listT = null;
//		listT.clear();
	}

	/* (non-Javadoc)
	 * @see generics.algos.datastructures.MyList#removeAll()
	 */
	@Override
	public void removeAll()
	{	
		
		for(Node<E> x = this.start;x!=null;){
			Node<E>temp = x.nextNode;
			x.prevNode= null;
			x.nextNode = null;
			x = temp; 
		}
		this.start = this.end = null;
		this.size = 0;
	}

	/* (non-Javadoc)
	 * @see generics.algos.datastructures.MyList#addAll(generics.algos.datastructures.MyList)
	 */
	@Override
	public void addAll(MyList<? extends E> col)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see generics.algos.datastructures.MyList#size()
	 */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see generics.algos.datastructures.MyList#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E t)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see generics.algos.datastructures.MyList#isEmpty()
	 */
	@Override
	public boolean isEmpty()
	{
		return this.size==0 ? true:false;
	}
}
