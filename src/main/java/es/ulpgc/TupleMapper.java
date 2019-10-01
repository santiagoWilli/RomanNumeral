package es.ulpgc;

import java.util.Arrays;
import java.util.stream.Collectors;

class TupleMapper {
    private final int[][] tuples;

    final static String[][] MAP = new String[][]{
            {},
            {"I", "X", "C", "M"},
            {"II", "XX", "CC", "MM"},
            {"III", "XXX", "CCC", "MMM"},
            {"IV", "XL", "CD"},
            {"V", "L", "D"},
            {"VI", "LX", "DC"},
            {"VII", "LXX", "DCC"},
            {"VIII", "LXXX", "DCCC"},
            {"IX", "XC", "CM"}
    };

    public TupleMapper(int[][] tuples) {
        this.tuples = tuples;
    }

    public String toRomanValue() {
        return Arrays.stream(tuples)
                .map(t -> MAP[t[0]][t[1]])
                .collect(Collectors.joining());
    }
}
