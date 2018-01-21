package com.concurrent;

public class DeadlockExample {

	public void test()
	{
		//only final variable is permitted inside method
		final String st = "dd";
	}
	
	public static void main(String args[]){
		final String str = "shruti";
		final String str1 = "singh";
	Thread th1 = new Thread(){
		public void run(){
			synchronized (str) {
				System.out.println("Thread1: locked resoure str");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("waiting for lock str1 by thread Thread1");
				synchronized (str1) {
					System.out.println("Thread1: locked resoure str1");
				}
			}
			
		}
	};
	Thread th2 = new Thread(){
		public void run(){
			synchronized (str1) {
				System.out.println("Thread2: locked resoure str1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("waiting for lock str by thread Thread2");
				synchronized (str) {
					System.out.println("Thread2: locked resoure str");
				}
			}
			
		}
	};
	th1.start();
	th2.start();
	}
}
