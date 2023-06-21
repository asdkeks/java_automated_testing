package ru.stqa.pfa.sandbox;

import java.util.Stack;


public class ValidParenthesesSolution {
    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        if ((s.length() % 2) == 0 ) {
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case ')':
                        if (charStack.empty() || charStack.peek() != '(') return false;
                        else charStack.pop();
                        break;
                    case ']':
                        if (charStack.empty() || charStack.peek() != '[') return false;
                        else charStack.pop();
                        break;
                    case '}':
                        if (charStack.empty() || charStack.peek() != '{') return false;
                        else charStack.pop();
                        break;
                    default:
                        if (i != s.length()-1) charStack.push(s.charAt(i));
                        else return false;
                        break;

                }
            }
        } else return false;
        return charStack.empty();
    }
}
