package com.programmingques;

public class ShiftOperators {
	public static void main(String args[]){
		int a = 11;
		int b = 12;
		int shiftRight = a >> 2; // 1011, shift right by 2 means 000010 ie 2
		int shiftLeft = b << 2; // 1100, shift left by 2 means 110000 ie 48
 		System.out.println("shift right: "+shiftRight); // divide by 2
		System.out.println("shift left: "+shiftLeft); // multiply by 2
		
		int shiftRight1 = a >>> 2;
		int shiftLeft1 = b << 2;
		System.out.println(shiftRight1);
		}
}
