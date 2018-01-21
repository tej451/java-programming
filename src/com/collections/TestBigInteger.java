package com.collections;

import java.math.BigInteger;
/*
 * Immutability means there is no way to change the state of the object once it is created and this is achieved by three thumb rules which makes the compiler to recognize that class is immutable and they are as follows :-

    all non private fields should be final
    make sure there is no method in the class that can change the fields of the object either directly or indirectly
    any object reference defined in the class can't be modified outside from the class

	BigInteger" class is immutable but its not final

 */
public class TestBigInteger {

	public static void main(String[] args) {
		BigInteger sum = BigInteger.valueOf(0);
		for(int i=0; i<10; i++){
			sum.add(BigInteger.valueOf(i));
		}
		System.out.println(sum);
	}

}
