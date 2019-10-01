package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class RomanNumeral_ {
    private final int arabicNumber;
    private final String romanNumber;
    private final Class exception;

    public RomanNumeral_(int arabicNumber, String romanNumber, Class exception) {
        this.arabicNumber = arabicNumber;
        this.romanNumber = romanNumber;
        this.exception = exception;
    }

    @Test
    public void execute() {
        try {
            assertThat(new RomanNumeral(arabicNumber).getValue()).isEqualTo(romanNumber);
            assertThat(exception).isEqualTo(null);
        } catch (Exception e){
            assertThat(exception).isNotEqualTo(null);
        }

    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][]{
                {1, "I", null},
                {10, "X", null},
                {23, "XIII", null},
                {301, "CCCI", null},
                {2327, "MMCCCXXVII", null},
                {-2, null, RomanNumeral.IllegalNumberException.class},
                {4000, null, RomanNumeral.IllegalNumberException.class},
        };
    }
}
