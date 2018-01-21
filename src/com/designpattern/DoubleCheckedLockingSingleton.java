package com.designpattern;

import java.io.Serializable;

public class DoubleCheckedLockingSingleton implements Cloneable, Serializable{
	private volatile static DoubleCheckedLockingSingleton INSTANCE;
	private DoubleCheckedLockingSingleton() throws Exception{
		if(INSTANCE != null){
			throw new Exception("Singleton already initialized");
		}
	}
	public static DoubleCheckedLockingSingleton getInstance() throws Exception{
		if(INSTANCE == null){
			synchronized (DoubleCheckedLockingSingleton.class) {
				if(INSTANCE == null){
					INSTANCE = new DoubleCheckedLockingSingleton();
					
				}
			}
		}
		return INSTANCE;
	}
	
	public Object clone() throws CloneNotSupportedException{
		//throw new CloneNotSupportedException(); OR 
		//return INSTANCE;
		return INSTANCE;
	}
	
	protected Object readResolve() {
	    return INSTANCE;
	}
	
	/*public String toString(){
		return "Hashcode - "+INSTANCE.hashCode();
	}*/
}
