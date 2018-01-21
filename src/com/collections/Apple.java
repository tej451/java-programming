package com.collections;

import java.util.HashMap;

public class Apple {
	private String color;
 
	public Apple(String color) {
		this.color = color;
	}
 
/*	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (!(obj instanceof Apple))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((Apple) obj).color);
	}*/
	
	public int hashCode(){
		return color.hashCode();
	}
 
	public static void main(String[] args) {
		Apple a1 = new Apple("green");
		Apple a2 = new Apple("red");
 
		//hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		for(Apple apple: m.keySet()){
			System.out.println(apple);
		}
		System.out.println(a1.hashCode()+" "+a2.hashCode());
		Apple a = new Apple("green");
		System.out.println(a+"hashcode: "+a.hashCode());
		m.put(a, 50);
		System.out.println(m.get(a)); // hashcode not implemented, so hashcode calculated new
	}
}