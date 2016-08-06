package ru.alexst.certification.ocp.par8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasic {

	public static void main(String[] args) {
		
		String s = "0123456789012!@#  121 a asd as  12 14 ";
		Pattern p = Pattern.compile("12");
		
		Pattern pw = Pattern.compile("\\w");
		Pattern pW = Pattern.compile("\\W");
		
		Pattern pd = Pattern.compile("\\d");
		Pattern pD = Pattern.compile("\\D");
		
		Pattern ps = Pattern.compile("\\s");
		Pattern pS = Pattern.compile("\\S");
		
		Pattern pb = Pattern.compile("\\b");
		Pattern pB = Pattern.compile("\\B");

		
		Matcher m = p.matcher(s);
		
		Matcher mw = pw.matcher(s);
		Matcher mW = pW.matcher(s);

		Matcher md = pd.matcher(s);
		Matcher mD = pD.matcher(s);

		Matcher ms = ps.matcher(s);
		Matcher mS = pS.matcher(s);

		Matcher mb = pb.matcher(s);
		Matcher mB = pB.matcher(s);
		
		while (m.find()) {
			System.out.print(m.start() + " " + m.group() + " | ");
		}
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567
		//\w = 0 1 2 3 4 5 6 7 8 9 10 11 12 18 19 20 22 24 25 26 28 29 32 33 35 36
		System.out.println();
		System.out.print("\\w = ");
		while (mw.find()) {
			System.out.print(mw.start() + " " + mw.group() + " | ");
		}
		
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567
		//\W = 13 14 15 16 17 21 23 27 30 31 34 37
		System.out.println();
		System.out.print("\\W = ");
		while (mW.find()) {
			System.out.print(mW.start() + " " + mW.group() + " | ");
		}
		
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567
		//\d = 0 1 2 3 4 5 6 7 8 9 10 11 12 18 19 20 32 33 35 36
		System.out.println();
		System.out.print("\\d = ");
		while (md.find()) {
			System.out.print(md.start() + " " + md.group() + " | ");
		}
		
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567
		//\D = 13 14 15 16 17 21 22 23 24 25 26 27 28 29 30 31 34 37
		System.out.println();
		System.out.print("\\D = ");
		while (mD.find()) {
			System.out.print(mD.start() + " " + mD.group() + " | ");
		}
		
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567		
		//\s = 16 17 21 23 27 30 31 34 37
		System.out.println();
		System.out.print("\\s = ");
		while (ms.find()) {
			System.out.print(ms.start() + " " + ms.group() + " | ");
		}
		
		
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567
		//\S = 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 18 19 20 22 24 25 26 28 29 32 33 35 36
		System.out.println();
		System.out.print("\\S = ");
		while (mS.find()) {
			System.out.print(mS.start() + " ");
		}
		
		
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567
		//\b = 0 13 18 21 22 23 24 27 28 30 32 34 35 37
		System.out.println();
		System.out.print("\\b = ");
		while (mb.find()) {
			System.out.println(mb.start() + " " + mb.end());
		}
		
		
		//String s = "0123456789012!@#  121 a asd as  12 14 ";
		//			  01234567890123456789012345678901234567
		System.out.println();
		System.out.print("\\B = ");
		while (mB.find()) {
			System.out.print(mB.start() + " ");
		}
		
		System.out.println();
		System.out.println("============== Attention ==============");
		System.out.println("In string \"s\" there is a none boundary character at position 38");
		
	}

}
