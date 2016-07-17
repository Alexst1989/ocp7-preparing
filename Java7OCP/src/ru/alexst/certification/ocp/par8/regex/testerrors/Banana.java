package ru.alexst.certification.ocp.par8.regex.testerrors;

/*
 
 Notice that every digit was used as a delimiter 
 and that contiguous digits created an empty token
 
 !!!!!!! From java se7 docs   !!!!!!!!!!!!!
 The array returned by this method contains each 
 substring of this string that is terminated by another 
 substring that matches the given expression or is 
 terminated by the end of the string.
 
 */

public class Banana {
	
	public static void main(String[] args) {
		String in = "1 a2 b 3 c4d 5e6";
		String[] chunks = in.split(" ");
		System.out.println("count " + chunks.length);
		for(String s : chunks) System.out.print(">" + s + "< ");
		System.out.println();
		String[] chunks2 = in.split("\\d");
		System.out.println("count " + chunks2.length);
		for(String s : chunks2) System.out.print(">" + s + "< ");
		
		System.out.println();
		
	    System.out.println("====  1  =====");
		for(String s : "a aaa".split("a")) System.out.print(">" + s + "< ");
		System.out.println();
		
		System.out.println("====  2  =====");
		for(String s : "1 234 ".split("\\d")) System.out.print(">" + s + "< ");
		System.out.println();
		
		System.out.println("====  3  =====");
		for(String s : "a aaa ".split("\\w")) System.out.print(">" + s + "< ");
		System.out.println();
		
		System.out.println("====  4  =====");
		for(String s : "a aaa ".split("\\b")) System.out.print(">" + s + "< ");
		System.out.println();
		

		System.out.println("====  5  =====");
		for(String s : "a aaa ".split("\\b")) System.out.print(">" + s + "< ");
		System.out.println();
	}
	
}