package es.ulpgc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberBreakdown {

    public static int[][] breakdownOf(int number) {
        int[] length = new int[]{String.valueOf(number).length() - 1};

         return Arrays.stream(String.valueOf(number).split(""))
                 .map(d -> new int[]{Integer.parseInt(d), length[0]--})
                 .filter(t -> isNotZero(t[0]))
                 .collect(Collectors.toList())
                 .toArray(new int[setArrayLength(number)][]);
    }

    private static boolean isNotZero(int number) {
        return number != 0;
    }

    private static int setArrayLength(int number) {
        String numberString = String.valueOf(number);
        int length = numberString.length();
        int numberOfZeros = 0;
        for(int i=0; i<length; i++) {if(numberString.charAt(i) == '0') numberOfZeros++;}
        return length - numberOfZeros;
    }
}
