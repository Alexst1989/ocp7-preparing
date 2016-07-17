package ru.alexst.certification.ocp.par9.io.files;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.File;
import java.io.IOException;

/*
 
 ■ delete() You can't delete a directory if it's not empty, which is why the
invocation delDir.delete() failed.
■ renameTo() You must give the existing File object a valid new File
object with the new name that you want. (If newName had been null, we
would have gotten a NullPointerException.)
■ renameTo() It's okay to rename a directory, even if it isn't empty.
 
 */

public class WorkWithFile {
	
	public static void main(String args[]) throws IOException {
		File file = new File(insertHome("workwithfile.txt"));
		System.out.println(file.delete());	//Удалили
		
		System.out.println(file.createNewFile());	
		System.out.println(file.createNewFile()); 				//Если файл уже существует, то он не создается заново
		
		System.out.println(file.delete());	
	}

}
