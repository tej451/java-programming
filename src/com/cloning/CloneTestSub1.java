package com.cloning;

public class CloneTestSub1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneTestSub1 sub = new CloneTestSub1();
		sub.testIt();
	}

	public void testIt() throws CloneNotSupportedException{
		//CloneTestSub1 sub = new CloneTestSub1();
		//CloneTestSub1 sub =  (CloneTestSub1) new CloneTestSub1().clone();
		System.out.println(new TestClone().clone());
		System.out.println(new TestClone().i);
		//System.out.println("AftTestCer: " +sub);
	}
	
	/*protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}*/
}
