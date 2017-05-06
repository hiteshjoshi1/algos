/**
 * 
 */
package com.hitesh.learn.ds.old;

import java.util.LinkedList;

/**
 * @author hitjoshi
 * @date Apr 14, 2017
 */
public class HashMap<K,V>
{
	public static final int INIT_CAPACITY = 10;
	public LinkedList<Node>[] arr = (LinkedList<Node>[]) new Object[INIT_CAPACITY];
	
	
	

	class Node<K,V>{
		K key;
		V value;
		
		public Node(K key, V val){
			this.key = key;
			this.value = val;
		}
		public K getKey()
		{
			return key;
		}
		public void setKey(K key)
		{
			this.key = key;
		}
		public V getValue()
		{
			return value;
		}
		public void setValue(V value)
		{
			this.value = value;
		}
	}
}
