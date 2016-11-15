/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.attributes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

/*
 BasicFileAttributes reads four attributes general for most file systems:
     - creationTime()
     - lastAccessTime()
     - lastModifiedTime()
     
 DosFileAttributes - for Windows
     - setArchive(true);
     - setHidden(true);
     - setReadOnly(false);
     - setSystem(false);
     
 PosixFileAttributes - For Unix Linux
     - Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r--r--");
     - first is Owner
     - second is Group
     - third id Other
     
 FileOwnerAttributeView - parent for PosixFileAttributes
     - String name();
     - void setOwner(UserPrincipal owner) throws IOException;
     - UserPrincipal getOwner() throws IOException;
     
 UserDefinedFileAttributeView - 
     - List<String> list() throws IOException; - list containing the names of the user-defined attributes.
     - int size(String name) throws IOException;
     - int read(String name, ByteBuffer dst) throws IOException;
     - int write(String name, ByteBuffer src) throws IOException;
     - void delete(String name) throws IOException;
 
 
 */
public class ToLearn {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Object[] strs = {1.0, 9, null};
        System.out.printf("%2$x-%1$.2f-%f-%d-%b", strs);
    }

}
