package ru.stqa.pfa.sandbox;

import java.util.*;

public class SequentialDigitsSolution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int[] mid = new int[]{12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345,
                23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789,
                123456789};
        int k = 0;

        while (mid[k] < low & mid[k] < high) {
            k++;
            if (k >= mid.length) return res;
        }

        low = mid[k];
        while (low <= high & k <= mid.length - 1) {
            res.add(low);
            k++;
            if (k <= mid.length - 1) low = mid[k];
        }

        return res;
    }
}

