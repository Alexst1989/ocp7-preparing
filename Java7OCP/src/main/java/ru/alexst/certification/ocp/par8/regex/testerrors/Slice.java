package ru.alexst.certification.ocp.par8.regex.testerrors;
/*
 D, F, and G are correct. The setMaximumFractionDigits() applies 
 to the formatting, but not the parsing. 
 The try/catch block is placed appropriately. 
This one might scare you into thinking that you'll need to 
memorize more than you really do. If you can remember that you're
formatting the number and parsing the string, you should be fine 
for the exam.
 */
import java.text.*;
public class Slice {
public static void main(String[] args) {
String s = "987.123456";
double d = 987.123456d;
NumberFormat nf = NumberFormat.getInstance();
nf.setMaximumFractionDigits(5);
 System.out.println(nf.format(d) + " ");
 try {
	 System.out.println(nf.parse(s));
 } catch (Exception e) { System.out.println("got exc"); }
}
}