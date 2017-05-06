package com.hitesh.learn.problemsolving.old;
//public class Percolation {
//WeightedQuickUnionUF wf;
//private int size;
//	public Percolation(int N)  
//	{	   
//		size=N;
//		if(N<=0)
//		{
//			throw new IllegalArgumentException("N should be greater then zero."); 
//		}		
//		wf= new WeightedQuickUnionUF(N*N);
//	}
//	//A full site is an open site that can be connected to an open site
//	//	in the top row via a chain of neighboring (left, right, up, down) open sites. 
//	
//	// open
//	//  blocked
//	// full - open and connected
//	
//	public void open(int i, int j)
//	{
//		// open site (row i, column j) if it is not already
//		int pos = getPos(i,j);
////		if(!isOpen(i,j))
////		{
////	
////		}
//
//	}
//	private int getPos(int i, int j)
//	{
//		return i*size+j; 
//	}
//	
//	
////	public boolean isOpen(int i, int j)
////	{
////		int pos = getPos(i,j);
////		
////	
////	}
////	public boolean isFull(int i, int j) {
////		// is site (row i, column j) full?
////		// is it open and connected to a neighboring open site
////		// check open, if yes, check connectivity
////	}
//	public boolean percolates() {
//		// does the system percolate?
//		//We say the system percolates if there is a full site in the bottom row
//		
//		return false;
//	}
//	public static void main(String[] args) {
//		Percolation p = new Percolation(10);
//	}
//}