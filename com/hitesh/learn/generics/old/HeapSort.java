/**
 * 
 */
package com.hitesh.learn.generics.old;

/**
 * @author hitjoshi
 * @date Jan 20, 2016
 */
public class HeapSort
{

	public static void main(String[] args)
	{
//		Integer a[] = new Integer[]{3,1,4,5,9,0,7,2};
//		Integer [] res = (Integer[])HeapSort.heapSort(a); 
//		String a [] = new String[]{"Hitesh","Rohit","Abhishek","Bum","Xander","Monisha"};
//		String [] res = (String[])HeapSort.heapSort(a); 
		
		Proc[] a = new Proc[]{new Proc(10,"Hitesh"),new Proc(1,"Joshi"),new Proc(2,"Deepika"), new Proc(5,"Vengance"),new Proc(100,"Mom")};
		Proc [] res = (Proc[])HeapSort.heapSort(a); 
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
		
	}
// First Create a max heap
// take top node at a[0] out, replace with last node then max heapify 	
	public static Comparable[] heapSort(Comparable [] a){
		int heapSize = a.length;
		buildMaxHeap(a);
		for(int i = a.length-1;i>0;i--){
			Helper.swap(a,i,0);
			heapSize--;
			maxHeapify(a,0,heapSize);
		}	
		return a;
	}
// All leaves start from a.length/2 , So loop starts from a.length/2  --> 0 
// and we call max - heapify at each node to get a max heap. 
	private static void buildMaxHeap(Comparable[] a)
	{	
		for(int i = a.length/2;i>=0;i--){
			maxHeapify(a, i,a.length);
		}

	}	
// largest set to i
//compare with left 
// compare largest of two with the right
// finally swap	
	private static void maxHeapify(Comparable[] a, int i, int heapSize)
	{
		int l = leftChild(i);
		int r = rightChild(i);
		int largest = i;
		if(l<heapSize && Helper.gterThanEqTo(a[l],a[i])){
			largest = l;
		}
		if (r< heapSize && Helper.gterThanEqTo(a[r],a[largest])){
			largest = r;
		}
		if(largest!= i){
			Helper.swap(a,i,largest);
			maxHeapify(a, largest,heapSize);
		}
	}
	private static int leftChild(int i)
	{
		i<<=1;    
		return i+1;
	}

	private static int rightChild(int i)
	{		
		i<<=1;
		return i+2;
	}

}
