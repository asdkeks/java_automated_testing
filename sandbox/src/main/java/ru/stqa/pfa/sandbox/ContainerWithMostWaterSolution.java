package ru.stqa.pfa.sandbox;

public class ContainerWithMostWaterSolution {

    public static int maxArea(int[] height) {
        int s = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int mid = Math.min(height[left], height[right]) * (right - left);
            s = Math.max(s, mid);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return s;
    }
}
