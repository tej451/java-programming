package com.generics;

public class Box<U> {
	U obj;
	
	/*public Box(U t){
		obj = t;
	}*/

	public U getObj() {
		return obj;
	}

	public void setObj(U obj) {
		this.obj = obj;
	}
}
