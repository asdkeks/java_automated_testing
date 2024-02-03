package ru.stqa.pfa.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumberSolution {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        HashMap<Character, String> buttons = new HashMap<>();
        buttons.put('2', "abc");
        buttons.put('3', "def");
        buttons.put('4', "ghi");
        buttons.put('5', "jkl");
        buttons.put('6', "mno");
        buttons.put('7', "pqrs");
        buttons.put('8', "tuv");
        buttons.put('9', "wxyz");

        backtrack(result, buttons, digits, "", 0);
        return result;
    }

    private static void backtrack(List<String> result, HashMap<Character, String> phoneMap, String digits, String current, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            backtrack(result, phoneMap, digits, current + letters.charAt(i), index + 1);
        }
    }
}
