package com.polymorphism;

public class Base implements Cloneable{
	static int i=1; int j=2;
	public static void main(String[] args) throws CloneNotSupportedException{
		i =4; j =3;
		Base base = new Sub1();
		base.doThat(); 
		System.out.println(base.f()); 
		System.out.println(base.i +" - "+base.j);
		base.change();
		Base base1 = new Sub1();
		System.out.println(base1.i +" - "+base1.j);
	}

	public int f() {
		doThat();
		return 20;
	}

	protected int g() {
		return f();
	}
	
	public void change(){
	  this.i = 9; this.j=10;	
	}

	public static void doThat(){
		System.out.println("Base doThat");
	}
}

class Sub1 extends Base {
	static int i=4; int j=5;
	public int f() {
		return -100;
	}
	
	public static void doThat(){
		System.out.println("Sub1 doThat");
	}
}