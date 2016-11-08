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
*In glob for Windows must be \\\\ for every dir, or /
* 
* Path path1 = Paths.get("0*b/test/1");
*Path path2 = Paths.get("9\\*b/test/1");
*Path path3 = Paths.get("01b/test/1");
*Path path4 = Paths.get("0*b/1");
*String glob = "glob:[0-9]\\*{A*,b}/**///1";
/*
*matches(path1,glob); // true
*matches(path2,glob); // false
*matches(path3,glob); // false
*matches(path4,glob); // false
*/
/*
Spelling out what the glob does,we have the following:

■[0-9]One single digit.Can also be read as any one character from 0 to 9.

■\\*The literal character asterisk rather than the asterisk that means to match anything.
A single backslash before*escapes it.However,Java won'tlet you type a single backslash,
so you have to escape the backslash itself with another backslash.

■{A*,b}Either a capital A followed by anything or the single character b.

■ /**/ /*One or more directories with any name.*/
/*
■1 The single character 1.

GLOB:

** - Zero or more of any character, including a directory boundary

*  - Zero or more of any character, not including a directory boundary

?  - Exactly one character

[0-9] - Any digit

{cat, dog}* - Begins with cat or dog

To match with path "C:/123/123" glob must include "glob:C:/" !!!!!!!!!!!!!!!


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
