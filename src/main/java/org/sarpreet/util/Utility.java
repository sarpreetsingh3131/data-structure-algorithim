package org.sarpreet.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utility {

    public static void swap(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int[] resize(final int[] values, int size) {
        int[] temp = new int[size * 2];
        IntStream.range(0, size)
                .forEach(i -> temp[i] = values[i]);
        return temp;
    }

    public static String toString(int[] values, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> values[i] + " ")
                .collect(Collectors.joining());
    }
}
