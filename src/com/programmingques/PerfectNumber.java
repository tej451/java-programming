package com.programmingques;

public class PerfectNumber {
	 
    public boolean isPerfectNumber(int number){
         
        int temp = 0;
        for(int i=1;i<=number/2;i++){
            if(number%i == 0){
            	System.out.print(" "+i);
                temp += i;
            }
        }
        if(temp == number){
            System.out.println("It is a perfect number");
            return true;
        } else {
            System.out.println("It is not a perfect number");
            return false;
        }
    }
     
    public static void main(String a[]){
        PerfectNumber ipn = new PerfectNumber();
        System.out.println("Is perfect number: "+ipn.isPerfectNumber(28));
    }
}