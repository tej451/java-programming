package com.basic;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = null;
		doSomething(null);
		
		try{
			int a = 1/0;
		}catch(ArithmeticException e){
			System.out.println("ae");
		}catch(Exception e){
			System.out.println("ex");
		}finally{
			System.out.println("finally");
		}
	}
	
	public static void doSomething(Object obj){
		System.out.println("object impl");
	}
	
	public static void doSomething(String obj){
		System.out.println("string impl");
	}

}
