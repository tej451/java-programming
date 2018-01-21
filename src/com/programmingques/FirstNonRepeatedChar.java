package com.programmingques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNonRepeatedChar {

	public static void main(String args[]){
		
		char ch;
		String s = "algorithms isl a procedure";
		int[] a = {1,2,3};
		
		ch = usingLooping(s.toCharArray());
		//System.out.println("using looping-"+ch);
		//ch = usingCollection(s.toCharArray());
		//System.out.println("using collections-"+ch);
		//ch = firstNonRepeatingChar(s);
		System.out.println("using list and set features-"+ch);
	}
	
	public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<Character>();
        List<Character> nonRepeating = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }
	
	public static char usingCollection(char[] s){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length; i++){
			if(!map.containsKey(s[i])){
				map.put(s[i], 0);
			}else{
				int val = map.get(s[i]);
				map.put(s[i], ++val);
			}
		}
		for(Entry<Character, Integer> entry: map.entrySet()){
			if(entry.getValue() == 0){
				return entry.getKey();
			}
		}
		return 0;
	}
	
	public static char usingLooping(char[] charArr){
		for(int i=0; i<charArr.length; i++){
			for(int j=i+1; j<charArr.length; j++){
				System.out.println(charArr[i]+" - "+charArr[j]);
				if(charArr[i] == charArr[j] ){
					System.out.println("break");
					break;
				}else{
					if(j == charArr.length - 1){
						return charArr[i];
					}
				}
			}
		}
		return 0;
	}
	 
}
