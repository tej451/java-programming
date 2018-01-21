package com.java8.features;

import java.util.function.BiConsumer;

public class ExceptionhandlingLambda {
	
	public static void main(String args[]){
		int[] arr = {1,2,3,4,5};
		//int key = 2;
		int key = 0;
		//process(arr, key, (k, v) -> System.out.println(k+v)); // using lambda we could invoke multiple operations 
		
		//instead of putting try catch around the lambda, we should create a wrapper lambda and put try catch there
		/*process(arr, key, (k, v) -> {
			try{
				System.out.println(k/v);
			}catch(ArithmeticException e){
				System.out.println("Arithmetic Exception ocurred");
			}
		});*/
		
		//using wrapper lambda for exception handling
		process(arr, key, wrapperLambda((k, v) -> System.out.println(k/v)));
	}
	
	
	//using generic approach, but if we want to do some other operation will have to write one more method like below
	public static void process(int[] arr, int key){
		for(int element: arr){
			System.out.println(element + key);
		}
	}
	
	//using lambda
	public static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer){
		for(int element: arr){
			consumer.accept(element, key);
		}
	}
	
	//using wrapperlambda for exception handling
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (k, v) ->{
			try{
				consumer.accept(k, v);
			}catch(ArithmeticException e){
				System.out.println("Exception caught in wrapper lambda");
			}
		};
	}

}
