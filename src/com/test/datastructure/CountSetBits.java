package com.test.datastructure;
//Time Complexity: O(logn)
public class CountSetBits {

	public static void main(String args[]){
		int i=15;
		int countBits = 0;
		while(i>0){
			i = i&(i-1);
			countBits++;
		}
		System.out.println(countBits);
	}
}
