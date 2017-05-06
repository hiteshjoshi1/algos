/**
 * 
 */
package com.hitesh.learn.generics.old;

/**
 * @author hitjoshi
 * @date Feb 28, 2016
 * 
 * example copied from http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeParameters.html#FAQ107
 */
public class TreeMap<Key extends Comparable<Key> ,Data>{ 
	  private static class Entry<K,V> { 
	     K key; 
	     V value; 
	     Entry<K,V> left = null; 
	     Entry<K,V> right = null; 
	     Entry<K,V> parent; 
	  } 
	  private transient Entry<Key,Data> root = null; 

	  private Entry<Key,Data> getEntry(Key key) { 
	     Entry<Key,Data> p = root; 
	     Key k = key; 
	     while (p != null) { 
	       int cmp = k. compareTo(p.key) ;  
	       if (cmp == 0) 
	         return p; 
	       else if (cmp < 0) 
	         p = p.left; 
	       else  
	         p = p.right;  
	     } 
	     return null; 
	  } 
	  public boolean containsKey(Key key) { 
	     return getEntry(key) != null; 
	  } 
	   
	}