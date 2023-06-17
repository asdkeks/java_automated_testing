package ru.stqa.pfa.sandbox;

import java.util.Arrays;

public class PalindromeNumberSolution {
    public static boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        char[] xArr = new char[xString.length()];
        char[] xArrReversed = new char[xString.length()];
        for (int i = 0; i < xString.length(); i++) {
            xArr[i] = xString.charAt(i);
            xArrReversed[i] = xString.charAt((xString.length()-1)-i);
        }
        return Arrays.equals(xArr, xArrReversed);
    }
}
