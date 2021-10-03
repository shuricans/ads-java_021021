package lesson1.bigO;

public class ExampleLogn {
    public static void main(String[] args) {

        int[] arr = {1,1,1,1,1,12,3,4,5,6,4,5};

        for (int i = 1; i < arr.length; i*=2) {
            System.out.println(arr[i]);
        } //O(logn)
    }
}
