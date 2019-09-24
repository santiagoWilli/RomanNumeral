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
        assertThat(breakdownOf(number)).isEqualTo(breakdown);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {

        };
    }

    private static int[][] breakdownOf(int number) {
        return null;
    }

}
