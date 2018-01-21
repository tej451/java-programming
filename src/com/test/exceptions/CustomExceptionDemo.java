package com.test.exceptions;

import java.util.HashMap;
import java.util.Map;

public class CustomExceptionDemo {

	    private static final Map<Integer, String> products = new HashMap<>();
	    private static final int val = 0;
	   /* static {
	        products.put(100, "Coke");
	        products.put(101, "KitKat");
	        products.put(102, "Bisuits");
	        products.put(103, "Toast");
	    }*/

	    public static void main(String args[]) {
	    	//val = 1; //final field cannot be assigned
	    	products.put(100, "Coke");
	        CustomExceptionDemo t = new CustomExceptionDemo();
	        t.getProduct(1000);
	    }

	    public String getProduct(int id) {
	        if (products.get(id) == null) {
	            throw new NoSuchProductException("No such product exists", id);
	        }
	        return (String)products.get(id);
	    }
	}
