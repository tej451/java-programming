package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// in reentrant lock we need to call unlock explicitly in finally, otherwise if exception would be thrown lock can never
// be released, unless you unlocked in finally and other thread waiting for the lock is blocked whereas in case of synchronized thread releases the lock 
// it acquired when exception occured.
public class ReentrantLockTest<E>
	{
	    private final Lock lock = new ReentrantLock();
	    private final List<E> list = new ArrayList<E>();
	    private static volatile int i = 0;
	    public void set(E o)
	    {
	    	System.out.println("Before lock - "+Thread.currentThread().getName()+" - "+System.nanoTime()+ " - ");
	    	try
	    	{ 
	    		lock.lockInterruptibly();
	    		Condition condition= lock.newCondition();
	    		condition.signal();
	    		System.out.println("After lock - "+Thread.currentThread().getName()+" - "+System.nanoTime());

	    		//System.out.println("before "+i+" - "+ Thread.currentThread().getName());
	    		i++;
	    		//System.out.println("after "+i+" - "+ Thread.currentThread().getName());
	    		E e = (E) String.valueOf(i);
	    		list.add(e);
	    		Thread.sleep(2000);
	    		System.out.println("************Adding "+e+"element by thread"+Thread.currentThread().getName());
	    		//System.out.println(1/0);
	    	}catch(InterruptedException e){
	    		e.printStackTrace();
	    	}finally{
	    		lock.unlock();
	    	}

	    }
	    
	    public void set1(E o)
	    {
	            
	    	try
	    	{
	    		lock.lock();
	    		System.out.println("Before lock int - "+Thread.currentThread().getName()+" - "+System.nanoTime()+ " - ");
	    		Condition condition= lock.newCondition();
	    		condition.await();
	    		System.out.println("After lock int - "+Thread.currentThread().getName()+" - "+System.nanoTime());
	    		//System.out.println("before "+i+" - "+ Thread.currentThread().getName());
	    		
	    			try{
	    				i++;
	    				//System.out.println("after "+i+" - "+ Thread.currentThread().getName());
	    				E e = (E) String.valueOf(i);
	    				list.add(e);
	    				Thread.sleep(1000);
	    				System.out.println("************Adding "+e+" element by thread "+Thread.currentThread().getName());
	    			}catch(InterruptedException e){
		            	e.printStackTrace();
		            }finally
	    			{
	    				//System.out.println("unlock "+i+" - "+Thread.currentThread().getName());
	    				lock.unlock();
	    			}
	    		
	    	}catch(InterruptedException e){
	    		e.printStackTrace();
	    	}
	            
	    }
	    
	    public void set2(E o)
	    {
	            
	    	
	    		System.out.println("Before lock int - "+Thread.currentThread().getName()+" - "+System.nanoTime()+ " - ");
	    		Thread.interrupted();
	    		System.out.println("After lock int - "+Thread.currentThread().getName()+" - "+System.nanoTime());
	    		//System.out.println("before "+i+" - "+ Thread.currentThread().getName());
	    		
	    			try{
	    				i++;
	    				//System.out.println("after "+i+" - "+ Thread.currentThread().getName());
	    				E e = (E) String.valueOf(i);
	    				list.add(e);
	    				Thread.sleep(1000);
	    				System.out.println("************Adding "+e+" element by thread "+Thread.currentThread().getName());
	    			}catch(InterruptedException e){
		            	e.printStackTrace();
		            }finally
	    			{
	    				//System.out.println("unlock "+i+" - "+Thread.currentThread().getName());
	    				lock.unlock();
	    			}
	    		
	    	
	            
	    }
	    public static void main(String[] args)
	    {
	            final ReentrantLockTest<String> lockExample = new ReentrantLockTest<String>();
	            Runnable syncThread = new Runnable()
	            {
	                @Override
	                public void run()
	                    {
	                       
	                        	//System.out.println("syncThread "+i);
	                            lockExample.set(String.valueOf(i));
	                        }
	                    
	            };
	            Runnable lockingThread = new Runnable()
	            {
	                @Override
	                public void run()
	                    {
	                        
	                        	//System.out.println("lockingThread "+i);
	                            lockExample.set1(String.valueOf(i));
	                        }
	                    
	            };
	            Thread t1 = new Thread(syncThread, "syncThread");
	            Thread t2 = new Thread(lockingThread, "lockingThread");
	            t1.start();
	            final int threadCount = 20;
	    		final ExecutorService service = Executors.newFixedThreadPool(threadCount);
	    		for (int i=0; i< threadCount; i++) {
	    			service.execute(syncThread);
	    		}
	            t2.start();
	            //t1.interrupt();
	    		/*for (int i=0; i< threadCount; i++) {
	    			service.execute(syncThread);
	    		}*/
	    		
	    }
	}
