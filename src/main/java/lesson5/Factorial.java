//5! = 5 * 4!;
//4! = 4 * 3!;
//3! = 3 * 2!
//2! = 2 * 1!;
//1! = 1;

package lesson5;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(100000));
    }

    private static long factorial(long n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
