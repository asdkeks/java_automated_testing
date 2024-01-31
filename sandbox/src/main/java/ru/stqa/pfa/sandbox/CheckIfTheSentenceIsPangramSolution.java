package ru.stqa.pfa.sandbox;

public class CheckIfTheSentenceIsPangramSolution {
    public static boolean checkIfPangram(String sentence) {
        int k = 0;
        while (sentence.length() > 0){
            sentence = sentence.replace(String.valueOf(sentence.charAt(0)), "");
            k++;
        }
        return k == 26;
    }

}
