package com.string;

public class StringTest {
	public static void main(String args[]){
		//Immutable and mutable eg
		String s = new String("durga"); // s -> durga (heap), durga(scp)
		s.concat("software"); // durgasoftware(heap)
		System.out.println(s);//durga
		
		StringBuffer sb = new StringBuffer("durga"); //sb -> durga
		sb.append("software"); // sb -> durgasoftware
		System.out.println(sb); // durgasoftware
		
		//String and StringBuffer
		String string1 = new String("durga");
		String string2 = new String("durga");
		System.out.println(string1==string2); // false
		System.out.println(string1.equals(string2)); // true, since string equals is called which is meant for 
		//content comparison
		
		
		StringBuffer sb1 = new StringBuffer("durga");
		StringBuffer sb2 = new StringBuffer("durga");
		System.out.println(sb1 == sb2); // false
		System.out.println(sb1.equals(sb2)); // false, since Object equals will be called which is meant 
		// for reference comparison

		//heap and scp examples
		String st1 = new String("durga"); // 2 objects will be created,
		// st1 -> durga in heap and durga in scp without reference for future reference only
		String st2 = "durga";
		//1 object created, st2 -> durga in scp only
		
		// heap and scp examples
		String str1 = new String("durga"); // str1 -> durga(heap), durga(scp)
		String str2 = new String("durga"); // str2 -> durga(heap), durga already in scp area
		String str3 = "durga"; // no object created, str3 -> durga that is already in scp area
		String str4 = "durga"; // no object created, str4 -> durga that is laready in scp area
		//total of 3 objects created, 2 in heap and one in scp
		
		// heap and scp examples
		String s1 = new String("durga"); // s1 -> durga(heap), durga(scp)
		s1.concat("software"); // durgasoftware(heap) no reference will be gc'd, software(scp)
		String s2 = s1.concat("solutions"); // s2 -> durgasolutions(heap), solutions(scp)
		s1 = s1.concat("soft"); // s1 -> durgasoft(heap), soft(scp)
		/* s1 reference moved from durga to durgasoft, so durga will be gc'd*/
		System.out.println(s1); //output- durgasoft
		System.out.println(s2); // output - durgasolutions
		//durga and durgasoftware will be garbage collected
		

	}

}
