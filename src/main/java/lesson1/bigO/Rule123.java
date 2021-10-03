package lesson1.bigO;

public class Rule123 {

    public static int findMax(int[] array) {

        int result = array[0]; //O(1)

        System.out.println("Начинаем поиск"); //O(1)

        for (int i = 1; i < array.length; i++) { //O(n)
            if (result > array[i]) { //O(1)
                result = array[i]; //O(1)
            }
        }

        System.out.println("Поиск окончен. Максимальное число: " + result); //O(1)

        return result; //O(1)
    }
}
//O(1) + O(1) + O(1) + O(1) + O(n) * (O(1) + O(1)) = O(4 + n*2);
//O(2 * n)
//O(n)