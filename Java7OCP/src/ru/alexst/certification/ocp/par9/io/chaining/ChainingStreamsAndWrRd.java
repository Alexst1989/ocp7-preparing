package ru.alexst.certification.ocp.par9.io.chaining;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ChainingStreamsAndWrRd {

	public static void main(String[] args) {
		File file = new File(insertHome("chaining.txt"));
		
		try(FileWriter fw = new FileWriter(file); 
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos)) {
			
			osw.append("0123456789\r\n");
			fw.write("FileWriterString \r\n");
			bw.write("Buffered Writer String \r\n");
			pw.println("PrintWriter String");
			pw.printf("%s %s", fw, bw);
			
			pw.flush();
		} catch (IOException e) {
			
		}
		
	}

}
