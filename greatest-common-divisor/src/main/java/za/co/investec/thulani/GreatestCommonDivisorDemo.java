package za.co.investec.thulani;

import za.co.investec.thulani.util.MathUtil;
import za.co.investec.thulani.util.NumberUtil;

import java.util.Scanner;

/**
 * author: Thulani Hlongwane
 * Date: 2019/08/11
 */
public class GreatestCommonDivisorDemo {

    /**
     * This method receives an array of integers and finds the highest denominator of the integers
     *
     * @param numbers int[]
     * @return greatest common divisor
     */
    public int greatestCommonDivisor(final int[] numbers) {
        if(!validateInputNumbers(numbers))
            throw new IllegalArgumentException("Please provide two or more valid numbers");

        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = MathUtil.calculateGCD(numbers[i], result);
        }

        return result;
    }

    private boolean validateInputNumbers(int[] numbers) {
        return numbers != null;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorDemo divisor = new GreatestCommonDivisorDemo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter numbers you would like to find the greatest common divisor for (eg. 6, 12, 15): ");

        String numberString = scanner.nextLine();
        int[] numbers = NumberUtil.convertToIntArray(numberString);

        System.out.printf("The Greatest Common Factor is %d", divisor.greatestCommonDivisor(numbers));
    }
}