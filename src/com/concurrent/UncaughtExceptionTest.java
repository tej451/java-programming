package com.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionTest {
	public static void main(String args[]){
		new Thread(new Computation()).start();
	}
}


class Computation implements Runnable
{
   @Override
   public void run()
   {
	   Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
      System.out.println(Integer.parseInt("123"));
      System.out.println(Integer.parseInt("234"));
      System.out.println(Integer.parseInt("345"));
      System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
      System.out.println(Integer.parseInt("456"));
   }
}

class ExceptionHandler implements UncaughtExceptionHandler
{
   public void uncaughtException(Thread t, Throwable e)
   {
	  System.out.printf("Thread status: %s\n", t.getState());
      System.out.printf("An exception has been captured\n");
      System.out.printf("Thread: %s\n", t.getId());
      System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
      System.out.printf("Stack Trace: \n");
      e.printStackTrace(System.out);
      System.out.printf("Thread status: %s\n", t.getState());
      new Thread(new Computation()).start();
   }
}