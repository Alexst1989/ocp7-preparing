/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.testerrors;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

/*
A, B, and D are correct. Creation time is a basic attribute, which means you can read
BasicFileAttributes or any of its subclasses to read it. DosFileAttributes is one such
subclass.
*/

/**
 * @author Алексей
 *
 */
public class Attributes {
 
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(insertHome());
        BasicFileAttributes attr1 = Files.readAttributes(dir, BasicFileAttributes.class);
        BasicFileAttributes attr2 = Files.readAttributes(dir, DosFileAttributes.class);// It will work!!!!!!!!!!
        // DosFileAttributes attr3 = Files.readAttributes(dir, BasicFileAttributes.class);
        DosFileAttributes attr4 = Files.readAttributes(dir, DosFileAttributes.class);
        // PosixFileAttributes attr5 = Files.readAttributes(dir, PosixFileAttributes.class); //Only on UNIX
        // BasicFileAttributes attr6 = new BasicFileAttributes(dir);
        // BasicFileAttributes attr7 =dir.getBasicFileAttributes();
    }

}
