package com.shika.testData;

public class reverse {

	public static void main(String[] args) {

		int name = 12345, rev = 0, remainder;
		
		while(name>0) {
			
			remainder = name %10;
			
			rev = rev*10 + remainder;
			
			name = name/10;
		}
		
		System.out.println(rev);
		
		
	
	}

}
