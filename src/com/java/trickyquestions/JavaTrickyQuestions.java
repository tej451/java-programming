package com.java.trickyquestions;

import java.util.Arrays;

import org.junit.Test;

public class JavaTrickyQuestions {

	@Test
	public void testDoubleMIN(){
		System.out.println("double min value: "+Double.MIN_VALUE +"integer min value: "+Integer.MIN_VALUE);
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Integer.MIN_VALUE, 0));
		System.out.println(1.0 / 0.0);
		System.out.println(1/0.0);
		System.out.println(0.0/1.0);
		System.out.println(-1.0/0.0);
		System.out.println(1.0/-0.0);
	}
	
	@Test
	public void testString(){
		char[] ch = {'s', 'd'};
		System.out.println(new String(ch));
		System.out.println(ch.toString());
		System.out.println("className:"+ch.getClass().getName() +" hashcode: "+ch.hashCode()+" hexString: "+Integer.toHexString(ch.hashCode()));
	}
	
	@Test
	public void testFinallyConcept(){
		try{
			System.out.println("in try..");
			int i=1;
			if(i==1){
				i =2;
				System.exit(0);
			}else{
				i =2;
				System.out.println(1/0);
			}
		}catch(Exception e){
			System.out.println("catch executed..");
			
			e.printStackTrace();
			//System.exit(0);
		}finally{
			System.out.println("finally executed..");
		}
	}
	
	@Test
	public void stringToByte(){
		 char[] chars = new char[] {'\u0097'};
	        String str = new String(chars);
	        System.out.println(str);
	        byte[] bytes = str.getBytes();
	        System.out.println(bytes);
	        System.out.println(Arrays.toString(bytes));
	}
	
	@Test
	public void testRuntimeException(){
		
	}
}
