/**
 * 
 */
package com.hitesh.learn.problemsolving.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hitjoshi
 * @date Mar 15, 2017
 * generate all solutions of the function
 * a^3+b^3=c^3+d^3
 * where a,b,c,d are integers between 1- 1000
 */
public class Cube
{

	/**
	 * @param args
	 * @description 
	 * @return void
	 */
	public static void main(String[] args)
	{
		Map<Double, List<Node>> map = new HashMap<Double,List<Node>>();
		for(int i=1;i<=1000; i++){
			for( int j=1; j<=1000;j++){
				
				double result = Math.pow(i,3)+Math.pow(j, 3);
				List<Node> tmp = map.get(result);
				if(tmp != null){
					tmp.add(new Node(i,j));
					map.put(result, tmp);
				}
				else{
					List<Node> tmp2 = new ArrayList<Node>();
					tmp2.add(new Node(i,j));
					map.put(result, tmp2);
				}
				
			}
		}
		
		for(Map.Entry<Double,List<Node>> entry : map.entrySet()){
			List<Node> tmp = entry.getValue();
				for(Node x: tmp){
					for(Node y: tmp){
						System.out.println("Printing a pair ----> ");
						System.out.println(x.toString());
						System.out.println(y.toString());
					}
					
				}
		}
	}

	
}

class Node {
	int c;
	int d;
	public Node(int c, int d){
		this.c=c;
		this.d = d;
	}
	@Override
	public String toString()
	{
		return "[val a = " + c + ", val b =" + d + "]";
	}
	
}