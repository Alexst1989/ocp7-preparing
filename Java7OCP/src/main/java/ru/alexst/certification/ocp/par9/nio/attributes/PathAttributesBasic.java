/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.attributes;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
    BasicFileAttributes reads four attributes general for most file systems:
     - creationTime()
     - lastAccessTime()
     - lastModifiedTime()

    DosFileAttributes

 */

/**
 * @author Алексей
 *
 */
public class PathAttributesBasic {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String homePath = insertHome();

        Date januaryFirst = new GregorianCalendar(2014, Calendar.JANUARY, 1).getTime();
        // old way
        File file = new File(homePath + "/file");
        try {
            file.createNewFile(); // create the file
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        file.setLastModified(januaryFirst.getTime()); // set time
        System.out.println(file.lastModified()); // get time
        // file.delete(); // delete the file
        // new way
        Path path = Paths.get(homePath, "file2");
        try { // create another file
            Files.createFile(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        FileTime fileTime = FileTime.fromMillis( // convert to the new
                januaryFirst.getTime()); // FileTime object
        try {
            Files.setLastModifiedTime(path, fileTime);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // set time
        System.out.println(Files.getLastModifiedTime(path)); // get time
        printBasicAttributes(path);
        printDosFileAttributes(path);
        setBasicAttributes(path);
        setDosAttributes(path);
        printBasicAttributes(path);
        printDosFileAttributes(path);
        Files.delete(path); // delete the file

    }

    private static void printBasicAttributes(Path path) throws IOException {
        System.out.println("============= Print Basic Attributes =================");
        System.out.println(path.toString());
        BasicFileAttributes basic = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("create: " + basic.creationTime());
        System.out.println("access: " + basic.lastAccessTime());
        System.out.println("modify: " + basic.lastModifiedTime());
        System.out.println("directory: " + basic.isDirectory());
    }

    private static void setBasicAttributes(Path path) throws IOException {
        BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        Date date = new GregorianCalendar(1999, Calendar.APRIL, 16).getTime();
        FileTime ft = FileTime.fromMillis(date.getTime());
        basicView.setTimes(ft, ft, ft);

    }

    private static void printDosFileAttributes(Path path) throws IOException {
        System.out.println("============= Print Dos Attributes =================");
        System.out.println(path.toString());
        DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("hidden: " + dos.isHidden());
        System.out.println("readOnly: " + dos.isReadOnly());
        System.out.println("system: " + dos.isSystem());
        System.out.println("archive: " + dos.isArchive());
    }

    private static void setDosAttributes(Path path) throws IOException {
        System.out.println("============= Set Dos Attributes =================");
        System.out.println(path.toString());
        DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dosView.setArchive(true);
        dosView.setHidden(true);
        dosView.setReadOnly(false);
        dosView.setSystem(false);
    }

}
