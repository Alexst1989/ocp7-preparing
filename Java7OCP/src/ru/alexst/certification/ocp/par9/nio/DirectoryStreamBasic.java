/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Алексей
 *
 */
public class DirectoryStreamBasic {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String homePath = insertHome();
		Path path = Paths.get(homePath);
		
		DirectoryStream<Path> ds = Files.newDirectoryStream(path);
		for(Path p : ds) {
			System.out.println(p.toString());
		}
	}

}
