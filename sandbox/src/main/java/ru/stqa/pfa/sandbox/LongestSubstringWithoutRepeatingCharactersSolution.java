package ru.stqa.pfa.sandbox;

import java.util.Stack;

public class LongestSubstringWithoutRepeatingCharactersSolution {
    public static int lengthOfLongestSubstring(String s) {
        Stack<Character> charStack = new Stack<Character>();
        int result = 0;
        int subresult = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!charStack.contains(s.charAt(j))) {
                    charStack.push(s.charAt(j));
                    subresult++;
                } else {
                    subresult = charStack.size();
                    break;
                }
            }
            result = Math.max(subresult, result);
            subresult = 0;
            charStack.clear();
        }
        return result;
    }
}
