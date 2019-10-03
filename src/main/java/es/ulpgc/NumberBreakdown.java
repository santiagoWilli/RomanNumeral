package es.ulpgc;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberBreakdown {

    private final int number;

    public NumberBreakdown(int number) {
        this.number = number;
    }

    public int[][] breakdown() {
         return stream()
                 .map(this::tuple)
                 .filter(this::isNotZero)
                 .collect(Collectors.toList())
                 .toArray(int[][]::new);
    }

    private String number() {
        return String.valueOf(number);
    }

    private Stream<Integer> stream() {
        return IntStream.iterate(0, l -> l + 1)
                .limit(number().length())
                .boxed();
    }

    private int[] tuple(int i) {
        return new int[]{
                Integer.parseInt(number().substring(i, i+1)),
                number().length() - i - 1};
    }

    private boolean isNotZero(int[] tuple) {
        return tuple[0] != 0;
    }
}
