package com.hitesh.learn.ds.old;


public class LinearSorting extends Routines {
	
	
	class Data
	{
		private int key;
		private String data;
		
		Data(int key, String data){
			this.key = key;
			this.data = data;
		}
	}

	public Data[] createDataArray(){
		
		Data[] dataArray = new Data[]{new Data(1,"Vendetta"),new Data(2,"Hitesh"),new Data(3,"Joshi"),new Data(1,"Mr"),new Data(0,"endomundo")};
		return dataArray;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinearSorting ln = new LinearSorting();
//		//int [] arr= new int[]{3,5,7,3,5,6,1,0,0,0};
//		int [] arr= new int[]{1,1};
//		System.out.println(arr.length);
//		arr=ln.countingSort(arr, 1);
//		System.out.println("Final Array ---- ");
//		printRoutine(arr);
		Data[] data=ln.createDataArray();
		data = ln.countingSort(data, 3);
		
		for(int i=0;i<data.length;i++)
		{
			System.out.println("Data Key "+data[i].key +"Data Value    "+data[i].data);
			
		}
	
		
	}
	
	public int[] countingSort(int[] a, int k)
	{
		int [] output = new int[a.length];
		int [] aux = new int[k+1];
		for(int i=0; i<a.length;i++)
		{	
			aux[a[i]]= aux[a[i]]+1;
		}
		printRoutine(aux);
		for(int i = 1;i<=k;i++)
		{
			aux[i]=aux[i]+aux[i-1];
		}
		printRoutine(aux);
		for(int i = a.length-1;i>=0;i--)
		{
			output[aux[a[i]]-1] = a[i];
			aux[a[i]]=aux[a[i]]-1;
		}
		return output;
	}
	
	/**
	 * Counting sort when the input is of [0,1]
	 * 
	 */
	public Data[] countingSort(Data[] arr,int k)
	{
		
		int [] aux= new int[k+1];
		Data[] output = new Data[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			aux[arr[i].key] = aux[arr[i].key]+1;
		}

		for(int i=1;i<aux.length;i++)
		{
			aux[i]=aux[i]+aux[i-1];
		}
	
		
		for(int j =arr.length-1;j>=0;j-- )
		{
			output[aux[arr[j].key]-1]= arr[j];
			aux[arr[j].key]=aux[arr[j].key]-1;
		}
		return output;
	}
	
}
