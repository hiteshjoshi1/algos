package com.hitesh.learn.problemsolving.old;

public class JavareferenceTest {

	/**
	 * @param args
	 */
	public static void main( String[] args ){
	    Dog aDog = new JavareferenceTest.Dog("Max");
	    foo(aDog);

	    if( aDog.getName().equals("Max") ){ //true
	        System.out.println( "Java passes by value." );
	    }else if( aDog.getName().equals("Fifi") ){
	        System.out.println( "Java passes by reference." );
	    }
	}

	public static void foo(Dog d) {
	 System.out.println(d.getName().equals("Max")); // true
	 // The Dog in the main is not overwritten
	  d = new Dog("Fifi");
	  System.out.println("After Reassignment"+d.getName().equals("Fifi")); // true
	}
	public static void foo2(Dog d) {
		  d.getName().equals("Max"); // true
		  d.setName("Fifi");
		}
	static class Dog {
		
		public Dog(String name)
		{
			this.name = name;
		}
		
		private String name;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
