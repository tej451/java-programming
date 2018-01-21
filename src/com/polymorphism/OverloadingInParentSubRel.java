package com.polymorphism;

class Base1 {
	public boolean foo(Base1 b) {
		return true;    
	}
}
class Sub2 extends Base1 {
	public boolean foo(Sub2 s) {
		return false;
	}
	
	
}

public class OverloadingInParentSubRel {
	/*
	 * The foo methods are overloaded in the Sub. In Base, there is only one foo method, and it is not overridden by the Sub!

Overloading is fundamentally different then overriding. There is no polymorphism or dynamic binding here!!! All decisions are made at compile time!!! See detailed explanation in the same code below, documented!

class Base {
 // There is only one foo method in Base!!!
 public boolean foo(Base b) {
   return true;    
 }
}
class Sub extends Base {
 // differnt signature, method overloading
 // there are 2 foo methods in the Sub
 public boolean foo(Sub s) {
   return false;
 }
}

public class Test {
 public static void main(String argv[]) {
   // bb is a Base ref to the compiler, Base obj at runtime
   Base bb = new Base();
   // bs is a Base ref to the compiler, Sub obj at runtime
   Base bs = new Sub(); 
   // ss is a Sub ref to the compiler, Sub obj at runtime
   Sub  ss = new Sub(); 
        
   // All these 4 lines are Base ref
   // call Base.foo(Base) method, and only one foo available
   // bs is a Base ref, and ss ISA Base ref too
   // Everything is fine!!!
   System.out.println(bb.foo(bb)); //true
   System.out.println(bs.foo(bs)); //true
   System.out.println(bs.foo(ss)); //true
   System.out.println(bs.foo(bb)); //true
        
   // bb, bs are both Base refs to Compiler
   // ss is a Sub ref
   // call Sub.foo(Base) which is inherited from Base
   System.out.println(ss.foo(bs)); //true
   System.out.println(ss.foo(bb)); //true
        
   // no doubt about this one, am I right?
   System.out.println(ss.foo(ss)); //false
 }
}


	 */
	public static void main(String argv[]) {
		Base1 bb = new Base1();
		Base1 bs = new Sub2();
		Sub2  ss = new Sub2();

		System.out.println(bb.foo(bb)); //true

		System.out.println(bs.foo(bs)); //true ???
		System.out.println(bs.foo(ss)); //true ???
		System.out.println(bs.foo(bb)); //true ???
		System.out.println(ss.foo(bs)); //true ???
		System.out.println(ss.foo(bb)); //true ???

		System.out.println(ss.foo(ss)); //false
	}
}
