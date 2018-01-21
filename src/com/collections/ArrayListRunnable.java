package com.collections;

import java.util.ArrayList;
import java.util.List;

import com.cloning.TestClone;

public class ArrayListRunnable extends TestClone implements Runnable   {
	// shared by all threads
	private List<Integer> list = new ArrayList<Integer>();
	public ArrayListRunnable() {
		// add some elements
		for (int i = 0; i < 100000; i++) {
			list.add(i);
		}
	}
	// might run concurrently, you cannot be sure
	// to be safe you must assume it does, u might get different results on each run
	public void run() {
		String tName = Thread.currentThread().getName();
		synchronized (list) {
			while (!list.isEmpty()) {
				System.out.println(tName + " removed " + list.remove(0));
			}
		}
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayListRunnable alr = new ArrayListRunnable();
		Thread t1 = new Thread(alr, "T1");
		Thread t2 = new Thread(alr, "T2"); // shared Runnable
		//t1.start();
		//t2.start();
		alr.testIt();
		
	}
	
	public void testIt() throws CloneNotSupportedException{
		//CloneTestSub1 sub = new CloneTestSub1();
		ArrayListRunnable sub =  (ArrayListRunnable) new ArrayListRunnable().clone();
		int j = new ArrayListRunnable().i;
		System.out.println(j+ " : "+sub);
		System.out.println(clone()); // calling protected method through inheritance
		System.out.println(i); // calling protected variable through inheritance
		//System.out.println("AftTestCer: " +sub);
	}
	
	/*protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}*/
}
