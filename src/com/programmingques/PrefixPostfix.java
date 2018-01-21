package com.programmingques;

public class PrefixPostfix {

	public static void main(String args[]){
		int i= 0;
		int j=9;
		System.out.println("first: i, j - "+i +" , "+ j);
		i++;
		j--;
		System.out.println("second: i, j - "+i +" , "+ j);
		dummyMethod(i++, j--);
		System.out.println("after dummyMethod postfix : i, j - "+i +" , "+ j);
		++i;
		--j;
		System.out.println("third : i, j - "+i +" , "+ j);
		dummyMethod(++i, --j);
		System.out.println("after dummyMethod prefix : i, j - "+i +" , "+ j);
	}
	
	public static void dummyMethod(int i, int j){
		System.out.println("dummyMethod: i, j - "+i +" , "+ j);
	}
}
