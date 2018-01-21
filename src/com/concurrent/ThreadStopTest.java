package com.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadStopTest {

	 class Runner implements Runnable{
		 boolean bExit = false;

		public void exit(boolean bExit){
			this.bExit = bExit;
		}

		@Override
		public void run(){
			while(!bExit){
				System.out.println("Thread is running"+Thread.currentThread().getName());
				/*try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}*/
			}
		}
	}

	public static void main(String args[]){
		ThreadStopTest inst = new ThreadStopTest();
		Executor executors = Executors.newFixedThreadPool(10);
		Runner t1 = inst.new Runner();
		new Thread(t1, "T-11").start();
		for(int i=0; i<10; i++){
			executors.execute(t1);
		}
		
		
		t1.bExit = true;
	}


}
