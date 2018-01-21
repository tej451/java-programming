package com.test.exceptions;

public class SubclassException extends ParentException{
	
	public void testException() throws RuntimeException{
		System.out.println("runtime excpetion..");
	}
	
	public static void main(String args[]){
		ParentException parent = new SubclassException();
		parent.testException();
	}
}
