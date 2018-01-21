package com.concurrent;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * ince a ThreadLocal is a reference to data within a given Thread, you can end up with classloading leaks when using ThreadLocals in application servers which use thread pools. You need to be very careful about cleaning up any ThreadLocals you get() or set() by using the ThreadLocal's remove() method.

If you do not clean up when you're done, any references it holds to classes loaded as part of a deployed webapp will remain in the permanent heap and will never get garbage collected. Redeploying/undeploying the webapp will not clean up each Thread's reference to your webapp's class(es) since the Thread is not something owned by your webapp. Each successive deployment will create a new instance of the class which will never be garbage collected.

You will end up with out of memory exceptions due to java.lang.OutOfMemoryError: PermGen space and after some googling will probably just increase -XX:MaxPermSize instead of fixing the bug.
 */
public class ThreadLocalTest {

    public static void main(String args[]) throws IOException {
        Thread t1 = new Thread(new Task());  
        Thread t2 = new Thread( new Task());
     
        t1.start();
        t2.start();      
     
    }
   
    /*
     * Thread safe format method because every thread will use its own DateFormat
     */
    public static String threadSafeFormat(Date date){
        DateFormat formatter = PerThreadFormatter.getDateFormatter();
        return formatter.format(date);
    }
   
}


/*
 * Thread Safe implementation of SimpleDateFormat
 * Each Thread will get its own instance of SimpleDateFormat which will not be shared between other threads. *
 */
class PerThreadFormatter {

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {

        /*
         * initialValue() is called
         */
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName());
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    };

    /*
     * Every time there is a call for DateFormat, ThreadLocal will return calling
     * Thread's copy of SimpleDateFormat
     */
    public static DateFormat getDateFormatter() {
        return dateFormatHolder.get();
    }
    
    public void removeIt(){
    	dateFormatHolder.remove();
    }
}

class Task implements Runnable{
   
    @Override
    public void run() {
        for(int i=0; i<2; i++){
            System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: " + ThreadLocalTest.threadSafeFormat(new Date()) );
        }      
    }
}