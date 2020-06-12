package org.sarpreet.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

class SearchingTest {

    final int startRange = -100000;
    final int endRange = 100000000;
    final int[] sortedArray = IntStream.range(startRange, endRange).toArray();
    final int[] unsortedArray = new Random().ints(endRange, startRange, endRange).toArray();
    final int numToFind = 100;
    final boolean expectedSorted = IntStream.of(sortedArray).anyMatch(i -> i == numToFind);
    final boolean expectedUnsorted = IntStream.of(unsortedArray).anyMatch(i -> i == numToFind);

    @Test
    void binarySearch() {
        Assertions.assertEquals(expectedSorted, Searching.BinarySearch.search(sortedArray, numToFind));
    }

    @Test
    void linearSearch() {
        Assertions.assertEquals(expectedUnsorted, Searching.LinearSearch.search(unsortedArray, numToFind));
    }
}
