package za.co.investec.thulani.util;

import java.util.stream.Stream;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class NumberUtil {
    public static int[] convertToIntArray(final String numbers) {
        final String[] integers = numbers.split(",");
        return Stream.of(integers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}