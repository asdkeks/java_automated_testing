package ru.stqa.pfa.sandbox;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequencySolution {
    public static String frequencySort(String s) {
        Map<Character, Integer> start = new HashMap<>();

        for (char c : s.toCharArray()) {
            start.put(c, start.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> mid = start.entrySet().stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                collect(Collectors.toList());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < mid.size(); i++) {
            for (int j = 0; j < mid.get(i).getValue(); j++) {
                res.append(mid.get(i).getKey());
            }
        }

        return res.toString();
    }
}
