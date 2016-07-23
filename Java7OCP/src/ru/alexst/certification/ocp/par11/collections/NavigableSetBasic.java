package ru.alexst.certification.ocp.par11.collections;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class NavigableSetBasic {

    private static final int N = 9;

    public static void main(String[] args) {
        NavigableSet<Integer> navigableSet = new ConcurrentSkipListSet<>();
        for (int i = 1; i < N; i++) {
            navigableSet.add(i * 2);
        }
        System.out.println(String.format("Ceiling 3: %s", navigableSet.ceiling(7)));
        System.out.println(String.format("floor 8: %s", navigableSet.floor(7)));

        System.out.println(String.format("higher 2: %s", navigableSet.higher(4)));
        System.out.println(String.format("lower 5: %s", navigableSet.lower(4)));

        System.out.println(String.format("pollFirst: %s", navigableSet.pollFirst()));
        System.out.println(String.format("pollLast: %s", navigableSet.pollLast()));

        System.out.println(navigableSet);
    }

}
