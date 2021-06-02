package com.org.MyFristMavenProjectIT;

import java.util.Arrays;

public class DemoStringsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Notes:
		//In Java, a string is a sequence of characters. For example, "hello" is a string containing a sequence of characters 'h', 'e', 'l', 'l', and 'o'.
		//Strings in Java are not primitive types (like int, char, etc). Instead, all strings are objects of a predefined class named String.
		//And, all string variables are instances of the String class.
		

	    // create first string
	    //String first = "Hi ";
	    //System.out.println("First String: " + first);
	    
	    // create second
	    //String second = "There";
	    //System.out.println("Second String: " + second);

	    // join two strings
	    //String joinedString = first.concat(second);
	    //System.out.println("Joined String: " + joinedString);
	    
	    // include double quote 
	    //String example = "This is the 'String' class";
	    //Since strings are represented by double quotes, the compiler will treat "This is the " as the string. Hence, the above code will cause an error.
		
	    // compare strings
		// create 3 strings
	    //String first = "java programming";
	    //String second = "java programming";
	    //String third = "python programming";

	    // compare first and second strings
	    //boolean result1 = first.equals(second);
	    //System.out.println("Strings first and second are equal: " + result1);

	    // compare first and third strings
	    //boolean result2 = first.equals(third);
	    //System.out.println("Strings first and third are equal: " + result2);

		//create a string
		//String greet = "Hello! IT Health your client id is: 564564569995";
		//System.out.println("String: " + greet);

		// get the length of greet
		//int length = greet.length();
		//System.out.println("Length: " + length);
		
//	    //String Str = new String("Welcome to IT Health");
//		//String Str = "Welcome to IT Health";
//		//Syntax - public String substring(int beginIndex)
//	    //System.out.print("Return Value :" );
//	    //System.out.println(Str.substring(10) );
//	    //System.out.print("Return Value :" );
//	    //System.out.println(greet.substring(36) );
//	    
//	    //for (statement 1; statement 2; statement 3) {
//	    	  // code block to be executed
//	    //	}
//	    
//	    //Statement 1 is executed (one time) before the execution of the code block.
//
//	    //Statement 2 defines the condition for executing the code block.
//
//	    //Statement 3 is executed (every time) after the code block has been executed.
//
//	    //The example below will print the numbers 0 to 7:
////	    for(int i=1; i<=7;i++) {
////	    	System.out.println(i);
////	    }
//	    
//	    //There is also a "for-each" loop, which is used exclusively to loop through elements in an array:
//	    
//	    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
//	    for (String i : cars) {
//	      System.out.println(i);
//	    }

		String stoSeperate = "Customer ID:- 661431               Customer Name:- drgdg";
//		String sSeperator = "-";
		String getcustomername = "";     //substring containing last 4 characters
		 
//		if (stoSeperate.length() > 4) 
//		{
//			getcustomername = stoSeperate.substring(stoSeperate.length() - 6);
//		} 
//		else
//		{
//			getcustomername = stoSeperate;
//		}
//		 
//		System.out.println(getcustomername);
		
//		String sfirst = "Customer ID:- 661431               Customer Name:- Customer Name:- Eon";
//		int splitAfter = 6; //split after the second character
//		sfirst = sfirst.substring(sfirst.indexOf(":- ")+4);
//		System.out.println(sfirst.substring(splitAfter));
//		System.out.println(sfirst.substring(0, splitAfter));
//		System.out.println(sfirst);
		
		String ssecond = "Customer ID:- 661431               Customer Name:- Thisismylongname";
		ssecond = ssecond.substring(ssecond.lastIndexOf(" ")+1);
		System.out.println("Customer Name extracted: " + ssecond);
		System.out.println(ssecond.substring(ssecond.lastIndexOf(":- ") + 1).trim());
		
//		String str = "Customer ID:- 661431               Customer Name:- drgdg";
//		String substr = " ";
//		String before = str.substring(0, str.indexOf(substr));
//		String after = str.substring(str.indexOf(substr) + substr.length());
//		System.out.println(before + after);

		String myString = "Customer ID:- 661431               Customer Name:- Thisismylongname";
		String[] splitString = myString.split(":- ");

		for (String s : splitString) {
		    System.out.println(s);
		}
	}
}
