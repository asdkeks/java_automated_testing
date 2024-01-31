package ru.stqa.pfa.sandbox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class DailyTemperaturesSolution {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> mid = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!mid.empty() &&  temperatures[mid.peek()] < temperatures[i]) {
                res[mid.peek()] = i - mid.pop();
            }
            mid.push(i);
        }
        return res;
    }
}
