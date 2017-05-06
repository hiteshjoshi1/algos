/**
 * 
 */
package com.hitesh.learn.generics.old;

/**
 * @author hitjoshi
 * @date Jan 21, 2016
 */
// Type parameter is T, all of which implements Comparable-- Recursive Type Bound
//The type bound <T extends Comparable<T>> may be read as “for every type T that can be compared to itself 

public class PriorityQueue<T extends Comparable<T>>
{
	private T[] a;
	private int heapSize = 0;
	public static void main(String[] args) throws Exception
	{
		PriorityQueue<Proc> queue = new PriorityQueue<Proc>();
		queue.insert(new Proc(10,"Hitesh"));
		queue.insert(new Proc(1,"Joshi"));
		queue.insert(new Proc(100,"Deepika"));
		queue.insert(new Proc(15,"Roark"));

		queue.buildMaxHeap(queue.getHeapSize());
		Proc p = queue.getMax();
		System.out.println(p);

		Proc q = queue.extractMax();
		System.out.println(q);

		Proc r = queue.extractMax();
		System.out.println(r);

		Proc s = queue.extractMax();
		System.out.println(s);

	}

	public PriorityQueue(){
		a =  (T[]) new Comparable[10];
	}
	public PriorityQueue(int size) throws Exception{
		if(size<=0){
			throw new Exception("Size cannot be zero or less");
		}
		a = (T[]) new Comparable[size];
	}

	public PriorityQueue(T[] a){
		this.heapSize = a.length;
		this.a = a;

	}

	public T getMax(){
		return a[0];
	}

	public T extractMax() throws Exception{
		if(heapSize==0){
			throw new Exception("Heap is empty");
		}
		T result = a[0];
		a[0]=a[heapSize-1];
		heapSize--;
		sink(0, heapSize);
		return result;
	}

	public void insert(T p) throws Exception{

		a[heapSize] = p;
		swim(heapSize);
		heapSize++;
	}


	private int parent(int i){
		return i/2;
	}
	public T[] getA()
	{
		return a;
	}
	public void setA(T[] a)
	{
		this.a = a;
	}
	public int getHeapSize()
	{
		return heapSize;
	}
	private void buildMaxHeap(int heapSize)
	{	
		for(int i = heapSize/2;i>=0;i--){
			sink(i, heapSize);
		}

	}
	// maxHeapify-- Sink signifies Node is smaller than children
	private void sink(int i, int heapSize)
	{
		int l = leftChild(i);
		int r = rightChild(i);
		int largest = i;
		if(l<heapSize && Helper.gterThanEqTo(a[l],a[i])){
			largest = l;
		}
		if (r< heapSize && Helper.gterThanEqTo(a[r],a[largest])){
			largest = r;
		}
		if(largest!= i){
			Helper.swap(a,i,largest);
			sink(largest,heapSize);
		}
	}

	// Swim species that Node is bigger than its parents
	private void swim(int pos)
	{
		while(pos > 0 && Helper.lesserThanEqTo(a[parent(pos)],a[pos])){
			int parentPos = parent(pos); 
			Helper.swap(a,pos,parentPos);
			pos = parentPos;
		}

	}

	private static int leftChild(int i)
	{
		i<<=1;    
		return i+1;
	}

	private static int rightChild(int i)
	{		
		i<<=1;
		return i+2;
	}
}
