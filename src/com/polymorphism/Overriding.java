package com.polymorphism;

public class Overriding {
	public static void main(String args[]){
		// This is static method defined in the Sub class
		// which does not override the Super doThis()
		// only hide it.
		// proved in the Overriding.main()
		Super obj = new Sub();
		obj.insertCopy(); // Will call Super insertCopy since Sub insertCopy do not Overrides Super insertCopy
		obj.insertCopy1();
		
		Sub ob = (Sub)obj;
		ob.insertCopy();
		ob.insertCopy1();
		
		Sub.test();
	}
}

class Super{
	public static void insertCopy(){
		System.out.println("insertCopy Super");
	}
	
	public void insertCopy1(){
		System.out.println("insertCopy1 Super");
	}
}

class Sub extends Super{
	// this will hide the static insertCopy in Super
	public static void insertCopy(){
		System.out.println("insertCopy Sub");
	}
	
	public void insertCopy1(){
		//super.insertCopy1(); // Subclass calls the Superclass method
		System.out.println("insertCopy1 Sub");
	}
	
	 public static void test() {
		   // since we are in class Sub's scope
		   // call insertCopy directory will refer to Sub's insertCopy,
		   // Super's insertCopy is hidden
		 insertCopy(); //in class Sub's static insertCopy

		   // However, we still can call Super's insertCopy even in Sub's territory
		   Super.insertCopy(); //in class Super's static insertCopy        
	 }
}
