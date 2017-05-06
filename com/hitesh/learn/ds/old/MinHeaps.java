package com.hitesh.learn.ds.old;

import java.lang.Integer;
public class MinHeaps<K extends Number,V> 
{
	static MinHeaps.Entry<Integer,String> [] array = new MinHeaps.Entry[]
			{new Entry<Integer, String>(1,"Hitesh"), new Entry<Integer, String>(1,"Joshi"),new Entry<Integer, String>(9,"Deepika"), new Entry<Integer, String>( 2,"Tetea tete"),
		new Entry<Integer, String>( 4,"Travel"), new Entry<Integer, String>( 6,"idiosyncracies"), new Entry<Integer, String>(6,"Test"),
		new Entry<Integer, String>(5,"Vendetta"),new Entry<Integer, String> (13,"Score"),new Entry<Integer, String>(3,"Monstrous") };

	static int heapSize = array.length;
	static class Entry<K extends Number,V>{
		private K key;
		private V value;

		Entry(){

		}
		Entry(K k,V v)
		{
			key = k;
			value= v;
		}	
		public K getKey()
		{
			return this.key;
		}
		public V getValue()
		{
			return this.value;
		}

		public void setKey(K key2)
		{
			this.key = key2;
		}
	}


	private  void printRoutine(Entry<K,V>[] a)
	{
		for(int i =0; i< heapSize;i++)
		{
			System.out.println("Entry Key"+a[i].getKey()+" Value  "+a[i].getValue() );
		}

	}
	public  Entry<K,V> [] buildMinHeap(Entry<K,V> a[] )
	{
		heapSize = a.length;
		for(int i = a.length/2;i>=0;i--)
		{
			minHeapify(a, i);
		}
		return a;
	}

	public  Entry<K,V>[] descendingHeapSort(Entry<K,V> [] a)
	{
		a = buildMinHeap(a);
		Entry<K,V> b [] = new Entry[a.length];
		int k = 0;

		for(int i = a.length-1;i>=0;i--)
		{			
			b[k]= a[0];
			a[0]= a[i];
			heapSize = heapSize-1;
			k++;
			minHeapify(a, 0);
		}
		return b;
	}

	public  Entry<K,V> [] minHeapify(Entry<K,V> a[],int pos)
	{
		int lc = left(pos);
		int rc = right(pos);
		int min = 0;

		if(lc< heapSize && a[lc].getKey().intValue()< a[pos].getKey().intValue())
		{
			min = lc; 
		}
		else
			min = pos;
		if(rc < heapSize && a[rc].getKey().intValue()<a[min].getKey().intValue())
		{
			min = rc;
		}
		if(pos != min)
		{
			swap(a,pos,min);
			return	minHeapify(a,min);
		}
		return a;
	}
	public static int left(int i)
	{
		return 2*i;
	}
	public static int right(int i)
	{
		return 2*i+1;
	}
	public static int parent(int i)
	{
		return i/2;
	}
	public Entry<K,V> heapMin(Entry<K,V> []a)
	{
		if(null != a && a.length<0)
			return null;
		else
			return a[0];
	}

	public Entry<K,V> extractMin(Entry<K,V> a[])
	{
		Entry<K,V> min = null;
		min	 = a[0];
		a[0]= a[heapSize-1];
		heapSize = heapSize-1;
		minHeapify(a,0);
		return min;
	}

	public void heapDecreaseKey(Entry<K,V>[] a,int pos, int val )
	{
		// decrease x key to key if x.key> key
		Entry<K,V>  e = a[pos];
		if(e.getKey().intValue()<val)
		{
			System.out.println("Wrong input");
			System.exit(0);
		}
		// compare it with parent
		K k = (K) new Integer(val);
		e.setKey(k);
		while(pos>0 && (a[parent(pos)].getKey().intValue()>a[pos].getKey().intValue()) )
		{
			swap(a,pos,parent(pos));
			pos = parent(pos);
		}

	}
	
	
	public Entry[] heapInsert(Entry [] a ,Entry<K,V> e)
	{
		if(heapSize<=a.length)
		{
			heapSize = heapSize+1;
			a[heapSize] = e;
			heapDecreaseKey(a, heapSize, e.getKey().intValue());
		}
		return a;
	}

	private void swap(Entry<K,V>[]a,int i,int j)
	{
		Entry<K,V> temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public Entry<K,V>[] descHeapSort2(Entry<K,V>[] e)
	{
		Entry<K,V>[] res = new Entry[e.length];
		buildMinHeap(e);
		int k = 0;
		while(k<res.length)
		{
			res[k]= extractMin(e);	
			k++;
		}	
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		MinHeaps<Integer,String> minHeap = new MinHeaps<Integer, String>();
//		Entry<Integer,String> res[] =	minHeap.descHeapSort2(array);
		//Entry<Integer,String> res[] =	minHeap.descendingHeapSort(array);
		Entry<Integer,String> res[] =	minHeap.buildMinHeap(array);
		minHeap.printRoutine(res);
		Entry<Integer,String> e= res[8];
		
		minHeap.heapDecreaseKey(res,8 , 0);
		heapSize = res.length;
		System.out.println("result---");
		minHeap.printRoutine(res);
		System.out.println("Extract Min");
		minHeap.extractMin(res);
		minHeap.extractMin(res);
		minHeap.extractMin(res);
		//System.out.println("Prinitng after extractMin"+ heapSize);
		minHeap.printRoutine(res);
		Entry<Integer,String> entry = new Entry<Integer,String>(2,"Volition"); 
		res = minHeap.heapInsert(res,entry);
	
		minHeap.printRoutine(res);
	
	}

}

