package lesson5.knapsackProblem;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Thing {
    private final String name;
    private final Integer weight;
    private final Integer price;
}
