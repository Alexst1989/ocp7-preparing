/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.attributes;

import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

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
 */
public class ToLearn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
