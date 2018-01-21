package com.collections;

import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
//backed collection
public class Test {
	
	public static void main(String args[]){
		AtomicInteger atomic = new AtomicInteger(0);
		int i =128;
		System.out.println( i+2);
		HashSet<String> set = new HashSet<String>();
		
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("b", "bb");
		treeMap.put("s", "ss");
		treeMap.put("n", "nn");
		System.out.println(treeMap );
		SortedMap<String, String> sortedMap = null;
		sortedMap = treeMap.subMap("b", "g");
		System.out.println(treeMap +" - "+sortedMap);
		treeMap.put("c", "cc");
		sortedMap.put("f", "ff");
		
		treeMap.put("h", "hh");
		treeMap.put("g", "gg");
		//sortedMap.put("g", "gg"); //java.lang.IllegalArgumentException will be thrown, key out of range is thrown
		//we can put g on treeMap instead
		System.out.println(treeMap+" - "+sortedMap);
		
	}

}
