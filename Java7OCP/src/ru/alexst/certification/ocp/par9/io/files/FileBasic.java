package ru.alexst.certification.ocp.par9.io.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class FileBasic {
	
	public static String HOME = "C:\\Users\\Алексей\\YandexDisk\\Учеба\\ПРОГРАММИРОВАНИЕ\\Подготовка к OCP Java 7\\files";

	public static String insertHome(String fileName) {
		return String.format("%s\\%s", HOME, fileName);
	}
	
	public static String insertHome() {
		return String.format("%s", HOME);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(insertHome("file1.txt"));
		
		//Two exception, one from close method (Writer) and one from
		//PrintWriter constructor
		try(Writer wr = new PrintWriter(file)) {
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 

		
		try(PrintWriter wr = new PrintWriter(file)) {
			wr.println("Записали строку");
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Файл будет стёрт и создан заново
		//flush всеравно нужен с try-with-resource
		try(PrintWriter wr = new PrintWriter(file)) {
			wr.append("Записали строку 2");
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Создадим дректорю
		File dir = new File(insertHome("dir1"));
		dir.mkdir();
		File file2 = new File(dir, "file2.txt");
		
		try(PrintWriter pw = new PrintWriter(file2)) {
			
			pw.flush();
		} catch (FileNotFoundException e) {
			//Invalid file path
			e.printStackTrace();
		}
		
	}

}
