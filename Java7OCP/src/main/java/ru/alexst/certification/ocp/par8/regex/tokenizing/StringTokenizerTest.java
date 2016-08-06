package ru.alexst.certification.ocp.par8.regex.tokenizing;

import java.util.StringTokenizer;

/*
 
■ StringTokenizer objects are constructed using strings as a source.
■ StringTokenizer objects use whitespace characters by default as delimiters,
but they can be constructed with a custom set of delimiters (which are listed
as a string).
■ Tokenizing is performed within a loop so that you can exit the process at any
point.
■ The loop used for tokenizing uses the Enumerator interface, and typically
uses the hasMoreTokens() and nextToken() methods, which are very
similar to Scanner's next() and hasNext() methods. (Note: These days,
the Iterator interface is recommended instead of Enumerator.)
 
 */

public class StringTokenizerTest {

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("a bc d e");
        System.out.println("\n " + st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.print(">" + st.nextToken() + "< ");
        }
        System.out.println("\n " + st.countTokens());

        // Second argument "a" is this StringTokenizer's delimiter
        StringTokenizer st2 = new StringTokenizer("a b cab a ba d", "a");
        System.out.println("\n " + st2.countTokens());
        while (st2.hasMoreTokens()) {
            System.out.print(">" + st2.nextToken() + "< ");
        }
        System.out.println("\n " + st2.countTokens());
    }

}
