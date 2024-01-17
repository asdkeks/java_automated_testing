package ru.stqa.pfa.sandbox;

public class SearchInsertPositionSolution {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return i;
            else if (i == nums.length-1) return nums.length;
            else if (target < nums[i+1] & target > nums[i]) return i+1;
        }
        return 0;
    }
}
