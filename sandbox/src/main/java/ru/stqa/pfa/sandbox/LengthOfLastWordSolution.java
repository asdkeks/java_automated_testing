package ru.stqa.pfa.sandbox;

public class LengthOfLastWordSolution {
    public int lengthOfLastWord(String s) {
        String[] newString = s.split(" ");
        return newString[newString.length-1].length();
    }

}
