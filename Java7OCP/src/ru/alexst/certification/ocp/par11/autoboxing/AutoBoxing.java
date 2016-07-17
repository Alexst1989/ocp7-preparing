/**
 * 
 */
package ru.alexst.certification.ocp.par11.autoboxing;

/*
 
 When == is used to compare a primitive to a wrapper, the wrapper will be
unwrapped and the comparison will be primitive to primitive.
 
 
"==" always return true for Objects:
■ Boolean
■ Byte
■ Character from \u0000 to \u007f (7f is 127 in decimal)
■ Short and Integer from –128 to 127
 
 */
public class AutoBoxing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i1 = 1000;
		Integer i2 = 1000;
		if(i1 != i2) System.out.println("different objects");
		if(i1.equals(i2)) System.out.println("meaningfully equal");
		
		Integer i3 = 10;
		Integer i4 = 10;
		if(i3 == i4) System.out.println("same object");
		if(i3.equals(i4)) System.out.println("meaningfully equal");
		
		Integer y = 567; // make a wrapper
		Integer x = y; // assign a second ref
		// var to THE wrapper
		System.out.println(y==x); // verify that they refer
		// to the same object
		y++; // unwrap, use, "rewrap"
		System.out.println(x + " " + y); // print values
		System.out.println(y==x);
		//System.out.println(0b0011 ^ 0b1001);
		
		System.out.println(String.format("%1$3d", 20, 100));
	}

}
