package org.jakubplayground.arraysandstrings;

/**
 * 13. Roman to Integer
 */
public class RomanToInt {
    public int romanToInt(String s) {
        char[] romanDigits = s.toCharArray();
        int total = 0;
        RomanNumber prev = null;

        for (int i = romanDigits.length - 1; i >= 0; i--) {
            RomanNumber romanNumber = RomanNumber.valueOf(String.valueOf(romanDigits[i]));

            if (prev != null && prev.decrementor == romanNumber) {
                total -= romanNumber.value;
            } else {
                total += romanNumber.value;
            }
            prev = romanNumber;
        }


        return total;
    }

    private enum RomanNumber {
        I(1, null),
        V(5, I),
        X(10, I),
        L(50, X),
        C(100, X),
        D(500, C),
        M(1000, C);

        public final int value;
        public final RomanNumber decrementor;

        RomanNumber(int value, RomanNumber decrementor) {
            this.value = value;
            this.decrementor = decrementor;
        }

    }
}
