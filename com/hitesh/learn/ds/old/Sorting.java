package com.hitesh.learn.ds.old;


public class Sorting extends Routines {

	


	public static void main(String args[])
	{
		// if array declaration is commented , the one in routuines will be used.
		 int [] array = new int[]{4, 1, 7, 8, 5, 9, 9, 4, 7, 0};
			printRoutine(array);
		 Sorting sortingObj= new Sorting();		
		sortingObj.mergeSort(array, 0, array.length-1);
		printRoutine(array);
		/*	int []sortedArray=sortingObj.insertionSort(array);
		sortingObj.printRoutine(sortedArray);*/

		//sortingObj.mergesort(0,array.length-1);
		/*System.out.println(sortedArray2.length);*/

//		File sorting= new File("C:/Users/hitjoshi/Desktop/sorting.txt");
//		if (sorting.exists()) {
//
//			BufferedWriter bw1 =null;
//
//			try {
//
//
//				FileOutputStream fostream = new FileOutputStream(sorting);
//				OutputStreamWriter out = new OutputStreamWriter(fostream,"UTF-16");
//				bw1 = new BufferedWriter(out);
//				long t=Calendar.getInstance().getTimeInMillis();
//				printRoutine(array);
//				bw1.write("Sort Started"+t);
//
//				//int []sortedArray=sortingObj.recursiveInsertionSort(array.length-1,array);
//				int [] sortedArray= sortingObj.insertionSortWithBinaryPartition(array);
//
//
//
//				bw1.write("Sort ended "+(Calendar.getInstance().getTimeInMillis()));
//				bw1.newLine();
//				System.out.println("Printing final Array");
//				printRoutine(sortedArray);
//				for(int k=0;k<sortedArray.length;k++)
//				{
//					bw1.write(" "+sortedArray[k]);
//					bw1.newLine();
//
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally{
//				try {
//					bw1.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}

	}


	/* trick is to use the card analogy.
		every new card gets compared to all the cards in the hand and inserted at the right position
	 */
	public int[] insertionSort(int[] ar)
	{	

		for(int i=1;i<ar.length;i++)
		{
			for(int j=i;j>0;j--){
				int pos=ar[j];

				if(ar[j-1]>pos)
				{
					ar[j]=ar[j-1];
					ar[j-1]=pos;
				}

			}
		}		
		return ar;
	}

	public int [] recursiveInsertionSort(int last, int a[])
	{
		if(last>0)
		{
			recursiveInsertionSort(last-1,a);
		}
		int pos=last-1;

		while(pos >= 0 && a[last] < a[pos])
		{
			pos--;//got the position of element lesser then current
		}
		pos++;
		int temp = a[last];
		for(int k = last-1;k >= pos;k--)
		{
			a[k+1] = a[k];
		}
		a[pos] = temp;
		return a;
	}

	//every number is compared to every other number one by one, if smaller , they are swapped
	public int[] bubbleSort(int [] a)
	{

		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if (a[i]<a[j])
				{
					swap(a,i,j);
				}
			}

		}
		return a;
	}

	/*
	 * find smallest , replace with a[0] and so on
	 */

	public int[] selectionSort(int [] a)
	{

		for(int i=0; i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(a[i]<a[j])
					swap(a,i,j);
			}
		}
		return a;
	}


	/*	public int binarySearch(int [] sortedArray,int start, int end, int item)
	{
		int mid = start+(end-start)/2;
		System.out.println(" "+start+" "+mid+" "+end );
		int pos=-1;
		if(start == mid || mid==end)
		{
			return -1;
		}
		 if(item == sortedArray[mid])
		 {
			 pos=mid;
		 }
		 else if(item > sortedArray[mid])
		{
		pos= binarySearch(sortedArray,mid,end,item);
		}
		else if((item < sortedArray[mid])){
		pos=binarySearch(sortedArray,start,mid,item);
		}	


		return pos;
	}*/
	//1111,21,8,101,323,4,232332,12312,123,5,0,89899
	//
	public int[] insertionSortWithBinaryPartition(int a[])
	{
		for(int i=1;i<a.length;i++)
		{
			int temp = a[i];
			System.out.println("current Value "+temp);
			int pos =findPos(a,0,i - 1, temp);
			
			for(int k=i-1;k > pos;k--)
			{
				swap(a,k,k+1);
			}
			printRoutine(a);
			
		}

		return a;
	}
	//1111,21,8,101,323,4,232332,12312,123,5,0,89899
	private int findPos(int []a,int start,int end, int item)
	{
		int pos = -1;
		
		if(start > end) {
			System.out.println("Start "+start+" End "+end);
			return item > a[start] ? start : start -1;
		}

		int mid = (start+(end - start)/2);
		
		System.out.println("Start "+start +"  Start Value "+a[start] +" Mid "+mid +" Mid  Value "+a[mid]+" End "+end+" End Value "+a[end]);
		
		if(item > a[mid])
		{			
			pos=findPos(a,mid+1,end, item);
		}
		else if(item < a[mid])
		{			
			pos=findPos(a,start,mid-1, item);
		} else {
			pos = mid;
		}
		
		return pos;
	}

	


//	//Helper Array is the size of sorting array, space complexity high
//	private void merge(int [] ar,int low, int middle, int high)
//	{
//		System.out.println("low "+low+ " Middle "+middle+ " high "+high); //3,3,4
//		int offset = low-0;//3
//		System.out.println("Offset "+offset);
//		int[] helper= new int[high-low+1];// size =2,o,1
//		for(int i=0;i<helper.length;i++)
//		{
//			helper[i]=array[(i+offset)];//0+3,1+3
//		}
//		System.out.println("Printing helper");
//		printRoutine(helper);
//		int i =low;
//		int j= middle+1;
//		int k =low;
//
//		while(i<=middle && j <=high)
//		{
//			if(helper[i]>= helper[j])
//			{
//				ar[k]=helper[j];
//				j++;
//			}
//			else
//			{
//				ar[k]=helper[i];
//				i++;
//			}
//			k++;
//		}
//		while (i <= middle) {
//			ar[k] = helper[i];
//			k++;
//			i++;
//		}
//	}	


	public  int[] mergeSort(int[] ar, int start, int end)
	{

		// to calculate mid point between two numbers a and b, 8, 0... 0+(8-0)/2=4

		if(start<end)
		{
			int  mid = start + (end - start) / 2;		
			mergeSort(ar,start,mid);
			mergeSort(ar,mid+1,end);		
			mergeNu(ar,start,mid,end);
		}

		return ar;

	}
	// helper array is the size of two sorted parts being merged, space complexity is much less
	private void mergeNu(int [] ar,int start, int mid, int end)
	{
		System.out.println("p "+start +" q "+mid+" r "+end );//0,0,1
		//create an interim array
		int i= start;
		//int j= mid+1;//actual mid(start<=mid)
		int q= start;

		int helper[]= new int[(end-start)+1];


		//copy both parts to be merged as is , in the helper
//		int x=0;
//		while(i<=end)
//		{
//			helper[x]=ar[i];
//			i++;
//			x++;
//		}

		for(int x=0;x<helper.length;x++)
		{
			helper[x]=ar[i+x];
		}
		System.out.println("Helper");
		printRoutine(helper);
		//helper has now both subparts , albeit unsorted

		int offset = start - 0;

		//int k = Math.min(mid + 1, end) - offset;
		int k = (mid+1)-offset;
		int j = start - offset;

		while(j <= (mid - offset) && k <= (end - offset))// while(0<1 &&1<3)
		{

			if(helper[j] >= helper[k])
			{
				ar[q]=helper[k];
				k++;
			}
			else
			{
				ar[q]=helper[j];
				j++;
			}
			q++;
		}

		while(j <= (mid - offset)) {
			ar[q] = helper[j];
			q++;
			j++;
		}

		while(k <= (end - offset)) {
			ar[q] = helper[k];
			q++;
			k++;
		}

	}
} 


