/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/*
 
 In glob for Windows must be \\\\ for every dir, or /
 
 */

/**
 * @author Алексей
 *
 */
public class PathMatcherBasic {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String glob = String.format("glob:C:\\\\**.txt");
        PathMatcher pm = FileSystems.getDefault().getPathMatcher(glob);

        Path p1 = Paths.get(insertHome("fileX1.txt"));
        Path p2 = Paths.get(insertHome("fileX2.txt"));
        Path p3 = Paths.get(insertHome("y"));
        Path p4 = Paths.get(insertHome("y\\fileY1.txt"));
        Path p5 = Paths.get(insertHome("y\\fileY2.txt"));

        System.out.println(pm.matches(p1));
        System.out.println(pm.matches(p2));
        System.out.println(pm.matches(p3));
        System.out.println(pm.matches(p4));
        System.out.println(pm.matches(p5));
    }

}
