package com.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
/*
 * A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the
 *  collection. Stream API will allow sequential as well as parallel execution. 
 * 
 * Collection interface has been extended with stream() and parallelStream() default methods to get 
 * the Stream for sequential and parallel execution.
 * 
 * Notice that parallel processing values are not in order, so parallel processing will be very helpful 
 * while working with huge collections.
 * 
 * java 8 Collection API improvements
 * 
 * Iterator default method forEachRemaining(Consumer action) to perform the given action for each remaining 
 * element until all elements have been processed or the action throws an exception.
 * 
 * Collection default method removeIf(Predicate filter) to remove all of the elements of this collection that 
 * satisfy the given predicate.
 */
	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		
		//using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
		//using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel="+p));
		
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

	}

}
