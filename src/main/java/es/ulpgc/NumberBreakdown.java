package es.ulpgc;

public class NumberBreakdown {

    public static int[][] breakdownOf(int number) {
        int[][] breakdown = new int[setArrayLength(number)][];
        int nZeros = String.valueOf(number).length() - 1;
        int digit, i = 0;

        while(nZeros > 1) {
            if((digit = getDigit(number, nZeros)) != 0) {
                breakdown[i] = new int[]{digit, nZeros};
                i++;
            }
            number %= Math.pow(10, nZeros);
            nZeros--;
        }
        if(number/10 != 0) breakdown[i++] = new int[]{number/10, 1};
        if(number%10 != 0) breakdown[i] = new int[]{number%10, 0};

        return breakdown;
    }

    private static int getDigit(int number, int nZeros) {
        return (int) (number/Math.pow(10, nZeros));
    }

    private static int setArrayLength(int number) {
        String numberString = String.valueOf(number);
        int length = numberString.length();
        int numberOfZeros = 0;
        for(int i=0; i<length; i++) {if(numberString.charAt(i) == '0') numberOfZeros++;}
        return length - numberOfZeros;
    }
}
