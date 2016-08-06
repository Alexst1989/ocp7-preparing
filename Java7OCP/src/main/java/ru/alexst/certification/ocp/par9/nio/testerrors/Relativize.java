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

        System.out.println(one.relativize(two));
        System.out.println(two.relativize(one));
        System.out.println(one.resolve(two));
        System.out.println(two.resolve(one));
        System.out.println(two.resolve(two));
    }

}
