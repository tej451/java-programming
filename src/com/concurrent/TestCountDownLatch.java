package com.concurrent;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

public class TestCountDownLatch {
	@Test
    public void shouldCreateOnlySingleIntsanceOfAClassWhenTestedWithParallelThreads() throws InterruptedException {
       // final ObjectFactory factory = new ObjectFactory();
        final CountDownLatch startSignal = new CountDownLatch(1);
        class MyThread extends Thread {
        	ObjectFactory instance;
            @Override
            public void run() {
                try {
                	//all threads are waiting here
                    startSignal.await();
                    //once any thread call countdown, all threads calls getInstance 
                    instance = ObjectFactory.getInstance();
                } catch (InterruptedException e) {
                    // ignore
                }
            }
        }
        int threadCount = 10;
        MyThread[] threads = new MyThread[threadCount];
        for (int i = 0;i< threadCount;i++) {
            threads[i] =  new MyThread();
            threads[i].start();
        }
        startSignal.countDown();
        for (MyThread myThread : threads) {
            myThread.join();
        }
        ObjectFactory instance = ObjectFactory.getInstance();
        for (MyThread myThread : threads) {
            assertEquals(instance, myThread.instance);
        }
    }
	
	//A useful property of a CountDownLatch is that it doesn't require that threads calling countDown wait for the count to reach zero before proceeding, 
	//it simply prevents any thread from proceeding past an await until all threads could pass or the countdown counted down to zero. it is advanceable
	//CountDownLatch will not throw any exception when timeout occurs while waiting on await, it simply timeout on await and continues execution, throws interruptedException when interrupted
	@Test
	public void testCountDown(){
		final CountDownLatch latch = new CountDownLatch(3);
		class Carriers implements Runnable{
			public void run(){
				/*try{
				//Thread.sleep(10000);
				}catch(InterruptedException e){
					System.out.println(e);
				}*/
				
				latch.countDown();
				System.out.println("Count - "+latch.getCount());
				System.out.println(Thread.currentThread().getName() +" Time -"+System.nanoTime());
				/*}catch(Exception e){
					e.printStackTrace();
				}*/
			}
		}
		ExecutorService executors = Executors.newFixedThreadPool(3);
		List<Future<Integer>> future = new ArrayList<Future<Integer>>();
		for(int i =0; i<3; i++){
			future.add((Future<Integer>)executors.submit(new Carriers()));
		}
		try {
			
			Thread t = new Thread(new Carriers());
			t.start();
			
			System.out.println(Thread.currentThread().getName() + " waiting.. ");
			//latch.await();
			latch.await(10, TimeUnit.SECONDS); // call interrupt after timeout happens
			//Thread.currentThread().interrupt();
			for(Future<Integer> future1 : future){
			Object futureResult = future1.get();
			System.out.println(futureResult);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Next pending task");
	}
	
	// A CyclicBarrier supports an optional Runnable command that is run once per barrier point, after the last thread in the party arrives, 
	//but before any threads are released. This barrier action is useful for updating shared-state before any of the parties continue.
	// BrokenBarrierException was thrown if, another thread was interrupted or timed out while the current thread was waiting,
	//or the barrier was reset, or the barrier was broken when await was called, or the barrier action (if present) 
	//failed due an exception.
	@Test
	public void testCyclicBarrier(){
		final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable(){
			public void run(){
				System.out.println("Updating shared state in cyclic barrier runnable");
			}
		});
		
		class MyThread implements Runnable{
			public void run(){
				System.out.println("In processing .."+Thread.currentThread().getName());
				try {
					System.out.println("await called "+barrier.getNumberWaiting());
					barrier.await();
					
					System.out.println(Thread.currentThread().getName()+" barrier count -"+barrier.getNumberWaiting());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			//new MyThread();
			Executor executor = Executors.newFixedThreadPool(2);
			for(int i=0; i<2; i++){
				executor.execute(new MyThread());
			}
			new Thread(){
				public void run(){
					System.out.println("In processing .."+Thread.currentThread().getName());
					System.out.println("await called "+barrier.getNumberWaiting());
					try {
						barrier.await(30, TimeUnit.SECONDS); // if timeout happens while other threads are waiting then current would throw timeoutexception while 
						//other waiting thraeds would throw brokenbarrierException
						//barrier.reset(); //if i call barrier.reset while other threads were waiting then brokenbarrierException would be thrown by waiting thread
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TimeoutException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
			System.out.println("await called "+barrier.getNumberWaiting());
			barrier.await();
			
			System.out.println(Thread.currentThread().getName()+" barrier count -"+barrier.getNumberWaiting());
			Thread.sleep(2000);
			System.out.println(" waiting for processing..");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testBlockingQueue(){
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);
		
		class Producer1 implements Runnable{
			BlockingQueue queue;
			public Producer1(BlockingQueue blockingQueue){
				queue = blockingQueue;
			}
			public void run(){
				try{
				queue.put(new Integer(10));
				//System.out.println("Produced: "+queue.element());
				Thread.sleep(1000);
				queue.put(new Integer(20));
				//System.out.println("Produced: "+queue.element());
				Thread.sleep(1000);
				queue.put(new Integer(30));
				queue.put(new Integer(40));
				queue.put(new Integer(50));
				//System.out.println("Produced: "+queue.element());
				//Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		
		class Consumer1 implements Runnable{
			BlockingQueue queue;
			public Consumer1(BlockingQueue blockingQueue){
				queue = blockingQueue;
			}
			
			public void run(){
				try{
					System.out.println("Consumed: "+queue.take());
					System.out.println("Consumed: "+queue.take());
					System.out.println("Consumed: "+queue.take());
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		new Thread(new Producer1(blockingQueue)).start();
		new Thread(new Consumer1(blockingQueue)).start();
	}
	
	//CyclicBarrier throws TimeoutException while waiting on await and other parties throws BrokenBarrierException
	//on calling interrupt it throws Interrupted exceptiona and other waiting parties throws BrokenBarrierException
	@Test
	public void TestCyclicBarrierMapReduce(){
		class Reduce implements Runnable{
			ArrayList<Integer> list;
			public Reduce(ArrayList<Integer> list){
				this.list = list;
			}
			public void run(){
				System.out.println("All servers are UP!!");
				System.out.println(list);
			}
		}
		class ServerThread implements Runnable{
			CyclicBarrier cb;
			ArrayList<Integer> list;
			String name;
			public ServerThread(CyclicBarrier barrier, String name,ArrayList<Integer> al){
				cb = barrier;
				list = al;
				this.name = name;
			}
			public void run(){
				try{
					System.out.println(name+" is starting..");
					list.add(new Integer(11));
					cb.await(10, TimeUnit.SECONDS);
					System.out.println(name+" startup completed sucessfully");
				}catch(InterruptedException e){
					e.printStackTrace();
				}catch(BrokenBarrierException e){
					e.printStackTrace();
				}catch (TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		CyclicBarrier cb = new CyclicBarrier(3, new Reduce(list));
		new Thread(new ServerThread(cb, "DB Server", list)).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new ServerThread(cb, "Application Server", list)).start();
		Thread t = new Thread(new ServerThread(cb, "Web Server", list));
		t.start();
		//t.interrupt();
		
	}
	
	@Test
	public void testBlockingQueue1(){
		final BlockingQueue blockingQueue = new ArrayBlockingQueue<Integer>(3);
		/*
		 * add - IllegalStateException - if the element cannot be added at this time due to capacity restrictions
		 * element/remove - NoSuchElementException - if the queue is empty
		 */
		class Producer implements Runnable{
			public void run(){
				for(int i=0; i<10;i++){
					System.out.println("Producing: "+i);
					try {
						blockingQueue.put(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		class Consumer implements Runnable{
			public void run(){
				while(true){
					int j;
					try {
						j = (Integer)blockingQueue.take();
						System.out.println("Consuming: "+j);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}
}
