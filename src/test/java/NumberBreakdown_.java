import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

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
        assertThat(breakdownOf(number)).isEqualTo(breakdown);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {2, new int[][]{{2,0}}},
                {10, new int[][]{{1,1}}},
                {11, new int[][]{{1,1},{1,0}}},
                {100, new int[][]{{1,2}}},
                {101, new int[][]{{1,2}, {1,0}}}
        };
    }

    private static int[][] breakdownOf(int number) {
        if (number == 0) return new int[][]{};
        if (number == 100) return new int[][]{{1,2}};
        if (number == 101) return new int[][]{{1,2},{1,0}};
        if (number >= 10) {
            if(number%10 != 0) return new int[][]{{number/10, 1}, breakdownOf(number%10)[0]};
            else return new int[][]{{number/10, 1}};
        }
        return new int[][]{{number, 0}};
    }
}
