package ru.stqa.pfa.sandbox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1 ; i < nums.length; i++) {
                if (nums[i] != nums[i-1]) {
                    nums[j] = nums[i];
                    j++;
                }
        }
        return j;
    }
}
