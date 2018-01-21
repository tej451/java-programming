package com.programmingques;

import java.util.Arrays;


public class ArrayTest {
	public static void main(String a[]){
		int[] arr1={1,2,3,4,'b',3,4};
		for(int i =0; i<arr1.length; i++){
			int k = arr1[i];
			ArrayTest.test1(arr1[i]);
			
		}
		int[] arr={666,7777, 5555,444,22,11};
		/* output: arr={5555,7777,444,666,11,22}; */
		for(int i=0; i<arr.length-1; i++){
			System.out.println("SIZE: "+new Integer(arr[i]).SIZE);
			if((new Integer(arr[i]).toString().length() < new Integer(arr[i+1]).toString().length()) 
					|| (new Integer(arr[i]).toString().length() == new Integer(arr[i+1]).toString().length() && arr[i] > arr[i+1])){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				System.out.println(Arrays.toString(arr));
			}
		}
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	static void test1(Integer i){
		if(i instanceof Integer){
			//System.out.println("Integer: "+i);
		}else{
			//System.out.println("char: "+i);
		}
	}

}
