package com.threading;

class LockExample {
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public synchronized void methodA() { // if we use static synchronized at method level, only one method can be executed at a time
        //synchronized(lockA) {
        	 System.out.println("in methodA"+System.currentTimeMillis());
        	//try {
				//System.out.println(1/0); // at this point after throwing exception, lock will be released here
			/*} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
            System.out.println("in methodA"+System.currentTimeMillis());
            System.out.println("using lockA"+System.currentTimeMillis());
        //}
    }

    public synchronized void methodB() {
        //synchronized(lockB) {
            //method B
        	System.out.println("in methodB"+System.currentTimeMillis());
            System.out.println("using lockB"+System.currentTimeMillis());
        //}
    }
    
    public static void main(String args[]){
    	LockExample a = new LockExample();
    	Thread th1 = new Thread(){
    		public void run(){
    			a.methodA();
    		}
    	};
    	Thread th2 = new Thread(){
    		public void run(){
    			a.methodB();
    		}
    	};
    	th1.start();
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	th2.start();
    }
}
