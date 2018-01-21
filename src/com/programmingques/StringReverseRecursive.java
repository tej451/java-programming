package com.programmingques;

import java.util.Arrays;

public class StringReverseRecursive {
	
	public static void main(String args[]){
		String str = "algorithms";
		
		String reverseStr = reverseThrFunction(str);
		System.out.println("Reverse String Fun: " + reverseStr);
		 reverseStr = reverseRecursively(str);
		System.out.println("reverseRecursively: " + reverseStr);
		char[] reverseArr = usingRecursion(str.toCharArray(), 0, str.toCharArray().length-1);
        System.out.println("usingRecursion: " + reverseStr);
        reverseStr = usingLoop(str);
        System.out.println("usingLoop: " + reverseStr);
	}
	
	public static String reverseThrFunction(String str){
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.reverse();
		return sb.toString();
	}
	
	public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }


	public static String usingLoop(String str){
		char temp;
		char[] strArr = str.toCharArray();
		for(int i=0,j = strArr.length-1; i<strArr.length/2;i++,j--){
			temp = strArr[j]; 
			strArr[j] = strArr[i];
			strArr[i] = temp;
		}
		//String.valueOf(strArr)
		return String.valueOf(strArr);
		//return Arrays.toString(strArr);
	}
	
	public static char[] usingRecursion(char[] strArr, int i, int j){
		if(i < strArr.length/2){
			return strArr;
		}
		char temp;
		temp = strArr[j]; 
		strArr[j] = strArr[i];
		strArr[i] = temp;
		return usingRecursion(strArr, i++, j--);
	}
}
