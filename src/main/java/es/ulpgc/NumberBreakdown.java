package es.ulpgc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberBreakdown {

    private final int number;

    public NumberBreakdown(int number) {
        this.number = number;
    }

    public int[][] breakdown() {
        int[] length = new int[]{String.valueOf(number).length() - 1};

         return Arrays.stream(String.valueOf(number).split(""))
                 .map(d -> tuple(d, length))
                 .filter(this::isNotZero)
                 .collect(Collectors.toList())
                 .toArray(int[][]::new);
    }

    private int[] tuple(String d, int[] length) {
        return new int[]{Integer.parseInt(d), length[0]--};
    }

    private boolean isNotZero(int[] tuple) {
        return tuple[0] != 0;
    }
}
