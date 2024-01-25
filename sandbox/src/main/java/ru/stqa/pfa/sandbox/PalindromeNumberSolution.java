package ru.stqa.pfa.sandbox;

import java.util.Arrays;

public class PalindromeNumberSolution {
    public static boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        StringBuilder xStringReversed = new StringBuilder(xString).reverse();
        return xString.contentEquals(xStringReversed);
    }
}
