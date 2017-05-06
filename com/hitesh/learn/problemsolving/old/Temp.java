package com.hitesh.learn.problemsolving.old;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



 
public class Temp{
 
  
public static String test = "Teri Galiyan galiyan";

public static void main(String [] args) throws IOException
{
	ArrayList<String> arrayList = new ArrayList<String>();

    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("A");
    arrayList.add("C");
    arrayList.add("D");

    System.out.println(arrayList);

    Collections.replaceAll(arrayList, "A", "Replace All");

    System.out.println(arrayList);
}
} 


