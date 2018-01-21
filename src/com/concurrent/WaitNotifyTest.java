package com.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitNotifyTest {

	public static void main(String args[]){
		Queue queue = new LinkedList();
		int i =0;
		Thread producer = new Thread(new Producer(queue, i));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
		//System.out.println("Producer state: "+producer.getState());
		//System.out.println("Consumer state: "+consumer.getState());
	}
}

class Producer implements Runnable{
	Queue queue;
	int i = 0;
	public Producer(Queue queue, int i){
		this.queue = queue;
		this.i = i;
	}

	public void run(){
		for(int i=0; i<5; i++){
			synchronized(queue){
				while(queue.size() > 0){
					try{
						System.out.println("waiting!! queue is full.. ");
						queue.wait();
						//i.wait();
						//we cannot call wait/notify on primitive types like i
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("producing task.."+i);
				queue.offer(i);
				System.out.println("producer1 notify called.");
				queue.notify();
				System.out.println("producer2 notify called.");
			}
			System.out.println("Producer state: "+Thread.currentThread().getState());
		}
	}
}

class Consumer implements Runnable{
	Queue queue;
	public Consumer(Queue queue){
		this.queue = queue;
	}

	public void run(){
		while(true){
			synchronized(queue){
				while(queue.size() == 0){
					try{
						System.out.println("waiting!! queue is empty.. ");
						queue.wait();
						System.out.println("Consumer state wait: "+Thread.currentThread().getState());
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				int number = (Integer)queue.poll();
				System.out.println("consuming task.."+number);
				System.out.println("consumer notify called.");
				queue.notify();
			}
			System.out.println("Consumer state: "+Thread.currentThread().getState());
		}
	}
}
