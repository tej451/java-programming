package com.programmingques;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestListAndSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new java.util.LinkedList<>();
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<100; i++){
			list.add(i+"");
			set.add(i+"");
		}
		
		for(String lis: list){
			System.out.println(lis);
		}
		
		System.out.println("SET");
		for(String lis: set){
			System.out.println(lis);
		}
	}

}
