package com.generics;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.generics.Box;
import com.sun.javafx.image.impl.IntArgb;

public class GenericsTest {
	
	@Test
	public void testNonGenerics(){
		List<Number> list = new ArrayList<Integer>();
		Box box = new Box();
		box.setObj("shruti");
		box.setObj(11);
		String str = (String)box.getObj();
		System.out.println(str);
		
		//instead u can use generic box verion instead of raw Version, since compiler defers risky code to run time as 
		// it does not have enough type safety information
		Box<Integer> boxInt = new Box<>();
		// boxInt.setObj("ss"); // it will fail at compile time
		
	}
	
	//used to limit the type we can use to instantiate a generic type, also used to invoke methods defined in bounds 
	//eg, intValue of Integer/Number
	@Test
	public void testBoundedParam(){
		BoundedTypeParam<Integer> boundedTypeparam = new BoundedTypeParam<>();
		boundedTypeparam.setType(new Integer(10)); // limit the type we can use to instantiate a generic type
		//boundedTypeparam.setType("ss");
		boundedTypeparam.ensure(new Byte((byte) 010101));
		boundedTypeparam.ensure(new Integer(10));
		//boundedTypeparam.ensure("ss"); // compiler will ensure type safety here
	}
	
	@Test
	public void testMethodAlgo(){
		BoundedTypeParam<Integer> boundedTypeparam = new BoundedTypeParam<>();
		Integer[] intarr = {3, 90, 4, 6, 11, 2, 8, 23};
		int result = boundedTypeparam.countGreaterThanWithGenerics(intarr, 10);
		//Assert.assertEquals(3, result);
		String[] strArr = {"shruti", "apple", "citrus", "banana"};
		result = boundedTypeparam.countGreaterThanWithGenerics(strArr, "bb");
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void testBoxParam(){
		BoundedTypeParam<Integer> boundedTypeparam = new BoundedTypeParam<>();
		BoundedTypeParam<Number> boundedNum =  new BoundedTypeParam<>();
		BoundedTypeParam<Integer> boundedInt =  new BoundedTypeParam<>();
		boundedTypeparam.boxTest(boundedNum);
		// boundedTypeparam.boxTest(boundedInt); // only accepts BoundedTypeParam<Number>
	}
	
	@Test
	public void testTypeInference(){
		ArrayList<Box<Integer>> boxList = new ArrayList<>();
		BoxDemo.addBox(new Integer(10), boxList);
		BoxDemo.addBox(new Integer(20), boxList);
		BoxDemo.addBox(new Integer(30), boxList);
		BoxDemo.outputBoxes(boxList);
		ArrayList<Box<Number>> boxListNum = new ArrayList<>();
		Number num= new Double(11);
		BoxDemo.addBox(num, boxListNum);
		BoxDemo.addBox(new Double(22), boxListNum);
		BoxDemo.outputBoxes(boxListNum);
	}
	
	@Test
	public void testTargetTyping(){
		BoxDemo boxDemo = new BoxDemo();
		boxDemo.processStringList(Collections.emptyList()); //public static final <T> List<T> emptyList()
		//Prior to java8, compiler was unable to infer 
		//The compiler requires a value for the type argument T so it starts with the value Object. 
		//Consequently, the invocation of Collections.emptyList returns a value of type List<Object>, 
		//which is incompatible with the method processStringList. 
		//Thus, in Java SE 7, you must specify the value of the value of the type argument as follows:
		//processStringList(Collections.<String>emptyList());
	}
	
	@Test
	public void testUnboundedMethodUsingT(){
		List<Integer> li = Arrays.asList(2, 8, 6, 1, 44);
		List<String> ls = Arrays.asList("aa", "ss", "shruti", "tt");
		//List<Box<String>> lb = Arrays.asList(new Box<>("pencil box"), new Box<>("geometry box"));
		UnboundedWildcard.printList(li);
		UnboundedWildcard.printList(ls);
		//UnboundedWildcard.printList(lb);
	}
	
	@Test
	public void testUnboundedMethodObject(){
		List<Integer> li = Arrays.asList(2, 8, 6, 1, 44);
		List<String> ls = Arrays.asList("aa", "ss", "shruti", "tt");
		List<Object> lo = Arrays.asList("aa", "ss", "shruti", "tt");
		//List<Box<String>> lb = Arrays.asList(new Box<>("pencil box"), new Box<>("geometry box"));
		//UnboundedWildcard.printListObject(li); //compile time error, since List<String> and List<Integer> is not 
		//the subtype of List<Object>
		//UnboundedWildcard.printListObject(ls); //compile time error, List<Object> is not the supertype of List<String> and List<Integer>
		//UnboundedWildcard.printList(lb);
		UnboundedWildcard.printListObject(lo);
		UnboundedWildcard.printListObject1(new Integer(10));
		UnboundedWildcard.printListObject1(new String("10"));
		UnboundedWildcard.printListObject1(new Object());
	}
	
	@Test
	public void testSubtyping(){
		UnboundedWildcard.printSubtypes(new Integer(10));
		UnboundedWildcard.printSubtypes(new String("10"));
		UnboundedWildcard.printSubtypes(new Double(10.0));
	}
	
	@Test
	public void testUnboundedWildcard(){
		List<Integer> li = Arrays.asList(2, 8, 6, 1, 44);
		List<String> ls = Arrays.asList("aa", "ss", "shruti", "tt");
		List<Object> lo = Arrays.asList("aa", "ss", "shruti", "tt");
		UnboundedWildcard.printListUBWildcard(li);
		UnboundedWildcard.printListUBWildcard(ls);
		UnboundedWildcard.printListUBWildcard(lo);
		
	}
	
	@Test
	public void testWildcardForRelationship(){
		
		List<? extends Integer> intList = new ArrayList<>();
		intList = Arrays.asList(1, 4, 2);
		List<? extends Number>  numList = intList;
		//numList.add(new Double(10.0));
		UnboundedWildcard.wildcardUseToConvertToNumber(intList);
		UnboundedWildcard.wildcardUseToConvertToNumber(numList);
	}
}

