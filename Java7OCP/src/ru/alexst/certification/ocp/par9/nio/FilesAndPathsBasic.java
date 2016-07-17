package ru.alexst.certification.ocp.par9.nio;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAndPathsBasic {

	public static void main(String args[]) throws IOException, URISyntaxException {
		String homePath = insertHome();
		String homeUri = "C:/Users/Алексей/YandexDisk/Учеба/ПРОГРАММИРОВАНИЕ/Подготовка%20к%20OCP%20Java%207/files";
		Path path = Paths.get(homePath);
		
		//Creating absolute paths relative to root directory
		Path p3 = Paths.get("/tmp", "file1.txt"); // /tmp/file1.txt
		Path p4 = Paths.get("c:", "temp", "test"); // c:\\temp\\test
		Path p5 = Paths.get("c:\\temp2", "test") ; // c:\\temp\\test
		
		//Creating relative paths without root directory
		//This directory occurs in place where program run:
		//C:\Users\Алексей\YandexDisk\Учеба\ПРОГРАММИРОВАНИЕ\Подготовка к OCP Java 7\Workspace\Java7OCP
		Path pp = Paths.get("ocptestrelative");
		Path p6 = Paths.get("ocptestrelative", "file1.txt");
		
		
		//Creating file in relative path
		if (!Files.isDirectory(pp)) Files.createDirectory(pp); //If directory already exist's an exception will occur
		Path path2;
		try {
			Files.createFile(p5);
			//if directory where you trying to create a file doesn't exists an exception will occur
			//if file already exists, an exception will occur
			path2 = Files.createFile(p6); 
		} catch (NoSuchFileException e) {
			System.err.println("NoSuchFileException");
		} catch (FileAlreadyExistsException e) {
			System.err.println("FileAlreadyExistsException");
		}
		
		
		//Converting nio <-> io
		File ioFile = p6.toFile();
		Path nioPath = ioFile.toPath();
		
		//Creating Path by URI
		Path uriPath = Paths.get(new URI(String.format("file:///%s/dir1", homeUri)));
		Files.createDirectory(uriPath);
		
	}
	
}

