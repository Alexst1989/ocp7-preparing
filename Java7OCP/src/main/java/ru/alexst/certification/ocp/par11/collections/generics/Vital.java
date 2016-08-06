/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.generics;

import java.util.ArrayList;
import java.util.List;

/*
 
 */
public class Vital {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(4);
        myList.add(6);
        Inserter in = new Inserter();
        in.insert(myList); // pass List<Integer> to legacy code

        for (Object o : myList) {
            System.out.println(o); // Third is actually a String, even the type of list is Integer !!!!!!!!!!!
        }
    }

}

class Inserter {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // method with a non-generic List argument
    void insert(List list) {
        list.add(new String("42")); // adds to the incoming list
    }
}
