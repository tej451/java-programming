package com.test;

import org.junit.Test;

public class Generics {
	
	
	@Test
	public void testBasics(){
		Box<Integer> box = new Box<>();
		Box box1 = box;
		box1.setT("ss");
		
		Box box2 = new Box();
		box2.setT("ss");
		Box<Integer> box3 = box2;
	}
	
	@Test
	public void testBoundedType(){
		Box<Integer> box = new Box<>();
		box.setT(2);
		box.ensure("ss");
	}

}
