/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.generics;

import java.util.ArrayList;
import java.util.List;

/*
 	-	There's a very simple rule here—the type of the variable
		declaration must match the type you pass to the actual object type

	- 	List<? extends Animal>  List<? extends Serializable> NOT List<? implements Serializable> !!
	
	- 	public void foo(List<?> list) { } means any type. could be a List of <Dog>, <Integer>, <JButton>, <Socket>, whatever
		You cannot ADD anything to the list referred to as List<?> !!!!!!!!!!
		
		public void foo(List<Object> list) { } the method can take ONLY a List<Object>. Not a List<Dog> or a List<Cat>.
		
		List<? extends Object> and List<?> are absolutely identical
		
		
 */
public class Polymorphism {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List<Parent> myList = new ArrayList<Child>(); //Compiler error!!!
		Object[] myArray = new Integer[3]; //OK
		
		//It is OK for collection
		List<AbstractAnimal> animalList = new ArrayList<AbstractAnimal>();
		animalList.add(new Dog());
		animalList.add(new Cat());
		
		//It is OK for array
		AbstractAnimal[] animalArray = new AbstractAnimal[10];
		animalArray[0] = new Dog();
		animalArray[1] = new Bird();
		
		Cat[] catArray = new Cat[2];
		catArray[0] = new Cat();
		catArray[1] = new Cat();
		
		List<Cat> catList = new ArrayList<Cat>();
		catList.add(new Cat());
		catList.add(new Cat());
		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(new Dog());
		dogList.add(new Dog());
		List<Bird> birdList = new ArrayList<Bird>();
		birdList.add(new Bird());
		birdList.add(new Bird());
		
		//AnimalDoctor.checkAnimalList(catList); //Compilation error !!!!!!
		AnimalDoctor.checkAnimalArray(catArray); //BUT FOR ARRAY IT IS OK !!!!
		
		//This scenario has been tried to be avoided with generics
		AnimalDoctor.holyShit(catArray);
		
		List<?> list = new ArrayList<Dog>();
		List<? extends AbstractAnimal> aList = new ArrayList<Dog>();
		aList.add(null); //Can't add anything but null
		//List<?> foo = new ArrayList<? extends Animal>(); //Compilation error !!!!!! You cannot use wildcard notation in the object creation.
		//List<? extends Dog> cList = new ArrayList<Integer>(); //Compilation error !!!!!! You cannot assign an Integer list to a reference that takes only a Dog
		List<? super Dog> bList = new ArrayList<AbstractAnimal>();
		bList.add(new Dog()); //Only Dog can be added!!!
		//List<? super Animal> dList = new ArrayList<Dog>(); //Compilation error !!!!!! 
		//You cannot assign a Dog to <? super Animal>. The Dog is too "low" in the class hierarchy
		
	}
	
	
	

}
class Parent { }
class Child extends Parent { }




class AnimalDoctor {
	// method takes an array of any animal subtype
	public static void checkAnimalArray(AbstractAnimal[] animalArray) {
		for(AbstractAnimal a : animalArray) {
			a.checkup();
		}
	}
	
	public static void checkAnimalList(List<AbstractAnimal> animalList) {
		for(AbstractAnimal a : animalList) {
			a.checkup();
		}
	}
	
	
	public static void holyShit(AbstractAnimal[] animalArray) {
		//If you put Cat[] array in this method, this code will compile, but RuntimeException occurs
		/*
		 But there IS no equivalent exception for generics because of type erasure! In other
words, at runtime, the JVM KNOWS the type of arrays, but does NOT know the type
of a collection.
		 */
		animalArray[0] = new Dog();
	}
	
	public static void checkAnimalWildcard(List<? extends AbstractAnimal> animalList) {
		//? extends Animal means that I SWEAR THAT I WILL NOT ADD anything into the collection !!!!!!!!!!!!!!!!!
		for(AbstractAnimal a : animalList) {
			a.checkup();
		}
		//animalList.add(new Cat()); //Compilation error
	}
	
	public static void checkAnimalWildcardSuper(List<? super Dog> dogList) {
		/*
		 Hey, compiler, please accept any List with a generic type that is of
type Dog or a supertype of Dog. Nothing lower in the inheritance tree can come in,
but anything higher than Dog is okay.
		 */
		dogList.add(new Dog()); // adding is sometimes OK with super
		//dogList.add(new Cat()); //Compiler error
		//dogList.add((Animal)new Cat()); //Compiler error
	}
	
	
}
