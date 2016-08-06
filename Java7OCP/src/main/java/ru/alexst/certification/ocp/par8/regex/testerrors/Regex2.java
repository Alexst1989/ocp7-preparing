package ru.alexst.certification.ocp.par8.regex.testerrors;

/*
 
 "*" greedy character means 0 to many characters,
  thats why m.group will return empty groups at each position 
  of any character in the string, except decimals
 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex2 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d*");
        Matcher m = p.matcher("ab34ef");
        boolean b = false;
        while (b = m.find()) {
            System.out.print(m.start() + m.group());
        }
    }
}
