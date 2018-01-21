package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * FutureTask represents a cancellable asynchronous computation in concurrent Java application. 
 * This class provides a base implementation of Future, with methods to start and cancel a computation, query to 
 * see if the computation is complete, and retrieve the result of the computation. The result can only be retrieved 
 * when the computation has completed; the get methods will block if the computation has not yet completed. 
 * A FutureTask object can be used to wrap a Callable or Runnable object. Since FutureTask also implements Runnable, 
 * it can be submitted to an Executor for execution.

 */
public class FutureTest {

	public static void main(String[] args) 
	{
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

		Random random = new Random();

		for (int i=0; i<4; i++)
		{
			Integer number = random.nextInt(10);
			FactorialCalculator calculator  = new FactorialCalculator(number);
			//System.out.println(executor.getCorePoolSize());
			Future<Integer> result = executor.submit(calculator);
			//to cancel the task
			/*if(!result.isDone()){
				System.out.println("interrupted!!");
				result.cancel(true);
				
			}*/
			resultList.add(result);
		}

		for(Future<Integer> future : resultList)
		{
			try
			{
				if(!future.isDone()){
					//boolean result = future.cancel(true);
					System.out.println("Future get: "+future.get() );
				}
				System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}catch(ExecutionException e){
				e.printStackTrace();
			}
		}
		//shut down the executor service now
		executor.shutdown();
	}
}
