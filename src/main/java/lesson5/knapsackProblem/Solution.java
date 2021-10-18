package lesson5.knapsackProblem;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        final int capacity = 8;
        List<Thing> things = List.of(
                new Thing("phone", 2, 100),
                new Thing("book", 1, 20),
                new Thing("clock", 1, 50),
                new Thing("laptop", 3, 150),
                new Thing("TV", 5, 200)
        );

        KnapsackProblem knapsackProblem = new KnapsackProblem();
        List<Thing> result = knapsackProblem.solve(things, capacity);

        System.out.println("result price = " + result.stream().mapToInt(Thing::getPrice).sum());
        System.out.println("result weight = " + result.stream().mapToInt(Thing::getWeight).sum());
        System.out.println();
        for (Thing thing : result) {
            System.out.println(thing);
        }
    }
}
