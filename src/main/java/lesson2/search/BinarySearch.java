package lesson2.search;

public class BinarySearch {
    public static int search(Integer[] arr, int num) {

        int start = 0;
        int end = arr.length - 1;
        int base;
        int i = 0;

        while (end >= start) {
            i++;
            base = (start + end) / 2;
            System.out.println("Base: " + base);

            if (arr[base] == num) {
                System.out.println("Кол-во итераций: " + i);
                return base;
            } else if(arr[base] < num) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        System.out.println("Кол-во итераций: " + i);
        return -1;
    }
}
