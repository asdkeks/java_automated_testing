package ru.stqa.pfa.sandbox;

public class ReverseIntegerSolution {

    public int reverse(int x) {
        int result;

        StringBuilder str = new StringBuilder(String.valueOf(x));
        if (str.charAt(0) == '-') {
            str = new StringBuilder(str.substring(1, str.length()));
            str.append('-');
        }
        str.reverse();
        try {
            result = Integer.parseInt(str.toString());
        } catch (NumberFormatException nfe) {
            return 0;
        }
        return result;
    }
}
