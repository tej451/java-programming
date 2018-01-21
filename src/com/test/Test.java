package com.test;

import java.util.List;


public class Test {
	static int i=2;
	static int j = 3;
	
	static{
		System.out.println(j);
	}

	public static void main(String[] args) {
		
	}

}

class Thread1 implements Runnable{
	
	 public Thread1(String name) {
		// TODO Auto-generated constructor stub
		 Thread.currentThread().setName(name);
	}

	@Override
	public void run() {
		for (int i=0; i<3; i++){
			Test1.getInstance().setValues(i+"");
		}
		
	}
	
}

class Thread2 implements Runnable{
	
	public Thread2(String name) {
		// TODO Auto-generated constructor stub
		 Thread.currentThread().setName(name);
	}

	@Override
	public void run() {
		for (int i=4; i<7; i++){
			Test1.getInstance().setValues(i+"");
		}
		
	}
	
}

class Thread3 implements Runnable{

	@Override
	public void run() {
		List<Test2> list = Test1.getInstance().getValues();
		System.out.println(list.size());
	}
	
}
