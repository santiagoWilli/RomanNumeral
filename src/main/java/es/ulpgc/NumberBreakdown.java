package es.ulpgc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberBreakdown {

    public static int[][] breakdownOf(int number) {
        int[] length = new int[]{String.valueOf(number).length() - 1};

         return Arrays.stream(String.valueOf(number).split(""))
                 .map(d -> tuple(d, length))
                 .filter(t -> isNotZero(t[0]))
                 .collect(Collectors.toList())
                 .toArray(new int[setArrayLength(number)][]);
    }

    private static int[] tuple(String d, int[] length) {
        return new int[]{Integer.parseInt(d), length[0]--};
    }

    private static boolean isNotZero(int number) {
        return number != 0;
    }

    private static int numberOfDigits(int number) {
        return String.valueOf(number).length();
    }

    private static int setArrayLength(int number) {
        return numberOfDigits(number) - numberOfZeros(number);
    }

    private static int numberOfZeros(int number) {
        return numberOfZeros(String.valueOf(number));
    }

    private static int numberOfZeros(String number) {
        if(number.length() == 0) return 0;
        if(Integer.parseInt(number.substring(0, 1)) == 0) return 1 + numberOfZeros(number.substring(1, number.length()));
        return numberOfZeros(number.substring(1, number.length()));
    }
}
