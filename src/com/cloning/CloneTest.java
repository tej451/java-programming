package com.cloning;

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException{

		Department hr = new Department(1, "HR");
		Employee emp = new Employee(1, "Lokesh", hr);
		Employee clonedEmp = (Employee)emp.clone();
		//changing to department version of cloned object will change the original department also since Department clone is 
		// not being called, on the other hand Employee original object will not change on changing cloned object
		//Here, we have not cloned the Department object on Employee class’s clone method
		clonedEmp.getDept().setDeptName("finanace");
		clonedEmp.setEmpName("shruti");
		System.out.println(emp.getDept().getDeptName());
		System.out.println(emp.getEmpName());
	}

}
