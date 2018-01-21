package com.collections;

public class Employee implements Cloneable{
	
	private int employeeId;
	private String employeeName;
	
	public Employee(int employeeId){
		this.employeeId = employeeId;
	}
	
	public Employee(int employeeId, String empName){
		this.employeeId = employeeId;
		this.employeeName = empName;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Override
	public int hashCode(){
		return 31+employeeId;
	}
	
	/*@Override
	public boolean equals(Object obj){
		if(obj == null)
		return false;
		else if(getClass()==this.getClass())
			return true;
		else if(obj == this)
			return true;
		else
			return false;
	}*/
	
	protected Employee clone() throws CloneNotSupportedException{
		return (Employee)super.clone();
	}
}
