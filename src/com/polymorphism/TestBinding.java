package com.polymorphism;

// TestBinding.java
class Parent {
	String s = "string in Base";
	
	static int i = 1;
	int j = 2;
	
	void init(){
		System.out.println("init() call in Base "+s);

	}
	
	void doEditing(){
		i+=1;
		j+=1;
	}
}
class SubBase extends Parent{
	String s = "string in SubBase";
	
	static int i = 5;
	int j=3;
	
	void init(){
		System.out.println("init() call in SubBase "+s);

	}
	
	
}

public class TestBinding {
	public static void main(String[] args) {
		Parent b = new SubBase();

		// static binding on instance fields
		System.out.println(b.s); //string in Base
		// dynamic binding on instance methods
		b.init();             //init() call in SubBase
		
		System.out.println(b.i +" - "+b.j); //1, 2
		
		System.out.println(b.i +" - "+b.j);
		
		Parent b1 = new SubBase();
		System.out.println(b1.i +" - "+b1.j);
	}
}
