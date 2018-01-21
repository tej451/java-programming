package com.collections;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {
	public static void main(String args[]){
		
		//UserDefined hashMap
		HashMap<Employee, String> hashMap = new HashMap<Employee, String>();
		Employee emp = new Employee(1);
		Employee emp1 = new Employee(2);
		hashMap.put(emp, "a");
		hashMap.put(emp1, "b");
		System.out.println(hashMap.size());
		System.out.println("emp hashcode: "+emp.hashCode()+" emp1 hashcode: "+emp1.hashCode());
		for(Map.Entry<Employee, String> entrySet:hashMap.entrySet()){
			System.out.println("Key: "+entrySet.getKey()+":"+entrySet.getKey().getEmployeeId()+" Value: "+entrySet.getValue());
		}
		System.out.println(hashMap.get(emp));
		System.out.println(hashMap.get(emp1));
		
		//With Wrappers
		HashMap<Integer, String> hashMap1 = new HashMap<Integer, String>();
		Integer i = new Integer(1);
		Integer j = new Integer(2);
		System.out.println("i hashcode: "+i.hashCode()+" j hashcode: "+j.hashCode());
		hashMap1.put(i, "a");
		hashMap1.put(j, "b");
		System.out.println(hashMap1.size());
		System.out.println(hashMap1.get(i));
		System.out.println(hashMap1.get(j));
	}
	
	
	
	
}
