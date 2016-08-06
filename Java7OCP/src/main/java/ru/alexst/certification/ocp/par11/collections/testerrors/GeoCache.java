/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.testerrors;

/*
Before using binarySarch Array or Collection must be sorted!!!
 
 */

import java.util.*;
 public class GeoCache {
 public static void main(String[] args) {
 String[] s = {"map", "pen", "marble", "key"};
 Othello o = new Othello();
Arrays.sort(s,o);
for(String s2: s) System.out.print(s2 + " ");
 System.out.println(Arrays.binarySearch(s, "map"));
 }
 static class Othello implements Comparator<String> {
 public int compare(String a, String b) { return b.compareTo(a); }
}
 }
