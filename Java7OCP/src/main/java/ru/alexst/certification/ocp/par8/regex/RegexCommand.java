package ru.alexst.certification.ocp.par8.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCommand {
 
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter search string:");
		String s = sc.nextLine();
		System.out.println("Enter regex pattern:");
		String regex = sc.nextLine();
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		
		while (m.find()) {
			System.out.println(m.start() + " " + m.end() + " " + m.group());
		}
		
		
	}
	
}
