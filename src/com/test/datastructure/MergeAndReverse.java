package com.test.datastructure;

import java.sql.Array;
import java.util.Arrays;

public class MergeAndReverse {

	public static void main(String args[]){
		int a1[] = {1, 2, 3, 4, 5, 6};
		int a2[] = {10, 20, 30, 40, 50, 60};
		int merge[] = new int[a1.length+a2.length];
		
		System.out.println("Merged array: ");
		for(int i=0; i<a1.length; i++){
			merge[i] = a1[i];
		}
		for(int i=a1.length, k=0; k<a2.length; i++,k++){
			merge[i] = a2[k];
		}
		//Merged array: [1, 2, 3, 4, 5, 6, 10, 20, 30, 40, 50, 60]
		System.out.println(Arrays.toString(merge));
		
		System.out.println("String array reveral: ");
		usingLoop(merge);
		
	}
	
	public static void usingLoop(int[] strArr){
		int temp;
		//char[] strArr = str.toCharArray();
		for(int i=0,j = strArr.length-1; i<strArr.length/2;i++,j--){
			temp = strArr[j]; 
			strArr[j] = strArr[i];
			strArr[i] = temp;
		}
		//String.valueOf(strArr)
		System.out.println(Arrays.toString(strArr));
		//return Arrays.toString(strArr);
	}
}
