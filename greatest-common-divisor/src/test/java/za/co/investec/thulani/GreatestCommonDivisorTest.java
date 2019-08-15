package za.co.investec.thulani;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class GreatestCommonDivisorTest {

    private GreatestCommonDivisorDemo commonDivisor;

    @BeforeEach
    void init() {
        commonDivisor = new GreatestCommonDivisorDemo();
    }

    @Test
    @DisplayName("Null Input")
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> commonDivisor.greatestCommonDivisor(null),
                "Passing a null should not be allowed");
    }

    @Test
    @DisplayName("Positive GCD Test")
    void testGreatestCommonDivisor() {
        assertAll(
                () -> assertEquals(2, commonDivisor.greatestCommonDivisor(new int[] {-2, -4})),
                () -> assertEquals(6, commonDivisor.greatestCommonDivisor(new int[] {-6, 6})),
                () -> assertEquals(0, commonDivisor.greatestCommonDivisor(new int[] {0})),
                () -> assertEquals(5, commonDivisor.greatestCommonDivisor(new int[] {5})),
                () -> assertEquals(0, commonDivisor.greatestCommonDivisor(new int[] {0, 0})),
                () -> assertEquals(1, commonDivisor.greatestCommonDivisor(new int[] {0, 1})),
                () -> assertEquals(6, commonDivisor.greatestCommonDivisor(new int[] {6, 12})),
                () -> assertEquals(1, commonDivisor.greatestCommonDivisor(new int[] {3, 25})),
                () -> assertEquals(2, commonDivisor.greatestCommonDivisor(new int[] {2, 4, 6})),
                () -> assertEquals(2, commonDivisor.greatestCommonDivisor(new int[] {6, 4, 2})),
                () -> assertEquals(3, commonDivisor.greatestCommonDivisor(new int[] {6, 12, 27, 33, 45}))
        );
    }
}