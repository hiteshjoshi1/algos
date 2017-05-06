/**
 * 
 */
package com.hitesh.learn.generics.old;

import java.util.ArrayList;
import java.util.List;

import com.hitesh.learn.ds.old.Program;

public class Program
{
	List<Program> aList = new ArrayList<Program>();
	int n = 10;
	public static void main(String[] args)	{
		Program p = new Program();
		List<Program> dummyList = new ArrayList<Program>();
		dummyList.add(new Program());
		p.dummyMethod(10,dummyList );
		System.out.println(p.getaList().size());
		System.out.println(p.getN());
	}
	public void dummyMethod(int num, List<Program>pList){
		num = num+10;
		pList = null;
	}
	public List<Program> getaList()
	{
		return aList;
	}
	public void setaList(List<Program> aList)
	{
		this.aList = aList;
	}
	public int getN()
	{
		return n;
	}
	public void setN(int n)
	{
		this.n = n;
	}
}
