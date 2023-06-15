package ru.stqa.pfa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class SolutionTest {

    @Test
    public void testSolution() {
        Random rd = new Random();
        int[] nums = arrayGeneration();
        int randomIndex = rd.nextInt((nums.length - 1));
        int target = nums[randomIndex] + nums[randomIndex + 1];
        int[] expected = {randomIndex,(randomIndex+1)};
        Assert.assertEquals(Solution.twoSum(nums, target), expected);
    }

    public static int[] arrayGeneration() {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }
        return arr;
    }
}


