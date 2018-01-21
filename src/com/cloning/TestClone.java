package com.cloning;

public class TestClone implements Cloneable{
	protected int i=5;
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
