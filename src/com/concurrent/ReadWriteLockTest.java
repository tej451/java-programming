package com.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * read -> read (lock granted)
 * read -> write then read (in order lock will be granted), read will be blocked, write execute/finishes first then read
 * write -> read then write(in order execution), read than write
 * read -> read then write(in order execution), read than write
 * write -> write then read(in order execution), write than read
 */
public class ReadWriteLockTest {

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	Lock writeLock = readWriteLock.writeLock();
	Lock readLock = readWriteLock.readLock();
	private final List<String> list = new LinkedList<String>();
	
	public void set(String o){
		System.out.println("before writeLock lock .. "+o);
		writeLock.lock();
		try{
		list.add(o);
		System.out.println("Adding to list, element: "+o);
		}finally{
			writeLock.unlock();
			System.out.println("after writeLock unlock .. "+o);
		}
	}
	
	public String get(int i){
		System.out.println("before readLock lock .. "+i);
		readLock.lock();
		try{
			String element =  list.get(i);
			System.out.println("Retrieving from list, element: "+element);
			return element;
		}finally{
			readLock.unlock();
			System.out.println("after readLock unlock .. "+i);
		}
	}
	
	public static void main(String args[]){
		final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
	/*	new Thread(){
			public void run(){
				
			}
		}.start();*/
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++){
					readWriteLockTest.set(i+"");
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++){
					readWriteLockTest.get(i);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=5; i<10; i++){
				readWriteLockTest.set(i+"");
				}
			}
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				readWriteLockTest.get(2);
				readWriteLockTest.get(3);
				for(int i=5; i<10; i++){
					readWriteLockTest.get(i);
				}
			}
		}).start();
	}
	
}
