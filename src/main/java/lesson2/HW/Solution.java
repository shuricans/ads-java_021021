package lesson2.HW;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    final static int[] testArr;
    final static int SIZE = 1_000_000;

    static {
        testArr = new int[SIZE];
        int missedValue = ThreadLocalRandom.current().nextInt(SIZE) + 1;
        System.out.println("missedValue = " + missedValue);
        for (int i = 0; i < testArr.length; i++) {
            if (i + 1 < missedValue) {
                testArr[i] = i + 1;
            } else {
                testArr[i] = i + 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(searchMissedValue(testArr));
    }

    /**
     * Finds the missing element in an {@code arr}, see examples and description.
     * Based on binary search.
     * Complexity O(log n).
     * Sequence in {@code arr}:
     * - started from 1
     * - arr[n] = arr[n-1] + 1
     * <p>
     * Examples:
     * [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
     * [1, 2, 4, 5, 6] => 3
     * [] => 1
     *
     * @param arr - array of integers.
     * @return missed value or -1 if no missing element in the array.
     */
    public static int searchMissedValue(int[] arr) {

        // simple base cases
        // empty array, first element not equals one
        if (arr.length == 0 || arr[0] != 1) {
            return 1;
        }

        int start = 0;
        int end = arr.length - 1;
        int base;

        while (end >= start) {

            base = (start + end) / 2;

            if (arr[base] == base + 1) { // true - means the missing element will be on the right side
                start = base + 1;
                // if new start element greater then his index + 1, missed number is arr[start] - 1
                if (arr[start] > start + 1) {
                    return arr[start] - 1;
                }
            } else if (arr[base] > base + 1) { // true - means the missing element will be on the left side
                end = base - 1;
                // if new end element equals his index + 1, missed number is arr[end] + 1
                if (arr[end] == end + 1) {
                    return arr[end] + 1;
                }
            }
        }
        // return -1 > no missing element in the array
        return -1;
    }
}



