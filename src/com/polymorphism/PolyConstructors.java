package com.polymorphism;
/*  //Output is:
//Glyph() before draw()
//RoundGlyph.draw(), radius = 0
//Glyph() after draw()
//RoundGlyph.RoundGlyph(), radius=5

A:

The execution order is:

    static variable initialization and static block executes only once when the class is loaded to the memory by JVM.

    When constructor is called, the constructor header executes first before instance variable initialization and instance block execution.

    instance variable initialization and instance block(instance initializers) execute.
    
    then remaining code in constructor executes

    Code in the constructor executes.
    
    Here, first static variable initialization happens, then static block initializer called from super to sub in hierarachy.
    then, constuctor header executes which called super constuctor header then instance variable initialization then instance 
    variable initializers called 
    then constructor of super called, then constuctor header of sub called then instance variable initialization then instance 
    variable initializers of sub called
    then remaining code in constructor called 
    */
abstract class Glyph {
	abstract void draw();
	static int i = 2;
	int j = 3;
	static{
		System.out.println("Glyph sttic initializer i = "+i);
	}
	{
		System.out.println("Glyph instance initializer j = "+j);
	}
	Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}
class RoundGlyph extends Glyph {
	//instance variable initializers
	static int temp = 2;
	int radius = 1;
	int x;
	//static initializers
	static{
	 System.out.println("HI i = "+i+" temp = "+temp);	
	}
	//instance initializers
	{
		x = 6;
		System.out.println("INSTANCE INITIALIZERS radius = "+radius);
	}
	RoundGlyph(int r) {
		radius = r;
		System.out.println(
				"RoundGlyph.RoundGlyph(), radius = " + radius+ " x = "+x);
	}
	void draw() {
		System.out.println("RoundGlyph.draw(), radius = " + radius + " , temp- "+temp+ " x = "+x + " i = "+i);
	}
}
public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}
