package com.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/*
 * A method has the following definition in which the statement is to create an instance of Object class, and second statement is to use it to enter into a synchronized block inside that method. What would happen in this situation?
a. All threads wait for the lock.
b. only one thread will execute the synchronized block of the method.
c. All the threads will execute the synchronized block
d. none of the above.

	Use the method definition below to explain the question clearly to the candidate
	void method() {
		Object o = new Object();
		synchronized(o) {
						this.x = "abc";
		}
	}
Answer:c
 */
public class TestMultiThread {


	public static void main(String[] args){
		Executor executor = Executors.newFixedThreadPool(3);
		for(int i=0; i<3; i++){
			executor.execute(new Thread1());
		}
	}

}

class Thread1 implements Runnable{
	String x = "10";
	@Override
	public void run() {
		method();
	}
	
	void method() {
		Object o = new Object();
		System.out.println(o);
		synchronized(o) {
			///this.x = "abc";
			System.out.println(this.x+" by thread "+Thread.currentThread());
		}
	}
}
