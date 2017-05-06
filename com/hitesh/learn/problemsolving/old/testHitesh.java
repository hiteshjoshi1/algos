package com.hitesh.learn.problemsolving.old;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class testHitesh {

	public static void main(String [] args){

double base = 1000;
int yr= 9;
double rate = 8.75/100;
double amount = base * Math.pow((1+rate), yr);
System.out.println(amount);	
System.out.println("Interest "+String.valueOf(amount - base));

	}
}