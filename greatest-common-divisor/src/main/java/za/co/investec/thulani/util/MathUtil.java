package za.co.investec.thulani.util;

import java.math.BigInteger;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class MathUtil {

    /**
     * Calculates the greatest common divisor for two given number using BigInteger's own gcd function
     */
    public static int calculateGCD(final int a, final int b) {
        return BigInteger.valueOf(a)
                .gcd(BigInteger.valueOf(b))
                .intValue();
    }
}
