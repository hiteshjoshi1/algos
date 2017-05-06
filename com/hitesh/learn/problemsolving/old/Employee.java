package com.hitesh.learn.problemsolving.old;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Employee{ 

    public String empid;
    public String empname;
    public double sal;
    public int age;

  
    public Employee(String empid,String empname,double sal,int age)
    {   this.empid = empid;
        this.empname = empname;
        this.sal = sal;
        this.age = age;
    }

    public String getEmpid() {
        return empid;
    }
    public void setEmpid(String empid) {
        this.empid = empid;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This override method playes a major role to remove duplicate values
     */
    @Override
    public int hashCode() {
        return (this.empid.hashCode() + this.empname.hashCode()+String.valueOf(this.sal).hashCode()+String.valueOf(this.age).hashCode());
    }

    /**
     * This override method plays a major role to remove duplicate values
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee) {
            Employee temp = (Employee) obj;

            if(this.empid.equals(temp.empid) && this.empname.equals(temp.empname) && String.valueOf(this.sal).equals(String.valueOf(temp.sal)) && String.valueOf(this.age).equals(String.valueOf(temp.age))) {
                return true;
            }
        }
        return false;
    }
   static class Domain implements Comparable<Domain>
    {
    private String[] fields;
    public String[] getFields() {
		return fields;
	}
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	public static String  dummyToString(String[] fields)
	{
		StringBuffer finalString=new StringBuffer(fields[0]);
		for(int i=1;i<fields.length;i++)
		{
		finalString.append(".");
		finalString.append(fields[i]);
		
		
		}
		return finalString.toString();
	}
	private int N;
    public Domain(String name)
    {
    fields = name.split("\\.");
    N = fields.length;
    }
    public int compareTo(Domain b)
    {
    Domain a = this;
    for (int i = 0; i < Math.min(a.N, b.N); i++)
    {
    int c = a.fields[i].compareTo(b.fields[i]);
    if (c < 0) return -1;
    else if (c > 0) return +1;
    }
    return a.N - b.N;
    }
    }
    
    public static void main(String[] args)
    {	
    	List <Domain>    domainList= new ArrayList<Domain>(); 
    	
    			domainList.add(new Domain("ee.princeton.edu"));
    			domainList.add(new Domain("cs.princeton.edu"));
    			domainList.add(new Domain("princeton.edu"));
    			domainList.add(new Domain("cnn.com"));
    			domainList.add(new Domain("google.com"));
    			domainList.add( new Domain("apple.com"));
    			domainList.add(new Domain("www.cs.princeton.edu"));
    			domainList.add(new Domain("bolle.cs.princeton.edu"));
    			domainList.add(new Domain("abcd.com"));
    			
    		Collections.sort(domainList);
    		
    		for(Domain d: domainList)
    		{
    			System.out.println(Domain.dummyToString(d.getFields()));
    			
    		}
    
    }
    
}



