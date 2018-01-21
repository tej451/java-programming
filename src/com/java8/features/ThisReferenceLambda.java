package com.java8.features;

public class ThisReferenceLambda {

	void perform(int i, Test t){
		t.test(i);
	}

	void execute(){
		perform(10, t -> {
			System.out.println("the value is "+t);
			System.out.println(this); //u cannot call this since it refers to ThisReferenceLambda
		});
	}
	
	public static void main(String args[]){
		ThisReferenceLambda thisRef = new ThisReferenceLambda();

		//using anonymous class
		thisRef.perform(10, new Test() {

			@Override
			public void test(int i) {
				System.out.println("the value is "+i);
				System.out.println(this); //able to call this since it refers to anonymous inner class,this points to Test
			}

			public String toString(){
				return "Test reference";
			}
		});

		//using lambda
		thisRef.perform(10, t -> {
			System.out.println("the value is "+t);
			//System.out.println(this); //u cannot call this since it refers to ThisReferenceLambda
		});
		
		//calls lambda in non-static method
		thisRef.execute();
		
	}
	
	public String toString(){
		return "ThisReferenceLambda reference";
	}
}
