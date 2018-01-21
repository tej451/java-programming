package com.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
//Counting Semaphore in Java maintains specified number of pass or permits, In order to access a shared resource, 
//Current Thread must acquire a permit. If permit is already exhausted by other thread than it can wait until a permit
//is available due to release of permit from different thread. This concurrency utility can be very useful to
//implement producer consumer design pattern or implement bounded pool or resources like Thread Pool, DB Connection pool
//etc. java.util.Semaphore class represent a Counting semaphore which is initialized with number of permits. 
//Semaphore provides two main method acquire() and release() for getting permits and releasing permits. acquire()
//method blocks until permit is available. Semaphore provides both blocking method as well as unblocking method to 
//acquire permits.

public class SemaphoreTest {

    Semaphore binary = new Semaphore(1);
 
    public static void main(String args[]) {
        final SemaphoreTest test = new SemaphoreTest();
        new Thread(){
            @Override
            public void run(){
              test.mutualExclusion();
            }
        }.start();
     
        new Thread(){
            @Override
            public void run(){
              test.mutualExclusion();
            }
        }.start();
        
        Thread t = new Thread(){
            @Override
            public void run(){
              test.mutualExclusion();
            }
        };
        t.start();
       t.interrupt();
     
    }
 
    private void mutualExclusion() {
        try {
        	//System.out.println(binary.isFair());
            //if(binary.tryAcquire()){
        	binary.acquireUninterruptibly();
        	//binary.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
           // }
           // Thread.sleep(1000);

        } /*catch (InterruptedException ie) {
            ie.printStackTrace();
        }*/ finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    }
 
}
