package com.hitesh.learn.problemsolving.old;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import com.hitesh.learn.ds.old.HashMap;

public class Solution {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int arr[][] = new int[6][6];
//        for(int arr_i=0; arr_i < 6; arr_i++){
//            for(int arr_j=0; arr_j < 6; arr_j++){
//                arr[arr_i][arr_j] = in.nextInt();
//            }
//        }
//        int sum = -45; 
//       for(int i = 0; i<=3; i++){           
//           for(int j = 0 ; j <= 3; j++){
//            int k = arr[i+0][j+0]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];   
//               if(k>sum)
//                   sum = k;
//           }
//       } 
//        System.out.print(sum);
//    }

    	 Scanner in = new Scanner(System.in);
         int n = in.nextInt();// total number of Strings
//         String arr[] = new String[n];
         
         Map<String, Integer> map = new HashMap<String, Integer>();
         for(int i = 0; i<n;i++){
        	 String x = in.next();
        	 if(map.get(x)== null){
        		 map.put(x,1);
        	 }
        	 else{
        		 int k = map.get(x);
        		 map.put(x, k+1);
        	 }
         }
         int q = in.nextInt(); 
         for(int k =0; k <q;k++ ){
        	 String val = in.next();
        	 if(map.get(val)!=null)
        		 System.out.println(map.get(val));
        	 else
        		 System.out.println(0);
         }
         
         
//         for(int arr_i=0; arr_i < n; arr_i++){
//             arr[arr_i] = in.next();
//         }
// 		int q = in.nextInt();// total number of Strings in Q
// 		String arr2[] = new String[q];
//         for(int k=0; k < q; k++){
//             arr2[k] = in.next();
//         }
//         int val =0;
//         for(int i = 0; i<q;i++){        	
//        	 for(int k = 0;k<n;k++){
//        		 if(arr2[i].equals(arr[k])){
//        		val++;
//        		}        		
//        	 }
//        	 System.out.println(val);
//        	 val=0;
//         }
         in.close();
         
         
         
    }
    	
}