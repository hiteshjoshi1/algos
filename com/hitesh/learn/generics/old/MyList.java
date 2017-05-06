/**
 * 
 */
package com.hitesh.learn.generics.old;



/**
 * @author hitjoshi
 * @date Oct 3, 2016
 */
interface MyList<T>
{
	//add
	void add(T t);	

	//get(pos)
	T get(int pos);

	//remove()
	T remove(int pos);

	// removeAll
	void removeAll();

	void addAll(MyList <? extends T> col);	


	int size();

	boolean contains(T t);

	boolean isEmpty();

}
