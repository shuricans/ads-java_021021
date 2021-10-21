package lesson5;

public class Solution {
    /**
     * Super simple of pow function with recursion.
     * No double...
     * Only positive power of a number...
     * No any checks...
     *
     * @param number just a number
     * @param p positive power of a number
     * @return exponentiation result
     */
    public static long superSimplePow(int number, int p) {

        if (p == 1) {
            return number;
        }

        return number * superSimplePow(number, --p);
    }
}
