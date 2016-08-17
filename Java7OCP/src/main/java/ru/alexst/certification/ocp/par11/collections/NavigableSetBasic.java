package ru.alexst.certification.ocp.par11.collections;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class NavigableSetBasic {

    private static final int N = 9;
    
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

    public static void main(String[] args) {
        NavigableSet<Integer> navigableSet = new ConcurrentSkipListSet<>();
        for (int i = 1; i < N; i++) {
            navigableSet.add(i * 2);
        }
        System.out.println(String.format("Ceiling 3: %s", navigableSet.ceiling(3)));
        System.out.println(String.format("floor 8: %s", navigableSet.floor(8)));
        System.out.println(String.format("floor 9: %s", navigableSet.floor(9)));

        System.out.println(String.format("higher 2: %s", navigableSet.higher(2)));
        System.out.println(String.format("lower 5: %s", navigableSet.lower(5)));

        System.out.println(String.format("pollFirst: %s", navigableSet.pollFirst()));
        System.out.println(String.format("pollLast: %s", navigableSet.pollLast()));

        System.out.println(navigableSet);
    }

}
