package com.collections;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
 
    public static void main(String[] args) {
        Employee1 employee = new Employee1();
        Employee1 employee1 = new Employee1();
        Employee1 employee2 = new Employee1();
        Employee1 employee3 = new Employee1();
        Employee1 employee4 = new Employee1();
        System.out.println((employee == employee1) + " - "+employee.hashCode() + " - "+employee1.hashCode());
        System.out.println(employee.equals(employee1));
        System.out.println(((employee == employee1) || employee.equals(employee1)));
        System.out.println(((employee == employee) || employee.equals(employee)));
 
        HashMap<Employee1, String> hashMap = new HashMap<Employee1, String>();
        hashMap.put(employee, "employee");
        hashMap.put(employee1, "employee1");
        hashMap.put(employee2, "employee2");
        hashMap.put(employee3, "employee3");
        hashMap.put(employee4, "employee4");
 
        System.out.println(hashMap.size() + "   size of hashmap");
 
        Set<Employee1> keySet = hashMap.keySet();
 
        for (Employee1 employeetest : keySet) {
            System.out.println(hashMap.get(employeetest));
        }
    }
 
}

class Employee1 {
	 
	@Override
    public int hashCode() {     
        return (int)(20+Math.random());
    }
 
    
    @Override
    public boolean equals(Object obj) {
        return false;
    }
 
}
