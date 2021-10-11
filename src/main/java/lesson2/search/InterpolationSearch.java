package lesson2.search;

public class InterpolationSearch {
    public static int search(Integer[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int base;
        int i = 0;

        while (end >= start && num >= arr[start] && num <= arr[end]) {
            if (arr[end].equals(arr[start])) {
                break;
            }
            i++;
            base =  (int)(start +
                    1.0 * (end - start) / (arr[end] - arr[start])
                    * (num - arr[start]));

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
        if (arr[start] == num) {
            return start;
        }
        return -1;
    }
}
