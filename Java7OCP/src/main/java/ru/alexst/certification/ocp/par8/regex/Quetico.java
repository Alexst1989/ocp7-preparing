package ru.alexst.certification.ocp.par8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Quetico {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\B");
        Matcher m = p.matcher("^23 *$76 bc");
        // 01234567890
        System.out.print("match positions: ");
        while (m.find()) {
            System.out.print(m.start() + " ");
        }
        System.out.println("");
    }
}
