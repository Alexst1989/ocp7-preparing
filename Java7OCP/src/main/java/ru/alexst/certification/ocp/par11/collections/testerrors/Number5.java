package ru.alexst.certification.ocp.par11.collections.testerrors;

import java.util.HashMap;
import java.util.Map;

/*
A is incorrect because you can't use a primitive type as a type parameter. C is incorrect
because a Map takes two type parameters separated by a comma. D is incorrect because an int
can't autobox to a null, and F is incorrect because a null can't unbox to 0. H is incorrect
because you can't autobox a primitive just by trying to invoke a method with it.
 */

public class Number5 {

    private Map accountTotals = new HashMap();
    private int retirementFund;

    public int getBalance(String accountName) {
        Integer total = (Integer) accountTotals.get(accountName);
        if (total == null)
            total = Integer.valueOf(0);
        return total.intValue();
    }

    public void setBalance(String accountName, int amount) {
        accountTotals.put(accountName, Integer.valueOf(amount));
    }
}

/*
 * A. private Map<String, int> accountTotals = new HashMap<String, int>(); 
 * B. private Map<String, Integer> accountTotals = new HashMap<String, Integer>(); 
 * c. private Map<String<Integer> accountTotals = new HashMap<String<Integer>();
 * 
 * D. 
 * int total = accountTotals.get(accountName); 
 * if (total == null) 
 *      total = 0; 
 * return total;
 * 
 * E. 
 * Integer total = accountTotals.get(accountName); 
 * if (total == null) 
 *      total = 0; 
 * return total;
 * 
 * F. return accountTotals.get(accountName); //if null, NullPointerException will be thrown (public int getBalance(String accountName))
 * G. accountTotals.put(accountName, amount); 
 * H. accountTotals.put(accountName, amount.intValue());
 * 
 */
