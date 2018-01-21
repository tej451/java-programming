package com.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFutureUsage {
/**
 * if we will start one thread in try and another in catch, just to ensure that if any runtime 
 * exception would have thrown in try then thread in catch must be executed.
 * but if we will do by using thread catch will never be executed
 * solution is to use concurrent API Future get method that will give u ExecutionException and catch will be executed  
 * 
 */
	public static void main(String args[]){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		try{
			//new Thread(new Thread1()).start();
			
			Future future = executor.submit(new Thread1());
			Object obj = future.get();
			System.out.println(obj);
			if(obj != null){
				System.out.println(obj);
			}
		}catch(ExecutionException e){
			System.out.println("ExecutionException");
			//new Thread(new Thread2()).start();
			executor.submit(new Thread2());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException");
			e.printStackTrace();
		}
	}
}

class Thread1 implements Runnable{
	public void run(){
		System.out.println("Thread1..");
		throw new RuntimeException();
		
	}
}

class Thread2 implements Runnable{
	public void run(){
		System.out.println("Thread2..");
	}
}
