package ru.stqa.pfa.sandbox;


import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        Point point1 = new Point(0, 3);
        Point point2 = new Point(4, 0);
        System.out.println(Point.getDistance(point1, point2));

        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString((TwoSumSolution.twoSum(nums, target))));

        System.out.println((RomanToIntegerSolution.romanToInt("MCMXCIV")));

        System.out.println(LongestCommonPrefixSolution.longestCommonPrefix(new String[]{"flower","flowe", "flowers"}));

        System.out.println(ValidParenthesesSolution.isValid("(()){{}}"));
    }

}