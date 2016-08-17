package ru.alexst.certification.ocp.par11.collections;

import java.util.NavigableSet;
import java.util.TreeSet;

/*
Натуральная сортировка по возрастанию (от меншего к большему)

First            9               Last
Lower                            Higher
Floor                            Ceiling                     
0  2   4   6   8   10   12   14   16

Ceiling(3) - 4 (Потолок) <= 3
Floor(8)   - 8 (Пол) >= 8
Floor(9)   - 8 (Пол) >= 9

Higher(2)  - 4 (больше)
Lower(5)   - 4 (меньше)


*/


public class NavigableSetTrain {
    
    private static final Integer N = 10;

    public static void main(String[] args) {
        NavigableSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("d");
        set.add("h");
        set.add("l");
        set.add("o");
        set.add("p");
        set.add("q");
        set.add("z");
        print(set);
        
        NavigableSet<String> descSet = set.descendingSet();
        print(descSet);
        
        System.out.println(String.format("higher 'm' = %s", descSet.higher("m"))); // l
        System.out.println(String.format("ceiling 'r' = %s", descSet.ceiling("r"))); // q
        System.out.println(String.format("ceiling 'b' = %s", descSet.ceiling("b"))); // a
        System.out.println(String.format("floor 'r' = %s", descSet.floor("r"))); // z
        
    }
    
    private static void generateStringSet(NavigableSet<String> set) {
        for (int i = 0; i < N; i++) {
            set.add(Character.getName(i));
            System.out.println();
        }
    }
    
    private static void print(NavigableSet<?> set) {
        for (Object o : set) {
            System.out.print(o.toString() + " ");
        }
        System.out.println();
    }

}
