/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.testerrors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Алексей
 *
 */
public class Number1 {

    public static void main(String[] args) {
        // INSERT DECLARATION HERE
        // List<List<Integer>> table = new List<List<Integer>>();
        List<List<Integer>> table = new ArrayList<List<Integer>>();
        // List<List<Integer>> table = new ArrayList<ArrayList<Integer>>();
        // List<List, Integer> table = new List<List, Integer>();
        // List<List, Integer> table = new ArrayList<List, Integer>();
        // List<List, Integer> table = new ArrayList<ArrayList, Integer>();

        for (int i = 0; i <= 10; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= 10; j++)
                row.add(i * j);
            table.add(row);
        }
        for (List<Integer> row : table)
            System.out.println(row);
    }

}
