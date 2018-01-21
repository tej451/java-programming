package com.concurrent;

public class TestThreadException {
//when an exception ocurred in the thread and If not caught thread will die
	public static void main(String args[]){
		new Thread(new Runnable(){
			public void run(){
				try{
					System.out.println(1/0);
					System.out.println("thread processing..");
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("in catch..");
				}
				finally{
					System.out.println("in finally");
				}
				System.out.println("normal processing after catch..");
			}
		}).start();
	}
}
