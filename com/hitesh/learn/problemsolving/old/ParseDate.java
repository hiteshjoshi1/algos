package com.hitesh.learn.problemsolving.old;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ParseDate {
	
	public static void main(String [] args) throws ParseException
	{
		//String  date = new String ("2014-05-01T19:17:37"); 
		String  date = new String ("2014-03-01 T 19:17:37"); 
		
		DateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date modifiedDate = null;

			modifiedDate = sft.parse(date);
		
			System.out.println(modifiedDate);
			System.out.println(modifiedDate.getTime());
			System.out.println(sft.format(modifiedDate));
		//.out.println("Dates"+modifiedDate.getDate()+" "+modifiedDate.getMonth()+" "+modifiedDate.getYear() );
	}

}
