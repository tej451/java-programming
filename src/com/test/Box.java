package com.test;

public class Box<T> {

	T obj;
	
	public T getT(){
		return obj;
	}
	
	public void setT(T obj){
		this.obj = obj;
	}
	
	public <U> void ensure(U u){
		System.out.println(obj.getClass().getName());
		System.out.println(u.getClass().getName());
		
	}
}
