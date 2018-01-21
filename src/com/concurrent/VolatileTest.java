package com.concurrent;

public class VolatileTest {

	int i = 0;
	boolean isExit = false;
	public static void main(String args[]){
		VolatileTest t = new VolatileTest();
		new Thread(t.new Thread1()).start();
		new Thread(t.new Thread2()).start();
	}
	
	class Thread1 implements Runnable{
		public void run(){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isExit = true;
			i=1;
			
		}
	}
	
	class Thread2 implements Runnable{
		public void run(){
			if(isExit == true){
				System.out.println("i: "+i);
			}
		}
	}
}
