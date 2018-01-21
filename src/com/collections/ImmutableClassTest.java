package com.collections;

import java.math.BigInteger;
import java.util.Date;
import java.util.TreeSet;

public class ImmutableClassTest extends BigInteger{
	
	 
	 

	

	public ImmutableClassTest(String val) {
		super(val);
		BigInteger.valueOf(Integer.parseInt(val)).add(BigInteger.valueOf(10));
		System.out.println(val);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	    {
		ImmutableClassTest t = new ImmutableClassTest("12");
		System.out.println(t);
		
		 TreeSet set = new TreeSet();
		 
		 //set.add(null); // Adding null will not be allowed in TreeSet as TreeSet calls compare internally, it will throw 
		 // NullPointerException
		 //set.add("ss");
	        ImmutableClass im = new ImmutableClass(102,"test", new Date());
		// ImmutableClass im = new ImmutableClass(2, "3", new Date());
	        System.out.println(im);
	        tryModification(im.getImmutableField1(),im.getImmutableField2(),im.getMutableField());
	        
	        im.getMutableField().setDate(new Date().getDate()+1500);
	        
	        System.out.println(im);
	    }
	 
	    private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField)
	    {
	        immutableField1 = 10000;
	        immutableField2 = "test changed";
	        mutableField.setDate(10);
	    }

		
}


