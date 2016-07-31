/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Алексей
 *
 */

/*
 * absolute1.relativize(absolute3) - how to get from absolute1 to absolute3. If Java don't know how, an exception occur
 */
public class RelativizingPath {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Path absolute1 = Paths.get("/home/java");
        Path absolute2 = Paths.get("/usr/local");
        Path absolute3 = Paths.get("/home/java/temp/music.mp3");
        Path relative1 = Paths.get("temp");
        Path relative2 = Paths.get("temp/music.pdf");
        System.out.println("1: " + absolute1.relativize(absolute3));
        System.out.println("2: " + absolute3.relativize(absolute1));
        System.out.println("3: " + absolute1.relativize(absolute2));
        System.out.println("4: " + relative1.relativize(relative2)); // If two relative has the same part
        System.out.println("5: " + absolute1.relativize(relative1));// BAD Java
                                                                    // don't
                                                                    // know
                                                                    // where is
                                                                    // relative
                                                                    // path is
    }

}
