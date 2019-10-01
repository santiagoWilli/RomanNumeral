package es.ulpgc;

public final class RomanNumeral {
    private final int arabicNumber;
    private final String romanNumber;

    private final int MAX = 3999;
    private final int MIN = 1;

    public RomanNumeral(int arabicNumber) {
        this.arabicNumber = arabicNumber;
        this.romanNumber = arabicToRomanNumber();
    }

    private String arabicToRomanNumber() {
        return null;
    }

    public String getValue() {
        return romanNumber;
    }

    public class IllegalNumberException extends RuntimeException {
    }
}
