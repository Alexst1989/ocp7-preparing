package ru.alexst.certification.ocp.par8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

/*
     + one to many occurrences
    * Zero or more occurrences
    ? Zero or one occurrence
 
     . any character 
     

    ■ ? is greedy, ?? is reluctant, for zero or once
    ■ *is greedy, *? is reluctant, for zero or more
    ■ + is greedy, +? is reluctant, for one or more
    
 */

public class RegexQuantifiers {

    public static void main(String[] args) {
        String s = "0b010111a01 0b111001010 0xabcdef00   21 a d as 12 21 r00 0 0 20 021 0xar101054";
        Pattern hex = Pattern.compile("0[xX]([a-fA-F0-9])+ ");
        Pattern bin = Pattern.compile("0[bB]([0-1])+ ");
        Matcher hexMatcher = hex.matcher(s);
        while (hexMatcher.find()) {
            out.println(hexMatcher.start() + " " + hexMatcher.group());
        }
        out.println("===========================");
        Matcher binMatcher = bin.matcher(s);
        while (binMatcher.find()) {
            out.println(binMatcher.start() + " " + binMatcher.group());
        }

        s = "proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java";

        Pattern p = Pattern.compile("proj([^,])*");
        Matcher m = p.matcher(s);
        out.println("===========================");
        while (m.find()) {
            out.println(m.start() + " " + m.group());
        }

        Pattern extension = Pattern.compile("\\.([\\w])*");
        Matcher extensionMatcher = extension.matcher(s);
        out.println("===========================");
        while (extensionMatcher.find()) {
            out.println(extensionMatcher.start() + " " + extensionMatcher.group());
        }

        out.println("===========================");
        s = "yyxxxyxx";
        Pattern greedy = Pattern.compile(".*xx");
        Pattern reluctant = Pattern.compile(".*?xx");

        Matcher greedyMatcher = greedy.matcher(s);
        Matcher reluctantMatcher = reluctant.matcher(s);

        while (greedyMatcher.find()) {
            out.println(greedyMatcher.start() + " " + greedyMatcher.group());
        }
        out.println("===========================");

        while (reluctantMatcher.find()) {
            out.println(reluctantMatcher.start() + " " + reluctantMatcher.group());
        }
    }

}
