package com.programmingques;

import java.util.Arrays;

public class UniqueFinder {
	public static void main(String args[]){
		int[] arr = {1, 1, 8, 9, 5, 3, 1, 5, 2, 8, 2};
		int[] uniqueArr = new int[arr.length];
		int temp = 0;
		int charOccurence = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<uniqueArr.length; j++){
				if(uniqueArr[j] == arr[i]){
					break;
				}else{
					if(j == arr.length - 1){
						charOccurence = 0;
					}
				}
			}
			if(charOccurence == 0){
				uniqueArr[temp] = arr[i];
				temp++;
				charOccurence = 1;
			}
			//System.out.println(Arrays.toString(uniqueArr));
		}
		int[] finalArr = new int[temp];
		/*for(int i=0; i<finalArr.length;i++){
			finalArr[i] = uniqueArr[i];
		}*/
		System.arraycopy(uniqueArr, 0, finalArr, 0, temp);
		System.out.println("UniqueArray "+Arrays.toString(finalArr));
	}
}
