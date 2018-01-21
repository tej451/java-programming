package com.polymorphism;

public class OverloadTest extends A{
	public static void main(String args[]){
		/*Overloading should have any of the following contract:
    Different method signature and different number or type of parameters.
    Same method signature but different number of parameters.
    Same method signature and same number of parameters but of different type*/
		A obj = new A();
		//obj.testIt();
		obj.testIt(1);
		System.out.println("obj.i: "+obj.i+" obj.j: "+obj.j+ " - " +A.i);
		A a2 = new A();
		a2.testIt(2);
		System.out.println("obj.i: "+a2.i+" obj.j: "+a2.j+ " - " +A.i);
		System.out.println("obj.i: "+obj.i+" obj.j: "+obj.j+ " - " +A.i);
	}

}

class A{
	public int j = 0;
	static int i = 0;
	public void testIt(int a, int b){
		i =5;
		System.out.println("A -"+i);
	}
	
	public int testIt(int a){
		i = a;
		j = a;
		System.out.println("A 1 - "+i +"j: "+j);
		return i;
	}
}
