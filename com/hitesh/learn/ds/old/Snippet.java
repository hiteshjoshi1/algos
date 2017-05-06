package com.hitesh.learn.ds.old;

public class Snippet
{
		/**
		 * @param args
		 */
		public static void main(String[] args)
		{
	
		String a = args[0];
		String b = args[1];
		if(a == null || b == null)
		{
			System.out.println("hours and Mins not defined");
			System.exit(0);
		}
		System.out.println("Angle is "+printAngle(Integer.parseInt(a),Integer.parseInt(b)));
		}
		private static double printAngle(int hrHand, int minHand)
		{
		// in 12-- 360,1 hour--> 30-->1 min--> .5 
		// 60 mins - 360 , 1 min -- 6
			double angleByHrHand = (30*hrHand)+ (0.5 *minHand);
			double angleByMinHand = 6*minHand;
			return (angleByMinHand-angleByHrHand);
					
			
		}
}

