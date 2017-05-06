package com.hitesh.learn.problemsolving.old;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateObjects {


    public static void main(String[] args) {

        Employee emp1 = new Employee("1","bapi",1000,31);
        Employee emp2 = new Employee("2","mano",2000,29);
        Employee emp3 = new Employee("1","bapi",1000,31); // emp3 == emp1 duplicate object
        Employee emp4 = new Employee("3","Rohan",3000,27);
        Employee emp5 = new Employee("1","bapi",1000,31); // emp5 == emp3 == emp1 duplicate object

        RemoveDuplicateObjects obj = new RemoveDuplicateObjects();

        // empList contains objects having duplicate values. How to remove duplicate? 
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);

      
        obj.removeDuplicate(empList);

    }

    // method is used for removing objects having duplicate values
    private void removeDuplicate(List<Employee> empList) {


        Set<Employee> empSet = new HashSet<Employee>();
        empSet.addAll(empList);

        for(Employee e: empSet){

            System.out.println("id = "+e.getEmpid());
            System.out.println("name = "+e.getEmpname());
            System.out.println("sal = "+e.getSal());
            System.out.println("age = "+e.getAge());
        }

    }

}
