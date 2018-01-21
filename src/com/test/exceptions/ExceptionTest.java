package com.test.exceptions;

public class ExceptionTest {
	public static void main(String args[]){
		testException();
	}
	
	public static synchronized void testException(){
		try{
			throw new Exception();
		}catch(Exception e){
			System.out.println("in exception");
			e.printStackTrace();
		}finally{
			System.out.println("finally called");
		}
	}
}
