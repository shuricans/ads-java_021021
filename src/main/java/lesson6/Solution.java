package lesson6;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {
        final int maxHeight = 4;
        final int amountOfTrees = 20;
        int amountOfBalancedTrees = 0;


        for (int i = 0; i < amountOfTrees; i++) {

            TreeImpl<Integer> tree = new TreeImpl<>(maxHeight);

            while (tree.getHeight() != maxHeight) {
                tree.add(ThreadLocalRandom.current().nextInt(-25, 26));
            }

            if (tree.isBalanced()) {
                System.out.println("balanced");
                amountOfBalancedTrees++;
            }
            tree.display();
        }

        System.out.printf("%d generated trees, amount of balanced is %d.%nPercentage of unbalanced - %d%%%n",
                amountOfTrees,
                amountOfBalancedTrees,
                100 - (amountOfBalancedTrees * 100 / amountOfTrees));


    }

}