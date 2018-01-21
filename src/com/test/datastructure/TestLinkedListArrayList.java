package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;

public class TestLinkedListArrayList {

	public static void main(String args[]){
		List<String> list = new ArrayList<>();
		
		java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
		
		for(int i = 0; i<5; i++){
			list.add(i+"");
			linkedList.add(i+"");
		}
		
		//list.add(11, 11+"");
		linkedList.add(11, 11+"");
	}
}
