package lesson2.HW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("My simple parameterized testing")
class SolutionTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("searchMissedValue")
    void searchMissedValue(int missedValue, int[] a) {
        assertEquals(missedValue, Solution.searchMissedValue(a));
    }

    public static Stream<Arguments> dataProvider() {
        final int maxSize = 1_000_000;
        final int pairsCount = 10;

        Arguments[] arguments = new Arguments[pairsCount + 5];
        arguments[0] = Arguments.of(1, new int[]{});
        arguments[1] = Arguments.of(1, new int[]{2});
        arguments[2] = Arguments.of(1, new int[]{2, 3});
        arguments[3] = Arguments.of(2, new int[]{1, 3});
        arguments[4] = Arguments.of(4, new int[]{1, 2, 3, 5});

        for (int i = 5; i < arguments.length; i++) {
            int randomSize = ThreadLocalRandom.current().nextInt(maxSize) + 1;
            int randomMissedValue = ThreadLocalRandom.current().nextInt(randomSize);
            int[] a = new int[randomSize];
            for (int j = 0; j < a.length; j++) {
                if (j + 1 < randomMissedValue) {
                    a[j] = j + 1;
                } else {
                    a[j] = j + 2;
                }
            }
            arguments[i] = Arguments.of(randomMissedValue, a);
        }

        return Stream.of(arguments);
    }
}