package ru.stqa.pfa.sandbox;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsSolution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        List<String> test = Arrays.stream(strs).collect(Collectors.toList());

        while (test.size() > 0) {
            Map<Character, Integer> mid = new HashMap<>();
            List<String> midres = new ArrayList<>();

            for (char c : test.get(0).toCharArray()) {
                mid.put(c, mid.getOrDefault(c, 0) + 1);
            }

            for (int i = 0; i < test.size(); i++) {
                Map<Character, Integer> eq = new HashMap<>();
                for (char c : test.get(i).toCharArray()) {
                    eq.put(c, eq.getOrDefault(c, 0) + 1);
                }
                if (eq.equals(mid)) {
                    midres.add(test.get(i));
                    test.remove(i);
                    i--;
                }
            }
            res.add(midres);
        }

        return res;
    }
}