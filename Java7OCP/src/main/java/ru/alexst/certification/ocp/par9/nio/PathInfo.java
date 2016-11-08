/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Алексей
 *
 */
public class PathInfo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String homePath = insertHome();

        Path p = Paths.get(homePath);

        System.out.println(String.format("File System = %s", p.getFileSystem()));
        System.out.println(String.format("getFileName = %s", p.getFileName()));
        System.out.println(String.format("Names = %s %s %s", p.getName(0), p.getName(1), p.getName(2)));
        System.out.println(String.format("getNameCount = %s", p.getNameCount()));
        System.out.println(String.format("getParent = %s", p.getParent()));
        System.out.println(String.format("getRoot = %s", p.getRoot()));
        System.out.println(String.format("subpath(0, 2) = %s", p.subpath(0, 2)));

        // Iterating through path
        for (Path subPath : p) {
            System.out.println(String.format("subPaths = %s", subPath.toString()));
        }

    }

}
