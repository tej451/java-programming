package com.designpattern;

public enum EnumSingleton implements Cloneable{

	INSTANCE;

	public void testIt(){
		System.out.println(EnumSingleton.INSTANCE.hashCode());
	}
	
	/*protected Object readResolve() {
	    return INSTANCE;
	}*/
	
	
}
