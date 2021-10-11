package lesson2.HW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("My simple parameterized testing")
class SolutionTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("searchMissedValue")
    void searchMissedValue(int[] array, int expectedValue) {
        assertEquals(expectedValue, Solution.searchMissedValue(array));
    }

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{},
                        1
                ),
                Arguments.of(
                        new int[]{2},
                        1
                ),
                Arguments.of(
                        new int[]{2, 3},
                        1
                ),
                Arguments.of(
                        new int[]{1, 3},
                        2
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 5},
                        4
                ),
                Arguments.of(
                        getArray(10_000, 123),
                        123
                ),
                Arguments.of(
                        getArray(1_000_000, 89796),
                        89796
                )
        );
    }

    private static int[] getArray(int length, int missedValue) {
        final int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            if (i + 1 < missedValue) {
                a[i] = i + 1;
            } else {
                a[i] = i + 2;
            }
        }
        return a;
    }
}