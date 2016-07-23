package ru.alexst.certification.ocp.par11.collections;

import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class SortedSetBasic {

    private static final int N = 9;

    public static void main(String args[]) {
        SortedSet<Integer> sortedIntSet = new ConcurrentSkipListSet<>();
        for (int i = 1; i < N; i++) {
            sortedIntSet.add(i);
        }
        System.out.println(sortedIntSet.headSet(8));
        System.out.println(sortedIntSet.tailSet(8));

        System.out.println(sortedIntSet.subSet(4, 8));

        System.out.println(sortedIntSet.first());
        System.out.println(sortedIntSet.last());

        System.out.println(sortedIntSet);

    }

}
