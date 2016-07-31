/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
■ Negative If thisObject < anotherObject
■ Zero If thisObject == anotherObject
■ Positive If thisObject > anotherObject


Collection.sort(List)
*/

public class CompareBasic implements Comparable<CompareBasic> {

	private Integer id;
	
	private String name;
	
	public CompareBasic(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int compareTo(CompareBasic anotherObject) {
		if (anotherObject == null) {
			return -1;
		} else
		if ((this.getId() == null && this.getName() == null)
				|| (anotherObject.getId() == null 
				&& anotherObject.getName() == null)) {
			return -1;
		} 
		byte b = 0, c = 0;
		if (this.getId()-anotherObject.getId() < 0) {
			b = -10;
		} else if (this.getId()-anotherObject.getId() > 0) {
			b = 10;
		} else {
			b=0;
		}
		if (this.getName().compareTo(anotherObject.getName()) < 0) {
			c = -1;
		} else if (this.getName().compareTo(anotherObject.getName()) > 0) {
			c = 1;
		} else {
			c=0;
		}
		return b + c;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%1$3d - %2$s", this.id, this.name);
	}
	
	public static void main(String args[]){
		CompareBasic cb1 = new CompareBasic(1, "Alex");
		CompareBasic cb2 = new CompareBasic(4, "Alex");
		CompareBasic cb3 = new CompareBasic(2, "John");
		CompareBasic cb4 = new CompareBasic(3, "Jhosef");
		CompareBasic cb5 = new CompareBasic(1, "Boris");
		CompareBasic cb6 = new CompareBasic(null, null);
		CompareBasic cb7 = new CompareBasic(null, null);
		List<CompareBasic> list = new ArrayList<CompareBasic>();
		list.add(null);
		list.add(cb1);
		list.add(cb2);
		list.add(cb3);
		list.add(cb4);
		list.add(cb5);
		list.add(cb6);
		list.add(cb7);
		
		printList(list);
		
		Collections.sort(list);
		
		printList(list);
		
		int[] intArray = new int[10];
		Arrays.sort(intArray);
	}
	
	public static void printList(List<?> list) {
		System.out.println("=================================");
		for (Object o:list) {
			System.out.println((o == null) ? String.format("%1$10s", "null") : o.toString());
		}
	}
	

}
