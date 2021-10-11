package lesson2.HW;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    final static int[] testArr;
    final static int SIZE = 2;

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
        System.out.println(Arrays.toString(testArr));
    }

    public static void main(String[] args) {
//         5
//        int[] a = {1, 2, 3, 4, 6};
//        System.out.println(5);
//        System.out.println(Arrays.toString(a));
        int[] a = new int[0];
        System.out.println(searchMissedValue(a));
    }



    public static int searchMissedValue(int[] arr) {

        // base case for empty array
        if (arr.length == 0) {
            return 1;
        }

        int start = 0;
        int end = arr.length - 1;
        int base;
        int i = 0;

        while (end >= start) {
            i++;
            base = (start + end) / 2;
            System.out.println("Base: " + base);

            if (arr[base] == base + 1) { // go to the right part
                start = base + 1;
                if (arr[start] > base + 2) {
                    System.out.println("Кол-во итераций (1): " + i);
                    return base + 2;
                }
            } else if(arr[base] > base + 1 && end > start) { // go to the left part
                if(arr[base - 1] == base) {
                    System.out.println("Кол-во итераций (2): " + i);
                    return base + 1;
                }
                end = base - 1;
            } else {
                System.out.println("Кол-во итераций (3): " + i);
                return base + 1;
            }
        }

        System.out.println("Кол-во итераций: " + i);
        return -1;
    }
}



