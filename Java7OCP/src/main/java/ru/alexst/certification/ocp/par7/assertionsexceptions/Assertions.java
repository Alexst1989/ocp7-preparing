package ru.alexst.certification.ocp.par7.assertionsexceptions;

/*
To enable assertions at various granularities, use the -enableassertions, or -ea, switch in JVM arguments. 
To disable assertions at various granularities, use the -disableassertions, or -da, switch
*/

/*
Appropriate use of assertions:
    Don�t Use Assertions to Validate Arguments to a public Method
    Do Use Assertions to Validate Arguments to a private Method
    Don't Use Assertions to Validate Command-Line Arguments
    Do Use Assertions, Even in public Methods, to Check for Cases That You Know Are Never, Ever Supposed to Happen
    Don't Use assert Expressions That Can Cause Side Effects!
*/
public class Assertions {

    /**
     * @param num
     */
    private void methodA(int num) {
        // The first expression must always result in a boolean value
        // Remember, the second expression is used to generate a String message that
        // displays in the stack trace to give you a little more debugging information
        assert (num >= 0) : "num = " + num; // throws an AssertionError
        // if this test isn't true
    }

    public static String aReturn() {
        return "aReturn";
    }

    public static void noReturn() {
        return;
    }

    public static void main(String[] args) {
        new Assertions().methodA(-4);

        int x = 1;
        boolean b = true;

        // the following six are legal assert statements
        assert (x == 1);
        assert (b);
        assert true;
        assert (x == 1) : x;
        assert (x == 1) : aReturn();
        assert (x == 1) : new ValidAssert();

        // the following six are ILLEGAL assert statements
        // assert(x = 1); // none of these are booleans
        // assert(x);
        // assert 0;
        // assert(x == 1) : ; // none of these return a value
        // assert(x == 1) : noReturn();
        // assert(x == 1) : ValidAssert va;
    }

}

class ValidAssert {

}
