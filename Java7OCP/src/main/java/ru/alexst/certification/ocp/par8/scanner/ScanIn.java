package ru.alexst.certification.ocp.par8.scanner;

import java.util.Scanner;

public class ScanIn {
    public static void main(String[] args) {
        System.out.print("input: ");
        System.out.flush();
        try {
            Scanner s = new Scanner(System.in);
            String token;
            do {
                token = s.findInLine("\\d\\d");
                System.out.println("found " + token);
            } while (token != null);
        } catch (Exception e) {
            System.out.println("scan exc");
        }
    }
}