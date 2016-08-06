package ru.alexst.certification.ocp.par8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 
 
 Zero-length matches can occur in several places:
	■ After the last character of source data (the 3 3 example)
	■ In between characters after a match has been found (the 1 1 example)
	■ At the beginning of source data (try java Regex "a?" "baba")
	■ At the beginning of zero-length source data
 */

public class RegexZeroLength {
	
	public static void printMatches(Matcher m) {
		System.out.println("====================");
		while (m.find()) {
			System.out.println(m.start() + " " + m.end() + " " + m.group());
		}
	}

	public static void main(String[] args) {
		String s1 = "baba";
		String s2 = "aaaabaa";
		String s3 = "";
		
		Pattern p1 = Pattern.compile("d?");
		Matcher m1 = p1.matcher(s1);
		Matcher m2 = p1.matcher(s2);
		Matcher m3 = p1.matcher(s3);
		
		printMatches(m1);
		printMatches(m2);
		printMatches(m3);
		
	}

}
