package org.sarpreet.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortingTest {

    int[] sorted;
    int[] unsorted;
    final int size = 90000;
    final int[] random =  new Random().ints(size, -size, size).toArray();

    @BeforeEach
    void setUp() {
        unsorted = random;
        if (sorted == null) {
            sorted = Arrays.copyOf(unsorted, unsorted.length);
            Arrays.sort(sorted);
        }
    }

    @AfterEach
    void verify() {
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void bubbleSort() {
        Sorting.BubbleSort.sort(unsorted);
    }

    @Test
    void heapSort() {
        Sorting.HeapSort.sort(unsorted);
    }

    @Test
    void insertionSort() {
        Sorting.InsertionSort.sort(unsorted);
    }

    @Test
    void MergeSort() {
        Sorting.MergeSort.sort(unsorted);
    }

    @Test
    void quickSort() {
        Sorting.QuickSort.sort(unsorted);
    }

    @Test
    void selectionSort() {
        Sorting.SelectionSort.sort(unsorted);
    }
}
