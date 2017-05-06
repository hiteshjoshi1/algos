package com.hitesh.learn.ds.old;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;


public abstract class Routines {
	static int[] array;
	static
	{

		 array= new int[1000];
		for(int i=0;i<array.length;i++)
		{
			array[i]=(int)(Math.random()*1000);
		}
	}

	/**
	 * @param args
	 */
	
	static void swap(int[]a,int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	static void printRoutine(int array[])
	{
		for(int k=0;k<array.length;k++)
		{
			System.out.print(array[k]);
			System.out.print(", ");
		}
		System.out.println();
	}
	static void printRoutine(double array[])
	{
		for(int k=0;k<array.length;k++)
		{
			System.out.print(array[k]);
			System.out.print(", ");
		}
		System.out.println();
	}	
	/**
	 * Generic method to note time.
	 * uses reflection to get object instance from full Class name and method Name
	 * input type is assumed to be int[] array for this method
	 * 	<b>Class<?> cIntArray = Class.forName("[I"); signifies an Integer array</b>
	 * @param fullyQualClassName
	 * @param methodName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	
	public static Object printTimeToRun(String fullyQualClassName, String methodName) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
//		System.out.println("Printing Array");
//		printRoutine(array);
		// getting the class object
		Class<?> c = Class.forName(fullyQualClassName);
		// getting the input type. This is the standard way to imply that input is a integer array
		Class<?> cIntArray = Class.forName("[I");
	
		long startTime = System.nanoTime();
		
		Method m = c.getDeclaredMethod(methodName, cIntArray);
		Object  obj = c.newInstance();
		Field[] fields =c.getFields();
		for(Field field: fields)
		{
			System.out.println(field);
		}
		Object o =  m.invoke(obj, array);
		Long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Time"+(Long)duration/1000000);
		return o;
		
	}
}
