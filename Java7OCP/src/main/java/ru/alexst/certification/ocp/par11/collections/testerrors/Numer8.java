package ru.alexst.certification.ocp.par11.collections.testerrors;

import java.util.ArrayList;
import java.util.List;

public class Numer8 {

    public static <E extends Number> List<E> process(List<E> nums) {
        return new ArrayList<E>();
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = null;
        ArrayList<Integer> output = null;
        output = process(input);

    }

    /*
     * 
     * A. ArrayList<Integer> input = null; ArrayList<Integer> output = null;
     * 
     * B. ArrayList<Integer> input = null; List<Integer> output = null;
     * 
     * C. ArrayList<Integer> input = null; List<Number> output = null;
     * 
     * D. List<Number> input = null; ArrayList<Integer> output = null;
     * 
     * E. List<Number> input = null; List<Number> output = null;
     * 
     * F. List<Integer> input = null; List<Integer> output = null;
     * 
     * G. None of the above
     * 
     * 
     * The return type of process is definitely declared as a List, not an ArrayList, so A and D are incorrect. C is
     * incorrect because the return type evaluates to List<Integer>, and that can't be assigned to a variable of type
     * List<Number>. Of course, all these would probably cause a NullPointerException since the variables are still
     * null—but the question only asked us to get the code to compile. (OCP Objective 4.1)
     * 
     */

}
