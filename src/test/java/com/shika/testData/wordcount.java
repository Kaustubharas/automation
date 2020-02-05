package com.shika.testData;

public class wordcount {

	public static void main(String[] args) {

		String str = "I'm learning Java";

		int state = 0; 
        int wc = 0;  // word count 
        int i = 0; 
          
        // Scan all characters one by one 
        while (i < str.length()) 
        { 
            // If next character is a separator, set the  
            // state as OUT 
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n' 
                    || str.charAt(i) == '\t') 
                state = 0; 
                  
       
            // If next character is not a word separator 
            // and state is OUT, then set the state as IN 
            // and increment word count 
            else if (state == 0) 
            { 
                state = 1; 
                ++wc; 
            } 
       
            // Move to next character 
            ++i; 
        }
        
        System.out.println(wc);

	}
}
