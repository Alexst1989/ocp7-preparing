/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/*
 
 Files.copy
 	-file
 		Если файл назначения существует, FileAlreadyExistsException. Можно добавить StandardCopyOption.REPLACE_EXISTING.
 		
 	-directory
 		Можно копировать директорию со всем содержимым
 Files.move
 	-file
 		Ошибки в случе если исходного файла нет или уже есть
 		файл назначения
 	-directory
 		Можно перемещать директорию со всем содержимым. Ошибки в случе если исходной директории нет или уже есть
 		директория назначения
 
 Files.delete
 	-file
 		Нельзя удалять несуществующий файл
 	-directory
 		Нельзя удалять не пустую директорию
 
 
 */
/**
 * @author Алексей
 *
 */
public class CopyMoveDeleteFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String homePath = insertHome();

		
		
		Path copyFromDir = Paths.get(homePath+"\\copyfrom");
		Path copyToDir = Paths.get(homePath+"\\copyto");
		
		Path moveToDir = Paths.get(homePath+"\\movetodir");
		
		createDir(copyFromDir);
		createDir(copyToDir);
		//createDir(moveToDir);
		
		Path copyFromFile = Paths.get(copyFromDir.toString()+"\\copyFile.txt");
		Path copyToFile = Paths.get(copyToDir.toString()+"\\copyToFile.txt");

		createFile(copyFromFile);

		//Копируем файл в дректорию с затиранием (Сделал из существующей директории файл!!!!)
		//copyFile(copyFromFile, copyToDir, StandardCopyOption.REPLACE_EXISTING);
		//Копировать нужно с указанием двух файлов, иначе затрет директорию !!!
		//copyFile(copyFromFile, copyToFile, StandardCopyOption.REPLACE_EXISTING);
		
		//Если файл существует то будет exception
		//copyFile(copyFromFile, copyToFile);
		//deleteFile(copyToFile);
		//deleteFile(copyToFile);
		//copyFile(Paths.get("C:\\1.txt"), copyToFile, StandardCopyOption.REPLACE_EXISTING);
		
		moveFile(copyFromDir, moveToDir);
	}
	
	private static Path createFile(Path path) {
		try {
			return Files.createFile(path);
		} catch (IOException e) {
			System.out.println("Ошибка создания файла "+path.toString());
		}
		return null;
	}
	
	private static Path createDir(Path path) {
		try {
			return Files.createDirectory(path);
		} catch (FileAlreadyExistsException e) {
			System.out.println(String.format("Ошибка создания директории:\r\n Директории %s уже существует", path.toString()));
		} catch (IOException e) {
			System.out.println("Ошибка создания директории "+path.toString());
		}
		return null;
	}
	
	private static void copyFile(Path source, Path target) {
		try {
			Files.copy(source, target);
		} catch (FileAlreadyExistsException e) {
			System.out.println(String.format("Ошибка копирования. Файл %s уже существует", target.toString()));
		} catch (IOException e) {
			System.out.println("Ошибка копирования");
			e.printStackTrace();
		}
	}
	
	private static void copyFile(Path source, Path target, CopyOption options) {
		try {
			Files.copy(source, target, options);
		} catch (NoSuchFileException e) {
			System.out.println(String.format("Ошибка копирования. Файла с именем %s не существует", source.toString()));
		} catch (FileAlreadyExistsException e) {
			System.out.println(String.format("Ошибка копирования. Файл %s уже существует", target.toString()));
		} catch (IOException e) {
			System.out.println("Ошибка копирования");
		}
	}
	
	private static void deleteFile(Path target) {
		try {
			Files.delete(target);
		} catch (NoSuchFileException e) {
			System.out.println(String.format("Ошибка при удалении файла.\r\n Файла с именем %s не существует", target.toString()));
		} catch (IOException e) {
			System.out.println("Ошибка удаления");
		}
	}
	
	private static void moveFile(Path source, Path target) {
		try {
			Files.move(source, target);
		} catch (FileAlreadyExistsException e) {
			System.out.println(String.format("Ошибка при перемещении файла.\r\n Файла с именем %s уже существует", target.toString()));
		} catch (DirectoryNotEmptyException e) {
			System.out.println(String.format("Ошибка при перемещении директории.\r\n Директория %s не пуста", target.toString()));
		} catch (IOException e) {
			
		}
		 
	}

}
