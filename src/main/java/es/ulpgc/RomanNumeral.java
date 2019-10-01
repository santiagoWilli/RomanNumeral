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

    //public RomanNumeral(String romanNumber) {}

    private String arabicToRomanNumber() {
        if(arabicNumber < MIN || arabicNumber > MAX) throw new IllegalNumberException();
        return romanNumberOfEachTuple();
    }

    private String romanNumberOfEachTuple() {
        return new TupleMapper(getBreakdown()).toRomanValue();
    }

    private int[][] getBreakdown() {
        return new NumberBreakdown(arabicNumber).breakdown();
    }

    public String getValue() {
        return romanNumber;
    }

    public int getArabicNumber() {
        return arabicNumber;
    }

    static class IllegalNumberException extends RuntimeException {
    }
}
