package ru.stqa.pfa.sandbox;

import java.util.Arrays;

public class MedianOfTwoSortedArraysSolution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] both = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, both, 0, nums1.length);
        System.arraycopy(nums2, 0, both, nums1.length, nums2.length);

        Arrays.sort(both);

        if (both.length % 2 != 0) return both[both.length/2];
        else return (double) (both[both.length / 2] + both[(both.length / 2) - 1]) / 2;
    }
}
