/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.testerrors;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

/**
 * @author Алексей
 *
 */

/*
 
 Code compiles but does not output anything !!!!!!!!!!!!!!
 Cant be "\" in a glob, because directoryStream looks immediate files in its dir!!!!!!
 
 */
public class DirectoryStreamErr {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get(insertHome());
		//try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "**/*.txt")) { //Can't be
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt")) { //can be
			for (Path path : stream) {
				System.out.println(path);
			} 
		}
	}

}
