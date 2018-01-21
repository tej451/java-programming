package com.test.exceptions;

public class ParentException {

	public void testException() throws ArithmeticException{
		int i = 1/0;
		System.out.println("exception occured..");
	}
}
