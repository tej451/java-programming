package com.generics;

public class BoundedTypeParam<T extends Number> { //AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float,
	//Long, Short would only be accepted
	T type;

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}
	
	//used to invoke methods defined in bounds
	public boolean isEven(){
		return type.intValue()%2 ==0;
	}
	
	public <U extends Number> void ensure(U u){
		System.out.println("Bounded type arg "+u.getClass().getName());
		System.out.println(type.getClass().getName());
	}
	
	public <T> int countGreaterThan(T[] arr, T elem){
		int count = 0;
		for(T e: arr){
			// compile time error, since operators is applicable only to primitive types
			//if(e > elem)
			{ 
				++count;
			}
		}
		return count;
	}
	
	public <T extends Comparable<T>> int countGreaterThanWithGenerics(T[] arr, T elem){
		int count = 0;
		for(T e: arr){
			if(e.compareTo(elem) > 0){ 
				++count;
			}
		}
		return count;
	}
	
	public void boxTest(BoundedTypeParam<Number> n) {
		
	}
}
