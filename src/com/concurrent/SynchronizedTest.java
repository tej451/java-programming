package com.concurrent;

import java.util.LinkedList;
import java.util.Queue;


// no matter how you exist synchronized block, either normally by finishing execution or abruptly by throwing exception, 
//thread releases the lock it acquired while entering that synchronized block

public class SynchronizedTest {
public static Queue queue = new LinkedList();
	public static void main(String args[]){
		new Thread(new Runnable(){
			public void run(){
				synchronized (queue) {
					queue.add("str");
					System.out.println(queue.size());
					System.out.println("in synchronized run 1..");
					System.out.println(1/0);
				}
			}
		}).start();
		new Thread(new Runnable(){
			public void run(){
				synchronized (queue) {
					try{
					queue.add(2);
					Thread.sleep(1000);
					System.out.println("in synchronized run 2..");
					System.out.println(queue.size());
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}

