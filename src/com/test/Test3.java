package com.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test3 {
	
	public static void main(String args[]){
		ArrayList<String> list = new ArrayList<String>();
		String s = "";
		s = s.concat("a");
		s = s.concat("*");
		System.out.println("str - "+s);
		for(int i=0; i<10; i++){
		list.add("str"+i);
		}
		list.add("s1");
		//System.out.println(list.);
		list.add("s2");
		list.add("s3");
		list.add("s4");
		list.add("s5");
		list.add("s5");
		list.add("s5");
		list.add("s5");
		
		System.out.println("hi");
		System.out.println(Integer.MAX_VALUE );
	}

	
//	public void ensureCapacity(int minCapacity) {
//		//modCount++;
//		int oldCapacity = elementData.length;
//		if (minCapacity > oldCapacity) {
//		    Object oldData[] = elementData;
//		    int newCapacity = (oldCapacity * 3)/2 + 1;
//	    	    if (newCapacity < minCapacity)
//			newCapacity = minCapacity;
//	            // minCapacity is usually close to size, so this is a win:
//	            elementData = Arrays.copyOf(elementData, newCapacity);
//		}
}
