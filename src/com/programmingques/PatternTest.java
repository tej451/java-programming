package com.programmingques;

public class PatternTest {
	/*
	 1
	 3*2
     4*5*6
     10*9*8*7
     11*12*13*14*15
     21*20*19*18*17*16
	 */
	
	public static void main(String[] a){
		int starCount = 0; // no of star to be printed on each line, initialized with (digitcount -1), and decrement while traversing the same line, new line controlled by startcount 
		int temp = 0; // temp variable to control startCount
		int reverseCounter = 0; // variable to perform negation alternatively
		int digitsCount = 1; // digitsCount to hold the no of digits to be printed on each line, and is modified when one line ends
		StringBuffer str = new StringBuffer();
		for(int i=1; i<=21; i++){
			str.append(i);
			if(temp == 0 && digitsCount > 0){
				starCount = digitsCount-1; 
			}
			if(starCount > 0){
				str.append("*");
			}
			if(starCount == 0){
				temp = 0;
				if(reverseCounter == 0){
					System.out.println(str);
					reverseCounter++;
				}else{
					System.out.println(reverse(str.toString()));
					reverseCounter--;
				}
				digitsCount++;
				str = new StringBuffer();
			}else{
				starCount = starCount-1;
				temp = temp+1;
				continue;
			}
		}
	}
	
	public static String reverse(String str){
		String reverseStr = "";
		String temp = "";
		for(int i=str.length()-1; i>=0 ;i--){
			//System.out.println(strArray[i]);
			//temp = strArray[i];
			if((i> 0 && str.charAt(i-1) == '*') || i==0){
				reverseStr = reverseStr+ str.charAt(i)+temp;
				temp = "";
			}else if(str.charAt(i) == '*'){
				reverseStr = reverseStr + str.charAt(i)+"";
			}else{
				temp = str.charAt(i)+""; 
			}
		}
		//System.out.println("Reverse: "+reverseStr);
		return reverseStr;
	}
}
