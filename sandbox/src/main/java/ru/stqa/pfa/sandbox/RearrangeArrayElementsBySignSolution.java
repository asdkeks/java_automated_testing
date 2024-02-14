package ru.stqa.pfa.sandbox;

public class RearrangeArrayElementsBySignSolution {
    public static int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length/2];
        int[] neg = new int[nums.length/2];
        int k = 0, j = 0;

        for (int num : nums) {
            if (num >= 0) {
                pos[k] = num;
                k++;
            }
            else {
                neg[j] = num;
                j++;
            }
        }

        int n = 0, p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = pos[p];
                p++;
            } else {
                nums[i] = neg[n];
                n++;
            }
        }
        return nums;
    }
}
