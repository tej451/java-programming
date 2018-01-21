package com.programmingques;

public class TwoHeighestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {45, 1, 90, 22, 78, 5, 102, 7, 67, 100};
		int first = a[0];
		int second = 0;
		for(int i=1; i<a.length  ; i++){
			if(a[i]>first){
				second = first; //f-45 f-90, s-45, f-102, s-90
				first = a[i];
			}else if(a[i] > second){
				second = a[i];
			}
		}
		System.out.println(first+" , "+second);
		// i =2, sec = 45, f = 90
		//i=6, sec=90, f = 102
		
	}

}
