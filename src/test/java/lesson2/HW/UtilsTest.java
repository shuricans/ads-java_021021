package lesson2.HW;

import lesson2.SpeedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("My simple testing")
class UtilsTest {

    @Test
    void sortInsert() {
        final int length = 10000;
        Laptop[] input = Utils.getArray(length);
        Laptop[] expected = new Laptop[length];
        System.arraycopy(input, 0, expected, 0, length);

        SpeedTest.startTime();
        // O(n^2)
        Utils.sortInsert(input);
        SpeedTest.endTime();

        SpeedTest.startTime();
        // O(nlogn)
        Arrays.sort(expected, Comparator.comparing(Laptop::getPrice)
                .thenComparing(Laptop::getRam)
                .thenComparingInt(laptop -> Utils.BRANDS_MAP.get(laptop.getBrand())));
        SpeedTest.endTime();

        assertArrayEquals(expected, input);
    }
}