package com.concurrent;

public class WaitNotifyAllTest {
	volatile boolean flag = false;
	public static void main(String args[]) throws InterruptedException{
		
		final WaitNotifyAllTest task = new WaitNotifyAllTest();
		Runnable waitTask = new Runnable(){
			public void run(){
				try {
                    task.waitTask();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " finished Execution");
			}
		};
		
		Runnable notifyTask = new Runnable(){
			public void run(){
				task.notifyTask();
				System.out.println(Thread.currentThread() + " finished Execution");
			}
		};
		
		Thread t1 = new Thread(waitTask, "WT1"); //will wait
        Thread t2 = new Thread(waitTask, "WT2"); //will wait
        Thread t3 = new Thread(waitTask, "WT3"); //will wait
        Thread t4 = new Thread(notifyTask,"NT1"); //will notify
        t1.start();t2.start();t3.start();
        Thread.sleep(200);
        t4.start();
	}
	
	private void waitTask() throws InterruptedException{
		synchronized (this) {
			while(flag != true){
				System.out.println(Thread.currentThread()
						+ " is going to wait on this object");
				wait();
				System.out.println(Thread.currentThread() + " is woken up");
			}
			flag = false; //resetting condition
		}
	}

	private void notifyTask(){
		synchronized (this) {
			while (flag == false){
	            System.out.println(Thread.currentThread()
	            + " is going to notify all or one thread waiting on this object");

	            flag = true; //making condition true for waiting thread
	            //notify(); // only one out of three waiting thread WT1, WT2,WT3 will woke up
	            notifyAll(); // all waiting thread  WT1, WT2,WT3 will woke up
	        }
		}
	}
}


