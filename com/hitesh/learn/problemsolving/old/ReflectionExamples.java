/**
 * 
 */
package com.hitesh.learn.problemsolving.old;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hitjoshi
 *
 */
public class ReflectionExamples
{

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException
	{
		Class c = Class.forName("examples.BinaryInsertion");

		Class cIntArray = Class.forName("[I");// will have int[].class 
		
		// gets all declared classes within Character class
		Class<?>[] d = Character.class.getClasses();
		for(Class x :d)
		{
			System.out.println(x.getName());
		}
		System.out.println("Now getting all Declared class-- Includes private class CharacterCache");
		Class<?>[] e = Character.class.getDeclaredClasses();
		for(Class x :e)
		{
			System.out.println(x.getName());
		}
		


	}

}
