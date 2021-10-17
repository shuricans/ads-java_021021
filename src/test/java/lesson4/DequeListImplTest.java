package lesson4;

import lesson3.deque.Deque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DequeListImpl simple testing")
class DequeListImplTest {

    @Test
    void insertLeftAndRemoveLeft() {
        Deque<String> deque = new DequeListImpl<>();
        deque.insertLeft("a");
        deque.insertLeft("b");
        deque.insertLeft("c");
        deque.insertLeft("d");
        deque.insertLeft("e");

        assertAll(
                () -> assertEquals(5, deque.size()),
                () -> assertEquals("e", deque.removeLeft()),
                () -> assertEquals(4, deque.size()),
                () -> assertEquals("d", deque.removeLeft()),
                () -> assertEquals(3, deque.size()),
                () -> assertEquals("c", deque.removeLeft()),
                () -> assertEquals(2, deque.size()),
                () -> assertEquals("b", deque.removeLeft()),
                () -> assertEquals(1, deque.size()),
                () -> assertEquals("a", deque.removeLeft()),
                () -> assertEquals(0, deque.size())
        );
    }

    @Test
    void insertRightAndRemoveRight() {
        Deque<String> deque = new DequeListImpl<>();
        deque.insertRight("a");
        deque.insertRight("b");
        deque.insertRight("c");
        deque.insertRight("d");
        deque.insertRight("e");

        assertAll(
                () -> assertEquals(5, deque.size()),
                () -> assertEquals("e", deque.removeRight()),
                () -> assertEquals(4, deque.size()),
                () -> assertEquals("d", deque.removeRight()),
                () -> assertEquals(3, deque.size()),
                () -> assertEquals("c", deque.removeRight()),
                () -> assertEquals(2, deque.size()),
                () -> assertEquals("b", deque.removeRight()),
                () -> assertEquals(1, deque.size()),
                () -> assertEquals("a", deque.removeRight()),
                () -> assertEquals(0, deque.size())
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderForPeekFront")
    @DisplayName("peekFront")
    void peekFront(String expected, Deque<String> deque) {
        assertEquals(expected, deque.peekFront());
    }

    @ParameterizedTest
    @MethodSource("dataProviderForSize")
    @DisplayName("size")
    void size(int expectedSize, Deque<?> deque) {
        assertEquals(expectedSize, deque.size());
    }

    @ParameterizedTest
    @MethodSource("dataProviderForIsEmpty")
    @DisplayName("isEmpty - expected true")
    void isEmpty(Deque<?> deque) {
        assertTrue(deque.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("dataProviderForToString")
    @DisplayName("toString - expected equals")
    void testToString(String expected, Deque<Integer> deque) {
        assertEquals(expected, deque.toString());
    }

    public static Stream<Arguments> dataProviderForSize() {
        final int maxSizeDeque = 100;
        final int pairsCount = 5;

        Arguments[] arguments = new Arguments[pairsCount];

        for (int i = 0; i < arguments.length; i++) {
            int randomMaxSize = ThreadLocalRandom.current().nextInt(maxSizeDeque) + 1;
            Deque<Integer> deque = new DequeListImpl<>();
            int randomAddCount = ThreadLocalRandom.current().nextInt(randomMaxSize);
            for (int j = 0; j < randomAddCount; j++) {
                deque.insertLeft(j);
            }
            int randomRemoveCount = ThreadLocalRandom.current().nextInt(randomMaxSize);
            for (int j = 0; j < randomRemoveCount; j++) {
                deque.removeRight();
            }
            int expectedSize = Math.max((randomAddCount - randomRemoveCount), 0);
            arguments[i] = Arguments.of(expectedSize, deque);
        }

        return Stream.of(arguments);
    }

    public static Stream<Arguments> dataProviderForPeekFront() {
        Arguments[] arguments = new Arguments[4];

        String expectedValue = "a";
        Deque<String> deque = new DequeListImpl<>();
        deque.insertRight(expectedValue);
        arguments[0] = Arguments.of(expectedValue, deque);

        expectedValue = "b";
        deque = new DequeListImpl<>();
        deque.insertLeft(expectedValue);
        arguments[1] = Arguments.of(expectedValue, deque);

        expectedValue = "c";
        deque = new DequeListImpl<>();
        deque.insertLeft(expectedValue);
        deque.insertRight("d");
        arguments[2] = Arguments.of(expectedValue, deque);

        deque = new DequeListImpl<>();
        arguments[3] = Arguments.of(null, deque);

        return Stream.of(arguments);
    }

    public static Stream<Arguments> dataProviderForIsEmpty() {
        Arguments[] arguments = new Arguments[3];

        Deque<Integer> deque = new DequeListImpl<>();
        arguments[0] = Arguments.of(deque);

        deque = new DequeListImpl<>();
        deque.insertLeft(1);
        deque.removeLeft();
        arguments[1] = Arguments.of(deque);

        deque = new DequeListImpl<>();
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertRight(3);
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();

        arguments[2] = Arguments.of(deque);

        return Stream.of(arguments);
    }

    public static Stream<Arguments> dataProviderForToString() {
        Arguments[] arguments = new Arguments[4];

        Deque<Integer> deque = new DequeListImpl<>();
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertLeft(5);
        arguments[0] = Arguments.of("[5 -> 4 -> 3 -> 2 -> 1]", deque);

        deque = new DequeListImpl<>();
        deque.insertRight(1);
        deque.insertLeft(2);
        deque.insertRight(3);
        arguments[1] = Arguments.of("[2 -> 1 -> 3]", deque);

        deque = new DequeListImpl<>();
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertRight(5);
        arguments[2] = Arguments.of("[4 -> 3 -> 1 -> 2 -> 5]", deque);

        deque = new DequeListImpl<>();
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertRight(5);
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        arguments[3] = Arguments.of("[]", deque);

        return Stream.of(arguments);
    }
}