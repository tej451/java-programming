package com.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class ComaparableMainTest {
	public static void main(String[] a){
		BigDecimal bd = new BigDecimal("2.0");
		BigDecimal bd1 = new BigDecimal("2.00");
		System.out.println("equals: "+bd.equals(bd1));
		System.out.println("compareTo: "+bd.compareTo(bd1));
		TreeSet<BigDecimal> ts = new TreeSet<BigDecimal>();
		ts.add(bd);
		ts.add(bd1);
		HashSet<BigDecimal> hs = new HashSet<BigDecimal>();
		hs.add(bd);
		hs.add(bd1);
		System.out.println("TreeSet: calls compareTo "+ts.size()+ " HashSet: calls equals() "+hs.size());
		// HashSet internally calls equals which return false and adds 2 items to HashSet, which violets HashSet property
		// on the other side TreeSet calls compareTo internally
		
		System.out.println("Comparable Test");
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer(3, "Idea"));
		list.add(new Customer(9, "vodafone"));
		list.add(new Customer(6, "Airtel"));
		list.add(new Customer(1, "Reliance"));
		Collections.sort(list);
		for(Customer cust:list){
			System.out.println("Collections: "+cust.getCustomerId()+" - "+cust.getCustomerName());
		}
		
		Customer[] customers = new Customer[3];
		customers[0] = new Customer(22, "hhhh");
		customers[1] = new Customer(0, "aa");
		customers[2] = new Customer(65, "sshhhh");
		Arrays.sort(customers);
		for(Customer cust:customers){
			System.out.println("Arrays: "+cust.getCustomerId()+" - "+cust.getCustomerName());
		}
		System.out.println("Comparator Test");
		Collections.sort(list, Customer.custIdComparator);
		for(Customer cust:list){
			System.out.println("Collections custIdComparator: "+cust.getCustomerId()+" - "+cust.getCustomerName());
		}
		
		Collections.sort(list, Customer.custNameComparator);
		for(Customer cust:list){
			System.out.println("Collections custNameComparator: "+cust.getCustomerId()+" - "+cust.getCustomerName());
		}
		
		List<BigDecimal> list1 = new ArrayList<BigDecimal>();
		list1.add(new BigDecimal("2.00"));
		list1.add(new BigDecimal("2.0"));
		list1.add(new BigDecimal("4.00"));
		Collections.sort(list1, new HashSetComaparator());
		for(BigDecimal bigDecimal :list1){
			System.out.println("Collections custNameComparator: "+bigDecimal);
		}
	}
}

class HashSetComaparator implements Comparator<BigDecimal>{
	@Override
	public int compare(BigDecimal o1, BigDecimal o2) {
		System.out.println("o1 :"+o1+" o2 :"+o2+" "+o1.compareTo(o2));
		return o1.compareTo(o2);
	}
}