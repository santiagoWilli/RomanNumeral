package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class NumberBreakdown_ {
    private final int number;
    private final int[][] breakdown;

    public NumberBreakdown_(int number, int[][] breakdown) {
        this.number = number;
        this.breakdown = breakdown;
    }

    @Test
    public void execute() {
        assertThat(new NumberBreakdown(number).breakdown()).isEqualTo(breakdown);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {2, new int[][]{{2,0}}},
                {10, new int[][]{{1,1}}},
                {11, new int[][]{{1,1},{1,0}}},
                {20, new int[][]{{2,1}}},
                {100, new int[][]{{1,2}}},
                {101, new int[][]{{1,2}, {1,0}}},
                {102, new int[][]{{1,2}, {2,0}}},
                {103, new int[][]{{1,2}, {3,0}}},
                {110, new int[][]{{1,2}, {1,1}}},
                {1000, new int[][]{{1,3}}},
                {2100, new int[][]{{2,3}, {1,2}}},
                {2132, new int[][]{{2,3}, {1,2}, {3,1}, {2,0}}}
        };
    }

}
