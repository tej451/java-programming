package com.java8.features;

public class MethodReferenceLambda {

	public static void main(String[] args) {
		Thread t = new Thread(MethodReferenceLambda::test); // or () -> test()
		t.start();
	}
	
	static void test(){
		System.out.println("hi");
	}

}
