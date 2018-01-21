package com.java8.features;
/*
 * It turns out that, in Java, lambdas only close over values, but not variables. Java requires those values to be
 *  unchanging, as if they had been declared final. So they must be final whether you declare them that way or not. 
 *  Thus, “effectively final.” And thus, Java has “closures with restrictions,” which might not be “perfect” closures, 
 *  but are nonetheless still quite useful.
 */
public class LambdaClosures {

	public static void main(String[] args){
		int i=2;
		int j=1; // before java 8 it must be declared final, in java 8 it is effectively final
		perform(i, p -> {
			//j =21; // u cannot do so or i=7;
			p=4;
			System.out.println(p+j);}); // value passed over here not variable, so values must be frozen/fixed
	}
	
	static void perform(int i, Test t){
		t.test(i);
	}
}

interface Test{
	void test(int i);
}
