package ru.stqa.pfa.sandbox;

import java.util.HashMap;

public class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mid = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            mid.put(nums[i], mid.getOrDefault(nums[i], 0) + 1);
            if (mid.get(nums[i]) > n/2) return nums[i];
        }

     return nums[0];
    }
}
