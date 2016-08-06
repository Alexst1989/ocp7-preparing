/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.generics;

/**
 * @author Алексей
 *
 */
public class TestGenerics<T> { // as the class type

    T anInstance; // as an instance variable type

    T[] anArrayOfTs; // as an array type

    TestGenerics(T anInstance) { // as an argument type
        this.anInstance = anInstance;
    }

    T getT() { // as a return type
        return anInstance;
    }
}
