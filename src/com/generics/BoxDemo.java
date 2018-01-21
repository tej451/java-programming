package com.generics;

import java.util.List;

public class BoxDemo {

	  public static <U> void addBox(U u, 
	      java.util.List<Box<U>> boxes) {
	    Box<U> box = new Box<>();
	    box.setObj(u);
	    boxes.add(box);
	  }

	  public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
	    int counter = 0;
	    for (Box<U> box: boxes) {
	      U boxContents = box.getObj();
	      System.out.println("Box #" + counter + " contains [" +
	             boxContents.toString() + "]");
	      counter++;
	    }
	  }
	  
	  void processStringList(List<String> stringList) {
		    // process stringList
		}
}
