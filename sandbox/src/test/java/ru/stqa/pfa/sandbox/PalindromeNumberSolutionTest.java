package ru.stqa.pfa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PalindromeNumberSolutionTest {

    @Test
    public void testSolution() {
        int x1 = 1556;
        int x2 = 145541;
        int x3 = 874114780;
        Assert.assertFalse(PalindromeNumberSolution.isPalindrome(x1));
        Assert.assertTrue(PalindromeNumberSolution.isPalindrome(x2));
        Assert.assertFalse(PalindromeNumberSolution.isPalindrome(x3));
    }
}
