package ru.stqa.pfa.sandbox;

import java.util.Arrays;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] answer = {i, j};
                    return answer;
                }
            }
        }
        return null;
    }
}
