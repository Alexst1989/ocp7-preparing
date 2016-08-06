/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.generics;

/**
 * @author Алексей
 *
 */
public class AnimalHolder<T extends Animal> { // use "T" instead of "?"
	
	T animal;
	
	public void doAnimal() {
		animal.checkup();
	}
	
	public static void main(String[] args) {
		AnimalHolder<Dog> dogHolder = new AnimalHolder<Dog>(); // OK
		//AnimalHolder<Integer> x = new AnimalHolder<Integer>(); // Compilation error!
	}
	
	
}
