/**
 * 
 */
package com.hitesh.learn.generics.old;

/**
 * @author hitjoshi
 * @date Feb 7, 2016
 */
public enum StackEnd {
	STACK1("Top1"),
	STACK2("Top2");
	private final String value; 
	
	private StackEnd(String value){
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
