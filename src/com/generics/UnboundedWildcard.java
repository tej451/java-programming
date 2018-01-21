package com.generics;

import java.util.List;

public class UnboundedWildcard {

	public static <T> void printList(List<T> list){
		for(T t:list){
			System.out.print(t + " ");
		}
		System.out.println();
	}
	
	public static void printListObject(List<Object> list){
		for(Object t:list){
			System.out.print(t + " ");
		}
		System.out.println();
	}
	
	public static void printListObject1(Object list){
		//for(Object t:list){
			System.out.print(list + " ");
		//}
		System.out.println();
	}
	
	//It is better when we do not limit the type applicable for the method
	public static void printListUBWildcard(List<?> list){
		for(Object t:list){
			System.out.print(t + " ");
		}
		System.out.println();
	}
	
	public static void wildcardUseToConvertToNumber(List<? extends Number> numbers){
		for(Number num : numbers){
			System.out.println(num);
		}
	}
	
	public static void printSubtypes(Object obj){
		System.out.println(obj);
	}
}
