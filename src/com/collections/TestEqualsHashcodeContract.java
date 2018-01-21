package com.collections;

import java.util.Arrays;
import java.util.List;



public class TestEqualsHashcodeContract {
/*
 * 10. A class overrides hashcode but not equals, and its instances are stored in a list. Which of the following are true when "contains" method is called on the list
a. Class does not compile
b. Class fails at runtime saying equals method is not found
c. contains method returns true when a cloned instance of stored object is passed to contians method
d. contains method will never return true in this case.
e. none of the above
Answer:d
 */
	public static void main(String[] args) throws CloneNotSupportedException {
		List<Employee> employees = Arrays.asList(new Employee(1, "a"),
				new Employee(2, "b"),
				new Employee(3, "c"),
				new Employee(4, "d"),
				new Employee(5, "e"));

		Employee testEmp = new Employee(1, "a");
		System.out.println(employees.contains(testEmp));
		
		Employee cloneEmp = testEmp.clone();
		System.out.println(employees.contains(cloneEmp));
	}

}
