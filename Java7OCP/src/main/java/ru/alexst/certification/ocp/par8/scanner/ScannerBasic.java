package ru.alexst.certification.ocp.par8.scanner;

import java.util.Scanner;

//This algorythm will cycle if matcher returns empty string !!!!!!!!!!!
//for example try "\\b"

/*
 
 Methods next*() search number in string, when find not a number throw an exception
 
 */

public class ScannerBasic {

	public static void main(String[] args) {
		String s = "1 2 4f 5 d 12asd3 as2";
		//			012345678901234567890
		Scanner sc = new Scanner(s);
		String token;
		do {
			token = sc.findInLine("\\d+");
			System.out.println(token);
		} while (token != null);
		sc.close();
		
		System.out.println("===============");
		sc = new Scanner(s);
		Integer token2;
		do {
			token2 = sc.nextInt(16);
			System.out.println(token2);
		} while (token2 != null);
		sc.close();
	}

}
