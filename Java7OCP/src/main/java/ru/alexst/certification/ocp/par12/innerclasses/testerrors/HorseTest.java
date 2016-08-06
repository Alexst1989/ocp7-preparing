/**
 * 
 */
package ru.alexst.certification.ocp.par12.innerclasses.testerrors;

//Referance type is Object, Object doesn't have field name

public class HorseTest {
    public static void main(String[] args) {
        class Horse {

            public String name;

            public Horse(String s) {
                name = s;
            }

        }
        Object obj = new Horse("Zippo");
        System.out.println(obj.name);
    }
}
