package lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Simple testing")
class SolutionTest {

    @ParameterizedTest
    @MethodSource("dataProviderForPow")
    @DisplayName("Testing recursion pow function")
    void powTest(long expected, int number, int p) {
        assertEquals(expected, Solution.superSimplePow(number, p));
    }

    public static Stream<Arguments> dataProviderForPow() {
        return Stream.of(
                Arguments.of(0, 0, 2),
                Arguments.of(2, 2, 1),
                Arguments.of(4, 2, 2),
                Arguments.of(-8, -2, 3),
                Arguments.of(16, -2, 4),
                Arguments.of(1024, 2, 10),
                Arguments.of(1419857, 17, 5)
        );
    }
}