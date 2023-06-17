package ru.stqa.pfa.sandbox;

import java.util.HashMap;

public class RomanToIntegerSolution {
    public static int romanToInt(String s) {

        HashMap<String, Integer> intsAndRomans = new HashMap<>();
        intsAndRomans.put("I", 1);
        intsAndRomans.put("IV", 4);
        intsAndRomans.put("V", 5);
        intsAndRomans.put("IX", 9);
        intsAndRomans.put("X", 10);
        intsAndRomans.put("XL", 40);
        intsAndRomans.put("L", 50);
        intsAndRomans.put("XC", 90);
        intsAndRomans.put("C", 100);
        intsAndRomans.put("CD", 400);
        intsAndRomans.put("D", 500);
        intsAndRomans.put("CM", 900);
        intsAndRomans.put("M", 1000);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
                if ((i + 1) <= (s.length()-1) && intsAndRomans.containsKey(s.substring(i,i+2))) {
                    answer += intsAndRomans.get(s.substring(i,i+2));
                    i++;
                }
                else {
                    answer += intsAndRomans.get(s.substring(i,i+1));
                }
        }
        return answer;
    }
}
