package lesson6;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

//    public static void main(String[] args) {
//        final int maxHeight = 4;
//        final int amountOfTrees = 20;
//        int amountOfBalancedTrees = 0;
//
//        for (int i = 0; i < amountOfTrees; i++) {
//            TreeImpl<Integer> tree = new TreeImpl<>(maxHeight);
//            while (tree.getHeight() != maxHeight) {
//                tree.add(ThreadLocalRandom.current().nextInt(-25, 26));
//            }
//
//            if (tree.isBalanced()) {
//                System.out.println("balanced");
//                amountOfBalancedTrees++;
//            }
//            tree.display();
//        }
//
//        System.out.printf("%d generated trees, amount of balanced is %d.%nPercentage of unbalanced - %d%%%n",
//                amountOfTrees,
//                amountOfBalancedTrees,
//                100 - (amountOfBalancedTrees * 100 / amountOfTrees));
//
//    }

    public static void main(String[] args) {
        TreeImpl<Integer> tree = new TreeImpl<>();
//        tree.add(-7);
//        tree.add(-11);
//        tree.add(6);
//        tree.add(-19);
//        tree.add(22);
//        tree.add(-24);
//        tree.add(11);
//        tree.display();
//        System.out.println("tree.isBalanced() = " + tree.isBalanced());
//        System.out.println("tree.getHeight() = " + tree.getHeight());

        tree = new TreeImpl<>();
        tree.add(10);
        tree.add(9);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        tree.add(11);
        tree.add(13);
        tree.add(12);
        tree.add(15);
        tree.display();
        System.out.println("tree.isBalanced() = " + tree.isBalanced());
        System.out.println("tree.getHeight() = " + tree.getHeight());

        tree = new TreeImpl<>();
        tree.add(10);
        tree.add(9);
        tree.add(6);
        tree.add(11);
        tree.add(13);
        tree.add(5);

        tree.display();
        System.out.println("tree.isBalanced() = " + tree.isBalanced());
        System.out.println("tree.getHeight() = " + tree.getHeight());
    }

}