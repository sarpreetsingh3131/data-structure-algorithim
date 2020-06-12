package org.sarpreet.sorting;

import static org.sarpreet.util.Utility.swap;
import static java.util.Arrays.copyOfRange;

class Sorting {

    static class BubbleSort {

        static void sort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        swap(j, j + 1, array);
                    }
                }
            }
        }
    }

    static class HeapSort {

        static void sort(int[] array) {
            buildMaxHeap(array);
            for (int i = array.length - 1; i >= 0; i--) {
                swap(0, i, array);
                heapify(array, i, 0);
            }
        }

        private static void buildMaxHeap(int[] array) {
            for (int i = array.length / 2; i >= 0; i--) {
                heapify(array, array.length , i);
            }
        }

        private static void heapify(int[] array, int heapSize, int parentIndex) {
            int leftChildIndex = (parentIndex * 2) + 1;
            int rightChildIndex = (parentIndex * 2) + 2;
            int maxChildIndex = parentIndex;
            if (leftChildIndex < heapSize && rightChildIndex < heapSize) {
                maxChildIndex = array[leftChildIndex] > array[rightChildIndex] ? leftChildIndex : rightChildIndex;
            } else if (leftChildIndex < heapSize) {
                maxChildIndex = leftChildIndex;
            }
            if (array[maxChildIndex] > array[parentIndex]) {
                swap(maxChildIndex, parentIndex, array);
                heapify(array, heapSize, maxChildIndex);
            }
        }
    }

    static class InsertionSort {

        static void sort(int[] array) {
            for (int i = 1; i < array.length; i++) {
                int index = i;
                while (index > 0 && array[index] < array[index - 1]) {
                    swap(index, index - 1, array);
                    index--;
                }
            }
        }
    }

    static class MergeSort {

        static void sort(int[] array) {
            mergeSort(array);
        }

        private static int[] mergeSort(int[] array) {
            if (array.length == 1) {
                return array;
            }
            int[] left = mergeSort(copyOfRange(array, 0, array.length / 2));
            int[] right = mergeSort(copyOfRange(array, array.length / 2, array.length));
            return merge(left, right, array);
        }

        private static int[] merge(int[] left, int[] right, int[] array) {
            int index = 0;
            int leftIndex = 0;
            int rightIndex = 0;
            while (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    array[index++] = left[leftIndex++];
                } else  {
                    array[index++] = right[rightIndex++];
                }
            }
            while(leftIndex < left.length) {
                array[index++] = left[leftIndex++];
            }
            while(rightIndex < right.length) {
                array[index++] = right[rightIndex++];
            }
            return array;
        }
    }

    static class QuickSort {

        static void sort(int[] array) {
            quickSort(0, array.length - 1, array);
        }

        private static int[] quickSort(int minIndex, int maxIndex, int[] array) {
            if (minIndex < maxIndex) {
                int pivot = pivot(minIndex, maxIndex, array);
                int partition = partition(minIndex, maxIndex, pivot, array);
                quickSort(minIndex, partition, array);
                quickSort(partition + 1, maxIndex, array);
            }
            return array;
        }

        private static int pivot(int minIndex, int maxIndex, int[] array) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (array[midIndex] < array[minIndex]) {
                swap(midIndex, minIndex, array);
            }
            if (array[maxIndex] < array[minIndex]) {
                swap(maxIndex, minIndex, array);
            }
            if (array[midIndex] < array[maxIndex]) {
                swap(midIndex, maxIndex, array);
            }
            return array[midIndex];
        }

        private static int partition(int minIndex, int maxIndex, int pivot, int[] array) {
            while (true) {
                while (array[minIndex] < pivot) {
                    minIndex++;
                }
                while (array[maxIndex] > pivot) {
                    maxIndex--;
                }
                if (minIndex >= maxIndex) {
                    return maxIndex;
                }
                swap(minIndex, maxIndex, array);
                minIndex++;
                maxIndex--;
            }
        }
    }

    static class SelectionSort {

        static void sort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[minIndex] > array[j]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    swap(minIndex, i, array);
                }
            }
        }
    }
}
