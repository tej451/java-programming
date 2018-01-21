package com.collections;

import java.util.Comparator;

public class Customer implements Comparable<Customer>{
	int customerId = 0;
	String customerName = null;
	
	public Customer(int custId, String custName){
		customerId = custId;
		customerName = custName;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public int compareTo(Customer obj) {
		return this.customerId > obj.customerId ? 1: this.customerId < obj.customerId ? -1: 0;
	}
	
	public static Comparator<Customer> custNameComparator = new Comparator<Customer>() {
		public int compare(Customer o1, Customer o2){
			return o1.getCustomerName().compareTo(o2.getCustomerName());
		}
	};
	
	public static Comparator<Customer> custIdComparator = new Comparator<Customer>() {
		public int compare(Customer o1, Customer o2){
			return o1.getCustomerId() > (o2.getCustomerId()) ? 1: o1.getCustomerId() < (o2.getCustomerId()) ? -1 : 0;
		}
	};
	
}
