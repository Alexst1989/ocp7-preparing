/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
The normalize() method knows that a single dot can be ignored. 
It also knows that any directory followed by two
dots can be removed from a path.

Be careful when using this normalize()! It just looks at the String equivalent
of the path and doesn't check the file system to see whether the directories or files
actually exist.
 */

/**
 * @author Алексей
 *
 */
public class NormalizingPath {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String homePath = insertHome();

        Path p = Paths.get(homePath);

        System.out.println(Paths.get("/a/./b/./c").normalize());
        System.out.println(Paths.get(".classpath").normalize());
        System.out.println(Paths.get("/a/b/c/..").normalize());
        // Pay attention !!!!!!!!!!!
        // The two dots do say to go up one directory. But since there
        // isn't a directory before it, Path can't simplify it.
        System.out.println("Pay attention !!!!!!!!!!!");
        System.out.println(Paths.get("../a/b/c").normalize());
    }

}
