package com.polymorphism;

class X {
	int x = 9;
	static int j = 2;
	 public static void jout(String s) {
		 j +=2;
	    System.out.println(s);
	 }
	 static void amethod() {
	    jout("In X, amethod()");
	 }
	 
	 public void change(int x){
		 this.x += x;
		 System.out.println(this.x);
	 }
	}
	class Y extends X {
		int x = 10;
	 static void amethod() {
	    jout("In Y, amethod()");
	 }
	}
	class Z extends Y {
	 static void amethod() {
	    jout("In Z. amethod()");
	 }
	}
	public class Test{
	 public static void main (String[] args) {
	    X xy = new Y();
	    X xz = new Z();
	    Y yz = new Z();

	    xy.amethod();
	    xy.change(10);
	    System.out.println("xy.x: "+xy.x+ " xy.j: "+xy.j);
	    System.out.println("xz.x: "+xz.x+ " xz.j: "+xz.j);
	    xz.amethod();
	    xz.change(20);
	    System.out.println("xy.x: "+xy.x+ " xy.j: "+xy.j);
	    System.out.println("xz.x: "+xz.x+ " xz.j: "+xz.j);
	    yz.amethod();
	    yz.change(30);
	    System.out.println("xy.x: "+xy.x+ " xy.j: "+xy.j);
	    System.out.println("xz.x: "+xz.x+ " xz.j: "+xz.j);
	    System.out.println("yz.x: "+yz.x+ " yz.j: "+yz.j);
	 }
	}
