package com.collections;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.Test;

public class ComparableTest {
	@Test
	public void testComparable(){
		BigDecimal bd = new BigDecimal("2.0");
		BigDecimal bd1 = new BigDecimal("2.00");
		System.out.println("equals: "+bd.equals(bd1));
		System.out.println("compareTo: "+bd.compareTo(bd1));
		TreeSet<BigDecimal> ts = new TreeSet<BigDecimal>();
		ts.add(bd);
		ts.add(bd1);
		HashSet<BigDecimal> hs = new HashSet<BigDecimal>();
		hs.add(bd);
		hs.add(bd1);
		System.out.println("TreeSet: calls compareTo "+ts.size()+ " HashSet: calls equals() "+hs.size());
		
		String str = "2.0";
		String str1 = "2.00";
		//System.out.println();
		System.out.println(str.compareTo(str1));
		System.out.println(str.equals(str1));
		TreeSet<String> tsStr = new TreeSet<String>();
		tsStr.add(str1);
		tsStr.add(str);
		HashSet<String> hsStr = new HashSet<String>();
		hsStr.add(str1);
		hsStr.add(str);
		System.out.println("TreeSet: calls compareTo "+tsStr.size()+ " HashSet: calls equals() "+hsStr.size());
	}
	
	
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}else if(this.getClass() == obj.getClass()){
			return true;
		}
		return false;
	}

	public int compareTo(Object obj){
		if(this == obj){
			return 0;
		}else if(this.getClass() == obj.getClass()){
			return 0;
		}
		return this.compareTo(obj);
	}
}
