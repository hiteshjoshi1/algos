/**
 * 
 */
package com.hitesh.learn.generics.old;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author hitjoshi
 * @date Jan 21, 2016
 */
public class Proc implements Comparable<Proc>
{

	private int key;
	private String value;
	
	public Proc(int k, String s){
		this.key = k;
		this.value = s;
	}
	/**
	 * @return the key
	 */
	public int getKey()
	{
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(int key)
	{
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value)
	{
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Proc o)
	{
		
		return this.key-o.key;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Proc [key=" + key + ", value=" + value + "]";
	}


}
