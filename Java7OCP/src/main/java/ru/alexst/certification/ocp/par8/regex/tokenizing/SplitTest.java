package ru.alexst.certification.ocp.par8.regex.tokenizing;

/*
 Splitting by regex
 between 4 and 5 there is an empty token !!!!!
 
 */

public class SplitTest {

    public static void printTokens(String[] args) {
        System.out.println("==============");
        System.out.println("count " + args.length);
        for (String s : args)
            System.out.println(">" + s + "<");
    }

    public static void main(String[] args) {
        String[] tokens = "ab5 ccc 45 @".split("\\d");
        printTokens(tokens);

        tokens = "ab5 ccc 45 @".split("(\\d)+");
        printTokens(tokens);
    }

}
