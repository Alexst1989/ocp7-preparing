/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.testerrors;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Алексей
 *
 */
public class Relativize {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Path one = Paths.get("c:/x");
        Path two = Paths.get("c:/x/y/a");

        System.out.println(one.relativize(two)); //Как из one попасть в two
        System.out.println(two.relativize(one)); //Как из two  попасть в one
        System.out.println(one.resolve(two)); //like one path + another
        System.out.println(two.resolve(one));
        System.out.println(two.resolve(two));
        
        Path p3 = Paths.get("x/y/z");
        Path p4 = Paths.get("y/z");
        System.out.println(p3.resolve(p4));

    }

}
