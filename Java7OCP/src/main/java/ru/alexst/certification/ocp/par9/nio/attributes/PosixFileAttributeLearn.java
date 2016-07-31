/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.attributes;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * @author Алексей
 *
 */
public class PosixFileAttributeLearn {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String homePath = insertHome();

        Path path = Paths.get(homePath + "\\posixDir");
        PosixFileAttributeView posixView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r--r--");
        posixView.setPermissions(perms);
        Files.setPosixFilePermissions(path, perms);

    }

}
