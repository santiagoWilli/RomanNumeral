package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class TupleMapper_ {
    private final int[][] tuples;
    private final String romanNumber;

    public TupleMapper_(int[][] tuples, String romanNumber) {
        this.tuples = tuples;
        this.romanNumber = romanNumber;
    }

    @Test
    public void execute() {
        assertThat(new TupleMapper(tuples).toRomanValue()).isEqualTo(romanNumber);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][]{
                {new int[][]{{1,0}}, "I"},
                {new int[][]{{2,0}}, "II"},
                {new int[][]{{3,0}}, "III"},
                {new int[][]{{4,0}}, "IV"},
                {new int[][]{{5,0}}, "V"},
                {new int[][]{{6,0}}, "VI"},
                {new int[][]{{7,0}}, "VII"},
                {new int[][]{{8,0}}, "VIII"},
                {new int[][]{{9,0}}, "IX"},
                {new int[][]{{1,1}}, "X"},
                {new int[][]{{2,1}}, "XX"},
                {new int[][]{{3,1}}, "XXX"},
                {new int[][]{{4,1}}, "XL"},
                {new int[][]{{5,1}}, "L"},
                {new int[][]{{6,1}}, "LX"},
                {new int[][]{{7,1}}, "LXX"},
                {new int[][]{{8,1}}, "LXXX"},
                {new int[][]{{9,1}}, "XC"},
                {new int[][]{{1,2}}, "C"},
                {new int[][]{{2,2}}, "CC"},
                {new int[][]{{3,2}}, "CCC"},
                {new int[][]{{4,2}}, "CD"},
                {new int[][]{{5,2}}, "D"},
                {new int[][]{{6,2}}, "DC"},
                {new int[][]{{7,2}}, "DCC"},
                {new int[][]{{8,2}}, "DCCC"},
                {new int[][]{{9,2}}, "CM"},
                {new int[][]{{1,3}}, "M"},
                {new int[][]{{2,3}}, "MM"},
                {new int[][]{{3,3}}, "MMM"},
                {new int[][]{{3,3},{6,2},{2,1},{5,0}}, "MMMDCXXV"}
        };
    }
}
