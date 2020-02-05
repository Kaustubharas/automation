package com.shika.testData;

import java.util.HashMap;
import java.util.Map;

public class stringrev {

	public static void main(String[] args) {

		String name = "Missisippi";
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		char ch[] = name.toCharArray();
		
		for(char c:ch) {
			
			if(hm.containsKey(c)) {
				
				hm.put(c, hm.get(c)+1);
				
			}else {
				
				hm.put(c, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry: hm.entrySet()) {
			
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	
	}

}
