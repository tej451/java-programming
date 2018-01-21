package com.polymorphism;

public class Test1 {
	public static void main(String args[]){
		Test2 t = new Test2();
		System.out.println(t.i+" - "+t.j);
		t.change();
		System.out.println(t.i+" - "+t.j);
		Test2 t1 = new Test2();
		System.out.println(t1.i+" - "+t1.j);
		
	}
}

class Test2{
	static int i = 2;
	int j = 3;
	 void change(){
		i = i+5;
		j = j+2;
	}
}
