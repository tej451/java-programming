package com.java8.features;

public class TestInterface implements Interface1, Interface2{
	/*
	 * Duplicate default methods named log with the parameters (String) and (String) are inherited from the types Interface2 and Interface1
	 */
	public static void main(String args[]){
		TestInterface testInterface = new TestInterface();
		testInterface.log("shruti");
		testInterface.print("shruti print");
	}
	
	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
		Interface2.print("abc1");
	}
	
	public void print(String str){
		System.out.println("main Printing "+str);
	}
}

interface Interface1{
	//public static final int variable = 0;
	//public abstract void testAlgo();
	
	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Interface1 Printing "+str);
	}
	
	//trying to override Object method gives compile time error as
	//"A default method cannot override a method from java.lang.Object"
	
	/*default String toString(){
		return "i1";
	}*/
}

interface Interface2 {
	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Interface2 Printing "+str);
	}
}


