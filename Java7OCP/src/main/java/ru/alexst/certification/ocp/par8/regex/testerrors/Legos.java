package ru.alexst.certification.ocp.par8.regex.testerrors;

public class Legos {
public static void main(String[] args) {
StringBuilder sb = new StringBuilder(8);
System.out.print(sb.length() + " " + sb + " ");
sb.insert(0, "abcdef");
sb.append("789");
System.out.println(sb.length() + " " + sb);
}
}