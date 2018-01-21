package com.programmingques;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BubbleSort {
	public static void main(String args[]){
		int[] unsorted =  {32, 39,21, 45, 23, 3};
		int temp =0;
		for(int i = 0; i< unsorted.length; i++){
			for(int j=i+1; j<unsorted.length; j++){
				if(unsorted[i]>unsorted[j]){
					temp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j]=temp;
				}
				System.out.println(Arrays.toString(unsorted));
			}
		}
		System.out.println(Arrays.toString(unsorted));
	}

}
