package com.concurrent;

public class JoinEx {
	public static void main(String a[]){
		Thread t = new Thread("A"){
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		};
		Thread t1 = new Thread("B"){
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		};
		Thread t2 = new Thread("C"){
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		};
		t.start();
		try {
			t.join();
			t1.start();
			t1.join();
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
