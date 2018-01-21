package com.test;

public class ThreadBasics {

	public static void main(String rags[]){
		Thread t = new Thread(new ThreadEx(), "A");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getState());
		t.start();
	}
}

class ThreadEx implements Runnable{
	
	public void run(){
		for(int i =0; i<10; i++){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("run"+i+" - "+Thread.currentThread().getName());
		}
	}
}
