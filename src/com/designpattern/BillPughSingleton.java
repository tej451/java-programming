package com.designpattern;

import java.io.Serializable;

public class BillPughSingleton implements Cloneable, Serializable{

    private BillPughSingleton(){}
    
    private static final class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
    
    public Object clone() throws CloneNotSupportedException{
    	return SingletonHelper.INSTANCE;
    }
    
    protected Object readResolve(){
    	return SingletonHelper.INSTANCE;
    }
}
