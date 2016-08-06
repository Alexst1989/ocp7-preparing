/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Алексей
 *
 */
public class Helper {

    private static final int[] STATIC_ARRAY = new int[20];

    private static final ArrayList<Integer> STATIC_LIST = new ArrayList<>();

    static {
        STATIC_ARRAY[0] = 5;
        STATIC_ARRAY[1] = 66;
        STATIC_ARRAY[2] = 57;
        STATIC_ARRAY[3] = 73;
        STATIC_ARRAY[4] = 1;
        STATIC_ARRAY[5] = 54;
        STATIC_ARRAY[6] = 24;
        STATIC_ARRAY[7] = 16;
        STATIC_ARRAY[8] = 13;
        STATIC_ARRAY[9] = 34;
        STATIC_ARRAY[10] = 39;
        STATIC_ARRAY[11] = 71;
        STATIC_ARRAY[12] = 99;
        STATIC_ARRAY[13] = 49;
        STATIC_ARRAY[14] = 81;
        STATIC_ARRAY[15] = 9;
        STATIC_ARRAY[16] = 77;
        STATIC_ARRAY[17] = 35;
        STATIC_ARRAY[18] = 76;
        STATIC_ARRAY[19] = 4;

        STATIC_LIST.add(5);
        STATIC_LIST.add(66);
        STATIC_LIST.add(57);
        STATIC_LIST.add(73);
        STATIC_LIST.add(1);
        STATIC_LIST.add(54);
        STATIC_LIST.add(24);
        STATIC_LIST.add(16);
        STATIC_LIST.add(13);
        STATIC_LIST.add(34);
        STATIC_LIST.add(39);
        STATIC_LIST.add(71);
        STATIC_LIST.add(99);
        STATIC_LIST.add(49);
        STATIC_LIST.add(81);
        STATIC_LIST.add(9);
        STATIC_LIST.add(77);
        STATIC_LIST.add(35);
        STATIC_LIST.add(76);
        STATIC_LIST.add(4);
    }

    public static int[] getArray(int length) {
        return Arrays.copyOf(STATIC_ARRAY, length);
    }

    public static List<Integer> getArrayList(int length) {
        return STATIC_LIST.subList(0, length);
    }

    public static void printList(List<?> list) {
        System.out.println("================ LIST =================");
        for (Object o : list) {
            System.out.print(String.format("%1$s ", o));
        }
        System.out.println();
        System.out.println("================ LIST =================");
    }

    public static void printIntArray(int[] array) {
        System.out.println("================ ARRAY ================");
        for (int o : array) {
            System.out.print(String.format("%1$d ", o));
        }
        System.out.println();
        System.out.println("================ ARRAY ================");
    }

}
