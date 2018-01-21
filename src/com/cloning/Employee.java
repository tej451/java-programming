package com.cloning;

public class Employee implements Cloneable {

	private int empId;
	private String empName;
	private Department dept;
	
	public Employee(int id, String name, Department dept)
    {
        empId = id;
        empName = name;
        this.dept = dept;
    }
	
	public Object clone() throws CloneNotSupportedException{
		//shallow cloning, if we will not clone the Object types, then on changing cloned object will change original also
		//return super.clone(); 
		
		//improved version, deep-cloning
		Employee clonedEmp = (Employee)super.clone();
		//clonedEmp.setDept((Department)clonedEmp.getDept().clone());
		
		//OR, If any member class does not support cloning then in clone method, 
		//one must create a new instance of that member class and copy all its attributes one by one to new 
		//member class object. This new member class object will be set in cloned object.
		
		Department dept = new Department();
		dept.setDeptId(clonedEmp.getDept().getDeptId());
		dept.setDeptName(clonedEmp.getDept().getDeptName());
		clonedEmp.setDept(dept);	
		return clonedEmp;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
}
