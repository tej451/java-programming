package com.cloning;

public class CloneTestSub {

	public static void main(String args[]) throws CloneNotSupportedException{
		CloneTestSub sub = new CloneTestSub();
		sub.testIt();
	}
	
	public void testIt( ) throws CloneNotSupportedException{
		//CloneTestSub sub = new CloneTestSub();
		//System.out.println("Before: " +sub);
		
		TestClone sub =  (TestClone) new TestClone().clone();
		System.out.println("AftTestCer: " +sub+" i: "+sub.i);
	}
}
