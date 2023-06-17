package ru.stqa.pfa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RomanToIntegerSolutionTest {
    @Test
    public void testSolution() {
        String romanString1 = "XIV";
        int intExpected1 = 14;
        String romanString2 = "MCDVI";
        int intExpected2 = 1406;
        String romanString3 = "MMDCCCLXVI";
        int intExpected3 = 2866;
        Assert.assertEquals(RomanToIntegerSolution.romanToInt(romanString1), intExpected1);
        Assert.assertEquals(RomanToIntegerSolution.romanToInt(romanString2), intExpected2);
        Assert.assertEquals(RomanToIntegerSolution.romanToInt(romanString3), intExpected3);
    }
}
