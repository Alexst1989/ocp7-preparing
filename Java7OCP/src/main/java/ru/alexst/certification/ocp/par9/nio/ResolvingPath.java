/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 
 Resolving like concatenating two Strings !!!!!!!!!!!!!!!!!!
 
 */

/**
 * @author Алексей
 *
 */
public class ResolvingPath {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Path absolute = Paths.get("/home/java");
        Path relative = Paths.get("dir");
        Path file = Paths.get("Model.pdf");
        System.out.println("1: " + absolute.resolve(relative)); // If two absolute paths, the second will be returned
        System.out.println("2: " + absolute.resolve(file));
        System.out.println("3: " + relative.resolve(file));
        System.out.println("4: " + relative.resolve(absolute)); // Java see's that absolute path is absolute and returns it
        System.out.println("5: " + file.resolve(absolute)); // returns the absolute path
        System.out.println("6: " + file.resolve(relative)); // Since that doesn't make any sense, Java just tries its best and gives you nonsense.

        Path path = Paths.get("/usr/bin/zip");
        // path.resolve(null); //Compiler doesn't know what method to inoke resolve(String) or resolve(Path)

        Path path2 = Paths.get("/usr/bin/zip");
        Path other = null;
        path.resolve(other); // resolve with Path parameter
        path.resolve((String) null); // resolve with String parameter

    }

}
