/**
 * 
 */
package ru.alexst.certification.ocp.par12.innerclasses;

/*
 because a regular inner
class cannot have static declarations of any kind. The only way you can access
the inner class is through a live instance of the outer class!

To create an instance of an inner class, you must have an instance of the outer class to
tie to the inner class. There are no exceptions to this rule: An inner class instance
can never stand alone without a direct relationship to an instance of the outer class

 */
public class OuterBasic {
	
	private Integer x = 10;

	class Inner {
		
		private Integer x = 20;
		
		private Integer yyy = 25;
		
		public Inner() {
			
		}
		
		public void dodo() {
			int y = 5;
			final int yy = 15;
			System.out.println(x);
			//Inner x !!!!!!!
			System.out.println(this.x);
			//Outer x !!!!!!!
			System.out.println(OuterBasic.this.x);
			System.out.println(this.x == OuterBasic.this.x); 
			System.out.println(this.x == x);
			new Integer(5);
			
			//Compilation error !!!!! Only after declaration
			//InnerInner ii2 = new InnerInner();
			
			/*
The same rules apply to
method-local inner classes as to local variable declarations. You can't, for example,
mark a method-local inner class public, private, protected, static
			 */
			class InnerInner{
				
				private Integer x = 30;
				
				public void seeOuter() {
					//System.out.println("InnerInner = " + y); //Compilation error !!!!
					System.out.println("InnerInner = " + yyy);
					//Only final method variables can be accessed from inner local class
					System.out.println("InnerInner = " + yy);
					
					
					
					System.out.println("InnerInner = " + x);
					System.out.println("InnerInner = " + this.x);
					System.out.println("InnerInner = " + Inner.this.x);
					System.out.println("InnerInner = " + OuterBasic.this.x);
				}
			}
			
			InnerInner ii = new InnerInner();
			ii.seeOuter();
			
		}
		
		//static public void dodo(){} // Compilation error!!!
		
	}
	
	public static void main(String args[]){
		OuterBasic ib = new OuterBasic();
		OuterBasic.Inner innerInstance = ib.new Inner();
		OuterBasic.Inner inner2 = new OuterBasic().new Inner();
		
		inner2.dodo();
	}
	
}
