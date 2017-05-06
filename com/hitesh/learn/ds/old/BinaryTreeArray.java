/**
 * 
 */
package com.hitesh.learn.ds.old;

/**
 * @author hitjoshi
 * @date Mar 15, 2016
 */
public class BinaryTreeArray<T>
{
	private T [] arr = null ;
	private static final int INITIAL_CAPACITY = 10;
	private int size = 0;
	@SuppressWarnings("unchecked")
	public BinaryTreeArray(int n){
		this.arr = (T[])new Object[n]; 
	}
	@SuppressWarnings("unchecked")
	public BinaryTreeArray(){
		this.arr = (T[]) new Object[INITIAL_CAPACITY];
	}
	
	private int leftChild( int i){
		return 2*i+1;
	}
	
	private int rightChild(int i){
		return 2*i+2;
	}
	
	public void add2Tree( T node){
		if(size == 0){
			System.out.println("Root Node");
			arr[0] = node;
			size++;
		}
		else{
			T curNode = arr[size-1];
			
		}
	}

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
	

	}

}
