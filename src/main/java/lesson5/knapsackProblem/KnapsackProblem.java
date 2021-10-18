package lesson5.knapsackProblem;

import java.util.*;

public class KnapsackProblem {

    private List<Thing> result = new ArrayList<>();
    private int maxPrice;
    private int capacity;

    public List<Thing> solve(List<Thing> things, int capacity) {
        this.capacity = capacity;
        solution(things);
        return result;
    }

    private void solution(List<Thing> things) {
        if (things.size() == 1) {
            if (things.get(0).getWeight() <= capacity) {
                int price = things.get(0).getPrice();
                if (price > maxPrice) {
                    result = things;
                    maxPrice = price;
                }
            }
            return;
        }

        int weight = things.stream().mapToInt(Thing::getWeight).sum();
        if (weight <= capacity) {
            int price = things.stream().mapToInt(Thing::getPrice).sum();
            if (price > maxPrice) {
                result = things;
                maxPrice = price;
            }
        } else {
            for (int i = 0; i < things.size(); i++) {
                List<Thing> part = new ArrayList<>();
                for (int j = 0; j < things.size(); j++) {
                    if (j != i) {
                        part.add(things.get(j));
                    }
                }
                solution(part);
            }
        }
    }
}
