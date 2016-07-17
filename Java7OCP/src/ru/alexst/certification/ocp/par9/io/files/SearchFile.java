package ru.alexst.certification.ocp.par9.io.files;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

/*
 Search works only for directory
 */

import java.io.File;

public class SearchFile {
	
	public static void main(String args[]) {
		File file = new File(insertHome()); // Search will be in this directory
		File file2 = new File(insertHome("chaining.txt")); // Search in file Exception
		String[] fileArray = file.list();
		String[] file2Array = file2.list(); //Will be NULL !!!!!!!!!!!
		
		for (String s:fileArray) System.out.println(s);
		for (String s:file2Array) System.out.println(s);
		
		
		
	}

}
