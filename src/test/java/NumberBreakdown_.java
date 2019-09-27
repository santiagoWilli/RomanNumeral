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
                {20, new int[][]{{2,1}}},
                {100, new int[][]{{1,2}}},
                {101, new int[][]{{1,2}, {1,0}}},
                {102, new int[][]{{1,2}, {2,0}}},
                {103, new int[][]{{1,2}, {3,0}}},
                {110, new int[][]{{1,2}, {1,1}}}
        };
    }

    private static int[][] breakdownOf(int number) {
        int[][] breakdown = new int[setArrayLength(number)][];
        int i = 0; //array index

        if(number >= 100) {
            breakdown[i++] = new int[]{number/100,2};
            number%=100;
            if(number/10 != 0) breakdown[i++] = new int[]{number/10,1};
            if(number%10 != 0) breakdown[i] = new int[]{number%10,0};
        }
        else if (number >= 10) {
            breakdown[i++] = new int[]{number/10,1};
            if(number%10 != 0) breakdown[i] = new int[]{number%10, 0};
        }
        else if (number > 0) breakdown[i] = new int[]{number, 0};
        return breakdown;
    }

    private static int setArrayLength(int number) {
        String numberString = String.valueOf(number);
        int length = numberString.length();
        int numberOfCeros = 0;
        for(int i=0; i<length; i++) {if(numberString.charAt(i) == '0') numberOfCeros++;}
        return length - numberOfCeros;
    }
}
