package ru.stqa.pfa.sandbox;

public class FirstUniqueCharacterInAStringSolution {
    public int firstUniqChar(String s) {
        String mid = s;

        while (mid.length() != 0 && mid.lastIndexOf(mid.charAt(0)) != mid.indexOf(mid.charAt(0)) ) {
            mid = mid.replace(String.valueOf(mid.charAt(0)), "");
        }
        return mid.length() == 0 ? -1 : s.indexOf(mid.charAt(0));
    }
}
