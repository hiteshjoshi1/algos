/**
 * 
 */
package com.hitesh.learn.generics.old;

import java.util.Arrays;

/**
 * @author hitjoshi
 * @date Feb 23, 2016
 */
public class ListByArray<T> 
{
	private static final int DEFAULT_SIZE = 10;
	@SuppressWarnings("unchecked")
	private T [] arr = (T[])new Object[DEFAULT_SIZE]; 
	private int size = 0; 
	/**
	 * @param args
	 * @description 
	 * @return void
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		ListByArray<Integer> list = new ListByArray<Integer>();
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(8);
		
		ListByArray<Integer>.Iterator<Integer> iter = list.getIterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	
	}

	public void add(T t){
		if(size== arr.length-1){
			ensureCapacity();
		}
		arr[size] = t;
		size++;
	}
	public void ensureCapacity(){
		arr = Arrays.copyOf(arr, arr.length+DEFAULT_SIZE);	
	}
/**
 * Remove from a location in the list
 * @param i
 * @return
 * @throws Exception
 * @description 
 * @return T
 */
	public T remove(int i) throws Exception{
		if(i>= size){
			throw new Exception("Not in the array");
		}else{
			T t = arr[i];
			int length = size-i-1;
			System.arraycopy(arr, i+1, arr, i,length);
			arr[--size]= null; // GC 
			return t;
		}

	}

	public boolean remove(T o) {
		if (o == null) {
			for (int index = 0; index < size; index++)
				if (arr[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (o.equals(arr[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}
	private void fastRemove(int index) {

		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(arr, index+1, arr, index,
					numMoved);
		arr[--size] = null; 
	}
	
	public Iterator<T> getIterator() {
		return new Iterator<T>();
	}

	class Iterator<E>{
		private int cursor = 0;
		

		public boolean hasNext(){
		while(cursor<size){
			return true;
		}
		return false;
		
		}
		public T next() throws Exception{
			if(cursor==size){
			throw new Exception("Out of bounds");	
			}
			else
			{
				T val = arr[cursor];
				cursor++;
				return val;
			}
		}
		
	}

}
