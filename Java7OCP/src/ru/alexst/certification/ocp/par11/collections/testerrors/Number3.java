/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.testerrors;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*You can't put both Strings and ints into the same TreeSet. Without
generics, the compiler has no way of knowing what type is appropriate for this TreeSet,
so it allows everything to compile. At runtime, the TreeSet will try to sort the elements
as they're added, and when it tries to compare an Integer with a String, it will throw a
ClassCastException. Note that although the before() method does not use generics, it does
use autoboxing. Watch out for code that uses some new features and some old features mixed
together.
 */
public class Number3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		before();
	}
	
	public static void before() {
		Set set = new TreeSet();
		set.add("2");
		set.add(3);
		set.add("1");
		Iterator it = set.iterator();
		while (it.hasNext())
		System.out.print(it.next() + " ");
	}
	
}
