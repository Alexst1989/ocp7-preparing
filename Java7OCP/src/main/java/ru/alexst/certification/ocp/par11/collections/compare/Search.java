/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.compare;

import static ru.alexst.certification.ocp.par11.collections.Helper.getArray;
import static ru.alexst.certification.ocp.par11.collections.Helper.getArrayList;
import static ru.alexst.certification.ocp.par11.collections.Helper.printIntArray;
import static ru.alexst.certification.ocp.par11.collections.Helper.printList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 Array must be sorted before search !!!!!!!!!
 
 */
public class Search {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = getArray(10);
		printIntArray(array);
		System.out.println(String.format("Searching for element with value %d: index = %d", 6, Arrays.binarySearch(array, 6)));
		Arrays.sort(array);
		printIntArray(array);
		System.out.println(String.format("Searching for element with value %d: index = %d", 6, Arrays.binarySearch(array, 6)));
		
		
		List<Integer> list = getArrayList(10);
		printList(list);
		System.out.println(String.format("Searching for element with value %d: index = %d", 6, Collections.binarySearch(list, 6)));
		System.out.println();
		Collections.sort(list);
		printList(list);
		System.out.println(String.format("Searching for element with value %d: index = %d", 6, Collections.binarySearch(list, 6)));
		
		System.out.println(String.format("Searching for element with value %d: index = %d", 13, Collections.binarySearch(list, 13)));
		System.out.println(String.format("Searching for element with value %d: index = %d", 5, Collections.binarySearch(list, 5)));


	}

}
