/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.testerrors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*
 
 Which code inserted at // CODE HERE would cause the FileVisitor to stop visiting files after
it sees the file Test.java?

ONLY return FileVisitResult.TERMINATE !!!!!!!!!!!!

SKIP_SUBLINGS wont stop visiting files in other directories !!!!!!!!!!!
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {
	// more code here
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)	throws IOException {
		System.out.println("File " + file);
		if ( file.getFileName().endsWith("Test.java")) {
			return FileVisitResult.TERMINATE; // CODE HERE 
			
		}
		return FileVisitResult.CONTINUE;
	}

	// more code here
}