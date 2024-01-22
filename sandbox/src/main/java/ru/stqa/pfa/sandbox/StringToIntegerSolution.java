package ru.stqa.pfa.sandbox;

import java.util.HashSet;

public class StringToIntegerSolution {

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        char symbol = '+';
        int result;
        StringBuilder str = new StringBuilder();

        if ((s.charAt(0) == '-' || s.charAt(0) == '+')) {
            symbol = s.charAt(0);
            s = s.substring(1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                str.append(s.charAt(i));
            } else break;
        }

        if (str.length() == 0) return 0;

        try {
            result = Integer.parseInt(str.toString());
        } catch (NumberFormatException nfe) {
            if (symbol == '-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        if (symbol == '-') return -result;
        else return result;
    }
}
