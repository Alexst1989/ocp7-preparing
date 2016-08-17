package ru.alexst.certification.ocp.par9.io.console;

import java.io.Console;

/*
 
Launch from cmd

 */

public class ConsoleBasic {

    public static void main(String args[]) {
        Console console = System.console();
        String string = console.readLine("Enter line:");
        char[] ch = console.readPassword("Enter password:");
        //String s = console.readPassword("Enter password:"); //Compilation error!
        console.writer().println("Ho ho ho");
        console.writer().println("The password is: " + new String(ch));
        console.flush();
    }

}
