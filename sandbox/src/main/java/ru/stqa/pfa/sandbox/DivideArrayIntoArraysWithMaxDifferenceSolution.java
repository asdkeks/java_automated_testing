package ru.stqa.pfa.sandbox;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifferenceSolution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][3];
        Arrays.sort(nums);
        int f = 0;
        int s = 1;

        for (int i = 0; i < nums.length - 2; i = i + 3) {
            result[f][0] = nums[i];
            for (int j = i + 1; j < i + 3; j++) {
                if (nums[j] - result[f][0] <= k) {
                    result[f][s] = nums[j];
                    s++;
                } else return new int[0][0];
            }
            f++;
            s = 1;
        }

        return result;
    }
}
