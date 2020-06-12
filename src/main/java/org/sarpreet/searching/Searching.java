package org.sarpreet.searching;

class Searching {

    static class BinarySearch {

        static boolean search(int[] sorted, int num) {
            return binarySearch(0, sorted.length - 1, sorted, num);
        }

        private static boolean binarySearch(int leftIndex, int rightIndex, int[] sorted, int num) {
            if (rightIndex < leftIndex) {
                return false;
            }
            int midIndex = (leftIndex + rightIndex) / 2;
            if (num == sorted[midIndex]) {
                return true;
            } else if (num < sorted[midIndex]) {
                return binarySearch(leftIndex, midIndex - 1, sorted, num);
            } else {
                return binarySearch(midIndex + 1, rightIndex, sorted, num);
            }
        }
    }

    static class LinearSearch {

        static boolean search(int[] array, int num) {
            for (int n : array) {
                if (n == num) {
                    return true;
                }
            }
            return false;
        }
    }
}
