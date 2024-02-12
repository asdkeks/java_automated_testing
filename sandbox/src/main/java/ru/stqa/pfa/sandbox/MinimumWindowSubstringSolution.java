package ru.stqa.pfa.sandbox;

import java.util.*;

public class MinimumWindowSubstringSolution {
    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        List<Character> characters =  new ArrayList<>();
        for (int i = 0; i <t.length(); i++) {
            characters.add(t.charAt(i));
        }
//        Set<Character> characters = new HashSet<>();
//        for (int i = 0; i < t.length(); i++) {
//            characters.add(t.charAt(i));
//        }

        String res = helper(s, characters, s.length());
        for (int i = 1; i < s.length(); i++) {
            String mid = helper(s.substring(i), characters, res.length());
            if (mid.length() != 0 && mid.length() < res.length()) {
                res = mid;
            }
        }

        return res;
    }

    private static String helper (String s, List<Character> ch, int length){
//        Set<Character> mid = new HashSet<>();
        List<Character> characters = new ArrayList<>(ch);
        List<Character> mid =  new ArrayList<>();
//        int k = characters.size();

        int right = 0;

        while (right < s.length()) {
            if (characters.contains(s.charAt(right))) {
                mid.add(s.charAt(right));
                characters.remove(characters.lastIndexOf(s.charAt(right)));
                right++;
            } else {
                right++;
            }
            if (characters.size() == 0) {
                return s.substring(0, right);
            }
            if (right > length) return "";
        }
        return "";
    }
}
