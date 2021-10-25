package additionalTasks;

/**
 * Требуется написать метод, принимающий на вход размеры двумерного массива и
 * выводящий массив в виде инкременированной цепочки чисел, идущих по спирали.
 * Примеры:
 * <p>
 * 2х3
 * 1 2
 * 6 3
 * 5 4
 * <p>
 * 3х1
 * 1 2 3
 * <p>
 * 4х4
 * 01 02 03 04
 * 12 13 14 05
 * 11 16 15 06
 * 10 09 08 07
 * <p>
 * 0х7
 * Ошибка!
 */

public class Solution {

    public static void main(String[] args) {
        print(10, 10);
    }

    public static void print(int col, int row) {
        if (col <= 0 || row <= 0) {
            throw new IllegalArgumentException();
        }

        int[][] result = new int[row][col];

        int count = col * row;

        int x = 0;
        int y = 0;

        int value = 1;

        int upperBound = -1;
        int bottomBound = row;
        int leftBound = -1;
        int rightBound = col;

        while (count > 0) {

            // Right move
            while (x < rightBound) {
                result[y][x++] = value++;
                count--;
            }
            if (count > 0) {
                rightBound--;
                upperBound++;
                x--;
                y++;
            } else break;

            // Down move
            while (y < bottomBound) {
                result[y++][x] = value++;
                count--;
            }
            if (count > 0) {
                bottomBound--;
                y--;
                x--;
            } else break;

            // Left move
            while (x > leftBound) {
                result[y][x--] = value++;
                count--;
            }
            if (count > 0) {
                leftBound++;
                x++;
                y--;
            } else break;

            // Up move
            while (y > upperBound) {
                result[y--][x] = value++;
                count--;
            }
            if (count > 0) {
                y++;
                x++;
            } else break;
        }

        int shift = 0;
        while (value > 0) {
            value/=10;
            shift++;
        }

        String format = "%" + shift + "d ";

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.printf(format, result[i][j]);
            }
            System.out.println();
        }
    }

}
