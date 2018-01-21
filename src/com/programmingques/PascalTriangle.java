package com.programmingques;

public class PascalTriangle {
	/*
	  			1 				
			1 		1 			
		1 		2 		1 		
	1 		3 		3 		1 	
1 		4 		6 		4 		1

	 */
	public static void main(String[] args) {
		int rows = 10;
		for(int i =0;i<rows;i++) {
			int number = 1;
			System.out.format("%"+(rows-i)*2+"s","");
			for(int j=0;j<=i;j++) {
				System.out.format("%4d",number);
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}
}
