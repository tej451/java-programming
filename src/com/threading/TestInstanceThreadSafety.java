package com.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/*
 * Which of the following instances are threadsafe to be used concurrently?
a. String  
b. Immutable Objects 
c. Instances of a class with no state(neither static nor non-static)
d. none of them
e. all of them(a, b,c)
Answer:e

9. Which of the following are not atomic for a volatile variable in a multithreaded environment?
a. an increment operation(i++) on a primitive volatile variable
b. reading a boolean volatile variable for checking the termination flag.
c. reading or writing into double volatile variables
d. calling a non synchronized method on a volatile reference variable
e. both b & c            
Answer: a

 */
public class TestInstanceThreadSafety {

	public static void main(String[] args) throws InterruptedException{
		String str = "test";
		Thread t = new Thread(new InstanceTest(str));
		t.start();
		Thread.sleep(1000);
		Executor executor = Executors.newFixedThreadPool(3);
		for(int i=0; i<3; i++){
			executor.execute(new InstanceTest(str));
		}
		
	} 
}

class InstanceTest implements Runnable{
	String str = null;
	public InstanceTest(String str){
		this.str = str;
	}

	@Override
	public void run() {
		str +="instance";
		System.out.println("changed to "+str +" by "+Thread.currentThread());
	}
	
}

